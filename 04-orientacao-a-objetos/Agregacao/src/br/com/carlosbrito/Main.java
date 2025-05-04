package br.com.carlosbrito;

import br.com.carlosbrito.agregacao.Comprador;
import br.com.carlosbrito.agregacao.Produto;
import br.com.carlosbrito.agregacao.Venda;
import br.com.carlosbrito.agregacao.Vendedor;

public class Main {
    public static void main(String[] args) {
        Produto produtoTeclado = criarProduto(1L, 10d, "Teclado");
        Produto produtoPC = criarProduto(2L, 100d, "Notebook");


        Vendedor vendedor = criarVendedor("Pedro", 0.1);

        Comprador comprador = criarComprador("João", 150d);

        Venda venda = new Venda();
        venda.setVendedor(vendedor);
        venda.setComprador(comprador);
        venda.add(produtoTeclado);
        venda.add(produtoPC);

        venda.concretizarVenda();

    }

    private static Comprador criarComprador(String nome, Double verba) {
       return new Comprador(nome, verba);
    }

    private static Vendedor criarVendedor(String nome, Double comissao) {
        Vendedor vendedor = new Vendedor();
        vendedor.setNome(nome);
        vendedor.setComissao(comissao);
        return vendedor;
    }

    private static Produto criarProduto(Long codigo, Double valor, String nomeProduto) {
        Produto produto = new Produto();
        produto.setCodigo(codigo);
        produto.setPreco(valor);
        produto.setNome(nomeProduto);
        return produto;
    }
}