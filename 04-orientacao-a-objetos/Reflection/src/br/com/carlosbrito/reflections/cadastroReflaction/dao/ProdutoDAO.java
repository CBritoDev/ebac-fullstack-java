package cadastro.dao;

import cadastro.dao.generic.GenericDAO;
import cadastro.domain.Produto;

import java.util.Collection;
import java.util.List;

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
        entityCadastrado.setCodigo(entity.getCodigo());
    }

    @Override
    public Class<Produto> getClassType() {
        return Produto.class;
    }

}
