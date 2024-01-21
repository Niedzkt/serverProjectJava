package org.example;

import java.io.Serializable;

public class Request implements Serializable {
    private String requestType;
    private Integer userId;
    private Integer idBiletu; // Dodane dla nowego żądania

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

    // Gettery
    public String getRequestType() { return requestType; }
    public Integer getUserId() { return userId; }
    public Integer getIdBiletu() { return idBiletu; }
}
