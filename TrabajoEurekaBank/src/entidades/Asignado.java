/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

import java.util.*;

/**
 *
 * @author Jose Andre
 */
public class Asignado {
    private String codigoAsignado;
    private String codigoSucursal;
    private String codigoEmpleado;
    private Fecha fechaAlta;
    private Fecha fechaBaja;
    private String fechaAlta2;
    private String fechaBaja2;

    public Asignado(String codigoAsignado, String codigoSucursal, String codigoEmpleado, Fecha fechaAlta, Fecha fechaBaja) {
        this.codigoAsignado = codigoAsignado;
        this.codigoSucursal = codigoSucursal;
        this.codigoEmpleado = codigoEmpleado;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
    }

    public Asignado(String codigoAsignado, String codigoSucursal, String codigoEmpleado, String fechaAlta2, String fechaBaja2) {
        this.codigoAsignado = codigoAsignado;
        this.codigoSucursal = codigoSucursal;
        this.codigoEmpleado = codigoEmpleado;
        this.fechaAlta2 = fechaAlta2;
        this.fechaBaja2 = fechaBaja2;
    }



    public String getFechaAlta2() {
        return fechaAlta2;
    }

    public String getFechaBaja2() {
        return fechaBaja2;
    }

    public String getCodigoAsignado() {
        return codigoAsignado;
    }

    public void setCodigoAsignado(String codigoAsignado) {
        this.codigoAsignado = codigoAsignado;
    }

    public String getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(String codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public Fecha getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Fecha fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Fecha getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Fecha fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public int compareTo(Asignado asignado) {
        return this.getCodigoAsignado().compareTo(asignado.getCodigoAsignado());
    }

}
