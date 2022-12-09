/**
 * Clase simple que almacena una bicicleta 
 * 
 * @author Alexeido, Thander y Natera
 * @version 
 */
import java.util.*;
import java.lang.*;
//Comparator bicicletas
class PesoComparatorAsc implements Comparator<Bicicleta> {
    public int compare(Bicicleta b1, Bicicleta b2) {
        if (b1.getPeso() == b2.getPeso())
            return new NombreBiciComparator().compare(b1,b2);
        else if (b1.getPeso() > b2.getPeso())
            return 1;
        else
            return -1;
    }
}
