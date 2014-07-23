/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

/**
 *
 * @author SNS
 */
public class Sucursal implements Comparable<Sucursal>{
    private String codigo;
    private String nombre;
    private String ciudad;
    private String direccion;
    private int numero;

    public Sucursal(String codigo,String nombre,String ciudad,String direccion,int numero) {
        this.codigo=codigo;
        this.nombre=nombre;
        this.ciudad=ciudad;
        this.direccion=direccion;
        this.numero=numero;
    }
    public Sucursal() {
        this("000","NN","NC","ND",0);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int compareTo(Sucursal sucursal) {
        return this.getCodigo().compareTo(sucursal.getCodigo());
    }
    

}
