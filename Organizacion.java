import java.util.*;
import java.lang.*;

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

    public Organizacion(ComparadorDificultadEtapa etapa) {
        // initialise instance variables
        this.etapas = new ArrayList<Etapa>();
        this.equipos = new ArrayList<Equipo>();
        this.ciclistasCarrera = new ArrayList<Ciclista>();
        this.abandonadosCarrera = new ArrayList<Ciclista>();
        this.compararetapa = etapa;
    }

    /**
     * Constructor para la calse Organizacion
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
     */
    public void anadirEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    public void anadirCiclistaCarrera(Equipo equipo) {
        for (int i=0;i<equipo.getCiclistas().size(); i++) {
            ciclistasCarrera.add(equipo.getCiclistas().get(i));
        } 
    }
    /**
     * Añade una etapa a la Arraylistis de etapas
     */
    public void anadirEtapa(Etapa etapa) {
        etapas.add(etapa);
        Collections.sort(etapas, compararetapa);
    }

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
 
    public void presentacionCarrera() {
        for(int i=0;i<equipos.size();i++){
            anadirCiclistaCarrera(equipos.get(i));
            equipos.get(i).asignarbici();
        }
        //asignarbici();    
        mostrarEtapas();
        System.out.println('\n'+'\n'+'\n'+"Los equipos de esta carrera son los siguientes: "+'\n'+'\n');
        mostrarEquipos();
        System.out.println('\n'+'\n'+'\n'+"Los corredores de esta carrera son los siguientes: "+'\n'+'\n');
        mostrarCiclistas();
    }

    public void desarroyoCarrera() {
        Ciclista auxC;
        Etapa auxT;
        for (int i = 0; i < etapas.size(); i++) {
            auxT = etapas.get(i);
            System.out.println('\n'+"Comienza la etapa: " + auxT.getNombre()+'\n'+'\n'+'\n'+'\n' );
            for (int n = 0; n < ciclistasCarrera.size(); n++) {
                auxC = ciclistasCarrera.get(n);
                System.out.println('\n'+"Informacion del clista numero " + (1+n));
                auxC.mostrarSinBici();
                System.out.println("La velocidad que es capaz de alcanzar en esta etapa es "
                        +String.format("%.2f",auxC.getBicicleta().getVelocidad(auxT, auxC)) );
                double aux = auxC.correrEtapa(auxT);  
                if (auxC.getEnergia() >= 0) {
                    System.out.println("El ciclista tarda " +String.format("%.2f",aux)  + " en completar la carrera");
                    System.out.print("La energia que le queda al corredor es : " + String.format("%.2f",auxC.getEnergia())+'\n'+'\n');
                } else {
                    System.out.println("El ciclista tarda se quedo sin energia a  " +  String.format("%.2f", -1 *auxC.getEnergia())+ " minutos del final");
                    System.out.println("El ciclista avanzo :  " + String.format("%.2f",aux)  + " antes de abandonar");
                    System.out.println("El ciclista termino con :  " + String.format("%.2f",auxC.getEnergia()) + " de energia"+'\n'+'\n');
                }
            }
            // ordenar vector de ciclistas en base al tiempo que han tardado en la etapa i y
            // mostrar su tiempo\
            System.out.println(" ****************************************************" +'\n' +"**************** FIN DE LA ETAPA ****************" + '\n'  +"****************************************************");
            System.out.println('\n'+'\n'+'\n'+"La clasificacion en esta etapa por orden es: ");
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
        }
        for (Equipo equipo : equipos) {
            equipo.setTiempoMedio();
        }
        // se ha terminado la carrera toca dar los premios
    }

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
                        ciclistasCarrera.get(i).mostrarhistorial();
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
        } else {
            System.out.print("No hay competidores o todos han abandonado");

        }

    }

    public void gestionarCampeonato() {
        presentacionCarrera();
        desarroyoCarrera();
        entregaPremios();
    }
}
