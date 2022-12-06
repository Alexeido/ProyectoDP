/**
 * Clase simple que almacena una bicicleta 
 * 
 * @author Alexeido, Thander y Natera
 * @version 
 */
import java.util.*;
import java.lang.*;
//Comparator bicicletas
class PesoComparator implements Comparator<Bicicleta> {
    public int compare(Bicicleta b1, Bicicleta b2) {
        if (b1.getPeso() == b2.getPeso())
            return new NombreComparator().compare(b1,b2);
        else if (b1.getPeso() > b2.getPeso())
            return 1;
        else
            return -1;
    }
}

class NombreComparator implements Comparator<Bicicleta> {
    public int compare(Bicicleta b1, Bicicleta b2) {
        return b1.getNombre().compareTo(b2.getNombre());
    }
}