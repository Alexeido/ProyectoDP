
/**
 * Write a description of class BicicletaRapida here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BicicletaRapida extends Bicicleta
{
    // instance variables - repla,ce the example below with your own
    private double velocidadextra;
    /**
     * Constructor for objects of class BicicletaRapida
     */
    public BicicletaRapida(String nombre, double peso,double velocidadextra)
    {
        // initialise instance variables
        super(nombre,peso);
        this.velocidadextra =velocidadextra;
    }
    @Override
        public double getVelocidad(Etapa e, Ciclista c){
        return velocidadextra+super.getVelocidad(e,c);
    }
    @Override
    public double getETime(Etapa e, Ciclista c) {
        return (e.getDistancia() / this.getVelocidad(e, c) * 60);
    }
}


