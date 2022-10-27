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
    public void añadirEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    /**
     * Añade una etapa a la Arraylistis de etapas
     */
    public void añadirEtapa(Etapa etapa) {
        etapas.add(etapa);
    }

    public void abandonar(Ciclista cilista) {
        ciclistasCarrera.remove(cilista);
        ciclistasAbandono.add(cilista);
    }

    /**
     * Muestra los equipos que van a competir
     */
    public void mostrarEquipos(){
        for(Equipo equipo: equipos){
            System.out.print(equipo.getNombre());
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
            return  new NombreComparator().compare(c1, c2) ;
        else if (c1.getTotalTime() >c2.getTotalTime())
            return 1;
        else
            return -1;
    }
}
class TiempoMedioDescComparator implements Comparator<Ciclista> {
    public int compare(Ciclista c1, Ciclista c2) {
        if (c1.getTotalTime() == c2.getTotalTime())
            return  new NombreComparator().compare(c1, c2) ;
        else if (c1.getTotalTime() >c2.getTotalTime())
            return 1;
        else
            return -1;
    }
}




