package br.com.carlosbrito.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author carlos.brito
 * Criado em: 06/12/2025
 */
public interface IGenericDAO<T> extends Serializable {

     T cadastrar(T entity) throws Exception;

     T consultarPorId(long id) throws Exception;

     long excluir(long id) throws Exception;

     List<T> buscarTodos() throws Exception;

     T alterar(T entity) throws Exception;
}
