
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ImpresoraTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ImpresoraTest
{
    /**
     * Default constructor for test class ImpresoraTest
     */
    public ImpresoraTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testImprimir1()
    {
        Impresora impresora = new Impresora(100, 10);
        impresora.imprimir(50);
        assertEquals(0, impresora.getTinta());
        assertEquals(0, impresora.getHojas());
        assertEquals(40, impresora.getPaginasPendientesPorImprimir());
    }

    @Test
    public void testImprimir2()
    {
        Impresora impresora = new Impresora(100, 20);
        impresora.imprimir(10);
        assertEquals(0, impresora.getTinta());
        assertEquals(10, impresora.getHojas());
        assertEquals(0, impresora.getPaginasPendientesPorImprimir());
        impresora.imprimir(1);
        assertEquals(0, impresora.getTinta());
        assertEquals(10, impresora.getHojas());
        assertEquals(1, impresora.getPaginasPendientesPorImprimir());
    }   
    
    @Test
    public void testImprimir3()
    {
        Impresora impresora = new Impresora(100, 20);
        impresora.imprimir(10);
        assertEquals(0, impresora.getTinta());
        assertEquals(10, impresora.getHojas());
        assertEquals(0, impresora.getPaginasPendientesPorImprimir());
        
        impresora.imprimir(11);
        assertEquals(0, impresora.getTinta());
        assertEquals(10, impresora.getHojas());
        assertEquals(11, impresora.getPaginasPendientesPorImprimir());
        
        impresora.recargarTinta(110);
        assertEquals(10, impresora.getTinta());
        assertEquals(0, impresora.getHojas());
        assertEquals(1, impresora.getPaginasPendientesPorImprimir());
        
        impresora.recargarHojas(1);
        assertEquals(0, impresora.getTinta());
        assertEquals(0, impresora.getHojas());
        assertEquals(0, impresora.getPaginasPendientesPorImprimir());
    }  
    
    @Test
    public void testImprimir4()
    {
        Impresora impresora = new Impresora(200, 10);
        impresora.imprimir(10);
        assertEquals(100, impresora.getTinta());
        assertEquals(0, impresora.getHojas());
        assertEquals(0, impresora.getPaginasPendientesPorImprimir());
        
        impresora.imprimir(11);
        assertEquals(100, impresora.getTinta());
        assertEquals(0, impresora.getHojas());
        assertEquals(11, impresora.getPaginasPendientesPorImprimir());
        
        impresora.recargarHojas(11);
        assertEquals(0, impresora.getTinta());
        assertEquals(1, impresora.getHojas());
        assertEquals(1, impresora.getPaginasPendientesPorImprimir());
        
        impresora.recargarTinta(10);
        assertEquals(0, impresora.getTinta());
        assertEquals(0, impresora.getHojas());
        assertEquals(0, impresora.getPaginasPendientesPorImprimir());
    }  
    
    @Test
    public void testRecargar()
    {
        Impresora impresora = new Impresora(100, 10);
        impresora.recargarHojas(20);
        impresora.recargarTinta(100);
        assertEquals(200, impresora.getTinta());
        assertEquals(30, impresora.getHojas());
        assertEquals(0, impresora.getPaginasPendientesPorImprimir());
    }
}

