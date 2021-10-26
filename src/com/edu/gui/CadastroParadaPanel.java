package com.edu.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.dyno.visual.swing.layouts.Bilateral;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import org.dyno.visual.swing.layouts.Trailing;

import com.edu.gui.model.ParadaTableModel;
import com.edu.gui.util.ValidadorCampos;
import com.edu.gui.view.CadastroParadaView;

//VS4E -- DO NOT REMOVE THIS LINE!
public class CadastroParadaPanel extends JPanel implements CadastroParadaView {

	private static final long serialVersionUID = 1L;
	private JLabel lblIdParada;
	private JLabel lblInicioParada;
	private JLabel lblTempoParada;
	private JTextField txtIdParada;
	private JTextField txtInicioParada;
	private JTextField txtTempoParada;
	private JButton btnRemoverParada;
	private JButton btnInserirParada;
	private JTable TabelaParadas;
	private JScrollPane jScrollPane0;

	public CadastroParadaPanel() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getLblIdParada(), new Constraints(new Leading(12, 12, 12), new Leading(12, 12, 12)));
		add(getLblInicioParada(), new Constraints(new Leading(12, 12, 12), new Leading(40, 12, 12)));
		add(getLblTempoParada(), new Constraints(new Leading(12, 12, 12), new Leading(68, 12, 12)));
		add(getTxtIdParada(), new Constraints(new Leading(147, 137, 10, 10), new Leading(12, 12, 12)));
		add(getTxtInicioParada(), new Constraints(new Leading(147, 136, 12, 12), new Leading(38, 12, 12)));
		add(getTxtTempoParada(), new Constraints(new Leading(147, 136, 12, 12), new Leading(64, 12, 12)));
		add(getBtnRemoverParada(), new Constraints(new Trailing(12, 162, 162), new Leading(96, 12, 12)));
		add(getBtnInserirParada(), new Constraints(new Trailing(153, 12, 12), new Leading(96, 12, 12)));
		add(getJScrollPane0(), new Constraints(new Bilateral(12, 12, 22), new Bilateral(134, 12, 22)));
		setSize(320, 240);
	}

	private JScrollPane getJScrollPane0() {
		if (jScrollPane0 == null) {
			jScrollPane0 = new JScrollPane();
			jScrollPane0.setViewportView(getTabelaParadas());
		}
		return jScrollPane0;
	}

	private JTable getTabelaParadas() {
		if (TabelaParadas == null) {
			TabelaParadas = new JTable();
			
		}
		return TabelaParadas;
	}

	private JButton getBtnInserirParada() {
		if (btnInserirParada == null) {
			btnInserirParada = new JButton();
			btnInserirParada.setText("Inserir Parada");
		}
		return btnInserirParada;
	}

	private JButton getBtnRemoverParada() {
		if (btnRemoverParada == null) {
			btnRemoverParada = new JButton();
			btnRemoverParada.setText("Remover Parada");
		}
		return btnRemoverParada;
	}

	private JTextField getTxtTempoParada() {
		if (txtTempoParada == null) {
			txtTempoParada = new JTextField();
		}
		return txtTempoParada;
	}

	private JTextField getTxtInicioParada() {
		if (txtInicioParada == null) {
			txtInicioParada = new JTextField();
		}
		return txtInicioParada;
	}

	private JTextField getTxtIdParada() {
		if (txtIdParada == null) {
			txtIdParada = new JTextField();
		}
		return txtIdParada;
	}

	private JLabel getLblTempoParada() {
		if (lblTempoParada == null) {
			lblTempoParada = new JLabel();
			lblTempoParada.setText("Tempo da Parada:");
		}
		return lblTempoParada;
	}

	private JLabel getLblInicioParada() {
		if (lblInicioParada == null) {
			lblInicioParada = new JLabel();
			lblInicioParada.setText("Inicio da Parada:");
		}
		return lblInicioParada;
	}

	private JLabel getLblIdParada() {
		if (lblIdParada == null) {
			lblIdParada = new JLabel();
			lblIdParada.setText("Id:");
		}
		return lblIdParada;
	}

	@Override
	public int getId() {
		return new Integer(getTxtIdParada().getText());
	}

	@Override
	public void setId(Integer id) {
		getTxtIdParada().setText(id.toString());
	}

	@Override
	public int getInicioParada() {
		return new Integer(getTxtInicioParada().getText());
	}

	@Override
	public void setInicioParada(Integer inicioParada) {
		getTxtInicioParada().setText(inicioParada.toString());
	}

	@Override
	public int getTempoParada() {
		return new Integer(getTxtTempoParada().getText());
	}

	@Override
	public void setTempoParada(Integer tempoParada) {
		getTxtTempoParada().setText(tempoParada.toString());
	}

	@Override
	public void clearFields() {
		Component[] componentes = this.getComponents();
		
		for (Component component : componentes) {
			if (component instanceof JTextField){
				JTextField field = (JTextField) component;
				field.setText("");
			}
		}
	}

	@Override
	public void setInserirActionListener(ActionListener listener) {
		btnInserirParada.addActionListener(listener);
		
	}

	@Override
	public void setRemoverActionListener(ActionListener listener) {
		btnRemoverParada.addActionListener(listener);
	}

	@Override
	public void packAndShow() {
		setVisible(true);
		
	}

	@Override
	public void setParadaTableModel(ParadaTableModel model) {
		getTabelaParadas().setModel(model);
	}

	@Override
	public ParadaTableModel getParadaTableModel() {
		return (ParadaTableModel) getTabelaParadas().getModel();
	}

	@Override
	public void refreshTable() {
		getTabelaParadas().updateUI();
	}

	@Override
	public int linhaSelecionadaTable() {
		return getTabelaParadas().getSelectedRow();
	}

	@Override
	public void enableBtnInserir(boolean arg) {
		getBtnInserirParada().setEnabled(arg);
	}

	@Override
	public void enableBtnRemover(boolean arg) {
		getBtnRemoverParada().setEnabled(arg);
	}

	@Override
	public JPanel getPanel() {
		return this;
	}

	@Override
	public void clearTable() {
		getTabelaParadas().removeRowSelectionInterval(0, getTabelaParadas().getRowCount()-1);
	}

	@Override
	public void enableTxtIdParada(boolean arg) {
		getTxtIdParada().setEnabled(arg);
	}

	@Override
	public void enableTxtInicioParada(boolean arg) {
		getTxtInicioParada().setEnabled(arg);
	}

	@Override
	public void enableTxtTempoParada(boolean arg) {
		getTxtTempoParada().setEnabled(arg);
	}
	
	private boolean validarTxtIncioParada(){
		return ValidadorCampos.validarCampoInteger(getTxtInicioParada());
	}
	
	private boolean validarTxtTempoParada(){
		return ValidadorCampos.validarCampoInteger(getTxtTempoParada());
	}
	
	@Override
	public boolean validarCampos() {
		boolean isCamposValidos = true;
		
		isCamposValidos = (validarTxtIncioParada() && isCamposValidos) ? true : false;
		isCamposValidos = (validarTxtTempoParada() && isCamposValidos) ? true : false;
		
		return isCamposValidos;
	}

	@Override
	public void showAlert(String msg) {
		JOptionPane.showMessageDialog(null, msg);
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
	