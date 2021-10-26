/**
 * 
 */
package com.edu.gui.presenter;

import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.PresentationDirection;
import javax.swing.JPanel;

import com.edu.entity.Aplicativo;
import com.edu.entity.Parada;
import com.edu.entity.Processo;
import com.edu.gui.model.ProcessoTableModel;
import com.edu.gui.presenter.strategy.Strategy;
import com.edu.gui.view.CadastroAplicativoView;
import com.edu.gui.view.ProcessadorView;
import com.edu.processador.Processador;
import com.edu.relatorio.Relatorio;

/**
 * @author Mews
 * 
 */
public class ProcessadorPresenter {

	public final Strategy PROCESSAR_STRATEGY = new ProcessarStrategy();
	public final Strategy RESET_STRATEGY = new ResetStrategy();

	private Strategy operacao = PROCESSAR_STRATEGY;

	private Processador processador;

	private ProcessoTableModel processoTableModel;

	private List<Aplicativo> modelAplicativo;

	private List<Parada> modelParada;

	private List<Processo> model;

	private ProcessadorView view;

	private CadastroAplicativoPresenter aplicativoPresenter;

	private CadastroParadaPresenter paradaPresenter;

	public ProcessadorPresenter() {
		// TODO Auto-generated constructor stub
	}

	public ProcessadorPresenter(List<Processo> model, ProcessadorView view) {
		this.model = model;
		this.view = view;
		modelAplicativo = new ArrayList<Aplicativo>();
		modelParada = new ArrayList<Parada>();

		aplicativoPresenter = new CadastroAplicativoPresenter(modelAplicativo,
				view.getCadastroAplicativoPanel());
		paradaPresenter = new CadastroParadaPresenter(modelParada,
				view.getCadastroParadaPanel());

		aplicativoPresenter.setProcessadorPresenter(this);
		aplicativoPresenter.createView();
		paradaPresenter.createView();

		view.enableBtnReset(false);
	}

	private ProcessoTableModel getProcessoTableModel() {
		if (processoTableModel == null)
			processoTableModel = new ProcessoTableModel(this.model);
		return processoTableModel;
	}

	public void setOperacao(Strategy operacao) {
		this.operacao = operacao;
	}

	public Strategy getOperacao() {
		return operacao;
	}

	private void novo() {
		processador = new Processador();
		view.resetCorCampos();

	}

	// TODO verificar esse codigo
	public JPanel createView() {
		this.setUpViewListeners();
		this.habilitarEdicao(true);
		novo();
		processador.setInicioAtendimento(1);
		view.enableBtnProcessar(false);
		view.enableBtnParar(false);

		updateViewFromModel();

		view.packAndShow();

		return (JPanel) view;
	}

	public void updateModelFromView() {
		processador.setInicioAtendimento(view.getInicioAtendimento());
		processador.setSalvamentoContexto(view.isSalvamentoContexto());
	}

	public void updateViewFromModel() {
		if (processador != null) {
			view.setInicioAtendimento(processador.getInicioAtendimento());
			view.setSalvamentoContexto(view.isSalvamentoContexto());
		} else {
			view.clearFields();
		}
	}

	public void updateModelFromJTable() {
		if (processador != null) {
			this.updateViewFromModel();
			view.enableBtnReset(true);
		} else {
			view.enableBtnReset(false);
		}

		this.updateViewFromModel();
	}

	public void habilitarEdicao(boolean habilitar) {

		view.enableTxtProcessadorInicioAtendimento(habilitar);
		view.enableComboProcessadorSalvamentoContexto(habilitar);
	}

	public void processar() {
		List<Processo> filaProcessada = new ArrayList<Processo>();

		processador = new Processador();
		processador.setInicioAtendimento(this.view.getInicioAtendimento());
		processador.setListaAplicativos(getListaAplicativos());
		processador.setListaParadas(getListaParadas());
		processador.setSalvamentoContexto(view.isSalvamentoContexto());

		filaProcessada = processador.iniciarAtendimento();
		setModel(filaProcessada);

		gerarRelatorio(filaProcessada);

		view.setProcessoTableModel(new ProcessoTableModel(getModel()));
		getView().refreshTable();

		view.enableBtnReset(true);
		view.resetCorCampos();
	}

	public void gerarRelatorio(List<Processo> fila) {
		Relatorio relatorio = new Relatorio();
		view.setAreaConsole(relatorio.gerarRelatorio(fila));
	}

	public List<Aplicativo> getListaAplicativos() {
		// desenvolver l�gica
		return modelAplicativo;
	}

	public List<Parada> getListaParadas() {
		// desenvolver l�gica
		return modelParada;
	}

	public ProcessadorView getView() {
		return view;
	}

	public void setView(ProcessadorView view) {
		this.view = view;
	}

	public List<Processo> getModel() {
		return model;
	}

	public void setModel(List<Processo> model) {
		this.model = model;
	}

	public void resetProcessamento() {

		aplicativoPresenter.reset();
		paradaPresenter.reset();
		reset();
	}

	private void reset() {
		model.clear();
		novo();
		view.refreshTable();
		view.setAreaConsole("");

	}

	// TODO verificar esse codigo
	private void setUpViewListeners() {
		view.setProcessarActionListener(new ProcessadorWindowActionListeners.ProcessarActionListener(
				this));
		view.setResetActionListener(new ProcessadorWindowActionListeners.ResetActionListener(
				this));

		// view.setPararActionListener(new
		// ProcessadorWindowActionListeners.PararActionListener(this));
	}

	public boolean validarInicioProcessamento(){
		if (validarCampos()){
			//verifica se existe alguma parada antes do inicio do processamento
			for (Parada parada : modelParada) {
				if (view.getInicioAtendimento() > parada.getInicioParada()){
					view.showAlert("Nao pode haver paradas antes do inicio do atendimento do processador!");
					return false;
				}
			}
		}
		else
			view.showAlert("Verique se os campos do Processador foram preenchido corretamente");
		
		return true;
	}

	public void clearProcessoTableModel() {
		view.clearTable();
		model.clear();
	}

	public boolean validarCampos(){
		return view.validarCampos();
	}

	private class ResetStrategy implements Strategy {
		public void execute() {
			resetProcessamento();
		}
	}

	public class ProcessarStrategy implements Strategy {
		public void execute() {
			if (validarInicioProcessamento())
				processar();
		}
	}

}
