package br.com.carlosbrito;

import br.com.carlosbrito.dao.ClienteDAO;
import br.com.carlosbrito.dao.IClienteDAO;
import br.com.carlosbrito.domain.Cliente;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    @Test
    public void deveBuscarClienteBDTest() throws Exception {
        String sql =  "SELECT * FROM tb_cliente WHERE codigo = ?";
        ResultSet rs;
        Integer count = 0;
        IClienteDAO clienteDao =  new ClienteDAO();
        Cliente retorno = new Cliente();
        Cliente cliente =  new Cliente();
        cliente.setNome("Teste 02");
        cliente.setCodigo("0002");

        clienteDao.cadastrar(cliente);

        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stm = connection.prepareStatement(sql)) {

            stm.setString(1,cliente.getCodigo());
            rs = stm.executeQuery();

            if(rs.next()){
                Cliente clienteBD = new Cliente();
                clienteBD.setId(rs.getLong("ID"));
                clienteBD.setNome(rs.getString("NOME"));
                clienteBD.setCodigo(rs.getString("CODIGO"));
                retorno = clienteBD;
            }

        } catch (SQLException e) {
            throw new Exception("Não foi possível buscar o cliente na base de dados" + e);
        }

        Assert.assertEquals(cliente.getNome(),retorno.getNome());
        Assert.assertEquals(cliente.getCodigo(),retorno.getCodigo());
        Assert.assertEquals(cliente.getId(),retorno.getId());




    }


}
