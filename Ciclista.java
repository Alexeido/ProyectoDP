
/**
 * Write a description of class Ciclista here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ciclista 
{
    // instance variables - replace the example below with your own
    private String nombreCiclic;
    private Bicicleta bici;
    private int habilidad;
    private int  energia;
    private int  resultado;
    private Equipo team;

    /**
     * Constructor for objects of class Ciclista
     */
    public Ciclista(String nombreCiclic, int habilidad,int energia)
    {
    this.nombreCiclic=nombreCiclic;
    this.habilidad=habilidad;
    this.energia=energia;
        
    }
    public int getHabilidad()
    {
        return habilidad;
    }

}
