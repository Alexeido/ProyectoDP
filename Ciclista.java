
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
    private double habilidad;
    private double energia;
    private ArrayList<Resultados> historial;
    private Equipo team;
    private Etapa Eorden;
    private double totalTime;

    /**
     *  Constructor por defecto de la clase Ciclista
     */
    public Ciclista() {
        this.nombre = "";
        this.bici = new Bicicleta();
        this.habilidad = -1;
        this.energia = -1;
        this.historial = new ArrayList<Resultados>();
        this.team = new Equipo();
        this.totalTime=0;
        Eorden = new Etapa();
    }

    /**
     * 
     * Constructor parametrizado de la clase Ciclista
     * 
     * @param nombre        Inicializa el nombre de la instancia por este
     * @param habilidad     Inicializa la habilidad de la instancia por esta
     * @param energia       Inicializa la energía de la instancia por esta
     * @param team          Inicializa el equipo de la instancia por este
     */
    public Ciclista(String nombre, double habilidad, double energia,Equipo team) {
        this.nombre = nombre;
        this.habilidad = habilidad;
        this.energia = energia;
        this.team = team;
        this.totalTime=0;
        this.bici = new Bicicleta();
        this.historial = new ArrayList<Resultados>();
        Eorden = new Etapa();
    }

    /**
     * 
     * Constructor parametrizado de la clase Ciclista
     * 
     * @param nombre        Inicializa el nombre de la instancia por este
     * @param bici          Inicializa la bicicleta de la instancia por esta
     * @param habilidad     Inicializa la habilidad de la instancia por esta
     * @param energia       Inicializa la energía de la instancia por esta
     * @param team          Inicializa el equipo de la instancia por este
     */
    public Ciclista(String nombre, Bicicleta bici, double habilidad, double energia, Equipo team) {
        this.nombre = nombre;
        this.bici = bici;
        this.habilidad = habilidad;
        this.energia = energia;
        this.historial = new ArrayList<Resultados>();
        this.team = team;
        this.totalTime=0;
        Eorden = new Etapa();
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
    public double getHabilidad() {
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
     * @return Devuelve la etapa en la que se estan comparando los ciclistas 
     */
    public Etapa getEtapa(){
        return Eorden;
    }
    
    /**
     * @param Eorden Establece la etapa en la que se compararán
     */
    public void setEtapa(Etapa Eorden){
        this.Eorden = Eorden;
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
         System.out.println('\n'+"Nombre:"+nombre +"/Con habilidad:" +String.format("%.2f",habilidad) +"/Con energia"+String.format("%.2f",energia)  + " con su biclieta:");
         bici.mostrarTodo();
    }

    /*
     * Muestra la información de un ciclista
     */
    public void mostrarSinBici(){
        String abandonado="<Sin abandono>" ;
        if(energia<0){
            abandonado=" <abandonado> ";
        }
        System.out.println("<Nombre: "+nombre +"> <con habilidad: " +String.format("%.2f",habilidad) +"> <con energia: "+String.format("%.2f",energia) + "> <tiempo acumulado sin abandonar: "+String.format("%.2f",totalTime) + "> "+ abandonado );
   }

    /*
     * Muestra la puntuacion de cada ciclista
     */
    public void mostrarPuntuacion(){
        System.out.println("Nombre: "+ nombre + " Tiene como tiempo total :"+ String.format("%.2f",totalTime));
        for(Resultados puntaje: historial){
            puntaje.mostrarResultadoEtapa();
        }
    }


    /**
     * @param etapa Etapa de la que se mostrará la información
     */
    public void mostrarResultadoEtapa(Etapa etapa){
        boolean encontrado=false;
        for(int i=0;i<=historial.size() && !encontrado ;i++){
            if (historial.get(i).getSitio().getNombre()==etapa.getNombre()){
                System.out.println(nombre+ " - Tiempo: "+ String.format("%.2f",historial.get(i).getTiempo()));
                encontrado=true;
            }
        }   
    }
    /**
     * @param e Etapa a correr
     * Si el usuario se ha quedado sin energía en la competición y no ha podido acabar tendrá energia negativa
     * El algoritmo almacenará automaticamente su resultado en Resultados
     * El algoritmo sumará a su tiempo total el tiempo que ha hecho en esta etapa solo si ha ganado 
     */
    public double correrEtapa(Etapa e) {
        double aux = this.getEnergia() - this.getBicicleta().getETime(e, this);
        double aux2=aux;
        double time;
        if(aux>=0){
            this.setEnergia(aux);
            aux2=this.getBicicleta().getETime(e, this);
            time=aux2;
            this.totalTime+=aux2;
            this.getHistorial().add(new Resultados(e, aux2));
            
        }
        else{
            this.setEnergia(aux);
            this.getHistorial().add(new Resultados(e, aux));
            time=this.getBicicleta().getETime(e, this)-aux;
            this.totalTime+=this.energia;
        }
        return time;

    }
    public void mostrarhistorial(){
        for(int i=0;i<historial.size();i++){
            historial.get(i).mostrarResultadoEtapa();
        }
    }
}

