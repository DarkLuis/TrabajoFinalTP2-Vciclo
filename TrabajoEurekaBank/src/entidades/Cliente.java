/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

/**
 *
 * @author sistemas
 */
public class Cliente implements Comparable<Cliente> {
    private String codigo;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombre;
    private String dni;
    private String ciudad;
    private String direccion;
    private String telefono;
    private String email;


    public Cliente() {
        codigo="";
        apellidoPaterno="";
        apellidoMaterno="";
        nombre="";
        dni="";
        ciudad="";
        direccion="";
        telefono="";
        email="";
    }
    public Cliente(String codigo, String apellidoPaterno,
                    String apellidoMaterno, String nombre, String dni,
                    String ciudad, String direccion, String telefono,
                    String email) {
        this.codigo = codigo;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.nombre = nombre;
        this.dni = dni;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int compareTo(Cliente o) {
          return this.getCodigo().compareTo(o.getCodigo());
    }


}
