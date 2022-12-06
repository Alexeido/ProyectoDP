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
    private ArrayList<Etapa> etapas;
    private ArrayList<Equipo> equipos;
    private ArrayList<Ciclista> ciclistasCarrera;
    private ArrayList<Ciclista> abandonadosCarrera;
    private ComparadorDificultadEtapa compararetapa;

    /**
     * Constructor para la calse Organizacion
     */
    public Organizacion() {
        // initialise instance variables
        this.etapas = new ArrayList<Etapa>();
        this.equipos = new ArrayList<Equipo>();
        this.ciclistasCarrera = new ArrayList<Ciclista>();
        this.abandonadosCarrera = new ArrayList<Ciclista>();
        this.compararetapa = new ComparadorDificultadEtapa();
    }

    /**
     * Constructor parametrizado para la calse Organizacion
     * @param etapa Tipo de comparador a usar
     */
    public Organizacion(ComparadorDificultadEtapa etapa) {
        // initialise instance variables
        this.etapas = new ArrayList<Etapa>();
        this.equipos = new ArrayList<Equipo>();
        this.ciclistasCarrera = new ArrayList<Ciclista>();
        this.abandonadosCarrera = new ArrayList<Ciclista>();
        this.compararetapa = etapa;
    }

    /**
     * Constructor parametrizado para la calse Organizacion
     * @param etapas Etapas de la carrera
     * @param equipos Equipos que van a participar
     * @param ciclistasCarrera Ciclistas que van a participar
     * @param abandonadosCarrera Ciclistas que han abandonado la carrera
     */
    public Organizacion(ArrayList<Etapa> etapas, ArrayList<Equipo> equipos,
            ArrayList<Ciclista> ciclistasCarrera, ArrayList<Ciclista> abandonadosCarrera) {
        this.etapas = etapas;
        this.equipos = equipos;
        this.ciclistasCarrera = ciclistasCarrera;
        this.abandonadosCarrera = abandonadosCarrera;
        this.compararetapa = new ComparadorDificultadEtapa();

    }

    /**
     * Añade un equipo a la Arraylistis de equipos
     * @param equipo Equipo a incribir en la carrera
     */
    public void anadirEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    /**
     * Añade los ciclistas de un equipo a la ArrayList de ciclistas que compiten
     * @param equipo Equipo que va a inscribir ciclistas
     */
    public void anadirCiclistaCarrera(Equipo equipo) {
        for (int i=0;i<equipo.getCiclistas().size(); i++) {
            ciclistasCarrera.add(equipo.getCiclistas().get(i));
        } 
    }

    /**
     * Añade una etapa a la Arraylistis de etapas
     * @param etapa Etapa a añadir
     */
    public void anadirEtapa(Etapa etapa) {
        etapas.add(etapa);
        Collections.sort(etapas, compararetapa);
    }

    /**
     * Quita un ciclista de las Arraylist de ciclistasCarrera y y lo añade la de ciclistas abandonados de la carrera y del propio equipo
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
        for(int i=0;i<equipos.size();i++){
            anadirCiclistaCarrera(equipos.get(i));
            equipos.get(i).asignarbici();
        }
        //asignarbici();    
        mostrarEtapas();
        System.out.println('\n'+"Los equipos de esta carrera son los siguientes: "+'\n'+'\n');
        mostrarEquipos();
        System.out.println('\n'+"Los corredores de esta carrera son los siguientes: "+'\n'+'\n');
        mostrarCiclistas();
    }

    /**
     * Se desarrolla el trancurso de la carrera mostrando el esado de los ciclistas tras cada etapa
     */
    public void desarroyoCarrera() {
        Ciclista auxC;
        Etapa auxT;
        for (int i = 0; i < etapas.size(); i++) {
            auxT = etapas.get(i);
            System.out.println('\n'+"****************************************************" +'\n' +"**************** COMIENZA LA ETAPA " +auxT.getNombre().toUpperCase()+ " ****************" + '\n'  +"****************************************************"+'\n' );
            for (int n = 0; n < ciclistasCarrera.size(); n++) {
                auxC = ciclistasCarrera.get(n);
                System.out.println('\n'+"Informacion del clista numero " + (1+n));
                auxC.mostrarTodo();
                System.out.println("La velocidad que es capaz de alcanzar en esta etapa es "
                        +String.format("%.2f",auxC.getBicicleta().getVelocidad(auxT, auxC)) );
                double aux = auxC.correrEtapa(auxT);
                auxC.setEtapa(auxT);  
                if (auxC.getEnergia() >= 0) {
                    System.out.println("El ciclista tarda " +String.format("%.2f",aux)  + " en completar la carrera");
                    System.out.print("La energia que le queda al corredor es : " + String.format("%.2f",auxC.getEnergia())+'\n'+'\n');
                } else {
                    System.out.println("El ciclista tarda se quedo sin energia a  " +  String.format("%.2f", -1 *auxC.getEnergia())+ " minutos del final");
                    System.out.println("El ciclista avanzo :  " + String.format("%.2f",aux)  + " antes de abandonar");
                    System.out.println("El ciclista termino con :  " + String.format("%.2f",auxC.getEnergia()) + " de energia"+'\n'+'\n');
                }
            }
            Collections.sort(ciclistasCarrera, new TiempoEtapaComparator());
            System.out.println(" ****************************************************" +'\n' +"**************** FIN DE LA ETAPA ****************" + '\n'  +"****************************************************");
            System.out.println('\n'+"La clasificacion en esta etapa por orden es: ");
            //Collections.sort(ciclistasCarrera, new TiempoAscComparator());

            for(int p=0;p<ciclistasCarrera.size();p++) {
                ciclistasCarrera.get(p).mostrarResultadoEtapa(auxT);
            }
            for(int p=0;p<ciclistasCarrera.size();p++) {
                if (ciclistasCarrera.get(p).getEnergia() < 0){
                    abandonar(ciclistasCarrera.get(p));
                    p--;
                }
            }
            for(int v=0;v<equipos.size();v++){
            equipos.get(v).asignarbici();
            }
        
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
            System.out.println(" ****************************************************" +'\n'+"**************** FIN DE LA COMPETTICION ****************" +'\n'+ "****************************************************");
            System.out.println('\n'+"Los ciclistas que clasificado sin abandonar ordenados por su puntuacion son: "+'\n');
            for (int i = 0; i < ciclistasCarrera.size(); i++) {
                    ciclistasCarrera.get(i).mostrarSinBici();
                    ciclistasCarrera.get(i).mostrarhistorial();
            }
            if (abandonadosCarrera.size() > 0) {
            System.out.println(" ****************************************************" +'\n'+"**************** LOS CICLISTAS QUE HAN ABADONADO SON ****************" +'\n'+ "****************************************************");
                for (int i = 0; i < abandonadosCarrera.size(); i++) {
                        abandonadosCarrera.get(i).mostrarSinBici();
                        abandonadosCarrera.get(i).mostrarhistorial();
                }
            }
            Collections.sort(equipos, new TiempoMedioComparator());
            System.out.println("****************************************************");
            System.out.println("******** CLASIFICACIÓN FINAL DE EQUIPOS *********" );
            System.out.println("****************************************************");
            System.out.println("La clasificacion por equipos en orden es: "+'\n'+'\n');
            for (Equipo equipo : equipos) {
                equipo.mostrarTodo();
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
