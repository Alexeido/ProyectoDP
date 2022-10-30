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

    public void presentacionCarrera() {
        for(int i=0;i<equipos.size();i++){
            anadirCiclistaCarrera(equipos.get(i));
        }
        System.out.println("Las etapas de esta carrera son las siguientes: ");
        mostrarEtapas();
        System.out.println("Los equipos a participar son los siguientes: ");
        mostrarEquipos();
        System.out.println("Los corredores de esta carrera son los siguientes: ");
        mostrarCiclistas();
    }

    public void desarroyoCarrera() {
        Ciclista auxC;
        Etapa auxT;
        for (int i = 0; i < etapas.size(); i++) {
            auxT = etapas.get(i);
            System.out.println("Comienza la etapa: " + auxT.getNombre());
            for (int n = 0; n < ciclistasCarrera.size(); n++) {
                auxC = ciclistasCarrera.get(n);
                System.out.println("Informacion del clista numero " + n);
                auxC.mostrarTodo();
                System.out.print("/La velocidad que es capaz de alcanzar en esta etapa es"
                        + auxC.getBicicleta().getVelocidad(auxT, auxC));
                double aux = auxC.correrEtapa(auxT);
                if (auxC.getEnergia() >= 0) {
                    System.out.println("El ciclista tarda " + aux + " en completar la carrera");
                    System.out.print("La energia que le queda al corredor es : " + auxC.getEnergia());
                } else {
                    System.out.println("El ciclista tarda se quedo sin energia a  " + -1 * auxC.getEnergia()
                            + " minutos del final");
                    System.out.println("El ciclista avanzo :  " + aux + " antes de abandonar");
                    System.out.println("El ciclista termino con :  " + auxC.getEnergia() + " de energia");
                }
            }
            // ordenar vector de ciclistas en base al tiempo que han tardado en la etapa i y
            // mostrar su tiempo
            System.out.print("La clasificacion en esta etapa por orden es: ");
            // aqui ordenar
            for (Ciclista ciclista : ciclistasCarrera) {
                ciclista.mostrarResultadoEtapa(auxT);
                if (ciclista.getEnergia() < 0)
                    ;
                {
                    abandonar(ciclista);
                }
            }
        }
        // se ha terminado la carrera toca dar los premios
    }

    public void entregaPremios() {
        if (ciclistasCarrera.size() > 0) {
            Collections.sort(ciclistasCarrera, new TiempoAscComparator());
            Collections.sort(abandonadosCarrera, new TiempoAscComparator());
            System.out.print("Los ciclistas que clasificado ordenados por su puntuacion son: ");
            for (int i = 0; i <= ciclistasCarrera.size(); i++) {
                for (Ciclista ciclista : ciclistasCarrera) {
                    ciclista.mostrarSinBici();
                }
            }
            if (abandonadosCarrera.size() > 0) {
                System.out.print("Los ciclistas que han abandonado son: ");
                for (int i = 0; i <= abandonadosCarrera.size(); i++) {
                    for (Ciclista ciclista : ciclistasCarrera) {
                        ciclista.mostrarSinBici();
                    }
                }
            }
            Collections.sort(equipos, new TiempoMedioComparator());
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
