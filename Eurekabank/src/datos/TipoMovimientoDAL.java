/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package datos;
import entidades.*;
import java.util.*;
import java.sql.*;
import static javax.swing.JOptionPane.showMessageDialog;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author SNS
 */
public class TipoMovimientoDAL {
    private Connection cn = null;
    private Statement st = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;

    public String insertarTipoMovimiento(TipoMovimiento tipoMovimiento) {
        String mensaje = null;
        try {
            cn = Conexion.realizarConexion();
            String sql = "insert into tipomovimiento values(?,?,?,?)";
            ps = cn.prepareStatement(sql);
            ps.setString(1, tipoMovimiento.getCodigo());
            ps.setString(2, tipoMovimiento.getDescripcion());
            ps.setString(3, tipoMovimiento.getAccion());
            ps.setString(4, tipoMovimiento.getEstado());
            ps.executeUpdate();
        }catch(ClassNotFoundException ex) {
            mensaje = ex.getMessage();
        }catch(SQLException ex) {
            mensaje = ex.getMessage();
        }finally {
            try {
                ps.close();
                cn.close();
            }catch(Exception ex) {
                mensaje = ex.getMessage();
            }
        }
        return mensaje;
    }

    public String buscarTipoMovimiento(String tipoCodigo) {
        try {
            cn = Conexion.realizarConexion();
            st = cn.createStatement();
            String sql = "select chr_tipocodigo from tipomovimiento " +
                 " where chr_tipocodigo = '" + tipoCodigo + "'";
            rs = st.executeQuery(sql);
            while(rs.next()) {
                return rs.getString("chr_tipocodigo");
            }
        }catch(ClassNotFoundException ex) {
            showMessageDialog(null, ex.getMessage(), "Excepción", 0);
        }catch(SQLException ex) {
            showMessageDialog(null, ex.getMessage(), "Excepción", 0);
        }finally {
            try {
                rs.close();
                st.close();
                cn.close();
            }catch(Exception ex) {
                showMessageDialog(null,ex.getMessage(),"Excepción",0);
            }
        }
        return null;
    }

    public ArrayList<TipoMovimiento> listarTipoMovimiento() {
        ArrayList<TipoMovimiento> tipoM = new ArrayList<TipoMovimiento>();
        try {
            cn = Conexion.realizarConexion();
            st = cn.createStatement();
            String sql = "select * from tipomovimiento";
            rs = st.executeQuery(sql);
            while(rs.next()) {
                tipoM.add(new TipoMovimiento(rs.getString(1),
                        rs.getString(2),rs.getString(3),rs.getString(4)));
            }
        }catch(ClassNotFoundException ex) {
            showMessageDialog(null, ex.getMessage(), "Excepción", 0);
        }catch(SQLException ex) {
            showMessageDialog(null, ex.getMessage(), "Excepción", 0);
        }finally {
            try {
                rs.close();
                st.close();
                cn.close();
            }catch(Exception ex) {
                showMessageDialog(null,ex.getMessage(),"Excepción",0);
            }
        }
        return tipoM;
    }

    public void ejecutarReporte(String codigo) {
        try {
            cn = Conexion.realizarConexion();
            String master = System.getProperty("user.dir") +
                    "\\src\\reportes\\reporteTipoMovimiento.jasper";
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
                showMessageDialog(null, "MasterReport:" + ex.getMessage(), "Error", 0);
                System.exit(3);
            }

            Map parametro = new HashMap();
            parametro.put("chr_tipocodigo", codigo);

            JasperPrint jasperPrint = JasperFillManager.fillReport(
                    masterReport, parametro, cn);

            JasperViewer jviewer = new JasperViewer(jasperPrint, false);
            jviewer.setTitle("Reporte");
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
