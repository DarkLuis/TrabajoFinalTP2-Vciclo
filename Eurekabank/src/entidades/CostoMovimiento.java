/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Sara Rojas
 */
public class CostoMovimiento implements Comparable <CostoMovimiento> {
    private String monecodigo;
    private double costimporte;

    public CostoMovimiento(){
        this("MC", 0.0);
    }
    public CostoMovimiento(String monecodigo, double costimporte) {
        this.monecodigo = monecodigo;
        this.costimporte = costimporte;
    }

    public double getCostimporte() {
        return costimporte;
    }

    public void setCostimporte(double costimporte) {
        this.costimporte = costimporte;
    }

    public String getMonecodigo() {
        return monecodigo;
    }

    public void setMonecodigo(String monecodigo) {
        this.monecodigo = monecodigo;
    }

    public int compareTo(CostoMovimiento costoMovimiento) {
        return this.getMonecodigo().compareTo(costoMovimiento.getMonecodigo());
    }
}
