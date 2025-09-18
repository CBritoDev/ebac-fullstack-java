package br.com.carlosbrito.dao;

import br.com.carlosbrito.dao.ConnectionFactory;
import br.com.carlosbrito.domain.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author carlos.brito
 * Criado em: 16/09/2025
 */
public class ClienteDAO implements IClienteDAO {

    /**
     * Realiza o cadastro de um novo cliente no Banco de Dados
     *
     * @param cliente Objeto cliente com os dados a serem cadastrados
     * @return Retorna 1 em caso de sucesso, 0 em caso de falha no cadastro
     * @throws Exception Em caso de erro ao comunicar com o Banco de dados
     */
    @Override
    public Integer cadastrar(Cliente cliente) throws Exception {

        // Define a instrução SQL com placeholders para evitar SQL Injection.
        String sql = "INSERT INTO tb_cliente (nome, codigo) VALUES (?,?)";

        //Usa o try-with_resources para realizar operação com bd e fechar a conexão
        //de forma automática.
        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement st = connection.prepareStatement(sql)){


            st.setString(1,cliente.getNome());
            st.setString(2,cliente.getCodigo());

             return st.executeUpdate();

        }catch(Exception e){
            //Lança exceção com erro original.
            throw  new Exception("Não foi possível cadastrar cliente no banco de dados : " + e);
        }

    }

    /**
     * Realiza a busca de cliente no Banco de Dados
     *
     * @param codigo Valor para a busca de cliente no bd
     * @return Retorna o cliente com codigo correspondente
     * @throws Exception Em caso de erro ao comunicar com o Banco de dados
     */
    @Override
    public Cliente buscar(String codigo) throws Exception {

        String sql =  "SELECT * FROM tb_cliente WHERE codigo = ?";
        ResultSet rs;

        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stm = connection.prepareStatement(sql)) {

            stm.setString(1,codigo);
            rs = stm.executeQuery();

            //confere se o resultado da query possui um objeto e o seta como cliente
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

    /**
     * Exclui cliente do Banco de dados
     *
     * @param codigo Valor para a busca e exclusao de cliente no bd
     * @return Retorna 1 em sucesso na exclusão, 0 para falha
     * @throws Exception Em caso de erro ao comunicar com o Banco de dados
     */
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


    /**
     * Busca todos os clientes do Banco de Dados
     *
     * @return Retorna lista com clientes encontrados
     * @throws Exception Em caso de erro ao comunicar com o Banco de dados
     */
    @Override
    public List<Cliente> buscarTodos() throws Exception {
        String sql =  "SELECT * FROM tb_cliente";
        ResultSet rs;
        List<Cliente> listaClientes = new ArrayList<>();

        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stm =  connection.prepareStatement(sql)){

            rs = stm.executeQuery();

            //enquanto rs tiver mais de um objeto, cada um deles será setado como cliente
            //e adicionado a lista para retorno
            while(rs.next()){
                Cliente clienteBD = new Cliente();
                clienteBD.setNome(rs.getString("NOME"));
                clienteBD.setCodigo(rs.getString("CODIGO"));
                clienteBD.setId(rs.getLong("ID"));
                listaClientes.add(clienteBD);
            }

            return listaClientes;

        }catch(SQLException e){
            throw new Exception("Não foi possível realizar a busca pelos clientes: " + e);
        }

    }

}
