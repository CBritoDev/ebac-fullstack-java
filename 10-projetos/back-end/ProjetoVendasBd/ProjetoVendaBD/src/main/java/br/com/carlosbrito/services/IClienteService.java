/**
 * 
 */
package br.com.carlosbrito.services;

import br.com.carlosbrito.domain.Cliente;
import br.com.carlosbrito.exceptions.DAOException;
import br.com.carlosbrito.services.generic.IGenericService;

/**
 * @author carlos.brito
 *
 */
public interface IClienteService extends IGenericService<Cliente, Long> {

//	Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;
//
	Cliente buscarPorCPF(Long cpf) throws DAOException;
//
//	void excluir(Long cpf);
//
//	void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}
