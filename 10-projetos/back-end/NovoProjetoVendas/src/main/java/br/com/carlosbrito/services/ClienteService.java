package br.com.carlosbrito.services;

import br.com.carlosbrito.dao.ClienteDAO;
import br.com.carlosbrito.dao.IClienteDAO;
import br.com.carlosbrito.domain.Cliente;
import br.com.carlosbrito.exception.TipoChaveNaoEncontradaException;

/**
 * @author carlos.brito
 * Criado em: 08/09/2025
 */
public class ClienteService implements IClienteService {

    private IClienteDAO clienteDAO;

    public ClienteService(IClienteDAO clienteDAO){
        this.clienteDAO = clienteDAO;
    }

    @Override
    public void cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException {
        clienteDAO.cadastrar(cliente);
    }

    @Override
    public Cliente buscarPorCpf(Long cpf) {
        return clienteDAO.consultar(cpf);
    }

    @Override
    public void excluir(Long cpf) {
        clienteDAO.excluir(cpf);
    }

    @Override
    public void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException {
        clienteDAO.cadastrar(cliente);
    }
}
