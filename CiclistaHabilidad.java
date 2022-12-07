/**
 * Clase simple que almacena una bicicleta 
 * 
 * @author Alexeido, Thander y Natera
 * @version 
 */

public enum CiclistaHabilidad{
    VACIA   ("VACIA", 0),
    LENTA   ("LENTA", 4.0),
    NORMAL  ("NORMAL", 6.0),
    BUENA   ("BUENA", 8.0);

    private String nombre;
    private double valor;

    CiclistaHabilidad(){
        this.nombre="";
        this.valor=0;
    }

    CiclistaHabilidad(String nombre, double valor){
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
        return "<Habilidad: " + getNombre() + " (valor: "+ getValor()+ ")>";
    }

}