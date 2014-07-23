/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import junit.framework.TestCase;
import logica.SucursalBL;

/**
 *
 * @author MorilloC
 */
public class Sucursal extends TestCase {
    
    public Sucursal(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    public void testInsertarSucursal()
    {
        String codigo,nombre,ciudad,direccion;
        int numero;
        codigo="016";
        nombre="Huaca del sol";
        ciudad="Trujillo";
        direccion="Av.San Juan";
        numero=2;
       SucursalBL suc=new SucursalBL();
       assertTrue(suc.insertarSucursal(codigo,nombre,ciudad,direccion,numero)==0);
    }
     public void testBuscarSucursal()
    {
        String codigo,C;
        codigo="001";
        C="001";
       SucursalBL suc=new SucursalBL();
       assertTrue(suc.buscarSucursal(codigo).equalsIgnoreCase(C));
    }
}
