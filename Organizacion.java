import java.util.*;

/**
 * La organización se encarga de gestionar toda la carrera
 * 
 * @author Alexeido, Thander y Natera
 * @version (a version number or a date)
 */
public class Organizacion {
    // instance variables - replace the example below with your own
    private ArrayList<Etapa> etapas;
    private ArrayList<Equipo> equipos;
    private ArrayList<Ciclista> ciclistasCarrera;
    private ArrayList<Ciclista> ciclistasAbandono;

    /**
     * Constructor para la calse Organizacion
     */
    public Organizacion() {
        // initialise instance variables
        etapas = new ArrayList<Etapa>();
        equipos = new ArrayList<Equipo>();
        ciclistasCarrera= new ArrayList<Ciclista>();
    }

    /**
     * Constructor para la calse Organizacion
     */
    public Organizacion(ArrayList<Etapa> etapas, ArrayList<Equipo> equipos,
            ArrayList<Ciclista> ciclistasCarrera, ArrayList<Ciclista> ciclistasAbandono) {
        this.etapas = etapas;
        this.equipos = equipos;
        this.ciclistasCarrera = ciclistasCarrera;
        this.ciclistasAbandono = ciclistasAbandono;
    }

    /**
     * Añade un equipo a la Arraylistis de equipos
     */
    public void anadirEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    public void anadirCiclistas(Equipo equipo){
        int i;
        ArrayList<Ciclista> ciclistaEquipo;
         i=equipos.indexOf(equipo);
            ciclistaEquipo= equipo.getCiclistas();
            for (i=0; i<ciclistaEquipo.size(); i++){
                ciclistasCarrera.add(ciclistaEquipo.get(i));
            }
    }

    /**
     * Añade una etapa a la Arraylistis de etapas
     */
    public void anadirEtapa(Etapa etapa) {
        etapas.add(etapa);
    }

    public void abandonar(Ciclista cilista) {
        ciclistasCarrera.remove(cilista);
    }
    
    public void avanzarCarrera(){
        System.out.println("Las etapas de esta carrera son las siguientes: ");
        mostrarEtapas();
        System.out.println("Los corredores de esta carrera son los siguientes: ");
        mostrarCiclistas();
        for(int i=0; i< etapas.size();){
            System.out.println("Comienza la etapa: "+etapas.get(i).getNombre());
                 for(int n=0; n< ciclistasCarrera.size();n++){
                    System.out.println("Informacion del clista numero "+n);
                    ciclistasCarrera.get(n).mostrarTodo();
                    System.out.print("/La velocidad que es capaz de alcanzar en esta etapa es" + ciclistasCarrera.get(n).getBicicleta().getVelocidad(etapas.get(i), ciclistasCarrera.get(n)));     
                    double aux=ciclistasCarrera.get(n).correrEtapa(etapas.get(i));
                    System.out.println("El ciclista tardad "+ ciclistasCarrera.get(n).getHistorial().get(i).getTiempo() + " en completar la carrera");
                    System.out.print("La energia que le queda al corredor es : " + aux);
                    if(aux<=0){
                        abandonar(ciclistasCarrera.get(n));
                        ciclistasCarrera.get(n).getTeam().addCiclistaAbandonado(ciclistasCarrera.get(n));
                    }
                    else
                        i++;
                 } 

        }
    }
    /**
     * Muestra los equipos que van a competir
     */
    public void mostrarEquipos(){
        for(Equipo equipo: equipos){
            System.out.print(equipo.getNombre());
        }
    }

    /**
     * Muestra las etapas de la carrera
     */
    public void mostrarEtapas(){
        for(Etapa etapa: etapas){
            etapa.mostrarTodo();
        }
    }

    /**
     * Muestra los ciclistas que estan participando en la carrera
     */
    public void mostrarCiclistas(){
        for(Ciclista ciclista: ciclistasCarrera){
            ciclista.mostrarTodo();
        }
    }
    
    /**
     * Muestra los ciclistas que han abandonado
     */
    public void mostrarAbandonos(){
        for(Ciclista ciclista: ciclistasAbandono){
            ciclista.mostrarTodo();
        }
    }
    
    public void entregaPremios() {
        for(int i=0;i<=ciclistasCarrera.size();i++){
        Collections.sort(ciclistasCarrera , new TiempoAscComparator());
        }
        for(int i=0;i<=ciclistasAbandono.size();i++){
        Collections.sort(ciclistasAbandono , new TiempoAscComparator());
        }
        Ciclista ciclistaGanador;
        Equipo equipoGanador;

        if (ciclistasCarrera.size() == 0) {
            System.out.print("No hay ganadores");
        } else {
            ciclistaGanador=ciclistasCarrera.get(0);
        }

    }
}

class TiempoMedioAscComparator implements Comparator<Ciclista> {
    public int compare(Ciclista c1, Ciclista c2) {
        if (c1.getTotalTime() == c2.getTotalTime())
            return  new NombreCComparator().compare(c1, c2) ;
        else if (c1.getTotalTime() >c2.getTotalTime())
            return 1;
        else
            return -1;
    }
}
class TiempoMedioDescComparator implements Comparator<Ciclista> {
    public int compare(Ciclista c1, Ciclista c2) {
        if (c1.getTotalTime() == c2.getTotalTime())
            return  new NombreCComparator().compare(c1, c2) ;
        else if (c1.getTotalTime() >c2.getTotalTime())
            return 1;
        else
            return -1;
    }
}




