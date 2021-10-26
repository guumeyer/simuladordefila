package com.edu.modalidades;

import java.util.Collections;
import java.util.List;

import com.edu.entity.Processo;
import com.edu.modalidades.ordenacao.GenericComparable;
/**
 * @author gustavo
 *
 */
public class ModalidadeGenerica implements IModalidadeAtendimento {

	@Override
	public List<Processo> ordernar(List<Processo> lista) {
		Collections.sort(lista,new GenericComparable());
		return lista;
	}
	
}
