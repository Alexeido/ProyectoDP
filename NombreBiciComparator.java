
import java.util.*;
import java.lang.*;

class NombreBiciComparator implements Comparator<Bicicleta> {
    public int compare(Bicicleta b1, Bicicleta b2) {
        return b1.getNombre().compareTo(b2.getNombre());
    }
}