/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package accesoADatos;
import java.sql.*;
import java.util.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import entidades.*;
import static javax.swing.JOptionPane.showMessageDialog;
/**
 *
 * @author Sistemas
 */
public class TipoMovimientoDAL {
    private Connection cn = null;
    private Statement st = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    public String buscarTipoMovimiento(String codigo) {
        try {
            cn = Conexion.realizarConexion();
            st = cn.createStatement();
            String sql = "select chr_tipocodigo " + " from tipomovimiento " +
                " where chr_tipocodigo = '" + codigo + "'";
            rs = st.executeQuery(sql);
            while(rs.next()) {
                return rs.getString("chr_tipocodigo");
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
    public String insertarTipoMovimiento(TipoMovimiento movimiento) {
        String mensaje = null;
        try {
            cn = Conexion.realizarConexion();
            String sql = "insert into movimiento values(?,?,?,?)";
            ps = cn.prepareStatement(sql);
            ps.setString(1, movimiento.getCodigo());
            ps.setString(2, movimiento.getAccion());
            ps.setString(3, movimiento.getDescripcion());
            ps.setString(4, movimiento.getEstado());            
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
    public ArrayList<TipoMovimiento> listarTipoMovimiento() {
        ArrayList<TipoMovimiento> movimiento = new ArrayList<TipoMovimiento>();
        try {
            cn = Conexion.realizarConexion();
            st = cn.createStatement();
            String sql = "select * from tipomovimiento";
            rs = st.executeQuery(sql);
            while(rs.next()) {
                movimiento.add(new TipoMovimiento(
                    rs.getString(1), rs.getString(2),
                    rs.getString(3), rs.getString(4)));
                    
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
        return movimiento;
    }
   
    public void ejecutarReporte(String codigo) {
        try {
            cn = Conexion.realizarConexion();
            String master = System.getProperty("user.dir") +
                    "\\src\\reportes\\rptTipoMovimiento.jasper";
            System.out.println("master: " + master);
            if(master == null) {
                showMessageDialog(null, "No se encontro el archivo",
                        "Error", 0);
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
            parametro.put("codigo", codigo);

            JasperPrint jasperPrint = JasperFillManager.fillReport(
                    masterReport, parametro, cn);

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
