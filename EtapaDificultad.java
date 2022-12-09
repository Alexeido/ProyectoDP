/**
 * Clase simple que almacena una bicicleta 
 * 
 * @author Alexeido, Thander y Natera
 * @version 
 */

public enum EtapaDificultad{
    VACIA ("VACIA", 0),
    SENCILLA ("SENCILLA", 0.9),
    NORMAL ("NORMAL", 1.0),
    COMPLEJA ("COMPLEJA", 1.1);

    private String nombre;
    private double valor;

    EtapaDificultad(){
        this.nombre="";
        this.valor=0;
    }

    EtapaDificultad(String nombre, double valor){
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
        return "<Dificultad: " + getNombre() + " (valor: "+ getValor()+ ")>";
    }

}