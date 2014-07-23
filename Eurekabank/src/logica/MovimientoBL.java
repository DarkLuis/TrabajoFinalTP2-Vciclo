/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import entidades.Movimiento;
import datos.*;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Sara Rojas
 */
public class MovimientoBL {
    public ArrayList<Movimiento> listarMovimiento() {
        return new MovimientoDAL().listarMovimiento();
    }
    
    public int insertarMovimiento(String cuencodigo, int numero,GregorianCalendar fecha, String emplcodigo, String tipocodigo, double importe, String cuenreferencia ) {
        if (cuencodigo.trim().length() == 8) {
            if (buscarCuenta(cuencodigo) != null) {
                Movimiento movimiento =
                        new Movimiento(cuencodigo, numero, fecha,emplcodigo,tipocodigo,importe,cuenreferencia);
                String mensaje =
                        new MovimientoDAL().insertarMovimiento(movimiento);
                if (mensaje != null) {
                    showMessageDialog(null,
                            "Registro insertado", "Resultado", 1);
                    return 0;
                } else {
                    showMessageDialog(null, mensaje,
                            "Excepción", 0);
                    return 1;
                }
            } else {
                showMessageDialog(null,
                        "Código de cuenta no existe, ingresar nuevo código en tabla Cuenta", "Error", 0);
                return 2;
            }
        } else {
            showMessageDialog(null,
                        "El código de la cuenta debe tener ocho caracteres", "Error", 0);
                return 3;
        }
    }

    public String buscarCuenta(String cuencodigo) {
        if (cuencodigo.trim().length() == 8) {
            return new CuentaDAL().buscarCuenta(cuencodigo);
        } else {
            return null;
        }
    }

    public void ejecutarReporte(String codigo) {
        if(codigo.trim().length()==8)
            new MovimientoDAL().ejecutarReporte(codigo);
        else
            showMessageDialog(null,"Código no válido",
                    "Reporte de Movimiento", 0);
    }
    
}
