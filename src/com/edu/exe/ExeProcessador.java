package com.edu.exe;

import java.util.ArrayList;
import java.util.List;

import com.edu.entity.Aplicativo;
import com.edu.entity.Modalidade;
import com.edu.entity.Parada;
import com.edu.entity.Processo;
import com.edu.processador.Processador;

public class ExeProcessador {
	
	public List<Processo> getFilaProcessada() {

		List<Aplicativo> lista = new ArrayList<Aplicativo>();

		lista.add(getAplicativo(1, 2, Modalidade.FIFO, 5, 3, "A"));
		lista.add(getAplicativo(6, 1, Modalidade.FIFO, 4, 1, "B"));
		lista.add(getAplicativo(8, 3, Modalidade.BJF, 6, 2, "C"));
		lista.add(getAplicativo(15, 2, Modalidade.BJF, 5, 1, "D"));

		List<Parada> listaParadas = new ArrayList<Parada>();

		listaParadas.add(getParada(10, 3));
		listaParadas.add(getParada(21, 2));
		listaParadas.add(getParada(35, 2));

		Processador processador = new Processador();

		processador.setInicioAtendimento(4);
		processador.setListaAplicativos(lista);
		processador.setListaParadas(listaParadas);
		processador.setSalvamentoContexto(false);

		List<Processo> filaProcessada = new ArrayList<Processo>();

		return processador.iniciarAtendimento();

		
	}

	public static Aplicativo getAplicativo(int chegada, int intervaloDeChegada, Modalidade modalidade, int qtdProcessos, 
			int tempoDeProcessamento, String nome){

		Aplicativo ap = new Aplicativo();
		ap.setChegadaAplicativo(chegada);
		ap.setIntervaloDeChegada(intervaloDeChegada);
		ap.setModalidade(modalidade);
		ap.setQtdProcessos(qtdProcessos);
		ap.setTempoDeProcessamento(tempoDeProcessamento);
		ap.setNome(nome);

		return ap;
	}

	public static Parada getParada(int inicioParada, int tempoParada){
		Parada parada = new Parada();

		parada.setCheck(false);
		parada.setInicioParada(inicioParada);
		parada.setTempoParada(tempoParada);

		return parada;
	}
}
