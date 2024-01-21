package org.example;

import java.io.Serializable;

public class PrzystanekAutobusowy implements Serializable {
    private String nazwaPrzystanku;
    private String lokalizacja;

    public PrzystanekAutobusowy(String nazwaPrzystanku, String lokalizacja) {
        this.nazwaPrzystanku = nazwaPrzystanku;
        this.lokalizacja = lokalizacja;
    }

    public String getNazwaPrzystanku() {
        return nazwaPrzystanku;
    }

    public String getLokalizacja() {
        return lokalizacja;
    }

    public void setNazwaPrzystanku(String nazwaPrzystanku) {
        this.nazwaPrzystanku = nazwaPrzystanku;
    }

    public void setLokalizacja(String lokalizacja) {
        this.lokalizacja = lokalizacja;
    }

    @Override
    public String toString() {
        return "PrzystanekAutobusowy{" +
                "nazwaPrzystanku='" + nazwaPrzystanku + '\'' +
                ", lokalizacja='" + lokalizacja + '\'' +
                '}';
    }
}
