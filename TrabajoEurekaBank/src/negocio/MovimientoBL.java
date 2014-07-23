
package negocio;

import accesoADatos.*;
import entidades.*;
import java.util.ArrayList;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author David
 */
public class MovimientoBL {
     public void insertarMovimiento(String param1,int param2,Fecha param3,String param4,String param5,float param6,String param7 ) {
        if(param1.trim().length()==8 && param4.trim().length()==4 && param5.trim().length()==3) {
            if(buscarMovimiento(param1)!=null){//el codigo de cuenta tiene q existir para poder crear un movimiento
                if(VerifNumMovimiento(param1,param2)==0){//el numero de mov tiene q ser nuevo
                     Movimiento movimiento = new Movimiento( param1, param2, param3, param4, param5, param6, param7);
                     String mensaje = new MovimientoDAL().insertarMovimiento(movimiento);
                     if(mensaje == null)
                        showMessageDialog(null,"Movimiento registrada","Insertar Movimiento", 1);
                    else
                        showMessageDialog(null, mensaje, "Error22", 0);
                }else
                    showMessageDialog(null,"Numero de Movimiento ya Existe " + param1,"Buscar Movimiento", 0);

            }else
                 showMessageDialog(null,"Codigo de cuenta no Existe " ,"Buscar Movimiento", 0);
        } else 
            showMessageDialog(null, "Datos no validos","Ingreso de datos", 2);
        
    }

     public int VerifNumMovimiento(String param1,int param2){
         return new MovimientoDAL().BuscarNumMovim(param1,param2);
     }

    public String buscarMovimiento(String param1) {
        if(param1.trim().length()==8)
            return new MovimientoDAL().buscarMovimiento(param1);
        else
            return null;
    }

    public ArrayList<Movimiento> listarMovimiento() {
        return new MovimientoDAL().listarMovimiento();
    }
     public ArrayList<Movimiento> listarMovimientoxEmpleado(String codigo) {
        return new MovimientoDAL().listarMovimientoxEmpleado(codigo);
    }
     public void EliminarMovimientoxCuenta(String codigoCuenta){

         if(buscarMovimiento(codigoCuenta.trim())==null){//la cuenta tiene q existir
             String recibe=new MovimientoDAL().EliminarMovimientosxCuenta(codigoCuenta.trim());
             if (recibe==null)
                  showMessageDialog(null,"Se eliminaron todos sus Movimientos Realizados por esta cuenta","Tabla Movimientos", 1);
         } else
             showMessageDialog(null,"La cuenta No habia realializado Movimientos " ,"Tabla Movimiento", 0);
     }

      public void EliminarMovimiento(String codigo,int num){
          if(codigo.trim().length()==8)
            if (new MovimientoDAL().buscarMovimiento(codigo)!=null){
                if(new MovimientoDAL().BuscarNumMovim(codigo,num)!=0){
                    String recibe=new MovimientoDAL().EliminarMovimiento(codigo,num);
                     if (recibe==null)
                          showMessageDialog(null,"Movimiento Eliminado","Tabla Movimientos", 1);
                     else
                         showMessageDialog(null,recibe ,"Error", 0);
                }else
                    showMessageDialog(null, "Numero Movimiento no Existe","Error", 0);
            }else
               showMessageDialog(null, "Codigo no Existe","Error", 0);
          else
              showMessageDialog(null, "Formato de Codigo ","Error", 0);
    }
}
