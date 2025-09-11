package br.com.carlosbrito.dao;

import br.com.carlosbrito.domain.Produto;
import br.com.carlosbrito.exception.TipoChaveNaoEncontradaException;
import br.com.carlosbrito.generics.GenericDAO;

import java.util.Collection;
import java.util.List;

/**
 * @author carlos.brito
 * Criado em: 11/09/2025
 */
public class ProdutoDAOMock extends GenericDAO<Produto> implements IProdutoDAO {

    public ProdutoDAOMock(){
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
