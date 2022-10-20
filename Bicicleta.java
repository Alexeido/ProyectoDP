
/**
 * Write a description of class Bicicleta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bicicleta
{
    // instance variables - replace the example below with your own
    private String nombreBic;
    
    private int peso;
    
    private double velocidad;
    
    private double tiempo;
    
    private Ciclista ciclista;
    
    private Etapa etapa;

    /**
     * Constructor for objects of class Bicicleta
     */
    public Bicicleta(String nombreBic, int peso)
    {
        // initialise instance variables
        this.nombreBic=nombreBic;
        this.peso=peso;
        
    }
    public void setVelocidad(Ciclista ciclista, Etapa etapa)
    {
        velocidad=(ciclista.getHabilidad()*100/(peso*etapa.getDificultad()));
    }
    public void setTiempo(Etapa etapa) {
        tiempo=etapa.getDistancia()/velocidad;        
    }
}   

