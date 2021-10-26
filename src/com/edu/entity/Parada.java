package com.edu.entity;

import java.util.ArrayList;
import java.util.List;

import com.edu.gui.model.ITableModel;

public class Parada implements ITableModel{
 
	private int id;
	
	private int inicioParada;
	 
	private int tempoParada;
	
	@Deprecated
	private boolean check;
	 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getInicioParada() {
		return inicioParada;
	}

	public void setInicioParada(int inicioParada) {
		this.inicioParada = inicioParada;
	}

	public int getTempoParada() {
		return tempoParada;
	}

	public void setTempoParada(int tempoParada) {
		this.tempoParada = tempoParada;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	@Override
	public List<String> getColunasParaTabela() {
		List<String> retornoList = new ArrayList<String>();

		retornoList.add("Id");
		retornoList.add("Inicio da Parada");
		retornoList.add("Tempo da Parada");

		return retornoList;
	}
}
 
