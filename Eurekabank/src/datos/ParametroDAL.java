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
 * @author jefferson
 */
public class ParametroDAL {
    private Connection cn = null;
    private Statement st = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;

    public String insertarParametro(Parametro parametro) {
        String mensaje = null;
        try {
            cn = Conexion.realizarConexion();
            String sql = "insert into parametro values(?,?,?,?)";
            ps = cn.prepareStatement(sql);
            ps.setString(1, parametro.getCodigo());
            ps.setString(2, parametro.getDescripcion());
            ps.setString(3, parametro.getValor());
            ps.setString(4, parametro.getEstado());
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

    public String buscarParametro(String paracodigo) {
        try {
            cn = Conexion.realizarConexion();
            st = cn.createStatement();
            String sql = "select chr_paracodigo from parametro " +
                 " where chr_paracodigo = '" + paracodigo + "'";
            rs = st.executeQuery(sql);
            while(rs.next()) {
                return rs.getString("chr_paracodigo");
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

    public ArrayList<Parametro> listarParametro() {
        ArrayList<Parametro> parametro= new ArrayList<Parametro>();
        try {
            cn = Conexion.realizarConexion();
            st = cn.createStatement();
            String sql = "select * from parametro";
            rs = st.executeQuery(sql);
            while(rs.next()) {
                parametro.add(new Parametro(rs.getString(1),
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
        return parametro;
    }
    
    public void ejecutarReporte(String codigo) {
        try {
            cn = Conexion.realizarConexion();
            String master = System.getProperty("user.dir") +
                    "\\src\\reportes\\reporteParametro.jasper";
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
            parametro.put("chr_paracodigo", codigo);

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
