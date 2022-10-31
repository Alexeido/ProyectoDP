

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class BicicletaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BicicletaTest
{
        Bicicleta bicicleta1= new Bicicleta("TREK Madone SLR 9 eTap Gen 7",7.35);
        Bicicleta bicicleta2= new Bicicleta("TREK Emonda SLR 9 eTap",7.65);
        Bicicleta bicicleta3= new Bicicleta("TREK Domane SLR 9 eTap Gen 4",7.85);
        Equipo movistarWomen = new Equipo("Movistar Women", 'H', 'P');
        Ciclista cliclista1 = new Ciclista("WIEBES",  4.97, 1190,movistarWomen);
        Ciclista cliclista2 = new Ciclista("LIPPERT", 5.0, 1160,movistarWomen);
        Ciclista cliclista3 = new Ciclista("LABOUS", 5.01, 1150,movistarWomen);
        Etapa etapa1 = new Etapa("sencilla larga", 0.9, 225);
        Etapa etapa2 = new Etapa("compleja intermedia", 1.1, 200);
        Etapa etapa3 = new Etapa("normal intermedia", 1.0, 200);
    /**
     * Default constructor for test class BicicletaTest
     */
    public BicicletaTest()
    {

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
    public void testGetVelocidad(){
        
        assertEquals(String.format("%.2f", bicicleta1.getVelocidad(etapa1,cliclista1)), "75,13");
        assertEquals(String.format("%.2f", bicicleta2.getVelocidad(etapa2,cliclista2)), "59,42");
        assertEquals(String.format("%.2f", bicicleta3.getVelocidad(etapa3,cliclista3)), "63,82");
    }
    @Test
    public void testGetTime(){
        assertEquals(String.format("%.2f", bicicleta1.getETime(etapa1,cliclista1)), "179,68");
        assertEquals(String.format("%.2f", bicicleta2.getETime(etapa2,cliclista2)), "201,96");
        assertEquals(String.format("%.2f", bicicleta3.getETime(etapa3,cliclista3)), "188,02");
    }
}
