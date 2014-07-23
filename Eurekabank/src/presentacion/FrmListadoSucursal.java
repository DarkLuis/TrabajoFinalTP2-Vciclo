/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmListadoSucursal.java
 *
 * Created on 02-jul-2012, 14:35:30
 */

package presentacion;
import entidades.Sucursal;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import logica.SucursalBL;
/**
 *
 * @author SNS
 */
public class FrmListadoSucursal extends javax.swing.JFrame {

    
    private static FrmListadoSucursal obj=null;
    
    public static FrmListadoSucursal getInstanciaUnica() {

        if (obj == null) {
            obj = new FrmListadoSucursal(obj);
        }
        return obj;
    }
    /**
     * Creates new form FrmSucursal
     */
    private FrmListadoSucursal(JFrame frmPrincipal) {
        initComponents();
        setLocationRelativeTo(frmPrincipal);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnMostrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSucursal = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("..::LISTADO DE SUCURSAL::..");

        btnMostrar.setFont(new java.awt.Font("Vrinda", 1, 14)); // NOI18N
        btnMostrar.setForeground(new java.awt.Color(0, 102, 0));
        btnMostrar.setText("Listar");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        tblSucursal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Ciudad", "Direccion", "Cuenta"
            }
        ));
        jScrollPane1.setViewportView(tblSucursal);

        btnSalir.setFont(new java.awt.Font("Vrinda", 1, 14)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(0, 102, 0));
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
                .addGap(56, 56, 56)
                .addComponent(btnMostrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(82, 82, 82))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnMostrar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        modelo = new DefaultTableModel();
        ArrayList<Sucursal> lista = new ArrayList<Sucursal>();
        lista = new SucursalBL().listarSucursal();
        String columnas[] = {"Código", "Nombre","Ciudad","Direccion","Numero"};
        Iterator<Sucursal> iterador = lista.iterator();
        modelo.setColumnIdentifiers(columnas);
        Object fila[] = new Object[columnas.length];
        Sucursal sucu = null;
        while(iterador.hasNext()) {
            sucu = iterador.next();
            fila[0] = sucu.getCodigo();
            fila[1] = sucu.getNombre();
            fila[2] = sucu.getCiudad();
            fila[3] = sucu.getDireccion();
            fila[4] = sucu.getNumero();
            modelo.addRow(fila);
        }
        tblSucursal.setModel(modelo);
}//GEN-LAST:event_btnMostrarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
}//GEN-LAST:event_btnSalirActionPerformed

    /**
    * @param args the command line arguments
    */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FrmListadoSucursal(null).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSucursal;
    // End of variables declaration//GEN-END:variables
    private DefaultTableModel modelo;
}
