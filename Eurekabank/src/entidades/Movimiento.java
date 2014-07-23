/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Sara Rojas
 */
public class Movimiento implements Comparable <Movimiento>{
    private String cuencodigo;
    private int numero;
    private GregorianCalendar fecha;
    private String emplcodigo;
    private String tipocodigo;
    private double importe;
    private String cuenreferencia;
    
    public Movimiento(){
        this("NC", 0, null, "NE", "TC", 0.0, "CR" );
    }

    public Movimiento(String cuencodigo, int numero, GregorianCalendar fecha, String emplcodigo, String tipocodigo, double importe, String cuenreferencia) {
        this.cuencodigo = cuencodigo;
        this.numero = numero;
        this.fecha = fecha;
        this.emplcodigo = emplcodigo;
        this.tipocodigo = tipocodigo;
        this.importe = importe;
        this.cuenreferencia = cuenreferencia;
        
        
    }

    public String getCuencodigo() {
        return cuencodigo;
    }

    public void setCuencodigo(String cuencodigo) {
        this.cuencodigo = cuencodigo;
    }

    public String getCuenreferencia() {
        return cuenreferencia;
    }

    public void setCuenreferencia(String cuenreferencia) {
        this.cuenreferencia = cuenreferencia;
    }

    public String getEmplcodigo() {
        return emplcodigo;
    }

    public void setEmplcodigo(String emplcodigo) {
        this.emplcodigo = emplcodigo;
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipocodigo() {
        return tipocodigo;
    }

    public void setTipocodigo(String tipocodigo) {
        this.tipocodigo = tipocodigo;
    }

    public String fecha(){
        GregorianCalendar fechaA=getFecha();
        int dia,mes,año;
        String fechanueva="";
                dia = fechaA.get(Calendar.DAY_OF_MONTH);
                mes = fechaA.get(Calendar.MONTH);
                año = fechaA.get(Calendar.YEAR);
                fechanueva+=año+"-"+(mes<=9?"0"+mes:mes)+"-";
                fechanueva+=(dia<=9?"0"+dia:dia);
        return fechanueva;
    }

    public int compareTo(Movimiento movimiento) {
        return this.getCuencodigo().compareTo(movimiento.getCuencodigo());
    }
    
}
