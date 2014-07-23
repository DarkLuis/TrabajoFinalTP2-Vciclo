/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;
import java.util.*;
import entidades.InteresMensual;
import java.sql.*;
import static javax.swing.JOptionPane.showMessageDialog;


import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Sara Rojas
 */
public class InteresMensualDAL {
    private Connection cn = null;
    private PreparedStatement ps = null;
    private Statement st = null;
    private ResultSet rs = null;
    
    public ArrayList<InteresMensual> listarInteresMensual() {
        ArrayList<InteresMensual> intereses = new ArrayList<InteresMensual>();
        try {
            cn = Conexion.realizarConexion();
            st = cn.createStatement();
            String sql = "select * from interesmensual";
            rs = st.executeQuery(sql);
            while(rs.next()) {
                intereses.add(new InteresMensual(
                  rs.getString(1), rs.getDouble(2) ));
            }
        } catch (ClassNotFoundException ex) {
            showMessageDialog(null,ex.getMessage(),"Error",0);
        } catch (SQLException ex) {
            showMessageDialog(null,ex.getMessage(),"Error",0);
        } finally {
            try {
                rs.close();
                st.close();
                cn.close();
            }catch(Exception ex) {
                showMessageDialog(null,ex.getMessage(),"Error",0);
            }
        }
        return intereses;
    }
    
    public String insertarInteresMensual(InteresMensual interesMensual) {
        String mensaje = null;
        try {
            cn = Conexion.realizarConexion();
            String sql =
                    "insert into interesmensual values(?,?)";
            ps = cn.prepareStatement(sql);
            ps.setString(1, interesMensual.getCodigo());
            ps.setDouble(2, interesMensual.getImporte());
            ps.executeUpdate();
        } catch (ClassNotFoundException ex) {
            mensaje = ex.getMessage();
        } catch (SQLException ex) {
            mensaje = ex.getMessage();
        } finally {
            try {
                ps.close();
                cn.close();
            } catch (Exception ex) {
                mensaje = ex.getMessage();
            }
        }
        return mensaje;
    }
    
    public void ejecutarReporte(String codigo) {
        try {
            cn = Conexion.realizarConexion();
            String master = System.getProperty("user.dir") +
                    "\\src\\reportes\\ReporteInteresMensual.jasper";
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
            parametro.put("chr_monecodigo", codigo);

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
