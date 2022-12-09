import java.util.*;
import java.lang.*;

class HabilidadComparatorDesc implements Comparator<Ciclista> {
    public int compare(Ciclista c1, Ciclista c2) {
        if (c1.getHabilidad() == c2.getHabilidad())
            return new NombreCComparator().compare(c1,c2);
        else if (c1.getHabilidad() >c2.getHabilidad())
            return -1;
        else
            return 1;
    }
}