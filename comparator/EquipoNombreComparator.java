/**
 * Clase simple que almacena una bicicleta 
 * 
 * @author Alexeido, Thander y Natera
 * @version 
 */
import java.util.*;
import java.lang.*;

//Comparator ciclistas
class EquipoNombreComparator implements Comparator<Equipo> {
    public int compare(Equipo b1, Equipo b2) {
        return b1.getNombre().compareTo(b2.getNombre());
    }
}




