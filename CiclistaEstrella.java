/**
 * Clase simple que almacena una bicicleta 
 * 
 * @author Alexeido, Thander y Natera
 * @version 
 */
public class CiclistaEstrella extends Ciclista
{
    // instance variables - replace the example below with your own
    private int popularidad;
    private int lastmove; //Si en su última carrera ha aumentado su popularidad +1, si ha disminuido -1, si no tiene última carrera 0
    /**
     * Constructor for objects of class CiclistaEstrella
     */
    public CiclistaEstrella(String nombre, CiclistaHabilidad habilidad, double energia,Equipo team)
    {
        // initialise instance variables
        super(nombre,habilidad,energia,team);
        super.setDestreza(((super.getHabilidad() + 6) / 140) * 10); 
        this.popularidad=6;       
        lastmove=0;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void aumentarpuplaridad()
    {
        popularidad +=4;
        lastmove=1;
    }

    public void disminuirpuplaridad()
    {
        popularidad --;
        lastmove=-1;
    }

    public int getPopularidad(){
        return this.popularidad;
    }

    
    /* 
     *  Muestra el ciclista sin su bicicleta llamando al super
     */
    @Override
    public void mostrarSinBici(){
        System.out.print ("<CiclistaEstrella: ");
        super.mostrarSinBici();
        System.out.println("<popularidad: "+ this.getPopularidad()+ ">");
        
    }
    @Override
    public void mostrarEnergia(){
        super.mostrarEnergia();
        if(lastmove==1){
            System.out.println("La popularidad del ciclista " + super.getNombre() +" ha aumentado y ahora su nivel de popularidad es de: "+ this.popularidad);
        }
        else if( lastmove==-1){
            System.out.println("La popularidad del ciclista " + super.getNombre() +" ha disminuido y ahora su nivel de popularidad es de: "+ this.popularidad);
        }
        else{
            System.out.println("La popularidad del ciclista " + super.getNombre() +" no ha variado y ahora su nivel de popularidad es de: "+ this.popularidad);
        }
    }

    @Override
    public double correrEtapa(Etapa e){
        double aux, aux2;
        aux=super.correrEtapa(e);
        aux2=super.getHistorialTiempo(e);
        if(aux2<=160.0&&aux2>=0){
            aumentarpuplaridad();
        }
        else{
            disminuirpuplaridad();
        }
        return aux;
    }

}
