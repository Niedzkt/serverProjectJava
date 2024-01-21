package org.example;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class InformacjeOBilecie implements Serializable {
    private Timestamp dataZakupu;
    private Timestamp dataWaznosci;
    private double cena;

    public InformacjeOBilecie(Timestamp dataZakupu, Timestamp dataWaznosci, double cena) {
        this.dataZakupu = dataZakupu;
        this.dataWaznosci = dataWaznosci;
        this.cena = cena;
    }

    public double getCena() {
        return cena;
    }

    public Timestamp getDataWaznosci() {
        return dataWaznosci;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public void setDataWaznosci(Timestamp dataWaznosci) {
        this.dataWaznosci = dataWaznosci;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "InformacjeOBilecie{" +
                "dataZakupu=" + (dataZakupu != null ? sdf.format(dataZakupu) : "null") +
                ", dataWaznosci=" + (dataWaznosci != null ? sdf.format(dataWaznosci) : "null") +
                ", cena=" + cena +
                '}';
    }
}
