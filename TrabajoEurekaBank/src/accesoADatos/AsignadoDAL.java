/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package accesoADatos;

import java.text.SimpleDateFormat;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.JasperReport;
import entidades.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date.*;
import java.util.Map;
import java.util.HashMap;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Jose Andre
 */
public class AsignadoDAL {
    private Connection cn = null;
    private Statement st = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public String buscarAsignado(String codigoAsignado) {
        try {
            cn = Conexion.realizarConexion();
            st = cn.createStatement();
            String sql = "select chr_asigcodigo from asignado where chr_sucucodigo = '" + codigoAsignado + "'";
            rs = st.executeQuery(sql);
            while(rs.next()) {
                return rs.getString("chr_asigcodigo");
            }
        } catch(ClassNotFoundException ex) {
            showMessageDialog(null, ex.getMessage(), "Error", 0);
        } catch(SQLException ex) {
            showMessageDialog(null, ex.getMessage(), "Error", 0);
        } finally {
            try {
                rs.close();
                st.close();
                cn.close();
            } catch(SQLException ex) {
                showMessageDialog(null, ex.getMessage(), "Error", 0);
            }
        }
        return null;
    }

    public String insertarAsignado(Asignado asignado) {
        String mensaje = null;
        //Date fecha = null;
        //SimpleDateFormat dt = new SimpleDateFormat("yyyy/mm/dd");
        try {
            cn = Conexion.realizarConexion();
            String sql = "insert into asignado  values(?,?,?,?,?)";
            ps = cn.prepareStatement(sql);
            ps.setString(1, asignado.getCodigoAsignado());
            ps.setString(2, asignado.getCodigoSucursal());
            ps.setString(3, asignado.getCodigoEmpleado());
            ps.setString(4,asignado.getFechaAlta().toString());
            ps.setString(5,asignado.getFechaBaja().toString());
            ps.executeUpdate();
        } catch(ClassNotFoundException ex) {
            mensaje = ex.getMessage();
        } catch(SQLException ex) {
            mensaje = ex.getMessage();
        } finally {
            try {
                ps.close();
                cn.close();
            }catch(SQLException ex) {
                mensaje = ex.getMessage();
            }
        }
        return mensaje;
    }

     public String EliminarAsignacioxEmpleado(String codigo){
        String mensaje= null;
        try{
            cn=Conexion.realizarConexion();
            String sql= "delete from asignado where chr_emplcodigo = '"+ codigo+"'";
            ps=cn.prepareStatement(sql);
            ps.executeUpdate();
        }catch(ClassNotFoundException e){
            mensaje=e.getMessage();
             showMessageDialog(null,"Error");
        }catch(SQLException e){
            mensaje= e.getMessage();
             showMessageDialog(null,"Error");
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

     public String EliminarAsignacioxSucursal(String codigo){
        String mensaje= null;
        try{
            cn=Conexion.realizarConexion();
            String sql= "delete from sucursal where chr_sucucodigo = '"+ codigo+"'";
            ps=cn.prepareStatement(sql);
            ps.executeUpdate();
        }catch(ClassNotFoundException e){
            mensaje=e.getMessage();
             showMessageDialog(null,"Error");
        }catch(SQLException e){
            mensaje= e.getMessage();
             showMessageDialog(null,"Error");
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

     public ArrayList<Asignado> listarAsignado() {
        ArrayList<Asignado> asignado = new ArrayList<Asignado>();
        try {
            cn = Conexion.realizarConexion();
            st = cn.createStatement();
            String sql = "select * from asignado";
            rs = st.executeQuery(sql);
            while(rs.next()) {
                asignado.add(new Asignado(rs.getString(1),
                        rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5)));
            }
        } catch(ClassNotFoundException ex) {
            showMessageDialog(null, ex.getMessage(), "Error", 0);
        } catch(SQLException ex) {
            showMessageDialog(null, ex.getMessage(), "Error", 0);
        } finally {
            try {
                rs.close();
                st.close();
                cn.close();
            } catch(SQLException ex) {
                showMessageDialog(null, ex.getMessage(), "Error", 0);
            }
        }
        return asignado;
    }

     public void ejecutarReporte(String codigoAsignado) {
        try {
            cn = Conexion.realizarConexion();
            String master = System.getProperty("user.dir") + "\\src\\reportes\\rptAsignado.jasper";
            System.out.println("master: " + master);
            if(master == null) {
                showMessageDialog(null, "No se encontro el archivo", "Error", 0);
                System.exit(2);
            }

            JasperReport masterReport = null;
            try {
                masterReport = (JasperReport) JRLoader.loadObject(master);
            } catch(JRException ex) {
                showMessageDialog(null, ex.getMessage(), "Error", 0);
                System.exit(3);
            }

            Map parametro = new HashMap();
            parametro.put("codigo", codigoAsignado);

            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, parametro, cn);

            JasperViewer jviewer = new JasperViewer(jasperPrint, false);
            jviewer.setTitle("Listado");
            jviewer.setVisible(true);
        } catch(ClassNotFoundException ex) {
            showMessageDialog(null, ex.getMessage(), "Error", 0);
        } catch(SQLException ex) {
            showMessageDialog(null, ex.getMessage(), "Error", 0);
        } catch(Exception ex) {
              showMessageDialog(null, ex.getMessage(), "Error", 0);
        } finally {
            try {
                cn.close();
            } catch(Exception ex) {
                showMessageDialog(null, ex.getMessage(), "Error", 0);
            }
        }
    }

}
