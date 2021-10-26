/**
 * 
 */
package com.edu.gui.view;

import java.awt.event.ActionListener;

import com.edu.gui.CadastroAplicativoPanel;
import com.edu.gui.CadastroParadaPanel;
import com.edu.gui.model.ProcessoTableModel;


/**
 * @author Mews
 *
 */
public interface ProcessadorView  {
	
	// Gets e Sets dos atributos que representam o model 
	public void setInicioAtendimento(Integer inicio);
	public void setSalvamentoContexto(Boolean salvamentoContexto) ;
	
	public int getInicioAtendimento();
	public boolean isSalvamentoContexto() ;

	public void clearFields();  
	public void clearTable();  
      
    public void enableTxtProcessadorInicioAtendimento(boolean arg);  
    public void enableComboProcessadorSalvamentoContexto(boolean arg);
    
    public void showAlert(String msg);
    
    public CadastroParadaPanel getCadastroParadaPanel();
    public CadastroAplicativoPanel getCadastroAplicativoPanel();
    
    public void enableBtnProcessar(boolean arg);  
    public void enableBtnParar(boolean arg); 
    public void enableBtnReset(boolean arg); 
    
    public void setProcessoTableModel(ProcessoTableModel model);  
    public ProcessoTableModel getProcessoTableModel();  
    
    public void setAreaConsole(String texto);
    public String getStringAreaConsole();
    
    public boolean validarCampos();
    
    public void resetCorCampos();
    
    public void refreshTable();
    
    public int linhaSelecionadaTable();
    
    // Métodos para configurar os listeners que compõe a lógica de apresentação  
    public void setInserirActionListener(ActionListener listener);
    public void setProcessarActionListener(ActionListener listener);
    public void setRemoverActionListener(ActionListener listener);  
    public void setResetActionListener(ActionListener listener);  
    
    public void packAndShow();
}


