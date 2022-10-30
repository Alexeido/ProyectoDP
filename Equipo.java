import java.util.*;

/**
 * Representa a los Equipos que competirán tanto por la clasificación por
 * Equipos como
 * por la victoria de uno de sus Ciclistas en el campeonato individual de
 * Ciclistas
 * 
 * @author Alexeido, Thander y Natera
 * @version (a version number or a date)
 */
public class Equipo {
    private String nombre;
    private ArrayList<Ciclista> ciclistas;
    private ArrayList<Ciclista> ciclistasAbandonados;
    private ArrayList<Bicicleta> bicis;
    private double tiempoMedio;
    /**
     *  Almacena el algoritmo de ordenacion que se usará para las bicicletas
     *  
     *  'P' = Ordenación por peso
     *  'N' = Ordenación por nombre
     *
     */
    private char ordenBicicleta;
    /**
     *  Almacena el algoritmo de ordenacion que se usará para los ciclistas
     *  
     *  'H' = Ordenación por Habilidad
     *  'N' = Ordenación por nombre
     *  'E' = Ordenación por Energía
     *  'A' = Ordenación por Tiempo ascendente
     *  'D' = Ordenacion por Tiempo Descendente
     *
     */
    private char ordenCiclista;

    /**
     * Constructor de objetos para la clase Equipo
     */
    public Equipo() {
        nombre = "";
        ciclistas = new ArrayList<Ciclista>();
        ciclistasAbandonados = new ArrayList<Ciclista>();
        bicis = new ArrayList<Bicicleta>();
        tiempoMedio=0;
        this.ordenBicicleta='0';
        this.ordenCiclista='0';
    }

    /**
     * Constructor parametrizado de objetos para la clase Equipo
     * 
     * @param Nombre representa el nombre del equipo
     */

    public Equipo(String nombre, ArrayList<Ciclista> ciclistas, ArrayList<Ciclista> ciclistasAbandonados,
        ArrayList<Bicicleta> bicis, double tiempoMedio, char ordenCiclista, char ordenBicicleta) {
        this.nombre = nombre;
        this.ciclistas = ciclistas;
        this.ciclistasAbandonados = ciclistasAbandonados;
        this.bicis = bicis;
        this.tiempoMedio=tiempoMedio;
        this.ordenBicicleta=ordenBicicleta;
        this.ordenCiclista=ordenCiclista;
    }

    public Equipo(String nombre, char ordenCiclista, char ordenBicicleta){
        this.nombre=nombre;
        this.ordenBicicleta=ordenBicicleta;
        this.ordenCiclista=ordenCiclista;
        ciclistas = new ArrayList<Ciclista>();
        ciclistasAbandonados = new ArrayList<Ciclista>();
        bicis = new ArrayList<Bicicleta>();
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Ciclista> getCiclistas() {
        return this.ciclistas;
    }

    public void setCiclistas(ArrayList<Ciclista> ciclistas) {
        this.ciclistas = ciclistas;
    }

    public ArrayList<Ciclista> getCiclistasAbandonados() {
        return this.ciclistasAbandonados;
    }
    public ArrayList<Bicicleta> getBicis() {
        return this.bicis;
    }

      /*
     * 
     */
    public void setTiempoMedio(Equipo equipo){
        this.tiempoMedio=getTiempototal()/ciclistas.size();
    }

     /*
     * 
     */
    public double getTiempoMedio(){
        return this.tiempoMedio;
    }
    
    public char getOrdenBicicleta(){
        return this.ordenBicicleta;
    }

    public void setOrdenBicicleta(char ordenBicicleta){
        this.ordenBicicleta=ordenBicicleta;
    }
    
    public char getOrdenCiclista(){
        return this.ordenCiclista;
    }

    public void setOrdenCiclista(char ordenCiclista){
        this.ordenCiclista=ordenCiclista;
    }

    public void mostrarTodo(Equipo equipo){
        System.out.print(nombre);
        for (int i=0; i<ciclistas.size(); i++){
            ciclistas.get(i).mostrarTodo();
        }
    }
     public void mostrarTodoPuntaje(Equipo equipo){
        System.out.println(nombre + " Cuya media de puntos de sus ciclistas sin abandonar es: " + tiempoMedio );
        for (int i=0; i<ciclistas.size(); i++){
            ciclistas.get(i).mostrarSinBici();//<ciclista:VAN VLEUTEN> <energía: 50.92> <habilidad: 4.96> <tiempo acumulado sin abandonar: 1149.08> <abandonado:false>
        }

        for (int i=0; i<ciclistasAbandonados.size();i++){
            ciclistas.get(i).mostrarSinBici();
            System.out.print("<Abandonado>");
        }
    }
    public void mostrarAbandonos(){
        for(Ciclista ciclista: ciclistasAbandonados){
            ciclista.mostrarTodo();
        }
    }
    
    public void addbicileta(Bicicleta b){
        bicis.add(b);
        this.reOrdenBicileta(this.ordenBicicleta);
    }
    public void addCiclista(Ciclista c){
        ciclistas.add(c);
        this.reOrdenCiclista(this.ordenCiclista);
    }

    public void reOrdenCiclista(char ordenCiclista){
        if(ordenCiclista=='H'){
            Collections.sort(ciclistas, new HabilidadComparator());
        }
        if(ordenCiclista=='N'){
            Collections.sort(ciclistas, new NombreCComparator());
        }
        if(ordenCiclista=='E'){
            Collections.sort(ciclistas, new EnergiaComparator());
        }
        if(ordenCiclista=='A'){
            Collections.sort(ciclistas, new TiempoAscComparator());
        }
        if(ordenCiclista=='D'){
            Collections.sort(ciclistas, new TiempoDescComparator());
        }
    }
    
    public void reOrdenBicileta(char ordenBicicleta){
        if(ordenBicicleta=='P'){
            Collections.sort(bicis, new PesoComparator());
        }
        if(ordenBicicleta=='N'){
            Collections.sort(bicis,new NombreComparator());
        }
    }
    public void addCiclistaAbandonado(Ciclista c){
        ciclistasAbandonados.add(c);
        ciclistas.remove(c);
    }
    public double getTiempototal(){
        double result=0;
        Ciclista aux;
        for(int i=0;i<=ciclistas.size();i++){
            aux=ciclistas.get(i);
            result=result+aux.getTotalTime();
        }
        return result;
    }
    public void enviarEtapa(Etapa e){
        Ciclista aux;
        for(int i=0;i<=ciclistas.size();i++){
            aux=ciclistas.get(i);
            aux.correrEtapa(e);     
        }
    }

}

