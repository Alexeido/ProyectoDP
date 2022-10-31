import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class EquipoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class EquipoTest
{
    Equipo dSMWomen= new Equipo("DSM Women", 'E', 'P');
    Ciclista ciclista1 = new Ciclista("WIEBES",  4.97, 1190,dSMWomen);
    Ciclista ciclista2 = new Ciclista("LIPPERT", 5.0, 1160,dSMWomen);
    Etapa etapa1 = new Etapa("sencilla larga", 0.9, 200);
    Etapa etapa2 = new Etapa("compleja corta", 1.1, 150);
    Bicicleta bicicleta1= new Bicicleta("TREK Madone SLR 9 eTap Gen 7",7.35);
    Bicicleta bicicleta2= new Bicicleta("TREK Emonda SLR 9 eTap",7.65); 
    /**
     * Default constructor for test class EquipoTest
     */
    public EquipoTest()
    {
        dSMWomen.addCiclista(ciclista1);
        dSMWomen.addCiclista(ciclista2);
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
        assertEquals(String.format("%.2f",dSMWomen.getTiempoMedio()),"311,42");
    }
    
    @Test
    public void testEnviarEtapa(){
        assertTrue(ciclista1.getEnergia() < 1190);
        assertTrue(ciclista2.getEnergia() < 1160);
    }
}
