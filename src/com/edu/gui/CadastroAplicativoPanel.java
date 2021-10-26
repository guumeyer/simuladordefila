/**
 * 
 */
package com.edu.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.dyno.visual.swing.layouts.Bilateral;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;

import com.edu.entity.Modalidade;
import com.edu.gui.componentes.NumberField;
import com.edu.gui.model.AplicativoTableModel;
import com.edu.gui.util.ValidadorCampos;
import com.edu.gui.view.CadastroAplicativoView;

//VS4E -- DO NOT REMOVE THIS LINE!
public class CadastroAplicativoPanel extends JPanel implements
		CadastroAplicativoView {

	private static final long serialVersionUID = 1L;
	// Controle do layout
	private int posicaoY;
	private int incY;

	private JLabel lblAplicativoNome;
	private JLabel lblAplicativoId;
	private JLabel lblIntervaloChegada;
	private JLabel lblQuantidadeProcesso;
	private JLabel lblTempoProcesso;
	private JTextField txtAplicativoId;
	private JTextField txtAplicativoNome;
	private JTextField txtIntervaloChegada;
	private JTextField txtTempoProcesso;
	private JTextField txtChegada;
	private JTextField txtQtdProcesso;
	private JLabel lblChegadaProcesso;
	private JButton btnAdicionar;
	private JButton btnRemover;
	private JTable tabelaAplicativo;
	private JScrollPane jScrollPane0;
	private JLabel lblModalidade;
	private JComboBox comboModalidade;
	private JComboBox jComboBox0;
	

	@Override
	public String getNome() {
		return getTxtAplicativoNome().getText();
	}
	
	public void setNome(String nome){
		getTxtAplicativoNome().setText(nome);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.edu.gui.CadastroAplitxtChegadatId()
	 */
	@Override
	public int getId() {
		return new Integer(getTxtAplicativoId().getText());
	}
	
	@Override
	public void showAlert(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.edu.gui.CadastroAplitivoView#setId(int)
	 */
	@Override
	public void setId(Integer id) {
		getTxtAplicativoId().setText(id.toString());

	}

	@Override
	public int getQtdProcesso() {
		return new Integer(getTxtQuantidadeProcesso().getText());
	}
	
	@Override
	public void setQtdProcesso(Integer qtd) {
		getTxtQuantidadeProcesso().setText(qtd.toString());
		
	}

	@Override
	public int getChegada() {
		return new Integer(getTxtChegada().getText());
	}

	@Override
	public void setChegada(Integer id) {
		getTxtChegada().setText(id.toString());

	}
	@Override
	public void enableComboBoxModalidade(boolean arg) {
		getComboBoxModalidade().setEditable(arg);
		getComboBoxModalidade().setEnabled(arg);
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.edu.gui.CadastroAplitivoView#getIntervaloDeChegada()
	 */
	@Override
	public int getIntervaloDeChegada() {
		return new Integer(getTxtIntervaloChegada().getText());
	}
	
	@Override
	public void enableBtnAdicionar(boolean enable) {
		this.getBtnAdicionar().setEnabled(enable);
	}
	
	@Override
	public void enableBtnRemover(boolean enable) {
		this.getBtnRemover().setEnabled(enable);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.edu.gui.CadastroAplitivoView#setIntervaloDeChegada(int)
	 */
	@Override
	public void setIntervaloDeChegada(Integer intervaloDeChegada) {
		getTxtIntervaloChegada().setText(intervaloDeChegada.toString());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.edu.gui.CadastroAplitivoView#getTempoDeProcessamento()
	 */
	@Override
	public int getTempoDeProcessamento() {
		return new Integer(getTxtTempoProcesso().getText());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.edu.gui.CadastroAplitivoView#setTempoDeProcessamento(int)
	 */
	@Override
	public void setTempoDeProcessamento(Integer tempoDeProcessamento) {
		getTxtTempoProcesso().setText(tempoDeProcessamento.toString());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.edu.gui.CadastroAplitivoView#clearFields()
	 */
	@Override
	public void clearFields() {
		Component[] componentes = this.getComponents();

		for (Component component : componentes) {
			if (component instanceof JTextField) {
				JTextField field = (JTextField) component;
				field.setText("");

			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.edu.gui.CadastroAplitivoView#enableTxtAplicativoId(boolean)
	 */
	@Override
	public void enableTxtAplicativoId(boolean enable) {
		getTxtAplicativoId().setEditable(enable);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.edu.gui.CadastroAplitivoView#enableTxtAplicativoNome(boolean)
	 */
	@Override
	public void enableTxtAplicativoNome(boolean enable) {
		getTxtAplicativoNome().setEditable(enable);

	}
	
	@Override
	public void enableTxtAplicativoChegada(boolean arg) {
		getTxtChegada().setEditable(arg);
	}
	
	@Override
	public void enableTxtAplicativoIntervaloDeChegada(boolean arg) {
		getTxtIntervaloChegada().setEditable(arg);
	}
	
	@Override
	public void enableTxtAplicativoQtdProcesso(boolean arg) {
		getTxtQuantidadeProcesso().setEditable(arg);
	}

	@Override
	public void enableTxtAplicativoTempoDeProcesso(boolean arg) {
		getTxtTempoProcesso().setEditable(arg);
	}
	
	@Override
	public void setTableMouseListener(MouseListener listener) {
		tabelaAplicativo.addMouseListener(listener);
	}
	

	@Override
	public void setInserirActionListener(ActionListener listener) {
		btnAdicionar.addActionListener(listener);

	}

	@Override
	public void setRemoverActionListener(ActionListener listener) {
		btnRemover.addActionListener(listener);
	}

	

	public CadastroAplicativoPanel() {
		posicaoY = 16;// Posição do primeiro campo
		incY = 23; // Espaçamento entre os campos
		initComponents();
	}

	private int getPosicaoY(int index) {
		return posicaoY + (index * incY);
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getLblAplicativoId(), new Constraints(new Leading(18, 10, 10), new Leading(12, 12, 12)));
		add(getLblIntervaloChegada(), new Constraints(new Leading(16, 10, 10), new Leading(57, 10, 10)));
		add(getLblAplicativoNome(), new Constraints(new Leading(18, 10, 10), new Leading(33, 10, 10)));
		add(getTxtAplicativoId(), new Constraints(new Leading(204, 62, 10, 10), new Leading(7, 10, 10)));
		add(getTxtAplicativoNome(), new Constraints(new Leading(204, 62, 12, 12), new Leading(29, 12, 12)));
		add(getTxtIntervaloChegada(), new Constraints(new Leading(204, 62, 12, 12), new Leading(52, 12, 12)));
		add(getTxtQuantidadeProcesso(), new Constraints(new Leading(204, 62, 12, 12), new Leading(76, 12, 12)));
		add(getTxtTempoProcesso(), new Constraints(new Leading(204, 62, 12, 12), new Leading(99, 12, 12)));
		add(getTxtChegada(), new Constraints(new Leading(204, 62, 12, 12), new Leading(125, 12, 12)));
		add(getLblTempoProcesso(), new Constraints(new Leading(18, 12, 12), new Leading(103, 12, 12)));
		add(getLblChegadaProcesso(), new Constraints(new Leading(18, 12, 12), new Leading(129, 12, 12)));
		add(getLblQuantidadeProcesso(), new Constraints(new Leading(18, 12, 12), new Leading(81, 12, 12)));
		add(getLblModalidade(), new Constraints(new Leading(20, 10, 10), new Leading(151, 10, 10)));
		add(getComboBoxModalidade(), new Constraints(new Leading(204, 70, 10, 10), new Leading(149, 50, 136)));
		add(getBtnRemover(), new Constraints(new Leading(170, 12, 12), new Leading(179, 44, 421)));
		add(getBtnAdicionar(), new Constraints(new Leading(16, 12, 12), new Leading(179, 44, 421)));
		add(getJScrollPane0(), new Constraints(new Bilateral(12, 12, 22), new Bilateral(217, 12, 26)));
		setSize(325, 338);
	}

	@Override
	public void setModalidade(Modalidade modalidade) {
		// TODO Auto-generated method stub
		int value = 0;
		
		if (modalidade.equals(Modalidade.BJF)) {
			value = 2;
		}else if(modalidade.equals(Modalidade.SJF)){
			value = 1;
		}
		getComboBoxModalidade().setSelectedIndex(value);
	}
	
	@Override
	public Modalidade getModalidade() {
		Modalidade modalidade = Modalidade.FIFO;
		
		switch (getComboBoxModalidade().getSelectedIndex()) {
		case 1:
			modalidade = Modalidade.SJF;
			break;
		
		case 2:
			modalidade = Modalidade.BJF;
	
		} 
		return modalidade;
	}

	private JComboBox getComboBoxModalidade() {
		if (comboModalidade == null) {
			comboModalidade = new JComboBox();
			comboModalidade.setModel(new DefaultComboBoxModel(new Object[] { "FIFO", "SJF", "BJF" }));
			comboModalidade.setDoubleBuffered(false);
			comboModalidade.setBorder(null);
			
		}
		return comboModalidade;
	}

	private JLabel getLblModalidade() {
		if (lblModalidade == null) {
			lblModalidade = new JLabel();
			lblModalidade.setText("Modalidade:");
		}
		return lblModalidade;
	}

	private JScrollPane getJScrollPane0() {
		if (jScrollPane0 == null) {
			jScrollPane0 = new JScrollPane();
			jScrollPane0.setViewportView(getTabelaAplicativo());
		}
		return jScrollPane0;
	}

	@Override
	public void refreshTable() {
		getTabelaAplicativo().updateUI();
	}
	
	@Override
	public void setAplicativoTableModel(AplicativoTableModel model) {
		getTabelaAplicativo().setModel(model);
		
	}
	
	@Override
	public void setLinhaSelecionadaTable(int index) {
		getTabelaAplicativo().addRowSelectionInterval(index, index);
		
	}
	@Override
	public int linhaSelecionadaTable() {
		return getTabelaAplicativo().getSelectedRow();
	}
	
	@Override
	public AplicativoTableModel getAplicativoTableModel() {
		return (AplicativoTableModel) getTabelaAplicativo().getModel();
	}
	
	private JTable getTabelaAplicativo() {
		if (tabelaAplicativo == null) {
			tabelaAplicativo = new JTable();
		}
		return tabelaAplicativo;
	}

	private JButton getBtnRemover() {
		if (btnRemover == null) {
			btnRemover = new JButton();
			btnRemover.setText("Remover Aplicativo");
		}
		return btnRemover;
	}

	private JButton getBtnAdicionar() {
		if (btnAdicionar == null) {
			btnAdicionar = new JButton();
			btnAdicionar.setText("Adicionar Aplicativo");
		}
		return btnAdicionar;
	}

	private JLabel getLblChegadaProcesso() {
		if (lblChegadaProcesso == null) {
			lblChegadaProcesso = new JLabel();
			lblChegadaProcesso.setText("Chegada:");
		}
		return lblChegadaProcesso;
	}

	private JTextField getTxtQuantidadeProcesso() {
		if (txtQtdProcesso == null) {
			txtQtdProcesso = new NumberField();
			txtQtdProcesso.setEditable(false);
		}
		return txtQtdProcesso;
	}

	private JTextField getTxtChegada() {
		if (txtChegada == null) {
			txtChegada = new NumberField();
			txtChegada.setEditable(false);
		}
		return txtChegada;
	}

	private JTextField getTxtTempoProcesso() {
		if (txtTempoProcesso == null) {
			txtTempoProcesso = new NumberField();
			txtTempoProcesso.setEditable(false);
		}
		return txtTempoProcesso;
	}

	private JTextField getTxtIntervaloChegada() {
		if (txtIntervaloChegada == null) {
			txtIntervaloChegada = new NumberField();
			txtIntervaloChegada.setEditable(false);
		}
		return txtIntervaloChegada;
	}

	private JTextField getTxtAplicativoNome() {
		if (txtAplicativoNome == null) {
			txtAplicativoNome = new JTextField();
			txtAplicativoNome.setEditable(false);
		}
		return txtAplicativoNome;
	}

	private JTextField getTxtAplicativoId() {
		if (txtAplicativoId == null) {
			txtAplicativoId = new JTextField();
			txtAplicativoId.setEditable(false);
		}
		return txtAplicativoId;
	}

	private JLabel getLblTempoProcesso() {
		if (lblTempoProcesso == null) {
			lblTempoProcesso = new JLabel();
			lblTempoProcesso.setText("Tempo de processo:");
		}
		return lblTempoProcesso;
	}

	private JLabel getLblQuantidadeProcesso() {
		if (lblQuantidadeProcesso == null) {
			lblQuantidadeProcesso = new JLabel();
			lblQuantidadeProcesso.setText("Quantidade de processo:");
		}
		return lblQuantidadeProcesso;
	}

	@Override
	public void packAndShow() {
		setVisible(true);

	}

	private JLabel getLblIntervaloChegada() {
		if (lblIntervaloChegada == null) {
			lblIntervaloChegada = new JLabel();
			lblIntervaloChegada.setText(" Intervalo de Chegada:");
		}
		return lblIntervaloChegada;
	}

	private JLabel getLblAplicativoId() {
		if (lblAplicativoId == null) {
			lblAplicativoId = new JLabel();
			lblAplicativoId.setHorizontalAlignment(SwingConstants.RIGHT);
			lblAplicativoId.setText("id:");
		}
		return lblAplicativoId;
	}

	private JLabel getLblAplicativoNome() {
		if (lblAplicativoNome == null) {
			lblAplicativoNome = new JLabel();
			lblAplicativoNome.setText("Nome:");
		}
		return lblAplicativoNome;
	}

	@Override
	public JPanel getPanel() {
		return this;
	}

	@Override
	public void clearTable() {
		getTabelaAplicativo().removeRowSelectionInterval(0, getTabelaAplicativo().getRowCount()-1);
	}
	
	private boolean validarTxtAplicativoNome(){
		return ValidadorCampos.validarCampoString(getTxtAplicativoNome());
	}
	
	private boolean validarTxtIntervaloChegada(){
		return ValidadorCampos.validarCampoIntervaloChegada(getTxtIntervaloChegada());
	}
	
	private boolean validarTxtQuantidadeProcessos(){
		return ValidadorCampos.validarCampoInteger(getTxtQuantidadeProcesso());
	}
	
	private boolean validarTxtTempoProcessos(){
		return ValidadorCampos.validarCampoInteger(getTxtTempoProcesso());
	}
	
	private boolean validarTxtChegada(){
		return ValidadorCampos.validarCampoInteger(getTxtChegada());
	}
	
	@Override
	public boolean validarCampos() {
		boolean isCamposValidos = true;
		
		isCamposValidos = (validarTxtAplicativoNome() && isCamposValidos) ? true : false;
		isCamposValidos = (validarTxtChegada() && isCamposValidos) ? true : false;
		isCamposValidos = (validarTxtIntervaloChegada() && isCamposValidos) ? true : false;
		isCamposValidos = (validarTxtQuantidadeProcessos() && isCamposValidos) ? true : false;
		isCamposValidos = (validarTxtTempoProcessos() && isCamposValidos) ? true : false;
		
		return isCamposValidos;
	}
	
	@Override
	public void resetCorCampos(){
		Component[] componentes = this.getComponents();
		
		for (Component component : componentes) {
			if (component instanceof JTextField){
				ValidadorCampos.setColorField((JTextField)component, Color.WHITE);
			}
		}
	}
}
