package br.com.tahnous.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static Connection connection;

    private ConnectionFactory(Connection connection) {

    }

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = initConnection();
        } else if (connection.isClosed()) {
            connection = initConnection();
        }
        return connection;
    }

    private static Connection initConnection() {
            try {
                return DriverManager.getConnection(
                        "jdbc:postgresql://127.0.0.1:5432/mydb", "postgres", "admin");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }
}
