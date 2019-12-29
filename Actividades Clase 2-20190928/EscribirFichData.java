package com.company;

import java.io.*;

public class EscribirFichData {
    public static void main (String[] args) throws IOException {
        ///////// 1 \\\\\\\\\\
        File fichero = new File ("FichData.dat"); //Objeto File. Será un fichero
        FileOutputStream fileout = new FileOutputStream(fichero); //flujo de salida
        //Para abrir un objeto para escribir datos primitivos: DataOutputStream
        DataOutputStream dataOS = new DataOutputStream(fileout);

        ///////// 2 \\\\\\\\\\
        String nombres[] = {"Ana", "Luis", "Alicia", "Pedro", "Manuel", "María", "Sara", "Andrés", "Silvia"}    ;
        int edades[] = {15, 16, 17, 16, 14, 15, 17, 18, 14};

        ///////// 3 \\\\\\\\\\
        for (int i = 0; i<edades.length; i++) {
            dataOS.writeUTF(nombres[i]); //escribe el nombre con el método writeUTF --> String
            dataOS.writeInt(edades[i]); //escribe la edad con el método writeInt--> Int
        }
        ///////// 4 \\\\\\\\\\
        dataOS.close(); //hay que cerrarlo
    }
}
