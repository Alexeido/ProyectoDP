/**
 * Clase simple que almacena una bicicleta 
 * 
 * @author Alexeido, Thander y Natera
 * @version 
 */
public class CiclistaExperimentado extends Ciclista
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class CiclistaExperimentado
     */

    public CiclistaExperimentado(String nombre, CiclistaHabilidad habilidad, double energia,Equipo team)
    {
        // initialise instance variables
        super(nombre,habilidad,energia,team);
        super.setDestreza(((getHabilidad() + 4) / 130) * 10);       
    }
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */

    
    /* 
     *  Muestra el ciclista sin su bicicleta llamando al super
     */
    @Override
    public void mostrarSinBici(){
        System.out.print ("<CiclistaExperimentado: ");
        super.mostrarSinBici();
        System.out.println();
    }

}
