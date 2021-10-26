package com.edu.relatorio.ordernacao;

import java.util.Comparator;

import com.edu.entity.Processo;

public class TempoEsperaComparator implements Comparator<Processo> {

	@Override
	public int compare(Processo p1, Processo p2) {
		int resultado = 0;

		if (p1.getTempoEspera() < p2.getTempoEspera())
			resultado = -1;
		else if (p1.getTempoEspera() > p2.getTempoEspera())
			resultado = 1;

		return resultado;
	}

}
