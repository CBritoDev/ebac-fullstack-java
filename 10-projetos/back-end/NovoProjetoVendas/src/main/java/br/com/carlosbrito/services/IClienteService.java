package br.com.carlosbrito.services;

import br.com.carlosbrito.domain.Cliente;
import br.com.carlosbrito.exception.TipoChaveNaoEncontradaException;

/**
 * @author carlos.brito
 * Criado em: 08/09/2025
 */
public interface IClienteService {
    void cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;

    Cliente buscarPorCpf(Long cpf);

    void excluir(Long cpf);

    void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;
}
