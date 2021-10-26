package com.edu.gui.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.edu.entity.Aplicativo;
import com.edu.entity.Aplicativo;
import com.edu.entity.Processo;

/**
 * @author Mews
 *
 */
public class AplicativoTableModel extends AbstractTableModel {

	private List<Aplicativo> aplicativos;  

	public AplicativoTableModel(List aplicativos) {  
		this.aplicativos = aplicativos;  
	}  

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {  
		Aplicativo Aplicativo = aplicativos.get(rowIndex);  

		if (Aplicativo != null) {  
			
			switch (columnIndex) {  
			case 0: return Aplicativo.getId();  
			case 1: return Aplicativo.getNome();  
			case 2: return Aplicativo.getChegadaAplicativo();  
			case 3: return Aplicativo.getQtdProcessos();  
			case 4: return Aplicativo.getTempoDeProcessamento();  
			case 5: return Aplicativo.getIntervaloDeChegada();
			case 6: return Aplicativo.getModalidade();  
			}  
		}  

		return null;  
	}  

	@Override
	public int getRowCount() {  
		if (aplicativos != null) {  
			return this.aplicativos.size();  
		}  

		return 0;  
	}  

	@Override
	public int getColumnCount() {  
		return 7;  
	}  

	public Aplicativo getAplicativo(int row) {  
		if (row >= 0) {  
			return this.aplicativos.get(row);  
		}  

		return null;  
	}  

	@Override
	public String getColumnName(int col){  
		return aplicativos.get(0).getColunasParaTabela().get(col);  
	}

	public boolean removeRow(int linhaInicial, int linhaFinal){  
		fireTableRowsDeleted(linhaInicial,linhaFinal);  
		return true;                  
	}
	
	public void addRow( String [] dadosLinha){
//	    fireTableRowsInserted(linha,linha);  
	    return;  
	}
}
