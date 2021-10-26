package com.edu.entity;

import java.util.ArrayList;
import java.util.List;

import com.edu.gui.model.ITableModel;

public class Processo implements ITableModel{

	private int pid;
	private int chegada;
	private int tempoEspera;
	private int inicioAtendimento;
	private int tempoProcessamento;
	private int terminoAtendimento;

	private String aplicativo;

	private Modalidade modalidade;

	private Estado estado;

	public String getAplicativo(){
		return aplicativo;
	}

	public void setAplicativo(String aplicativo){
		this.aplicativo = aplicativo;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public Modalidade getModalidade() {
		return this.modalidade;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}

	public int getChegada() {
		return chegada;
	}

	public void setChegada(int chegada) {
		this.chegada = chegada;
	}

	public int getInicioAtendimento() {
		return inicioAtendimento;
	}

	public void setInicioAtendimento(int inicioAtendimento) {
		//Calcula o tempo de espera do processo na fila
		this.inicioAtendimento = inicioAtendimento;
		this.tempoEspera = this.inicioAtendimento - this.chegada;	
	}

	public int getTerminoAtendimento() {
		return terminoAtendimento;
	}

	public void setTerminoAtendimento(int terminoAtendimento) {
		this.terminoAtendimento = terminoAtendimento;
	}

	public int getTempoEspera() {
		return tempoEspera;
	}

	public int getTempoProcessamento() {
		return tempoProcessamento;
	}
	
	public void setTempoEspera(int tempoEspera) {
		this.tempoEspera = tempoEspera;
	}

	public void setTempoProcessamento(int tempoProcessamento) {
		this.tempoProcessamento = tempoProcessamento;
	}

	@Override
	public List<String> getColunasParaTabela() {
		List<String> retornoList = new ArrayList<String>();

		retornoList.add("pid");
		retornoList.add("Chegada");
		retornoList.add("Tempo Processamento");
		retornoList.add("Tempo Espera");
		retornoList.add("Inicio Atendimento");
		retornoList.add("Termino Atendimento");
		retornoList.add("Modalidade");
		retornoList.add("Aplicativo");

		return retornoList;
	}
	
	public String toString(){
		return "pID= " + getPid() +
				" - chegada= " + getChegada() +
				" - Tempo Processamento= " + getTempoProcessamento() +
				" - Tempo Espera= " + getTempoEspera() +
				" - Inicio Atendimento= " + getInicioAtendimento() +
				" - Termino Atendimento= " + getTerminoAtendimento() +
				" - Modalidade= " + getModalidade() +
				" - Aplicativo= " + getAplicativo();
	}

}

