/**
 * 
 */
package br.com.carlosbrito.services;

import br.com.carlosbrito.dao.IClienteDAO;
import br.com.carlosbrito.domain.Cliente;
import br.com.carlosbrito.exceptions.DAOException;
import br.com.carlosbrito.exceptions.MaisDeUmRegistroException;
import br.com.carlosbrito.exceptions.TableException;
import br.com.carlosbrito.services.generic.GenericService;

/**
 * @author carlos.brito
 *
 */
public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {
	
	//private IClienteDAO clienteDAO;
	
	public ClienteService(IClienteDAO clienteDAO) {
		super(clienteDAO);
		//this.clienteDAO = clienteDAO;
	}

//	@Override
//	public Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException {
//		return clienteDAO.cadastrar(cliente);
//	}

	@Override
	public Cliente buscarPorCPF(Long cpf) throws DAOException {
		try {
			return this.dao.consultar(cpf);
		} catch (MaisDeUmRegistroException | TableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

//	@Override
//	public void excluir(Long cpf) {
//		clienteDAO.excluir(cpf);
//	}
//
//	@Override
//	public void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException{
//		clienteDAO.alterar(cliente);
//	}

}
