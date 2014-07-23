/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author g
 */
public class EmpleadoTest1 {
    private Empleado empleado;

    public EmpleadoTest1() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        String codigo = "0001";
        String paterno = "Romero";
        String materno = "Castillo";
        String nombre = "Carlos Alberto";
        String cuidad = "Trujillo";
        String direccion = "Call1 1 Nro. 456";
        String usuario = "cromero";
        String clave = "chicho";

        empleado= new Empleado(codigo, paterno,materno,nombre,cuidad,direccion,usuario,clave);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getCodigo method, of class Empleado.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        assertEquals("0001",empleado.getCodigo());
    }

    /**
     * Test of setCodigo method, of class Empleado.
     */
    @Test
    public void testSetCodigo() {
        System.out.println("setCodigo");
        String codigo = "0001";
        empleado.setCodigo(codigo);
        assertTrue(codigo.equals(empleado.getCodigo()));
    }

    /**
     * Test of getPaterno method, of class Empleado.
     */
    @Test
    public void testGetPaterno() {
        System.out.println("getPaterno");
        assertEquals("Romero",empleado.getPaterno());
    }

    /**
     * Test of setPaterno method, of class Empleado.
     */
    @Test
    public void testSetPaterno() {
        System.out.println("setPaterno");
        String paterno = "Romero";
        empleado.setCodigo(paterno);
        assertTrue(paterno.equals(empleado.getPaterno()));
    }

    /**
     * Test of getMaterno method, of class Empleado.
     */
    @Test
    public void testGetMaterno() {
        System.out.println("getMaterno");
         assertEquals("Castillo",empleado.getMaterno());
    }

    /**
     * Test of setMaterno method, of class Empleado.
     */
    @Test
    public void testSetMaterno() {
        System.out.println("setMaterno");
        String materno = "Castillo";
        empleado.setMaterno(materno);
        assertTrue(materno.equals(empleado.getMaterno()));
    }

    /**
     * Test of getNombre method, of class Empleado.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        assertEquals("Carlos Alberto",empleado.getNombre());
    }

    /**
     * Test of setNombre method, of class Empleado.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "Carlos Alberto";
        empleado.setNombre(nombre);
        assertTrue(nombre.equals(empleado.getNombre()));
    }

    /**
     * Test of getCiudad method, of class Empleado.
     */
    @Test
    public void testGetCiudad() {
        System.out.println("getCiudad");
        assertEquals("Trujillo",empleado.getCiudad());
    }

    /**
     * Test of setCiudad method, of class Empleado.
     */
    @Test
    public void testSetCiudad() {
        System.out.println("setCiudad");
        String ciudad = "Trujillo";
        empleado.setCiudad(ciudad);
        assertTrue(ciudad.equals(empleado.getCiudad()));
    }

    /**
     * Test of getDireccion method, of class Empleado.
     */
    @Test
    public void testGetDireccion() {
        System.out.println("getDireccion");
        assertEquals("Call1 1 Nro. 456",empleado.getDireccion());
    }

    /**
     * Test of setDireccion method, of class Empleado.
     */
    @Test
    public void testSetDireccion() {
        System.out.println("setDireccion");
        String direccion = "Call1 1 Nro. 456";
        empleado.setDireccion(direccion);
        assertTrue(direccion.equals(empleado.getDireccion()));
    }

    /**
     * Test of getUsuario method, of class Empleado.
     */
    @Test
    public void testGetUsuario() {
        System.out.println("getUsuario");
        assertEquals("cromero",empleado.getUsuario());
    }

    /**
     * Test of setUsuario method, of class Empleado.
     */
    @Test
    public void testSetUsuario() {
        System.out.println("setUsuario");
        String usuario = "cromero";
        empleado.setUsuario(usuario);
        assertTrue(usuario.equals(empleado.getUsuario()));
    }

    /**
     * Test of getClave method, of class Empleado.
     */
    @Test
    public void testGetClave() {
        System.out.println("getClave");
        assertEquals("chicho",empleado.getClave());
    }

    /**
     * Test of setClave method, of class Empleado.
     */
    @Test
    public void testSetClave() {
        System.out.println("setClave");
        String clave = "chicho";
        empleado.setClave(clave);
        assertTrue(clave.equals(empleado.getClave()));
    }

    /**
     * Test of compareTo method, of class Empleado.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Empleado empleadoE = new Empleado();
        empleadoE.setCodigo("0001");
        int expResult=0;
        int result= empleado.compareTo(empleadoE);
        assertEquals(expResult,result);
    }

}