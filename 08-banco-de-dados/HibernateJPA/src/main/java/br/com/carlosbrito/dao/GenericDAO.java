package br.com.carlosbrito.dao;

import br.com.carlosbrito.jpa.JPAUtil;
import com.sun.javafx.binding.StringFormatter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * @author carlos.brito
 * Criado em: 06/12/2025
 */
public abstract class GenericDAO<T extends Serializable> implements IGenericDAO<T>{

    private Class<T> entityClass;
    private String nomeEntidade;

    @SuppressWarnings("unchecked")
    public GenericDAO(){
        ParameterizedType genericSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperClass.getActualTypeArguments()[0];
        this.nomeEntidade = entityClass.getSimpleName();
    }

    protected EntityManager getEntityManager(){
        EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
        return entityManagerFactory.createEntityManager();
    }

    @Override
    public T cadastrar(T entity) throws Exception {
        EntityManager entityManager = getEntityManager();

        try{
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();

        } catch (Exception e) {

            if(entityManager != null && entityManager.isOpen()){
                entityManager.getTransaction().rollback();
            }

            throw new Exception(String.format("Erro ao persistir %s: ",nomeEntidade) + e.getMessage());
        }
        finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }

        return entity;
    }

    @Override
    public T consultarPorId(long id) throws Exception {
        EntityManager entityManager = getEntityManager();
        T entity = null;
        try{
            entity = (T) entityManager.find(entityClass, id);

        } catch (Exception e) {
            throw new Exception(String.format("Erro ao consultar %s por ID: ",nomeEntidade) + e.getMessage());
        }
        finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }

        return entity;
    }

    @Override
    public long excluir(long id) throws Exception {
        EntityManager entityManager = getEntityManager();
        T entityToRemove = null;

        try{

            entityManager.getTransaction().begin();
            entityToRemove = entityManager.find(entityClass,id);

            if(entityToRemove != null){
                entityManager.remove(entityToRemove);
            }

            entityManager.getTransaction().commit();

        } catch (Exception e) {
            if(entityManager != null && entityManager.isOpen()){
                entityManager.getTransaction().rollback();
            }

            throw new Exception(String.format("Erro ao excluir %s: ",nomeEntidade) + e.getMessage());
        }
        finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }

        return 1;
    }

    @Override
    public List<T> buscarTodos() throws Exception {

        EntityManager entityManager = getEntityManager();
        List<T> listaEntidade = new ArrayList<>();

        try {

            String jpql = String.format("SELECT e FROM %s e", nomeEntidade);

            listaEntidade = entityManager.createQuery(jpql, entityClass)
                    .getResultList();
            return listaEntidade;

        } catch (Exception e) {
            throw new Exception(String.format("Erro ao buscar todas as %ss: ", nomeEntidade) + e.getMessage());
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }

    @Override
    public T alterar(T entity) throws Exception {
        EntityManager entityManager = getEntityManager();

        try{

            entityManager.getTransaction().begin();
            entity = entityManager.merge(entity);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            if(entityManager != null && entityManager.isOpen()){
                entityManager.getTransaction().rollback();
            }

            throw new Exception(String.format("Erro ao atualizar %s: ",nomeEntidade) + e.getMessage());
        }
        finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
        return entity;
    }


}
