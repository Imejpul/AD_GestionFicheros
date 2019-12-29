package com.imejpul.serializables;

import com.imejpul.auxiliares.LadoCurva;

import java.io.Serializable;

public class Curva implements Serializable {

    private LadoCurva lc;
    private int numeroCurva;
    private Circuito c;

    public Curva() {
    }

    public Curva(LadoCurva lc, int numeroCurva, Circuito c) {
        this.lc = lc;
        this.numeroCurva = numeroCurva;
        this.c = c;
    }

    @Override
    public String toString() {
        return "Curva{" +
                /*"lc=" + lc.toString() +*/
                ", numeroCurva=" + numeroCurva +
                /*", c=" + c.toString() +*/
                '}';
    }

    public LadoCurva getLc() {
        return lc;
    }

    public void setLc(LadoCurva lc) {
        this.lc = lc;
    }

    public int getNumeroCurva() {
        return numeroCurva;
    }

    public void setNumeroCurva(int numeroCurva) {
        this.numeroCurva = numeroCurva;
    }

    public Circuito getC() {
        return c;
    }

    public void setC(Circuito c) {
        this.c = c;
    }
}
