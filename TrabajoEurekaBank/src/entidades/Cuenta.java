package entidades;



public class Cuenta {

    private String cuenCodigo;
    private String moneCodigo;
    private String sucuCodigo;
    private String emplCreaCuenta;
    private String clieCodigo;
    private float cuenSaldo;
    private Fecha cuenFechaCreacion;
    private String cuenEstado;
    private int cuenContMonto;
    private String cuenClave;
    private String cuenFechaCreacion2;


        public Cuenta(){
        cuenCodigo = "";
        moneCodigo = "";
        sucuCodigo = "";
        emplCreaCuenta = "";
        clieCodigo = "";
        cuenFechaCreacion=new Fecha(0,0,0);
        cuenFechaCreacion2 = "";
        cuenEstado = "";
        cuenContMonto = 0;
        cuenClave = "";
        }

        public Cuenta(String cuenCodigo, String moneCodigo, String sucuCodigo, String emplCreaCuenta, String clieCodigo, float cuenSaldo, String cuenFechaCreacion2, String cuenEstado, int cuenContMonto, String cuenClave) {
        this.cuenCodigo = cuenCodigo;
        this.moneCodigo = moneCodigo;
        this.sucuCodigo = sucuCodigo;
        this.emplCreaCuenta = emplCreaCuenta;
        this.clieCodigo = clieCodigo;
        this.cuenSaldo = cuenSaldo;
        this.cuenFechaCreacion2 = cuenFechaCreacion2;
        this.cuenEstado = cuenEstado;
        this.cuenContMonto = cuenContMonto;
        this.cuenClave = cuenClave;
    }


    public Cuenta(String cuenCodigo, String moneCodigo, String sucuCodigo, String emplCreaCuenta, String clieCodigo, float cuenSaldo, Fecha cuenFechaCreacion, String cuenEstado, int cuenContMonto, String cuenClave) {
        this.cuenCodigo = cuenCodigo;
        this.moneCodigo = moneCodigo;
        this.sucuCodigo = sucuCodigo;
        this.emplCreaCuenta = emplCreaCuenta;
        this.clieCodigo = clieCodigo;
        this.cuenSaldo = cuenSaldo;
        this.cuenFechaCreacion = cuenFechaCreacion;
        this.cuenEstado = cuenEstado;
        this.cuenContMonto = cuenContMonto;
        this.cuenClave = cuenClave;
    }
    public String getClieCodigo () {
        return clieCodigo;
    }

    public void setClieCodigo (String val) {
        this.clieCodigo = val;
    }

    public String getCuenClave () {
        return cuenClave;
    }
    public void setCuenClave (String val) {
        this.cuenClave = val;
    }
    public String getCuenCodigo () {
        return cuenCodigo;
    }
    public void setCuenCodigo (String val) {
        this.cuenCodigo = val;
    }

    public int getCuenContMonto () {
        return cuenContMonto;
    }

    public void setCuenContMonto (int val) {
        this.cuenContMonto = val;
    }
    public String getCuenEstado () {
        return cuenEstado;
    }

    public void setCuenEstado (String val) {
        this.cuenEstado = val;
    }
    public Fecha getCuenFechaCreacion () {
        return cuenFechaCreacion;
    }
    public void setCuenFechaCreacion (Fecha val) {
        this.cuenFechaCreacion = val;
    }
    public float getCuenSaldo () {
        return cuenSaldo;
    }
    public void setCuenSaldo (float val) {
        this.cuenSaldo = val;
    }
    public String getEmplCreaCuenta () {
        return emplCreaCuenta;
    }
    public void setEmplCreaCuenta (String val) {
        this.emplCreaCuenta = val;
    }
    public String getMoneCodigo () {
        return moneCodigo;
    }
    public void setMoneCodigo (String val) {
        this.moneCodigo = val;
    }
    public String getSucuCodigo () {
        return sucuCodigo;
    }
    public void setSucuCodigo (String val) {
        this.sucuCodigo = val;
    }

    public String getCuenFechaCreacion2() {
        return cuenFechaCreacion2;
    }

    public void setCuenFechaCreacion2(String cuenFechaCreacion2) {
        this.cuenFechaCreacion2 = cuenFechaCreacion2;
    }

}

