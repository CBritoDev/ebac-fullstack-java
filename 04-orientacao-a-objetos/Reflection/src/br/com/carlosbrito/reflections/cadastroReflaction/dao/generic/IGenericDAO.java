package cadastro.dao.generic;

import cadastro.domain.IPersistente;
import cadastro.domain.Produto;

import java.util.Collection;

/**
 * @author carlos.brito
 * Criado em: 24/07/2025
 */
//Aqui temos uma restrição. Toda T que for se beneficiar de IGenericDAO deve ser
// uma IPersistente, ou seja, retornar um getCodigo()
public interface IGenericDAO<T extends IPersistente> {
    public Boolean cadastrar(T entity);

    public void excluir(Long key);

    public void alterar(T entity);

    public T consultar(Long key);

    public Collection<T> buscarTodos();
}
