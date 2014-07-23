/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import entidades.*;
import datos.*;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Sistemas
 */
public class MonedaBL {

    public int insertarMoneda(String codigo, String descripcion) {
        if (codigo.trim().length() == 2
                && descripcion.trim().length() > 0
                && descripcion.trim().length() <= 20) {
            if (buscarMoneda(codigo) == null) {
                Moneda moneda =
                        new Moneda(codigo, descripcion);
                String mensaje =
                        new MonedaDAL().insertarMoneda(moneda);
                if (mensaje == null) {
                    showMessageDialog(null,
                            "Registro insertado", "Resultado", 1);
                    return 0;
                } else {
                    showMessageDialog(null, mensaje,
                            "Excepción", 0);
                    return 1;
                }
            } else {
                showMessageDialog(null,
                        "Código ya existe", "Error", 0);
                return 2;
            }
        } else {
            showMessageDialog(null,
                        "Datos no válidos", "Error", 0);
                return 3;
        }
    }

    public String buscarMoneda(String codigo) {
        if (codigo.trim().length() == 2) {
            return new MonedaDAL().buscarMoneda(codigo);
        } else {
            return null;
        }
    }

    public ArrayList<Moneda> listarMoneda() {
        return new MonedaDAL().listarMoneda();
    }

    public void ejecutarReporte(String codigo) {
        if(codigo.trim().length()==2)
            new MonedaDAL().ejecutarReporte(codigo);
    }
}
