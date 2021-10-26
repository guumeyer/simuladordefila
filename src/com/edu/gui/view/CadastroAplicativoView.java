/**
 * 
 */
package com.edu.gui.view;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.event.AncestorListener;

import com.edu.entity.Modalidade;
import com.edu.gui.model.AplicativoTableModel;

/**
 * @author gustavo
 *
 */
public interface CadastroAplicativoView  {
	
	// Gets e Sets dos atributos que representam o model 
	public void setId(Integer id) ;
	public void setNome(String nome);
	public void setChegada(Integer id);
	public void setIntervaloDeChegada(Integer intervaloDeChegada) ;
	public void setTempoDeProcessamento(Integer tempoDeProcessamento) ;	
	public void setQtdProcesso(Integer qtd);
	public void setModalidade(Modalidade modalidade );
	
	public JPanel getPanel();
	
	public int getId() ;
	public String getNome();
	public int getChegada();
	public int getIntervaloDeChegada() ;
	public int getTempoDeProcessamento() ;
	public int getQtdProcesso();
	public Modalidade getModalidade();
	
    public void clearFields(); 
    public void clearTable(); 
    
    public boolean validarCampos();
      
    public void enableTxtAplicativoId(boolean arg);  
    public void enableTxtAplicativoNome(boolean arg);
    public void enableTxtAplicativoChegada(boolean arg);
    public void enableTxtAplicativoIntervaloDeChegada(boolean arg);
    public void enableTxtAplicativoTempoDeProcesso(boolean arg);
    public void enableTxtAplicativoQtdProcesso(boolean arg);
    public void enableComboBoxModalidade(boolean arg);
    
    public void resetCorCampos();
    
    public void showAlert(String msg);
    
    public void enableBtnRemover(boolean arg);  
    public void enableBtnAdicionar(boolean arg); 
    
    
    public void setAplicativoTableModel(AplicativoTableModel model);  
    public AplicativoTableModel getAplicativoTableModel();
    
      
    public void refreshTable();
    
    public int linhaSelecionadaTable();
    public void setLinhaSelecionadaTable(int index);
    
    // Métodos para configurar os listeners que compõe a lógica de apresentação  
    public void setInserirActionListener(ActionListener listener);  
    public void setRemoverActionListener(ActionListener listener);
    public void setTableMouseListener(MouseListener listener);
    
    public void packAndShow();
}


