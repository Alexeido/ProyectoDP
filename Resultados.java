
/**
 * Clase siemple que almacena el resultado de una etapa concreta
 * 
 * @author Alexeido, Thander y Natera
 * @version (a version number or a date)
 */

public class Resultados {
    // instance variables - replace the example below with your own
    private Etapa sitio;
    private double tiempo;

    /**
     * Constructor for objects of class Resultados
     */
    public Resultados() {
        sitio = new Etapa();
        tiempo = 0;
    }

    public Resultados(Etapa sitio, double tiempo) {
        this.sitio = sitio;
        this.tiempo = tiempo;
    }

    /**
     * @return Etapa donde se consiguió el resultado
     */
    public Etapa getSitio() {
        return sitio;
    }

    /**
     * @return si >=0 Tiempo que ha tardado en recorrer una etapa 
     * @return si <0 energía que le ha faltado para completar una etapa
     */
    public double getTiempo() {
        return tiempo;
    }

    /**
     * @param sitio Establece la etapa donde se realiza el resultado por la recibida como parametro
     */
    public void setSitio(Etapa sitio) {
        this.sitio = sitio;
    }


    /**
     * @param tiempo Establece el tiempo del resultado por el recibido como parámetro
     */
    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }
    public void mostrarResultadoEtapa(){
        System.out.println("Carrera ("+sitio.getNombre() + ") Tiempo: " + tiempo + " Minutos "); 
    }
}
