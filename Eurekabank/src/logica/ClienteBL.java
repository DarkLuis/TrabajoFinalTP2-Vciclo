/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;
import entidades.Cliente;
import datos.ClienteDAL;
import java.util.*;
import static javax.swing.JOptionPane.showMessageDialog;
/**
 *
 * @author SNS
 */
public class ClienteBL {
    public int insertarCliente(String codigo, String paterno, String materno, String nombre, String dni,
            String ciudad, String direccion, String telefono, String email) {
        if(codigo.trim().length()==5){
        if( paterno.trim().length()>0 && paterno.trim().length()<=25
                && materno.trim().length()>0 && materno.trim().length()<=25 &&
                nombre.trim().length()>0 && nombre.trim().length()<=30 &&
                dni.trim().length()>0 && dni.trim().length()<=8 &&
                ciudad.trim().length()>0 && ciudad.trim().length()<=30 &&
                direccion.trim().length()>0 && direccion.trim().length()<=50 &&
                telefono.trim().length()>0 && telefono.trim().length()<=20 &&
                email.trim().length()>0 && email.trim().length()<=50) {
            if(buscarCliente(codigo) == null) {
                Cliente cliente = new Cliente(codigo,paterno,materno,nombre,dni,ciudad,direccion,telefono,email);
                String mensaje = new ClienteDAL().insertarCliente(cliente);
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
            showMessageDialog(null,"El código de empleado tiene cinco caracteres","Aviso",0);
            return 4;
        }
    }

    public String buscarCliente(String codigo) {
        if(codigo.trim().length()==5)
            return new ClienteDAL().buscarCliente(codigo);
        else
            return null;
    }

    public ArrayList<Cliente> listarCliente() {
        return new ClienteDAL().listarCliente();
    }

    public void ejecutarReporte(String codigo) {
        if(codigo.trim().length()==5)
            new ClienteDAL().ejecutarReporte(codigo);
        else
            showMessageDialog(null,"Código no válido",
                    "Reporte de Cliente", 0);
    }

}
