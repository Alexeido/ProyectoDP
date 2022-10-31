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
        if(c1.getEtapa() != c2.getEtapa()){
            return 0;
        }
        else{
            double T1=-1;
            double T2=-1;
            Boolean enc=false;
            for(int i=0; i<c1.getHistorial().size()&&!enc;i++){
                if(c1.getHistorial().get(i).getSitio()==c1.getEtapa()){
                    T1=c1.getHistorial().get(i).getTiempo();
                    enc=true;
                }
            }
            enc=false;
            for(int i=0; i<c2.getHistorial().size()&&!enc;i++){
                if(c2.getHistorial().get(i).getSitio()==c2.getEtapa()){
                    T2=c2.getHistorial().get(i).getTiempo();
                    enc=true;
                }
            }
        
            if (T1 == T2)
                return 0;
            else if (T1>T2)
                return 1;
            else
                return -1;
        }
    }
}

//Comparator bicicletas
class PesoComparator implements Comparator<Bicicleta> {
    public int compare(Bicicleta b1, Bicicleta b2) {
        if (b1.getPeso() == b2.getPeso())
            return new NombreComparator().compare(b1,b2);
        else if (b1.getPeso() > b2.getPeso())
            return 1;
        else
            return -1;
    }
}

class NombreComparator implements Comparator<Bicicleta> {
    public int compare(Bicicleta b1, Bicicleta b2) {
        return b1.getNombre().compareTo(b2.getNombre());
    }
}

//Comparator equipos
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

//Comparator etapas
class ComparadorDificultadEtapa implements Comparator<Etapa>{
    public int compare(Etapa et1, Etapa et2){
        if (et1.getDificultad()==et2.getDificultad()){
            return 0;
        }
        else if(et1.getDificultad()< et2.getDificultad()){
            return 1;
        }
        else{
            return -1;
        }
    }
}

