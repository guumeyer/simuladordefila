package com.edu.gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.dyno.visual.swing.layouts.Bilateral;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import org.dyno.visual.swing.layouts.Trailing;

import com.edu.entity.Aplicativo;
import com.edu.entity.Parada;
import com.edu.gui.presenter.CadastroAplicativoPresenter;
import com.edu.gui.presenter.CadastroParadaPresenter;

//VS4E -- DO NOT REMOVE THIS LINE!
public class TelaSimulador extends JFrame {

	private List<Aplicativo> listaAplicativos = new ArrayList<Aplicativo>();
	private List<Parada> listaParada = new ArrayList<Parada>();
	
	private static final long serialVersionUID = 1L;
	private JTabbedPane jTabbedPane0;
	private JPanel jPanel0;
	private JTable tabelaProcessos;
	private JScrollPane jScrollPane0;
	private JPanel jPanel1;
	private JPanel jPanel2;
	private JPanel jPanel3;
	private JButton btnProcessar;
	private JButton btnParar;
	private JButton btnGrafico;
	private JPanel jPanel4;
	private JLabel labelInicioAtendimento;
	private JLabel labelSalvamentoContexto;
	private JLabel labelNomeAplicativo;
	private JLabel labelIntervalChegada;
	private JLabel labelModalidade;
	private JLabel labelNumProcessos;
	private JTextField textNomeAplicativo;
	private JComboBox comboModalidade;
	private JLabel labelProcessamento;
	private JLabel labelChegada;
	private JTextField textNumProcessos;
	private JTextField textIntervalChegada;
	private JTextField textChegada;
	private JTextField textProcessamento;
	private JTextField textInicioAtendimento;
	private JPanel jPanel6;
	private JComboBox ComboSalvamentoContexto;
	private CadastroAplicativoPanel aplicativoPanel;
	private CadastroAplicativoPresenter aplicativoPresenter;
	private CadastroParadaPanel paradaPanel;
	private CadastroParadaPresenter paradaPresenter;

	private JPanel jPanel5;
	private static final String PREFERRED_LOOK_AND_FEEL = "javax.swing.plaf.metal.MetalLookAndFeel";

	public TelaSimulador() {
		//listaAplicativos = new ArrayList<Aplicativo>();
		initComponents();
	}

	private void initComponents() {
		setTitle("Simulador de Processamento de Fila de Processos");
		setLayout(new GroupLayout());
		add(getJPanel0(), new Constraints(new Bilateral(12, 12, 433), new Bilateral(12, 12, 0)));
		setSize(900, 450);
	}



	public JPanel getParadaPanel(){
		if(paradaPanel == null){
			paradaPanel = new CadastroParadaPanel();
			paradaPresenter = new CadastroParadaPresenter(listaParada, paradaPanel);
		}
		
		return paradaPresenter.createView();
	}
	
	public JPanel getAplicativoPanel(){
		if(aplicativoPanel == null){
			aplicativoPanel = new CadastroAplicativoPanel();
			aplicativoPresenter = new CadastroAplicativoPresenter(listaAplicativos, aplicativoPanel);
		}
		
		return aplicativoPresenter.createView();
	}
	
	private JComboBox getComboSalvamentoContexto() {
		if (ComboSalvamentoContexto == null) {
			ComboSalvamentoContexto = new JComboBox();
			ComboSalvamentoContexto.setModel(new DefaultComboBoxModel(new Object[] { "Sim", "N�o" }));
			ComboSalvamentoContexto.setDoubleBuffered(false);
			ComboSalvamentoContexto.setBorder(null);
		}
		return ComboSalvamentoContexto;
	}

	private JPanel getJPanel6() {
		if (jPanel6 == null) {
			jPanel6 = new JPanel();
			jPanel6.setBorder(new LineBorder(Color.gray, 1, false));
			jPanel6.setLayout(new GroupLayout());
			jPanel6.add(getLabelInicioAtendimento(), new Constraints(new Leading(12, 12, 12), new Leading(12, 12, 12)));
			jPanel6.add(getLabelSalvamentoContexto(), new Constraints(new Leading(12, 12, 12), new Leading(48, 10, 10)));
			jPanel6.add(getTextInicioAtendimento(), new Constraints(new Leading(187, 62, 10, 10), new Leading(10, 12, 12)));
			jPanel6.add(getComboSalvamentoContexto(), new Constraints(new Leading(187, 12, 12), new Leading(44, 12, 12)));
		}
		return jPanel6;
	}

	private JTextField getTextInicioAtendimento() {
		if (textInicioAtendimento == null) {
			textInicioAtendimento = new JTextField();
		}
		return textInicioAtendimento;
	}

	private JTextField getTextProcessamento() {
		if (textProcessamento == null) {
			textProcessamento = new JTextField();
		}
		return textProcessamento;
	}


	
	

	private JTextField getTextIntervaloChegada() {
		if (textIntervalChegada == null) {
			textIntervalChegada = new JTextField();
		}
		return textIntervalChegada;
	}

	private JTextField getTextNumProcessos() {
		if (textNumProcessos == null) {
			textNumProcessos = new JTextField();
		}
		return textNumProcessos;
	}

	private JLabel getLabelChegada() {
		if (labelChegada == null) {
			labelChegada = new JLabel();
			labelChegada.setText("Chegada:");
		}
		return labelChegada;
	}


	private JLabel getLabelSalvamentoContexto() {
		if (labelSalvamentoContexto == null) {
			labelSalvamentoContexto = new JLabel();
			labelSalvamentoContexto.setText("Salvamento do Contexto:");
		}
		return labelSalvamentoContexto;
	}

	private JLabel getLabelInicioAtendimento() {
		if (labelInicioAtendimento == null) {
			labelInicioAtendimento = new JLabel();
			labelInicioAtendimento.setText("Inicio do Atendimento:");
		}
		return labelInicioAtendimento;
	}

	private JPanel getCadastroAplicativo(){
		if(aplicativoPanel ==null){
			aplicativoPanel = new CadastroAplicativoPanel();
			aplicativoPresenter = new CadastroAplicativoPresenter(listaAplicativos,aplicativoPanel);
		
			
		}
		return aplicativoPresenter.createView();
	}

	private JButton getBtnGrafico() {
		if (btnGrafico == null) {
			btnGrafico = new JButton();
			btnGrafico.setText("Gr�fico");
		}
		return btnGrafico;
	}

	private JButton getBtnParar() {
		if (btnParar == null) {
			btnParar = new JButton();
			btnParar.setText("Parar");
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

	private JPanel getJPanel3() {
		if (jPanel3 == null) {
			jPanel3 = new JPanel();
			jPanel3.setLayout(new GroupLayout());
			jPanel3.add(getParadaPanel(), new Constraints(new Leading(6, 334, 10, 10), new Leading(12, 209, 12, 12)));
		}
		return jPanel3;
	}

	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jPanel2 = new JPanel();
			jPanel2.setLayout(new GroupLayout());
			jPanel2.add(getAplicativoPanel(), new Constraints(new Bilateral(12, 12, 0), new Leading(12, 327, 10, 10)));
		}
		return jPanel2;
	}

	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.setLayout(new GroupLayout());
			jPanel1.add(getJPanel6(), new Constraints(new Bilateral(12, 11, 171), new Leading(12, 100, 12, 12)));
		}
		return jPanel1;
	}

	private JScrollPane getJScrollPane0() {
		if (jScrollPane0 == null) {
			jScrollPane0 = new JScrollPane();
			jScrollPane0.setViewportView(getTabelaProcessos());
		}
		return jScrollPane0;
	}

	private JTable getTabelaProcessos() {
		if (tabelaProcessos == null) {
			tabelaProcessos = new JTable();
			tabelaProcessos.setModel(new DefaultTableModel(new Object[][] { { "0x0", "0x1", }, { "1x0", "1x1", }, }, new String[] { "Title 0", "Title 1", }) {
				private static final long serialVersionUID = 1L;
				Class<?>[] types = new Class<?>[] { Object.class, Object.class, };
	
				public Class<?> getColumnClass(int columnIndex) {
					return types[columnIndex];
				}
			});
		}
		return tabelaProcessos;
	}

	private JPanel getJPanel0() {
		if (jPanel0 == null) {
			jPanel0 = new JPanel();
			jPanel0.setLayout(new GroupLayout());
			jPanel0.add(getBtnProcessar(), new Constraints(new Leading(12, 12, 12), new Trailing(12, 19, 385)));
			jPanel0.add(getBtnParar(), new Constraints(new Leading(118, 12, 12), new Trailing(12, 19, 385)));
			jPanel0.add(getBtnGrafico(), new Constraints(new Leading(196, 12, 12), new Trailing(12, 78, 385)));
			jPanel0.add(getJTabbedPane0(), new Constraints(new Leading(0, 393, 12, 12), new Bilateral(0, 56, 66)));
			jPanel0.add(getJScrollPane0(), new Constraints(new Bilateral(411, 0, 22), new Bilateral(0, 12, 22)));
		}
		return jPanel0;
	}

	private JTabbedPane getJTabbedPane0() {
		if (jTabbedPane0 == null) {
			jTabbedPane0 = new JTabbedPane();
			jTabbedPane0.addTab("Processador", getJPanel1());
			jTabbedPane0.addTab("Aplicativo", getJPanel2());
			jTabbedPane0.addTab("Parada", getJPanel3());
		}
		return jTabbedPane0;
	}

	private static void installLnF() {
		try {
			String lnfClassname = PREFERRED_LOOK_AND_FEEL;
			if (lnfClassname == null)
				lnfClassname = UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(lnfClassname);
		} catch (Exception e) {
			System.err.println("Cannot install " + PREFERRED_LOOK_AND_FEEL
					+ " on this platform:" + e.getMessage());
		}
	}

	/**
	 * Main entry of the class.
	 * Note: This class is only created so that you can easily preview the result at runtime.
	 * It is not expected to be managed by the designer.
	 * You can modify it as you like.
	 */
	public static void main(String[] args) {
		installLnF();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				TelaSimulador frame = new TelaSimulador();
				frame.setDefaultCloseOperation(TelaSimulador.EXIT_ON_CLOSE);
				frame.setTitle("TelaSimulador");
				frame.getContentPane().setPreferredSize(frame.getSize());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}

}
