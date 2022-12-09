/**
 * Subclase de ciclista 
 * 
 * @author Alexeido, Thander y Natera
 * @version 
 */
public class CiclistaExperimentado extends Ciclista
{
    
    /**
     * 
     * Constructor de la subclase CiclistaExperimentado
     * 
     * @param nombre        Nombre para la subclase
     * @param habilidad     Habilidad para la subclase
     * @param energia       Energia para la subclase
     * @param team          Equipo para la subclase
     */
    public CiclistaExperimentado(String nombre, CiclistaHabilidad habilidad, double energia,Equipo team)
    {
        // initialise instance variables
        super(nombre,habilidad,energia,team);
        super.setDestreza(((getHabilidad() + 4) / 130) * 10);       
    }

    
    /* (non-Javadoc)
     * @see Ciclista#mostrarSinBici()
     */
    @Override
    public void mostrarSinBici(){
        System.out.print ("<CiclistaExperimentado: ");
        super.mostrarSinBici();
        System.out.println();
    }

}
