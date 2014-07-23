/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

import java.util.GregorianCalendar;
import junit.framework.TestCase;

/**
 *
 * @author Sistemas
 */
public class CuentaTest extends TestCase {

    private Cuenta cuenta;
    public CuentaTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        String codigo="00200001";
        String codigoM="01";
        String codigoS="002";
        String codigoE="0001";
        String codigoC="00008";
        double saldo= 7000.00;
        GregorianCalendar fecha= new GregorianCalendar(2008,05,01);
        String estado="ACTIVO";
        int costMovimiento=15;
        String clave="123456";

        cuenta = new Cuenta(codigo,codigoM,codigoS,codigoE,codigoC,
                saldo,fecha,estado,costMovimiento,clave);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testGetCodigo() {
        System.out.println("getCodigo");
        String expResult = "00200001";
        String result = cuenta.getCodigo();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    public void testSetCodigo() {
        System.out.println("setCodigo");
        String codigo = "00200001";
        cuenta.setCodigo(codigo);
        assertTrue(codigo.equals(cuenta.getCodigo()));
    }

    public void testGetCodigoM() {
        System.out.println("getCodigoM");
        String expResult = "01";
        String result = cuenta.getCodigoM();
        assertEquals(expResult, result);
    }

    public void testSetCodigoM() {
        System.out.println("setCodigoM");
        String codigoM = "01";
        cuenta.setCodigoM(codigoM);
        assertTrue(codigoM.equals(cuenta.getCodigoM()));
    }

    public void testGetCodigoS() {
        System.out.println("getCodigoS");
        String expResult = "002";
        String result = cuenta.getCodigoS();
        assertEquals(expResult, result);
    }

    public void testSetCodigoS() {
        System.out.println("setCodigoS");
        String codigoS = "002";
        cuenta.setCodigoS(codigoS);
        assertTrue(codigoS.equals(cuenta.getCodigoS()));
    }

    public void testGetCodigoE() {
        System.out.println("getCodigoE");
        String expResult = "0001";
        String result = cuenta.getCodigoE();
        assertEquals(expResult, result);
    }

    public void testSetCodigoE() {
        System.out.println("setCodigoE");
        String codigoE = "0001";
        cuenta.setCodigoE(codigoE);
        assertTrue(codigoE.equals(cuenta.getCodigoE()));
    }

    public void testGetCodigoC() {
        System.out.println("getCodigoC");
        String expResult = "00008";
        String result = cuenta.getCodigoC();
        assertEquals(expResult, result);
    }

    public void testSetCodigoC() {
        System.out.println("setCodigoC");
        String codigoC = "00008";
        cuenta.setCodigoC(codigoC);
        assertTrue(codigoC.equals(cuenta.getCodigoC()));
    }

    public void testGetSaldo() {
        System.out.println("getSaldo");
        double expResult = 7000.00;
        double result = cuenta.getSaldo();
        assertEquals(expResult, result, 0.0);
    }

    public void testSetSaldo() {
        System.out.println("setSaldo");
        double saldo = 7000.00;
        cuenta.setSaldo(saldo);
        assertEquals(saldo,cuenta.getSaldo());
    }

    public void testGetFecha() {
        System.out.println("getFecha");
        GregorianCalendar expResult = new GregorianCalendar(2008,05,01);
        GregorianCalendar result = cuenta.getFecha();
        assertEquals(expResult, result);
    }

    public void testSetFecha() {
        System.out.println("setFecha");
        GregorianCalendar fecha = new GregorianCalendar(2008,05,01);
        cuenta.setFecha(fecha);
        assertTrue(fecha.equals(cuenta.getFecha()));
    }

    public void testGetEstado() {
        System.out.println("getEstado");
        String expResult = "ACTIVO";
        String result = cuenta.getEstado();
        assertEquals(expResult, result);
    }

    public void testSetEstado() {
        System.out.println("setEstado");
        String estado = "activo";
        cuenta.setEstado(estado);
        assertTrue(estado.equals(cuenta.getEstado()));
    }

    public void testGetCostMovimiento() {
        System.out.println("getCostMovimiento");
        int expResult = 15;
        int result = cuenta.getCostMovimiento();
        assertEquals(expResult, result);
    }

    public void testSetCostMovimiento() {
        System.out.println("setCostMovimiento");
        int costMovimiento = 15;
        cuenta.setCostMovimiento(costMovimiento);
        assertEquals(costMovimiento,cuenta.getCostMovimiento());
    }

    public void testGetClave() {
        System.out.println("getClave");
        String expResult = "123456";
        String result = cuenta.getClave();
        assertEquals(expResult, result);
    }

    public void testSetClave() {
        System.out.println("setClave");
        String clave = "123456";
        cuenta.setClave(clave);
        assertTrue(clave.equals(cuenta.getClave()));
    }

    public void testCompareTo() {
        System.out.println("compareTo");
        Cuenta cuentaC = new Cuenta();
        cuentaC.setCodigo("00200001");
        int expResult = 0;
        int result = cuenta.compareTo(cuentaC);
        assertEquals(expResult,result );
    }
}
