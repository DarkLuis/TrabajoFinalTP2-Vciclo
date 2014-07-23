/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import entidades.*;
import accesoADatos.*;
import java.util.*;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Jose Andre
 */
public class AsignadoBL {
    public int buscarAsignado(String codigoAsignado) {
        if(codigoAsignado.trim().length() == 6) {
            if (new AsignadoDAL().buscarAsignado(codigoAsignado) == null)
                return -1;  // Codigo no existe
            else
                return 1;  // Codigo ya existe o
                           // sucedio excepción
        }
        return 0;  // Codigo no valido
    }

    public int insertarAsignado(String codigoAsignado, String codigoSucursal,
            String codigoEmpleado, Fecha fechaAlta, Fecha fechaBaja) {
        if(codigoAsignado.trim().length() == 6 &&
            codigoSucursal.trim().length() == 3 &&
            codigoEmpleado.trim().length() == 4) {
            Asignado asignado = new Asignado(codigoAsignado, codigoSucursal, codigoEmpleado,
                    fechaAlta, fechaBaja);
            String mensaje = new AsignadoDAL().insertarAsignado(asignado);
            if( mensaje == null) {
                showMessageDialog(null, "Registro insertado", "Resultado", 1);
                return 1;  // Registro insertado
            }
            else {
                showMessageDialog(null, mensaje, "Error", 1);
                return 0;  // Ocurrió una excepción
            }
        }
        showMessageDialog(null, "Datos no validos", "Error", 1);
        return -1;  // Datos no válidos
    }

    public ArrayList<Asignado> listarAsignado() {
        return new AsignadoDAL().listarAsignado();
    }

    //copiado de la carpata Reportes/Archivo2//
    public void ejecutarReporte(String codigoAsignado) {
        if(codigoAsignado.trim().length() == 6)
            new AsignadoDAL().ejecutarReporte(codigoAsignado);
    }

}
