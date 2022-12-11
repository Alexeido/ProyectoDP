
/**
 * Clase de pruebas de la organizacion
 * 
 * @author Alexeido, Thander y Natera
 * @version 1,0
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class OrganizacionTest.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OrganizacionTest {
    /**
     * Default constructor for test class OrganizacionTest
     */
    Equipo dSMWomen;
    Organizacion organizacion;

    public OrganizacionTest() {
        dSMWomen = new Equipo("DSM Women", new EnergiaComparatorAsc(), new PesoComparatorAsc());
        organizacion = new Organizacion(new ComparadorDificultadEtapa());
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
    public void testAnadirEquipo() {
        organizacion.anadirEquipo(dSMWomen);
        boolean correcto = false;
        correcto = dSMWomen.equals(organizacion.getEquipos().get(0));
        assertTrue(correcto);
    }

    @Test
    public void testTodosCiclistasAbandonados() {
        Ciclista cliclista1 = new CiclistaNovato("WIEBES", CiclistaHabilidad.LENTA, 1190, dSMWomen);
        Ciclista cliclista2 = new CiclistaExperimentado("LIPPERT", CiclistaHabilidad.NORMAL, 1160, dSMWomen);
        Ciclista cliclista3 = new CiclistaEstrella("LABOUS", CiclistaHabilidad.BUENA, 1150, dSMWomen);
        organizacion.anadirEquipo(dSMWomen);
        organizacion.anadirCiclistaCarrera(dSMWomen);
        Etapa etapa1 = new Etapa("sencilla larga", EtapaDificultad.SENCILLA, EtapaDistancia.CORTA);
        while (!organizacion.comprobarTodosCiclistasAbandonados()) {
            cliclista1.correrEtapa(etapa1);
            cliclista2.correrEtapa(etapa1);
            cliclista3.correrEtapa(etapa1);
            if (cliclista1.getEnergia() < 0)
                organizacion.abandonar(cliclista1);
            if (cliclista2.getEnergia() < 0)
                organizacion.abandonar(cliclista2);
            if (cliclista3.getEnergia() < 0)
                organizacion.abandonar(cliclista3);
        }
        assertTrue(organizacion.comprobarTodosCiclistasAbandonados());
    }

}
