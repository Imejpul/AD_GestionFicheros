package com.imejpul.serializables;

import java.io.Serializable;
import java.util.Map;

public class Moto implements Serializable {

    private int codigoMoto;
    private Vuelta v;
    private Circuito c;
    private Map<Curva, Integer> torqueCurvas;
    private Map<Curva, Integer> rpmCurvas;
    private Map<Curva, Integer> velRuedaDelCurvas;
    private Map<Curva, Integer> velRuedaTrasCurvas;

    public Moto() {
    }

    public Moto(int codigoMoto, Vuelta v, Circuito c, Map<Curva, Integer> torqueCurvas, Map<Curva, Integer> rpmCurvas, Map<Curva, Integer> velRuedaDelCurvas, Map<Curva, Integer> velRuedaTrasCurvas) {
        this.codigoMoto = codigoMoto;
        this.v = v;
        this.c = c;
        this.torqueCurvas = torqueCurvas;
        this.rpmCurvas = rpmCurvas;
        this.velRuedaDelCurvas = velRuedaDelCurvas;
        this.velRuedaTrasCurvas = velRuedaTrasCurvas;
    }

    @Override
    public String toString() {
        return "Moto{" +
                "codigoMoto =" + codigoMoto +
                ", vuelta =" + v.getNumeroVuelta() +
                ", circuito =" + c.getCodigoCircuito() +
                /*", torqueCurvas=" + torqueCurvas +
                ", rpmCurvas=" + rpmCurvas.toString() +
                ", velRuedaDelCurvas=" + velRuedaDelCurvas.toString() +
                ", velRuedaTrasCurvas=" + velRuedaTrasCurvas.toString() +*/
                '}';
    }

    public int getCodigoMoto() {
        return codigoMoto;
    }

    public void setCodigoMoto(int codigoMoto) {
        this.codigoMoto = codigoMoto;
    }

    public Vuelta getV() {
        return v;
    }

    public void setV(Vuelta v) {
        this.v = v;
    }

    public Circuito getC() {
        return c;
    }

    public void setC(Circuito c) {
        this.c = c;
    }

    public Map<Curva, Integer> getTorqueCurvas() {
        return torqueCurvas;
    }

    public void setTorqueCurvas(Map<Curva, Integer> torqueCurvas) {
        this.torqueCurvas = torqueCurvas;
    }

    public Map<Curva, Integer> getRpmCurvas() {
        return rpmCurvas;
    }

    public void setRpmCurvas(Map<Curva, Integer> rpmCurvas) {
        this.rpmCurvas = rpmCurvas;
    }

    public Map<Curva, Integer> getVelRuedaDelCurvas() {
        return velRuedaDelCurvas;
    }

    public void setVelRuedaDelCurvas(Map<Curva, Integer> velRuedaDelCurvas) {
        this.velRuedaDelCurvas = velRuedaDelCurvas;
    }

    public Map<Curva, Integer> getVelRuedaTrasCurvas() {
        return velRuedaTrasCurvas;
    }

    public void setVelRuedaTrasCurvas(Map<Curva, Integer> velRuedaTrasCurvas) {
        this.velRuedaTrasCurvas = velRuedaTrasCurvas;
    }
}
