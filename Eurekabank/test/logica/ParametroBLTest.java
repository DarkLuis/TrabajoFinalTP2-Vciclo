/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

//import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sistemas
 */
public class ParametroBLTest {

    public ParametroBLTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    /**
     * Test of insertarParametro method, of class ParametroBL.
     */
    @Test
    public void testInsertarParametro() {
        System.out.println("insertarParametro");
        String codigo = "004";
        String descripcion = "Impusto";
        String valor = "19";
        String estado = "ACTIVO";
        ParametroBL parametro = new ParametroBL();
        int expResult = 0;
        int result = parametro.insertarParametro(codigo, descripcion, valor, estado);
        assertEquals("El codigo insertado ya existe",expResult, result);
    }

    /**
     * Test of buscarParametro method, of class ParametroBL.
     */
    @Test
    public void testBuscarParametro() {
        System.out.println("buscarParametro");
        String codigo = "001";
        ParametroBL parametro=new ParametroBL();
        String expResult = "001";
        String result = parametro.buscarParametro(codigo);
        assertEquals(expResult,(result));
    }
}