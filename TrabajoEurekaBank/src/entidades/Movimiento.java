/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

/**
 *
 * @author David
 */
public class Movimiento {
       private String cuenCodigo;
     private int moviNumero;
     private String emplCodigo;
     private String tipoCodigo;
     private Fecha moviFecha;
     private String moviFecha2;
     private float moviimporte;
     private String cuenReferencia;

    public Movimiento(String cuenCodigo, int moviNumero, Fecha moviFecha, String emplCodigo, String tipoCodigo, float moviimporte, String cuenReferencia) {
        this.cuenCodigo = cuenCodigo;
        this.moviNumero = moviNumero;
        this.emplCodigo = emplCodigo;
        this.tipoCodigo = tipoCodigo;
        this.moviFecha = moviFecha;
        this.moviimporte = moviimporte;
        this.cuenReferencia = cuenReferencia;
    }

    public Movimiento(String cuenCodigo, int moviNumero, String moviFecha2, String emplCodigo, String tipoCodigo, float moviimporte, String cuenReferencia) {
        this.cuenCodigo = cuenCodigo;
        this.moviNumero = moviNumero;
        this.emplCodigo = emplCodigo;
        this.tipoCodigo = tipoCodigo;
        this.moviFecha2 = moviFecha2;
        this.moviimporte = moviimporte;
        this.cuenReferencia = cuenReferencia;
    }

    public String getCuenCodigo() {
        return cuenCodigo;
    }

    public void setCuenCodigo(String cuenCodigo) {
        this.cuenCodigo = cuenCodigo;
    }

    public String getCuenReferencia() {
        return cuenReferencia;
    }

    public void setCuenReferencia(String cuenReferencia) {
        this.cuenReferencia = cuenReferencia;
    }

    public String getEmplCodigo() {
        return emplCodigo;
    }

    public void setEmplCodigo(String emplCodigo) {
        this.emplCodigo = emplCodigo;
    }

    public Fecha getMoviFecha() {
        return moviFecha;
    }

    public void setMoviFecha(Fecha moviFecha) {
        this.moviFecha = moviFecha;
    }

    public String getMoviFecha2() {
        return moviFecha2;
    }

    public void setMoviFecha2(String moviFecha2) {
        this.moviFecha2 = moviFecha2;
    }

    public int getMoviNumero() {
        return moviNumero;
    }

    public void setMoviNumero(int moviNumero) {
        this.moviNumero = moviNumero;
    }

    public float getMoviimporte() {
        return moviimporte;
    }

    public void setMoviimporte(float moviimporte) {
        this.moviimporte = moviimporte;
    }

    public String getTipoCodigo() {
        return tipoCodigo;
    }

    public void setTipoCodigo(String tipoCodigo) {
        this.tipoCodigo = tipoCodigo;
    }

}
