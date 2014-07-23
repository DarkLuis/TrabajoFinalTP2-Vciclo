/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;
import java.util.*;
import entidades.CargoMantenimiento;
import java.sql.*;
import static javax.swing.JOptionPane.showMessageDialog;


import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Sara Rojas
 */
public class CargoMantenimientoDAL {
    private Connection cn = null;
    private PreparedStatement ps = null;
    private Statement st = null;
    private ResultSet rs = null;
    
    public ArrayList<CargoMantenimiento> listarCargoMantenimiento() {
        ArrayList<CargoMantenimiento> cargoMantenimientos = 
                new ArrayList<CargoMantenimiento>();
        try {
            cn = Conexion.realizarConexion();
            st = cn.createStatement();
            String sql = "select * from cargomantenimiento";
            rs = st.executeQuery(sql);
            while(rs.next()) {
                cargoMantenimientos.add(new CargoMantenimiento(
                  rs.getString(1), rs.getDouble(2), rs.getDouble(3)));
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
        return cargoMantenimientos;
    }
    
    public String insertarCargoMantenimiento(CargoMantenimiento cargoMantenimiento) {
        String mensaje = null;
        try {
            cn = Conexion.realizarConexion();
            String sql =
                    "insert into cargomantenimiento values(?,?,?)";
            ps = cn.prepareStatement(sql);
            ps.setString(1, cargoMantenimiento.getMonecodigo());
            ps.setDouble(2, cargoMantenimiento.getImporte());
            ps.setDouble(3, cargoMantenimiento.getMontoMaximo());
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
    
    public void ejecutarReporte(String monecodigo) {
        try {
            cn = Conexion.realizarConexion();
            String master = System.getProperty("user.dir") +
                    "\\src\\reportes\\ReporteMantenimiento.jasper";
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
            parametro.put("chr_monecodigo", monecodigo);

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
