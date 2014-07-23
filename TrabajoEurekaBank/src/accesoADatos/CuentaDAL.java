/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package accesoADatos;

import entidades.*;
import java.sql.*;
import java.util.ArrayList;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author David
 */

public class CuentaDAL {

    private Connection cn=null;
    private PreparedStatement ps= null;
        private Statement st=null;
    private ResultSet rs= null;

    public String insertarCuenta(Cuenta cuenta) {
        String mensaje = null;
        try {
            cn = Conexion.realizarConexion();
            String sql = "insert into cuenta values(?,?,?,?,?,?,?,?,?,?)";
            ps = cn.prepareStatement(sql);
            ps.setString(1, cuenta.getCuenCodigo());
            ps.setString(2, cuenta.getMoneCodigo());
            ps.setString(3, cuenta.getSucuCodigo());
            ps.setString(4, cuenta.getEmplCreaCuenta());
            ps.setString(5, cuenta.getClieCodigo());
            ps.setFloat(6, cuenta.getCuenSaldo());
            ps.setString(7, cuenta.getCuenFechaCreacion().toString());
            ps.setString(8, cuenta.getCuenEstado());
            ps.setInt(9, cuenta.getCuenContMonto());
            ps.setString(10, cuenta.getCuenClave());
            ps.executeUpdate();
        } catch(ClassNotFoundException ex) {
            mensaje = ex.getMessage();
        } catch(SQLException ex) {
            mensaje = ex.getMessage();
        } finally {
            try {
                ps.close();
                cn.close();
            } catch(Exception ex) {
                mensaje = ex.getMessage();
            }
        }
        return mensaje;
    }

     public String eLiminarcuenta(String codigo){
        String mensaje= null;
        try{
            cn=Conexion.realizarConexion();
            String sql= "delete from cuenta where chr_cuencodigo = '"+ codigo + "'";
            ps=cn.prepareStatement(sql);
            ps.executeUpdate();
        }catch(ClassNotFoundException e){
            mensaje=e.getMessage();
             showMessageDialog(null,"Error2");
        }catch(SQLException e){
            mensaje= e.getMessage();
             showMessageDialog(null,"Error3");
        }finally{
            try{
                ps.close();
                cn.close();
            }catch(Exception e){
                mensaje=e.getMessage();
            }

        }
        return mensaje;
    }
     public String eLiminarcuentasXEmpleados(String codigo){
        String mensaje= null;
        try{
            cn=Conexion.realizarConexion();
            String sql= "delete from cuenta where chr_emplcreacuenta = '"+ codigo + "'";
            ps=cn.prepareStatement(sql);
            ps.executeUpdate();
        }catch(ClassNotFoundException e){
            mensaje=e.getMessage();
             showMessageDialog(null,"Error2");
        }catch(SQLException e){
            mensaje= e.getMessage();
             showMessageDialog(null,"Error3");
        }finally{
            try{
                ps.close();
                cn.close();
            }catch(Exception e){
                mensaje=e.getMessage();
            }

        }
        return mensaje;
    }
      public String eLiminarcuentasXSucursal(String codigo){
        String mensaje= null;
        try{
            cn=Conexion.realizarConexion();
            String sql= "delete from cuenta where chr_sucucodigo = '"+ codigo + "'";
            ps=cn.prepareStatement(sql);
            ps.executeUpdate();
        }catch(ClassNotFoundException e){
            mensaje=e.getMessage();
             showMessageDialog(null,"Error2");
        }catch(SQLException e){
            mensaje= e.getMessage();
             showMessageDialog(null,"Error3");
        }finally{
            try{
                ps.close();
                cn.close();
            }catch(Exception e){
                mensaje=e.getMessage();
            }

        }
        return mensaje;
    }

       public String eLiminarcuentasXCliente(String codigo){
        String mensaje= null;
        try{
            cn=Conexion.realizarConexion();
            String sql= "delete from cliente where chr_cliecodigo = '"+ codigo + "'";
            ps=cn.prepareStatement(sql);
            ps.executeUpdate();
        }catch(ClassNotFoundException e){
            mensaje=e.getMessage();
             showMessageDialog(null,"Error2");
        }catch(SQLException e){
            mensaje= e.getMessage();
             showMessageDialog(null,"Error3");
        }finally{
            try{
                ps.close();
                cn.close();
            }catch(Exception e){
                mensaje=e.getMessage();
            }

        }
        return mensaje;
    }



    public String buscarCuenta(String cuencodigo) {
        try {
            cn = Conexion.realizarConexion();
            st = cn.createStatement();
            String sql = "select chr_cuencodigo from cuenta where chr_cuencodigo = '" + cuencodigo + "'" ;
            rs = st.executeQuery(sql);
            while(rs.next()) {
                return rs.getString(1);
            }
        } catch(ClassNotFoundException ex) {
            showMessageDialog(null, ex.getMessage(), "Error", 0);
        } catch(SQLException ex) {
            showMessageDialog(null, ex.getMessage(), "Error", 0);
        } finally {
            try {
                st.close();
                rs.close();
                cn.close();
            } catch(Exception ex) {
                showMessageDialog(null, ex.getMessage(), "Error", 0);
            }
        }
        return null;
    }



    public ArrayList<Cuenta> listarCuenta() {
        ArrayList<Cuenta> listaCuentas = new ArrayList<Cuenta>();
        try {
            cn = Conexion.realizarConexion();
            st = cn.createStatement();
            String sql = "select * from cuenta";
            rs = st.executeQuery(sql);
            while(rs.next()) {
                listaCuentas.add(new Cuenta(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),
                        Float.valueOf(rs.getString(6)),rs.getString(7),rs.getString(8),Integer.parseInt(rs.getString(9)),rs.getString(10)));
            }
        } catch(ClassNotFoundException ex) {
            showMessageDialog(null,ex.getMessage(),"Error",0);
        } catch(SQLException ex) {
            showMessageDialog(null,ex.getMessage(),"Error",0);
        } finally {
            try {
                st.close();
                rs.close();
                cn.close();
            } catch(Exception ex) {
                showMessageDialog(null,ex.getMessage(),"Error",0);
            }
        }
        return listaCuentas;
    }


     public ArrayList<Cuenta> listarCuentaxEmpleado(int temp ,String codigoE) {
        ArrayList<Cuenta> listaCuentas = new ArrayList<Cuenta>();
        try {
            String sql=null;
            cn = Conexion.realizarConexion();
            st = cn.createStatement();
            if(temp==1){
               sql = "select * from cuenta where chr_emplcreacuenta = '" + codigoE + "'";
            } else{
              sql = "select * from cuenta where chr_cliecodigo = '" + codigoE + "'";
            }
            rs = st.executeQuery(sql);
            while(rs.next()) {
                listaCuentas.add(new Cuenta(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString("chr_cliecodigo"),
                        Float.valueOf(rs.getString(6)),rs.getString(7),rs.getString(8),Integer.parseInt(rs.getString(9)),rs.getString(10)));
            }
        } catch(ClassNotFoundException ex) {
            showMessageDialog(null,ex.getMessage(),"Error",0);
        } catch(SQLException ex) {
            showMessageDialog(null,ex.getMessage(),"Error",0);
        } finally {
            try {
                st.close();
                rs.close();
                cn.close();
            } catch(Exception ex) {
                showMessageDialog(null,ex.getMessage(),"Error",0);
            }
        }
        return listaCuentas;
    }
}
