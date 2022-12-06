/**
 * Clase simple que almacena una bicicleta 
 * 
 * @author Alexeido, Thander y Natera
 * @version 
 */
import java.util.*;
import java.lang.*;
//Comparator etapas
class ComparadorDificultadEtapa implements Comparator<Etapa>{
    public int compare(Etapa et1, Etapa et2){
        if (et1.getDificultad()==et2.getDificultad()){
            return 0;
        }
        else if(et1.getDificultad() > et2.getDificultad()){
            return 1;
        }
        else{
            return -1;
        }
    }
}
