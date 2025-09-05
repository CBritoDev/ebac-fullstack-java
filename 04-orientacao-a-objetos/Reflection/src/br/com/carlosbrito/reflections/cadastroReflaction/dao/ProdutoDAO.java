package br.com.carlosbrito.reflections.cadastroReflaction.dao;


import br.com.carlosbrito.reflections.cadastroReflaction.dao.generic.GenericDAO;
import br.com.carlosbrito.reflections.cadastroReflaction.domain.Produto;

/**
 * @author carlos.brito
 * Criado em: 24/07/2025
 */
public class ProdutoDAO extends GenericDAO<Produto> implements IProdutoDAO{

    public ProdutoDAO(){
        super();
    }

    @Override
    public void atualizarDados(Produto entity, Produto entityCadastrado) {
        entityCadastrado.setNome(entity.getNome());
        entityCadastrado.setValor(entity.getValor());
    }

    @Override
    public Class<Produto> getClassType() {
        return Produto.class;
    }

}
