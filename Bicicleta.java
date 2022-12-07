/**
 * Clase simple que almacena una bicicleta 
 * 
 * @author Alexeido, Thander y Natera
 * @version 31-10-2022
 */
 



public class Bicicleta {
    private String nombre;
    /*Grados de peso
    *   VACIA = 0;
    *   LIGERA = 7.35
    *   NORMAL = 7.50
    *   PESADA = 7.85
    */
    private BicicletaPeso peso;

    /**
     * Constructor for objects of class Bicicleta
     */
    public Bicicleta() {
        nombre = "";
        setPeso(BicicletaPeso.VACIA);
    }

    /**
     * Constructor parameterized for objects of class Bicicleta
     * @param nombre Nombre de la bicicleta
     * @param peso Peso de la bicicleta
     */
    public Bicicleta(String nombre, BicicletaPeso peso) {
        this.nombre = nombre;
        setPeso(peso);
    }

    /**
     * @return el nombre de la Bicicleta
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * @return el peso de la bicicleta
     */
    public double getPeso() {
        return this.peso.getValor();
    }

    /**
     * @return la distancia de la etapa
     */
    public BicicletaPeso getBicicletaPeso() {
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
    public void setPeso(BicicletaPeso peso) {
        this.peso = peso;
    }

    /**
     * @param e Objeto etapa que indica la distancia que tiene y su dificultad
     * @param c Objeto ciclista que nos indica la habilidad de este
     * @return La velocidad que alcanza el ciclista c en la etapa e con la bicicleta
     *         actual
     */
    public double getVelocidad(Etapa e, Ciclista c) {
        return ((c.getHabilidad() * 100) / (this.getPeso() * e.getDificultad()));
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
     System.out.println("<Bicicleta: "+ nombre + "> "+ peso +">");
    }
}