package br.com.carlosbrito.dao.generic.jdbc.dao;

import br.com.carlosbrito.dao.generic.jdbc.ConnectionFactory;
import br.com.carlosbrito.domain.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static br.com.carlosbrito.dao.generic.jdbc.ConnectionFactory.initConnection;

/**
 * @author carlos.brito
 * Criado em: 15/09/2025
 */
public class ClienteDAO implements IClienteDAO{

    @Override
    public Integer cadastrar(Cliente cliente) throws Exception {

        Connection connection = null;
        //comando a ser executado no bando de dados
        PreparedStatement stm = null;

        try{
            connection = ConnectionFactory.getConnection();
            String sql = getSqlInsert();
            stm = connection.prepareStatement(sql);
            adicionarParametrosInsert(stm,cliente);

            return stm.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Erro ao cadastrar o cliente no banco de dados.", e);
        }finally {
            closeConnection(connection,stm,null);
        }
    }



    @Override
    public Integer atualizar(Cliente cliente) throws Exception {

        Connection connection = null;
        PreparedStatement stm =  null;

        try{
            connection = ConnectionFactory.getConnection();
            String sql = getSqlUpdate();
            stm = connection.prepareStatement(sql);
            adicionarParametrosUpdate(stm,cliente);
            return stm.executeUpdate();

        }catch (SQLException e1) {
            throw new Exception("Erro ao atualizar o cliente no banco de dados.", e1);
        }finally {
            closeConnection(connection,stm,null);
        }
    }

    @Override
    public Cliente buscar(String codigo) throws Exception {
        Connection connection = null;
        PreparedStatement stm =  null;
        ResultSet rs = null;
        Cliente cliente = null;

        try{
            connection = ConnectionFactory.getConnection();
            String sql = getSqlSelect();
            stm = connection.prepareStatement(sql);
            adicionarParametrosSelect(stm,codigo);
            rs = stm.executeQuery();

            if(rs.next()){
                cliente =  new Cliente();
                Long id = rs.getLong("ID");
                String nome =  rs.getString("NOME");
                String cd =  rs.getString("CODIGO");
                cliente.setId(id);
                cliente.setNome(nome);
                cliente.setCodigo(cd);
            }

        }catch (SQLException e2) {

            throw new Exception("Erro ao buscar o cliente no banco de dados.", e2);

        }finally {
            closeConnection(connection,stm,rs);
        }
        return cliente;
    }

    @Override
    public List<Cliente> buscarTodos() throws Exception {
        Connection connection = null;
        PreparedStatement stm =  null;
        ResultSet rs =  null;
        List<Cliente> list = new ArrayList<>();
        Cliente cliente =  null;

        try{
            connection = ConnectionFactory.getConnection();
            String sql = getSqlSelectAll();
            stm  = connection.prepareStatement(sql);
            rs = stm.executeQuery();

            while(rs.next()){
                cliente =  new Cliente();
                Long id = rs.getLong("ID");
                String nome =  rs.getString("NOME");
                String cd =  rs.getString("CODIGO");
                cliente.setId(id);
                cliente.setNome(nome);
                cliente.setCodigo(cd);
                list.add(cliente);

            }

        }catch (SQLException e3) {
            throw new Exception("Erro ao buscar clientes no banco de dados.", e3);
        }finally {
            closeConnection(connection,stm,rs);
        }
        return list;
    }

    @Override
    public Integer excluir(Cliente cliente) throws Exception {
        Connection connection = null;
        PreparedStatement stm =  null;

        try{
            connection = ConnectionFactory.getConnection();
            String sql = getSqlDelete();
            stm = connection.prepareStatement(sql);
            adicionarParametrosDelete(stm, cliente);
            return stm.executeUpdate();

        }catch (SQLException e4){
            throw new Exception("Erro ao atualizar o cliente no banco de dados.", e4);
        }finally {
            closeConnection(connection,stm,null);
        }

    }

    private String getSqlInsert(){
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO tb_cliente (CODIGO,NOME)");
        sb.append(" VALUES (?,?)");
        return sb.toString();
    }

    private void adicionarParametrosInsert(PreparedStatement stm, Cliente cliente) throws SQLException {
        stm.setString(1,cliente.getCodigo());
        stm.setString(2,cliente.getNome());
    }

    private String getSqlUpdate(){
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE tb_cliente");
        sb.append(" SET nome = ?, CODIGO = ?");
        sb.append(" WHERE id = ?");
        return sb.toString();
    }

    private void adicionarParametrosUpdate(PreparedStatement stm, Cliente cliente) throws SQLException{
        stm.setString(1, cliente.getNome());
        stm.setString(2, cliente.getCodigo());
        stm.setLong(3,cliente.getId());
    }

    private String getSqlDelete(){
        StringBuilder sb =  new StringBuilder();
        sb.append("DELETE FROM tb_cliente");
        sb.append(" WHERE codigo = ?");
        return sb.toString();
    }

    private void adicionarParametrosDelete(PreparedStatement stm, Cliente cliente) throws SQLException{
        stm.setString(1, cliente.getCodigo());
    }

    private String getSqlSelect(){
        StringBuilder sb =  new StringBuilder();
        sb.append("SELECT * FROM tb_cliente");
        sb.append(" WHERE CODIGO = ?");
        return sb.toString();
    }

    private void adicionarParametrosSelect(PreparedStatement stm,String codigo) throws SQLException{
        stm.setString(1, codigo);
    }

    private String getSqlSelectAll(){
        String select = "SELECT * FROM tb_cliente";
        return select;
    }


    private void closeConnection(Connection connection, PreparedStatement stm, ResultSet rs) {
        try{
            if(rs != null && !rs.isClosed()){
                rs.close();;
            }
            if(stm != null && !stm.isClosed()){
                stm.close();
            }
            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        } catch (SQLException e5) {
            e5.printStackTrace();
        }
    }


}
