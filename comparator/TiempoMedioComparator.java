/**
 * Clase simple que almacena una bicicleta 
 * 
 * @author Alexeido, Thander y Natera
 * @version 
 */
import java.util.*;
import java.lang.*;

class TiempoMedioComparator implements Comparator<Equipo> {
    public int compare(Equipo e1, Equipo e2) {
        if (e1.getTiempoMedio() == e2.getTiempoMedio())
            return 0;
        else if (e1.getTiempoMedio() > e2.getTiempoMedio())
            return 1;
        else
            return -1;
    }
}
