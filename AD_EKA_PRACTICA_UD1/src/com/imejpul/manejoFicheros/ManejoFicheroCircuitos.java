package com.imejpul.manejoFicheros;

import com.imejpul.serializables.Circuito;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManejoFicheroCircuitos {

    public void escribirFicheroCircuitos(Circuito c){
        //objeto file
        File fichero = new File ("FichCircuitos.dat");
        //Flujo de salida
        try {
            FileOutputStream fileout = new FileOutputStream(fichero, true);
            //Conecta el flujo de bytes al flujo de datos
            ObjectOutputStream dataOS = new ObjectOutputStream(fileout);

            dataOS.writeObject(c);
            dataOS.close();
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println(" - Fin fichero Circuitos - ");
        }

    }

    public List<Circuito> leerFicheroCircuitos(){
        Circuito c = new Circuito();
        List<Circuito> circuitos = new ArrayList<>();
        //Objeto File
        File fichero = new File ("FichCircuitos.dat");
        //Flujo de entrada
        try {
            FileInputStream filein = new FileInputStream(fichero);
            //Conecta el flujo de bytes al flujo de datos

            try {
                while (true) {
                    ObjectInputStream dataIS = new ObjectInputStream(filein);
                    c = (Circuito) dataIS.readObject();
                    circuitos.add(c);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return circuitos;
    }
}
