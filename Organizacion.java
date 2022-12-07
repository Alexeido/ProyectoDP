import java.util.*;
import java.lang.*;

/**
 * La organización se encarga de gestionar toda la carrera
 * 
 * @author Alexeido, Thander y Natera
 * @version 31-10-2022
 */
public class Organizacion {
    // instance variables
    // private ArrayList<Etapa> etapas;
    private TreeSet<Etapa> etapas;
    private ArrayList<Equipo> equipos;
    private ArrayList<Ciclista> ciclistasCarrera;
    private ArrayList<Ciclista> abandonadosCarrera;

    /**
     * Constructor para la calse Organizacion
     */
    public Organizacion() {
        // initialise instance variables
        this.etapas = new TreeSet<Etapa>();
        this.equipos = new ArrayList<Equipo>();
        this.ciclistasCarrera = new ArrayList<Ciclista>();
        this.abandonadosCarrera = new ArrayList<Ciclista>();
    }

    /**
     * Constructor parametrizado para la calse Organizacion
     * 
     * @param etapa Tipo de comparador a usar
     */
    public Organizacion(ComparadorDificultadEtapa etapa) {
        // initialise instance variables
        this.etapas = new TreeSet<Etapa>(etapa);
        this.equipos = new ArrayList<Equipo>();
        this.ciclistasCarrera = new ArrayList<Ciclista>();
        this.abandonadosCarrera = new ArrayList<Ciclista>();
    }

    /**
     * Constructor parametrizado para la calse Organizacion
     * 
     * @param etapas             Etapas de la carrera
     * @param equipos            Equipos que van a participar
     * @param ciclistasCarrera   Ciclistas que van a participar
     * @param abandonadosCarrera Ciclistas que han abandonado la carrera
     */
    public Organizacion(TreeSet<Etapa> etapas, ArrayList<Equipo> equipos,
            ArrayList<Ciclista> ciclistasCarrera, ArrayList<Ciclista> abandonadosCarrera) {
        this.etapas = etapas;
        this.equipos = equipos;
        this.ciclistasCarrera = ciclistasCarrera;
        this.abandonadosCarrera = abandonadosCarrera;

    }

    /**
     * Añade un equipo a la Arraylistis de equipos
     * 
     * @param equipo Equipo a incribir en la carrera
     */
    public void anadirEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    /**
     * Añade los ciclistas de un equipo a la ArrayList de ciclistas que compiten
     * 
     * @param equipo Equipo que va a inscribir ciclistas
     */
    public void anadirCiclistaCarrera(Equipo equipo) {
        for (int i = 0; i < equipo.getCiclistas().size(); i++) {
            ciclistasCarrera.add(equipo.getCiclistas().get(i));
        }
    }

    /**
     * Añade una etapa a la Arraylistis de etapas
     * 
     * @param etapa Etapa a añadir
     */
    public void anadirEtapa(Etapa etapa) {
        etapas.add(etapa);
    }

    /**
     * Quita un ciclista de las Arraylist de ciclistasCarrera y y lo añade la de
     * ciclistas abandonados de la carrera y del propio equipo
     * 
     * @param ciclista Ciclista que va a abandonar
     */
    public void abandonar(Ciclista ciclista) {
        ciclistasCarrera.remove(ciclista);
        abandonadosCarrera.add(ciclista);
        ciclista.getTeam().addCiclistaAbandonado(ciclista);
    }

    /**
     * Muestra los equipos que van a competir
     */
    public void mostrarEquipos() {
        for (Equipo equipo : equipos) {
            equipo.mostrarTodo();
        }
        System.out.println('\n');
    }

    /**
     * Muestra las etapas de la carrera
     */
    public void mostrarEtapas() {
        for (Etapa etapa : etapas) {
            etapa.mostrarTodo();
        }
    }

    /**
     * Muestra los ciclistas que estan participando en la carrera
     */
    public void mostrarCiclistas() {
        for (Ciclista ciclista : ciclistasCarrera) {
            ciclista.mostrarTodo();
        }
    }

    /**
     * Muestra los ciclistas que estan participando en la carrera
     */
    public void mostrarCiclistasSinBici() {
        for (Ciclista ciclista : ciclistasCarrera) {
            ciclista.mostrarSinBici();
        }
    }

    /**
     * Muestra los ciclistas que han abandonado
     */
    public void mostrarAbandonos() {
        for (Equipo equipo : equipos) {
            equipo.mostrarAbandonos();
        }

    }

    /**
     * Presenta los equipos que van a competir y sus ciclistas
     */
    public void presentacionCarrera() {
        Collections.sort(equipos, new EquipoNombreComparator());
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||" + '\n'
        + "||||||||||||||||||| ETAPAS DEL CAMPEONATO ||||||||||||||||||||||" + '\n'
        + "||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        for (int i = 0; i < equipos.size(); i++) {
            anadirCiclistaCarrera(equipos.get(i));
            equipos.get(i).asignarbici();
        }
        Collections.sort(ciclistasCarrera, new NombreCComparatorDesc());

        // asignarbici();
        mostrarEtapas();
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||"+'\n'+'\n');
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" + '\n'
        + "%%%%%%%%% EQUIPOS DEL CAMPEONATO %%%%%%%%%%" + '\n'
        + "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        mostrarEquipos();
    }

    /**
     * Se desarrolla el trancurso de la carrera mostrando el esado de los ciclistas
     * tras cada etapa
     */
    public void desarroyoCarrera() {
        Ciclista auxC;
        int eliminados;
        for (Etapa etapa : etapas) {
            System.out.println('\n' + "**************************************************************************************************" + '\n'
                    + "**************** Ciclistas que van a competir en " + etapa.getNombre()+ " *****************************" + '\n' 
                    + "**************************************************************************************************" + '\n');
            this.mostrarCiclistasSinBici();
            System.out.println();
            System.out.println('\n' + "*********************************************************************************" + '\n'
                    + "**************** COMIENZA LA ETAPA " + etapa.getNombre().toUpperCase() + " *****************************"
                    + '\n' + "*********************************************************************************" + '\n');

            for (int n = 0; n < ciclistasCarrera.size(); n++) {
                auxC = ciclistasCarrera.get(n);
                System.out.println("@@@ ciclista  " + (1 + n)+" de "+ciclistasCarrera.size());
                auxC.mostrarTodo();
                System.out.println("+++ Con estas condiciones el ciclista "+ auxC.getNombre()+ " con la biciclceta " + auxC.getBicicleta().getNombre()+ " alcanza una velocidad de "
                        + String.format("%.2f", auxC.getBicicleta().getVelocidad(etapa, auxC))+ " km/hora +++");
                double aux = auxC.correrEtapa(etapa);
                auxC.setEtapa(etapa);
                if (auxC.getEnergia() >= 0) {
                    System.out.println("+++ El ciclista "+ auxC.getNombre()+" termina la etapa en " + String.format("%.2f", aux) + " minutos +++");
                    auxC.mostrarEnergia();
                } else {
                    System.out.println("+++ El ciclista "+ auxC.getNombre()+" se quedo sin energia a falta de "
                            + String.format("%.2f", -1 * auxC.getEnergia()) + " minutos minutos para terminar !!!");
                    System.out.println("+++ En el momento de quedarse sin energia llevaba en la carrera " + String.format("%.2f", aux) + " minutos !!!");
                    System.out.println("+++ La energia del ciclista "+ auxC.getNombre()+ " tras la carrera es de " + String.format("%.2f", auxC.getEnergia())
                            + " +++");
                }
                System.out.println("@@@"+ '\n'+'\n');
            }
            Collections.sort(ciclistasCarrera, new TiempoEtapaComparator());
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + '\n'
                    + "++++++++++++++++++ Clasificacion final de la carrera "+etapa+" ++++++++++" + '\n'
                    + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            
            eliminados=0;
            for (int p = 0; p < ciclistasCarrera.size(); p++) {
                if(ciclistasCarrera.get(p).getEnergia()>=0){
                    System.out.print("@@@ Posicion("+(p+1)+"): ");
                    ciclistasCarrera.get(p).mostrarResultadoEtapa(etapa);
                }
                else{
                    eliminados++;
                    abandonar(ciclistasCarrera.get(p));
                    p--;
                }
            }
            for(int j = abandonadosCarrera.size()-eliminados; j<abandonadosCarrera.size();j++){
                abandonadosCarrera.get(j).mostrarResultadoEtapa(etapa);
            }
            for (int v = 0; v < equipos.size(); v++) {
                equipos.get(v).asignarbici();
            }
            
            Collections.sort(ciclistasCarrera, new TiempoDescComparator());
        }
        for (Equipo equipo : equipos) {
            equipo.setTiempoMedio();
        }
        // se ha terminado la carrera toca dar los premios
    }

    /**
     * Muestra la clasificacion de los equipos y ciclistas
     */
    public void entregaPremios() {
        if (ciclistasCarrera.size() > 0) {
            Collections.sort(ciclistasCarrera, new TiempoAscComparator());
            Collections.sort(abandonadosCarrera, new TiempoAscComparator());
            System.out.println( '\n');
            System.out.println("********************************************************" + '\n'
                    +           "**************** FIN DE LA COMPETTICION ****************" + '\n'
                    +           "********************************************************");
            for (int i = 0; i < ciclistasCarrera.size(); i++) {
                System.out.println("@@@ Posicion("+(i+1)+"): "+ciclistasCarrera.get(i).getNombre()+ " - "+
                "Tiempo Total: "+String.format("%.2f",ciclistasCarrera.get(i).getTotalTime())+" @@@");
                ciclistasCarrera.get(i).mostrarhistorial();
                System.out.println('\n');
            }
            if (abandonadosCarrera.size() > 0) {
                System.out.println(" ***********************************************************" + '\n'
                        + "**************** CICLISTAS QUE ABANDONARON ****************" + '\n'
                        + "***********************************************************");
                for (int i = 0; i < abandonadosCarrera.size(); i++) {
                    System.out.println("--- ciclista Abandonado: "+abandonadosCarrera.get(i).getNombre()+ 
                    " - Puntos Totales Anulados: "+String.format("%.2f", abandonadosCarrera.get(i).getTotalTime())+" ---");
                    abandonadosCarrera.get(i).mostrarhistorial();
                    System.out.println('\n');
                }
            }
            Collections.sort(equipos, new TiempoMedioComparator());
            System.out.println('\n');
            System.out.println("****************************************************");
            System.out.println("******** CLASIFICACIÓN FINAL DE EQUIPOS ************");
            System.out.println("****************************************************");
           int i=1;
            for (Equipo equipo : equipos) {
                System.out.println("@@@ Posicion ("+i+") "+equipo.getNombre()+" con "+String.format("%.2f", equipo.getTiempoMedio())+ " minutos de media @@@"+ '\n');
                equipo.mostrarTodo();
                i++;
            }
            System.out.print("pekka 14 o 15 con espejo");
        } else {
            System.out.print("No hay competidores o todos han abandonado");

        }

    }

    /**
     * Se lleva a cabo toda la carrera
     */
    public void gestionarCampeonato() {
        presentacionCarrera();
        desarroyoCarrera();
        entregaPremios();
    }
}
