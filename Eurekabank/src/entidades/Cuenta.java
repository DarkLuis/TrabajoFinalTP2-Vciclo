/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;
import java.util.*;

/**
 *
 * @author jefferson
 */
public class Cuenta implements Comparable<Cuenta>{
    private String codigo;
    private String codigoM;
    private String codigoS;
    private String codigoE;
    private String codigoC;
    private double saldo;
    private GregorianCalendar fecha;
    private String estado;
    private int costMovimiento;
    private String clave;

    public Cuenta(String codigo, String codigoM, String codigoS, String codigoE, String codigoC, double saldo, GregorianCalendar fecha, String estado, int costMovimiento, String clave) {
        this.codigo = codigo;
        this.codigoM = codigoM;
        this.codigoS = codigoS;
        this.codigoE = codigoE;
        this.codigoC = codigoC;
        this.saldo = saldo;
        this.fecha = fecha;
        this.estado = estado;
        this.costMovimiento = costMovimiento;
        this.clave = clave;
    }
    
    public Cuenta(){
        this("NC","NCM","NCS","NC","NCC",0.0,null,"NE",0,"NC");
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoM() {
        return codigoM;
    }

    public void setCodigoM(String codigoM) {
        this.codigoM = codigoM;
    }

    public String getCodigoS() {
        return codigoS;
    }

    public void setCodigoS(String codigoS) {
        this.codigoS = codigoS;
    }

    public String getCodigoE() {
        return codigoE;
    }

    public void setCodigoE(String codigoE) {
        this.codigoE = codigoE;
    }

    public String getCodigoC() {
        return codigoC;
    }

    public void setCodigoC(String codigoC) {
        this.codigoC = codigoC;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCostMovimiento() {
        return costMovimiento;
    }

    public void setCostMovimiento(int costMovimiento) {
        this.costMovimiento = costMovimiento;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int compareTo(Cuenta cuenta) {
        return this.getCodigo().compareTo(cuenta.getCodigo());
    }

}
