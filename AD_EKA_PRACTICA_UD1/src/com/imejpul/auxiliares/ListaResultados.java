package com.imejpul.auxiliares;

import com.imejpul.serializables.Resultado;

import java.util.ArrayList;
import java.util.List;

public class ListaResultados {

    private List<Resultado> listaResultados = new ArrayList<>();

    public ListaResultados() {
    }

    public List<Resultado> getListaResultados() {
        return listaResultados;
    }

    public void addResultadoALista(Resultado r){
        listaResultados.add(r);
    }
}
