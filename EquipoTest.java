import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class EquipoTest.
 *
 * @author Alexeido, Thander y Natera
 * @version 31-10-2022
 */
public class EquipoTest
{
    Equipo dSMWomen;
    
    Ciclista ciclista1 = new CiclistaEstrella("WIEBES",CiclistaHabilidad.BUENA  , 1190,dSMWomen);
    Ciclista ciclista2 = new CiclistaExperimentado("LIPPERT",CiclistaHabilidad.NORMAL, 1160,dSMWomen);
    Ciclista ciclista3 = new CiclistaNovato("ALEXEIDO",CiclistaHabilidad.NORMAL, 1200,dSMWomen);
    
    Etapa etapa1 = new Etapa("sencilla larga", EtapaDificultad.NORMAL, EtapaDistancia.INTERMEDIA);
    Etapa etapa2 = new Etapa("compleja corta", EtapaDificultad.COMPLEJA, EtapaDistancia.LARGA);
    
    Bicicleta bicicleta1= new Bicicleta("TREK Madone SLR 9 eTap Gen 7",BicicletaPeso.LIGERA);
    Bicicleta bicicleta2= new BicicletaRapida("TREK Emonda SLR 9 eTap",BicicletaPeso.PESADA,0.5); 
    Bicicleta bicicleta3= new BicicletaPrototipo("TREK Domane SLR 9 eTap Gen 4",BicicletaPeso.PESADA);
    /**
     * Default constructor for test class EquipoTest
     */
    public EquipoTest()
    {
        dSMWomen= new Equipo("DSM Women", new EnergiaComparatorAsc(), new PesoComparatorAsc());
        dSMWomen.addCiclista(ciclista1);
        dSMWomen.addCiclista(ciclista2);
        dSMWomen.addCiclista(ciclista3);
        dSMWomen.addBicicleta(bicicleta1);
        dSMWomen.addBicicleta(bicicleta2);
        dSMWomen.addBicicleta(bicicleta3);

        ciclista1.setBicicleta(bicicleta1);
        ciclista2.setBicicleta(bicicleta2);
        ciclista1.correrEtapa(etapa1);
        ciclista2.correrEtapa(etapa1);
        ciclista1.correrEtapa(etapa2);
        ciclista2.correrEtapa(etapa2);
        dSMWomen.setTiempoMedio();
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
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
    public void testSetTiempoMedio(){ 
        assertEquals(String.format("%.2f",dSMWomen.getTiempoMedio()),"198,52");
    }
    
    @Test
    public void testEnviarEtapa(){
        assertTrue(ciclista1.getEnergia() < 1190);
        assertTrue(ciclista2.getEnergia() < 1160);
    }
        @Test 
        void testOrdenCiclistas(){
        Ciclista ciclistAux1=dSMWomen.getCiclistas().get(0);
        Ciclista ciclistAux2=dSMWomen.getCiclistas().get(2);
        dSMWomen.reOrdenCiclista(new HabilidadComparatorDesc());
        boolean correcto1=false;
        boolean correcto2=false;
        correcto1=ciclistAux2.equals(dSMWomen.getCiclistas().get(1));
        correcto2=ciclistAux1.equals(dSMWomen.getCiclistas().get(2));
        assertTrue(correcto1);
        assertTrue(correcto2); 
        }
    @Test 
    void testOrdenBicis(){
        Bicicleta biciAux1=dSMWomen.getBicis().get(0);
        Bicicleta biciAux2=dSMWomen.getBicis().get(2);
        dSMWomen.reOrdenBicicleta(new PesoComparatorDesc());
        boolean correcto1=false;
        boolean correcto2=false;
        correcto1=biciAux2.equals(dSMWomen.getBicis().get(1));
        correcto2=biciAux1.equals(dSMWomen.getBicis().get(2));
        assertTrue(correcto1);
        assertTrue(correcto2); 
 
    }
}
