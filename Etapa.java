
/**
 * Write a description of class Etapa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Etapa
{
    // instance variables - replace the example below with your own
    private int distancia;
    private double dificultad;
    private String nombre;

    /**
     * Constructor for objects of class Etapa
     */
    public Etapa()
    {
        // initialise instance variables
        distancia=0;
        dificultad=0;
        nombre="";
    }
    
    /**
     * Constructor for objects of class Etapa
     */
    public Etapa(int distancia, int dificultad, String nombre)
    {
        // initialise instance variables
        this.distancia=distancia;
        this.dificultad=dificultad;
        this.nombre=nombre;
    }
}
