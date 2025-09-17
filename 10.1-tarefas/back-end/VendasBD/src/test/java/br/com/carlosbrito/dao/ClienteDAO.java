package br.com.carlosbrito.dao;

import br.com.carlosbrito.ConnectionFactory;
import br.com.carlosbrito.domain.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
