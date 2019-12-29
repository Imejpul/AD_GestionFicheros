package com.company;

import java.io.*;

public class LeerFichObject {
    public static void main (String [] args) throws IOException, ClassNotFoundException {
        //Objeto File
        File fichero = new File ("FichPersona.dat");
        //Flujo de entrada
        FileInputStream filein = new FileInputStream(fichero);
        //Conecta el flujo de bytes al flujo de datos
        ObjectInputStream dataIS = new ObjectInputStream(filein);
        
        try{
            while(true){
                //Leemos una persona, pero debemos hacer casting en readObject
                Persona persona = (Persona) dataIS.readObject();
                //No podemos utilizar println de esta manera, así que utilizamos %n para saltos de línea
                // %s --> String
                // %d --> Int
                System.out.printf("Nombre: %s, Edad: %d %n", persona.getNombre(),persona.getEdad());
            }
        }
        catch(EOFException eo){
            System.out.println("Fin de lectura");
        }
        dataIS.close(); //Cerramos el flujo de entrada
    }
}
