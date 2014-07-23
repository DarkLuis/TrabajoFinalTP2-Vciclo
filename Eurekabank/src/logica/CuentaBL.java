/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;
import entidades.*;
import datos.*;
import java.util.*;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author jefferson
 */
public class CuentaBL {
    public int insertarCuenta(String codigo, String codigoM, String codigoS, String codigoE, String codigoC, 
            double saldo, GregorianCalendar fecha, String estado, int costMovimiento, String clave){
        if(codigo.trim().length() == 8 ){
            if(codigoM.length()==2 ){
                if( codigoS.length()==3){
                    if( codigoE.length()==4){
                        if( codigoC.length()==5){
            if(buscarCuenta(codigo) == null) {
                if(buscarMoneda(codigo) != null){
                    if(buscarSucursal(codigo) != null){
                        if(buscarEmpleado(codigo) != null){
                            if(buscarCliente(codigo) != null){
                                Cuenta cuenta = new Cuenta(codigo,codigoM,codigoS,codigoE,codigoC,saldo,fecha,estado,costMovimiento,clave);
                                String mensaje = new CuentaDAL().insertarCuenta(cuenta);
                                if(mensaje == null) {
                                   showMessageDialog(null,"Registro insertado","Aviso",1);
                                   return 0;
                                } else {
                                    showMessageDialog(null,mensaje,"Problema",0);
                                    return 1;
                                }
                            }else{
                                showMessageDialog(null,"Código de Cliente no existe, ingrese nuevo código en tabla Cliente","Aviso",2);
                                return 2;
                            }
                        }else{
                            showMessageDialog(null,"Código de empleado no existe, ingrese nuevo código en tabla Empleado","Aviso",2);
                            return 3;                        }
                }else{
                    showMessageDialog(null,"Código de sucursal no existe, ingrese nuevo código en tabla Sucursal","Aviso",2);
                    return 4;
                }
                }else{
                    showMessageDialog(null,"Código de moneda no existe, ingrese nuevo código en tabla Moneda","Aviso",2);
                    return 5;
                }
            }else {
                showMessageDialog(null,"Código de cuenta ya existe","Aviso",2);
                return 6;
            }
                        }else{
                               showMessageDialog(null,"El código de cliente debe tener cinco caracteres","Aviso",0);
            return 7;
                        }
                    }else{
                        showMessageDialog(null,"El código de empleado debe tener cuatro caracteres","Aviso",0);
            return 8;
                    }
                }else{
                    showMessageDialog(null,"El código de sucursal debe tener tres caracteres","Aviso",0);
            return 9;
                }
            }else{
                showMessageDialog(null,"El código de moneda debe tener dos caracteres","Aviso",0);
            return 10;
            }
        }else {
            showMessageDialog(null,"El código de cuenta debe tener ocho caracteres","Aviso",0);
            return 11;
        }
    }
    
    public String buscarCuenta(String codigo) {
        if(codigo.trim().length()==8)
            return new CuentaDAL().buscarCuenta(codigo);
        else
            return null;
    }
    
   public String buscarMoneda(String monecodigo) {
        if (monecodigo.trim().length() == 2) {
            return new MonedaDAL().buscarMoneda(monecodigo);
        } else {
            return null;
        }
    }
   
   public String buscarSucursal(String sucucodigo) {
        if(sucucodigo.trim().length()==2)
            return new SucursalDAL().buscarSucursal(sucucodigo);
        else
            return null;
    }

    public ArrayList<Cuenta> listarCuenta() {
        return new CuentaDAL().listarCuenta();
    }
    
    public String buscarEmpleado(String codigo) {
        if(codigo.trim().length()==4)
            return new EmpleadoDAL().buscarEmpleado(codigo);
        else
            return null;
    }
    
    public String buscarCliente(String codigo) {
        if(codigo.trim().length()==5)
            return new ClienteDAL().buscarCliente(codigo);
        else
            return null;
    }

    public void ejecutarReporte(String codigo) {
        if(codigo.trim().length()==8)
            new CuentaDAL().ejecutarReporte(codigo);
        else
            showMessageDialog(null,"Código no válido",
                    "Reporte de Cuenta", 0);
    }
}
