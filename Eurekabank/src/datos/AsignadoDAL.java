/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;
import java.util.*;
import entidades.Asignado;
import java.sql.*;
import static javax.swing.JOptionPane.showMessageDialog;


import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Sara Rojas
 */
public class AsignadoDAL {
    private Connection cn = null;
    private PreparedStatement ps = null;
    private Statement st = null;
    private ResultSet rs = null;
    
    public ArrayList<Asignado> listarAsignado() {
        ArrayList<Asignado> asignados = new ArrayList<Asignado>();
        Asignado asignado = null;
        int dia=0, mes=0, año=0;
        GregorianCalendar fecha=null;
        try {
            cn = Conexion.realizarConexion();
            st = cn.createStatement();
            String sql = "select * from asignado";
            rs = st.executeQuery(sql);
            while(rs.next()) {
                asignado = new Asignado();
                asignado.setAsigcodigo(rs.getString(1));
                asignado.setSucucodigo(rs.getString(2));
                asignado.setEmplcodigo(rs.getString(3));
                dia = rs.getDate(4).getDate();
                mes = rs.getDate(4).getMonth();
                año = rs.getDate(4).getYear();
                fecha = new GregorianCalendar(año, mes, dia);
                asignado.setFechaAlta(fecha);

                if (rs.getDate(5) == null) {
                    fecha=null;
                }

                else{
                    dia = rs.getDate(5).getDate();
                    mes = rs.getDate(5).getMonth();
                    año = rs.getDate(5).getYear();
                    fecha = new GregorianCalendar(año, mes, dia);
                }

                asignado.setFechaBaja(fecha);
                asignados.add(asignado);
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
        return asignados;
    }
    
    public void ejecutarReporte(String asigcodigo) {
        try {
            cn = Conexion.realizarConexion();
            String master = System.getProperty("user.dir") +
                    "\\src\\reportes\\ReporteAsignado.jasper";
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
            parametro.put("chr_asigcodigo", asigcodigo);

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
    
    public String insertarAsignado(Asignado asignado) {
        String mensaje = null;
        try {
            cn = Conexion.realizarConexion();
            String sql =
                    "insert into asignado values(?,?,?,?,?)";
            ps = cn.prepareStatement(sql);
            ps.setString(1, asignado.getAsigcodigo());
            ps.setString(2,asignado.getSucucodigo());
            ps.setString(3, asignado.getEmplcodigo());
            ps.setString(4, asignado.fechaAlta());
            if (asignado.fechaBaja()== null)
                ps.setDate(5, null);
            else
                ps.setString(5, asignado.fechaBaja());
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
   
    
    public String buscarAsignado(String asigcodigo) {
        try {
            cn = Conexion.realizarConexion();
            st = cn.createStatement();
            String sql = "select chr_asigcodigo "
                    + "from asignado where chr_asigcodigo = '"
                    + asigcodigo + "'";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                return rs.getString("chr_asigcodigo");
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
}
