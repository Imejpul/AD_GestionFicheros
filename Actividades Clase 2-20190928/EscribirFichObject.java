import java.io.*;
public class EscribirFichObject {
    public static void main (String[] args) throws IOException {

        //Objeto File
        File fichero = new File ("FichPersona.dat");
        //Flujo de salida
        FileOutputStream fileout = new FileOutputStream(fichero);
        //Conecta el flujo de bytes al flujo de datos
        ObjectOutputStream dataOS = new ObjectOutputStream(fileout);

        ///////// 2 \\\\\\\\\\
        String nombres[] = {"Ana", "Luis", "Alicia", "Pedro", "Manuel", "María", "Sara", "Andrés", "Silvia"}    ;
        int edades[] = {15, 16, 17, 16, 14, 15, 17, 18, 14};

        for (int i = 0; i<edades.length; i++) {
            Persona persona = new Persona(nombres[i], edades[i]);
            dataOS.writeObject(persona); //escribimos la persona en el fichero
         }
        dataOS.close();//cerramos el stream de salida
    }
}