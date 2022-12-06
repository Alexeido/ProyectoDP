/**
 * Clase simple que almacena una bicicleta 
 * 
 * @author Alexeido, Thander y Natera
 * @version 
 */
public class CiclistaNovato extends Ciclista
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class CiclistaNovato
     */

    public CiclistaNovato(String nombre, CiclistaHabilidad habilidad, double energia,Equipo team)
    {
        // initialise instance variables
        super(nombre,habilidad,energia,team);
        super.setDestreza(((getHabilidad() + 2) / 120) * 10);        
    }
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */

}
