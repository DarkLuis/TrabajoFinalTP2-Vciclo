/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package datos;
import entidades.Empleado;
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
public class EmpleadoDAL {
    private Connection cn = null;
    private Statement st = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;

    public String insertarEmpleado(Empleado empleado) {
        String mensaje = null;
        try {
            cn = Conexion.realizarConexion();
            String sql = "insert into empleado values(?,?,?,?,?,?,?,?)";
            ps = cn.prepareStatement(sql);
            ps.setString(1, empleado.getCodigo());
            ps.setString(2, empleado.getPaterno());
            ps.setString(3, empleado.getMaterno());
            ps.setString(4, empleado.getNombre());
            ps.setString(5, empleado.getCiudad());
            ps.setString(6, empleado.getDireccion());
            ps.setString(7, empleado.getUsuario());
            ps.setString(8, empleado.getClave());
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

    public String buscarEmpleado(String codigo) {
        try {
            cn = Conexion.realizarConexion();
            st = cn.createStatement();
            String sql = "select chr_emplcodigo from empleado " +
                 " where chr_emplcodigo = '" + codigo + "'";
            rs = st.executeQuery(sql);
            while(rs.next()) {
                return rs.getString("chr_emplcodigo");
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

    public ArrayList<Empleado> listarEmpleado() {
        ArrayList<Empleado> emple = new ArrayList<Empleado>();
        try {
            cn = Conexion.realizarConexion();
            st = cn.createStatement();
            String sql = "select * from empleado";
            rs = st.executeQuery(sql);
            while(rs.next()) {
                emple.add(new Empleado(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
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
        return emple;
    }

    public void ejecutarReporte(String codigo) {
        try {
            cn = Conexion.realizarConexion();
            String master = System.getProperty("user.dir") +
                    "\\src\\reportes\\reporteEmpleado.jasper";
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
            parametro.put("chr_emplcodigo", codigo);

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
