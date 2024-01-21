package org.example;

import java.io.Serializable;
import java.sql.Timestamp;

public class HistoriaZakupowBiletow implements Serializable {
    private Timestamp dataZakupu;
    private Timestamp dataWaznosci;
    private double cena;

    public HistoriaZakupowBiletow(Timestamp dataZakupu, Timestamp dataWaznosci, double cena) {
        this.dataZakupu = dataZakupu;
        this.dataWaznosci = dataWaznosci;
        this.cena = cena;
    }

    // Gettery i settery
    public Timestamp getDataZakupu() {
        return dataZakupu;
    }

    public void setDataZakupu(Timestamp dataZakupu) {
        this.dataZakupu = dataZakupu;
    }

    public Timestamp getDataWaznosci() {
        return dataWaznosci;
    }

    public void setDataWaznosci(Timestamp dataWaznosci) {
        this.dataWaznosci = dataWaznosci;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }
}
