/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;
import java.util.ArrayList;
import entidades.Asignado;
import datos.*;
import java.util.GregorianCalendar;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Sara Rojas
 */
public class AsignadoBL {
    public ArrayList<Asignado> listarAsignado() {
        return new AsignadoDAL().listarAsignado();
    }
    
    public int insertarAsignado(String asigcodigo, String sucucodigo, String emplcodigo,GregorianCalendar fechaAlta,GregorianCalendar fechaBaja ) {
        if(asigcodigo.trim().length()==6){
          if(sucucodigo.trim().length()==3){
              if(emplcodigo.trim().length() == 4){
                  if(buscarAsignado(asigcodigo) == null){
                  if (buscarSucursal(sucucodigo) != null) {
                if(buscarEmpleado(emplcodigo) != null){
                    Asignado asignado =
                        new Asignado(asigcodigo, sucucodigo, emplcodigo, fechaAlta,fechaBaja);
                String mensaje =
                        new AsignadoDAL().insertarAsignado(asignado);
                if (mensaje == null) {
                    showMessageDialog(null,
                            "Registro insertado", "Resultado", 1);
                    return 0;
                } else {
                    showMessageDialog(null, mensaje,
                            "Excepción", 0);
                    return 1;
                }
              }else{
                    showMessageDialog(null,"Codigo de empleado no existe, ingresar codigo en tabla Empleado","Error",0);
                    return 2;
              }
            } else {
                showMessageDialog(null,
                        "Código de sucursal no existe, ingrese un nuevo código en tabla sucursal", "Error", 0);
                return 3;
            }
                  }else{
                    showMessageDialog(null, "El código de asignado ya existe", "Error", 0);
              return 4;  
                  }
              }else{
                  showMessageDialog(null, "El código de empleado tiene cuatro caracteres", "Error", 0);
              return 5;
              }
          }else{
              showMessageDialog(null, "El código de sucursal tiene tres caracteres", "Error", 0);
              return 6;
          }  
        }else{
            showMessageDialog(null,"El código de asignado tiene seis caracteres",
                    "Error",0);
            return 7;
        }
    }

    public String buscarSucursal(String sucucodigo) {
        if (sucucodigo.trim().length() == 3) {
            return new SucursalDAL().buscarSucursal(sucucodigo);
        } else {
            return null;
        }
    }
    
    public String buscarEmpleado(String emplcodigo) {
        if (emplcodigo.trim().length() == 4) {
            return new EmpleadoDAL().buscarEmpleado(emplcodigo);
        } else {
            return null;
        }
    }
    
    public String buscarAsignado(String asigcodigo) {
        if (asigcodigo.trim().length() == 6) {
            return new AsignadoDAL().buscarAsignado(asigcodigo);
        } else {
            return null;
        }
    }

    public void ejecutarReporte(String codigo) {
        if(codigo.trim().length()==6)
            new AsignadoDAL().ejecutarReporte(codigo);
        else
            showMessageDialog(null,"Código no válido",
                    "Reporte de Asignado", 0);
    }

}
