
/**
 * Subclase que almacena una bicicleta 
 * 
 * @author Alexeido, Thander y Natera
 * @version 1.0
 */

import java.io.*;
import java.io.IOException;
import java.nio.*;

public class BicicletaPrototipo extends Bicicleta {
    // instance variables - replace the example below with your own

    /**
     * @param nombre Nombre para la subclase
     * @param peso   Peso para la subclase
     *               Constructor parametrized for objects of subclass
     *               BicicletaPrototipo
     */
    public BicicletaPrototipo(String nombre, BicicletaPeso peso) {
        // initialise instance variables
        super(nombre, peso);

    }

    /*
     * (non-Javadoc)
     * 
     * @see Bicicleta#getETime(Etapa, Ciclista)
     */
    @Override
    public double getETime(Etapa e, Ciclista c) {
        return (e.getDistancia() / (super.getVelocidad(e, c) * c.getDestreza()));
    }

    /*
     * (non-Javadoc)
     * 
     * @see Bicicleta#mostrarTodo()
     */
    /*
     * @Override
     * public void mostrarTodo(BufferedWriter ficheroOut) {
     * try {
     * System.out.println("<BicicletaPrototipo: " + super.getNombre() + "> " +
     * super.getBicicletaPeso());
     * ficheroOut.write("<BicicletaPrototipo: " + super.getNombre() + "> " +
     * super.getBicicletaPeso());
     * } catch (IOException e) {
     * System.err.println("There was a problem writing to ");
     * }
     * }
     */

    // toString de la subclase BicicletaPrototipo
    @Override
    public String toString() {
        return '\n' + "<BicicletaPrototipo: " + super.getNombre() + "> " + super.getBicicletaPeso();
    }
}
