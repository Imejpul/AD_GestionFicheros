package com.imejpul;

import com.imejpul.auxiliares.LadoCurva;
import com.imejpul.manejoFicheros.ManejoFicheroCircuitos;
import com.imejpul.manejoFicheros.ManejoFicheroResultados;
import com.imejpul.manejoFicheros.ManejoFicheroVueltas;
import com.imejpul.serializables.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static ManejoFicheroCircuitos mfc = new ManejoFicheroCircuitos();
    private static ManejoFicheroVueltas mfv = new ManejoFicheroVueltas();
    private static ManejoFicheroResultados mfr = new ManejoFicheroResultados();

    public static void main(String[] args) {

        int cantMotos = 2;
        //int cantVueltas = ((int) (Math.random() * (16 - 22 + 1)) + 16);
        int cantVueltas = 10;
        int cantidadCircuitos = 5;

        for (int m = 0; m < cantMotos; m++) {
            for (int c = 0; c < cantidadCircuitos; c++) {
                for (int v = 0; v < cantVueltas; v++) {
                    Moto moto = cargarDatosMoto((m + 1), (c + 1), (v + 1));
                    mostrarMoto(moto);
                    System.out.println("-----------");
                    Resultado r = cargarDatosResultado(moto, v);
                    mostrarResultado(r);
                    System.out.println("--- FIN VUELTA " + (v + 1) + " ---");
                }
                System.out.println("--- FIN CIRCUITO " + (c + 1) + " MOTO " + (m + 1) + " ---" + "\n");
            }
            System.out.println("--- FIN CAMPEONATO MOTO " + (m + 1) + " ---" + "\n");
        }

        /*Moto moto = cargarDatosMoto(1,1,1);
        mostrarMoto(moto);

        Resultado res = cargarDatosResultado(moto, 1);
        mostrarResultado(res);*/
        System.out.println("**********************************************************");

        mostrarCircuitoFromFile();
        mostrarVueltasFromFile();
        mostrarResultadoFromFile();
        mfr.escribirFicheroResultadoXML();
        mostrarResultadoFromXML();

    }

    //cargarDatosCircuito
    private static Circuito cargarDatosCircuito(int codigoCircuito) {
        List<Curva> curvas = new ArrayList<>();

        Circuito c = new Circuito();
        c.setCodigoCircuito(codigoCircuito);
        c.setCurvasTotales((int) (Math.random() * 17) + 10);
        c.setLongitudTotal((int) (Math.random() * 5600) + 1500);

        for (int j = 0; j < c.getCurvasTotales(); j++) {
            int aux = (int) (Math.random() * 7894) + 1;
            Curva cur = new Curva();
            if (aux % 2 == 0) {
                cur.setNumeroCurva(j + 1);
                cur.setLc(LadoCurva.DERECHA);
                cur.setC(c);
                curvas.add(cur);
            } else {
                cur.setNumeroCurva(j + 1);
                cur.setLc(LadoCurva.IZQUIERDA);
                cur.setC(c);
                curvas.add(cur);
            }
        }
        c.setCurvas(curvas);
        /*System.out.println("Total Curvas -> " + c.getCurvas().size());
        System.out.println("Longitud -> " + c.getLongitudTotal());*/
        mfc.escribirFicheroCircuitos(c);
        return c;
    }

    //cargarDatosVuelta
    private static Vuelta cargarDatosVuelta(int numeroVuelta, Circuito c, Moto m) {
        Vuelta v = new Vuelta();
        v.setNumeroVuelta(numeroVuelta);
        v.setTiempoTotal((float) (Math.random() * (295 - 300 + 1)) + 295);
        v.setC(c);
        v.setM(m);
        mfv.escribirFicheroVueltas(v);
        //System.out.println("Tiempo total vuelta -> " + v.getTiempoTotal());
        return v;
    }

    //cargarDatosMoto
    private static Moto cargarDatosMoto(int codigoMoto, int codigoCircuito, int numeroVuelta) {
        Moto m = new Moto();

        m.setCodigoMoto(codigoMoto);
        m.setC(cargarDatosCircuito(codigoCircuito));

        Map<Curva, Integer> valoresTorqueCurva = new HashMap<>();
        Map<Curva, Integer> valoresRPMCurva = new HashMap<>();
        Map<Curva, Integer> valoresVelocidadRuedaDel = new HashMap<>();
        Map<Curva, Integer> valoresVelocidadRuedaTras = new HashMap<>();

        for (Curva cur : m.getC().getCurvas()) {
            //torque
            int cantTorque = ((int) (Math.random() * (66 + 1))); //TODO: comprobar valores
            valoresTorqueCurva.put(cur, cantTorque);

            //rpm
            int cantRPM = ((int) (Math.random() * (18000 + 1))); //TODO: comprobar valores
            valoresRPMCurva.put(cur, cantRPM);

            //velRuedas
            int velRueda = ((int) (Math.random() * (200 + 150))); //TODO: comprobar valores
            if (velRueda % 2 == 0) {
                valoresVelocidadRuedaDel.put(cur, velRueda);
                valoresVelocidadRuedaTras.put(cur, velRueda);
            } else {
                valoresVelocidadRuedaDel.put(cur, velRueda);
                valoresVelocidadRuedaTras.put(cur, velRueda - 20);
            }
        }

        m.setTorqueCurvas(valoresTorqueCurva);
        m.setRpmCurvas(valoresRPMCurva);
        m.setVelRuedaDelCurvas(valoresVelocidadRuedaDel);
        m.setVelRuedaTrasCurvas(valoresVelocidadRuedaTras);

        m.setV(cargarDatosVuelta(numeroVuelta, m.getC(), m));
        return m;
    }

    public static Resultado cargarDatosResultado(Moto m, int codigoResultado) {
        Resultado r = new Resultado();

        r.setCodigoResultado(codigoResultado);
        r.setCurvasHP(calcularHP(m));
        r.setCurvasDerrapada(calcularDerrapada(m));
        r.setVelocidadMedia(calcularVelMedia(m));

        mfr.escribirFicheroResultado(r);

        return r;
    }

    private static Map<Curva, Float> calcularHP(Moto m) {
        Map<Curva, Float> curvasHP = new HashMap<>();

        for (Map.Entry<Curva, Integer> valorTorque : m.getTorqueCurvas().entrySet()) {
            float torque = valorTorque.getValue();
            int rpm = m.getRpmCurvas().get(valorTorque.getKey());

            float hp = (rpm * torque) / 5252;
            curvasHP.put(valorTorque.getKey(), hp);
            //System.out.println("HP-> " + curvasHP.get(valorTorque.getKey()) + " " + hp);
        }
        return curvasHP;
    }

    private static Map<Curva, Boolean> calcularDerrapada(Moto m) {
        Map<Curva, Boolean> curvasDerrape = new HashMap<>();

        for (Map.Entry<Curva, Integer> valorRuedas : m.getVelRuedaDelCurvas().entrySet()) {
            int velRuedaDel = valorRuedas.getValue();
            int velRuedaTras = m.getVelRuedaTrasCurvas().get(valorRuedas.getKey());

            boolean derrapa;
            if (velRuedaDel != velRuedaTras) {
                derrapa = true;
                curvasDerrape.put(valorRuedas.getKey(), derrapa);
                //System.out.println("Derrapa-> " + curvasDerrape.get(valorRuedas.getKey().getNumeroCurva()) + " " + derrapa);
            } else {
                derrapa = false;
                curvasDerrape.put(valorRuedas.getKey(), derrapa);
                //System.out.println("Derrapa-> " + curvasDerrape.get(valorRuedas.getKey().getNumeroCurva()) + " " + derrapa);
            }
        }

        return curvasDerrape;
    }

    private static float calcularVelMedia(Moto m) {
        int longitud = m.getC().getLongitudTotal() / 1000;
        float tiempo = m.getV().getTiempoTotal() / 3600;

        float velMedia = longitud / tiempo;
        //System.out.println("Velocidad -> " + velMedia);
        return velMedia;
    }

    private static void mostrarMoto(Moto m) {

        System.out.println("Código Moto -> " + m.getCodigoMoto());
        System.out.println("Codigo Circuito -> " + m.getC().getCodigoCircuito() +
                ", Logitud total -> " + m.getC().getLongitudTotal() + " mts" +
                ", Curvas Totales -> " + m.getC().getCurvasTotales());

        for (Curva c : m.getC().getCurvas()) {
            int torque = m.getTorqueCurvas().get(c);
            int rpm = m.getRpmCurvas().get(c);
            int velRuedaDel = m.getVelRuedaDelCurvas().get(c);
            int velRuedaTras = m.getVelRuedaTrasCurvas().get(c);

            System.out.println("Número Curva -> " + c.getNumeroCurva() +
                    ", Lado Curva -> " + c.getLc().toString() +
                    ", Torque -> " + torque + " NM" +
                    ", RPM -> " + rpm +
                    ", velRuedaDel -> " + velRuedaDel + " KM/H" +
                    ", velRuedaTras -> " + velRuedaTras + " KM/H");
        }

        System.out.println("Número Vuelta -> " + m.getV().getNumeroVuelta() +
                ", Tiempo total vuelta -> " + m.getV().getTiempoTotal() + " seg");
    }

    private static void mostrarResultado(Resultado r) {
        System.out.println("Codigo resultado -> " + r.getCodigoResultado());
        System.out.println("Velocidad Media -> " + r.getVelocidadMedia());

        for (Map.Entry<Curva, Float> curvaHP : r.getCurvasHP().entrySet()) {
            System.out.println("Número Curva -> " + curvaHP.getKey().getNumeroCurva() +
                    ", HP -> " + curvaHP.getValue() +
                    ", ¿Derrapa? -> " + r.getCurvasDerrapada().get(curvaHP.getKey()));
        }
    }

    private static void mostrarCircuitoFromFile(){
        List<Circuito> circuitos = mfc.leerFicheroCircuitos();

        for (Circuito c : circuitos) {
            System.out.println("Codigo Circuito -> " + c.getCodigoCircuito() +
                    ", Logitud total -> " + c.getLongitudTotal() + " mts" +
                    ", Curvas Totales -> " + c.getCurvasTotales());
        }
    }

    private static void mostrarVueltasFromFile(){
        List<Vuelta> vueltas = mfv.leerFicheroVueltas();

        for (Vuelta v : vueltas) {
            System.out.println("Número Vuelta -> " + v.getNumeroVuelta() +
                    ", Tiempo total vuelta -> " + v.getTiempoTotal() + " seg" +
                    ", Circuito nº -> " + v.getC().getCodigoCircuito() +
                    ", Moto nº -> " + v.getM().getCodigoMoto());
        }
    }

    private static void mostrarResultadoFromFile(){

        List<Resultado> resultados = mfr.leerFciheroResultado();

        for (Resultado r : resultados) {
            System.out.println("Resultado nº -> " + r.getCodigoResultado());
            System.out.println("Velocidad Media -> " + r.getVelocidadMedia());

            for (Map.Entry<Curva, Float> curvaHP : r.getCurvasHP().entrySet()) {
                System.out.println("Número Curva -> " + curvaHP.getKey().getNumeroCurva() +
                        ", HP -> " + curvaHP.getValue() +
                        ", ¿Derrapa? -> " + r.getCurvasDerrapada().get(curvaHP.getKey()));
            }
        }
    }

    private static void mostrarResultadoFromXML(){

        List<Resultado> resultados = mfr.leerFicheroResultadoXML();

        for (Resultado r : resultados) {
            System.out.println("Resultado nº -> " + r.getCodigoResultado());
            System.out.println("Velocidad Media -> " + r.getVelocidadMedia());

            for (Map.Entry<Curva, Float> curvaHP : r.getCurvasHP().entrySet()) {
                System.out.println("Número Curva -> " + curvaHP.getKey().getNumeroCurva() +
                        ", HP -> " + curvaHP.getValue() +
                        ", ¿Derrapa? -> " + r.getCurvasDerrapada().get(curvaHP.getKey()));
            }
        }
    }


}
