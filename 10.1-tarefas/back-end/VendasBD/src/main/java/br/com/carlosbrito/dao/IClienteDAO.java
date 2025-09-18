package br.com.carlosbrito.dao;

import br.com.carlosbrito.domain.Cliente;

import java.util.List;

/**
 * @author carlos.brito
 * Criado em: 16/09/2025
 */
public interface IClienteDAO {
    Integer cadastrar(Cliente cliente) throws Exception;

    Cliente buscar(String codigo) throws Exception;

    Integer excluir(String codigo) throws Exception;

    List<Cliente> buscarTodos() throws Exception;
}
