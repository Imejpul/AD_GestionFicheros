package com.imejpul.serializables;

import java.io.Serializable;


public class Vuelta implements Serializable {

    private int numeroVuelta;
    private float tiempoTotal;
    private Circuito c;
    private Moto m;

    public Vuelta() {
    }

    public int getNumeroVuelta() {
        return numeroVuelta;
    }

    public void setNumeroVuelta(int numeroVuelta) {
        this.numeroVuelta = numeroVuelta;
    }

    public float getTiempoTotal() {
        return tiempoTotal;
    }

    public void setTiempoTotal(float tiempoTotal) {
        this.tiempoTotal = tiempoTotal;
    }

    public Circuito getC() {
        return c;
    }

    public void setC(Circuito c) {
        this.c = c;
    }

    public Moto getM() {
        return m;
    }

    public void setM(Moto m) {
        this.m = m;
    }
}
