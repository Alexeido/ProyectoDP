
/**
 * Subclase de ciclista 
 * 
 * @author Alexeido, Thander y Natera
 * @version 
 */
import java.io.*;
import java.io.IOException;
import java.nio.*;

public class CiclistaExperimentado extends Ciclista {

    /**
     * 
     * Constructor de la subclase CiclistaExperimentado
     * 
     * @param nombre    Nombre para la subclase
     * @param habilidad Habilidad para la subclase
     * @param energia   Energia para la subclase
     * @param team      Equipo para la subclase
     */
    public CiclistaExperimentado(String nombre, CiclistaHabilidad habilidad, double energia, Equipo team) {
        // initialise instance variables
        super(nombre, habilidad, energia, team);
        super.setDestreza(((getHabilidad() + 4) / 130) * 10);
    }

    /*
     * (non-Javadoc)
     * 
     * @see Ciclista#mostrarSinBici()
     */
    @Override
    public void mostrarSinBici(BufferedWriter ficheroOut) {
        try {
            System.out.print("<CiclistaExperimentado: ");
            ficheroOut.write("<CiclistaExperimentado: ");
            super.mostrarSinBici(ficheroOut);
            System.out.println();
            ficheroOut.write('\n');
        } catch (IOException e) {
            System.err.println("There was a problem writing to ");
        }
    }

    @Override
    public String toString() {
        return "<CiclistaExpetimentado: " + super.getNombre() + " energia: " + String.format("%.2f", super.getEnergia())+super.getCiclistaHabilidad()
                + " tiempo acumulado sin abandonar: " + String.format("%.2f", super.getTotalTime()) + super.getBicicleta();
    }
}
