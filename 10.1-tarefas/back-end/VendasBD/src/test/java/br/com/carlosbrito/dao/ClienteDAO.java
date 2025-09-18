package br.com.carlosbrito.dao;

import br.com.carlosbrito.ConnectionFactory;
import br.com.carlosbrito.domain.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author carlos.brito
 * Criado em: 16/09/2025
 */
public class ClienteDAO implements IClienteDAO {
    @Override
    public Integer cadastrar(Cliente cliente) throws Exception {

        String sql = "INSERT INTO tb_cliente (nome, codigo) VALUES (?,?)";


        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement st = connection.prepareStatement(sql)){


            st.setString(1,cliente.getNome());
            st.setString(2,cliente.getCodigo());

             return st.executeUpdate();

        }catch(Exception e){
            throw  new Exception("Não foi possível cadastrar cliente no banco de dados : " + e);
        }

    }

    @Override
    public Cliente buscar(String codigo) throws Exception {

        String sql =  "SELECT * FROM tb_cliente WHERE codigo = ?";
        ResultSet rs;

        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stm = connection.prepareStatement(sql)) {

            stm.setString(1,codigo);
            rs = stm.executeQuery();

            if(rs.next()){
                Cliente clienteBD = new Cliente();
                clienteBD.setId(rs.getLong("ID"));
                clienteBD.setNome(rs.getString("NOME"));
                clienteBD.setCodigo(rs.getString("CODIGO"));
                return clienteBD;
            }

        } catch (SQLException e) {
            throw new Exception("Não foi possível buscar o cliente na base de dados" + e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Integer excluir(String codigo) throws Exception {
        String sql =  "DELETE FROM tb_cliente WHERE CODIGO = ?";

        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stm = connection.prepareStatement(sql)){

            stm.setString(1,codigo);
            return stm.executeUpdate();

        }catch (SQLException e){
            throw new Exception("Não foi possível realizar a exclusão do cliente: " + e);
        }
    }
}
