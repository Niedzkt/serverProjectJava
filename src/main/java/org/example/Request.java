package org.example;

import java.io.Serializable;

public class Request implements Serializable {
    private String requestType;
    private Integer userId;
    private Integer idBiletu;
    private String additionalData;


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

    public String getRequestType() { return requestType; }
    public Integer getUserId() { return userId; }
    public Integer getIdBiletu() { return idBiletu; }
    public String getAdditionalData() { return additionalData; }
}
