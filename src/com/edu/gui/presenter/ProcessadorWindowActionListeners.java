/**
 * 
 */
package com.edu.gui.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.edu.gui.view.CadastroParadaView;
import com.edu.gui.view.ProcessadorView;

/**
 * @author Mews
 *
 */
public class ProcessadorWindowActionListeners {
	
	static class ProcessarActionListener implements ActionListener {

		private  ProcessadorPresenter presenter; 
		
		public ProcessarActionListener(ProcessadorPresenter presenter){
			this.presenter = presenter;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			
			ProcessadorView view = presenter.getView();
			presenter.setOperacao(presenter.PROCESSAR_STRATEGY);
			presenter.getOperacao().execute();
			view.enableBtnProcessar(true);
			view.enableBtnReset(true);
		}
		
	}
	
	
	static class ResetActionListener implements ActionListener {

		private  ProcessadorPresenter presenter; 
		
		public ResetActionListener(ProcessadorPresenter presenter){
			this.presenter = presenter;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			ProcessadorView view = presenter.getView();
			presenter.setOperacao(presenter.RESET_STRATEGY);
			presenter.getOperacao().execute();
			
		}
		
	}
	

	
}
