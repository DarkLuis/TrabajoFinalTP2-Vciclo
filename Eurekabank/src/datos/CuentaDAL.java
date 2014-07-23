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
public class CuentaDAL {
    private Connection cn = null;
    private Statement st = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    
    public String insertarCuenta(Cuenta cuenta) {
        int dia,mes,año;
        String mensaje = null; 
        try {
            cn = Conexion.realizarConexion();
            String sql = "insert into cuenta values(?,?,?,?,?,?,?,?,?,?)";
            ps = cn.prepareStatement(sql);
            dia=cuenta.getFecha().get(Calendar.DAY_OF_YEAR);
            mes=cuenta.getFecha().get(Calendar.MONTH);
            año=cuenta.getFecha().get(Calendar.YEAR); 
            ps.setString(1,cuenta.getCodigo());
            ps.setString(2,cuenta.getCodigoM());
            ps.setString(3,cuenta.getCodigoS());
            ps.setString(4,cuenta.getCodigoE());
            ps.setString(5,cuenta.getCodigoC());
            ps.setDouble(6,cuenta.getSaldo());
            ps.setInt(7,dia);
            ps.setInt(7, mes);
            ps.setInt(7,año);
            ps.setString(8,cuenta.getEstado());
            ps.setInt(9,cuenta.getCostMovimiento());
            ps.setString(10,cuenta.getClave());
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
    
        public String buscarCuenta(String codigo) {
        try {
            cn = Conexion.realizarConexion();
            st = cn.createStatement();
            String sql = "select chr_cuencodigo "
                    + "from cuenta where chr_cuencodigo = '"
                    + codigo + "'";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                return rs.getString("chr_cuencodigo");
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
        public ArrayList<Cuenta> listarCuenta() {
        ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
        Cuenta cuenta = null;
        int dia, mes, año;
        GregorianCalendar fecha;
        try {
            cn = Conexion.realizarConexion();
            st = cn.createStatement();
            String sql = "select * from cuenta";
            rs = st.executeQuery(sql);
            while(rs.next()) {
                cuenta = new Cuenta();
                cuenta.setCodigo(rs.getString(1));
                cuenta.setCodigoM(rs.getString(2));
                cuenta.setCodigoS(rs.getString(3));
                cuenta.setClave(rs.getString(4));
                cuenta.setCodigoE(rs.getString(5));
                cuenta.setSaldo(rs.getDouble(6));
                dia = rs.getDate(7).getDate();
                mes = rs.getDate(7).getMonth();
                año = rs.getDate(7).getYear();
                fecha = new GregorianCalendar(año, mes, dia);
                cuenta.setFecha(fecha);
                cuenta.setEstado(rs.getString(8));
                cuenta.setCostMovimiento(rs.getInt(9));
                cuenta.setClave(rs.getString(10));
                cuentas.add(cuenta);
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
        return cuentas;
    }
        
    public void ejecutarReporte(String cuencodigo) {
        try {
            cn = Conexion.realizarConexion();
            String master = System.getProperty("user.dir") +
                    "\\src\\reportes\\reporteCuenta.jasper";
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
            parametro.put("chr_cuencodigo", cuencodigo);

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
