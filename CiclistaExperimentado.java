
/**
 * Write a description of class CiclistaExperimentado here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CiclistaExperimentado extends Ciclista
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class CiclistaExperimentado
     */

    public CiclistaExperimentado(String nombre, double habilidad, double energia,Equipo team)
    {
        // initialise instance variables
        super(nombre,habilidad,energia,team);
        super.setDestreza(((habilidad + 4) / 130) * 10);       
    }
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */

}
