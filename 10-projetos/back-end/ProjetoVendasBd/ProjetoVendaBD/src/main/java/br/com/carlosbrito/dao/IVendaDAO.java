/**
 * 
 */
package br.com.carlosbrito.dao;

import br.com.carlosbrito.dao.generic.IGenericDAO;
import br.com.carlosbrito.domain.Venda;
import br.com.carlosbrito.exceptions.DAOException;
import br.com.carlosbrito.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author carlos.brito
 *
 */
public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}
