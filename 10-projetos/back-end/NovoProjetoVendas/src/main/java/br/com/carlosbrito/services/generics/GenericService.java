package br.com.carlosbrito.services.generics;

import br.com.carlosbrito.domain.Persistente;
import br.com.carlosbrito.exception.TipoChaveNaoEncontradaException;
import br.com.carlosbrito.generics.GenericDAO;
import br.com.carlosbrito.generics.IGenericDAO;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author carlos.brito
 * Criado em: 11/09/2025
 */
public class GenericService<T extends Persistente> implements IGenericService<T> {

    private IGenericDAO<T> entityDAO;

    public GenericService(GenericDAO<T> entityDAO) {
        this.entityDAO = entityDAO;
    }

    @Override
    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException {
       return entityDAO.cadastrar(entity);
    }

    @Override
    public Boolean excluir(Long valor) {
        return entityDAO.excluir(valor);
    }

    @Override
    public T consultar(Long id) {
        return entityDAO.consultar(id);
    }

    @Override
    public void alterar(T entity) throws TipoChaveNaoEncontradaException {
        entityDAO.alterar(entity);
    }

    @Override
    public Collection<T> buscarTodos() {
        return entityDAO.buscarTodos();
    }

}
