/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package accesoADatos;
import entidades.Movimiento;
import entidades.*;
import java.util.ArrayList;
import java.sql.*;
import static javax.swing.JOptionPane.showMessageDialog;
/**
 *
 * @author David
 */
public class MovimientoDAL {

    private Connection cn=null;
    private PreparedStatement ps= null;
        private Statement st=null;
    private ResultSet rs= null;

    public String insertarMovimiento(Movimiento movimiento) {
        String mensaje = null;
        try {
            cn = Conexion.realizarConexion();
            String sql = "insert into movimiento values(?,?,?,?,?,?,?)";
            ps = cn.prepareStatement(sql);
            ps.setString(1, movimiento.getCuenCodigo());
            ps.setInt(2, movimiento.getMoviNumero());
            ps.setString(3, movimiento.getMoviFecha().toString());
            ps.setString(4, movimiento.getEmplCodigo());
            ps.setString(5, movimiento.getTipoCodigo());
            ps.setFloat(6, movimiento.getMoviimporte());
            ps.setString(7, movimiento.getCuenReferencia());
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


     public int BuscarNumMovim( String codigo,int numero) {
        try {
            cn = Conexion.realizarConexion();
            st = cn.createStatement();
            String sql = "select int_movinumero from movimiento where int_movinumero = " + numero +" and chr_cuencodigo = + '"+ codigo +"'";
            rs = st.executeQuery(sql);
            while(rs.next()) 
                return rs.getInt(2);
        } catch(ClassNotFoundException ex) {
            showMessageDialog(null, ex.getMessage(), "Errora", 0);
        } catch(SQLException ex) {
            showMessageDialog(null, ex.getMessage(), "Errorb", 0);
        } finally {
            try {
                st.close();
                rs.close();
                cn.close();
            } catch(Exception ex) {
                showMessageDialog(null, ex.getMessage(), "Errorc", 0);
            }
        }
        return 0;
    }

    public String buscarMovimiento(String cuencodigo) {
        try {
            cn = Conexion.realizarConexion();
            st = cn.createStatement();
            String sql = "select chr_cuencodigo from movimiento where chr_cuencodigo = '" + cuencodigo +"'";
            rs = st.executeQuery(sql);
            while(rs.next()) 
                return rs.getString(1);
            
        } catch(ClassNotFoundException ex) {
            showMessageDialog(null, ex.getMessage(), "Errord", 0);
        } catch(SQLException ex) {
            showMessageDialog(null, ex.getMessage(), "Errore", 0);
        } finally {
            try {
                st.close();
                rs.close();
                cn.close();
            } catch(Exception ex) {
                showMessageDialog(null, ex.getMessage(), "Errorf", 0);
            }
        }
        return null;
    }

    public ArrayList<Movimiento> listarMovimiento() {
        ArrayList<Movimiento> listaMovimientos = new ArrayList<Movimiento>();
        try {
            cn = Conexion.realizarConexion();
            st = cn.createStatement();
            String sql = "select * from movimiento";
            rs = st.executeQuery(sql);
            while(rs.next()) {
                listaMovimientos.add(new Movimiento(rs.getString(1),Integer.parseInt(rs.getString(2)),rs.getString(3),rs.getString(4),rs.getString(5),
                        Float.valueOf(rs.getString(6)),rs.getString(7)));
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
        return listaMovimientos;
    }

  public ArrayList<Movimiento> listarMovimientoxEmpleado(String codigo) {
        ArrayList<Movimiento> listaMovimientos = new ArrayList<Movimiento>();
        try {
            cn = Conexion.realizarConexion();
            st = cn.createStatement();
            String sql = "select * from movimiento where chr_emplcodigo= '"+ codigo + "'";
            rs = st.executeQuery(sql);
            while(rs.next()) {
                listaMovimientos.add(new Movimiento(rs.getString(1),Integer.parseInt(rs.getString(2)),rs.getString(3),rs.getString(4),rs.getString(5),
                        Float.valueOf(rs.getString(6)),rs.getString(7)));
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
        return listaMovimientos;
    }

   public String EliminarMovimientosxCuenta(String codigo){
        String mensaje= null;
        try{
            cn=Conexion.realizarConexion();
            String sql= "delete from movimiento where chr_cuencodigo = '"+ codigo + "'";
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
    public String EliminarMovimientosxEmpleado(String codigo){
        String mensaje= null;
        try{
            cn=Conexion.realizarConexion();
            String sql= "delete from movimiento where chr_emplcodigo = '"+ codigo + "'";
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
    
    
    public String EliminarMovimiento(String codigo,int num){
        String mensaje= null;
        try{
            cn=Conexion.realizarConexion();
            String sql= "delete from movimiento where chr_cuencodigo = '"+ codigo +"'"+ " and int_movinumero = "+ num ;
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




}
