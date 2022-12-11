/**
 * Enum simple que almacena valores de la Habilidad
 * 
 * @author Alexeido, Thander y Natera
 * @version 1,0
 */

public enum CiclistaHabilidad {
    VACIA("VACIA", 0),
    LENTA("LENTA", 4.0),
    NORMAL("NORMAL", 6.0),
    BUENA("BUENA", 8.0);

    private String nombre;
    private double valor;

    /**
     * Constructor del enum CiclistaHabilidad
     */
    CiclistaHabilidad() {
        this.nombre = "";
        this.valor = 0;
    }

    /**
     * Constructor del enum CiclistaHabilidad
     * 
     * @param nombre Nombre del enum
     * @param valor  Valor del enum
     */
    CiclistaHabilidad(String nombre, double valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    /**
     * @return Nombre enum
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return Valor enum
     */
    public double getValor() {
        return valor;
    }

    //toString del enum CiclistaHabilidad la clase Ciclista 
    @Override
    public String toString() {
        return "<Habilidad: " + getNombre() + " (valor: " + getValor() + ")>";
    }

}