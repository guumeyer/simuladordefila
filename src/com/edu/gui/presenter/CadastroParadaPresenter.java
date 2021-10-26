/**
 * 
 */
package com.edu.gui.presenter;

import java.util.List;

import javax.swing.JPanel;

import com.edu.entity.Parada;
import com.edu.gui.model.AplicativoTableModel;
import com.edu.gui.model.ParadaTableModel;
import com.edu.gui.view.CadastroParadaView;
import com.edu.gui.presenter.strategy.Strategy;

/**
 * @author Mews
 *
 */
public class CadastroParadaPresenter {

	public final Strategy REMOVE_STRATEGY = new RemoveStrategy();
	public final Strategy INSERT_STRATEGY = new InsertStrategy();

	private Strategy operacao = INSERT_STRATEGY;

	private Parada parada;

	private List<Parada> model;

	private CadastroParadaView view;

	private ParadaTableModel paradaTableModel;


	public void reset(){
		model.clear();
		novo();
		view.refreshTable();			
	}

	public CadastroParadaPresenter(List<Parada> model, CadastroParadaView view) {
		this.model = model;
		this.view = view;
	}

	public void setOperacao(Strategy operacao) {
		this.operacao = operacao;
	}

	public Strategy getOperacao() {
		return operacao;
	}

	public JPanel createView() {

		this.novo();
		this.setUpViewListeners();

		view.packAndShow();
		updateViewFromModel();
		view.enableBtnRemover(false);
		return (JPanel) view;
	}

	public void updateModelFromView() {
		parada.setId(view.getId());
		parada.setInicioParada(view.getInicioParada());
		parada.setTempoParada(view.getTempoParada());
	}

	public void updateViewFromModel() {
		if (parada != null) {
			view.setId(parada.getId());
			view.setInicioParada(parada.getInicioParada());
			view.setTempoParada(parada.getTempoParada());
		} else {
			view.clearFields();
		}
	}

	public void updateModelFromJTable() {
		ParadaTableModel tbModel = view.getParadaTableModel();  

		parada = tbModel.getParada(view.linhaSelecionadaTable());  

		if (parada != null) {  
			this.updateViewFromModel();  

			view.enableBtnRemover(true);  
		}  
		else {  
			view.enableBtnRemover(false);  
		}  

		this.updateViewFromModel();
	}

	public void adicionar() {
		this.updateModelFromView();
		if (isNovaParadaValida(parada)){
			this.model.add(parada);
			view.setParadaTableModel(getParadaTableModel());
			novo();
			view.refreshTable();	
		}
		else
			view.showAlert("Nao pode haver Paradas no mesmo intervalo. Confira os valores digitados");
	}

	public void resetIdOfModel(){
		for (int i = 0; i < model.size(); i++) {
			if (model.get(i).getId() != i+1)
				model.get(i).setId(i+1);
		}
	}

	private ParadaTableModel getParadaTableModel() {
		if (paradaTableModel == null)
			paradaTableModel = new ParadaTableModel(model);
		return paradaTableModel;
	}

	public void novo() {
		parada = new Parada();
		parada.setId(model.size()+1);
		parada.setInicioParada(1);
		parada.setTempoParada(1);
		updateViewFromModel();
		view.resetCorCampos();
		view.enableTxtIdParada(false);
	}

	public void novo(int id) {
		parada = new Parada();
		view.enableTxtIdParada(false);
		parada.setId(id);
		parada.setInicioParada(0);
		parada.setTempoParada(0);
		updateViewFromModel();
	}

	public CadastroParadaView getView(){
		return view;
	}

	public void setView(CadastroParadaView view){
		this.view = view;
	}

	public List<Parada> getModel(){
		return model;
	}

	public void setModel(List<Parada> model){
		this.model = model;
	}


	public void remover(){
		try{
			if (model.size() > 0) {
				parada = model.get(view.linhaSelecionadaTable());
				model.remove(parada);
				resetIdOfModel();
				view.refreshTable();
				controleBotoes();
				novo();
			}
		}
		catch (Exception e) {
			view.showAlert("Linha nao selecionada!");
		}
	}

	public boolean isNovaParadaValida(Parada novaParada){
		for (Parada parada : model) {
			if (parada.getInicioParada() <= novaParada.getInicioParada() && novaParada.getInicioParada() < (parada.getInicioParada()
					+ parada.getTempoParada()))
				return false;
			if (novaParada.getInicioParada() < parada.getInicioParada() && (novaParada.getInicioParada() 
					+ novaParada.getTempoParada() - 1) >= parada.getInicioParada())
				return false;
		}
		return true;
	}

	private void controleBotoes() {
		boolean visible = (model.size() > 0);
		view.enableBtnRemover(visible);
	}

	private void setUpViewListeners() {
		view.setInserirActionListener(new ParadaWindowActionListeners.InserirActionListener(this));
		view.setRemoverActionListener(new ParadaWindowActionListeners.RemoverActionListener(this));
	}

	public boolean validarCampos(){
		return view.validarCampos();
	}

	private class InsertStrategy implements Strategy {
		public void execute() {
			if (validarCampos())
				adicionar();
			else
				view.showAlert("Verique se os campos da Parada foram preenchido corretamente");
		}
	}

	private class RemoveStrategy implements Strategy {
		public void execute() {
			remover();
		}
	}

}
