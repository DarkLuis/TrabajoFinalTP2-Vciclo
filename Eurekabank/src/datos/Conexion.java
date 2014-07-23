/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package datos;
import java.sql.*;
/**
 *
 * @author SNS
 */
public class Conexion {
    public static Connection realizarConexion()
            throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/eurekabank";
        String user = "root";
        String password = "sa";
        return DriverManager.getConnection(url, user, password);
    }

}
