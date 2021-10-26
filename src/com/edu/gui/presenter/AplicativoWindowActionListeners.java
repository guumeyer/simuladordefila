/**
 * 
 */
package com.edu.gui.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.edu.gui.view.CadastroAplicativoView;

/**
 * @author gustavo
 *
 */
public class AplicativoWindowActionListeners {
	
	static class InserirActionListener implements ActionListener {

		private  CadastroAplicativoPresenter presenter; 
		
		public InserirActionListener(CadastroAplicativoPresenter presenter){
			this.presenter = presenter;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			presenter.habilitarEdicao(true);

			CadastroAplicativoView view = presenter.getView();
			presenter.setOperacao(presenter.INSERT_STRATEGY);
			presenter.getOperacao().execute();
			//presenter.
			
			//view.enableBtnConfirmar(true);
			
		}
		
	}
	
	
	static class RemoverActionListener implements ActionListener {

		private  CadastroAplicativoPresenter presenter; 
		
		public RemoverActionListener(CadastroAplicativoPresenter presenter){
			this.presenter = presenter;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			presenter.habilitarEdicao(true);
			
			CadastroAplicativoView view = presenter.getView();
			
			presenter.setOperacao(presenter.REMOVE_STRATEGY);
			presenter.getOperacao().execute();
//			view.clearFields();
			//view.enableBtnCancelar(true);
			//view.enableBtnConfirmar(true);
			
		}
		
	}
	
	static class TableAplicativoMouseListener extends MouseAdapter {  
		private  CadastroAplicativoPresenter presenter;
          
        public TableAplicativoMouseListener(CadastroAplicativoPresenter presenter) {  
            this.presenter = presenter;  
        }  
          
        @Override
        public void mousePressed(MouseEvent e) {
           presenter.updateModelFromJTable();  
                CadastroAplicativoView view = presenter.getView();  
                view.enableBtnRemover(true);  
                
        }
        
    }  

	
}
