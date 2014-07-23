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
public class TipoMovimientoBL {
   
    public int buscarMovimiento(String codigo) {
        if(codigo.trim().length() == 3) {
            if (new TipoMovimientoDAL().
                    buscarTipoMovimiento(codigo) == null)
                return -1;  // Codigo no existe
            else
                return 1;  // Codigo ya existe o
                           // sucedio excepción
        }
        return 0;  // Codigo no valido
    }

    public int insertarTipoMovimieto(String codigo, 
            String descripcion,String accion,String estado ) {
        if(codigo.trim().length() == 3 &&
            descripcion.trim().length()>0 &&
            descripcion.trim().length()<=40 &&
            accion.trim().length()>0 &&
            accion.trim().length()<=10 &&
            estado.trim().length()>0 &&
            estado.trim().length()<=15)
        {
            
            TipoMovimiento movimiento = new TipoMovimiento(codigo,descripcion, accion, estado);
            String mensaje = new TipoMovimientoDAL().insertarTipoMovimiento(movimiento);
            if( mensaje == null) {
                showMessageDialog(null, "Registro insertado","Resultado", 1);
                return 1;  // Registro insertado
            }
            else {
                showMessageDialog(null, mensaje,"Error", 1);
                return 0;  // Ocurrió una excepción
            }
        }
        showMessageDialog(null, "Datos no validos","Error", 1);
        return -1;  // Datos no válidos
    }

    public ArrayList<TipoMovimiento> listarTipoMovimiento() {
        return new TipoMovimientoDAL().listarTipoMovimiento();
    }


    //copiado de la carpata Reportes/Archivo2//
    public void ejecutarReporte(String codigo) {
        if(codigo.trim().length()==3)
            new TipoMovimientoDAL().ejecutarReporte(codigo);
    }



}
