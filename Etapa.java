
/**
 * Write a description of class Etapa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Etapa
{
    // instance variables - replace the example below with your own
<<<<<<< HEAD
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
=======
    private String nombre;
    
    private int dificultad;
    
    private double distancia;

    /**
     * Constructor for objects of class Etapa
     */
    public Etapa(String nombre,int  dificultad,int distancia)
    {
        this.nombre = nombre;
        this.dificultad = dificultad;
        this.distancia = distancia;
        
    }


    public String getnombre()
    {
    return nombre;
    }
        public int getdificultad()
    {
    return dificultad;
    }
        public double getdistancia()
    {
    return distancia;
>>>>>>> 4467a72d13cc086fb7e3b4986a0a882ba3c7babe
    }
}
