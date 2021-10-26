package com.edu.modalidades.teste;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.edu.entity.Modalidade;
import com.edu.entity.Processo;
import com.edu.modalidades.EngineModalidade;

public class EngineModalidadeTeste {

	public Processo getProcesso(int pid,int tempoChecada, int tempoDeProcessamento,
			Modalidade modalidade) {
		Processo p1 = new Processo();
		p1.setPid(pid);
		p1.setModalidade(modalidade);
		p1.setChegada(tempoChecada);
		p1.setTempoProcessamento(tempoDeProcessamento);
		p1.setAplicativo("A");
		return p1;
	}

	@Test
	public void verificarOrdenacaoDo3ProcessModalidadeFIFO() {
		List<Processo> lista = new ArrayList<Processo>();

		Processo p1 = getProcesso(6, 10,10, Modalidade.FIFO);
		Processo p2 = getProcesso(3, 5, 3,Modalidade.FIFO);
		Processo p3 = getProcesso(1, 2, 2,Modalidade.FIFO);

		lista.add(p1);
		lista.add(p2);
		lista.add(p3);

		EngineModalidade modalidade = new EngineModalidade();

		modalidade.ordernar(lista);

		assertTrue(lista.get(2).equals(p1));
	}

	@Test
	public void verificarOrdenacaoDo3ProcessModalidadeSJF() {
		List<Processo> lista = new ArrayList<Processo>();

		Processo p1 = getProcesso(3, 10, 10,Modalidade.SJF);
		Processo p2 = getProcesso(2, 5, 5,Modalidade.SJF);
		Processo p3 = getProcesso(1, 2, 1,Modalidade.SJF);

		lista.add(p1);
		lista.add(p2);
		lista.add(p3);

		EngineModalidade modalidade = new EngineModalidade();
		modalidade.ordernar(lista);

		assertTrue(lista.get(0).equals(p3));

	}

	@Test
	public void verificarOrdenacaoDo3ProcessModalidadeBJF() {
		List<Processo> lista = new ArrayList<Processo>();

		Processo p1 = getProcesso(1, 10, 34,Modalidade.BJF);
		Processo p2 = getProcesso(2, 5, 23,Modalidade.BJF);
		Processo p3 = getProcesso(3, 2, 32,Modalidade.BJF);

		lista.add(p1);
		lista.add(p2);
		lista.add(p3);

		EngineModalidade modalidade = new EngineModalidade();
		modalidade.ordernar(lista);

		assertTrue(lista.get(0).equals(p1));

	}

	
	
	@Test
	public void verificarProcesso3FIFOEmLista() {
		List<Processo> lista = new ArrayList<Processo>();

		//indice resultado = 2
		Processo pf1 = getProcesso(3, 10, 21,Modalidade.FIFO);
		//indice resultado = 1
		Processo pf2 = getProcesso(2, 5, 2,Modalidade.FIFO);
		//indice resultado = 1
		Processo pf3 = getProcesso(1, 2, 1,Modalidade.FIFO);

		lista.add(pf1);
		lista.add(pf2);
		lista.add(pf3);

		
		Processo pb1 = getProcesso(4, 10, 20,Modalidade.BJF);
		Processo pb2 = getProcesso(5, 5, 5,Modalidade.BJF);
		Processo pb3 = getProcesso(6, 2, 2,Modalidade.BJF);

			
		lista.add(pb1);
		lista.add(pb2);
		lista.add(pb3);

		Processo pS1 = getProcesso(7, 10, 30,Modalidade.SJF);
		Processo pS2 = getProcesso(8, 5, 20,Modalidade.SJF);
		Processo pS3 = getProcesso(9, 2, 10,Modalidade.SJF);

		lista.add(pS1);
		lista.add(pS2);
		lista.add(pS3);
		
		
		EngineModalidade modalidade = new EngineModalidade();
		modalidade.ordernar(lista);

		assertTrue((lista.get(0).getPid()==pf3.getPid() && lista.get(1).getPid()==pf2.getPid() && lista.get(2).getPid()==pf1.getPid()));

	}
	

	@Test
	public void verificarProcesso4BJFEmLista() {
		List<Processo> lista = new ArrayList<Processo>();

		Processo pf1 = getProcesso(3, 10, 30,Modalidade.FIFO);
		Processo pf2 = getProcesso(2, 5, 20,Modalidade.FIFO);
		Processo pf3 = getProcesso(1, 2, 10,Modalidade.FIFO);

		lista.add(pf1);
		lista.add(pf2);
		lista.add(pf3);

		//indice resultado = 3
		Processo pb1 = getProcesso(4, 10, 50,Modalidade.BJF);
		//indice resultado = 4
		Processo pb2 = getProcesso(5, 5, 23,Modalidade.BJF);
		//indice resultado = 5
		Processo pb3 = getProcesso(6, 2, 13,Modalidade.BJF);

			
		lista.add(pb1);
		lista.add(pb2);
		lista.add(pb3);

		Processo pS1 = getProcesso(9, 10, 32,Modalidade.SJF);
		Processo pS2 = getProcesso(8, 5, 31,Modalidade.SJF);
		Processo pS3 = getProcesso(7, 2, 30,Modalidade.SJF);

		lista.add(pS1);
		lista.add(pS2);
		lista.add(pS3);
		
		
		EngineModalidade modalidade = new EngineModalidade();
		modalidade.ordernar(lista);

		assertTrue((lista.get(3).getPid()==pb1.getPid() && lista.get(4).getPid()==pb2.getPid() && lista.get(5).getPid()==pb3.getPid()));

	}

	
	@Test
	public void verificarProcesso7SJFEmLista() {
		List<Processo> lista = new ArrayList<Processo>();

		Processo pf1 = getProcesso(3, 10, 40,Modalidade.FIFO);
		Processo pf2 = getProcesso(2, 5,12 ,Modalidade.FIFO);
		Processo pf3 = getProcesso(1, 2, 1,Modalidade.FIFO);

		lista.add(pf1);
		lista.add(pf2);
		lista.add(pf3);

		
		Processo pb1 = getProcesso(14, 10, 40,Modalidade.BJF);
		Processo pb2 = getProcesso(5, 5, 43,Modalidade.BJF);
		Processo pb3 = getProcesso(6, 2, 40,Modalidade.BJF);

			
		lista.add(pb1);
		lista.add(pb2);
		lista.add(pb3);

		//indice resultado = 8
		Processo pS1 = getProcesso(9, 10, 39,Modalidade.SJF);
		//indice resultado = 7
		Processo pS2 = getProcesso(8, 5, 38,Modalidade.SJF);
		//indice resultado = 6
		Processo pS3 = getProcesso(7, 2, 37,Modalidade.SJF);

		lista.add(pS1);
		lista.add(pS2);
		lista.add(pS3);
		
		
		EngineModalidade modalidade = new EngineModalidade();
		modalidade.ordernar(lista);

		assertTrue((lista.get(8).getPid()==pS1.getPid() && lista.get(7).getPid()==pS2.getPid() && lista.get(6).getPid()==pS3.getPid()));
	}


	@Test
	public void verificarOrdenacaoDaListaFIFO_BJF_SJF() {
		List<Processo> lista = new ArrayList<Processo>();

		//indice resultado = 2
		Processo pf1 = getProcesso(3, 10, 10,Modalidade.FIFO);
		//indice resultado = 1
		Processo pf2 = getProcesso(2, 5, 5,Modalidade.FIFO);
		//indice resultado = 0
		Processo pf3 = getProcesso(1, 2, 2,Modalidade.FIFO);

		lista.add(pf1); //indice 0
		lista.add(pf3); //indice 1
		lista.add(pf2); //indice 2
		
		//indice resultado = 3
		Processo pb1 = getProcesso(4, 10, 50,Modalidade.BJF);
		//indice resultado = 4
		Processo pb2 = getProcesso(5, 5, 23,Modalidade.BJF);
		//indice resultado = 5
		Processo pb3 = getProcesso(6, 2, 13,Modalidade.BJF);

			
		lista.add(pb1);	//indice 3	
		lista.add(pb3); //indice 4
		lista.add(pb2); //indice 5

		//indice resultado = 8
		Processo pS1 = getProcesso(9, 10, 42,Modalidade.SJF);
		//indice resultado = 7
		Processo pS2 = getProcesso(8, 5, 41,Modalidade.SJF);
		//indice resultado = 6
		Processo pS3 = getProcesso(7, 2, 40,Modalidade.SJF);


		lista.add(pS1); //indice 6
		lista.add(pS2); //indice 7
		lista.add(pS3); //indice 8
		
		
		EngineModalidade modalidade = new EngineModalidade();
		modalidade.ordernar(lista);

		assertTrue(((lista.get(0).getPid()==pf3.getPid() && lista.get(1).getPid()==pf2.getPid() && lista.get(2).getPid()==pf1.getPid())) 
				&& ((lista.get(3).getPid()==pb1.getPid() && lista.get(4).getPid()==pb2.getPid() && lista.get(5).getPid()==pb3.getPid())) 
				&& ((lista.get(8).getPid()==pS1.getPid() && lista.get(7).getPid()==pS2.getPid() && lista.get(6).getPid()==pS3.getPid()))
				);

	}


	@Test
	public void verificarOrdenacaoDaListaFIFO_BJF_FIFO_SJF() {
		List<Processo> lista = new ArrayList<Processo>();

		//indice resultado = 2
		Processo pf1 = getProcesso(3, 3, 30,Modalidade.FIFO);
		//indice resultado = 1
		Processo pf2 = getProcesso(2, 2, 29,Modalidade.FIFO);
		//indice resultado = 0
		Processo pf3 = getProcesso(1, 1, 20,Modalidade.FIFO);

		lista.add(pf1); //indice 1
		lista.add(pf3); //indice 0
		lista.add(pf2); //indice 2
		
		//indice resultado = 3
		Processo pb1 = getProcesso(4, 10, 50,Modalidade.BJF);
		//indice resultado = 4
		Processo pb2 = getProcesso(5, 5, 23,Modalidade.BJF);
		//indice resultado = 5
		Processo pb3 = getProcesso(6, 2, 13,Modalidade.BJF);

			
		lista.add(pb1);	//indice 3	
		lista.add(pb3); //indice 4
		lista.add(pb2); //indice 5

		//indice resultado = 8
		Processo pf4 = getProcesso(9, 10, 40,Modalidade.FIFO);
		//indice resultado = 7
		Processo pf5 = getProcesso(8, 5, 39,Modalidade.FIFO);
		//indice resultado = 6
		Processo pf6 = getProcesso(7, 2, 30,Modalidade.FIFO);

		lista.add(pf4); //indice 6
		lista.add(pf6); //indice 7
		lista.add(pf5); //indice 8
		
		
		//indice resultado = 12
		Processo pS1 = getProcesso(9, 10, 42,Modalidade.SJF);
		//indice resultado = 11
		Processo pS2 = getProcesso(8, 5, 41,Modalidade.SJF);
		//indice resultado = 10
		Processo pS3 = getProcesso(7, 2, 40,Modalidade.SJF);



		lista.add(pS1); //indice 9
		lista.add(pS2); //indice 10
		lista.add(pS3); //indice 11
		
		
		EngineModalidade modalidade = new EngineModalidade();
		modalidade.ordernar(lista);

		assertTrue((lista.get(0).getPid()==pf3.getPid() && lista.get(1).getPid()==pf2.getPid() && lista.get(2).getPid()==pf1.getPid()) &&
		(lista.get(3).getPid()==pb1.getPid() && lista.get(4).getPid()==pb2.getPid() && lista.get(5).getPid()==pb3.getPid()) &&
		(lista.get(8).getPid()==pf4.getPid() && lista.get(7).getPid()==pf5.getPid() && lista.get(6).getPid()==pf6.getPid()) &&
		(lista.get(11).getPid()==pS1.getPid() && lista.get(10).getPid()==pS2.getPid() && lista.get(9).getPid()==pS3.getPid()));

	}
	
	

	
	@Test
	public void verificarOrdenacaoDe10MilProcessosModalidadeFIFO() {
		List<Processo> lista = new ArrayList<Processo>();

		
		for (int i = 9999; i >=0; i--) {
			Processo p1 = getProcesso(i, i, i,Modalidade.FIFO);
			lista.add(p1);	
		}
		
		Processo p9999 = lista.get(0); 	

		EngineModalidade modalidade = new EngineModalidade();

		modalidade.ordernar(lista);

		
		assertTrue(lista.get(9999).getPid()==p9999.getPid());
	}
	
	@Test
	public void verificarOrdenacaoDe10MilProcessosModalidadeSJF() {
		List<Processo> lista = new ArrayList<Processo>();

		
		for (int i = 9999; i >=0; i--) {
			Processo p1 = getProcesso(i, i, i,Modalidade.SJF);
			lista.add(p1);	
		}
		
		Processo p9999 = lista.get(0); 	

		EngineModalidade modalidade = new EngineModalidade();

		modalidade.ordernar(lista);

		
		assertTrue(lista.get(9999).getPid()==p9999.getPid());
	}
	@Test
	public void verificarOrdenacaoDe10MilProcessosModalidadeBJF() {
		List<Processo> lista = new ArrayList<Processo>();

		
		for (int i = 9999; i >=0; i--) {
			Processo p1 = getProcesso(i, i, i,Modalidade.SJF);
			lista.add(p1);	
		}
		
		Processo p9999 = lista.get(0); 	

		EngineModalidade modalidade = new EngineModalidade();

		modalidade.ordernar(lista);

		
		assertTrue(lista.get(9999).getPid()==p9999.getPid());
	}
	
	@Test
	public void verificarOrdenacaoDe100MilProcessosModalidadeFIFO() {
		List<Processo> lista = new ArrayList<Processo>();

		
		for (int i = 99999; i >=0; i--) {
			Processo p1 = getProcesso(i, i, i,Modalidade.FIFO);
			lista.add(p1);	
		}
		
		Processo p9999 = lista.get(0); 	

		EngineModalidade modalidade = new EngineModalidade();

		modalidade.ordernar(lista);

		
		assertTrue(lista.get(99999).getPid()==p9999.getPid());
	}	
	
}
