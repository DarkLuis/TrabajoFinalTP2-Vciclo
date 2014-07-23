/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import entidades.Fecha;
import accesoADatos.*;
import entidades.Cuenta;
import java.util.ArrayList;
import static javax.swing.JOptionPane.showMessageDialog;
/**
 *
 * @author David
 */
public class CuentaBL {
     public int insertarCuenta(String param1,String param2,String param3,String param4,String param5,float param6,Fecha param7,String param8,int param9,String param10 ) {
        if(param1.trim().length()==8 && param2.trim().length()==2 && param3.trim().length()==3 && param4.trim().length()==4  && param5.trim().length()==5 && param8.trim().length()<=15 && param10.trim().length()==6) {
            if(buscarCuenta(param1) == null) {
                Cuenta cuenta = new Cuenta( param1, param2, param3, param4, param5, param6, param7, param8, param9, param10);
                String mensaje = new CuentaDAL().insertarCuenta(cuenta);
                if(mensaje == null) {
                    showMessageDialog(null,"Cuenta registrada","Insertar Cuenta", 1);
                    return 0;
                }
                else {
                    showMessageDialog(null, mensaje, "Error", 0);
                    return 1;
                }
            } else {
                showMessageDialog(null,
                   "Código ya existe: " + param1,"Buscar Cuenta", 0);
                return 2;
            }
        } else {
            showMessageDialog(null, "Datos no validos","Ingreso de datos", 2);
            return 3;
        }
    }

        public void ElimarCuenta(String codigo){
        if(codigo.trim().length()==8){
            if(buscarCuenta(codigo)!=null){// devueve null cuando el codigo no existe;
                String mensaje= new CuentaDAL().eLiminarcuenta(codigo);
                if(mensaje==null){
                    showMessageDialog(null,"Cuenta Eliminada","Resultado",1);
                }
                else{
                    showMessageDialog(null,mensaje,"Error001",0);
                }
            }else{
                    showMessageDialog(null,"Codigo No existe","Error2",0);
            }
        }else{
            showMessageDialog(null,"Formato Incorrecto","Error3",0);
        }

    }
  
    public String buscarCuenta(String param1) {
        if(param1.trim().length()==8)
            return new CuentaDAL().buscarCuenta(param1);
        else
            return null;
    }

    public ArrayList<Cuenta> listarCuenta() {
        return new CuentaDAL().listarCuenta();
    }
    public ArrayList<Cuenta> listarCuentaxCliente(int temp,String codigo) {

        if(new EmpleadoDAL().buscarEmpleado(codigo)!=null || new ClienteDAL().buscarCliente(codigo)!=null){
            return new CuentaDAL().listarCuentaxEmpleado(temp,codigo);
        }else{
            showMessageDialog(null,"Codigo No existe","Error2",0);
            return null;
        }
    }

}
