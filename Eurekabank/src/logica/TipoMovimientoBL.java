/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;
import entidades.*;
import datos.*;
import java.util.*;
import static javax.swing.JOptionPane.showMessageDialog;
/**
 *
 * @author SNS
 */
public class TipoMovimientoBL {
    public int insertarTipoMovimiento(String codigo, String descripcion, String accion, String estado) {
        if(codigo.trim().length()==3 && descripcion.trim().length()>0 && descripcion.trim().length()<=40
                && accion.trim().length()>0 && accion.trim().length()<=10 &&
                estado.trim().length()>0 && estado.trim().length()<=15) {
            if(buscarTipoMovimiento(codigo) == null) {
                TipoMovimiento tipoM = new TipoMovimiento(codigo, descripcion,accion,estado);
                String mensaje = new TipoMovimientoDAL().insertarTipoMovimiento(tipoM);
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
    }

    public String buscarTipoMovimiento(String codigo) {
        if(codigo.trim().length()==3)
            return new TipoMovimientoDAL().buscarTipoMovimiento(codigo);
        else
            return null;
    }

    public ArrayList<TipoMovimiento> listarTipoMovimiento() {
        return new TipoMovimientoDAL().listarTipoMovimiento();
    }

    public void ejecutarReporte(String codigo) {
        if(codigo.trim().length()==3)
            new TipoMovimientoDAL().ejecutarReporte(codigo);
        else
            showMessageDialog(null,"Código no válido",
                    "Reporte de TipoMovimiento", 0);
    }

}
