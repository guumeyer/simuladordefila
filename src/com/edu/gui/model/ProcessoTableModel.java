package com.edu.gui.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.edu.entity.Processo;

/**
 * @author Mews
 *
 */
public class ProcessoTableModel extends AbstractTableModel {

	private List<Processo> processos;  

	public ProcessoTableModel(List<Processo> processos) {  
		this.processos = processos;  
	}  

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {  
		Processo processo = processos.get(rowIndex);  

		if (processo != null) {  

			switch (columnIndex) {  
			case 0: return processo.getPid();  
			case 1: return processo.getChegada();  
			case 2: return processo.getTempoProcessamento();  
			case 3: return processo.getTempoEspera();  
			case 4: return processo.getInicioAtendimento();  
			case 5: return processo.getTerminoAtendimento();  
			case 6: return processo.getModalidade();  
			case 7: return processo.getAplicativo();  

			}  
		}  

		return null;  
	}  

	@Override
	public int getRowCount() {  
		if (processos != null) {  
			return this.processos.size();  
		}  

		return 0;  
	}  

	@Override
	public int getColumnCount() {  
		return 8;  
	}  

	public Processo getProcesso(int row) {  
		if (row >= 0) {  
			return this.processos.get(row);  
		}  

		return null;  
	}  

	@Override
	public String getColumnName(int col){  
		return processos.get(0).getColunasParaTabela().get(col);  
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
