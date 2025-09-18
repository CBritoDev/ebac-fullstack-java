package br.com.carlosbrito.dao;

import br.com.carlosbrito.domain.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
}
