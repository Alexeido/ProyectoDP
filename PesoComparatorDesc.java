
/**
 * Clase comparator de peso de Bicicleta descendete
 * 
 * @author Alexeido, Thander y Natera
 * @version 1.0
 */
import java.util.*;
import java.lang.*;

//Comparator bicicletas
class PesoComparatorDesc implements Comparator<Bicicleta> {
    public int compare(Bicicleta b1, Bicicleta b2) {
        if (b1.getPeso() == b2.getPeso())
            return new NombreBiciComparator().compare(b1, b2);
        else if (b1.getPeso() < b2.getPeso())
            return 1;
        else
            return -1;
    }
}
