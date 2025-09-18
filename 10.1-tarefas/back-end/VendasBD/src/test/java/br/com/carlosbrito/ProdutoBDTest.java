package br.com.carlosbrito;

import br.com.carlosbrito.dao.ConnectionFactory;
import br.com.carlosbrito.dao.IProdutoDAO;
import br.com.carlosbrito.dao.ProdutoDAO;
import br.com.carlosbrito.domain.Cliente;
import br.com.carlosbrito.domain.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author carlos.brito
 * Criado em: 18/09/2025
 */
public class ProdutoBDTest {

    @Test
    public void deveCadastrarProdutoBD() throws Exception {
        String sql = "INSERT INTO tb_produto (NOME,CODIGO,VALOR) VALUES (?,?,?)";
        Integer count = 0;

        Produto produto =  new Produto();
        produto.setNome("Refrigerante");
        produto.setCodigo("ABCD");
        produto.setValor(BigDecimal.valueOf(9.90));

        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stm =  connection.prepareStatement(sql)){

            stm.setString(1,produto.getNome());
            stm.setString(2,produto.getCodigo());
            stm.setBigDecimal(3,produto.getValor());

            count = stm.executeUpdate();

        }catch (Exception e){
            throw new Exception("Não foi possível cadastrar o produto: " + e);
        }

        Assert.assertTrue(count == 1);
    }

    @Test
    public void deveBuscarProdutoBD() throws Exception {
        String sql = "SELECT * FROM tb_produto WHERE CODIGO = ?";
        Integer count = 0;
        ResultSet rs;
        IProdutoDAO produtoDAO =  new ProdutoDAO();
        Produto produtoRetorno = new Produto();

        Produto produto =  new Produto();
        produto.setNome("Refrigerante");
        produto.setCodigo("ABCD");
        produto.setValor(BigDecimal.valueOf(9.90));

        count  = produtoDAO.cadastrar(produto);
        Assert.assertTrue(count == 1);

        try(Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stm =  connection.prepareStatement(sql)){

            stm.setString(1,produto.getCodigo());

            rs = stm.executeQuery();

            if(rs.next()){
                produtoRetorno.setId(rs.getLong("ID"));
                produtoRetorno.setNome(rs.getString("NOME"));
                produtoRetorno.setCodigo(rs.getString("CODIGO"));
                produtoRetorno.setValor(rs.getBigDecimal("VALOR"));
            }

        }catch (Exception e){
            throw new Exception("Não foi possível buscar o produto: " + e);
        }

        Assert.assertEquals(produto.getNome(), produtoRetorno.getNome());
        Assert.assertEquals(produto.getCodigo(), produtoRetorno.getCodigo());
        Assert.assertEquals(produto.getValor(), produtoRetorno.getValor().stripTrailingZeros());

    }

    @Test
    public void deveExcluirProdutoBD() throws Exception {
        String sql = "DELETE FROM tb_produto WHERE CODIGO = ?";
        Integer count = 0;

        IProdutoDAO produtoDAO = new ProdutoDAO();
        Produto produto =  new Produto();
        produto.setNome("Refrigerante");
        produto.setCodigo("ABCD");
        produto.setValor(BigDecimal.valueOf(9.90));


        count = produtoDAO.cadastrar(produto);
        Assert.assertTrue(count == 1);

        Produto produtoBD = produtoDAO.buscar(produto.getCodigo());
        Assert.assertNotNull(produtoBD);

        Assert.assertEquals(produto.getNome(),produtoBD.getNome());
        Assert.assertEquals(produto.getCodigo(),produtoBD.getCodigo());
        Assert.assertEquals(produto.getValor(),produtoBD.getValor().stripTrailingZeros());


        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stm = connection.prepareStatement(sql)){

            stm.setString(1,produtoBD.getCodigo());
            count = stm.executeUpdate();

        }catch (SQLException e){
            throw new Exception("Não foi possível realizar a exclusão do cliente: " + e);
        }

        Assert.assertTrue(count == 1);

    }

}
