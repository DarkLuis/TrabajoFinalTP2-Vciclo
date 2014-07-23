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
 * @author jefferson
 */
public class ParametroBL {
     public int insertarParametro(String codigo, String descripcion, String valor,String estado) {
         if(codigo.trim().length()==3){
        if(descripcion.trim().length()>0 && descripcion.trim().length()<=50
                && valor.trim().length()>0 && valor.trim().length()<=70
                && estado.trim().length()>0 && estado.trim().length()<=15) {
            if(buscarParametro(codigo) == null) {
                Parametro parametro = new Parametro(codigo, descripcion, valor, estado);
                String mensaje = new ParametroDAL().insertarParametro(parametro);
                if(mensaje == null) {
                    showMessageDialog(null,"Registro insertado","Aviso",1);
                    return 0;
                } else {
                    showMessageDialog(null,mensaje,"Problema",0);
                    return 1;
                }
            }else {
                showMessageDialog(null,"Código de Parámetro ya existe","Aviso",2);
                return 2;
            }
        }else {
            showMessageDialog(null,"Datos no válidos","Aviso",0);
            return 3;
        }
         }else{
             showMessageDialog(null,"El código debe tener tres caracteres","Aviso",0);
            return 4;
         }
    }

    public String buscarParametro(String codigo) {
        if(codigo.trim().length()==3)
            return new ParametroDAL().buscarParametro(codigo);
        else
            return null;
    }

    public ArrayList<Parametro> listarParametro() {
        return new ParametroDAL().listarParametro();
    }

    public void ejecutarReporte(String codigo) {
        if(codigo.trim().length()==3)
            new ParametroDAL().ejecutarReporte(codigo);
        else
            showMessageDialog(null,"Código no válido",
                    "Reporte de Parametro", 0);
    }
}
