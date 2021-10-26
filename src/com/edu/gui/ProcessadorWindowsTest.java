/**
 * 
 */
package com.edu.gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.dyno.visual.swing.layouts.Bilateral;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;

import com.edu.entity.Processo;
import com.edu.gui.presenter.ProcessadorPresenter;
import com.edu.gui.view.ProcessadorView;

//VS4E -- DO NOT REMOVE THIS LINE!
public class ProcessadorWindowsTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jPanel0;
	
	private List<Processo> listaProcesso;
	
	private ProcessadorView processadorView;
	
	private ProcessadorPresenter processadorPresenter;
	private static final String PREFERRED_LOOK_AND_FEEL = "javax.swing.plaf.metal.MetalLookAndFeel";
	public ProcessadorWindowsTest() {
		listaProcesso = new ArrayList<Processo>();
		add(getProcessoPanel());

		initComponents();
	} 

	public JPanel getProcessoPanel(){
		if(processadorView == null){
			processadorView = new ProcessadorPanel();
			processadorPresenter = new ProcessadorPresenter(listaProcesso, processadorView);
			
		}
		return (JPanel) processadorPresenter.createView();
		
	}
	
	private void initComponents() {
		setLayout(new GroupLayout());
		add(getProcessoPanel(), new Constraints(new Bilateral(5, 10, 10), new Bilateral(2, 10, 10)));
		setSize(890, 542);
	}

	private JPanel getJPanel0() {
		if (jPanel0 == null) {
			jPanel0 = new JPanel();
			jPanel0.setLayout(new GroupLayout());
		}
		return jPanel0;
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
				ProcessadorWindowsTest frame = new ProcessadorWindowsTest();
				frame.setDefaultCloseOperation(ProcessadorWindowsTest.EXIT_ON_CLOSE);
				frame.setTitle("Simulador de Filas de Processo");
				frame.getContentPane().setPreferredSize(frame.getSize());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
	}

}
