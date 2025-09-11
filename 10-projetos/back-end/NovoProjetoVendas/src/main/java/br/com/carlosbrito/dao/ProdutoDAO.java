package br.com.carlosbrito.dao;

import br.com.carlosbrito.domain.Persistente;
import br.com.carlosbrito.domain.Produto;
import br.com.carlosbrito.exception.TipoChaveNaoEncontradaException;
import br.com.carlosbrito.generics.GenericDAO;
import br.com.carlosbrito.generics.IGenericDAO;

/**
 * @author carlos.brito
 * Criado em: 11/09/2025
 */
public class ProdutoDAO extends GenericDAO<Produto> implements IProdutoDAO {

    public ProdutoDAO(){
        super();
    }


    @Override
    public Class<Produto> getTipoClasse() {
        return null;
    }

    @Override
    public void atualizarDados(Produto entity, Produto entityCadastrado) {

    }
}
