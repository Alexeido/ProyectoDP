/**
 * Clase simple que almacena una bicicleta 
 * 
 * @author Alexeido, Thander y Natera
 * @version 31-10-2022
 */
 



public class Bicicleta {
    private String nombre;
    private double peso;

    /**
     * Constructor for objects of class Bicicleta
     */
    public Bicicleta() {
        nombre = "";
        peso = -1;
    }

    /**
     * Constructor parameterized for objects of class Bicicleta
     * @param nombre Nombre de la bicicleta
     * @param peso Peso de la bicicleta
     */
    public Bicicleta(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    /**
     * @return la dificultad de la etapa
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * @return la distancia de la etapa
     */
    public double getPeso() {
        return this.peso;
    }

    /**
     * @param nombre Establece el nombre de la bicicleta al que entra como parametro
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param peso Establece el peso de la bicicleta al que entra como parametro
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * @param e Objeto etapa que indica la distancia que tiene y su dificultad
     * @param c Objeto ciclista que nos indica la habilidad de este
     * @return La velocidad que alcanza el ciclista c en la etapa e con la bicicleta
     *         actual
     */
    public double getVelocidad(Etapa e, Ciclista c) {
        return ((c.getHabilidad() * 100) / (this.peso * e.getDificultad()));
    }

    /**
     * @param e Objeto etapa que indica la distancia que tiene y su dificultad
     * @param c Objeto ciclista que nos indica la habilidad de este
     * @return El tiempo que tarda el ciclista c en recorrer la etapa e con la
     *         bicicleta this
     */
    public double getETime(Etapa e, Ciclista c) {
        return (e.getDistancia() / this.getVelocidad(e, c) * 60);
    }

    /**
     *  Muestra los atributos de la bicicleta
     */
    public void mostrarTodo(){
     System.out.println("<bicicleta: "+ nombre + "> <peso: "+ peso +">");
    }
}