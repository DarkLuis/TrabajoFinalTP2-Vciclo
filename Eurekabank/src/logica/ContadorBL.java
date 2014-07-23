/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;
import entidades.*;
import datos.*;
import java.util.*;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author jefferson
 */
public class ContadorBL {
    public int insertarContador(String tabla,int item,int longitud){
        if(item !=0 && longitud !=0 && tabla.trim().length()!=0){
        if(tabla.trim().length()>0 && tabla.trim().length()<=30){
            if(buscarContador(tabla) == null) {
                Contador contador = new Contador(tabla,item,longitud);
                String mensaje = new ContadorDAL().insertarContador(contador);
                if(mensaje == null) {
                    showMessageDialog(null,"Registro insertado","Aviso",1);
                    return 0;
                } else {
                    showMessageDialog(null,mensaje,"Problema",0);
                    return 1;
                }
            }else {
                showMessageDialog(null,"Código ya existe","Aviso",2);
                return 2;
            }
        }else {
            showMessageDialog(null,"Tabla incorrecta","Aviso",0);
            return 3;
        }
        }else{
            showMessageDialog(null,"Todo los campos son obligatorios","Aviso",0);
            return 4;
        }
    }

    public String buscarContador(String tabla) {
        if(tabla.trim().length()>0 && tabla.trim().length()<=30)
            return new ContadorDAL().buscarContador(tabla);
        else
            return null;
    }

    public ArrayList<Contador> listarContador() {
        return new ContadorDAL().listarContador();
    }

    public void ejecutarReporte(String tabla) {
        if(tabla.trim().length()>0 && tabla.length()<=30)
            new ContadorDAL().ejecutarReporte(tabla);
        else
            showMessageDialog(null,"Código no válido",
                    "Reporte de Contador", 0);
    }
}
