<<<<<<< HEAD
import java.util.ArrayList;

/**
 * Representa a los Equipos que competirán tanto por la clasificación por
 * Equipos como
 * por la victoria de uno de sus Ciclistas en el campeonato individual de
 * Ciclistas
 * 
 * @author Alejandro Barrena Millán, Raúl MArtín-Romo Sánchez y Pablo Natera
 *         Muñoz
 * @version (a version number or a date)
 */
public class Equipo {
    // instance variables - replace the example below with your own
    private String nombreEq;
    private ArrayList<Ciclista> ciclistas;
    private ArrayList<Ciclista> ciclistasAbandonados;
    private ArrayList<Bicicleta> bicis;

    /**
     * Constructor de objetos para la clase Equipo
     */
    public Equipo() {
        nombreEq = "";
        ciclistas = new ArrayList<Ciclista>();
        ciclistasAbandonados = new ArrayList<Ciclista>();
        bicis = new ArrayList<Bicicleta>();
    }

    /**
     * Constructor parametrizado de objetos para la clase Equipo
     * 
     * @param nombreEq representa el nombre del equipo
     */

    public Equipo(String nombreEq, ArrayList<Ciclista> ciclistas, ArrayList<Ciclista> ciclistasAbandonados,
            ArrayList<Bicicleta> bicis) {
        this.nombreEq = nombreEq;
        this.ciclistas = ciclistas;
        this.ciclistasAbandonados = ciclistasAbandonados;
        this.bicis = bicis;
    }

    public String getNombreEq() {
        return this.nombreEq;
    }

    public void setNombreEq(String nombreEq) {
        this.nombreEq = nombreEq;
    }

    public ArrayList<Ciclista> getCiclistas() {
        return this.ciclistas;
    }

    public void setCiclistas(ArrayList<Ciclista> ciclistas) {
        this.ciclistas = ciclistas;
    }

    public ArrayList<Ciclista> getCiclistasAbandonados() {
        return this.ciclistasAbandonados;
    }

    public void setCiclistasAbandonados(ArrayList<Ciclista> ciclistasAbandonados) {
        this.ciclistasAbandonados = ciclistasAbandonados;
    }

    public ArrayList<Bicicleta> getBicis() {
        return this.bicis;
    }

    public void setBicis(ArrayList<Bicicleta> bicis) {
        this.bicis = bicis;
    }

=======
            
/**
 * Write a description of class Equipo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Equipo
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Equipo
     */
    public Equipo()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
>>>>>>> 320ad4e6ae0dac251cd1fc5366c634595bf4e9cb
}
