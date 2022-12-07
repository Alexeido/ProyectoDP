/**
 * Clase simple que almacena una bicicleta 
 * 
 * @author Alexeido, Thander y Natera
 * @version 
 */
import java.util.*;
import java.lang.*;

//Comparator ciclistas
class NombreCComparator implements Comparator<Ciclista> {
    public int compare(Ciclista b1, Ciclista b2) {
        return b1.getNombre().compareTo(b2.getNombre());
    }
}




