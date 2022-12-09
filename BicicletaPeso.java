/**
 * Enum para el peso de la Bicicleta
 * 
 * @author Alexeido, Thander y Natera
 * @version
 */

public enum BicicletaPeso {
    VACIA("VACIA", 0),
    LIGERA("LIGERA", 7.35),
    NORMAL("NORMAL", 7.50),
    PESADA("PESADA", 7.85);

    private String nombre;
    private double valor;

    /**
     * Constructor del enum BicicletaPeso
     */
    BicicletaPeso() {
        this.nombre = "";
        this.valor = 0;
    }

    /**
     * @param nombre Nombre de un nuevo peso
     * @param valor  Valor del peso
     */
    BicicletaPeso(String nombre, double valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    /**
     * @return Nombre del enum
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return Valor del enum
     */
    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "<Peso: " + getNombre() + " (valor: " + getValor() + ")>";
    }

}
