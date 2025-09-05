package br.com.carlosbrito.exerciciosLambda;

import java.util.ArrayList;
import java.util.List;

/**
 * @author carlos.brito
 * Criado em: 13/08/2025
 */
public class Demo {
    public static void main(String[] args) {

        OperacoesProduto operacoes = new OperacoesProduto();

        List<Produto> produtos = new ArrayList<>();

        Produto produto01 =  new Produto("Shampoo", 24.99);
        Produto produto02 =  new Produto("Sabonete", 2.99);
        Produto produto03 =  new Produto("Creme de pentear", 34.99);
        Produto produto04 =  new Produto("Creme hidratação profunda", 56.99);
        Produto produto05 =  new Produto("Óleo umectante", 77.99);

        produtos.add(produto01);
        produtos.add(produto02);
        produtos.add(produto03);
        produtos.add(produto04);
        produtos.add(produto05);

        System.out.println("-------Teste 01 (Imprimir todos os produtos)-------");
        operacoes.imprimirProdutos(produtos, (produto -> System.out.println(produto)));
        System.out.println("");


        System.out.println("-------Teste 02 (Filtrar apenas produtos acima de 10.00)-------");
        List<Produto> produtosFiltradosAcima10 = operacoes.filtrarProdutos(produtos, ( Produto produto ) -> produto.getPreco() > 10.00);
        operacoes.imprimirProdutos(produtosFiltradosAcima10, (produto -> System.out.println(produto)));
        System.out.println("");

        System.out.println("-------Teste 03 ( Filtrar apenas produtos que começam com C)-------");
        List<Produto> produtosFiltradosStartsWithC = operacoes.filtrarProdutos(produtos, ( Produto produto ) -> produto.getNome().startsWith("C"));
        operacoes.imprimirProdutos(produtosFiltradosStartsWithC, (produto -> System.out.println(produto)));
        System.out.println("");

        System.out.println("-------Teste 04 (Transformar em uma Lista de nomes de produtos)-------");
        List<String> nomesProdutos = operacoes.transformarProdutos(produtos, (Produto produto )-> produto.getNome());
        for(String nome : nomesProdutos){
            System.out.println("Nome produto: " + nome);
        }
        System.out.println("");

        System.out.println("-------Teste 05 (Trasnformar em uma lista de preços de produtos)-------");
        List<Double> precos = operacoes.transformarProdutos(produtos, (Produto produto )-> produto.getPreco());
        for(Double preco : precos){
            System.out.println("Preço: " + preco);
        }

    }
}
