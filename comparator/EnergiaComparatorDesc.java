import java.util.*;
import java.lang.*;

class EnergiaComparatorDesc implements Comparator<Ciclista> {
    public int compare(Ciclista c1, Ciclista c2) {
        if (c1.getEnergia() == c2.getEnergia())
            return new NombreCComparator().compare(c1, c2) ;
        else if (c1.getEnergia() <c2.getEnergia())
            return 1;
        else
            return -1;
    }
}