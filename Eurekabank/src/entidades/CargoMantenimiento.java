/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Sara Rojas
 */
public class CargoMantenimiento implements Comparable <CargoMantenimiento> {
    private String monecodigo;
    private double montoMaximo;
    private double importe;
    
    public CargoMantenimiento(){
        this("MC", 0.0, 0.0);
    }

    public CargoMantenimiento(String monecodigo, double montoMaximo, double importe) {
        this.monecodigo = monecodigo;
        this.montoMaximo = montoMaximo;
        this.importe = importe;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getMonecodigo() {
        return monecodigo;
    }

    public void setMonecodigo(String monecodigo) {
        this.monecodigo = monecodigo;
    }

    public double getMontoMaximo() {
        return montoMaximo;
    }

    public void setMontoMaximo(double montoMaximo) {
        this.montoMaximo = montoMaximo;
    }

    public int compareTo(CargoMantenimiento cargoMantenimiento) {
        return this.getMonecodigo().compareTo(cargoMantenimiento.getMonecodigo());
    }
}
