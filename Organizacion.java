import java.util.*;
import java.lang.*;
import java.io.*;
import java.io.IOException;
import java.nio.*;

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
    private BufferedWriter ficheroOut;

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
    public ArrayList<Equipo> getEquipos() {
        return this.equipos;
    }
    /**
     * Anade los ciclistas de un equipo a la ArrayList de ciclistas que compiten
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
            equipo.mostrarTodo(ficheroOut);
        }
    }

    /**
     * Muestra las etapas de la carrera
     */
    public void mostrarEtapas() {
        /*
         * for (Etapa etapa : etapas) {
         * etapa.mostrarTodo(ficheroOut);
         * }
         */
        try{
        for (Iterator<Etapa> it = etapas.iterator(); it.hasNext();) {
                Etapa e = it.next();
                System.out.println(e);
                ficheroOut.write(""+e+'\n');
            }
        }
        catch (IOException e) {
        System.err.println("There was a problem writing to ");
    }
    }

    /**
     * Muestra los ciclistas que estan participando en la carrera
     */
    public void mostrarCiclistas() {
        try{
            for (Ciclista ciclista : ciclistasCarrera) {
                System.out.println(ciclista);
                ficheroOut.write(""+ciclista);            
            }
        }
        catch (IOException e) {
            System.err.println("There was a problem writing to ");
        }
        
    }

    /**
     * Muestra los ciclistas que estan participando en la carrera sin su bicicleta
     */
    public void mostrarCiclistasSinBici() {
        for (Ciclista ciclista : ciclistasCarrera) {
            ciclista.mostrarSinBici(ficheroOut);
        }
    }

    /**
     * Muestra los ciclistas que han abandonado
     */
    public void mostrarAbandonos() {
        for (Equipo equipo : equipos) {
            equipo.mostrarAbandonos(ficheroOut);
        }

    }
    /*
     * Comprueba si todos los ciclistas han abandonado
     */
    public boolean comprobarTodosCiclistasAbandonados(){
        if(this.ciclistasCarrera.size()==0)
            return true;
        else
            return false;
    }
    /**
     * Presenta las etapas del campeonato, los equipos y sus ciclistas
     */
    public void presentacionCarrera() {
        try {
            Collections.sort(equipos, new EquipoNombreComparator());
            System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||" + '\n'
                    + "||||||||||||||||||| ETAPAS DEL CAMPEONATO ||||||||||||||||||||||" + '\n'
                    + "||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");

            ficheroOut.write("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||" + '\n'
                    + "||||||||||||||||||| ETAPAS DEL CAMPEONATO ||||||||||||||||||||||" + '\n'
                    + "||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||" + '\n');

            for (int i = 0; i < equipos.size(); i++) {
                anadirCiclistaCarrera(equipos.get(i));
                equipos.get(i).asignarbici();
            }
            Collections.sort(ciclistasCarrera, new NombreCComparatorDesc());

            mostrarEtapas();
            System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||" + '\n' + '\n');
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" + '\n'
                    + "%%%%%%%%% EQUIPOS DEL CAMPEONATO %%%%%%%%%%" + '\n'
                    + "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            ficheroOut.write("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||" + '\n' + '\n');
            ficheroOut.write("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" + '\n'
                    + "%%%%%%%%% EQUIPOS DEL CAMPEONATO %%%%%%%%%%" + '\n'
                    + "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" + '\n');

            mostrarEquipos();
        } catch (IOException e) {
            System.err.println("There was a problem writing to ");
        }
    }

    /**
     * Se desarrolla el trancurso de la carrera mostrando el esado de los ciclistas
     * tras cada etapa
     */
    public void desarroyoCarrera() {
        try {
            Ciclista auxC;
            int eliminados;
            
            for (Etapa etapa : etapas) {
                if(!comprobarTodosCiclistasAbandonados()){
                    
                
                System.out.println('\n'
                        + "**************************************************************************************************"
                        + '\n'
                        + "**************** Ciclistas que van a competir en " + etapa.getNombre()
                        + " *****************************" + '\n'
                        + "**************************************************************************************************"
                        + '\n');
                ficheroOut.write('\n'
                        + "**************************************************************************************************"
                        + '\n'
                        + "**************** Ciclistas que van a competir en " + etapa.getNombre()
                        + " *****************************" + '\n'
                        + "**************************************************************************************************"
                        + '\n');

                this.mostrarCiclistasSinBici();

                System.out.println();
                System.out.println('\n'
                        + "*********************************************************************************" + '\n'
                        + "**************** COMIENZA LA ETAPA " + etapa.getNombre().toUpperCase()
                        + " *****************************"
                        + '\n' + "*********************************************************************************"
                        + '\n');
                ficheroOut.write('\n'
                        + "*********************************************************************************" + '\n'
                        + "**************** COMIENZA LA ETAPA " + etapa.getNombre().toUpperCase()
                        + " *****************************"
                        + '\n' + "*********************************************************************************"
                        + '\n');
                for (int n = 0; n < ciclistasCarrera.size(); n++) {
                    auxC = ciclistasCarrera.get(n);
                    System.out.println("@@@ ciclista  " + (1 + n) + " de " + ciclistasCarrera.size());
                    ficheroOut.write("@@@ ciclista  " + (1 + n) + " de " + ciclistasCarrera.size()+'\n');
                    
                    
                    
                    System.out.println(auxC);
                    ficheroOut.write(""+auxC);
                    
                    
                    System.out.println("+++ Con estas condiciones el ciclista " + auxC.getNombre()
                            + " con la biciclceta " + auxC.getBicicleta().getNombre() + " alcanza una velocidad de "
                            + String.format("%.2f", auxC.getBicicleta().getVelocidad(etapa, auxC)) + " km/hora +++");
                    ficheroOut.write('\n' + "+++ Con estas condiciones el ciclista " + auxC.getNombre()
                            + " con la biciclceta " + auxC.getBicicleta().getNombre() + " alcanza una velocidad de "
                            + String.format("%.2f", auxC.getBicicleta().getVelocidad(etapa, auxC)) + " km/hora +++");
                    double aux = auxC.correrEtapa(etapa);
                    auxC.setEtapa(etapa);
                    if (auxC.getEnergia() >= 0) {
                        System.out.println("+++ El ciclista " + auxC.getNombre() + " termina la etapa en "
                                + String.format("%.2f", aux) + " minutos +++");
                        ficheroOut.write('\n' + "+++ El ciclista " + auxC.getNombre() + " termina la etapa en "
                                + String.format("%.2f", aux) + " minutos +++");
                        auxC.mostrarEnergia(ficheroOut);
                    } else {
                        System.out.println("+++ El ciclista " + auxC.getNombre() + " se quedo sin energia a falta de "
                                + String.format("%.2f", -1 * auxC.getEnergia()) + " minutos minutos para terminar !!!");
                        ficheroOut.write('\n' + "+++ El ciclista " + auxC.getNombre()
                                + " se quedo sin energia a falta de "
                                + String.format("%.2f", -1 * auxC.getEnergia()) + " minutos minutos para terminar !!!");
                        System.out.println("+++ En el momento de quedarse sin energia llevaba en la carrera "
                                + String.format("%.2f", aux) + " minutos !!!");
                        ficheroOut.write('\n' + "+++ En el momento de quedarse sin energia llevaba en la carrera "
                                + String.format("%.2f", aux) + " minutos !!!");
                        System.out.println("+++ La energia del ciclista " + auxC.getNombre() + " tras la carrera es de "
                                + String.format("%.2f", auxC.getEnergia())
                                + " +++");
                        ficheroOut.write('\n' + "+++ La energia del ciclista " + auxC.getNombre()
                                + " tras la carrera es de " + String.format("%.2f", auxC.getEnergia())
                                + " +++");
                    }
                    System.out.println("@@@" + '\n' + '\n');
                    ficheroOut.write("@@@" + '\n' + '\n');
                }
                Collections.sort(ciclistasCarrera, new TiempoEtapaComparator());
                System.out.println(
                        "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + '\n'
                                + "++++++++++++++++++ Clasificacion final de la carrera " + etapa + " ++++++++++" + '\n'
                                + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                ficheroOut.write("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"
                        + '\n'
                        + "++++++++++++++++++ Clasificacion final de la carrera " + etapa + " ++++++++++" + '\n'
                        + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                eliminados = 0;
                for (int p = 0; p < ciclistasCarrera.size(); p++) {
                    if (ciclistasCarrera.get(p).getEnergia() >= 0) {
                        System.out.print("@@@ Posicion(" + (p + 1) + "): ");
                        ficheroOut.write("@@@ Posicion(" + (p + 1) + "): ");
                        ciclistasCarrera.get(p).mostrarResultadoEtapa(etapa, ficheroOut);
                    } else {
                        eliminados++;
                        abandonar(ciclistasCarrera.get(p));
                        p--;
                    }
                }
                for (int j = abandonadosCarrera.size() - eliminados; j < abandonadosCarrera.size(); j++) {
                    abandonadosCarrera.get(j).mostrarResultadoEtapa(etapa, ficheroOut);
                }
                /*
                 * for (int v = 0; v < equipos.size(); v++) {
                 * equipos.get(v).asignarbici();
                 * }
                 */
                for (Iterator<Equipo> it = equipos.iterator(); it.hasNext();) {
                    Equipo v = it.next();
                    v.asignarbici();
                }

                Collections.sort(ciclistasCarrera, new TiempoDescComparator());
            }
            }
            for (Equipo equipo : equipos) {
                equipo.setTiempoMedio();
            }
        }
        // no se por que da error aqui
        catch (IOException e) {
            System.err.println("There was a problem writing to ");
        }
        // se ha terminado la carrera toca dar los premios

    }

    /**
     * Muestra la clasificacion de los equipos y ciclistas
     */
    public void entregaPremios() {
        try {
            if (!comprobarTodosCiclistasAbandonados()) {
                Collections.sort(ciclistasCarrera, new TiempoAscComparator());
                Collections.sort(abandonadosCarrera, new TiempoAscComparator());

                System.out.println('\n');
                System.out.println("********************************************************" + '\n'
                        + "**************** FIN DE LA COMPETTICION ****************" + '\n'
                        + "********************************************************");

                ficheroOut.write("********************************************************" + '\n'
                        + "**************** FIN DE LA COMPETTICION ****************" + '\n'
                        + "********************************************************" + '\n');

                for (int i = 0; i < ciclistasCarrera.size(); i++) {
                    System.out.println("@@@ Posicion(" + (i + 1) + "): " + ciclistasCarrera.get(i).getNombre() + " - " +
                            "Tiempo Total: " + String.format("%.2f", ciclistasCarrera.get(i).getTotalTime()) + " @@@");

                    ficheroOut.write("@@@ Posicion(" + (i + 1) + "): " + ciclistasCarrera.get(i).getNombre() + " - " +
                            "Tiempo Total: " + String.format("%.2f", ciclistasCarrera.get(i).getTotalTime()) + " @@@"
                            + '\n');

                    ciclistasCarrera.get(i).mostrarHistorial(ficheroOut);

                    System.out.println('\n');
                }
                if (abandonadosCarrera.size() > 0) {
                    System.out.println("***********************************************************" + '\n'
                            + "**************** CICLISTAS QUE ABANDONARON ****************" + '\n'
                            + "***********************************************************");

                    ficheroOut.write("***********************************************************" + '\n'
                            + "**************** CICLISTAS QUE ABANDONARON ****************" + '\n'
                            + "***********************************************************" + '\n');

                    for (int i = 0; i < abandonadosCarrera.size(); i++) {
                        System.out.println("--- ciclista Abandonado: " + abandonadosCarrera.get(i).getNombre() +
                                " - Puntos Totales Anulados: "
                                + String.format("%.2f", abandonadosCarrera.get(i).getTotalTime()) + " ---");

                        ficheroOut.write("--- ciclista Abandonado: " + abandonadosCarrera.get(i).getNombre() +
                                " - Puntos Totales Anulados: "
                                + String.format("%.2f", abandonadosCarrera.get(i).getTotalTime()) + " ---" + '\n');

                        abandonadosCarrera.get(i).mostrarHistorial(ficheroOut);
                        System.out.println('\n');
                    }
                }
                Collections.sort(equipos, new TiempoMedioComparator());
                System.out.println('\n');
                System.out.println("****************************************************");
                System.out.println("******** CLASIFICACIÓN FINAL DE EQUIPOS ************");
                System.out.println("****************************************************");

                ficheroOut.write("***********************************************************" + '\n'
                        + "**************** CLASIFICACIÓN FINAL DE EQUIPOS ****************" + '\n'
                        + "***********************************************************" + '\n');
                int i = 1;
                for (Equipo equipo : equipos) {
                    System.out.println("@@@ Posicion (" + i + ") " + equipo.getNombre() + " con "
                            + String.format("%.2f", equipo.getTiempoMedio()) + " minutos de media @@@" + '\n');

                    ficheroOut.write("@@@ Posicion (" + i + ") " + equipo.getNombre() + " con "
                            + String.format("%.2f", equipo.getTiempoMedio()) + " minutos de media @@@" + '\n');

                    equipo.mostrarTodo(ficheroOut);
                    i++;
                }
            } else {
                System.out.print("No hay competidores o todos han abandonado");

                ficheroOut.write("No hay competidores o todos han abandonado");

            }
        } catch (IOException e) {   
            System.err.println("There was a problem writing to ");
        }
    }

    /**
     * Se lleva a cabo toda la carrera
     */
    public void gestionarCampeonato() {
        try {
            ficheroOut = new BufferedWriter(new FileWriter("Salida.txt"));
            presentacionCarrera();
            desarroyoCarrera();
            entregaPremios();
            ficheroOut.close();
        } catch (IOException e) {
            System.err.println("There was a problem writing to ");
        }
    }
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Organizacion)) {
            return false;
        }
        Organizacion organizacion = (Organizacion) o;
        return Objects.equals(etapas, organizacion.etapas) && Objects.equals(equipos, organizacion.equipos) && Objects.equals(ciclistasCarrera, organizacion.ciclistasCarrera) && Objects.equals(abandonadosCarrera, organizacion.abandonadosCarrera) && Objects.equals(ficheroOut, organizacion.ficheroOut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(etapas, equipos, ciclistasCarrera, abandonadosCarrera, ficheroOut);
    }
}
