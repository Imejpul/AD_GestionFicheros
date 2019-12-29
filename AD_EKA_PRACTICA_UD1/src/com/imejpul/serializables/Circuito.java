package com.imejpul.serializables;

import java.io.Serializable;
import java.util.List;

public class Circuito implements Serializable {

    private int codigoCircuito;
    private int longitudTotal;
    private int curvasTotales;
    private List<Curva> curvas;

    public Circuito() {
    }

    public int getCodigoCircuito() {
        return codigoCircuito;
    }

    public void setCodigoCircuito(int codigoCircuito) {
        this.codigoCircuito = codigoCircuito;
    }

    public int getLongitudTotal() {
        return longitudTotal;
    }

    public void setLongitudTotal(int longitudTotal) {
        this.longitudTotal = longitudTotal;
    }

    public int getCurvasTotales() {
        return curvasTotales;
    }

    public void setCurvasTotales(int curvasTotales) {
        this.curvasTotales = curvasTotales;
    }

    public List<Curva> getCurvas() {
        return curvas;
    }

    public void setCurvas(List<Curva> curvas) {
        this.curvas = curvas;
    }
}
