/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Sara Rojas
 */
public class InteresMensual implements Comparable <InteresMensual> {
    private String codigo;
    private double importe;
    
    public InteresMensual(){
        this("MC", 0.0);
    }

    public InteresMensual(String codigo, double importe) {
        this.codigo = codigo;
        this.importe = importe;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public int compareTo(InteresMensual interes) {
        return this.getCodigo().compareTo(interes.getCodigo());
    }
}
