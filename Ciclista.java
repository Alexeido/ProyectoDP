
/**
 * Clase que almacena un ciclista y sus metodos para correr etapas y compararse entre otros ciclistas 
 * 
 * @author Alexeido, Thander y Natera
 * @version (a version number or a date)
 */
 
 import java.util.*;


public class Ciclista {
    private String nombre;
    private Bicicleta bici;
    private int habilidad;
    private double energia;
    private ArrayList<Resultados> historial;
    private Equipo team;
    private double totalTime;

    public Ciclista() {
        this.nombre = "";
        this.bici = new Bicicleta();
        this.habilidad = -1;
        this.energia = -1;
        this.historial = new ArrayList<>();
        this.team = new Equipo();
        this.totalTime=0;
    }

    public Ciclista(String nombre, Bicicleta bici, int habilidad, int energia, ArrayList<Resultados> historial,
            Equipo team) {
        this.nombre = nombre;
        this.bici = bici;
        this.habilidad = habilidad;
        this.energia = energia;
        this.historial = historial;
        this.team = team;
        this.totalTime=0;
    }

    public Ciclista(String nombre, Bicicleta bici, int habilidad, int energia, Equipo team) {
        this.nombre = nombre;
        this.bici = bici;
        this.habilidad = habilidad;
        this.energia = energia;
        this.historial = new ArrayList<>();
        this.team = team;
        this.totalTime=0;
    }

    /**
     * @return Nombre del ciclista
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * @param nombre Establece el nombre a este
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return La bicicleta actual del ciclista
     */
    public Bicicleta getBicicleta() {
        return this.bici;
    }

    /**
     * @param b Establece la bicicleta actual a la que entra como parametro
     */
    public void setBicicleta(Bicicleta bici) {
        this.bici = bici;
    }

    /**
     * @return La habilidad del ciclista
     */
    public int getHabilidad() {
        return this.habilidad;
    }

    /**
     * @param habilidad Establece la habilidad actual a la que entra como parametro
     */
    public void setHabilidad(int habilidad) {
        this.habilidad = habilidad;
    }

    /**
     * @return La energia que le queda al ciclista
     */
    public double getEnergia() {
        return this.energia;
    }

    /**
     * @param energia Establece la energia actual al que entra como parametro
     */
    public void setEnergia(double energia) {
        this.energia = energia;
    }

    /**
     * @return El historial de carreras
     */
    public ArrayList<Resultados> getHistorial() {
        return this.historial;
    }

    /**
     * @param historial Establece el historial actual al que entra como parametro
     */
    public void setHistorial(ArrayList<Resultados> historial) {
        this.historial = historial;
    }

    /**
     * @return Equipo al que pertenece
     */
    public Equipo getTeam() {
        return this.team;
    }

    /**
     * @param team Establece el equipo actual al que entra como parametro
     */
    public void setTeam(Equipo team) {
        this.team = team;
    }
    
    /**
     * @return tiempo total en su historial
     */
    public double getTotalTime(){
        return this.totalTime;
    }

    /**
     * @param totalTime Establece el tiempototal actual por el que entra como parametro
     */
    public void setTotalTime(double totalTime){
        this.totalTime=totalTime;
    }

    /*
     * Muestra la información de un ciclista y de su bicicleta
     */
    public void mostrarTodo(){
         System.out.println("Nombre:"+nombre +"/Con habilidad:" +habilidad +"/Con energia"+energia + " con su biclieta:");
         bici.mostrarTodo();
    }
    
    /**
     * @param e Etapa a correr
     * Si el usuario se ha quedado sin energía en la competición y no ha podido acabar tendrá como energía -1
     * El algoritmo almacenará automaticamente su resultado en Resultados
     * El algoritmo sumará a su tiempo total el tiempo que ha hecho en esta etapa solo si ha ganado 
     */
    public double correrEtapa(Etapa e) {
        double aux = this.getEnergia() - this.getBicicleta().getETime(e, this);
        double aux2=aux;
        if(aux>=0){
            this.setEnergia(aux);
            aux2=this.getBicicleta().getETime(e, this);
            this.totalTime+=aux2;
            this.getHistorial().add(new Resultados(e, aux2));
            
        }
        else{
            this.setEnergia(-1);
            this.getHistorial().add(new Resultados(e, aux));
            this.totalTime+=this.energia;
        }
        return aux;

    }
}

class HabilidadComparator implements Comparator<Ciclista> {
    public int compare(Ciclista c1, Ciclista c2) {
        if (c1.getHabilidad() == c2.getHabilidad())
            return 0;
        else if (c1.getHabilidad() >c2.getHabilidad())
            return 1;
        else
            return -1;
    }
}

class NombreCComparator implements Comparator<Ciclista> {
    public int compare(Ciclista b1, Ciclista b2) {
        return b1.getNombre().compareTo(b2.getNombre());
    }
}
class EnergiaComparator implements Comparator<Ciclista> {
    public int compare(Ciclista c1, Ciclista c2) {
        if (c1.getEnergia() == c2.getEnergia())
            return 0;
        else if (c1.getEnergia() >c2.getEnergia())
            return 1;
        else
            return -1;
    }
}
class TiempoAscComparator implements Comparator<Ciclista> {
    public int compare(Ciclista c1, Ciclista c2) {
        if (c1.getTotalTime() == c2.getTotalTime())
            return  new NombreCComparator().compare(c1, c2) ;
        else if (c1.getTotalTime() >c2.getTotalTime())
            return 1;
        else
            return -1;
    }
}
class TiempoDescComparator implements Comparator<Ciclista> {
    public int compare(Ciclista c1, Ciclista c2) {
        if (c1.getTotalTime() == c2.getTotalTime())
            return  new NombreCComparator().compare(c1, c2) ;
        else if (c1.getTotalTime() >c2.getTotalTime())
            return 1;
        else
            return -1;
    }
}