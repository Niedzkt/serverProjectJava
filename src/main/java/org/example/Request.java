package org.example;

import java.io.Serializable;

public class Request implements Serializable {
    private String requestType;
    private Integer userId;
    private Integer idBiletu;
    private String additionalData;
    private String nazwaUzytkownika;
    private String haslo;
    private String email;


    // Konstruktor dla rozkładu jazdy
    public Request(String requestType, Integer userId) {
        this.requestType = requestType;
        this.userId = userId;
        this.idBiletu = null;
    }

    // Konstruktor dla zakupu biletu
    public Request(String requestType, Integer userId, Integer idBiletu) {
        this.requestType = requestType;
        this.userId = userId;
        this.idBiletu = idBiletu;
    }

    // Konstruktor dla zmiany emaila
    public Request(String requestType, Integer userId, String additionalData) {
        this.requestType = requestType;
        this.userId = userId;
        this.additionalData = additionalData;
    }

    // Konstruktor dla rejestracji użytkownika
    public Request(String requestType, String nazwaUzytkownika, String haslo, String email) {
        this.requestType = requestType;
        this.nazwaUzytkownika = nazwaUzytkownika;
        this.haslo = haslo;
        this.email = email;
    }

    // Konstruktor dla logowania
    public Request(String requestType, String email, String haslo) {
        this.requestType = requestType;
        this.email = email;
        this.haslo = haslo;
    }


    public String getRequestType() { return requestType; }
    public Integer getUserId() { return userId; }
    public Integer getIdBiletu() { return idBiletu; }
    public String getAdditionalData() { return additionalData; }
    public String getNazwaUzytkownika() { return nazwaUzytkownika; }
    public String getHaslo() { return haslo; }
    public String getEmail() { return email; }
}
