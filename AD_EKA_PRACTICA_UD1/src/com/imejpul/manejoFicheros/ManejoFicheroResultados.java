package com.imejpul.manejoFicheros;

import com.imejpul.auxiliares.ListaResultados;
import com.imejpul.serializables.Resultado;
import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManejoFicheroResultados {

    public void escribirFicheroResultado(Resultado r) {
        //objeto file
        File fichero = new File("FichResultados.dat");
        //Flujo de salida
        try {
            FileOutputStream fileout = new FileOutputStream(fichero, true);
            //Conecta el flujo de bytes al flujo de datos
            ObjectOutputStream dataOS = new ObjectOutputStream(fileout);

            dataOS.writeObject(r);
            dataOS.close();
        } catch (IOException e) {
            System.out.println(" - Fin fichero Circuitos - ");
            //e.printStackTrace();
        }
        //escribirFicheroResultadoXML();
    }

    public List<Resultado> leerFciheroResultado() {
        Resultado r = new Resultado();
        List<Resultado> resultados = new ArrayList<>();
        //Objeto File
        File fichero = new File("FichResultados.dat");
        //Flujo de entrada
        try {
            FileInputStream filein = new FileInputStream(fichero);
            //Conecta el flujo de bytes al flujo de datos


            try {
                while (true) {
                    ObjectInputStream dataIS = new ObjectInputStream(filein);
                    r = (Resultado) dataIS.readObject();
                    resultados.add(r);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            System.out.println(" - Fin fichero Resultados - ");
            //e.printStackTrace();
        }

        return resultados;
    }

    public void escribirFicheroResultadoXML() {

        File fichero = new File("FichResultados.dat");

        ObjectInputStream dataIS = null;
        FileInputStream filein = null;
        try {
            filein = new FileInputStream(fichero);

        } catch (IOException e) {
            System.out.println(" - Fin fichero Resultados (XML) - ");
            //e.printStackTrace();
        }

        //Creamos un objeto Lista de Personas
        ListaResultados lr = new ListaResultados();
        try {
            while (true) {
                //lectura del fichero
                dataIS = new ObjectInputStream(filein);
                Resultado r = (Resultado) dataIS.readObject();
                lr.addResultadoALista(r);

            }
        } catch (IOException | ClassNotFoundException o) {
            System.out.println(" - Fin fichero Resultados (XML)- ");
            //o.printStackTrace();
        }
        try {
            dataIS.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            XStream xstream = new XStream();
            //cambiar de nombre a las etiquetas XML
            xstream.alias("ListaResultados", ListaResultados.class);
            xstream.alias("Resultado", Resultado.class);
            //quitar etiqueta lista (atributo de la clase ListaPersonas)
            //xstream.addImplicitCollection(ListaResultados.class, "Lista");
            //Insrtarlos objetos en el XML
            xstream.toXML(lr, new FileOutputStream("Resultados.xml", true));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<Resultado> leerFicheroResultadoXML() {
        List<Resultado> lr = new ArrayList<>();

        XStream xstream = new XStream();

        xstream.alias("ListaResultados", ListaResultados.class);
        xstream.alias("Resultado", Resultado.class);
        //xstream.addImplicitCollection(ListaResultados.class, "Lista");

        try {
            FileInputStream fichero = new FileInputStream("Resultados.xml");
            ListaResultados listaResultados = (ListaResultados) xstream.fromXML(fichero);
            lr = listaResultados.getListaResultados();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lr;
    }
}
