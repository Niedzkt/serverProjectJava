package org.example;

import java.io.Serializable;

public class RozkladJazdy implements Serializable {
    private String nazwaLinii;
    private String opis;

    // Konstruktor
    public RozkladJazdy(String nazwaLinii, String opis) {
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

    // Opcjonalnie, metoda toString() do łatwiejszego debugowania i wyświetlania
    @Override
    public String toString() {
        return "RozkladJazdy{" +
                "nazwaLinii='" + nazwaLinii + '\'' +
                ", opis='" + opis + '\'' +
                '}';
    }
}
