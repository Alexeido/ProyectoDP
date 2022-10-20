
/**
 * Write a description of class Etapa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Etapa
{
    // instance variables - replace the example below with your own
    private String nombre;
    
    private int dificultad;
    
    private int distancia;

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
        public int getdistancia()
    {
    return distancia;
    }
}
