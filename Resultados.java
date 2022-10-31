
/**
 * Clase siemple que almacena el resultado de una etapa concreta
 * 
 * @author Alexeido, Thander y Natera
 * @version 31-10-2022
 */

public class Resultados {
    // instance variables - replace the example below with your own
    private Etapa sitio;
    private double tiempo;

    /**
     * Constructor de objetos de la calse Resultados
     */
    public Resultados() {
        sitio = new Etapa();
        tiempo = 0;
    }

    /**
     * Constructor parametrizado de objetos de la calse Resultados
     * @param sitio Etapa recorrida
     * @param tiempo Tiempo tardado en recorrer la etapa
     */
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

    /**
     * Muestra los resultados de la etapa
     */
    public void mostrarResultadoEtapa(){
        System.out.println("Carrera ("+sitio.getNombre() + ") Tiempo: " + String.format("%.2f",tiempo) + " minutos "); 
    }
}
