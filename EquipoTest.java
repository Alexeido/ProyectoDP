

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
        Ciclista cliclista2 = new Ciclista();
        Ciclista cliclista3 = new Ciclista();
        Ciclista cliclista4 = new Ciclista();
        Ciclista cliclista5 = new Ciclista();
        Ciclista cliclista6 = new Ciclista();
        Ciclista cliclista7 = new Ciclista();
        Ciclista cliclista8 = new Ciclista();
        Ciclista cliclista9 = new Ciclista();
        

        dSMWomen.addCiclista(cliclista1);
        dSMWomen.addCiclista(new Ciclista("LIPPERT", 5.0, 1160,dSMWomen));
        dSMWomen.addCiclista(new Ciclista("LABOUS", 5.01, 1150,dSMWomen));
        movistarWomen.addCiclista(new Ciclista("VAN VLEUTEN", 4.96,1200,movistarWomen));
        movistarWomen.addCiclista(new Ciclista("NORSGAARD", 5.02,1145,movistarWomen));
        movistarWomen.addCiclista(new Ciclista("SIERRA", 5.03, 1130,movistarWomen));   
        trekSegafredoWomen.addCiclista(new Ciclista("BALSAMO", 4.98,1180,trekSegafredoWomen));
        trekSegafredoWomen.addCiclista(new Ciclista("LONGO-BORGHINI", 4.99,1175,trekSegafredoWomen));
        trekSegafredoWomen.addCiclista(new Ciclista("CORDON-RAGOT", 5.04, 1120,trekSegafredoWomen));
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
        //ciclista.getTeam().addCiclistaAbandonado(ciclista);
    }
}
