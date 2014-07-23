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
public class Asignado implements Comparable <Asignado> {
    private String asigcodigo;
    private String sucucodigo;
    private String emplcodigo;
    private GregorianCalendar fechaAlta;
    private GregorianCalendar fechaBaja;
    
    public Asignado(){
        this ("AC","SC","EC", null, null);
    }

    public Asignado(String asigcodigo, String sucucodigo, String emplcodigo, GregorianCalendar fechaAlta, GregorianCalendar fechaBaja) {
        this.asigcodigo = asigcodigo;
        this.sucucodigo = sucucodigo;
        this.emplcodigo = emplcodigo;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
    }

    public String getAsigcodigo() {
        return asigcodigo;
    }

    public void setAsigcodigo(String asigcodigo) {
        this.asigcodigo = asigcodigo;
    }

    public String getEmplcodigo() {
        return emplcodigo;
    }

    public void setEmplcodigo(String emplcodigo) {
        this.emplcodigo = emplcodigo;
    }

    public GregorianCalendar getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(GregorianCalendar fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public GregorianCalendar getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(GregorianCalendar fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public String getSucucodigo() {
        return sucucodigo;
    }

    public String fechaAlta(){
        GregorianCalendar fechaA=getFechaAlta();
        int dia,mes,año;
        String fecha="";
                dia = fechaA.get(Calendar.DAY_OF_MONTH);
                mes = fechaA.get(Calendar.MONTH);
                año = fechaA.get(Calendar.YEAR);
                fecha+=año+"-"+(mes<=9?"0"+mes:mes)+"-";
                fecha+=(dia<=9?"0"+dia:dia);
        return fecha;
    }

    public void setSucucodigo(String sucucodigo) {
        this.sucucodigo = sucucodigo;
    }

    public String fechaBaja(){
        GregorianCalendar fechaB=getFechaBaja();
        int dia,mes,año;
        String fecha="";
            if (fechaB!=null){
                dia = fechaB.get(Calendar.DAY_OF_MONTH);
                mes = fechaB.get(Calendar.MONTH);
                año = fechaB.get(Calendar.YEAR);
                fecha+=año+"-"+(mes<=9?"0"+mes:mes)+"-";
                fecha+=(dia<=9?"0"+dia:dia);
            }
            else{
                fecha=null;
            }
        return fecha;
    }

    public int compareTo(Asignado asignado) {
        return this.getAsigcodigo().compareTo(asignado.getAsigcodigo());
    }
}
