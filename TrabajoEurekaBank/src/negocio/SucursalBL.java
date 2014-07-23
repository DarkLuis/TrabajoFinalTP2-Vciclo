/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import entidades.*;
import accesoADatos.*;
import java.util.*;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Sistemas
 */
public class SucursalBL {
    public int buscarSucursal(String codigo) {
        if(codigo.trim().length() == 3) {
            if (new SucursalDAL().buscarSucursal(codigo) == null)
                return -1;  // Codigo no existe
            else
                return 1;  // Codigo ya existe o
                           // sucedio excepción
        }
        return 0;  // Codigo no valido
    }

    public int insertarSucursal(String codigo, String nombre,
            String ciudad, String direccion, int contadorCuenta) {
        if(codigo.trim().length() == 3 &&
            nombre.trim().length() > 0 &&
            nombre.trim().length() <= 50 &&
            ciudad.trim().length() > 0 &&
            ciudad.trim().length() <= 30 &&
            direccion.trim().length() > 0 &&
            direccion.trim().length() <= 50) {
            Sucursal sucursal = new Sucursal(codigo, nombre, ciudad,
                    direccion, contadorCuenta);
            String mensaje = new SucursalDAL().insertarSucursal(sucursal);
            if( mensaje == null) {
                showMessageDialog(null, "Registro insertado", "Resultado", 1);
                return 1;  // Registro insertado
            }
            else {
                showMessageDialog(null, mensaje, "Error", 1);
                return 0;  // Ocurrió una excepción
            }
        }
        showMessageDialog(null, "Datos no validos", "Error", 2);
        return -1;  // Datos no válidos
    }

    public ArrayList<Sucursal> listarSucursal() {
        return new SucursalDAL().listarSucursal();
    }

    public void ModificarSucursal(Sucursal sucursal){
        if(new SucursalDAL().buscarSucursal(sucursal.getCodigo())!=null){
            if(new SucursalDAL().ModificarSucursal(sucursal)==null)
                 showMessageDialog(null,"Datos Modificados","Modificar Datos", 1);
            else
                showMessageDialog(null,"erroraka","Modificar Datos", 2);
        }else
             showMessageDialog(null,"codigo Incorrecto","Modificar", 2);
    }



    //copiado de la carpata Reportes/Archivo2//
    public void ejecutarReporte() {
      
            new SucursalDAL().ejecutarReporte();
    }

}
