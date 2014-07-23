/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jefferson
 */
public class ClienteTest {
    private Cliente cliente;
    
    public ClienteTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        String codigo ="00002";
        String paterno = "VALENCIA";
        String materno ="MORALES";
        String nombre = "PEDRO HUGO";
        String dni= "01576173";
        String ciudad = "LIMA";
        String direccion = "MAGDALENA";
        String telefono= "924-7834";
        String email ="pvalecia@terra.com.pe";
        
        cliente = new Cliente (codigo, paterno,materno,nombre,dni,ciudad,direccion,telefono,email);
    }

    /**
     * Test of getCodigo method, of class Cliente.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        assertEquals("00002", cliente.getCodigo());
        
    }

    /**
     * Test of setCodigo method, of class Cliente.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        String codigo = "00002";
        cliente.setCodigo(codigo);
        assertTrue(codigo.equals(cliente.getCodigo()));
    }

    /**
     * Test of getPaterno method, of class Cliente.
     */
    @Test
    public void testGetPaterno() {
        System.out.println("getPaterno");
        assertEquals("VALENCIA", cliente.getPaterno());
    }

    /**
     * Test of setPaterno method, of class Cliente.
     */
    @Test
    public void testSetPaterno() {
        System.out.println("setPaterno");
        String paterno = "VALENCIA";
        cliente.setPaterno(paterno);
        assertTrue(paterno.equals(cliente.getPaterno()));
    }

    /**
     * Test of getMaterno method, of class Cliente.
     */
    @Test
    public void testGetMaterno() {
        System.out.println("getMaterno");
        assertEquals("MORALES",cliente.getMaterno());
    }

    /**
     * Test of setMaterno method, of class Cliente.
     */
    @Test
    public void testSetMaterno() {
        System.out.println("setMaterno");
        String materno = "MORALES";
        cliente.setMaterno(materno);
        assertTrue(materno.equals(cliente.getMaterno()));
    }

    /**
     * Test of getNombre method, of class Cliente.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        assertEquals("PEDRO HUGO", cliente.getNombre());
    }

    /**
     * Test of setNombre method, of class Cliente.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "PEDRO HUGO";
        cliente.setNombre(nombre);
        assertTrue(nombre.equals(cliente.getNombre()));
    }

    /**
     * Test of getDni method, of class Cliente.
     */
    @Test
    public void testGetDni() {
        System.out.println("getDni");
        assertEquals("01576173",cliente.getDni());
    }

    /**
     * Test of setDni method, of class Cliente.
     */
    @Test
    public void testSetDni() {
        System.out.println("setDni");
        String dni = "01576173";
        cliente.setDni(dni);
        assertTrue(dni.equals(cliente.getDni()));
    }

    /**
     * Test of getCiudad method, of class Cliente.
     */
    @Test
    public void testGetCiudad() {
        System.out.println("getCiudad");
        assertEquals("LIMA", cliente.getCiudad());
    }

    /**
     * Test of setCiudad method, of class Cliente.
     */
    @Test
    public void testSetCiudad() {
        System.out.println("setCiudad");
        String ciudad = "LIMA";
        cliente.setCiudad(ciudad);
        assertTrue(ciudad.equals(cliente.getCiudad()));
    }

    /**
     * Test of getDireccion method, of class Cliente.
     */
    @Test
    public void testGetDireccion() {
        System.out.println("getDireccion");
        assertEquals("MAGDALENA", cliente.getDireccion());
    }

    /**
     * Test of setDireccion method, of class Cliente.
     */
    @Test
    public void testSetDireccion() {
        System.out.println("setDireccion");
        String direccion = "MAGDALENA";
        cliente.setDireccion(direccion);
        assertTrue(direccion.equals(cliente.getDireccion()));
    }

    /**
     * Test of getTelefono method, of class Cliente.
     */
    @Test
    public void testGetTelefono() {
        System.out.println("getTelefono");
        assertEquals("924-7834",cliente.getTelefono());
    }

    /**
     * Test of setTelefono method, of class Cliente.
     */
    @Test
    public void testSetTelefono() {
        System.out.println("setTelefono");
        String telefono = "924-7834";
        cliente.setTelefono(telefono);
        assertTrue(telefono.equals(cliente.getTelefono()));
    }

    /**
     * Test of getEmail method, of class Cliente.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        assertEquals("pvalecia@terra.com.pe", cliente.getEmail());
    }

    /**
     * Test of setEmail method, of class Cliente.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "pvalecia@terra.com.pe";
        cliente.setEmail(email);
        assertTrue(email.equals(cliente.getEmail()));
    }

    /**
     * Test of compareTo method, of class Cliente.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Cliente clienteC = new Cliente();
        clienteC.setCodigo("00002");
        int expResult = 0;
        int result = cliente.compareTo(clienteC);
        assertEquals(expResult,result );
    }
}
