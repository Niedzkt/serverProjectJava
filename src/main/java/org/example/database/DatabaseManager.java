package org.example.database;

import java.sql.*;

public class DatabaseManager {
    private Connection connection;

    public DatabaseManager(String dbURL, String user, String password) throws SQLException {
        this.connection = DriverManager.getConnection(dbURL, user, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement stmt = connection.createStatement();
        return stmt.executeQuery(query);
    }

    public int executeUpdate(String query) throws SQLException {
        Statement stmt = connection.createStatement();
        return stmt.executeUpdate(query);
    }

    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
