/**
 * Subclase que almacena una bicicleta 
 * 
 * @author Alexeido, Thander y Natera
 * @version 1.0
 */
public class BicicletaPrototipo extends Bicicleta
{
    // instance variables - replace the example below with your own

    /**
     * @param nombre    Nombre para la subclase
     * @param peso      Peso para la subclase
     * Constructor parametrized for objects of subclass BicicletaPrototipo
     */
    public BicicletaPrototipo(String nombre, BicicletaPeso peso)
    {
        // initialise instance variables
        super(nombre,peso);

    }

    
    /* (non-Javadoc)
     * @see Bicicleta#getETime(Etapa, Ciclista)
     */
    @Override
    public double getETime(Etapa e, Ciclista c) {
        return (e.getDistancia() / (super.getVelocidad(e, c) *c.getDestreza()));
    }

    
    /* (non-Javadoc)
     * @see Bicicleta#mostrarTodo()
     */
    @Override
    public void mostrarTodo(){
     System.out.println("<BicicletaPrototipo: "+ super.getNombre() + "> "+ super.getBicicletaPeso());
    }
}
