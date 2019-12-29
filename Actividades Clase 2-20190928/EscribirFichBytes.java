package com.company;

import java.io.*;

public class EscribirFichBytes {
    public static void main (String[] args) throws IOException {

        //Creamos objeto file para gestionar después el flujo de salida
        File fichero = new File("FichBytes.dat"); //Dentro de la carpeta del proyecto

        //Creamos flujo de salida hacia el fichero
        FileOutputStream fileout = new FileOutputStream(fichero);

        //Creamos flujo de entrada
        FileInputStream filein = new FileInputStream(fichero);

        //Escribimos 99 veces
        int i;
        for (i=1; i<100; i++){
            fileout.write(i); //escribe los datos en el flujo de salida
        }
        fileout.close(); //cerramos flujo de salida

        //Visualizamos datos del fichero, una vez escrito
        while((i=filein.read())!=-1){ //lee los datos del flujo de entrada
            System.out.println(i);
        }
        filein.close(); //cerramos flujo de entrada
    }
}
