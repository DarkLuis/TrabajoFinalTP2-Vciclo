/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package accesoADatos;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import static javax.swing.JOptionPane.showMessageDialog;
import java.util.*;
import entidades.*;
import java.sql.*;
import static javax.swing.JOptionPane.showMessageDialog;


/**
 *
 * @author sistemas
 */
public class ClienteDAL {
    private Connection cn;
    private Statement st;
    private PreparedStatement ps;
    private ResultSet rs;

    public String insertarCliente(Cliente cliente) {
        String mensaje = null;
        try {

            cn = Conexion.realizarConexion();
            String sql = "insert into cliente values(?,?,?,?,?,?,?,?,?)";
            ps = cn.prepareStatement(sql);
            ps.setString(1, cliente.getCodigo());
            ps.setString(2, cliente.getApellidoPaterno());
            ps.setString(3, cliente.getApellidoMaterno());
            ps.setString(4, cliente.getNombre());
            ps.setString(5, cliente.getDni());
            ps.setString(6, cliente.getCiudad());
            ps.setString(7, cliente.getDireccion());
            ps.setString(8, cliente.getTelefono());
            ps.setString(9, cliente.getEmail());

            ps.executeUpdate();
        } catch(ClassNotFoundException ex) {
            mensaje = ex.getMessage();
        } catch(SQLException ex) {
            mensaje = ex.getMessage();
        } finally {
            try {
                ps.close();
                cn.close();
            } catch(Exception ex) {
                mensaje = ex.getMessage();
            }
        }
        return mensaje;
    }

    public String buscarCliente(String codigo) {
        try {
            cn = Conexion.realizarConexion();
            st = cn.createStatement();
            String sql = "select chr_cliecodigo from cliente where chr_cliecodigo = '" + codigo + "'";
            rs = st.executeQuery(sql);
            while(rs.next()) {
                return rs.getString("chr_cliecodigo");
            }
        } catch(ClassNotFoundException ex) {
            showMessageDialog(null, ex.getMessage(), "Error1 Buscar Cliente", 0);
        } catch(SQLException ex) {
            showMessageDialog(null, ex.getMessage(), "Error2 Buscar Cliente", 0);
        } finally {
            try {
                st.close();
                rs.close();
                cn.close();
            } catch(Exception ex) {
                showMessageDialog(null, ex.getMessage(), "Error3 Buscar Cliente", 0);
            }
        }
        return null;
    }

     public String eLiminarCliente(String codigo){
        String mensaje= null;
        try{
            cn=Conexion.realizarConexion();
            String sql= "delete from cliente where chr_cliecodigo = '"+ codigo + "'";
            ps=cn.prepareStatement(sql);
            ps.executeUpdate();
        }catch(ClassNotFoundException e){
            mensaje=e.getMessage();
             showMessageDialog(null,"Error1 eliminar Cliente");
        }catch(SQLException e){
            mensaje= e.getMessage();
             showMessageDialog(null,"Error2 eliminar Cliente");
        }finally{
            try{
                ps.close();
                cn.close();
            }catch(Exception e){
                mensaje=e.getMessage();
            }

        }
        return mensaje;
    }

    public ArrayList<Cliente> listarClientes() {
        ArrayList<Cliente> listaClientes =
                new ArrayList<Cliente>();
        try {
            cn = Conexion.realizarConexion();
            st = cn.createStatement();
            String sql = "select * from cliente";
            rs = st.executeQuery(sql);
            while(rs.next()) {
                listaClientes.add(new Cliente(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
                                              rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)));            }
        } catch(ClassNotFoundException ex) {
            showMessageDialog(null,ex.getMessage(),"Error1 listar Cliente ",0);
        } catch(SQLException ex) {
            showMessageDialog(null,ex.getMessage(),"Error2 listar Cliente",0);
        } finally {
            try {
                st.close();
                rs.close();
                cn.close();
            } catch(Exception ex) {
                showMessageDialog(null,ex.getMessage(),"Error3 listar Cliente",0);
            }
        }
        return listaClientes;
    }
    public void ejecutarReporte() {
        try {
            cn = Conexion.realizarConexion();
            String master = System.getProperty("user.dir") + "\\src\\reportes\\rptCliente.jasper";
            System.out.println("master: " + master);
            if(master == null) {
                showMessageDialog(null, "No se encontro el archivo","Error", 0);
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


     public void ejecutarReporteMov(String codigo) {
        try {
            cn = Conexion.realizarConexion();
            String master = System.getProperty("user.dir") +
                    "\\src\\reportes\\rptMovimientoCliente.jasper";
            System.out.println("master: " + master);
            if(master == null) {
                showMessageDialog(null, "No se encontro el archivo","Error", 0);
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
            parametro.put("codigo", codigo);
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
