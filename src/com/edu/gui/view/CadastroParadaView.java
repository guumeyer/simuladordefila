package com.edu.gui.view;

import java.awt.event.ActionListener;

import javax.swing.JPanel;

import com.edu.gui.model.ParadaTableModel;

/**
 * @author Mews
 *
 */
public interface CadastroParadaView {

	public int getId() ;
	public void setId(Integer id) ;

	public int getInicioParada();
	public void setInicioParada(Integer inicioParada);

	public int getTempoParada() ;
	public void setTempoParada(Integer tempoParada);

	public void clearFields();
	public void clearTable();
	
	public void setParadaTableModel(ParadaTableModel model);  
    public ParadaTableModel getParadaTableModel();  
      
    public void enableBtnInserir(boolean arg);
    public void enableBtnRemover(boolean arg);
    public void enableTxtIdParada(boolean arg);
    public void enableTxtInicioParada(boolean arg);
    public void enableTxtTempoParada(boolean arg);
    
    public void refreshTable();
    
    public int linhaSelecionadaTable();
    public boolean validarCampos();
    
    public void resetCorCampos();
    
    public void showAlert(String msg);

	// Métodos para configurar os listeners que compõe a lógica de apresentação  
	public void setInserirActionListener(ActionListener listener);  
	public void setRemoverActionListener(ActionListener listener);  

	public void packAndShow();
	
	public JPanel getPanel();
}
