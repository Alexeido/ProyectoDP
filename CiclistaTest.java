

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
    Ciclista Ciclista1, Ciclista2, Ciclista3;
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
        assertEquals(String.format("%.2f",Ciclista1.correrEtapa(etapa1)),"180,91");
        assertEquals(String.format("%.2f",Ciclista2.correrEtapa(etapa1)),"184,68");
        assertEquals(String.format("%.2f",Ciclista3.correrEtapa(etapa1)),"189,16");
        assertEquals(String.format("%.2f",Ciclista1.correrEtapa(etapa2)),"196,54");
        assertEquals(String.format("%.2f",Ciclista2.correrEtapa(etapa2)),"200,64");
        assertEquals(String.format("%.2f",Ciclista3.correrEtapa(etapa2)),"205,51");
        assertEquals(String.format("%.2f",Ciclista1.correrEtapa(etapa3)),"178,67");
        assertEquals(String.format("%.2f",Ciclista2.correrEtapa(etapa3)),"182,40");
        assertEquals(String.format("%.2f",Ciclista3.correrEtapa(etapa3)),"186,83");
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
        assertEquals(String.format("%.2f",Ciclista1.getTotalTime()),"556,12");
        assertEquals(String.format("%.2f",Ciclista2.getTotalTime()),"567,72");
        assertEquals(String.format("%.2f",Ciclista3.getTotalTime()),"581,50");
        
        
        
    }
}
