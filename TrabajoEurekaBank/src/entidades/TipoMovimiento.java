/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

/**
 *
 * @author Sistemas
 */
public class TipoMovimiento implements Comparable<TipoMovimiento>{
     private String codigo;
     private String descripcion;
     private String accion;
     private String estado;



     public TipoMovimiento(String codigo, String descripcion, String accion, String estado) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.accion = accion;
        this.estado = estado;
    }

     public TipoMovimiento() {
        this("000", "ND", "NA", "NE");
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public int compareTo(TipoMovimiento tipomovimiento) {
        return this.getCodigo().compareTo(tipomovimiento.getCodigo());
    }


}
