
/**
 * Clase que representa a los Equipos que competirán
 * 
 * @author Alexeido, Thander y Natera
 * @version 31-10-2022
 */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.io.IOException;
import java.nio.*;

public class Equipo {
    private String nombre;
    private ArrayList<Ciclista> ciclistas;
    private ArrayList<Ciclista> ciclistasAbandonados;
    private ArrayList<Bicicleta> bicis;
    private double tiempoMedio;
    private Comparator<Bicicleta> ordenBicicleta;
    private Comparator<Ciclista> ordenCiclista;

    /**
     * Constructor de objetos para la clase Equipo
     */
    public Equipo() {
        nombre = "";
        ciclistas = new ArrayList<Ciclista>();
        ciclistasAbandonados = new ArrayList<Ciclista>();
        bicis = new ArrayList<Bicicleta>();
        tiempoMedio = 0;
        this.ordenBicicleta = new PesoComparatorAsc();
        this.ordenCiclista = new NombreCComparator();
    }

    /**
     * Constructor parametrizado de objetos para la clase Equipo
     * 
     * @param nombre               Nombre del equipo
     * @param ciclistas            Ciclistas del equipo
     * @param ciclistasAbandonados Ciclistas abandonados del equipo
     * @param bicis                Bicicletas del equipo
     * @param tiempoMedio          Tiempo medio del equipo
     * @param ordenCiclista        indica el orden de los ciclistas
     * @param ordenBicicleta       indica el orden de las bicicletas
     */
    public Equipo(String nombre, ArrayList<Ciclista> ciclistas, ArrayList<Ciclista> ciclistasAbandonados,
            ArrayList<Bicicleta> bicis, double tiempoMedio, Comparator<Ciclista> ordenCiclista,
            Comparator<Bicicleta> ordenBicicleta) {
        this.nombre = nombre;
        this.ciclistas = ciclistas;
        this.ciclistasAbandonados = ciclistasAbandonados;
        this.bicis = bicis;
        this.tiempoMedio = tiempoMedio;
        this.ordenBicicleta = ordenBicicleta;
        this.ordenCiclista = ordenCiclista;
    }

    /**
     * Constructor parametrizado de objetos para la clase Equipo
     * 
     * @param nombre         Nombre del equipo
     * @param ordenCiclista  indica el orden de los ciclistas
     * @param ordenBicicleta indica el orden de las bicicletas
     */
    public Equipo(String nombre, Comparator<Ciclista> ordenCiclista, Comparator<Bicicleta> ordenBicicleta) {
        this.nombre = nombre;
        this.ordenBicicleta = ordenBicicleta;
        this.ordenCiclista = ordenCiclista;
        ciclistas = new ArrayList<Ciclista>();
        ciclistasAbandonados = new ArrayList<Ciclista>();
        bicis = new ArrayList<Bicicleta>();
    }

    /**
     * @return Nombre del equipo
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * @param nombre Nombre del equipo
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return ArrayList de ciclistas
     */
    public ArrayList<Ciclista> getCiclistas() {
        return this.ciclistas;
    }

    /**
     * @param ciclistas ArrayList de ciclistas
     */
    public void setCiclistas(ArrayList<Ciclista> ciclistas) {
        this.ciclistas = ciclistas;
    }

    /**
     * @return ArrayList de ciclistas abandonados
     */
    public ArrayList<Ciclista> getCiclistasAbandonados() {
        return this.ciclistasAbandonados;
    }

    /**
     * @return ArrayLiist de Bicicletas
     */
    public ArrayList<Bicicleta> getBicis() {
        return this.bicis;
    }

    /*
     * Calcula y establece el tiempo medio del equipo
     */
    public void setTiempoMedio() {
        this.tiempoMedio = getTiempototal() / ciclistas.size();
    }

    /**
     * @return Tiempo medio del equipo
     */
    public double getTiempoMedio() {
        return this.tiempoMedio;
    }

    /**
     * @return Orden de las Bicicletas
     */
    public Comparator<Bicicleta> getOrdenBicicleta() {
        return this.ordenBicicleta;
    }

    /**
     * @param ordenBicicleta Comparator según el que se va a ordenar
     */
    public void setOrdenBicicleta(Comparator<Bicicleta> ordenBicicleta) {
        this.ordenBicicleta = ordenBicicleta;
    }

    /**
     * @return Comparator de los ciclistas
     */
    public Comparator<Ciclista> getOrdenCiclista() {
        return this.ordenCiclista;
    }

    /**
     * @param ordenCiclista Comparator según el que se va a ordenar
     */
    public void setOrdenCiclista(Comparator<Ciclista> ordenCiclista) {
        this.ordenCiclista = ordenCiclista;
    }

    /*
     * Asigna una Bicicleta a cada ciclista
     */
    public void asignarbici() {
        reOrdenCiclista(ordenCiclista);
        for (int i = 0; i < ciclistas.size(); i++) {
            ciclistas.get(i).setBicicleta(bicis.get(i));
        }
    }

    /*
     * Muestra la informacion del equipo y sus ciclistas
     */
    public void mostrarTodo(BufferedWriter ficheroOut) {
        try {
            System.out.println("%%% " + nombre.toUpperCase() + " %%% Media Minutos de Ciclistas sin abandonar: "
                    + String.format("%.2f", tiempoMedio) + " %%%" + '\n');
            ficheroOut.write("%%% " + nombre.toUpperCase() + " %%% Media Minutos de Ciclistas sin abandonar: "
                    + String.format("%.2f", tiempoMedio) + " %%%" + '\n');
            for (int i = 0; i < ciclistas.size(); i++) {
                ciclistas.get(i).mostrarSinBici(ficheroOut);// <ciclista:VAN VLEUTEN> <energía: 50.92> <habilidad: 4.96>
                                                            // <tiempo
                // acumulado sin abandonar: 1149.08> <abandonado:false>
            }
            for (int i = 0; i < ciclistasAbandonados.size(); i++) {
                ciclistasAbandonados.get(i).mostrarSinBici(ficheroOut);
            }
            System.out.println(
                    "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"
                            + '\n' +
                            "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            ficheroOut.write(
                    "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"
                            + '\n' +
                            "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        } catch (IOException e) {
            System.err.println("There was a problem writing to ");
        }

    }

    /*
     * Muestra los ciclistas que han abandonado
     */
    public void mostrarAbandonos(BufferedWriter ficheroOut) {
        for (Ciclista ciclista : ciclistasAbandonados) {
            ciclista.mostrarTodo(ficheroOut);
        }
    }

    /**
     * Añade una bicilceta al vector de Bicicletas y ordena el vector
     * 
     * @param b Bicicleta a añadir
     */
    public void addBicicleta(Bicicleta b) {
        bicis.add(b);
        this.reOrdenBicicleta(this.ordenBicicleta);
    }

    /**
     * Añade un ciclista al vector de ciclistas y ordena el vector
     * 
     * @param c Ciclista a añadir
     */
    public void addCiclista(Ciclista c) {
        ciclistas.add(c);
        this.reOrdenCiclista(this.ordenCiclista);
    }

    /**
     * Reordena el vector de ciclistas
     * 
     * @param ordenCiclista char que indica según que se va a ordenar
     */
    public void reOrdenCiclista(Comparator<Ciclista> ordenCiclista) {
        Collections.sort(ciclistas, ordenCiclista);
    }

    /**
     * Reordena el vector de Bicicletas
     * 
     * @param ordenBicicleta char que indica según que se va a ordenar
     */
    public void reOrdenBicicleta(Comparator<Bicicleta> ordenBicicleta) {
        Collections.sort(bicis, ordenBicicleta);
    }

    /**
     * Quita un ciclista del vector de ciclistas y lo añade al de abandonados
     * 
     * @param c Ciclista que abandona
     */
    public void addCiclistaAbandonado(Ciclista c) {
        ciclistas.remove(c);
        ciclistasAbandonados.add(c);

    }

    /**
     * @return Suma de los tiempo totales acumulados en toda la carrera por todos
     *         los ciclistas del equipo
     */
    public double getTiempototal() {
        double result = 0;
        Ciclista aux;
        for (int i = 0; i < ciclistas.size(); i++) {
            aux = ciclistas.get(i);
            result = result + aux.getTotalTime();
        }
        return result;
    }

    /**
     * Envia a todos los ciclistas a correr una etapa
     * 
     * @param e Etapa a correr
     */
    public void enviarEtapa(Etapa e) {
        Ciclista aux;
        for (int i = 0; i <= ciclistas.size(); i++) {
            aux = ciclistas.get(i);
            aux.correrEtapa(e);
        }
    }

    @Override
    public String toString() {
        return "<Nombre: " + getNombre() + " tiempo medio: " + getTiempoMedio();
    }
}
