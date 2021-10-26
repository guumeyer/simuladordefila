/**
 * 
 */
package com.edu.gui.presenter;

import java.util.List;

import javax.swing.JPanel;

import com.edu.entity.Aplicativo;
import com.edu.entity.Modalidade;
import com.edu.gui.model.AplicativoTableModel;
import com.edu.gui.presenter.strategy.Strategy;
import com.edu.gui.view.CadastroAplicativoView;

/**
 * @author gustavo
 * 
 */
public class CadastroAplicativoPresenter {

	// pid
	private int pid;
	public final Strategy INSERT_STRATEGY = new InsertStrategy();

	public final Strategy REMOVE_STRATEGY = new RemoveStrategy();

	private Strategy operacao = INSERT_STRATEGY;

	private Aplicativo aplicativo;

	private AplicativoTableModel aplicativoTableModel;

	private List<Aplicativo> model;

	private CadastroAplicativoView view;

	private ProcessadorPresenter processadorPresenter;

	private int getPid() {
		return ++pid;
	}

	public void reset() {
		model.clear();
		novo();
		view.refreshTable();
	}

	public ProcessadorPresenter getProcessadorPresenter() {
		return processadorPresenter;
	}

	public void setProcessadorPresenter(
			ProcessadorPresenter processadorPresenter) {
		this.processadorPresenter = processadorPresenter;
	}

	public CadastroAplicativoPresenter(List<Aplicativo> model,
			CadastroAplicativoView view) {
		this.model = model;
		this.view = view;
		pid = 0;
	}

	private AplicativoTableModel getAplicativoTableModel() {
		if (aplicativoTableModel == null)
			aplicativoTableModel = new AplicativoTableModel(model);
		return aplicativoTableModel;
	}

	public void setOperacao(Strategy operacao) {
		this.operacao = operacao;
	}

	public Strategy getOperacao() {
		return operacao;
	}

	public JPanel createView() {
		this.setUpViewListeners();
		this.habilitarEdicao(false);
		this.novo();
		view.packAndShow();
		return (JPanel) view;
	}

	public void updateModelFromView() {
		aplicativo.setId(view.getId());
		aplicativo.setNome(view.getNome());
		aplicativo.setChegadaAplicativo(view.getChegada());
		aplicativo.setIntervaloDeChegada(view.getIntervaloDeChegada());
		aplicativo.setQtdProcessos(view.getQtdProcesso());
		aplicativo.setTempoDeProcessamento(view.getTempoDeProcessamento());
		aplicativo.setModalidade(view.getModalidade());
	}

	public void updateViewFromModel() {
		if (aplicativo != null) {
			view.setId(aplicativo.getId());
			view.setNome(aplicativo.getNome());
			view.setChegada(aplicativo.getChegadaAplicativo());
			view.setIntervaloDeChegada(aplicativo.getIntervaloDeChegada());
			view.setQtdProcesso(aplicativo.getQtdProcessos());
			view.setTempoDeProcessamento(aplicativo.getTempoDeProcessamento());
			view.setModalidade(aplicativo.getModalidade());
		} else {
			view.clearFields();
		}
	}

	public void updateModelFromJTable() {
		AplicativoTableModel tbModel = view.getAplicativoTableModel();
		aplicativo = tbModel.getAplicativo(view.linhaSelecionadaTable());
		if (aplicativo != null) {
			this.updateViewFromModel();
			view.enableBtnRemover(true);
		} else {
			view.enableBtnRemover(false);
		}

		this.updateViewFromModel();
	}

	public void habilitarEdicao(boolean habilitar) {
		view.enableTxtAplicativoNome(habilitar);
		view.enableTxtAplicativoChegada(habilitar);
		view.enableTxtAplicativoIntervaloDeChegada(habilitar);
		view.enableTxtAplicativoQtdProcesso(habilitar);
		view.enableTxtAplicativoTempoDeProcesso(habilitar);
		view.enableComboBoxModalidade(false);
	}

	public void adicionar() {
		this.updateModelFromView();
		this.model.add(aplicativo);// metodo clone
		view.setAplicativoTableModel(getAplicativoTableModel());
		novo();
		view.refreshTable();
		controleBotoes();
	}

	public boolean validarCampos() {
		return view.validarCampos();
	}

	private void controleBotoes() {
		boolean visible = (model.size() > 0);
		view.enableBtnRemover(visible);
		view.enableTxtAplicativoChegada(!visible);
		if (getProcessadorPresenter() != null) {
			getProcessadorPresenter().getView().enableBtnProcessar(visible);
			getProcessadorPresenter().getView().enableBtnParar(false);
			getProcessadorPresenter().getView().enableBtnReset(true);
		}

	}

	public void novo() {
		novo(model.size() + 1);
	}

	public int getAplicativoChegada() {
		int retorno = 1;

		if (model.size() > 0) {
			Aplicativo temp = model.get(model.size() - 1);
			int intervaloDeChegada = (temp.getIntervaloDeChegada() > 0) ? temp
					.getIntervaloDeChegada() : 1;
			// chegada + qtd processo * intervalo chegada
			retorno = temp.getChegadaAplicativo() + temp.getQtdProcessos()
					* intervaloDeChegada;
		}

		return retorno;
	}

	public int getAplicativoChegada(Aplicativo apAnterior) {
		return apAnterior.getChegadaAplicativo() + apAnterior.getQtdProcessos()
				* apAnterior.getIntervaloDeChegada();
	}

	public void novo(int id) {
		aplicativo = new Aplicativo();
		view.enableTxtAplicativoId(false);
		aplicativo.setNome("A");
		aplicativo.setId(id);
		aplicativo.setChegadaAplicativo(getAplicativoChegada());
		aplicativo.setIntervaloDeChegada(1);
		aplicativo.setQtdProcessos(1);
		aplicativo.setTempoDeProcessamento(1);
		aplicativo.setModalidade(Modalidade.FIFO);
		updateViewFromModel();
		view.resetCorCampos();
		habilitarEdicao(true);

		if (model.size() == 0)
			view.enableBtnRemover(false);
	}

	public void resetIdOfModel() {
		for (int i = 0; i < model.size(); i++) {
			if (model.get(i).getId() != i + 1)
				model.get(i).setId(i + 1);
		}
	}

	public void resetChegadaOfModel() {
		for (int i = 0; i < model.size(); i++) {
			if (i != 0)
				model.get(i).setChegadaAplicativo(
						getAplicativoChegada(model.get(i - 1)));
		}
	}

	public CadastroAplicativoView getView() {
		return view;
	}

	public void setView(CadastroAplicativoView view) {
		this.view = view;
	}

	public List<Aplicativo> getModel() {
		return model;
	}

	public void setModel(List<Aplicativo> model) {
		this.model = model;
	}

	public void remover() {
		try {
			if (model.size() > 0) {
				aplicativo = model.get(view.linhaSelecionadaTable());
				model.remove(aplicativo);
				resetIdOfModel();
				resetChegadaOfModel();
				view.refreshTable();
				controleBotoes();
				novo();
			}
		} catch (Exception e) {
			view.showAlert("Linha nao selecionada!");
		}
	}

	private void setUpViewListeners() {
		view.setInserirActionListener(new AplicativoWindowActionListeners.InserirActionListener(
				this));
		view.setRemoverActionListener(new AplicativoWindowActionListeners.RemoverActionListener(
				this));
		// view.setTableMouseListener(new
		// AplicativoWindowActionListeners.TableAplicativoMouseListener(
		// this));
	}

	private class InsertStrategy implements Strategy {
		public void execute() {
			if (validarCampos())
				adicionar();
			else
				view.showAlert("Verique se os campos do Aplicativo foram preenchido corretamente");

		}
	}

	private class RemoveStrategy implements Strategy {
		public void execute() {
			remover();
		}

	}

}
