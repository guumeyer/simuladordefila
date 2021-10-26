/**
 * 
 */
package com.edu.relatorio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.edu.entity.Processo;
import com.edu.relatorio.ordernacao.TempoEsperaComparator;
import com.edu.util.Estatistica;

/**
 * @author gustavo
 * 
 */
public class Relatorio {

	private String getStringProcesso(Processo processo){
		
		return "Aplicativo= " + processo.getAplicativo()
		+ " - pID= " + processo.getPid() +

		" - Tempo Espera= " + processo.getTempoEspera();
	}
	
	private List<String> getTempoDePermanenciaDoProcessoNaFila(
			List<Processo> listaProcesso) {
		List<String> listaResultado = new ArrayList<String>();

		for (Processo processo : listaProcesso) {
			listaResultado.add(getStringProcesso(processo));
		}

		return listaResultado;

	}
	
	private String getMaiorTempoEspera(List<Processo> listaProcesso){
		return getStringProcesso(listaProcesso.get(listaProcesso.size()-1));
	}
	
	private List<Double> getArrayTempoEspera(List<Processo> listaProcesso){
		List<Double> array = new ArrayList<Double>();
		
		for (Processo processo : listaProcesso) {
			array.add(Double.parseDouble(String.valueOf(processo.getTempoEspera())));
		}
		return array;
	}

	private String getMenorTempoEspera(List<Processo> listaProcesso){
		return getStringProcesso(listaProcesso.get(0));
	}
	
	
	private List<String> getRelatorio(List<Processo> listaProcesso){
		List<String> resultado = new ArrayList<String>();
		
		Estatistica estatistica = new Estatistica();
		estatistica.setArray(getArrayTempoEspera(listaProcesso));
		
		resultado.add("Menor Tempo de Espera");
		resultado.add(getMenorTempoEspera(listaProcesso));
		resultado.add("----------------------------------------------");
		resultado.add("Maior Tempo de Espera");
		resultado.add(getMaiorTempoEspera(listaProcesso));
		resultado.add("----------------------------------------------");
		resultado.add("Desvio Padrao");
		resultado.add(estatistica.getStringDesvioPadrao());
		return resultado;		
		
	}
	
	private String imprimir(List<String> linhas){
		String texto = "";
		for (String linha : linhas) {
			texto += linha + "\n";
		}
		return texto;
	}
	
	public String gerarRelatorio(List<Processo> listaProcesso) {

		List<String> relatorio = getRelatorio(listaProcesso);
		return imprimir(relatorio);
		
	}
	
	private void ordenarProcessosPorTempoEspera(List<Processo> listaProcesso){
		Collections.sort(listaProcesso,new TempoEsperaComparator());
	}
	
	
	

}
