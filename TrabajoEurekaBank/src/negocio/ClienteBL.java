/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import java.util.*;
import entidades.*;
import accesoADatos.*;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author sistemas
 */
public class ClienteBL {
    public int insertarCliente(String codigo,String apellidoPaterno,String apellidoMaterno,
                             String nombre, String dni, String ciudad, String direccion,
                                String telefono, String email) {
        if(codigo.trim().length()==5 &&
           apellidoPaterno.trim().length()>0 && apellidoPaterno.trim().length()<=25 &&
           apellidoMaterno.trim().length()>0 && apellidoMaterno.trim().length()<=25 &&
           nombre.trim().length()>0 && nombre.trim().length()<=30 &&
           dni.trim().length() == 8 &&
           ciudad.trim().length()>0 && ciudad.trim().length()<=30 &&
           direccion.trim().length()>0 && direccion.trim().length()<=50 &&
           telefono.trim().length()>0 && telefono.trim().length()<=20 &&
           email.trim().length()>0 && email.trim().length()<=50) {
            if(buscarCliente(codigo) == null) {
                Cliente cliente = new Cliente(codigo, apellidoPaterno, apellidoMaterno, nombre, dni, ciudad,direccion, telefono, email);
                String mensaje =
                     new ClienteDAL().insertarCliente(cliente);
                if(mensaje == null) {
                    showMessageDialog(null,"Cliente registrado",
                            "Insertar Cliente", 1);
                    return 0;
                }
                else {
                    showMessageDialog(null, mensaje, "Error", 0);
                    return 1;
                }
            } else {
                showMessageDialog(null,
                   "Código ya existe: " + codigo,
                   "Buscar Cliente", 0);
                return 2;
            }
        } else {
            showMessageDialog(null, "Datos no validos",
                    "Ingreso de datos", 2);
            return 3;
        }
    }

    public void EliminarCliente(String codigo){
        if(new ClienteDAL().buscarCliente(codigo)!=null){
        if(new CuentaDAL().eLiminarcuentasXCliente(codigo)==null)
            if(new ClienteDAL().eLiminarCliente(codigo)==null)
                showMessageDialog(null, "Cliente Eliminado","Resultado", 1);
        
        }else
            showMessageDialog(null, "Codigo no existe","Error", 0);
    }

    public String buscarCliente(String codigo) {
        if(codigo.trim().length()==5)
            return new ClienteDAL().buscarCliente(codigo);
        else
            return null;
    }
       public ArrayList<Cliente> listarCliente() {
        return new ClienteDAL().listarClientes();
    }

   public void ejecutarReporte() {
    new ClienteDAL().ejecutarReporte();
    }

   public void ejecutarReporteMov(String codigo) {
       if(codigo.trim().length()==8)
         if(new CuentaDAL().buscarCuenta(codigo)!=null)
             new ClienteDAL().ejecutarReporteMov(codigo);
         else
             showMessageDialog(null, "Codigo no existe","Error", 0);
      else
             showMessageDialog(null, "Formato de Codigo Incorrecto","Error", 0);
           
    }

}
