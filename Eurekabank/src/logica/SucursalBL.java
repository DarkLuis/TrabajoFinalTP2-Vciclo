/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;
import entidades.Sucursal;
import datos.SucursalDAL;
import java.util.*;
import static javax.swing.JOptionPane.showMessageDialog;
/**
 *
 * @author SNS
 */
public class SucursalBL {
    public int insertarSucursal(String codigo, String nombre, String ciudad, String direccion,int numero) {
        if(codigo.trim().length()==3){
        if( nombre.trim().length()>0 && nombre.trim().length()<=50
                && ciudad.trim().length()>0 && ciudad.trim().length()<=30 &&
                direccion.trim().length()>0 && direccion.trim().length()<=50 &&
                numero < 200) {
            if(buscarSucursal(codigo) == null) {
                Sucursal sucu = new Sucursal(codigo, nombre, ciudad, direccion, numero);
                String mensaje = new SucursalDAL().insertarSucursal(sucu);
                if(mensaje == null) {
                    showMessageDialog(null,"Registro insertado","Aviso",1);
                    return 0;
                } else {
                    showMessageDialog(null,mensaje,"Problema",0);
                    return 1;
                }
            }else {
                showMessageDialog(null,"Código de Sucursal ya existe","Aviso",2);
                return 2;
            }
        }else {
            showMessageDialog(null,"Datos no válidos","Aviso",0);
            return 3;
        }
        }else{
            showMessageDialog(null,"El código de sucursal debe tener tres caracteres","Aviso",0);
            return 4;
        }
    }

    public String buscarSucursal(String codigo) {
        if(codigo.trim().length()==2)
            return new SucursalDAL().buscarSucursal(codigo);
        else
            return null;
    }

    public ArrayList<Sucursal> listarSucursal() {
        return new SucursalDAL().listarSucursal();
    }

    public void ejecutarReporte(String codigo) {
        if(codigo.trim().length()==3)
            new SucursalDAL().ejecutarReporte(codigo);
        else
            showMessageDialog(null,"Código no válido",
                    "Reporte de Sucursal", 0);
    }

}
