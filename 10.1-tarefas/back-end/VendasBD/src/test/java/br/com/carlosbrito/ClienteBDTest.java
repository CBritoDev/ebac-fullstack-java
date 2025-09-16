package br.com.carlosbrito;

import br.com.carlosbrito.domain.Cliente;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author carlos.brito
 * Criado em: 16/09/2025
 */
public class ClienteBDTest {

    @Test
    public void deveCadastrarClienteTest() throws Exception {
        String sql =  "INSERT INTO tb_cliente (nome, codigo) VALUES (?,?)";
        Integer count = 0;

        Cliente cliente01 = new Cliente();
        cliente01.setNome("Teste 01");
        cliente01.setCodigo("0001");

        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement st = connection.prepareStatement(sql)){


            st.setString(1,cliente01.getNome());
            st.setString(2,cliente01.getCodigo());

            count = st.executeUpdate();

        }catch(SQLException e){
            throw  new Exception("Não foi possível cadastrar cliente no banco de dados : " + e);
        }

        Assert.assertTrue(count == 1);


    }


}
