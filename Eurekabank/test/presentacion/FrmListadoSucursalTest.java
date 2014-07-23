/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package presentacion;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sistemas
 */
public class FrmListadoSucursalTest {

    public FrmListadoSucursalTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
         System.out.println("metodo setUp");
    }

    /**
     * Test of main method, of class FrmListadoSucursal.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String sucursal[]= {"001","Sipan","Chiclayo","Av.Balta 1456","2"},x;
        try{
            x=sucursal[5];
            fail("debe lanzar una excepcion");
        }catch(IndexOutOfBoundsException ex){
            javax.swing.JOptionPane.showMessageDialog(null,"SE PRODUJO UNA EXCEPCION: "+ ex.getMessage());
        }
    }
}