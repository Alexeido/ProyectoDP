import java.util.*;
import java.lang.*;

class TiempoAscComparator implements Comparator<Ciclista> {
    public int compare(Ciclista c1, Ciclista c2) {
        if (c1.getTotalTime() == c2.getTotalTime())
            return  new NombreCComparator().compare(c1, c2) ;
        else if (c1.getTotalTime() >c2.getTotalTime())
            return -1;
        else
            return 1;
    }
}