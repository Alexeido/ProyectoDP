/**
 * Clase simple que almacena una bicicleta 
 * 
 * @author Alexeido, Thander y Natera
 * @version (a version number or a date)
 */
 
 import java.util.*;


public class Bicicleta {
    // instance variables - replace the example below with your own
    private String nombre;
    private double peso;

    /**
     * Constructor for objects of class Bicicleta
     */
    public Bicicleta() {
        nombre = "";
        peso = -1;
    }

    /**
     * Constructor parameterized for objects of class Bicicleta
     */
    public Bicicleta(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    /**
     * Devuelve la dificultad de la etapa
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve la distancia de la etapa
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Establece el nombre de la etapa
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece la dificultad de la etapa
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * @param e Objeto etapa que indica la distancia que tiene y su dificultad
     * @param c Objeto ciclista que nos indica la habilidad de este
     * @return La velocidad que alcanza el ciclista c en la etapa e con la bicicleta
     *         actual
     */
    public double getVelocidad(Etapa e, Ciclista c) {
        return ((c.getHabilidad() * 100) / this.peso * e.getDificultad());
    }

    /**
     * @param e Objeto etapa que indica la distancia que tiene y su dificultad
     * @param c Objeto ciclista que nos indica la habilidad de este
     * @return El tiempo que tarda el ciclista c en recorrer la etapa e con la
     *         bicicleta this
     */
    public double getETime(Etapa e, Ciclista c) {
        return (e.getDistancia() / this.getVelocidad(e, c) * 60);
    }

}

class PesoComparator implements Comparator<Bicicleta> {
    public int compare(Bicicleta b1, Bicicleta b2) {
        if (b1.getPeso() == b2.getPeso())
            return 0;
        else if (b1.getPeso() > b2.getPeso())
            return 1;
        else
            return -1;
    }
}

class NombreComparator implements Comparator<Bicicleta> {
    public int compare(Bicicleta b1, Bicicleta b2) {
        return b1.getNombre().compareTo(b2.getNombre());
    }
}