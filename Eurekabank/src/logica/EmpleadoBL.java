/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;
import entidades.Empleado;
import datos.EmpleadoDAL;
import java.util.*;
import static javax.swing.JOptionPane.showMessageDialog;
/**
 *
 * @author SNS
 */
public class EmpleadoBL {
    public int insertarEmpleado(String codigo, String paterno, String materno, String nombre,
            String ciudad, String direccion, String usuario, String clave) {
        if(codigo.trim().length()==4){
        if( paterno.trim().length()>0 && paterno.trim().length()<=25
                && materno.trim().length()>0 && materno.trim().length()<=25 &&
                nombre.trim().length()>0 && nombre.trim().length()<=30 &&
                ciudad.trim().length()>0 && ciudad.trim().length()<=30 &&
                direccion.trim().length()>0 && direccion.trim().length()<=50 &&
                usuario.trim().length()>0 && usuario.trim().length()<=15 &&
                clave.trim().length()>0 && clave.trim().length()<=15) {
            if(buscarEmpleado(codigo) == null) {
                Empleado emple = new Empleado(codigo,paterno,materno,nombre,ciudad,direccion,usuario,clave);
                String mensaje = new EmpleadoDAL().insertarEmpleado(emple);
                if(mensaje == null) {
                    showMessageDialog(null,"Registro insertado","Aviso",1);
                    return 0;
                } else {
                    showMessageDialog(null,mensaje,"Problema",0);
                    return 1;
                }
            }else {
                showMessageDialog(null,"Código ya existe","Aviso",2);
                return 2;
            }
        }else {
            showMessageDialog(null,"Datos no válidos","Aviso",0);
            return 3;
        }
        }else{
            showMessageDialog(null,"El código de empleado debe tener cuatro caracteres","Aviso",0);
            return 4;
        }
    }

    public String buscarEmpleado(String codigo) {
        if(codigo.trim().length()==4)
            return new EmpleadoDAL().buscarEmpleado(codigo);
        else
            return null;
    }

    public ArrayList<Empleado> listarEmpleado() {
        return new EmpleadoDAL().listarEmpleado();
    }

    public void ejecutarReporte(String codigo) {
        if(codigo.trim().length()==4)
            new EmpleadoDAL().ejecutarReporte(codigo);
        else
            showMessageDialog(null,"Código no válido",
                    "Reporte de Empleado", 0);
    }

}
