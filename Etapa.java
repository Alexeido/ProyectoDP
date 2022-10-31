
/**
 * Clase siemple que almacena el nombre y la dificultad de una etapa
 * 
 * @author Alexeido, Thander y Natera
 * @version 31-10-2022
 */

public class Etapa {
    private String nombre;

    private double dificultad;

    private double distancia;

    /**
     * Constructor para la clase Etapa
     */
    public Etapa() {
        this.nombre = "";
        this.dificultad = 0;
        this.distancia = 0;

    }

    /**
     * Constructor parametrizado para la clase Etapa
     */
    public Etapa(String nombre, double dificultad, double distancia) {
        this.nombre = nombre;
        this.dificultad = dificultad;
        this.distancia = distancia;

    }

    /**
     * @return Nombre de la etapa
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return Nivel de dificultad
     */
    public double getDificultad() {
        return dificultad;
    }

    /**
     * @return Distancia de la etapa
     */
    public double getDistancia() {
        return distancia;
    }

    /**
     * @param nombre El nombre de la etapa cambia por el insertado como parametro
     */
    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param dificultad La dificultad de la etapa cambia por la insertada como parametro
     */
    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }
    
    /**
     * @param distancia La distancia de la etapa cambia por la insertada como parametro
     */
    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }
    
    /**
     * Muestra la información de la etapa
     */
    public void mostrarTodo(){
         System.out.println("<etapa:"+nombre+"> <dificultad: " + dificultad+ "> <distancia: "+ distancia +">");
    }
}
