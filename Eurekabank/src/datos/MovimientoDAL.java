/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;
import java.util.*;
import entidades.Movimiento;
import java.sql.*;
import static javax.swing.JOptionPane.showMessageDialog;


import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Sara Rojas
 */
public class MovimientoDAL {
    private Connection cn = null;
    private PreparedStatement ps = null;
    private Statement st = null;
    private ResultSet rs = null;
    
    public ArrayList<Movimiento> listarMovimiento() {
        ArrayList<Movimiento> movimientos = new ArrayList<Movimiento>();
        Movimiento movimiento = null;
        int dia=0, mes=0, año=0;
        GregorianCalendar fecha=null;
        try {
            cn = Conexion.realizarConexion();
            st = cn.createStatement();
            String sql = "select * from movimiento";
            rs = st.executeQuery(sql);
            while(rs.next()) {
                movimiento = new Movimiento();
                movimiento.setCuencodigo(rs.getString(
                        1));
                movimiento.setNumero(rs.getInt(2));
                dia = rs.getDate(3).getDate();
                mes = rs.getDate(3).getMonth();
                año = rs.getDate(3).getYear();
                fecha = new GregorianCalendar(año, mes, dia);
                movimiento.setFecha(fecha);
                movimiento.setEmplcodigo(rs.getString(4));
                movimiento.setTipocodigo(rs.getString(5));
                movimiento.setImporte(rs.getDouble(6));
                movimiento.setCuenreferencia(rs.getString(7));
                movimientos.add(movimiento);
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
        return movimientos;
    }
    
     public String insertarMovimiento(Movimiento movimiento) {
        String mensaje = null;
        try {
            cn = Conexion.realizarConexion();
            String sql =
                    "insert into movimiento values(?,?,?,?,?,?,?)";
            ps = cn.prepareStatement(sql);
            ps.setString(1, movimiento.getCuencodigo());
            ps.setInt(2,movimiento.getNumero());
            ps.setString(3, movimiento.fecha());
            ps.setString(4, movimiento.getEmplcodigo());
            ps.setString(5, movimiento.getTipocodigo());
            ps.setDouble(6, movimiento.getImporte());
            ps.setString(7, movimiento.getCuenreferencia());
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
    
    public String buscarTipocodigo(String tipocodigo) {
        try {
            cn = Conexion.realizarConexion();
            st = cn.createStatement();
            String sql = "select chr_tipocodigo "
                    + "from movimiento where chr_tipocodigo = '"
                    + tipocodigo + "'";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                return rs.getString("chr_tipocodigo");
            }
        } catch (ClassNotFoundException ex) {
            showMessageDialog(null, ex.getMessage(),
                    "Excepcion", 0);
        } catch (SQLException ex) {
            showMessageDialog(null, ex.getMessage(),
                    "Excepción", 0);
        } finally {
            try {
                rs.close();
                st.close();
                cn.close();
            } catch (Exception ex) {
                showMessageDialog(null, ex.getMessage(),
                        "Excepción", 0);
            }
        }
        return null;
    }
    
    public void ejecutarReporte(String codigo) {
        try {
            cn = Conexion.realizarConexion();
            String master = System.getProperty("user.dir") +
                    "\\src\\reportes\\ReporteMovimiento.jasper";
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
            parametro.put("chr_cuencodigo", codigo);

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
