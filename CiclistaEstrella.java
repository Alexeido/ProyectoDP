
/**
 * Subclase de ciclista
 * 
 * @author Alexeido, Thander y Natera
 * @version 1.0
 */

import java.io.*;
import java.io.IOException;
import java.nio.*;

public class CiclistaEstrella extends Ciclista {

    private int popularidad;
    // Variable que se actualiza dependiendo de la última carrera, si ha aumentado
    // su popularidad +1, si ha disminuido -1, si no tiene última carrera 0
    private int lastmove;

    /**
     * 
     * Constructor de la subclase CiclistaEstrella
     * 
     * @param nombre    Nombre para la subclase
     * @param habilidad Habilidad para la subclase
     * @param energia   Energia para la subclase
     * @param team      Equipo para la subclase
     */
    public CiclistaEstrella(String nombre, CiclistaHabilidad habilidad, double energia, Equipo team) {
        // initialise instance variables
        super(nombre, habilidad, energia, team);
        super.setDestreza(((super.getHabilidad() + 6) / 140) * 10);
        this.popularidad = 6;
        lastmove = 0;
    }

    /**
     * Aumenta la popularidad del ciclista en 4 uds y actualiza el valor de la
     * última actualización de popularidad
     */
    public void aumentarpuplaridad() {
        popularidad += 4;
        lastmove = 1;
    }

    /**
     * Disminuye la popularidad del ciclista en 1 ud y actualiza el valor de la
     * última actualización de popularidad
     */
    public void disminuirpuplaridad() {
        popularidad--;
        lastmove = -1;
    }

    /**
     * Devuelve el valor de la popularidad
     */
    public int getPopularidad() {
        return this.popularidad;
    }

    /*
     * (non-Javadoc)
     * 
     * @see Ciclista#mostrarSinBici()
     */
    @Override
    public void mostrarSinBici(BufferedWriter ficheroOut) {
        try {
            System.out.print("<CiclistaEstrella: ");
            ficheroOut.write("<CiclistaEstrella: ");
            super.mostrarSinBici(ficheroOut);
            System.out.println("<popularidad: " + this.getPopularidad() + ">");
            ficheroOut.write("<popularidad: " + this.getPopularidad() + ">" + '\n');
        } catch (IOException e) {
            System.err.println("There was a problem writing to ");
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see Ciclista#mostrarEnergia()
     */
    @Override
    public void mostrarEnergia(BufferedWriter ficheroOut) {
        super.mostrarEnergia(ficheroOut);
        try {
            if (lastmove == 1) {
                System.out.println("La popularidad del ciclista " + super.getNombre()
                        + " ha aumentado y ahora su nivel de popularidad es de: " + this.popularidad);
                ficheroOut.write("La popularidad del ciclista " + super.getNombre()
                        + " ha aumentado y ahora su nivel de popularidad es de: " + this.popularidad);
            } else if (lastmove == -1) {
                System.out.println("La popularidad del ciclista " + super.getNombre()
                        + " ha disminuido y ahora su nivel de popularidad es de: " + this.popularidad);
                ficheroOut.write("La popularidad del ciclista " + super.getNombre()
                        + " ha disminuido y ahora su nivel de popularidad es de: " + this.popularidad);
            } else {
                System.out.println("La popularidad del ciclista " + super.getNombre()
                        + " no ha variado y ahora su nivel de popularidad es de: " + this.popularidad);
                ficheroOut.write("La popularidad del ciclista " + super.getNombre()
                        + " no ha variado y ahora su nivel de popularidad es de: " + this.popularidad);
            }
        } catch (IOException e) {
            System.err.println("There was a problem writing to ");
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see Ciclista#correrEtapa(Etapa)
     */
    @Override
    public double correrEtapa(Etapa e) {
        double aux, aux2;
        aux = super.correrEtapa(e);
        aux2 = super.getHistorialTiempo(e);
        if (aux2 <= 160.0 && aux2 >= 0) {
            aumentarpuplaridad();
        } else {
            disminuirpuplaridad();
        }
        return aux;
    }

    @Override
    public String toString() {
        return "<CiclistaEstrella: " + super.getNombre() + " energia: " +String.format("%.2f", super.getEnergia()) +super.getCiclistaHabilidad()
                + " tiempo total: " + String.format("%.2f", super.getTotalTime()) + " popularidad: " + getPopularidad() + super.getBicicleta();
    }
}
