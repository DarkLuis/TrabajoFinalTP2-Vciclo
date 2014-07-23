/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package accesoADatos;

import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.JasperReport;
import entidades.*;
import java.sql.*;
import java.util.*;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Sistemas
 */
public class SucursalDAL {
    private Connection cn = null;
    private Statement st = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public String buscarSucursal(String codigo) {
        try {
            cn = Conexion.realizarConexion();
            st = cn.createStatement();
            String sql = "select chr_sucucodigo from sucursal where chr_sucucodigo = " + codigo ;
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
                rs.close();
                st.close();
                cn.close();
            } catch(SQLException ex) {
                showMessageDialog(null, ex.getMessage(), "Error", 0);
            }
        }
        return null;
    }

    public String insertarSucursal(Sucursal sucursal) {
        String mensaje = null;
        try {
            cn = Conexion.realizarConexion();
            String sql = "insert into sucursal " + " values(?,?,?,?,?)";
            ps = cn.prepareStatement(sql);
            ps.setString(1, sucursal.getCodigo());
            ps.setString(2, sucursal.getNombre());
            ps.setString(3, sucursal.getCiudad());
            ps.setString(4, sucursal.getDireccion());
            ps.setInt(5, sucursal.getContadorCuenta());
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
     public String ModificarSucursal(Sucursal sucursal) {
        String mensaje = null;
        try {
            cn = Conexion.realizarConexion();
            String sql = "update sucursal set vch_sucunombre='"+sucursal.getNombre()+"',vch_sucuciudad='"+sucursal.getCiudad()+"',vch_sucudireccion='"+sucursal.getDireccion()+"',int_sucucontcuenta='"+sucursal.getCodigo()+"' where chr_sucucodigo='"+sucursal.getCodigo()+"'";
            ps = cn.prepareStatement(sql);
            ps.executeUpdate();
        } catch(ClassNotFoundException ex) {
            mensaje = ex.getMessage();
            showMessageDialog(null, ex.getMessage(), "Error", 0);
        } catch(SQLException ex) {
            mensaje = ex.getMessage();
            showMessageDialog(null, ex.getMessage(), "Error", 0);
        } finally {
            try {
                ps.close();
                cn.close();
            }catch(SQLException ex) {
                mensaje = ex.getMessage();
                showMessageDialog(null, ex.getMessage(), "Error", 0);
            }
        }
        return mensaje;
    }

    

    public ArrayList<Sucursal> listarSucursal() {
        ArrayList<Sucursal> sucursales = new ArrayList<Sucursal>();
        try {
            cn = Conexion.realizarConexion();
            st = cn.createStatement();
            String sql = "select * from sucursal";
            rs = st.executeQuery(sql);
            while(rs.next()) {
                sucursales.add(new Sucursal(rs.getString(1),
                        rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getInt(5)));
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
        return sucursales;
    }

    public void ejecutarReporte() {
        try {
            cn = Conexion.realizarConexion();
            String master = System.getProperty("user.dir") + "\\src\\reportes\\rptSucursales.jasper";
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
