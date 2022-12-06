/**
 * Clase simple que almacena una bicicleta 
 * 
 * @author Alexeido, Thander y Natera
 * @version 
 */
import java.util.*;
import java.lang.*;

//Comparator ciclistas
class NombreCComparator implements Comparator<Ciclista> {
    public int compare(Ciclista b1, Ciclista b2) {
        return b1.getNombre().compareTo(b2.getNombre());
    }
}
class EnergiaComparator implements Comparator<Ciclista> {
    public int compare(Ciclista c1, Ciclista c2) {
        if (c1.getEnergia() == c2.getEnergia())
            return new NombreCComparator().compare(c1, c2) ;
        else if (c1.getEnergia() >c2.getEnergia())
            return 1;
        else
            return -1;
    }
}
class TiempoAscComparator implements Comparator<Ciclista> {
    public int compare(Ciclista c1, Ciclista c2) {
        if (c1.getTotalTime() == c2.getTotalTime())
            return  new NombreCComparator().compare(c1, c2) ;
        else if (c1.getTotalTime() >c2.getTotalTime())
            return 1;
        else
            return -1;
    }
}
class TiempoDescComparator implements Comparator<Ciclista> {
    public int compare(Ciclista c1, Ciclista c2) {
        if (c1.getTotalTime() == c2.getTotalTime())
            return  new NombreCComparator().compare(c1, c2) ;
        else if (c1.getTotalTime() <c2.getTotalTime())
            return 1;
        else
            return -1;
    }
}
class HabilidadComparator implements Comparator<Ciclista> {
    public int compare(Ciclista c1, Ciclista c2) {
        if (c1.getHabilidad() == c2.getHabilidad())
            return new NombreCComparator().compare(c1,c2);
        else if (c1.getHabilidad() >c2.getHabilidad())
            return 1;
        else
            return -1;
    }
}
class TiempoEtapaComparator implements Comparator<Ciclista> {
    public int compare(Ciclista c1, Ciclista c2) {
        if(c1.getEtapa() != c2.getEtapa() || 
        c1.getHistorialTiempo(c1.getEtapa())==null || 
        c2.getHistorialTiempo(c2.getEtapa())==null){
            return 0;
        }
        else{
            double T1= c1.getHistorialTiempo(c1.getEtapa());
            double T2= c2.getHistorialTiempo(c2.getEtapa());
            if (T1 == T2)
                return 0;
            else if (T1>T2)
                return 1;
            else
                return -1;
        }
    }
}