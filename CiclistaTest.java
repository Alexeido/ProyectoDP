

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class CiclistaTest.
 *
 * @author Alexeido, Thander y Natera
 * @version 31-10-2022
 */
public class CiclistaTest
{
    Etapa etapa1, etapa2, etapa3;
    Bicicleta Bicicleta1, Bicicleta2, Bicicleta3;
    Ciclista Ciclista1, Ciclista2, Ciclista3,Ciclista4,Ciclista5,Ciclista6;
    /**
     * Default constructor for test class CiclistaTest
     */
    public CiclistaTest()
    {
        //Constructor de etapas
        etapa1 = new Etapa("sencilla larga", EtapaDificultad.SENCILLA, EtapaDistancia.CORTA);
        etapa2 = new Etapa("compleja intermedia", EtapaDificultad.NORMAL, EtapaDistancia.INTERMEDIA);
        etapa3 = new Etapa("normal intermedia", EtapaDificultad.COMPLEJA, EtapaDistancia.LARGA);
        //constructor de bicicletas pide ( String nombre, double peso)
        Bicicleta1= new Bicicleta("TREK Madone SLR 9 eTap Gen 7",BicicletaPeso.LIGERA);
        Bicicleta2= new Bicicleta("TREK Emonda SLR 9 eTap",BicicletaPeso.NORMAL);
        Bicicleta3= new Bicicleta("TREK Domane SLR 9 eTap Gen 4",BicicletaPeso.PESADA);
        //constructor de ciclistas pide (String nombre , double habilidad , double energia, Equipo equipo)
        Ciclista1 = new CiclistaNovato("WIEBES",  CiclistaHabilidad.LENTA, 1190,new Equipo());
        Ciclista2 = new CiclistaExperimentado("LIPPERT", CiclistaHabilidad.NORMAL, 1160,new Equipo());
        Ciclista3 = new CiclistaEstrella("LABOUS", CiclistaHabilidad.BUENA, 1150,new Equipo());
        Ciclista4 = new CiclistaEstrella("THANDER", CiclistaHabilidad.NORMAL, 1650,new Equipo());
        Ciclista5 = new CiclistaEstrella("OKITO", CiclistaHabilidad.LENTA, 1350,new Equipo());
        Ciclista6 = new CiclistaEstrella("NATERA", CiclistaHabilidad.LENTA, 600,new Equipo());


        
        
        
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {    
        Ciclista1.setBicicleta(Bicicleta1);
        Ciclista2.setBicicleta(Bicicleta2);
        Ciclista3.setBicicleta(Bicicleta3);
        Ciclista6.setBicicleta(Bicicleta3);

    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    @Test
    public void testCorrerEtapa(){
        assertEquals(String.format("%.2f",Ciclista1.correrEtapa(etapa1)),"148,84");
        assertEquals(String.format("%.2f",Ciclista2.correrEtapa(etapa1)),"101,25");
        assertEquals(String.format("%.2f",Ciclista3.correrEtapa(etapa1)),"79,48");
        assertEquals(String.format("%.2f",Ciclista1.correrEtapa(etapa2)),"220,50");
        assertEquals(String.format("%.2f",Ciclista2.correrEtapa(etapa2)),"150,00");
        assertEquals(String.format("%.2f",Ciclista3.correrEtapa(etapa2)),"117,75");
        assertEquals(String.format("%.2f",Ciclista1.correrEtapa(etapa3)),"272,87");
        assertEquals(String.format("%.2f",Ciclista2.correrEtapa(etapa3)),"185,62");
        assertEquals(String.format("%.2f",Ciclista3.correrEtapa(etapa3)),"145,72");
    }
    
    @Test
    public void testGetTotalMinutos(){
        Ciclista1.correrEtapa(etapa1);
        Ciclista2.correrEtapa(etapa1);
        Ciclista3.correrEtapa(etapa1);
        Ciclista1.correrEtapa(etapa2);
        Ciclista2.correrEtapa(etapa2);
        Ciclista3.correrEtapa(etapa2);
        Ciclista1.correrEtapa(etapa3);
        Ciclista2.correrEtapa(etapa3);
        Ciclista3.correrEtapa(etapa3);
        assertEquals(String.format("%.2f",Ciclista1.getTotalTime()),"642,21");
        assertEquals(String.format("%.2f",Ciclista2.getTotalTime()),"436,88");
        assertEquals(String.format("%.2f",Ciclista3.getTotalTime()),"342,95");
    }
    
    @Test
    public void testGetResultadoEtapa(){
        Ciclista1.correrEtapa(etapa1);
        Ciclista2.correrEtapa(etapa1);
        Ciclista3.correrEtapa(etapa1);
        Ciclista1.correrEtapa(etapa2);
        Ciclista2.correrEtapa(etapa2);
        Ciclista3.correrEtapa(etapa2);
        Ciclista1.correrEtapa(etapa3);
        Ciclista2.correrEtapa(etapa3);
        Ciclista3.correrEtapa(etapa3);
        
        assertEquals(String.format("%.2f",Ciclista2.getHistorialTiempo(etapa2)),"150,00");
        assertEquals(String.format("%.2f",Ciclista2.getHistorialTiempo(etapa3)),"185,62");
        assertEquals(String.format("%.2f",Ciclista1.getHistorialTiempo(etapa3)),"272,87");
        assertEquals(String.format("%.2f",Ciclista3.getHistorialTiempo(etapa1)),"79,48");   
    }
    @Test
    public void testGetDestreza(){
        assertEquals(String.format("%.2f",Ciclista3.getDestreza()),"1,00");
        assertEquals(String.format("%.2f",Ciclista1.getDestreza()),"0,50");
        assertEquals(String.format("%.2f",Ciclista2.getDestreza()),"0,77");
        
    }
    @Test
    public void testGetEtapasTerminadas(){
        Ciclista6.correrEtapa(etapa1);
        Ciclista6.correrEtapa(etapa2);
        Ciclista6.correrEtapa(etapa3);
        assertEquals(Ciclista6.getEtapasTerminadas(), 2);

    }
    @Test
    public void testGetEtapabandonado(){
        Ciclista6.correrEtapa(etapa1);
        Ciclista6.correrEtapa(etapa2);
        Ciclista6.correrEtapa(etapa3);
        Etapa etapaabandonado;
        etapaabandonado=Ciclista6.getEtapabandonado();
        boolean iguales=false;
        iguales=etapa3.equals(etapaabandonado);
        assertTrue(iguales);    
    }
    
}
