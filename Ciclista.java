
/**
 * Clase que almacena un ciclista y sus metodos para correr etapas y compararse entre otros ciclistas 
 * 
 * @author Alexeido, Thander y Natera
 * @version 31-10-2022
 */

import java.util.*;
import java.io.*;
import java.io.IOException;
import java.nio.*;

public abstract class Ciclista {
    private String nombre;
    private Bicicleta bici;
    private CiclistaHabilidad habilidad;
    /*
     * Grados de habilidad
     * VACIA = 0.00
     * LENTA = 4.00
     * NORMAL = 6.00
     * BUENA = 8.00
     */
    private double energia;
    private HashMap<Etapa, Double> historial; // Guarda las etapas y el tiempo que ha hecho en esa etapa en un hashmap
    private Equipo team;
    private Etapa Eorden;
    private double totalTime;
    private double destreza;

    /**
     * Constructor por defecto de la clase Ciclista
     */
    public Ciclista() {
        this.nombre = "";
        this.bici = new Bicicleta();
        setHabilidad(CiclistaHabilidad.VACIA);
        this.energia = -1;
        this.historial = new HashMap<Etapa, Double>();
        this.team = new Equipo();
        this.totalTime = 0;
        this.Eorden = new Etapa();
    }

    /**
     * 
     * Constructor parametrizado de la clase Ciclista
     * 
     * @param nombre    Inicializa el nombre de la instancia por este
     * @param habilidad Inicializa la habilidad de la instancia por esta
     * @param energia   Inicializa la energía de la instancia por esta
     * @param team      Inicializa el equipo de la instancia por este
     */
    public Ciclista(String nombre, CiclistaHabilidad habilidad, double energia, Equipo team) {
        this.nombre = nombre;
        setHabilidad(habilidad);
        this.energia = energia;
        this.team = team;
        this.totalTime = 0;
        this.bici = new Bicicleta();
        this.historial = new HashMap<>();
        this.Eorden = new Etapa();
    }

    /**
     * 
     * Constructor parametrizado de la clase Ciclista
     * 
     * @param nombre    Inicializa el nombre de la instancia por este
     * @param bici      Inicializa la bicicleta de la instancia por esta
     * @param habilidad Inicializa la habilidad de la instancia por esta
     * @param energia   Inicializa la energía de la instancia por esta
     * @param team      Inicializa el equipo de la instancia por este
     */
    public Ciclista(String nombre, Bicicleta bici, CiclistaHabilidad habilidad, double energia, Equipo team) {
        this.nombre = nombre;
        this.bici = bici;
        setHabilidad(habilidad);
        this.energia = energia;
        this.historial = new HashMap<>();
        this.team = team;
        this.totalTime = 0;
        this.Eorden = new Etapa();
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
     * @return El valor de la habilidad del ciclista
     */
    public double getHabilidad() {
        return this.habilidad.getValor();
    }

    /**
     * @return La habilidad del ciclista
     */
    public CiclistaHabilidad getCiclistaHabilidad() {
        return this.habilidad;
    }

    /**
     * @param habilidad Establece la habilidad actual a la que entra como parametro
     */
    public void setHabilidad(CiclistaHabilidad habilidad) {
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
    public HashMap<Etapa, Double> getHistorial() {
        return this.historial;
    }

    /**
     * @param historial Establece el historial actual al que entra como parametro
     */
    public void setHistorial(HashMap<Etapa, Double> historial) {
        this.historial = historial;
    }

    /**
     * @param carrera Etapa en la que comprobamos el tiempo
     * @return El tiempo en la etapa que llega como parametro
     */
    public Double getHistorialTiempo(Etapa carrera) {
        return this.historial.get(carrera);
    }

    /**
     * @param historial Establece el historial actual al que entra como parametro
     */
    public void addHistorial(Etapa carrera, Double tiempo) {
        this.historial.put(carrera, tiempo);
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
    public Etapa getEtapa() {
        return this.Eorden;
    }

    /**
     * @param Eorden Establece la etapa en la que se compararán dos ciclistas
     */
    public void setEtapa(Etapa Eorden) {
        this.Eorden = Eorden;
    }

    /**
     * @return tiempo total en su historial
     */
    public double getTotalTime() {
        return this.totalTime;
    }

    /**
     * @param totalTime Establece el tiempototal actual por el que entra como
     *                  parametro
     */
    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }

    /*
     * Muestra la información de un ciclista y de su bicicleta
     */
    /*
    protected void mostrarTodo(BufferedWriter ficheroOut) {
        mostrarSinBici(ficheroOut);
        bici.mostrarTodo(ficheroOut);
    }
    */
    /*
     * Muestra la información de un ciclista
     */
    protected void mostrarSinBici(BufferedWriter ficheroOut) {
        try {
            String abandonado = "<Sin abandono>";
            if (energia < 0) {
                abandonado = " <abandonado> ";
            }
            System.out.print(nombre + "> <con energia: " + String.format("%.2f", energia) + "> " + habilidad.toString()
                    + " <tiempo acumulado sin abandonar: " + String.format("%.2f", totalTime) + "> " + abandonado);
            ficheroOut.write(nombre + "> <con energia: " + String.format("%.2f", energia) + "> " + habilidad.toString()
                    + " <tiempo acumulado sin abandonar: " + String.format("%.2f", totalTime) + "> " + abandonado);
        } catch (IOException e) {
            System.err.println("There was a problem writing to ");
        }
    }

    /*
     * Muestra la puntuacion de cada ciclista
     */
    protected void mostrarPuntuacion(BufferedWriter ficheroOut) {
        try {
            System.out.println("Nombre: " + nombre + " Tiene como tiempo total :" + String.format("%.2f", totalTime));
            ficheroOut.write("Nombre: " + nombre + " Tiene como tiempo total :" + String.format("%.2f", totalTime));
            for (Etapa sitio : historial.keySet()) {
                System.out.println("Carrera (" + sitio.getNombre() + ") Tiempo: "
                        + String.format("%.2f", this.historial.get(sitio)) + " minutos ");
                ficheroOut.write("Carrera (" + sitio.getNombre() + ") Tiempo: "
                        + String.format("%.2f", this.historial.get(sitio)) + " minutos ");
            }
        } catch (IOException e) {
            System.err.println("There was a problem writing to ");
        }
    }

    /**
     * @param etapa Etapa de la que se mostrará la información
     * 
     *              Muestra el resultaddo del ciclista
     */

    public void mostrarResultadoEtapa(Etapa etapa, BufferedWriter ficheroOut) {
        try {

            if (historial.get(etapa) != null) {
                if (historial.get(etapa) >= 0) {
                    System.out.println(this.getNombre() + " - Tiempo: "
                            + String.format("%.2f", this.historial.get(etapa)) + " minutos @@@");
                    ficheroOut.write(this.getNombre() + " - Tiempo: " + String.format("%.2f", this.historial.get(etapa))
                            + " minutos @@@" + '\n');
                } else {
                    System.out.println("### Ha abandonado " + this.getNombre() + " - Tiempo: "
                            + String.format("%.2f", this.historial.get(etapa))
                            + " minutos - Ademas ha abandonado para el resto del Campeonato !!!");
                    ficheroOut.write("### Ha abandonado " + this.getNombre() + " - Tiempo: "
                            + String.format("%.2f", this.historial.get(etapa))
                            + " minutos - Ademas ha abandonado para el resto del Campeonato !!!" + '\n');
                }
            } else {
                System.out.println("El ciclista " + this.getNombre() + " no ha corrido la etapa @@@");
                ficheroOut.write("El ciclista " + this.getNombre() + " no ha corrido la etapa @@@");
            }
        } catch (IOException e) {
            System.err.println("There was a problem writing to ");
        }
    }

    /**
     * @param e Etapa a correr
     *          Si el usuario se ha quedado sin energía en la competición y no ha
     *          podido acabar tendrá energia negativa
     *          El algoritmo almacenará automaticamente su resultado en Resultados
     *          El algoritmo sumará a su tiempo total el tiempo que ha hecho en esta
     *          etapa solo si ha ganado
     */
    public double correrEtapa(Etapa e) {
        double aux = this.getEnergia() - this.getBicicleta().getETime(e, this);
        double aux2 = aux;
        double time;
        if (aux >= 0) {
            this.setEnergia(aux);
            aux2 = this.getBicicleta().getETime(e, this);
            time = aux2;
            this.totalTime += aux2;
            this.addHistorial(e, aux2);

        } else {
            this.setEnergia(aux);
            this.addHistorial(e, aux);
            time = this.getBicicleta().getETime(e, this) + aux;
            this.totalTime += (-1 * aux) + this.getEnergia();
        }
        return time;

    }

    /**
     * @param destreza Valor al que se establece la destreza
     * 
     */
    public void setDestreza(Double destreza) {
        this.destreza = destreza;
    }

    /**
     * @return Destreza del ciclista
     */
    public double getDestreza() {
        return this.destreza;
    }
    public int getEtapasTerminadas(){
        int result=0;
        for (Etapa sitio : historial.keySet()) {
            if(this.historial.get(sitio) > 0 ){
                result++;
            }
        }
        return result;
    }
    public Etapa getEtapabandonado(){
        Etapa etapaabandonado=null;
        boolean encontrado=false;
        for (Etapa sitio : historial.keySet()) {
            if(this.historial.get(sitio) < 0 && !encontrado ){
                etapaabandonado=sitio;
                encontrado=true;
            } 
        }
        return etapaabandonado;
    }
    /**
     * Muestra los resultados del ciclista en todas las etapas
     * Tambien está System.out.println(historial);
     */
    public void mostrarHistorial(BufferedWriter ficheroOut) {
        try {
            for (Etapa sitio : historial.keySet()) {
                System.out.println("Carrera (" + sitio.getNombre() + ") Tiempo: "
                        + String.format("%.2f", this.historial.get(sitio)) + " minutos ");
                ficheroOut.write("Carrera (" + sitio.getNombre() + ") Tiempo: "
                        + String.format("%.2f", this.historial.get(sitio)) + " minutos " + '\n');
            }
        } catch (IOException e) {
            System.err.println("There was a problem writing to ");
        }
    }

    /**
     * Muestra por pantalla la energia del ciclista
     */
    public void mostrarEnergia(BufferedWriter ficheroOut) {
        try {
            System.out.println("La energia que le queda al corredor es : " + String.format("%.2f", this.getEnergia()));
            ficheroOut.write("La energia que le queda al corredor es : " + String.format("%.2f", this.getEnergia()));
        } catch (IOException e) {
            System.err.println("There was a problem writing to ");
        }
    }

    public String toString() {
        return "<Nombre: " + getNombre() + " energia: " + String.format("%.2f", this.getEnergia()) +" tiempo total: "+"Habilidad:"+getCiclistaHabilidad()
                +String.format("%.2f", getTotalTime()) + '\n'+ '\n' + getBicicleta();
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Ciclista)) {
            return false;
        }
        Ciclista ciclista = (Ciclista) o;
        return Objects.equals(nombre, ciclista.nombre) && Objects.equals(bici, ciclista.bici) && Objects.equals(habilidad, ciclista.habilidad) && energia == ciclista.energia && Objects.equals(historial, ciclista.historial) && Objects.equals(team, ciclista.team) && Objects.equals(Eorden, ciclista.Eorden) && totalTime == ciclista.totalTime && destreza == ciclista.destreza;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, bici, habilidad, energia, historial, team, Eorden, totalTime, destreza);
    }
}
