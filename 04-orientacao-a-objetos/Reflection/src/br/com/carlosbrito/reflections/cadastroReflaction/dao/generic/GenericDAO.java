package cadastro.dao.generic;

import cadastro.domain.IPersistente;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author carlos.brito
 * Criado em: 24/07/2025
 */
public abstract class GenericDAO<T extends IPersistente> implements IGenericDAO<T>{

    //O mapa aninhado que vimos: Chave é o tipo da Classe, Valor é outro Mapa (ID, Entidade T)
    protected Map<Class,Map<Long, T>> map;
    protected Map<Long, T> innerMapCache;
    public abstract void atualizarDados(T entity, T entityCadastrado);

    //Metodo abstrato que as subclasses DEVERÃO implementar
    //para dizer qual é o tipo concreto de 'T' para aquele DAO.
    public abstract Class<T> getClassType();

    public GenericDAO(){

        this.map = new HashMap<>();// Inicializa o mapa principal
        // Pega o mapa interno para o tipo de entidade específico desta subclasse (via getClassType())
        this.innerMapCache = this.map.get(getClassType());
        if(innerMapCache == null){// Se ainda não existe um mapa para esse tipo de entidade...
            innerMapCache = new HashMap<>();//...cria um novo mapa interno
            this.map.put(getClassType(), innerMapCache);}// ...e adiciona ao mapa principal
    }
        /***
         *
         * @param
         * @return a new entity
         */
    @Override
     public Boolean cadastrar(T entity) {
            // Pega o mapa interno específico para o tipo da entidade 'T' (ex: Cliente.class)
            if(innerMapCache.containsKey(entity.getCodigo())) {
                return false;
            }
            innerMapCache.put(entity.getCodigo(), entity);
            return true;
    }

    /***
     * Exclude T entity
     * @param
     */
    @Override
    public void excluir(Long key) {
        innerMapCache.remove(key);
    }

    /***
     * Changes object fields
     * @param
     */
    @Override
    public void alterar(T entity) {
        T entityReference = consultar(entity.getCodigo());

        if(entityReference == null){
            System.out.println("Dados não fornecidos para a alteração.");
            return;
        }
        atualizarDados(entity, entityReference);
    }

    /***
     *
     * @param
     * @return entity
     */
    @Override
    public T consultar(Long key) {
        return innerMapCache.get(key);
    }

    /***
     *
     * @return Collection of T entitys
     */
    @Override
    public Collection<T> buscarTodos() {
        return innerMapCache.values();
    }
}
