package com.edu.entity;

import java.util.List;

public class Engine {

	public List<Processo> ordenar(List<Processo> lista)
	{
		int inicio = 0;
		int fim;
		Modalidade mod = null;

		if (lista.size() > 1)
		{
			for (int i = 0; i < lista.size(); i++) {
				//iniciando a lista
				if (i == 0)
				{
					mod = lista.get(i).getModalidade();
				}
				else
				{
					//se o mod do current for diferente do anterior
					if ((!mod.equals(lista.get(i).getModalidade()) || (i+1 == lista.size())))
					{
						if (i+1 == lista.size())
							fim = i;
						else
							fim = i-1;
						
						if (fim > inicio)
						{
							if (mod.equals(Modalidade.FIFO))
								lista = ordenarFIFO(lista, inicio, fim);
							else if (mod.equals(Modalidade.BJF))
								lista = ordenarBJF(lista, inicio, fim);
							else
								lista = ordenarSJF(lista, inicio, fim);
						}

						//faz as configuracoes iniciais para nova verificao
						mod = lista.get(i).getModalidade();
						inicio = i;
					}
				}
			}
			return lista;
		}
		else
			return lista;
	}

	public List<Processo> ordenarFIFO(List<Processo> lista, final int inicio, final int fim)
	{
		if (inicio == fim)
		{
			return lista;
		}
		else
		{
			//ordena o lista atrav�s do PID - bubbleSort
			boolean trocou;
			do
			{
				trocou = false;
				for (int i = inicio; i < fim; i++) {
					if (lista.get(i).getPid() > lista.get(i+1).getPid())
					{
						lista = swapProcesso(lista, i, i+1);
						trocou = true;
					}
				}
			}while(trocou);

			return lista;
		}

	}

	public List<Processo> ordenarSJF(List<Processo> lista, final int inicio, final int fim)
	{
		if (lista.size() == 1)
		{
			return lista;
		}
		else
		{
			//ordena o lista atrav�s do listaoProcessamento - bubbleSort
			boolean trocou;
			do
			{
				trocou = false;
				for (int i = inicio; i < fim; i++) {
					if (lista.get(i).getTempoProcessamento() > lista.get(i+1).getTempoProcessamento())
					{
						lista = swapProcesso(lista, i, i+1);
						trocou = true;
					}
				}
			}while(trocou);

			return lista;
		}

	}

	public List<Processo> ordenarBJF(List<Processo> lista, final int inicio, final int fim)
	{
		if (lista.size() == 1)
		{
			return lista;
		}
		else
		{
			//ordena o lista atrav�s do listaoProcessamento - bubbleSort
			boolean trocou;
			do
			{
				trocou = false;
				for (int i = inicio; i < fim; i++) {
					if (lista.get(i).getTempoProcessamento() < lista.get(i+1).getTempoProcessamento())
					{
						lista = swapProcesso(lista, i, i+1);
						trocou = true;
					}
				}
			}while(trocou);

			return lista;
		}

	}

	public List<Processo> swapProcesso (List<Processo> lista, int p1, int p2)
	{
		//		System.out.println("tamanho da lista=" + lista + " p1=" + p1 + " p2=" + p2);
		Processo aux = lista.get(p1);
		lista.set(p1, lista.get(p2));
		lista.set(p2, aux);
		return lista;
	}
	
//	public List<Processo> setarTempoDeEspera(Fila fila, ListaParadas listaParadas){
//		
//	}
	
}

