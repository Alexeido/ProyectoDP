/**
 * Clase simple que almacena una bicicleta 
 * 
 * @author Alexeido, Thander y Natera
 * @version 
 */
import java.util.*;
import java.lang.*;

//Comparator ciclistas
class NombreCComparatorDesc implements Comparator<Ciclista> {
    public int compare(Ciclista b1, Ciclista b2) {
        return -1*b1.getNombre().compareTo(b2.getNombre());
    }
}




