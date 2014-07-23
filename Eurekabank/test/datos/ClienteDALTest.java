/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package datos;

import entidades.Cliente;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sistemas
 */
public class ClienteDALTest {
    private Cliente cliente;

    public ClienteDALTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        String codigo = "00040";
        String paterno ="ROSAS";
        String materno = "GARCIA";
        String nombre ="LUIS ALFONSO";
        String dni ="10258769";
        String ciudad = "TUMBES";
        String  direccion = "Av.Sausales 145";
        String telefono ="3658-1458";
        String email="rosas@yahoo.com";

        cliente = new Cliente(codigo,paterno,materno,nombre,dni,ciudad,direccion,telefono,email);
    }

    /**
     * Test of insertarCliente method, of class ClienteDAL.
     */
    @Test
    public void testInsertarCliente() {
        System.out.println("insertarCliente");
        String expResult = "Insertado";
        String result = new ClienteDAL().insertarCliente(cliente);
        assertEquals(result,expResult);
    }

    /**
     * Test of buscarCliente method, of class ClienteDAL.
     */
    @Test
    public void testBuscarCliente() {
        System.out.println("buscarCliente");
        String codigo = "00002";
        ClienteDAL clienteD = new ClienteDAL();
        String expResult = "00002";
        String result = clienteD.buscarCliente(codigo);
        assertEquals(expResult, result);
    }
}