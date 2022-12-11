
/**
 * Clase comparator de dificultad de Etapas
 * 
 * @author Alexeido, Thander y Natera
 * @version 1,0
 */
import java.util.*;
import java.lang.*;

//Comparator por dificultad
class ComparadorDificultadEtapa implements Comparator<Etapa> {
    public int compare(Etapa et1, Etapa et2) {
        if (et1.getDificultad() == et2.getDificultad()) {
            return et1.getNombre().compareTo(et2.getNombre());
        } else if (et1.getDificultad() > et2.getDificultad()) {
            return 1;
        } else {
            return -1;
        }
    }
}
