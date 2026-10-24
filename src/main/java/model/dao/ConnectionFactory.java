package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/information_schema", "root", "root");
        } catch (ClassNotFoundException e) {
            throw new SQLException("ConnectionFactory: Driver não encontrado", e);
        }
    }
}
