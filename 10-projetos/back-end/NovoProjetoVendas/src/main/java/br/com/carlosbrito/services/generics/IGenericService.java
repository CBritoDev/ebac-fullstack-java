package br.com.carlosbrito.services.generics;

import br.com.carlosbrito.domain.Persistente;
import br.com.carlosbrito.domain.Produto;
import br.com.carlosbrito.exception.TipoChaveNaoEncontradaException;

import java.util.Collection;
import java.util.Map;

/**
 * @author carlos.brito
 * Criado em: 11/09/2025
 */
public interface IGenericService<T extends Persistente> {

    /**
     * Metodo para cadastrar objeto
     * @param entity Objeto a ser passado para alteracao de dados
     * @return
     *
     */
    Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException;

    Boolean excluir(Long valor);

    T consultar(Long id);

    void alterar(T entity) throws TipoChaveNaoEncontradaException;

    Collection<T> buscarTodos();
}
