package com.edu.gui;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.dyno.visual.swing.layouts.Bilateral;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import org.dyno.visual.swing.layouts.Trailing;


//VS4E -- DO NOT REMOVE THIS LINE!
public class SimuladorFila extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel jPanel0;
	private JButton jButton3;
	private JButton jButton4;
	private JPanel jPanel3;
	private JButton jButton0;
	private JButton jButton1;
	private JButton jButton2;
	private JPanel jPanel1;
	private JTable jTable0;
	private JScrollPane jScrollPane0;
	private JPanel jPanel2;
	private JTabbedPane jTabbedPane0;
	private JPanel jPanel4;
	private JPanel jPanel5;
	private JPanel jPanel6;
	private JTable jTable1;
	private JScrollPane jScrollPane1;
	private JLabel jLabel1;
	private JLabel jLabel0;
	private JTextField jTextField0;
	private JComboBox jComboBox0;
	private JButton jButton6;
	private JButton jButton5;
	private JButton jButton8;
	private JButton jButton7;
	private JTable jTable2;
	private JScrollPane jScrollPane2;
	public SimuladorFila() {
		initComponents();
	}

	private void initComponents() {
		setMinimumSize(new Dimension(720, 554));
		setOpaque(false);
		setLayout(new GroupLayout());
		add(getJPanel0(), new Constraints(new Bilateral(12, 12, 29), new Leading(12, 138, 69, 69)));
		add(getJPanel1(), new Constraints(new Leading(12, 696, 12, 12), new Leading(156, 37, 69, 69)));
		add(getJPanel2(), new Constraints(new Bilateral(13, 12, 675), new Leading(199, 286, 69, 69)));
		add(getJPanel3(), new Constraints(new Bilateral(13, 13, 699), new Leading(491, 28, 10, 10)));
		setSize(720, 525);
	}

	private JScrollPane getJScrollPane2() {
		if (jScrollPane2 == null) {
			jScrollPane2 = new JScrollPane();
			jScrollPane2.setViewportView(getJTable2());
		}
		return jScrollPane2;
	}

	private JTable getJTable2() {
		if (jTable2 == null) {
			jTable2 = new JTable();
			jTable2.setModel(new DefaultTableModel(new Object[][] { { "0x0", "0x1", }, { "1x0", "1x1", }, }, new String[] { "Title 0", "Title 1", }) {
				private static final long serialVersionUID = 1L;
				Class<?>[] types = new Class<?>[] { Object.class, Object.class, };
	
				public Class<?> getColumnClass(int columnIndex) {
					return types[columnIndex];
				}
			});
		}
		return jTable2;
	}

	private JButton getJButton7() {
		if (jButton7 == null) {
			jButton7 = new JButton();
			jButton7.setText("Inserir");
		}
		return jButton7;
	}

	private JButton getJButton8() {
		if (jButton8 == null) {
			jButton8 = new JButton();
			jButton8.setText("Remover");
		}
		return jButton8;
	}

	private JButton getJButton5() {
		if (jButton5 == null) {
			jButton5 = new JButton();
			jButton5.setText("Inserir");
		}
		return jButton5;
	}

	private JButton getJButton6() {
		if (jButton6 == null) {
			jButton6 = new JButton();
			jButton6.setText("Remover");
		}
		return jButton6;
	}

	private JComboBox getJComboBox0() {
		if (jComboBox0 == null) {
			jComboBox0 = new JComboBox();
			jComboBox0.setModel(new DefaultComboBoxModel(new Object[] { "Sim", "Não"}));
			jComboBox0.setDoubleBuffered(false);
			jComboBox0.setBorder(null);
		}
		return jComboBox0;
	}

	private JTextField getJTextField0() {
		if (jTextField0 == null) {
			jTextField0 = new JTextField();
		}
		return jTextField0;
	}

	private JLabel getJLabel0() {
		if (jLabel0 == null) {
			jLabel0 = new JLabel();
			jLabel0.setText("Inicio de Atendimento:");
		}
		return jLabel0;
	}

	private JLabel getJLabel1() {
		if (jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Salvamento de Contexto:");
		}
		return jLabel1;
	}

	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setViewportView(getJTable1());
		}
		return jScrollPane1;
	}

	private JTable getJTable1() {
		if (jTable1 == null) {
			jTable1 = new JTable();
			jTable1.setModel(new DefaultTableModel(new Object[][] { { "0x0", "0x1", }, { "1x0", "1x1", }, }, new String[] { "Title 0", "Title 1", }) {
				private static final long serialVersionUID = 1L;
				Class<?>[] types = new Class<?>[] { Object.class, Object.class, };
	
				public Class<?> getColumnClass(int columnIndex) {
					return types[columnIndex];
				}
			});
		}
		return jTable1;
	}

	private JPanel getJPanel6() {
		if (jPanel6 == null) {
			jPanel6 = new JPanel();
			jPanel6.setLayout(new GroupLayout());
			jPanel6.add(getJButton8(), new Constraints(new Trailing(12, 556, 556), new Leading(12, 14, 12, 12)));
			jPanel6.add(getJButton7(), new Constraints(new Trailing(115, 12, 12), new Leading(12, 14, 12, 12)));
			jPanel6.add(getJScrollPane2(), new Constraints(new Bilateral(12, 12, 22), new Leading(44, 59, 10, 10)));
		}
		return jPanel6;
	}
	
	private JPanel getJPanel5() {
		if (jPanel5 == null) {
			jPanel5 = new JPanel();
			jPanel5.setLayout(new GroupLayout());
			jPanel5.add(getJButton6(), new Constraints(new Trailing(12, 556, 556), new Leading(12, 14, 12, 12)));
			jPanel5.add(getJButton5(), new Constraints(new Trailing(115, 12, 12), new Leading(12, 14, 12, 12)));
			jPanel5.add(getJScrollPane1(), new Constraints(new Bilateral(12, 12, 22), new Leading(44, 59, 10, 10)));
		}
		return jPanel5;
	}


	private JPanel getJPanel4() {
		if (jPanel4 == null) {
			jPanel4 = new JPanel();
			jPanel4.setVisible(false);
			jPanel4.setLayout(new GroupLayout());
			jPanel4.add(getJLabel1(), new Constraints(new Leading(12, 12, 12), new Leading(66, 10, 10)));
			jPanel4.add(getJLabel0(), new Constraints(new Leading(12, 12, 12), new Leading(27, 10, 10)));
			jPanel4.add(getJTextField0(), new Constraints(new Leading(196, 89, 10, 10), new Leading(25, 12, 12)));
			jPanel4.add(getJComboBox0(), new Constraints(new Leading(196, 88, 12, 12), new Leading(57, 12, 12)));
		}
		return jPanel4;
	}
	
	private JPanel getJPanel0() {
		if (jPanel0 == null) {
			jPanel0 = new JPanel();
			jPanel0.setLayout(new GroupLayout());
			jPanel0.add(getJTabbedPane0(), new Constraints(new Bilateral(0, 0, 5), new Bilateral(0, 0, 7)));
		}
		return jPanel0;
	}

	private JTabbedPane getJTabbedPane0() {
		if (jTabbedPane0 == null) {
			jTabbedPane0 = new JTabbedPane();
			jTabbedPane0.addTab("Processador", getJPanel4());
			jTabbedPane0.addTab("Aplicativo", getJPanel5());
			jTabbedPane0.addTab("Parada", getJPanel6());
		}
		return jTabbedPane0;
	}

	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jPanel2 = new JPanel();
			jPanel2.setBackground(Color.lightGray);
			jPanel2.setLayout(new GroupLayout());
			jPanel2.add(getJScrollPane0(), new Constraints(new Bilateral(0, 0, 22), new Bilateral(0, 0, 26, 403)));
		}
		return jPanel2;
	}

	private JScrollPane getJScrollPane0() {
		if (jScrollPane0 == null) {
			jScrollPane0 = new JScrollPane();
			jScrollPane0.setViewportView(getJTable0());
		}
		return jScrollPane0;
	}

	private JTable getJTable0() {
		if (jTable0 == null) {
			jTable0 = new JTable();
			jTable0.setModel(new DefaultTableModel(new Object[][] { { "0x0", "0x1", }, { "1x0", "1x1", }, }, new String[] { "Title 0", "Title 1", }) {
				private static final long serialVersionUID = 1L;
				Class<?>[] types = new Class<?>[] { Object.class, Object.class, };
	
				public Class<?> getColumnClass(int columnIndex) {
					return types[columnIndex];
				}
			});
		}
		return jTable0;
	}

	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.setLayout(new GroupLayout());
			jPanel1.add(getJButton0(), new Constraints(new Leading(3, 12, 12), new Leading(2, 10, 10)));
			jPanel1.add(getJButton1(), new Constraints(new Leading(109, 12, 12), new Leading(2, 12, 12)));
			jPanel1.add(getJButton2(), new Constraints(new Leading(183, 10, 10), new Leading(2, 12, 12)));
		}
		return jPanel1;
	}

	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setText("Gráfico");
		}
		return jButton2;
	}

	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("Parar");
		}
		return jButton1;
	}

	private JButton getJButton0() {
		if (jButton0 == null) {
			jButton0 = new JButton();
			jButton0.setText("Processar");
		}
		return jButton0;
	}

	private JPanel getJPanel3() {
		if (jPanel3 == null) {
			jPanel3 = new JPanel();
			jPanel3.setLayout(new GroupLayout());
			jPanel3.add(getJButton3(), new Constraints(new Trailing(0, 602, 602), new Leading(0, 12, 12)));
			jPanel3.add(getJButton4(), new Constraints(new Trailing(103, 12, 12), new Leading(0, 12, 12)));
		}
		return jPanel3;
	}

	private JButton getJButton4() {
		if (jButton4 == null) {
			jButton4 = new JButton();
			jButton4.setText("OK");
		}
		return jButton4;
	}

	private JButton getJButton3() {
		if (jButton3 == null) {
			jButton3 = new JButton();
			jButton3.setText("Cancelar");
		}
		return jButton3;
	}

}
