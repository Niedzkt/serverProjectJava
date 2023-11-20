package org.example.database;

import java.sql.*;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/databasetest";
    private static final String USER = "root";
    private static final String PASSWORD = "";


    public static void initializeDatabase(){
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            String sqlCreateUserTable = "CREATE TABLE IF NOT EXISTS uzytkownicy (" +
                    "id_uzytkownik INT AUTO_INCREMENT PRIMARY KEY," +
                    "nazwa_uzytkownika VARCHAR(50)," +
                    "email VARCHAR(100)," +
                    "haslo VARCHAR(255)," +
                    "data_rejestracji DATETIME," +
                    "rola VARCHAR(20)," +
                    ")";
            statement.executeUpdate(sqlCreateUserTable);

            String sqlCreateBusesTable = "CREATE TABLE IF NOT EXISTS linie_autobusowe (" +
                    "id_linii INT AUTO_INCREMENT PRIMARY KEY," +
                    "nazwa_linii VARCHAR(50)," +
                    "opis TEXT," +
                    ")";
            statement.executeUpdate(sqlCreateBusesTable);

            String sqlCreateBusStopTable = "CREATE TABLE IF NOT EXISTS przystanki (" +
                    "id_przystanku INT AUTO_INCREMENT PRIMARY KEY," +
                    "nazwa_przystanku VARCHAR(100)," +
                    "lokalizacja VARCHAR(255)," +
                    ")";
            statement.executeUpdate(sqlCreateBusStopTable);

            String sqlCreateScheduleTable = "CREATE TABLE IF NOT EXISTS rozklad_jazdy (" +
                    "id_rozkladu INT AUTO_INCREMENT PRIMARY KEY," +
                    "id_linii INT," +
                    "id_przystanku INT," +
                    "czas_odjazdu TIME," +
                    ")";
            statement.executeUpdate(sqlCreateScheduleTable);

            String sqlCreateRoutesTable = "CREATE TABLE IF NOT EXISTS trasy (" +
                    "id_trasy INT AUTO_INCREMENT PRIMARY KEY," +
                    "id_linii INT," +
                    "nazwa_trasy VARCHAR(100)," +
                    ")";
            statement.executeUpdate(sqlCreateRoutesTable);

            String sqlCreateRoutesBusStopTable = "CREATE TABLE IF NOT EXISTS trasa_przystanek (" +
                    "id_trasy_przystanku INT AUTO_INCREMENT PRIMARY KEY," +
                    "id_trasy INT," +
                    "id_przystanku INT," +
                    "kolejnosc INT," +
                    ")";
            statement.executeUpdate(sqlCreateRoutesBusStopTable);

            String sqlCreateTicketTable = "CREATE TABLE IF NOT EXISTS bilety (" +
                    "id_biletu INT AUTO_INCREMENT PRIMARY KEY," +
                    "id_uzytkownika INT," +
                    "id_rozkladu INT," +
                    "data_waznosci DATETIME," +
                    "cena DECIMAL(10,2)," +
                    ")";
            statement.executeUpdate(sqlCreateTicketTable);

            String sqlCreateHistoryTable = "CREATE TABLE IF NOT EXISTS historia_zakupu (" +
                    "id_zakupu INT AUTO_INCREMENT PRIMARY KEY," +
                    "id_uzytkownika INT," +
                    "id_biletu INT," +
                    "data_zakupu DATETIME," +
                    "metoda_platnosci VARCHAR(50)," +
                    ")";
            statement.executeUpdate(sqlCreateHistoryTable);

            //String sqlInsertData = "INSERT INTO przykladowa_tabela (nazwa, wartosc) VALUES ('Przykład', 100)";
            //statement.executeUpdate(sqlInsertData);

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
