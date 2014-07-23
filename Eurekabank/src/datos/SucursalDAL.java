/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package datos;
import entidades.Sucursal;
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
public class SucursalDAL {
    private Connection cn = null;
    private Statement st = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;

    public String insertarSucursal(Sucursal sucursal) {
        String mensaje = null;
        try {
            cn = Conexion.realizarConexion();
            String sql = "insert into sucursal values(?,?,?,?,?)";
            ps = cn.prepareStatement(sql);
            ps.setString(1, sucursal.getCodigo());
            ps.setString(2, sucursal.getNombre());
            ps.setString(3, sucursal.getCiudad());
            ps.setString(4, sucursal.getDireccion());
            ps.setInt(5, sucursal.getNumero());
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

    public String buscarSucursal(String sucuCodigo) {
        try {
            cn = Conexion.realizarConexion();
            st = cn.createStatement();
            String sql = "select chr_sucucodigo from sucursal " +
                 " where chr_sucucodigo = '" + sucuCodigo + "'";
            rs = st.executeQuery(sql);
            while(rs.next()) {
                return rs.getString("chr_sucucodigo");
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

    public ArrayList<Sucursal> listarSucursal() {
        ArrayList<Sucursal> sucu = new ArrayList<Sucursal>();
        try {
            cn = Conexion.realizarConexion();
            st = cn.createStatement();
            String sql = "select * from sucursal";
            rs = st.executeQuery(sql);
            while(rs.next()) {
                sucu.add(new Sucursal(rs.getString(1),rs.getString(2),
                        rs.getString(3),rs.getString(4),rs.getInt(5)));
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
        return sucu;
    }

    public void ejecutarReporte(String codigo) {
        try {
            cn = Conexion.realizarConexion();
            String master = System.getProperty("user.dir") +
                    "\\src\\reportes\\reporteSucursal.jasper";
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
