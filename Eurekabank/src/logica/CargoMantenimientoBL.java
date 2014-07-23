/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;
import datos.MonedaDAL;
import java.util.ArrayList;
import entidades.CargoMantenimiento;
import datos.CargoMantenimientoDAL;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Sara Rojas
 */
public class CargoMantenimientoBL {
    public ArrayList<CargoMantenimiento> listarCargoMantenimiento() {
        return new CargoMantenimientoDAL().listarCargoMantenimiento();
    }

    public int insertarCargoMantenimiento(String monecodigo, double montoMaximo, double importe) {
        if (monecodigo.trim().length() == 2) {
            if (buscarMoneda(monecodigo) != null) {
                CargoMantenimiento cargoMantenimiento =
                        new CargoMantenimiento(monecodigo, montoMaximo, importe);
                String mensaje =
                        new CargoMantenimientoDAL().insertarCargoMantenimiento(cargoMantenimiento);
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
                        "Código de Moneda no existe, ingrese código en tabla Moneda", "Error", 0);
                return 2;
            }
        } else {
            showMessageDialog(null,
                        "Código de Moneda sólo tiene dos caracteres", "Error", 0);
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
            new CargoMantenimientoDAL().ejecutarReporte(codigo);
        else
            showMessageDialog(null,"Código no válido",
                    "Reporte de Cargo Mantenimiento", 0);
    }

}
