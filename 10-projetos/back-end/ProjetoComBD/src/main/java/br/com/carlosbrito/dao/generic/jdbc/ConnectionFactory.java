package br.com.carlosbrito.dao.generic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author carlos.brito
 * Criado em: 15/09/2025
 */
public class ConnectionFactory {

    private static Connection connection;

    private ConnectionFactory(Connection connection){

    }

    public static Connection getConnection() throws SQLException {
        if(connection == null){
            connection = initConnection();
        } else if(connection != null && connection.isClosed()){

            connection =  initConnection();
        }
        return connection;
    }

    public static Connection initConnection(){
        try{
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/projetoVendaBD","postgres","CBritoDev2025!");

        }catch(SQLException e){
            throw  new RuntimeException(e);
        }
    }

}
