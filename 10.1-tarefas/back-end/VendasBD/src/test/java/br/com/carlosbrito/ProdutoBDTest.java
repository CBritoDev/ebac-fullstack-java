package br.com.carlosbrito;

import br.com.carlosbrito.dao.ConnectionFactory;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author carlos.brito
 * Criado em: 18/09/2025
 */
public class ProdutoBDTest {

    @Test
    public void deveCadastrarProduto() throws Exception {
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

}
