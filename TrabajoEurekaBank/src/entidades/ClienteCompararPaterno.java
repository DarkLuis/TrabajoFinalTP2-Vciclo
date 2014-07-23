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
public class ClienteCompararPaterno implements Comparator<Cliente> {

    public int compare(Cliente c1, Cliente c2) {
        return c1.getApellidoPaterno().compareToIgnoreCase(c2.getApellidoPaterno());
    }
}
