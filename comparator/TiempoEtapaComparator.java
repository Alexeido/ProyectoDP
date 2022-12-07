import java.util.*;
import java.lang.*;


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