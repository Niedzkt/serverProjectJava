package org.example;

import org.example.database.DatabaseManager;
import org.example.server.Server;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args)
    {
        int port = 1234;
        Server server = new Server(port);
        try {
            DatabaseManager dbManager = new DatabaseManager("jdbc:oracle:thin:@192.168.1.21:1521:XE", "busstopdb", "busstoppass");

            // Przykład użycia
            ResultSet rs = dbManager.executeQuery("SELECT * FROM bilety");
            while (rs.next()) {
                System.out.println(rs.getString("id_biletu"));
            }
            rs.close();

            dbManager.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        server.start();
    }

}
