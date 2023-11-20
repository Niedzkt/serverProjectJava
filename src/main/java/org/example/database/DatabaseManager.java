package org.example.database;

import java.sql.*;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/databasetest";
    private static final String USER = "root";
    private static final String PASSWORD = "";


    public static void initializeDatabase(){
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            String sqlCreateTable = "CREATE TABLE IF NOT EXISTS przykladowa_tabela (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "nazwa VARCHAR(50)," +
                    "wartosc INT)";
            statement.executeUpdate(sqlCreateTable);

            String sqlInsertData = "INSERT INTO przykladowa_tabela (nazwa, wartosc) VALUES ('Przykład', 100)";
            statement.executeUpdate(sqlInsertData);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void checkData(){
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {

            String sqlQuery = "SELECT * FROM przykladowa_tabela";
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nazwa = resultSet.getString("nazwa");
                int wartosc = resultSet.getInt("wartosc");
                System.out.println("ID: " + id + ", Nazwa: " + nazwa + ", Wartość: " + wartosc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }

}
