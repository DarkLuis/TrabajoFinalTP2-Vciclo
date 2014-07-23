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
 * @author Sistemas
 */
public class EmpleadoBL {

    public int buscarEmpleado(String codigo) {
        if(codigo.trim().length() == 4) {
            if (new EmpleadoDAL().buscarEmpleado(codigo) == null)
                return -1;  // Codigo no existe
            else
                return 1;  // Codigo ya existe o
                           // sucedio excepción
        }
        return 0;  // Codigo no valido
    }

    public int insertarEmpleado(String codigo, String paterno,
            String materno, String nombre,
            String ciudad, String direccion,
            String usuario, String clave) {
        if(codigo.trim().length() == 4 &&
            paterno.trim().length()>0 &&
            paterno.trim().length()<=25 &&
            materno.trim().length()>0 &&
            materno.trim().length()<=25 &&
            nombre.trim().length()>0 &&
            nombre.trim().length()<=30 &&
            ciudad.trim().length()>0 &&
            ciudad.trim().length()<=30 &&
            direccion.trim().length()>0 &&
            direccion.trim().length()<=50 &&
            usuario.trim().length()>0 &&
            usuario.trim().length()<=15 &&
            clave.trim().length()>0 &&
            clave.trim().length()<=15) {
            Empleado empleado = new Empleado(codigo,
                    paterno, materno, nombre, ciudad,
                    direccion, usuario, clave);
            String mensaje = new EmpleadoDAL().insertarEmpleado(empleado);
            if( mensaje == null) {
                showMessageDialog(null, "Registro insertado","Resultado", 1);
                return 1;  // Registro insertado
            }
            else {
                showMessageDialog(null, mensaje,"Error", 1);
                return 0;  // Ocurrió una excepción
            }
        }
        showMessageDialog(null, "Datos no validos", "Error", 0);
        return -1;  // Datos no válidos
    }


    public void EliminarEmpleado(String codigo){
        if (new EmpleadoDAL().buscarEmpleado(codigo)!=null){
            if(new CuentaDAL().eLiminarcuentasXEmpleados(codigo)==null)
             if(new MovimientoDAL().EliminarMovimientosxEmpleado(codigo)==null)
                if(new AsignadoDAL().EliminarAsignacioxEmpleado(codigo)==null)
                    if(new EmpleadoDAL().eLiminarempleado(codigo)==null)
                        showMessageDialog(null, "Empleado Eliminado","Resultado", 1);
        }else
           showMessageDialog(null, "Codigo no existe","Error", 0);
    }

    public ArrayList<Empleado> listarEmpleado() {
        return new EmpleadoDAL().listarEmpleado();
    }


    //copiado de la carpata Reportes/Archivo2//
    public void ejecutarReporte() {
            new EmpleadoDAL().ejecutarReporte();

    }

     public void ejecutarReporteMov(String codigo) {
       if(codigo.trim().length()==4){
         if(new EmpleadoDAL().buscarEmpleado(codigo)!=null)
             new EmpleadoDAL().ejecutarReporteMov(codigo);
         else
             showMessageDialog(null, "Codigo no existe","Error", 0);
         }else
             showMessageDialog(null, "Formato de Codigo Incorrecto","Error", 0);

    }

}

 