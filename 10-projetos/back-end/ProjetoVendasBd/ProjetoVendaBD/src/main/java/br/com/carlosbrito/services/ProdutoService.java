/**
 * 
 */
package br.com.carlosbrito.services;

import br.com.carlosbrito.dao.IProdutoDAO;
import br.com.carlosbrito.domain.Produto;
import br.com.carlosbrito.services.generic.GenericService;

/**
 * @author carlos.brito
 *
 */
public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}
