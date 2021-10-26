package com.edu.processador;

import java.util.ArrayList;
import java.util.List;

import com.edu.entity.Aplicativo;
import com.edu.entity.Parada;
import com.edu.entity.Processo;
import com.edu.modalidades.EngineModalidade;

/**
 * @author Mews
 *
 */
public class EngineProcessador {

	public List<Processo> gerarFila(List<Aplicativo> listaAplicativos){
		List<Processo> fila = new ArrayList<Processo>();

		//apenas inseri os processos dos aplicativos em uma fila de processos
		for (Aplicativo aplicativo : listaAplicativos) {
			fila.addAll(aplicativo.getListaProcessos());
		}
		return setarPId(ordenarFila(fila));
	} 

	public List<Processo> ordenarFila(List<Processo> fila){
		EngineModalidade em = new EngineModalidade();
		return em.ordernar(fila);
	}

	public List<Processo> setarPId(List<Processo> fila){
		for (int i = 0; i < fila.size(); i++) {
			//primeiro processo da fica comeca com 1
			fila.get(i).setPid(i+1);
		}
		return fila;
	}


	public List<Processo> processarFila(List<Processo> fila, List<Parada> listaParadas, Processador processador){
		for (int i = 0; i < fila.size(); i++) {
			if (i==0){
				if (processador.getInicioAtendimento() < fila.get(i).getChegada()){
					fila.get(i).setInicioAtendimento(getInicioAtendimentoProcesso(listaParadas, fila.get(i).getChegada()));
				}
				else{
					fila.get(i).setInicioAtendimento(getInicioAtendimentoProcesso(listaParadas, processador.getInicioAtendimento()));
				}
			}
			else
			{
				if (fila.get(i).getInicioAtendimento() > fila.get(i).getTerminoAtendimento()){
					fila.get(i).setInicioAtendimento(getInicioAtendimentoProcesso(listaParadas, fila.get(i).getChegada()));
				}
				else{
					fila.get(i).setInicioAtendimento(getInicioAtendimentoProcesso(listaParadas, fila.get(i-1).getTerminoAtendimento()+1));
				}
			}
			fila.get(i).setTerminoAtendimento(getTerminoProcessamentoProcesso(listaParadas, fila.get(i),processador));
		}

		return fila;
	}

	public int getTerminoProcessamentoProcesso(List<Parada> listaParadas, Processo processo,Processador processador){

		int termino = processo.getTempoProcessamento() + processo.getInicioAtendimento() - 1;

		for (Parada parada : listaParadas) {
			if (parada.getInicioParada() >= processo.getInicioAtendimento() && 
					parada.getInicioParada() <= termino){

				if (processador.isSalvamentoContexto())
					termino = parada.getTempoParada() + termino;
				else{
					termino = (parada.getTempoParada() + parada.getInicioParada() - 1) + processo.getTempoProcessamento();
				}
			}
		}
		return termino;
	}


	public int getInicioAtendimentoProcesso(List<Parada> listaParadas, int inicioAtendimento){

		for (Parada parada : listaParadas) {
			if (inicioAtendimento >= parada.getInicioParada() && inicioAtendimento <= parada.getInicioParada()+ parada.getTempoParada()){
				return parada.getInicioParada()+ parada.getTempoParada();
			}
		}
		return  inicioAtendimento;
	}
}
