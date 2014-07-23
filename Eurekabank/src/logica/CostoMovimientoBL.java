/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;
import java.util.ArrayList;
import entidades.CostoMovimiento;
import datos.*;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Sara Rojas
 */
public class CostoMovimientoBL {
    public ArrayList<CostoMovimiento> listarCostoMovimiento() {
        return new CostoMovimientoDAL().listarCostoMovimiento();
    }
    
    
    public int insertarCostoMovimiento(String monecodigo, double costimporte) {
        if (monecodigo.trim().length() == 2) {
            if (buscarMoneda(monecodigo) != null) {
                CostoMovimiento costoMovimiento =
                        new CostoMovimiento(monecodigo, costimporte);
                String mensaje =
                        new CostoMovimientoDAL().insertarCostoMovimiento(costoMovimiento);
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
                        "Código de moneda no existe, ingrese un nuevo código en tabla Moneda", "Error", 0);
                return 2;
            }
        } else {
            showMessageDialog(null,
                        "El código de moneda tiene dos caracteres", "Error", 0);
                return 3;
        }
    }

    public String buscarMoneda(String monecodigo) {
        if (monecodigo.trim().length() == 2) {
            return new MonedaDAL().buscarMoneda(monecodigo);
        } else {
            return null;
        }
    }

    public void ejecutarReporte(String codigo) {
        if(codigo.trim().length()==2)
            new CostoMovimientoDAL().ejecutarReporte(codigo);
        else
            showMessageDialog(null,"Código no válido",
                    "Reporte de Costo Movimiento", 0);
    }
    
}
