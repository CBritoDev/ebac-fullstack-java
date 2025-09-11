package br.com.carlosbrito.generics;

import br.com.carlosbrito.dao.ProdutoDAOMock;
import br.com.carlosbrito.dao.SingletonMap;
import br.com.carlosbrito.domain.Produto;
import br.com.carlosbrito.exception.TipoChaveNaoEncontradaException;
import br.com.carlosbrito.services.generics.GenericService;
import br.com.carlosbrito.services.generics.IGenericService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * @author carlos.brito
 * Criado em: 11/09/2025
 */
public class ServiceProdutoTest {

    private BigDecimal valorProduto = BigDecimal.valueOf(20.00);
    private Produto produto =  new Produto(2l, "Cerveja", valorProduto);
    private Produto produto2 =  new Produto(2l,"Refrigerante", BigDecimal.valueOf(14.00));
    private Produto produto3 =  new Produto(3l,"Refrigerante", BigDecimal.valueOf(14.00));
    ProdutoDAOMock produtoDAO =  new ProdutoDAOMock();
    IGenericService genericService = new GenericService(produtoDAO);

    public ServiceProdutoTest(){

    }

    @Before
    public void reiniciaSingleton(){
        SingletonMap.getInstance().clear();
    }

    @Test
    public void deveCadastrarProduto() throws TipoChaveNaoEncontradaException {
        Boolean resposta = genericService.cadastrar(produto);
        Assert.assertTrue(resposta);
    }

    @Test
    public void deveExcluirProduto() throws TipoChaveNaoEncontradaException {
        genericService.cadastrar(produto);
        Boolean resposta = genericService.excluir(produto.getId());
        Assert.assertTrue(resposta);
    }

    @Test
    public void deveConsultarERetornarProduto() throws TipoChaveNaoEncontradaException {
        genericService.cadastrar(produto);
        Produto produtoRetorno = (Produto) genericService.consultar(produto.getId());
        Assert.assertEquals("Deve ser o mesmo produto", produto,produtoRetorno);
    }


    @Test
    public void deveAlterarProduto() throws TipoChaveNaoEncontradaException{
        genericService.cadastrar(produto);
        genericService.alterar(produto2);
        Produto produtoRetorno =  (Produto) genericService.consultar(produto.getId());
        Assert.assertEquals("Produto deve conter novos dados", produto2, produtoRetorno);
    }

    @Test
    public void deveRetornarMapaDeProdutos() throws TipoChaveNaoEncontradaException {
        genericService.cadastrar(produto);
        genericService.cadastrar(produto3);
        Collection<Produto> mapaProdutos =  genericService.buscarTodos();
        mapaProdutos.forEach(System.out::println);
        Assert.assertNotNull(mapaProdutos);
    }


}
