/**
 * Clase simple que almacena una bicicleta 
 * 
 * @author Alexeido, Thander y Natera
 * @version 
 */

public enum BicicletaPeso{
    VACIA  ("VACIA", 0),
    LIGERA ("LIGERA", 7.35),
    NORMAL ("NORMAL", 7.50),
    PESADA ("PESADA", 7.85);

    private String nombre;
    private double valor;

    BicicletaPeso(){
        this.nombre="";
        this.valor=0;
    }

    BicicletaPeso(String nombre, double valor){
        this.nombre=nombre;
        this.valor=valor;
    }
 
    public String getNombre(){
        return nombre;
    }

    public double getValor(){
        return valor;
    }
    @Override
    public String toString(){
        return "<dist: " + getNombre() + " (valor: "+ getValor()+ ")>";
    }

}
