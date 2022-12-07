/**
 * Clase simple que almacena una bicicleta 
 * 
 * @author Alexeido, Thander y Natera
 * @version 1.0
 */
public class BicicletaRapida extends Bicicleta
{
    private double velocidadextra;


    /**
     * 
     * Constructor for object of subclass BicicletaRapida
     * @param nombre            Nombre para la subclase
     * @param peso              Peso para la subclase
     * @param velocidadextra    Velocidad Extra para la bicicletaRapida
     */
    public BicicletaRapida(String nombre, BicicletaPeso peso,double velocidadextra)
    {
        // initialise instance variables
        super(nombre,peso);
        this.velocidadextra =velocidadextra;
    }

    /* (non-Javadoc)
     * @see Bicicleta#getVelocidad(Etapa, Ciclista)
     */
    @Override
        public double getVelocidad(Etapa e, Ciclista c){
        return velocidadextra+super.getVelocidad(e,c);
    }

    /* (non-Javadoc)
     * @see Bicicleta#getETime(Etapa, Ciclista)
     */
    @Override
    public double getETime(Etapa e, Ciclista c) {
        return (e.getDistancia() / this.getVelocidad(e, c) * 60);
    }

    /* (non-Javadoc)
     * @see Bicicleta#mostrarTodo()
     */
    @Override
    public void mostrarTodo(){
     System.out.println("<BicicletaRapida: "+ super.getNombre() + "> "+ super.getBicicletaPeso());
    }
}


