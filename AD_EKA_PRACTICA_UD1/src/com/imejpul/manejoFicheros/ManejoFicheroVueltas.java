package com.imejpul.manejoFicheros;

import com.imejpul.serializables.Vuelta;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManejoFicheroVueltas {

    public void escribirFicheroVueltas(Vuelta v){
        //objeto file
        File fichero = new File ("FichVueltas.dat");
        //Flujo de salida
        try {
            FileOutputStream fileout = new FileOutputStream(fichero, true);
            //Conecta el flujo de bytes al flujo de datos
            ObjectOutputStream dataOS = new ObjectOutputStream(fileout);

            dataOS.writeObject(v);
            dataOS.close();
        } catch (IOException e) {
            System.out.println(" - Fin fichero Vueltas - ");
            //e.printStackTrace();
        }
    }

    public List<Vuelta> leerFicheroVueltas(){
        Vuelta v = new Vuelta();
        List<Vuelta> vueltas = new ArrayList<>();
        //Objeto File
        File fichero = new File ("FichVueltas.dat");
        //Flujo de entrada
        try {
            FileInputStream filein = new FileInputStream(fichero);
            //Conecta el flujo de bytes al flujo de datos

            try {
                while (true) {
                    ObjectInputStream dataIS = new ObjectInputStream(filein);
                    v = (Vuelta) dataIS.readObject();
                    vueltas.add(v);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return vueltas;
    }
}
