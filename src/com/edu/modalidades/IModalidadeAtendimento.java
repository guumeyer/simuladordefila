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
public interface IModalidadeAtendimento {
	
	public List<Processo> ordernar(List<Processo> lista); 

}
