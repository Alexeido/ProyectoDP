
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class BicicletaTest.
 *
 * @author Alexeido, Thander y Natera
 * @version 31-10-2022
 */
public class BicicletaTest {
    Bicicleta bicicleta1 = new Bicicleta("TREK Madone SLR 9 eTap Gen 7", BicicletaPeso.LIGERA);
    BicicletaRapida bicicleta2 = new BicicletaRapida("TREK Emonda SLR 9 eTap", BicicletaPeso.NORMAL, 0.5);
    BicicletaPrototipo bicicleta3 = new BicicletaPrototipo("TREK Domane SLR 9 eTap Gen 4", BicicletaPeso.PESADA);
    Ciclista cliclista1 = new CiclistaNovato("WIEBES", CiclistaHabilidad.LENTA, 1190, new Equipo());
    Ciclista cliclista2 = new CiclistaExperimentado("LIPPERT", CiclistaHabilidad.NORMAL, 1160, new Equipo());
    Ciclista cliclista3 = new CiclistaEstrella("LABOUS", CiclistaHabilidad.BUENA, 1150, new Equipo());
    Etapa etapa1 = new Etapa("sencilla larga", EtapaDificultad.NORMAL, EtapaDistancia.CORTA);
    Etapa etapa2 = new Etapa("compleja intermedia", EtapaDificultad.SENCILLA, EtapaDistancia.INTERMEDIA);
    Etapa etapa3 = new Etapa("normal intermedia", EtapaDificultad.COMPLEJA, EtapaDistancia.LARGA);

    /**
     * Default constructor for test class BicicletaTest
     */
    public BicicletaTest() {

    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp() {

    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testGetVelocidad() {

        assertEquals(String.format("%.2f", bicicleta1.getVelocidad(etapa1, cliclista1)), "54,42");
        assertEquals(String.format("%.2f", bicicleta2.getVelocidad(etapa2, cliclista2)), "89,39");
        assertEquals(String.format("%.2f", bicicleta3.getVelocidad(etapa3, cliclista3)), "92,65");
    }

    @Test
    public void testGetTime() {
        assertEquals(String.format("%.2f", bicicleta1.getETime(etapa1, cliclista1)), "165,37");
        assertEquals(String.format("%.2f", bicicleta2.getETime(etapa2, cliclista2)), "134,24");
        assertEquals(String.format("%.2f", bicicleta3.getETime(etapa3, cliclista3)), "2,43");
    }

}