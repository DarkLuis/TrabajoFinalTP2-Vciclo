/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author jefferson
 */
public class Parametro implements Comparable<Parametro> {
    private String codigo;
    private String descripcion;
    private String valor;
    private String estado;
    
    public Parametro(String codigo,String descripcion,String valor,String estado) {
        this.codigo=codigo;
        this.descripcion=descripcion;
        this.valor=valor;
        this.estado=estado;
    }
    public Parametro() {
        this("000","ND","NV","NE");
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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
      @Override
    public int compareTo(Parametro parametro) {
        return this.getCodigo().compareTo(parametro.getCodigo());
    }
}
