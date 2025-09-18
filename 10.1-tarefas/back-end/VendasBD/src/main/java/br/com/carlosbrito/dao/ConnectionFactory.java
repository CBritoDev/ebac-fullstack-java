package br.com.carlosbrito.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author carlos.brito
 * Criado em: 16/09/2025
 */
public class ConnectionFactory {

    private static Connection connection;
    
    private ConnectionFactory(Connection connection){

    }

    public static Connection getConnection() throws Exception {
        if(connection == null){
            connection = initConnection();
        }else if(connection != null || connection.isClosed()){
            connection = initConnection();
        }
        return connection;
    }

    public static Connection initConnection() throws Exception {
        try{
           return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/vendasBd","postgres","CBritoDev2025!");
        }catch (SQLException e){
            throw new Exception("Não foi possível realizar a conexão com o Banco de Dados " + e);
        }
    }


}
