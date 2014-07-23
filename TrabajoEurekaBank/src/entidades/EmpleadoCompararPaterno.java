/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

import empleado.*;
import java.util.*;
import entidades.*;

/**
 *
 * @author Sistemas
 */
public class EmpleadoCompararPaterno implements Comparator<Empleado> {

    public int compare(Empleado empleado1, Empleado empleado2) {
        return empleado1.getPaterno().compareToIgnoreCase(empleado2.getPaterno());
    }
}
