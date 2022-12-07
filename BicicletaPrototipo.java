/**
 * Clase simple que almacena una bicicleta 
 * 
 * @author Alexeido, Thander y Natera
 * @version 
 */
public class BicicletaPrototipo extends Bicicleta
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class BicicletaPrototipo
     */
    public BicicletaPrototipo(String nombre, BicicletaPeso peso)
    {
        // initialise instance variables
        super(nombre,peso);

    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    @Override
    public double getETime(Etapa e, Ciclista c) {
        return (e.getDistancia() / (super.getVelocidad(e, c) *c.getDestreza()));
    }

    /**
     *  Muestra los atributos de la bicicleta
     */
    @Override
    public void mostrarTodo(){
     System.out.println("<BicicletaPrototipo: "+ super.getNombre() + "> "+ super.getBicicletaPeso());
    }
}
