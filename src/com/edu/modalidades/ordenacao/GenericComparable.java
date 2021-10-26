/**
 * 
 */
package com.edu.modalidades.ordenacao;

import java.util.Comparator;

import com.edu.entity.Modalidade;
import com.edu.entity.Processo;

/**
 * @author gustavo
 * 
 */
public class GenericComparable implements Comparator<Processo> {

	@Override
	public int compare(Processo p1, Processo p2) {

		int resultado = 0;
		if (p1.getAplicativo().equals(p2.getAplicativo()) &&  p1.getModalidade()==p2.getModalidade() ) {
			if (p1.getModalidade().equals(Modalidade.FIFO)) {
				resultado = getMetodoFIFO(p1, p2);
			} else if (p1.getModalidade().equals(Modalidade.SJF)) {
				resultado = getMetodoSJF(p1, p2);
			} else if (p1.getModalidade().equals(Modalidade.BJF)) {
				resultado = getMetodoBJF(p1, p2);
			}

		}

		return resultado;
	}
	
	public int getMetodoBJF(Processo p1, Processo p2) {
		int resultado = 0;

		if (p1.getTempoProcessamento() > p2.getTempoProcessamento())
			resultado = -1;
		else if (p1.getTempoProcessamento() < p2.getTempoProcessamento())
			resultado = 1;

		return resultado;
	}

	public int getMetodoSJF(Processo p1, Processo p2) {
		int resultado = 0;

		if (p1.getTempoProcessamento() < p2.getTempoProcessamento())
			resultado = -1;
		else if (p1.getTempoProcessamento() > p2.getTempoProcessamento())
			resultado = 1;

		return resultado;
	}

	public int getMetodoFIFO(Processo p1, Processo p2) {

		int resultado = 0;

		if (p1.getChegada() < p2.getChegada())
			resultado = -1;
		else if (p1.getChegada() > p2.getChegada())
			resultado = 1;

		return resultado;
	}

}
