package org.example;

import java.io.Serializable;

public class LiniaAutobusowa implements Serializable {
    private String nazwaLinii;
    private String opis;

    // Konstruktor
    public LiniaAutobusowa(String nazwaLinii, String opis) {
        this.nazwaLinii = nazwaLinii;
        this.opis = opis;
    }

    // Gettery
    public String getNazwaLinii() {
        return nazwaLinii;
    }

    public String getOpis() {
        return opis;
    }

    // Settery
    public void setNazwaLinii(String nazwaLinii) {
        this.nazwaLinii = nazwaLinii;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    // Metoda toString
    @Override
    public String toString() {
        return "LiniaAutobusowa{" +
                "nazwaLinii='" + nazwaLinii + '\'' +
                ", opis='" + opis + '\'' +
                '}';
    }
}
