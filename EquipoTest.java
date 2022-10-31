

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
    /**
     * Default constructor for test class EquipoTest
     */
    public EquipoTest()
    {
        Equipo movistarWomen = new Equipo("Movistar Women", 'H', 'P');
        Equipo dSMWomen= new Equipo("DSM Women", 'E', 'P');
        Equipo trekSegafredoWomen = new Equipo("Trek Segafredo Women",'H','P');
        Ciclista cliclista1 = new Ciclista("WIEBES",  4.97, 1190,dSMWomen);
        Ciclista cliclista2 = new Ciclista("LIPPERT", 5.0, 1160,dSMWomen);
        Ciclista cliclista3 = new Ciclista("LABOUS", 5.01, 1150,dSMWomen);
        Ciclista cliclista4 = new Ciclista("VAN VLEUTEN", 4.96,1200,movistarWomen);
        Ciclista cliclista5 = new Ciclista("NORSGAARD", 5.02,1145,movistarWomen);
        Ciclista cliclista6 = new Ciclista("SIERRA", 5.03, 1130,movistarWomen);
        Ciclista cliclista7 = new Ciclista("BALSAMO", 4.98,1180,trekSegafredoWomen);
        Ciclista cliclista8 = new Ciclista("LONGO-BORGHINI", 4.99,1175,trekSegafredoWomen);
        Ciclista cliclista9 = new Ciclista("CORDON-RAGOT", 5.04, 1120,trekSegafredoWomen);
        dSMWomen.addCiclista(cliclista1);
        dSMWomen.addCiclista(cliclista2);
        dSMWomen.addCiclista(cliclista3);
        movistarWomen.addCiclista(cliclista4);
        movistarWomen.addCiclista(cliclista5);
        movistarWomen.addCiclista(cliclista6);   
        trekSegafredoWomen.addCiclista(cliclista7);
        trekSegafredoWomen.addCiclista(cliclista8);
        trekSegafredoWomen.addCiclista(cliclista9);

        
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
    public void testabandonados(){
        //int a=movistarWomen.getCiclistas().size();
        // b=movistarWomen.getCiclistas().size();
    }
}
