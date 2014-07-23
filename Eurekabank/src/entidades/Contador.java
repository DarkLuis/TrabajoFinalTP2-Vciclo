/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author jefferson
 */
public class Contador implements Comparable<Contador> {
    private String tabla;
    private int item;
    private int longitud;

    public Contador(String tabla, int item, int longitud) {
        this.tabla = tabla;
        this.item = item;
        this.longitud = longitud;
    }
    
    public Contador(){
        this("T",0,0);
    }

    public String getTabla(){
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }
    
    public int compareTo(Contador contador) {
       return  this.getTabla().compareTo(contador.getTabla());
    }
}
