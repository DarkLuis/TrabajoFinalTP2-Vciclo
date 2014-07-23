/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmListadoEmpleados.java
 *
 * Created on 21/07/2011, 04:18:06 PM
 */

package cliente;

import Imagenes.JFondo3;
import negocio.*;
import entidades.*;
import java.awt.BorderLayout;
import javax.swing.table.*;
import static javax.swing.JOptionPane.showMessageDialog;
import java.util.*;

/**
 *
 * @author Sistemas
 */
public class ListarClientes extends javax.swing.JFrame {

    /** Creates new form frmListadoEmpleados */
    public ListarClientes() {
        initComponents();
        setLocationRelativeTo(null);
        JFondo3 p=new JFondo3(this);
        this.add(p,BorderLayout.CENTER);
        this.pack();
        lista = new ClienteBL().listarCliente();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        btrGrupos = new javax.swing.ButtonGroup();
        rbtnOrdenarCodigo = new javax.swing.JRadioButton();
        rbtnOrdenarApellido = new javax.swing.JRadioButton();
        btnMostrar = new javax.swing.JButton();
        scrEmpleados = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listar Clientes");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btrGrupos.add(rbtnOrdenarCodigo);
        rbtnOrdenarCodigo.setFont(new java.awt.Font("Comic Sans MS", 1, 14));
        rbtnOrdenarCodigo.setText("Ordenar por Codigo");

        btrGrupos.add(rbtnOrdenarApellido);
        rbtnOrdenarApellido.setFont(new java.awt.Font("Comic Sans MS", 1, 14));
        rbtnOrdenarApellido.setText("Ordenar por Apellidos Paternos");

        btnMostrar.setFont(new java.awt.Font("Comic Sans MS", 1, 14));
        btnMostrar.setText("Mostrar listado");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Ap.Paterno", "Ap. Materno", "Nombre", "Cuidad", "Direccion", "Usuario", "Clave"
            }
        ));
        scrEmpleados.setViewportView(tblEmpleados);

        btnSalir.setFont(new java.awt.Font("Comic Sans MS", 1, 14));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rbtnOrdenarCodigo)
                .addGap(18, 18, 18)
                .addComponent(rbtnOrdenarApellido)
                .addGap(90, 90, 90))
            .addGroup(layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(166, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrEmpleados, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(386, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnOrdenarApellido)
                    .addComponent(rbtnOrdenarCodigo))
                .addGap(18, 18, 18)
                .addComponent(btnMostrar)
                .addGap(18, 18, 18)
                .addComponent(scrEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       
       // Sirve para generar la consulta
    }//GEN-LAST:event_formWindowOpened

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        if(rbtnOrdenarCodigo.isSelected()) {
            Collections.sort(lista);
            llenarTabla();
        }else {
            if(rbtnOrdenarApellido.isSelected()) {
                Collections.sort(lista, new ClienteCompararPaterno());
                llenarTabla();
            }else 
                showMessageDialog(null, "Debe seleccionar un boton", "ERROR", 2);
            
        }
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void llenarTabla() {
        modelo = new DefaultTableModel();
        Iterator<Cliente> iterador = lista.iterator();
        String columnas[] = {"Codigo", "Ap. Paterno", "Ap. Materno", "Nombre", "DNI", "Ciudad", "Direccion", "Tel / Cel","E-mail"};
        modelo.setColumnIdentifiers(columnas);
        Object fila[] = new Object[columnas.length];
        Cliente cliente = null;
        while(iterador.hasNext()) {
            cliente = iterador.next();
           fila[0] = cliente.getCodigo();
            fila[1] = cliente.getApellidoPaterno();
            fila[2] = cliente.getApellidoMaterno();
            fila[3] = cliente.getNombre();
            fila[4] = cliente.getDni();
            fila[5] = cliente.getCiudad();
            fila[6] = cliente.getDireccion();
            fila[7] = cliente.getTelefono();
            fila[8] = cliente.getEmail();
            modelo.addRow(fila);
        }
        tblEmpleados.setModel(modelo);
    }

    /**
    * @param args the command line arguments
    */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ListarClientes().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.ButtonGroup btrGrupos;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JRadioButton rbtnOrdenarApellido;
    private javax.swing.JRadioButton rbtnOrdenarCodigo;
    private javax.swing.JScrollPane scrEmpleados;
    private javax.swing.JTable tblEmpleados;
    // End of variables declaration//GEN-END:variables

    private ArrayList<Cliente> lista = null;
    private DefaultTableModel modelo = null;

}
