package br.com.carlosbrito.dao.generic.jdbc.dao;

import br.com.carlosbrito.domain.Cliente;

import java.util.List;

/**
 * @author carlos.brito
 * Criado em: 15/09/2025
 */
public interface IClienteDAO {

    public Integer cadastrar(Cliente cliente) throws  Exception;

    public Integer atualizar(Cliente cliente)  throws  Exception;

    public Cliente buscar(String codigo) throws Exception;

    public List<Cliente> buscarTodos() throws Exception;

    public Integer excluir(Cliente cliente) throws Exception;
}
