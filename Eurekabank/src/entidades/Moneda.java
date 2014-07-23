/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

/**
 *
 * @author Sistemas
 */
public class Moneda implements Comparable<Moneda> {
    private String codigo;
    private String descripcion;

    public int compareTo(Moneda moneda) {
        return this.getCodigo().compareTo(
                moneda.getCodigo());
    }

    public Moneda() {
        this("00", "ND");
    }

    public Moneda(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}