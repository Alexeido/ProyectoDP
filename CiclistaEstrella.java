/**
 * Clase simple que almacena una bicicleta 
 * 
 * @author Alexeido, Thander y Natera
 * @version 
 */
public class CiclistaEstrella extends Ciclista
{
    // instance variables - replace the example below with your own
    private int popularidad;
    /**
     * Constructor for objects of class CiclistaEstrella
     */
    public CiclistaEstrella(String nombre, CiclistaHabilidad habilidad, double energia,Equipo team)
    {
        // initialise instance variables
        super(nombre,habilidad,energia,team);
        super.setDestreza(((getHabilidad() + 6) / 140) * 10); 
        this.popularidad=6;       
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void aumentarpuplaridad()
    {
        popularidad +=4;
    }

    public void disminuirpuplaridad()
    {
        popularidad --;
    }

    public int getPopularidad(){
        return this.popularidad;
    }
}
