
/**
 * Write a description of class Ciclista here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ciclista 
{
    // instance variables - replace the example below with your own
    private String nombreCiclic;
    private Bicicleta bici;
    private int habilidad;
    private int  energia;
    private int  resultado;
    private Equipo team;

    /**
     * Constructor for objects of class Ciclista
     */
    public Ciclista(String nombreCiclic, int habilidad,int energia)
    {
    this.nombreCiclic=nombreCiclic;
    this.habilidad=habilidad;
    this.energia=energia;
        
    }
    public int getHabilidad()
    {
        return habilidad;
    }      

    public String getNombreCiclic() {
        return this.nombreCiclic;
    }

    public void setNombreCiclic(String nombreCiclic) {
        this.nombreCiclic = nombreCiclic;
    }

    public Bicicleta getBici() {
        return this.bici;
    }

    public void setBici(Bicicleta bici) {
        this.bici = bici;
    }
    public void setHabilidad(int habilidad) {
        this.habilidad = habilidad;
    }

    public int getEnergia() {
        return this.energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public int getResultado() {
        return this.resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public Equipo getTeam() {
        return this.team;
    }

    public void setTeam(Equipo team) {
        this.team = team;
    }

}
