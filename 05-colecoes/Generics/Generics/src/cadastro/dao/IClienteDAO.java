package br.com.cbritodev.dao;

import br.com.cbritodev.domain.Cliente;

import java.util.Collection;

/**
 * @author carlos.brito
 * Criado em: 19/06/2025
 */
public interface IClienteDAO {

    public Boolean cadastrar(Cliente cliente);

    public void excluir(Long cpf);

    public void alterar(Cliente cliente);

    public Cliente consultar(Long cpf);

    public Collection<Cliente> buscarTodos();
}
