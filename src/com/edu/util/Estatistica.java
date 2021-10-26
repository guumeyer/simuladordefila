package com.edu.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Estatistica {

	private List<Double> array;

	public Estatistica(){
		array = new ArrayList<Double>();
	}
	// Coeficiente de Varia��o de Pearson
	public double getPearson() {
		return (getDesvioPadrao() / getMediaAritmetica()) * 100;
	}

	public double getMediaAritmetica() {
		double total = 0;
		for (int counter = 0; counter < array.size(); counter++)
			total += array.get(counter);
		return total / array.size();
	}

	public double getSomaDosElementos() {
		double total = 0;
		for (int counter = 0; counter < array.size(); counter++)
			total += array.get(counter);
		return total;
	}

	public double getSomaDosElementosAoQuadrado() {
		double total = 0;
		for (int counter = 0; counter < array.size(); counter++)
			total += Math.pow(array.get(counter), 2);
		return total;
	}

	public static double getMediaAritmetica(List<Double> array) {
		double total = 0;
		for (int counter = 0; counter < array.size(); counter++)
			total += array.get(counter);
		return total / array.size();
	}

	public static double getSomaDosElementos(List<Double> array) {
		double total = 0;
		for (int counter = 0; counter < array.size(); counter++)
			total += array.get(counter);
		return total;
	}
	@Deprecated
	public void ordenar() {
		//            Arrays.sort(array);
	}

	public void imprimeArray() {
		System.out.print("\nElementos do Array: ");
		for (int count = 0; count < array.size(); count++)
			System.out.print(array.get(count) + " ");
	}

	// Array n�o pode conter valores duplicados
	public int buscaPor(int value) {
		return array.indexOf(value);
	}

	// Vari�ncia Amostral
	public double getVariancia() {
		double p1 = 1 / Double.valueOf(array.size() - 1);
		double p2 = getSomaDosElementosAoQuadrado()
		- (Math.pow(getSomaDosElementos(), 2) / Double
				.valueOf(array.size()));
		return p1 * p2;
	}

	// Desvio Padr�o Amostral
	public double getDesvioPadrao() {
		return Math.sqrt(getVariancia());
	}

	// Retornar o Desvio padrao em String com 2 digitos apos a virgula
	public String getStringDesvioPadrao(){
		String desvioPadrao = String.valueOf(Math.sqrt(getVariancia()));
		return desvioPadrao;
	}

	public double getMediana() {
		this.ordenar();
		int tipo = array.size() % 2;
		if (tipo == 1) {
			return array.get(((array.size() + 1) / 2) - 1);
		} else {
			int m = array.size() / 2;
			return (array.get(m - 1) + array.get(m)) / 2;
		}
	}

	public double getModa() {

		HashMap map = new HashMap();
		Integer i;
		Double moda = 0.0;
		Integer numAtual, numMaior = 0;
		for (int count = 0; count < array.size(); count++) {
			i = (Integer) map.get(new Double(array.get(count)));

			if (i == null) {
				map.put(new Double(array.get(count)), new Integer(1));
			} else {
				map.put(new Double(array.get(count)), new Integer(i.intValue() + 1));
				numAtual = i.intValue() + 1;
				if (numAtual > numMaior) {
					numMaior = numAtual;
					moda = new Double(array.get(count));

				}

			}
		}
		// System.out.print("\n Eis o mapa: "+map.toString());
		return moda;
	}

	public double getCoefAssimetria() {
		return (getMediaAritmetica() - getModa()) / getDesvioPadrao();
	}

	public List<Double> getArray() {
		return array;
	}

	public void setArray(List<Double> array) {
		this.array = array;
	}
}