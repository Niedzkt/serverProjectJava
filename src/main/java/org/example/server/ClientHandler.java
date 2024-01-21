package org.example.server;

import oracle.jdbc.internal.OracleTypes;
import org.example.*;
import org.example.database.DatabaseManager;

import java.io.*;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket socket){
        this.clientSocket = socket;
    }

    private List<RozkladJazdy> convertResultSet(ResultSet rs) throws SQLException {
        List<RozkladJazdy> list = new ArrayList<>();
        while (rs.next()) {
            RozkladJazdy obj = new RozkladJazdy(
                    rs.getString("nazwa_linii"),
                    rs.getString("opis")
            );
            list.add(obj);
        }
        return list;
    }

    private List<InformacjeOBilecie> convertInformacjeOBilecieResultSet(ResultSet rs) throws SQLException {
        List<InformacjeOBilecie> list = new ArrayList<>();
        while (rs.next()) {
            InformacjeOBilecie obj = new InformacjeOBilecie(
                    rs.getTimestamp("data_zakupu"),
                    rs.getTimestamp("data_waznosci"),
                    rs.getDouble("cena")
            );
            list.add(obj);
        }
        return list;
    }


    @Override
    public void run() {
        try (ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
             ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream())) {

            Object request = in.readObject();

            if (request instanceof Request) {
                Request req = (Request) request;

                try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.21:1521:XE", "busstopdb", "busstoppass")) {
                    if ("rozklad jazdy".equals(req.getRequestType())) {
                        try (CallableStatement cstmt = conn.prepareCall("{call pobierz_wszystkie_linie(?)}")) {
                            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
                            cstmt.execute();

                            try (ResultSet rs = (ResultSet) cstmt.getObject(1)) {
                                List<RozkladJazdy> list = convertResultSet(rs);
                                out.writeObject(list);
                            }
                        }
                    }

                    if ("pobierz historie zakupow".equals(req.getRequestType())) {
                        try (CallableStatement cstmt = conn.prepareCall("{call pobierz_historie_i_bilety_uzytkownika(?, ?)}")) {
                            cstmt.setInt(1, req.getUserId());
                            cstmt.registerOutParameter(2, OracleTypes.CURSOR);
                            cstmt.execute();

                            try (ResultSet rs = (ResultSet) cstmt.getObject(2)) {
                                List<InformacjeOBilecie> list = convertInformacjeOBilecieResultSet(rs);
                                out.writeObject(list);
                            }
                        }
                    }

                    if ("pobierz linie autobusowe".equals(req.getRequestType())) {
                        try (CallableStatement cstmt = conn.prepareCall("{call pobierz_linie_autobusowe(?)}")) {
                            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
                            cstmt.execute();

                            try (ResultSet rs = (ResultSet) cstmt.getObject(1)) {
                                List<RozkladJazdy> list = convertResultSet(rs);
                                out.writeObject(list);
                            }
                        }
                    }

                    if ("pobierz przystanki".equals(req.getRequestType())) {
                        try (CallableStatement cstmt = conn.prepareCall("{call pobierz_przystanki(?)}")) {
                            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
                            cstmt.execute();

                            try (ResultSet rs = (ResultSet) cstmt.getObject(1)) {
                                List<PrzystanekAutobusowy> list = new ArrayList<>();
                                while (rs.next()) {
                                    list.add(new PrzystanekAutobusowy(rs.getString("nazwa_przystanku"), rs.getString("lokalizacja")));
                                }
                                out.writeObject(list);
                            }
                        }
                    }


                }
            }
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
