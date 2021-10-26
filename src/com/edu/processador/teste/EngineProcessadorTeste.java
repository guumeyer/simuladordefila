package com.edu.processador.teste;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.edu.entity.Aplicativo;
import com.edu.entity.Modalidade;
import com.edu.entity.Parada;
import com.edu.entity.Processo;
import com.edu.processador.EngineProcessador;
import com.edu.processador.Processador;

public class EngineProcessadorTeste {

	
	public Aplicativo getAplicativo(int chegada, int intervaloDeChegada, Modalidade modalidade, int qtdProcessos, 
			int tempoDeProcessamento){
		Aplicativo ap = new Aplicativo();
		ap.setChegadaAplicativo(chegada);
		ap.setIntervaloDeChegada(intervaloDeChegada);
		ap.setModalidade(modalidade);
		ap.setQtdProcessos(qtdProcessos);
		ap.setTempoDeProcessamento(tempoDeProcessamento);
		
		
		return ap;
	}
	
	public Aplicativo getAplicativo(int chegada, int intervaloDeChegada, Modalidade modalidade, int qtdProcessos, 
			int tempoDeProcessamento,String nomeAplicativo){
		Aplicativo ap = getAplicativo(chegada, intervaloDeChegada, modalidade, qtdProcessos, tempoDeProcessamento);
		ap.setNome(nomeAplicativo);
		return ap;
	}
	
	public Parada getParada(int inicio, int fim){
		Parada parada = new Parada();
		parada.setInicioParada(inicio);
		parada.setTempoParada(fim);
		return parada;
	}
	
	public List<Aplicativo> getListaAplicativo(){
		Aplicativo a1 = getAplicativo(1, 1, Modalidade.FIFO, 10, 5,"A");
		Aplicativo a2 = getAplicativo(10, 2, Modalidade.BJF, 10, 5,"B");
		Aplicativo a3 = getAplicativo(30, 3, Modalidade.BJF, 10, 5,"C");
		
		List<Aplicativo> lista = new ArrayList<Aplicativo>();
		
		lista.add(a1);
		lista.add(a2);
		lista.add(a3);
		
		return lista;
	}
	
	@Test
	public void verificarQtdProcessosNaFila(){
		EngineProcessador ep = new EngineProcessador();
		List<Processo> fila = ep.gerarFila(getListaAplicativo());
		
		assertTrue(fila.size() == 30);
	}

	@Test
	public void verificarPIdDosProcessos(){
		EngineProcessador ep = new EngineProcessador();
		List<Processo> fila = ep.gerarFila(getListaAplicativo());
		
		boolean verificaPId = true;
		
		for (int i = 0; i < fila.size(); i++) {
			verificaPId = (fila.get(i).getPid() == i+1) ? verificaPId : false;
		}
		
		assertTrue(verificaPId);
	}
	
	@Test
	public void verificarTempoChegada3ProcessoDo2Aplicativo(){

		EngineProcessador ep = new EngineProcessador();
		List<Processo> fila = ep.gerarFila(getListaAplicativo());
		
		assertTrue(fila.get(12).getChegada() == 14);
	}
	
	@Test
	public void validarTerminoAtendimentoDe20ProcessoComSalvamentoDeContexto(){
		List<Aplicativo> listaAplicativos = new ArrayList<Aplicativo>();
		listaAplicativos.add(getAplicativo(1, 2, Modalidade.FIFO, 5, 3,"A"));
		listaAplicativos.add(getAplicativo(6, 1, Modalidade.FIFO, 4, 1,"B"));
		listaAplicativos.add(getAplicativo(8, 3, Modalidade.BJF, 6, 2,"C"));
		listaAplicativos.add(getAplicativo(15, 2, Modalidade.BJF, 5, 1,"D"));
		
		List<Parada> listaParadas = new ArrayList<Parada>();
		listaParadas.add(getParada(10, 3));
		listaParadas.add(getParada(21, 2));
		listaParadas.add(getParada(35, 2));
		
		Processador processador = new Processador();
		processador.setInicioAtendimento(4);
		processador.setListaAplicativos(listaAplicativos);
		processador.setListaParadas(listaParadas);
		
		processador.setSalvamentoContexto(true);
		
		List<Processo> lista = processador.iniciarAtendimento();
		
		
		
		Assert.assertTrue((lista.get(0).getTerminoAtendimento()==6)
						&&(lista.get(1).getTerminoAtendimento()==9)
						&&(lista.get(2).getTerminoAtendimento()==15)
						&&(lista.get(3).getTerminoAtendimento()==18)
						&&(lista.get(4).getTerminoAtendimento()==23)
						&&(lista.get(5).getTerminoAtendimento()==24)
						&&(lista.get(6).getTerminoAtendimento()==25)
						&&(lista.get(7).getTerminoAtendimento()==26)
						&&(lista.get(8).getTerminoAtendimento()==27)
						&&(lista.get(9).getTerminoAtendimento()==29)
						&&(lista.get(10).getTerminoAtendimento()==31)
						&&(lista.get(11).getTerminoAtendimento()==33)
						&&(lista.get(12).getTerminoAtendimento()==37)
						&&(lista.get(13).getTerminoAtendimento()==39)
						&&(lista.get(14).getTerminoAtendimento()==41)
						&&(lista.get(15).getTerminoAtendimento()==42)
						&&(lista.get(16).getTerminoAtendimento()==43)
						&&(lista.get(17).getTerminoAtendimento()==44)
						&&(lista.get(18).getTerminoAtendimento()==45)
						&&(lista.get(19).getTerminoAtendimento()==46));
	}

	@Test
	public void validarTerminoAtendimentoDe20ProcessoSemSalvamentoDeContexto(){
		List<Aplicativo> listaAplicativos = new ArrayList<Aplicativo>();
		listaAplicativos.add(getAplicativo(1, 2, Modalidade.FIFO, 5, 3,"A"));
		listaAplicativos.add(getAplicativo(6, 1, Modalidade.FIFO, 4, 1,"B"));
		listaAplicativos.add(getAplicativo(8, 3, Modalidade.BJF, 6, 2,"C"));
		listaAplicativos.add(getAplicativo(15, 2, Modalidade.BJF, 5, 1,"D"));
		
		List<Parada> listaParadas = new ArrayList<Parada>();
		listaParadas.add(getParada(10, 3));
		listaParadas.add(getParada(21, 2));
		listaParadas.add(getParada(35, 2));
		
		Processador processador = new Processador();
		processador.setInicioAtendimento(4);
		processador.setListaAplicativos(listaAplicativos);
		processador.setListaParadas(listaParadas);
		
		processador.setSalvamentoContexto(false);
		
		List<Processo> lista = processador.iniciarAtendimento();
		
		
		
		Assert.assertTrue((lista.get(0).getTerminoAtendimento()==6)
						&&(lista.get(1).getTerminoAtendimento()==9)
						&&(lista.get(2).getTerminoAtendimento()==15)
						&&(lista.get(3).getTerminoAtendimento()==18)
						&&(lista.get(4).getTerminoAtendimento()==25)
						&&(lista.get(5).getTerminoAtendimento()==26)
						&&(lista.get(6).getTerminoAtendimento()==27)
						&&(lista.get(7).getTerminoAtendimento()==28)
						&&(lista.get(8).getTerminoAtendimento()==29)
						&&(lista.get(9).getTerminoAtendimento()==31)
						&&(lista.get(10).getTerminoAtendimento()==33)
						&&(lista.get(11).getTerminoAtendimento()==38)
						&&(lista.get(12).getTerminoAtendimento()==40)
						&&(lista.get(13).getTerminoAtendimento()==42)
						&&(lista.get(14).getTerminoAtendimento()==44)
						&&(lista.get(15).getTerminoAtendimento()==45)
						&&(lista.get(16).getTerminoAtendimento()==46)
						&&(lista.get(17).getTerminoAtendimento()==47)
						&&(lista.get(18).getTerminoAtendimento()==48)
						&&(lista.get(19).getTerminoAtendimento()==49));
	}

	@Test
	public void validarTerminoAtendimentoCom2Paradas1ProcessoComSalvamentoContexto(){
		List<Aplicativo> listaAplicativos = new ArrayList<Aplicativo>();
		listaAplicativos.add(getAplicativo(1, 2, Modalidade.FIFO, 5, 5,"A"));
		
		List<Parada> listaParadas = new ArrayList<Parada>();
		listaParadas.add(getParada(7, 2));
		listaParadas.add(getParada(11, 2));
		
		Processador processador = new Processador();
		processador.setInicioAtendimento(4);
		processador.setListaAplicativos(listaAplicativos);
		processador.setListaParadas(listaParadas);
		
		processador.setSalvamentoContexto(true);
		
		List<Processo> lista = processador.iniciarAtendimento();
		
		Assert.assertTrue((lista.get(0).getTerminoAtendimento()==10));
	}

	@Test
	public void validarTerminoAtendimentoCom2Paradas1ProcessoSemSalvamentoContexto(){
		List<Aplicativo> listaAplicativos = new ArrayList<Aplicativo>();
		listaAplicativos.add(getAplicativo(1, 2, Modalidade.FIFO, 5, 5,"A"));
		
		List<Parada> listaParadas = new ArrayList<Parada>();
		listaParadas.add(getParada(8, 2));
		listaParadas.add(getParada(12, 2));
		
		Processador processador = new Processador();
		processador.setInicioAtendimento(4);
		processador.setListaAplicativos(listaAplicativos);
		processador.setListaParadas(listaParadas);
		
		processador.setSalvamentoContexto(false);
		
		List<Processo> lista = processador.iniciarAtendimento();
		
		Assert.assertTrue((lista.get(0).getTerminoAtendimento()==18));
	}
}
