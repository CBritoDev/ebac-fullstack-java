package br.com.carlosbrito.dao;

import br.com.carlosbrito.domain.Produto;

/**
 * @author carlos.brito
 * Criado em: 18/09/2025
 */
public interface IProdutoDAO {
    Integer cadastrar(Produto produto) throws Exception;

    Produto buscar(String codigo) throws Exception;
}
