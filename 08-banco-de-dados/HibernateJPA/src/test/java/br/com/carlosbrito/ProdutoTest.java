package br.com.carlosbrito;

import br.com.carlosbrito.dao.IProdutoDAO;
import br.com.carlosbrito.dao.ProdutoDAO;
import br.com.carlosbrito.domain.Matricula;
import br.com.carlosbrito.domain.Produto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

/**
 * @author carlos.brito
 * Criado em: 06/12/2025
 */
public class ProdutoTest {

    private static Produto produto;
    private IProdutoDAO produtoDAO;

    public ProdutoTest(){
        this.produtoDAO =  new ProdutoDAO();
    }

    @BeforeEach
    public void criarProduto(){
        produto =  new Produto();
        produto.setNome("Refrigerante");
        produto.setCodigo("L12N75");
        produto.setCategoria("Bebidas");
        produto.setValor(BigDecimal.valueOf(12.99));
    }

    @Test
    public void cadastrar() throws Exception {
        Produto produto01 = produtoDAO.cadastrar(produto);
        Assertions.assertNotNull(produto01);
        Assertions.assertNotNull(produto01.getId());
    }

    @Test
    public void consultarPorId() throws Exception{
        Produto produto01 = produtoDAO.cadastrar(produto);
        Produto matriculaRetorno = null;
        matriculaRetorno = produtoDAO.consultarPorId(produto01.getId());

        Assertions.assertNotNull(produto01);
        Assertions.assertEquals(produto01.getId(), matriculaRetorno.getId());
    }

    @Test
    public void excluir() throws Exception{
        Produto produto01 = produtoDAO.cadastrar(produto);

        Produto retorno = produtoDAO.consultarPorId(produto01.getId());

        long excluiu = produtoDAO.excluir(produto01.getId());

        Assertions.assertEquals(1, excluiu);
    }


    @Test
    public void buscarTodos() throws Exception {
        Produto produto02 =  new Produto();
        produto02.setCodigo("abcde01");
        produto02.setCategoria("Comida");
        produto02.setNome("Agua");
        produto02.setValor(BigDecimal.valueOf(9.99));

        Produto produto01 = produtoDAO.cadastrar(produto);
        produto02 = produtoDAO.cadastrar(produto02);

        Assertions.assertNotNull(produto01.getId());
        Assertions.assertNotNull(produto02.getId());

        List<Produto> listaProdutos = produtoDAO.buscarTodos();

        Assertions.assertNotNull(listaProdutos);
        Assertions.assertTrue(listaProdutos.size() >= 2,
                "O método buscarTodos() não retornou pelo menos 2 matriculas.");

        for(Produto c : listaProdutos){
            produtoDAO.excluir(c.getId());
        }

    }

    @Test
    public void alterar() throws Exception{
        Produto produto02 =  new Produto();
        produto02.setCodigo("abcde01");
        produto02.setCategoria("Comida");
        produto02.setNome("Agua");
        produto02.setValor(BigDecimal.valueOf(9.99));

        produto02 = produtoDAO.cadastrar(produto02);

        produto02.setCodigo("Renomeado");

        Produto retorno = produtoDAO.alterar(produto02);

        Produto produtoRetorno = produtoDAO.consultarPorId(produto02.getId());

        Assertions.assertNotNull(produtoRetorno, "Não deve ser nulo");
        Assertions.assertEquals("Renomeado", produtoRetorno.getCodigo());

        produtoDAO.excluir(produtoRetorno.getId());
        Assertions.assertNull(produtoDAO.consultarPorId(produtoRetorno.getId()));
    }
}
