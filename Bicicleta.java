
/**
 * Write a description of class Bicicleta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bicicleta
{
    // instance variables - replace the example below with your own
    private String nombreBic;
    
    private int peso;
    
    private double velocidad;
    
    private double tiempo;
    
    private Ciclista ciclista;
    
    private Etapa etapa;

    /**
     * Constructor for objects of class Bicicleta
     */
    public Bicicleta(String nombreBic, int peso)
    {
        // initialise instance variables
        this.nombreBic=nombreBic;
        this.peso=peso;
        
    }

    public String getNombreBic() {
        return this.nombreBic;
    }

    public void setNombreBic(String nombreBic) {
        this.nombreBic = nombreBic;
    }

    public int getPeso() {
        return this.peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public double getVelocidad() {
        return this.velocidad;
    }

    public void setVelocidad(Ciclista ciclista, Etapa etapa)
    {
        velocidad=(ciclista.getHabilidad()*100/(peso*etapa.getDificultad()));
    }

    public double getTiempo() {
        return this.tiempo;
    }

    public void setTiempo(Etapa etapa) {
        tiempo=etapa.getDistancia()/velocidad;        
    }

    public Ciclista getCiclista() {
        return this.ciclista;
    }

    public void setCiclista(Ciclista ciclista) {
        this.ciclista = ciclista;
    }

    public Etapa getEtapa() {
        return this.etapa;
    }

    public void setEtapa(Etapa etapa) {
        this.etapa = etapa;
    }
    
}

