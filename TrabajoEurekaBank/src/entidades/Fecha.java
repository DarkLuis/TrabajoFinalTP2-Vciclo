package entidades;



// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.1F48EF36-5EFB-334A-F3B8-8207691B5C19]
// </editor-fold> 
public class Fecha {

     private int dia;
    private int mes;
    private int año;

    public Fecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }
    public void setAño(int año) {
        this.año = año;
    }

    public boolean  VerificarFecha(){
        int diasxMes[]={0,31,28,31,30,31,30,31,31,30,31,30,31};
        if(año%4==0&&año%100!=0||año%400==0)
            diasxMes[2]=29;
        if(mes>=1 && mes<=12){
            if(dia>=1 && dia<=diasxMes[mes] && año>=1900)
                return true;
            else
                return false;
        }
        else
            return false;
    }

    @Override
    public String toString() {
        return  getAño()+ ""+(getMes()<10?"0"+getMes():getMes())+""+(getDia()<10?"0"+getDia():getDia()) ;
    }

}

