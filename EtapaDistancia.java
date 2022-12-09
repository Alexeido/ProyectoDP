/**
 * Clase simple que almacena una bicicleta 
 * 
 * @author Alexeido, Thander y Natera
 * @version 
 */

  public enum EtapaDistancia{
    VACIA ("VACIA", 0),
    CORTA ("CORTA", 150.0),
    INTERMEDIA ("INTERMEDIA", 200.0),
    LARGA ("LARGA", 225.0);

    private String nombre;
    private double valor;

    EtapaDistancia(String nombre, double valor){
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
        return "<Distancia: " + getNombre() + " (valor: "+ getValor()+ ")>";
    }

}