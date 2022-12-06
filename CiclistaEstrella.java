
/**
 * Write a description of class CiclistaEstrella here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CiclistaEstrella extends Ciclista
{
    // instance variables - replace the example below with your own
    private int popularidad;
    /**
     * Constructor for objects of class CiclistaEstrella
     */
    public CiclistaEstrella(String nombre, double habilidad, double energia,Equipo team)
    {
        // initialise instance variables
        super(nombre,habilidad,energia,team);
        super.setDestreza(((habilidad + 6) / 140) * 10);        
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void aumentarpuplaridad()
    {
        // put your code here
        popularidad +=4;
    }

    public int getPopularidad(){
        return this.popularidad;
    }
}
