package com.edu.entity;

import java.util.ArrayList;
import java.util.List;

import com.edu.gui.model.ITableModel;

public class Aplicativo implements ITableModel{

	private int id;
	private int qtdProcessos;
	private int intervaloDeChegada;
	private int tempoDeProcessamento;
	private int chegadaAplicativo;
	
	private Modalidade modalidade;
	
	private String nome;
	private Estado estado;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getChegadaAplicativo() {
		return chegadaAplicativo;
	}
	
	public void setChegadaAplicativo(int chegadaAplicativo) {
		this.chegadaAplicativo = chegadaAplicativo;
	}
	
	public int getIntervaloDeChegada() {
		return intervaloDeChegada;
	}
	
	public void setIntervaloDeChegada(int intervaloDeChegada) {
		this.intervaloDeChegada = intervaloDeChegada;
	}
	
	public int getTempoDeProcessamento() {
		return tempoDeProcessamento;
	}
	
	public void setTempoDeProcessamento(int tempoDeProcessamento) {
		this.tempoDeProcessamento = tempoDeProcessamento;
	}
	
	public int getQtdProcessos() {
		return qtdProcessos;
	}
	
	public void setQtdProcessos(int qtdProcessos) {
		this.qtdProcessos = qtdProcessos;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Estado getEstado() {
		return estado;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
//	Retorna lista de processo atraves das configuracoes
//	do aplicativo
	public List<Processo> getListaProcessos(){
		List<Processo> lista = new ArrayList<Processo>();
		Processo p;
		
		if (getQtdProcessos() > 0){
			for (int i = 0; i < getQtdProcessos(); i++) {
				if (i == 0 )
				{
					p = new Processo();
					p.setPid(0);
					p.setChegada(getChegadaAplicativo());
					p.setTempoProcessamento(getTempoDeProcessamento());
					p.setModalidade(getModalidade());
					p.setEstado(getEstado());
					p.setAplicativo(getId() + "-" + this.getNome());
				}
				else
				{
					p = new Processo();
					p.setPid(0);
					p.setChegada(lista.get(i-1).getChegada() + getIntervaloDeChegada());
					p.setTempoProcessamento(getTempoDeProcessamento());
					p.setModalidade(getModalidade());
					p.setEstado(getEstado());
					p.setAplicativo(getId() + "-" + this.getNome());
				}
				lista.add(p);
			}
		}
		else
			return null;
		
		return lista;
	}
	
	public Modalidade getModalidade() {
		return modalidade;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}
	
	@Override
	public List<String> getColunasParaTabela() {
		List<String> retornoList = new ArrayList<String>();

		retornoList.add("pid");
		retornoList.add("Nome");
		retornoList.add("Chegada do Aplicativo");
		retornoList.add("Qtde de Processos");
		retornoList.add("Tempo Processamento");
		retornoList.add("Intervalo de Chegada");
		retornoList.add("Modalidade");

		return retornoList;
	}
}
