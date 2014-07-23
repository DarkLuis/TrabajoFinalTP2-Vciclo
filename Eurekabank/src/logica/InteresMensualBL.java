/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;
import java.util.ArrayList;
import entidades.InteresMensual;
import datos.*;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Sara Rojas
 */
public class InteresMensualBL {
    public ArrayList<InteresMensual> listarInteresMensual() {
        return new InteresMensualDAL().listarInteresMensual();
    }
    
    public int insertarInteresMensual(String codigo, double importe) {
        if (codigo.trim().length() == 2) {
            if (buscarMoneda(codigo) != null) {
                InteresMensual interesMensual =
                        new InteresMensual(codigo, importe);
                String mensaje =
                        new InteresMensualDAL().insertarInteresMensual(interesMensual);
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
                        "Código de moneda no existe, ingrese nuevo códido en tabla Moneda", "Error", 0);
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

    public void ejecutarReporte(String codigo) {
        if(codigo.trim().length()==2)
            new InteresMensualDAL().ejecutarReporte(codigo);
        else
            showMessageDialog(null,"Código no válido",
                    "Reporte de Interes Mesual", 0);
    }
}
