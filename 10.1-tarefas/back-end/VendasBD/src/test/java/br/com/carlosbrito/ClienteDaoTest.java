package br.com.carlosbrito;

import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author carlos.brito
 * Criado em: 16/09/2025
 */
public class ClienteDaoTest {

    @Test
    public void deveCadastrarClienteTest(){
        String sql =  "INSERT INTO tb_cliente (nome, codigo) VALUES (?,?)";
        Integer count = 0;

        Cliente cliente01 = new Cliente();
        cliente.setNome("Teste 01");
        cliente.setCodigo("0001");

        try(Connection connection = ConnectionFactory.getConnection;
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
