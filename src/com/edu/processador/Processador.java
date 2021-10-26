package com.edu.processador;

import java.util.ArrayList;
import java.util.List;

import com.edu.entity.Aplicativo;
import com.edu.entity.Parada;
import com.edu.entity.Processo;

public class Processador {
 
	private boolean salvamentoContexto;
	 
	private int inicioAtendimento;
	 
	private List<Aplicativo> listaAplicativos;
	
	private List<Parada> listaParadas;
	
	public List<Parada> getListaParadas() {
		return listaParadas;
	}

	public void setListaParadas(List<Parada> listaParadas) {
		this.listaParadas = listaParadas;
	}

	public List<Aplicativo> getListaAplicativos() {
		return listaAplicativos;
	}

	public Processador(){
		listaParadas = new ArrayList<Parada>();
		listaAplicativos = new ArrayList<Aplicativo>();
	}

	public boolean isSalvamentoContexto() {
		return salvamentoContexto;
	}

	public void setSalvamentoContexto(boolean salvamentoContexto) {
		this.salvamentoContexto = salvamentoContexto;
	}

	public int getInicioAtendimento() {
		return inicioAtendimento;
	}

	public void setInicioAtendimento(int inicioAtendimento) {
		this.inicioAtendimento = inicioAtendimento;
	}

	public void setListaAplicativos(List<Aplicativo> listaAplicativos) {
		this.listaAplicativos = listaAplicativos;
	}
	
	public List<Processo> iniciarAtendimento(){
		EngineProcessador engine = new EngineProcessador();
		
		//implementar o salvamento de contexto
		return engine.processarFila(engine.gerarFila(getListaAplicativos()), getListaParadas(), this);
	}
}
 
