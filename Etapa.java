
/**
 * Clase siemple que almacena el nombre y la dificultad de una etapa
 * 
 * @author Alexeido, Thander y Natera
 * @version 31-10-2022
 */


public class Etapa {
    private String nombre;
    private EtapaDificultad dificultad;
    /*Grados de dificultad
    *   VACIA = 0;
    *   CORTA  = 150;
    *   INTERMEDIA = 200;
    *   LARAG = 225;
    */
    private EtapaDistancia distancia;
    /*Grados de distancia
    *   VACIA = 0;
    *   SENCILLA = 0.9;
    *   NORMAL = 1.0;
    *   COMPLEJA = 1.1;
    */

    /**
     * Constructor para la clase Etapa
     */
    public Etapa(){
        this.nombre = "";
        setDificultad(EtapaDificultad.VACIA);
        setDistancia(EtapaDistancia.VACIA);
    }

    /**
     * Constructor parametrizado para la clase Etapa
     */
    public Etapa(String nombre, EtapaDificultad dificultad, EtapaDistancia distancia) {
        this.nombre = nombre;
        setDificultad(dificultad);
        setDistancia(distancia);
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
        return dificultad.getValor();
    }

    /**
     * @return El enum de la dificultad
     */
    public EtapaDificultad getEtapaDificultad() {
        return dificultad;
    }

    /**
     * @return Distancia de la etapa
     */
    public double getDistancia() {
        return distancia.getValor();
    }

    /**
     * @return El enum de la etapa
     */
    public EtapaDistancia getEtapaDistancia() {
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
    public void setDificultad(EtapaDificultad dificultad) {
        this.dificultad = dificultad;
    }
    
    /**
     * @param distancia La distancia de la etapa cambia por la insertada como parametro
     */
    public void setDistancia(EtapaDistancia distancia) {
        this.distancia = distancia;
    }
    
    /**
     * Muestra la información de la etapa
     */
    public void mostrarTodo(){
         System.out.println("<Etapa: "+nombre+">  "  + dificultad +"  "+ distancia );
    }
    @Override
    public String toString(){
        return this.getNombre();
    }
}
