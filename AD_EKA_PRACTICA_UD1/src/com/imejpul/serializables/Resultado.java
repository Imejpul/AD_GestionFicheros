package com.imejpul.serializables;

import java.io.Serializable;
import java.util.Map;

public class Resultado implements Serializable {

    private int codigoResultado;
    private Map<Curva, Float> CurvasHP;
    private Map<Curva, Boolean> curvasDerrapada;
    private float velocidadMedia;

    public Resultado() {
    }

    public int getCodigoResultado() {
        return codigoResultado;
    }

    public void setCodigoResultado(int codigoResultado) {
        this.codigoResultado = codigoResultado;
    }

    public Map<Curva, Float> getCurvasHP() {
        return CurvasHP;
    }

    public void setCurvasHP(Map<Curva, Float> curvasHP) {
        CurvasHP = curvasHP;
    }

    public Map<Curva, Boolean> getCurvasDerrapada() {
        return curvasDerrapada;
    }

    public void setCurvasDerrapada(Map<Curva, Boolean> curvasDerrapada) {
        this.curvasDerrapada = curvasDerrapada;
    }

    public float getVelocidadMedia() {
        return velocidadMedia;
    }

    public void setVelocidadMedia(float velocidadMedia) {
        this.velocidadMedia = velocidadMedia;
    }
}
