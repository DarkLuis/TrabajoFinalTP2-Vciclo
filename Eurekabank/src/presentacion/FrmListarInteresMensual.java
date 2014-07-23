/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmListarInteresMensual.java
 *
 * Created on 10/07/2012, 07:58:06 PM
 */
package presentacion;
import entidades.InteresMensual;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import logica.InteresMensualBL;

/**
 *
 * @author Sara Rojas
 */
public class FrmListarInteresMensual extends javax.swing.JFrame {

    /** Creates new form FrmListarInteresMensual */
    public FrmListarInteresMensual(JFrame frmPrincipal) {
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

        btnListarInteresMensual = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInteres = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("..::LISTADO DE INTERES MENSUAL::..");

        btnListarInteresMensual.setFont(new java.awt.Font("Vrinda", 1, 14)); // NOI18N
        btnListarInteresMensual.setForeground(new java.awt.Color(0, 102, 0));
        btnListarInteresMensual.setText("Listar");
        btnListarInteresMensual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarInteresMensualActionPerformed(evt);
            }
        });

        tblInteres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "CÓDIGO", "IMPORTE"
            }
        ));
        jScrollPane1.setViewportView(tblInteres);

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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(btnListarInteresMensual)
                        .addGap(54, 54, 54)
                        .addComponent(btnSalir)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnListarInteresMensual)
                    .addComponent(btnSalir))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListarInteresMensualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarInteresMensualActionPerformed
        // TODO add your handling code here:
        modelo = new DefaultTableModel();
        String columnas[] = {"Código de moneda","Importe"};
        Object fila[] = new Object[columnas.length];
        ArrayList<InteresMensual> lista = new ArrayList<InteresMensual>();
        lista = new InteresMensualBL().listarInteresMensual();
        modelo.setColumnIdentifiers(columnas);
        Iterator<InteresMensual> iterador = lista.iterator();
        InteresMensual intereses=null;
        while(iterador.hasNext()) {
            intereses = iterador.next();
            fila[0] = intereses.getCodigo();
            fila[1] = intereses.getImporte();
            modelo.addRow(fila);
        }
        tblInteres.setModel(modelo);
}//GEN-LAST:event_btnListarInteresMensualActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
}//GEN-LAST:event_btnSalirActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FrmListarInteresMensual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FrmListarInteresMensual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FrmListarInteresMensual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FrmListarInteresMensual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//
//            public void run() {
//                new FrmListarInteresMensual(null).setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnListarInteresMensual;
    private javax.swing.JButton btnSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblInteres;
    // End of variables declaration//GEN-END:variables
    private DefaultTableModel modelo;
}

