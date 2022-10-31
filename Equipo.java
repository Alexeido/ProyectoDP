import java.util.*;
import java.lang.*;

/**
 * Representa a los Equipos que competirán tanto por la clasificación por
 * Equipos como
 * por la victoria de uno de sus Ciclistas en el campeonato individual de
 * Ciclistas
 * 
 * @author Alexeido, Thander y Natera
 * @version 31-10-2022
 */
public class Equipo {
    private String nombre;
    private ArrayList<Ciclista> ciclistas;
    private ArrayList<Ciclista> ciclistasAbandonados;
    private ArrayList<Bicicleta> bicis;
    private double tiempoMedio;
    /**
     * Almacena el algoritmo de ordenacion que se usará para las bicicletas
     * 
     * 'P' = Ordenación por peso
     * 'N' = Ordenación por nombre
     *
     */
    private char ordenBicicleta;
    /**
     * Almacena el algoritmo de ordenacion que se usará para los ciclistas
     * 
     * 'H' = Ordenación por Habilidad
     * 'N' = Ordenación por nombre
     * 'E' = Ordenación por Energía
     * 'A' = Ordenación por Tiempo ascendente
     * 'D' = Ordenacion por Tiempo Descendente
     *
     */
    private char ordenCiclista;

    /**
     * Constructor de objetos para la clase Equipo
     */
    public Equipo() {
        nombre = "";
        ciclistas = new ArrayList<Ciclista>();
        ciclistasAbandonados = new ArrayList<Ciclista>();
        bicis = new ArrayList<Bicicleta>();
        tiempoMedio = 0;
        this.ordenBicicleta = '0';
        this.ordenCiclista = '0';
    }

    /**
     * Constructor parametrizado de objetos para la clase Equipo
     * @param nombre Nombre del equipo
     * @param ciclistas Ciclistas del equipo
     * @param ciclistasAbandonados Ciclistas abandonados del equipo
     * @param bicis Bicicletas del equipo
     * @param tiempoMedio Tiempo medio del equipo
     * @param ordenCiclista char que indica según que se van a ordenar los ciclistas
     * @param ordenBicicleta char que indica según que se van a ordenar las bicicletas
     */
    public Equipo(String nombre, ArrayList<Ciclista> ciclistas, ArrayList<Ciclista> ciclistasAbandonados,
            ArrayList<Bicicleta> bicis, double tiempoMedio, char ordenCiclista, char ordenBicicleta) {
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
     * @param nombre Nombre del equipo 
     * @param ordenCiclista char que indica según que se van a ordenar los ciclistas
     * @param ordenBicicleta char que indica según que se van a ordenar las bicicletas
     */
    public Equipo(String nombre, char ordenCiclista, char ordenBicicleta) {
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
     * @return ArrayLiist de bicicletas
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
     * @return Orden de las bicicletas
     */
    public char getOrdenBicicleta() {
        return this.ordenBicicleta;
    }

    /**
     * @param ordenBicicleta char que indica según que se va a ordenar
     */
    public void setOrdenBicicleta(char ordenBicicleta) {
        this.ordenBicicleta = ordenBicicleta;
    }

    /**
     * @return Orden de los ciclistas
     */
    public char getOrdenCiclista() {
        return this.ordenCiclista;
    }

    /**
     * @param ordenCiclista char que indica según que se va a ordenar
     */
    public void setOrdenCiclista(char ordenCiclista) {
        this.ordenCiclista = ordenCiclista;
    }

    /*
     * Asigna una bicicleta a cada ciclista
     */
    public void asignarbici() {
        for (int i = 0; i < ciclistas.size(); i++) {
            ciclistas.get(i).setBicicleta(bicis.get(i));
        }
    }

    /*
     * Muestra la informacion del equipo y sus ciclistas
     */
    public void mostrarTodo() {
        System.out.println(nombre + " Cuya media de puntos de sus ciclistas sin abandonar es: "
                + String.format("%.2f", tiempoMedio));
        for (int i = 0; i < ciclistas.size(); i++) {
            ciclistas.get(i).mostrarSinBici();// <ciclista:VAN VLEUTEN> <energía: 50.92> <habilidad: 4.96> <tiempo
                                              // acumulado sin abandonar: 1149.08> <abandonado:false>
        }
        for (int i = 0; i < ciclistasAbandonados.size(); i++) {
            ciclistasAbandonados.get(i).mostrarSinBici();

        }
    }

    /*
     * Muestra los ciclistas que han abandonado
     */
    public void mostrarAbandonos() {
        for (Ciclista ciclista : ciclistasAbandonados) {
            ciclista.mostrarTodo();
        }
    }

    /**
     * Añade una bicilceta al vector de bicicletas y ordena el vector
     * @param b Bicicleta a añadir
     */
    public void addbicileta(Bicicleta b) {
        bicis.add(b);
        this.reOrdenBicileta(this.ordenBicicleta);
    }

    /**
     * Añade un ciclista al vector de ciclistas y ordena el vector
     * @param c Ciclista a añadir
     */
    public void addCiclista(Ciclista c) {
        ciclistas.add(c);
        this.reOrdenCiclista(this.ordenCiclista);
    }

    /**
     * Reordena el vector de ciclistas
     * @param ordenCiclista char que indica según que se va a ordenar
     */
    public void reOrdenCiclista(char ordenCiclista) {
        if (ordenCiclista == 'H') {
            Collections.sort(ciclistas, new HabilidadComparator());
        }
        if (ordenCiclista == 'N') {
            Collections.sort(ciclistas, new NombreCComparator());
        }
        if (ordenCiclista == 'E') {
            Collections.sort(ciclistas, new EnergiaComparator());
        }
        if (ordenCiclista == 'A') {
            Collections.sort(ciclistas, new TiempoAscComparator());
        }
        if (ordenCiclista == 'D') {
            Collections.sort(ciclistas, new TiempoDescComparator());
        }
    }

    /**
     * Reordena el vector de bicicletas
     * @param ordenBicicleta char que indica según que se va a ordenar
     */
    public void reOrdenBicileta(char ordenBicicleta) {
        if (ordenBicicleta == 'P') {
            Collections.sort(bicis, new PesoComparator());
        }
        if (ordenBicicleta == 'N') {
            Collections.sort(bicis, new NombreComparator());
        }
    }

    /**
     * Quita un ciclista del vector de ciclistas y lo añade al de abandonados
     * @param c Ciclista que abandona
     */
    public void addCiclistaAbandonado(Ciclista c) {
        ciclistas.remove(c);
        ciclistasAbandonados.add(c);

    }

    /**
     * @return Suma de los tiempo totales acumulados en toda la carrera por todos los ciclistas del equipo
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
     * Envia un ciclista a correr una etapa
     * @param e Etapa a correr
     */
    public void enviarEtapa(Etapa e) {
        Ciclista aux;
        for (int i = 0; i <= ciclistas.size(); i++) {
            aux = ciclistas.get(i);
            aux.correrEtapa(e);
        }
    }

}
