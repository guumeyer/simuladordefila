package com.edu.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import org.dyno.visual.swing.layouts.Bilateral;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import org.dyno.visual.swing.layouts.Trailing;

import com.edu.gui.model.ProcessoTableModel;
import com.edu.gui.util.ValidadorCampos;
import com.edu.gui.view.ProcessadorView;

//VS4E -- DO NOT REMOVE THIS LINE!
public class ProcessadorPanel extends JPanel implements ProcessadorView {

	private static final long serialVersionUID = 1L;
	private JButton btnProcessar;
	private JButton btnParar;
	private JButton btnReset;
	private JTabbedPane jTabbedPane0;
	private JScrollPane jScrollPane0;
	private JTable tabelaProcessos;
	private JLabel lblInicioAtendimento;
	private JLabel lblSalvamentoContexto;
	private JTextField txtInicioAtendimento;
	private JComboBox comboSalvamentoContexto;
	private CadastroAplicativoPanel aplicativoPanel;
	private CadastroParadaPanel paradaPanel;
	private JScrollPane jScrollPane1;
	private JTextArea areaConsole;
	
	public ProcessadorPanel() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getBtnProcessar(), new Constraints(new Leading(12, 12, 12), new Trailing(12, 12, 12)));
		add(getJScrollPane1(), new Constraints(new Bilateral(413, 13, 22), new Trailing(12, 100, 50, 334)));
		add(getJScrollPane0(), new Constraints(new Bilateral(413, 12, 22), new Bilateral(12, 124, 26)));
		add(getBtnReset(), new Constraints(new Leading(116, 10, 10), new Trailing(12, 473, 473)));
		add(getBtnParar(), new Constraints(new Leading(195, 41, 28), new Trailing(12, 473, 473)));
		add(getLblSalvamentoContexto(), new Constraints(new Leading(12, 47, 34), new Trailing(56, 439, 439)));
		add(getComboSalvamentoContexto(), new Constraints(new Leading(174, 118, 41, 28), new Trailing(56, 439, 439)));
		add(getTxtInicioAtendimento(), new Constraints(new Leading(174, 119, 41, 28), new Trailing(92, 307, 407)));
		add(getLlbInicioAtendimento(), new Constraints(new Leading(12, 47, 34), new Trailing(93, 307, 407)));
		add(getJTabbedPane0(), new Constraints(new Leading(12, 383, 10, 10), new Bilateral(12, 127, 283)));
		setSize(878, 530);
	}

	private JTextArea getAreaConsole() {
		if (areaConsole == null) {
			areaConsole = new JTextArea();
			areaConsole.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		}
		return areaConsole;
	}

	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setViewportView(getAreaConsole());
		}
		return jScrollPane1;
	}

	private JComboBox getComboSalvamentoContexto() {
		if (comboSalvamentoContexto == null) {
			comboSalvamentoContexto = new JComboBox();
			comboSalvamentoContexto.setModel(new DefaultComboBoxModel(new Object[] { "Sim", "Nao" }));
			comboSalvamentoContexto.setDoubleBuffered(false);
			comboSalvamentoContexto.setBorder(null);
		}
		return comboSalvamentoContexto;
	}
	
	private JPanel getParadaPanel(){
		if (paradaPanel == null){
			paradaPanel = new CadastroParadaPanel();
		}
		return paradaPanel.getPanel();
	}
	
	private CadastroAplicativoPanel getAplicativoPanel() {
		if (aplicativoPanel == null) {
			aplicativoPanel = new CadastroAplicativoPanel();
			aplicativoPanel.addMouseListener(new MouseAdapter() {
	
			});
		}
		return aplicativoPanel;
	}

	private JTextField getTxtInicioAtendimento() {
		if (txtInicioAtendimento == null) {
			txtInicioAtendimento = new JTextField();
		}
		return txtInicioAtendimento;
	}

	private JLabel getLblSalvamentoContexto() {
		if (lblSalvamentoContexto == null) {
			lblSalvamentoContexto = new JLabel();
			lblSalvamentoContexto.setText("Salvamento de Contexto:");
		}
		return lblSalvamentoContexto;
	}

	@Override
	public void setProcessarActionListener(ActionListener listener) {
		getBtnProcessar().addActionListener(listener);
		
	}
	
	private JLabel getLlbInicioAtendimento() {
		if (lblInicioAtendimento == null) {
			lblInicioAtendimento = new JLabel();
			lblInicioAtendimento.setText("Inicio do Atendimento:");
		}
		return lblInicioAtendimento;
	}

	private JTable getTabelaProcessos() {
		if (tabelaProcessos == null) {
			tabelaProcessos = new JTable();
			
		}
		return tabelaProcessos;
	}

	private JScrollPane getJScrollPane0() {
		if (jScrollPane0 == null) {
			jScrollPane0 = new JScrollPane();
			jScrollPane0.setViewportView(getTabelaProcessos());
		}
		return jScrollPane0;
	}

	private JTabbedPane getJTabbedPane0() {
		if (jTabbedPane0 == null) {
			jTabbedPane0 = new JTabbedPane();
			jTabbedPane0.addTab("Aplicativo", getAplicativoPanel());
			jTabbedPane0.addTab("Parada", getParadaPanel());
		}
		return jTabbedPane0;
	}

	private JButton getBtnReset() {
		if (btnReset == null) {
			btnReset = new JButton();
			btnReset.setText("Reset");
		}
		return btnReset;
	}

	private JButton getBtnParar() {
		if (btnParar == null) {
			btnParar = new JButton();
			btnParar.setText("Parar");
			btnParar.setVisible(false);
		}
		return btnParar;
	}

	private JButton getBtnProcessar() {
		if (btnProcessar == null) {
			btnProcessar = new JButton();
			btnProcessar.setText("Processar");
		}
		return btnProcessar;
	}

	@Override
	public void setInicioAtendimento(Integer inicio) {
		getTxtInicioAtendimento().setText(inicio.toString());
	}

	@Override
	public void setSalvamentoContexto(Boolean salvamentoContexto) {
		if (salvamentoContexto)
			getComboSalvamentoContexto().setSelectedIndex(0);
		else
			getComboSalvamentoContexto().setSelectedIndex(1);
	}

	@Override
	public int getInicioAtendimento() {
		return new Integer(getTxtInicioAtendimento().getText());
	}

	@Override
	public boolean isSalvamentoContexto() {
		if (getComboSalvamentoContexto().getItemAt(getComboSalvamentoContexto().getSelectedIndex()) == "Sim")
			return true;
		else
			return false;
	}

	@Override
	public void clearFields() {
		Component[] componentes = this.getComponents();
		
		for (Component component : componentes) {
			if (component instanceof JTextField){
				JTextField field = (JTextField)component;
				field.setText("");
			}
		}
	}

	@Override
	public void enableTxtProcessadorInicioAtendimento(boolean arg) {
		getTxtInicioAtendimento().setEnabled(arg);
	}

	@Override
	public void enableComboProcessadorSalvamentoContexto(boolean arg) {
		getComboSalvamentoContexto().setEnabled(arg);
	}

	@Override
	public void showAlert(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}

	@Override
	public void enableBtnProcessar(boolean arg) {
		getBtnProcessar().setEnabled(arg);
	}

	@Override
	public void enableBtnParar(boolean arg) {
		getBtnParar().setEnabled(arg);
	}

	@Override
	public void enableBtnReset(boolean arg) {
		getBtnReset().setEnabled(arg);
	}

	@Override
	public void setProcessoTableModel(ProcessoTableModel model) {
		getTabelaProcessos().setModel(model);
	}

	@Override
	public ProcessoTableModel getProcessoTableModel() {
		return (ProcessoTableModel)getTabelaProcessos().getModel();
	}

	@Override
	public void refreshTable() {
		getTabelaProcessos().updateUI();
	}

	@Override
	public int linhaSelecionadaTable() {
		return getTabelaProcessos().getSelectedRow();
	}

	@Override
	public void setInserirActionListener(ActionListener listener) {
		
	}

	@Override
	public void setRemoverActionListener(ActionListener listener) {
		
	}

	@Override
	public void setResetActionListener(ActionListener listener) {
		getBtnReset().addActionListener(listener);
	}

	@Override
	public void packAndShow() {
		
	}

	@Override
	public CadastroParadaPanel getCadastroParadaPanel() {
		return this.paradaPanel;
	}

	@Override
	public CadastroAplicativoPanel getCadastroAplicativoPanel() {
		return this.aplicativoPanel;
	}

	@Override
	public void clearTable() {
			getTabelaProcessos().removeRowSelectionInterval(0, getTabelaProcessos().getRowCount()-1);
	}

	@Override
	public void setAreaConsole(String texto) {
		getAreaConsole().setText(texto);
	}

	@Override
	public String getStringAreaConsole() {
		return getAreaConsole().getText();
	}

	private boolean validarTxtInicioAtendimento(){
		return ValidadorCampos.validarCampoInteger(getTxtInicioAtendimento());
	}
	
	@Override
	public boolean validarCampos() {
		boolean isCamposValidos = true;
		
		isCamposValidos = (validarTxtInicioAtendimento() && isCamposValidos) ? true : false;
		
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
