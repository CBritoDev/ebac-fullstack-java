package br.com.carlosbrito.exerciciosLambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author carlos.brito
 * Criado em: 13/08/2025
 */
public class OperacoesProduto {
    public void imprimirProdutos(List<Produto> produtos, Consumer<Produto>  acao){
        for(Produto produto: produtos){
            acao.accept(produto);
        }
    }

    public List<Produto>  filtrarProdutos(List<Produto> produtos, Predicate<Produto> condicao){
        List<Produto> produtosFiltrados =  new ArrayList<>();
        for(Produto produto : produtos){
            if(condicao.test(produto)){
                produtosFiltrados.add(produto);
            }
        }
        return produtosFiltrados;
    }

    public <R> List<R> transformarProdutos(List<Produto> produtos, Function<Produto, R> transformacao){
        List<R> produtosTransformados = new ArrayList<>();
        for(Produto produto : produtos){
            produtosTransformados.add(transformacao.apply(produto));
        }

        return  produtosTransformados;
    }

}
