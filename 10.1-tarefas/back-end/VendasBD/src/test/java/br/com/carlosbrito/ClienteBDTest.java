package br.com.carlosbrito;

import br.com.carlosbrito.dao.ClienteDAO;
import br.com.carlosbrito.dao.ConnectionFactory;
import br.com.carlosbrito.dao.IClienteDAO;
import br.com.carlosbrito.domain.Cliente;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author carlos.brito
 * Criado em: 16/09/2025
 */
public class ClienteBDTest {

    IClienteDAO clienteDao;

    public ClienteBDTest(){
        clienteDao = new ClienteDAO();
    }

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

        Cliente clienteBD =  clienteDao.buscar(cliente01.getCodigo());
        Assert.assertNotNull(clienteBD);

        Assert.assertEquals(cliente01.getNome(),clienteBD.getNome());
        Assert.assertEquals(cliente01.getCodigo(),clienteBD.getCodigo());

        count = clienteDao.excluir(clienteBD.getCodigo());
        Assert.assertTrue(count == 1);
    }

    @Test
    public void deveBuscarClienteBDTest() throws Exception {
        String sql =  "SELECT * FROM tb_cliente WHERE codigo = ?";
        ResultSet rs;
        Integer count = 0;
        Cliente retorno = new Cliente();
        Cliente cliente =  new Cliente();
        cliente.setNome("Teste 02");
        cliente.setCodigo("0002");

       count= clienteDao.cadastrar(cliente);
       Assert.assertTrue(count == 1);

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

        count =  clienteDao.excluir(retorno.getCodigo());
        Assert.assertTrue(count == 1);

    }

    @Test
    public void deveExcluirClienteTest() throws Exception {

        String sql = "DELETE FROM tb_cliente WHERE CODIGO = ?";
        Cliente cliente = new Cliente();
        cliente.setCodigo("0003");
        cliente.setNome("Teste 03");
        Integer count = 0;

        count = clienteDao.cadastrar(cliente);
        Assert.assertTrue(count == 1);

        Cliente clienteBD = clienteDao.buscar(cliente.getCodigo());
        Assert.assertNotNull(clienteBD);

        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stm = connection.prepareStatement(sql)){

            stm.setString(1,clienteBD.getCodigo());
            count = stm.executeUpdate();

        }catch (SQLException e){
            throw new Exception("Não foi possível realizar a exclusão do cliente: " + e);
        }

        Assert.assertTrue(count == 1);

    }

    @Test
    public void deveAtualizarClienteBDTest() throws Exception {
        String sql = "UPDATE tb_cliente SET nome = ?, codigo = ? WHERE id = ?";
        Integer count = 0;

        //Cliente 01
        Cliente cliente = new Cliente();
        cliente.setCodigo("0003");
        cliente.setNome("Teste 03");

        //Cliente02 para atualização de dados
        Cliente cliente2 = new Cliente();
        cliente2.setCodigo("0004");
        cliente2.setNome("Teste 04");


        count = clienteDao.cadastrar(cliente);
        Assert.assertTrue(count == 1);

        Cliente clienteBD = clienteDao.buscar(cliente.getCodigo());
        Assert.assertNotNull(clienteBD);

        Assert.assertEquals(cliente.getNome(),clienteBD.getNome());
        Assert.assertEquals(cliente.getCodigo(),clienteBD.getCodigo());

        try(Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stm =  connection.prepareStatement(sql)){

            stm.setString(1,cliente2.getNome());
            stm.setString(2,cliente2.getCodigo());
            stm.setLong(3,clienteBD.getId());

            count = stm.executeUpdate();

        }catch(SQLException e){
            throw new Exception("Não foi possível atualizar os dados do cliente: " + e);
        }

        Assert.assertTrue(count == 1);

        Cliente clienteUpdate = clienteDao.buscar(cliente2.getCodigo());
        Assert.assertNotNull(clienteUpdate);

        Assert.assertEquals(cliente2.getNome(),clienteUpdate.getNome());
        Assert.assertEquals(cliente2.getCodigo(),clienteUpdate.getCodigo());
        Assert.assertEquals(clienteBD.getId(),clienteUpdate.getId());

        count  = clienteDao.excluir(clienteUpdate.getCodigo());
        Assert.assertTrue(count == 1);


    }

    @Test
    public void deveRetornarListaClientes() throws Exception {
        String sql = "SELECT * FROM tb_cliente";
        Integer count = 0;
        ResultSet rs;
        List<Cliente> listaClientes =  new ArrayList<>();
        List<Cliente> listaComparacao =  new ArrayList<>();

        //Cliente 01
        Cliente cliente = new Cliente();
        cliente.setCodigo("0005");
        cliente.setNome("Teste 05");

        //Cliente02
        Cliente cliente2 = new Cliente();
        cliente2.setCodigo("00015");
        cliente2.setNome("Teste 15");

        listaComparacao = Arrays.asList(cliente,cliente2);

        count = clienteDao.cadastrar(cliente);
        Assert.assertTrue(count ==  1);
        count = clienteDao.cadastrar(cliente2);
        Assert.assertTrue(count ==  1);

        try(Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stm =  connection.prepareStatement(sql)){

            rs = stm.executeQuery();

            while(rs.next()){
                Cliente clienteBD = new Cliente();
                clienteBD.setNome(rs.getString("NOME"));
                clienteBD.setCodigo(rs.getString("CODIGO"));
                clienteBD.setId(rs.getLong("ID"));
                listaClientes.add(clienteBD);
            }

        }catch(SQLException e){
            throw new Exception("Não foi possível realizar a busca pelos clientes: " + e);
        }

        Assert.assertNotNull(listaClientes);
        Assert.assertEquals(cliente.getNome(),listaClientes.get(0).getNome());
        Assert.assertEquals(cliente.getCodigo(),listaClientes.get(0).getCodigo());
        Assert.assertEquals(cliente2.getNome(),listaClientes.get(1).getNome());
        Assert.assertEquals(cliente2.getCodigo(),listaClientes.get(1).getCodigo());

        count = 0;
        for(Cliente one : listaClientes){
            clienteDao.excluir(one.getCodigo());
            count++;
        }

        Assert.assertTrue(count == listaComparacao.size());
    }

}
