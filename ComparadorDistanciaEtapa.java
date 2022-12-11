
/**
 * Clase comparator de distancia de Etapas
 * 
 * @author Alexeido, Thander y Natera
 * @version 1,0
 */
import java.util.*;
import java.lang.*;

//Comparator distancias
class ComparadorDistanciaEtapa implements Comparator<Etapa> {
    public int compare(Etapa et1, Etapa et2) {
        if (et1.getDistancia() == et2.getDistancia()) {
            return 0;
        } else if (et1.getDificultad() < et2.getDificultad()) {
            return -1;
        } else {
            return 1;
        }
    }
}