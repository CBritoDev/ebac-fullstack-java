package br.com.carlosbrito.generics;

import br.com.carlosbrito.anotation.TipoChave;
import br.com.carlosbrito.dao.SingletonMap;
import br.com.carlosbrito.domain.Persistente;
import br.com.carlosbrito.exception.TipoChaveNaoEncontradaException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author carlos.brito
 * Criado em: 10/09/2025
 */
public abstract class GenericDAO<T extends Persistente> implements IGenericDAO<T> {

    //protected Map<Class, Map<Long, T>> map = new HashMap<>();

    /**
     * Necessário utilizar Singleton para ter apenas um MAP no sistema
     */
    private SingletonMap singletonMap;

    public abstract Class<T> getTipoClasse();

    public abstract void atualizarDados(T entity, T entityCadastrado);

    private Map<Long, T> mapaInterno;

    public GenericDAO() {
        this.singletonMap = SingletonMap.getInstance();
        if(this.singletonMap.getMap().get(getTipoClasse()) == null){
            Map<Long, T> novoMapa =  new HashMap<>();
            this.singletonMap.getMap().put(getTipoClasse(),novoMapa);
        }
        mapaInterno = (Map<Long, T>) this.singletonMap.getMap().get(getTipoClasse());
    }

    public Long getChave(T entity) throws TipoChaveNaoEncontradaException {
        Field[] fields = entity.getClass().getDeclaredFields();
        Long returnValue = null;
        for (Field field : fields) {
            if (field.isAnnotationPresent(TipoChave.class)) {
                TipoChave tipoChave = field.getAnnotation(TipoChave.class);
                String nomeMetodo = tipoChave.value();
                try {
                    Method method = entity.getClass().getMethod(nomeMetodo);
                    returnValue = (Long) method.invoke(entity);
                    return returnValue;
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    //Criar exception de negócio TipoChaveNaoEncontradaException
                    e.printStackTrace();
                    throw new TipoChaveNaoEncontradaException("Chave principal do objeto " + entity.getClass() + " não encontrada", e);
                }
            }
        }
        if (returnValue == null) {
            String msg = "Chave principal do objeto " + entity.getClass() + " não encontrada";
            System.out.println("**** ERRO ****" + msg);
            throw new TipoChaveNaoEncontradaException(msg);
        }
        return null;
    }

    @Override
    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException {
        //Map<Long, T> mapaInterno = this.map.get(getTipoClasse());

        Long chave = getChave(entity);
        if (!mapaInterno.containsKey(chave)) {
            mapaInterno.put(chave, entity);
            return true;
        }else{
            return false;
        }


    }

    @Override
    public Boolean excluir(Long valor) {
        //Map<Long, T> mapaInterno = this.map.get(getTipoClasse());
        T objetoCadastrado = mapaInterno.get(valor);
        if (objetoCadastrado != null) {
            mapaInterno.remove(valor, objetoCadastrado);
            return true;
        }
        return false;
    }

    @Override
    public void alterar(T entity) throws TipoChaveNaoEncontradaException {
        //Map<Long, T> mapaInterno = this.map.get(getTipoClasse());
        Long chave = getChave(entity);
        T objetoCadastrado = mapaInterno.get(chave);
        if (objetoCadastrado != null) {
            mapaInterno.put(chave,entity);
        }
    }

    @Override
    public T consultar(Long valor) {
        //Map<Long, T> mapaInterno = this.map.get(getTipoClasse());
        return mapaInterno.get(valor);
    }

    @Override
    public Collection<T> buscarTodos() {
        return mapaInterno.values();
    }
}
