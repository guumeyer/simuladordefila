/**
 * 
 */
package com.edu.gui.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.edu.gui.view.CadastroParadaView;

/**
 * @author Mews
 *
 */
public class ParadaWindowActionListeners {
	
	static class InserirActionListener implements ActionListener {

		private  CadastroParadaPresenter presenter; 
		
		public InserirActionListener(CadastroParadaPresenter presenter){
			this.presenter = presenter;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			CadastroParadaView view = presenter.getView();
			presenter.setOperacao(presenter.INSERT_STRATEGY);
			presenter.getOperacao().execute();
			
			view.enableBtnInserir(true);
			view.enableBtnRemover(true);
		}
		
	}
	
	
	static class RemoverActionListener implements ActionListener {

		private  CadastroParadaPresenter presenter; 
		
		public RemoverActionListener(CadastroParadaPresenter presenter){
			this.presenter = presenter;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			CadastroParadaView view = presenter.getView();
			presenter.setOperacao(presenter.REMOVE_STRATEGY);
			presenter.getOperacao().execute();
			
//			view.clearFields();

//			view.enableBtnInserir(true);
//			view.enableBtnRemover(true);
			
		}
		
	}
	

	
}
