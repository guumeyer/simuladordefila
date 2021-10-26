/**
 * 
 */
package com.edu.modalidades;

import java.util.List;

import com.edu.entity.Processo;

/**
 * @author gustavo
 * 
 */
public class EngineModalidade {

	private IModalidadeAtendimento getModalidade() {
		return new ModalidadeGenerica();
	}

	public List<Processo> ordernar(List<Processo> processos) {
		return getModalidade().ordernar(processos);

	}

}
