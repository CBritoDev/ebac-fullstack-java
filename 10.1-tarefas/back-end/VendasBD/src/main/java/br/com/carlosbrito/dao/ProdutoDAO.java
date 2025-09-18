package br.com.carlosbrito.dao;

import br.com.carlosbrito.domain.Cliente;
import br.com.carlosbrito.domain.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author carlos.brito
 * Criado em: 18/09/2025
 */
public class ProdutoDAO implements IProdutoDAO {
    @Override
    public Integer cadastrar(Produto produto) throws Exception {
        String sql = "INSERT INTO tb_produto (NOME,CODIGO,VALOR) VALUES (?,?,?)";

        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stm =  connection.prepareStatement(sql)){

            stm.setString(1,produto.getNome());
            stm.setString(2,produto.getCodigo());
            stm.setBigDecimal(3,produto.getValor());

            return stm.executeUpdate();

        }catch (Exception e){
            throw new Exception("Não foi possível cadastrar o produto: " + e);
        }
    }

    @Override
    public Produto buscar(String codigo) throws Exception {
        String sql =  "SELECT * FROM tb_produto WHERE CODIGO = ?";
        ResultSet rs;

        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stm =  connection.prepareStatement(sql)){

            stm.setString(1,codigo);

            rs = stm.executeQuery();

            if(rs.next()){
                Produto produtoRetorno = new Produto();
                produtoRetorno.setId(rs.getLong("ID"));
                produtoRetorno.setNome(rs.getString("NOME"));
                produtoRetorno.setCodigo(rs.getString("CODIGO"));
                produtoRetorno.setValor(rs.getBigDecimal("VALOR"));
                return produtoRetorno;
            }

        }catch (Exception e){
            throw new Exception("Não foi possível buscar o produto: " + e);
        }
        return null;
    }

    @Override
    public Integer excluir(String codigo) throws Exception {
        String sql = "DELETE FROM tb_produto WHERE CODIGO = ?" ;

        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stm = connection.prepareStatement(sql)){

            stm.setString(1,codigo);

            return stm.executeUpdate();

        }catch (SQLException e){
            throw new Exception("Não foi possível realizar a exclusão do cliente: " + e);
        }
    }

    @Override
    public List<Produto> buscarTodos() throws Exception {
        String sql =  "SELECT * FROM tb_produto";
        ResultSet rs;
        List<Produto> listaProdutos =  new ArrayList<>();

        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stm =  connection.prepareStatement(sql)){

            rs = stm.executeQuery();

            while(rs.next()){
                Produto produtoBD = new Produto();
                produtoBD.setId(rs.getLong("ID"));
                produtoBD.setNome(rs.getString("NOME"));
                produtoBD.setCodigo(rs.getString("CODIGO"));
                produtoBD.setValor(rs.getBigDecimal("VALOR"));
                listaProdutos.add(produtoBD);
            }

            return listaProdutos;

        }catch(SQLException e){
            throw new Exception("Não foi possível realizar a busca pelos produtos: " + e);
        }
    }
}
