package com.edu.relatorio.teste;

import java.util.ArrayList;
import java.util.List;

import com.edu.entity.Modalidade;
import com.edu.entity.Processo;

public class RelatorioTest {
	
	private Processo getProcesso(int pid, int chegada,int tmpAtendimento){
		Processo p1= new Processo();
		p1.setPid(pid);
		p1.setTempoProcessamento(10);
		p1.setModalidade(Modalidade.FIFO);
		p1.setChegada(chegada);
		p1.setTempoProcessamento(tmpAtendimento);
		
		return p1;
	}
	
	private List<Processo> geraConjunto(int qtdProcesso, int intervaloChegada, int tempoAtendimento, int inicioPrimeiroProcesso ){
		List<Processo> lista = new ArrayList<Processo>();
		int tmpQtdProcesso = 0;
		int intervaloChecadaTmp = intervaloChegada; 
		while((tmpQtdProcesso++)<qtdProcesso){
			lista.add(getProcesso(tmpQtdProcesso,intervaloChecadaTmp,tempoAtendimento));
			intervaloChecadaTmp +=intervaloChegada; 
		}
		return lista;
	}
	
	
	
	public void processar10Processo2Paradas()
	{
		List<Processo> processos = geraConjunto(10, 2, 10,1);
		
		for (Processo processo : processos) {
			System.out.println(processo.getPid());
		}
		
	}
	

	public static void main(String[] args) {
		RelatorioTest rel = new RelatorioTest();
		
		rel.processar10Processo2Paradas();
	}
}
