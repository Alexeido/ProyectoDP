
/**
 * Write a description of class Etapa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Etapa 
{
    // instance variables - replace the example below with your own
    private String nombreEt;
    
    private int dificultad;
    
    private double distancia;

    /**
     * Constructor for objects of class Etapa
     */
    public Etapa(String nombreEt,int  dificultad,int distancia)
    {
        this.nombreEt = nombreEt;
        this.dificultad = dificultad;
        this.distancia = distancia;
        
    }


    public String getNombreEt()
    {
    return nombreEt;
    }
        public int getDificultad()
    {
    return dificultad;
    }
        public double getDistancia()
    {
    return distancia;
    }
}
