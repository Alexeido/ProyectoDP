
/**
 * Clase comparator de energia de Ciclistas ascendente
 * 
 * @author Alexeido, Thander y Natera
 * @version 1.0
 */
import java.util.*;
import java.lang.*;

class EnergiaComparatorAsc implements Comparator<Ciclista> {
    public int compare(Ciclista c1, Ciclista c2) {
        if (c1.getEnergia() == c2.getEnergia())
            return c1.getNombre().compareTo(c2.getNombre());
        else if (c1.getEnergia() > c2.getEnergia())
            return 1;
        else
            return -1;
    }
}