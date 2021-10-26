package com.edu.gui.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.edu.entity.Parada;
import com.edu.entity.Processo;

/**
 * @author Mews
 *
 */
public class ParadaTableModel extends AbstractTableModel {

	private List<Parada> paradas;  

	public ParadaTableModel(List paradas) {  
		this.paradas = paradas;  
	}  

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {  
		Parada parada = paradas.get(rowIndex);  

		if (parada != null) {  

			switch (columnIndex) {  
			case 0: return parada.getId();  
			case 1: return parada.getInicioParada();  
			case 2: return parada.getTempoParada();  
			}  
		}  

		return null;  
	}  

	@Override
	public int getRowCount() {  
		if (paradas != null) {  
			return this.paradas.size();  
		}  

		return 0;  
	}  

	@Override
	public int getColumnCount() {  
		return 3;  
	}  

	public Parada getParada(int row) {  
		if (row >= 0) {  
			return this.paradas.get(row);  
		}  

		return null;  
	}  

	@Override
	public String getColumnName(int col){  
		return paradas.get(0).getColunasParaTabela().get(col);  
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
