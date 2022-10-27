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
    // instance variables - replace the example below with your own
    private String nombre;
    private ArrayList<Ciclista> ciclistas;
    private ArrayList<Ciclista> ciclistasAbandonados;
    private ArrayList<Bicicleta> bicis;

    /**
     * Constructor de objetos para la clase Equipo
     */
    public Equipo() {
        nombre = "";
        ciclistas = new ArrayList<Ciclista>();
        ciclistasAbandonados = new ArrayList<Ciclista>();
        bicis = new ArrayList<Bicicleta>();
    }

    /**
     * Constructor parametrizado de objetos para la clase Equipo
     * 
     * @param Nombre representa el nombre del equipo
     */

    public Equipo(String nombre, ArrayList<Ciclista> ciclistas, ArrayList<Ciclista> ciclistasAbandonados,
        ArrayList<Bicicleta> bicis) {
        this.nombre = nombre;
        this.ciclistas = ciclistas;
        this.ciclistasAbandonados = ciclistasAbandonados;
        this.bicis = bicis;
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
    public void addbicileta(Bicicleta b){
        bicis.add(b);
        //Collections.sort(bicis, new PesoComparator());
        //Collections.sort(bicis,   );
    }
    public void addCiclista(Ciclista c){
        ciclistas.add(c);
    }
    public void addCiclistaAbandonado(Ciclista c){
        ciclistasAbandonados.add(c);
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

