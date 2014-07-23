/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmListadoTipoMovimiento.java
 *
 * Created on 29-jun-2012, 11:43:01
 */

package presentacion;
import entidades.TipoMovimiento;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import logica.TipoMovimientoBL;
/**
 *
 * @author SNS
 */
public class FrmListadoTipoMovimiento extends javax.swing.JFrame {

    
    private static FrmListadoTipoMovimiento obj=null;
    
    public static FrmListadoTipoMovimiento getInstanciaUnica() {

        if (obj == null) {
            obj = new FrmListadoTipoMovimiento(obj);
        }
        return obj;
    }
    /**
     * Creates new form FrmSucursal
     */
    private FrmListadoTipoMovimiento(JFrame frmPrincipal) {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblTipoM = new javax.swing.JTable();
        btnMostrarListado = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("..::LISTADO TIPO DE MOVIMIENTO::..");

        tblTipoM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Descripcion", "Accion", "Estado"
            }
        ));
        jScrollPane1.setViewportView(tblTipoM);

        btnMostrarListado.setFont(new java.awt.Font("Vrinda", 1, 14)); // NOI18N
        btnMostrarListado.setForeground(new java.awt.Color(0, 102, 0));
        btnMostrarListado.setText("Listar");
        btnMostrarListado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarListadoActionPerformed(evt);
            }
        });

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
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMostrarListado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 219, Short.MAX_VALUE)
                        .addComponent(btnSalir)
                        .addGap(77, 77, 77))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMostrarListado)
                    .addComponent(btnSalir))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMostrarListadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarListadoActionPerformed
        modelo = new DefaultTableModel();
        ArrayList<TipoMovimiento> lista = new ArrayList<TipoMovimiento>();
        lista = new TipoMovimientoBL().listarTipoMovimiento();
        String columnas[] = {"Código", "Descripción","Accion","Estaso"};
        Iterator<TipoMovimiento> iterador = lista.iterator();
        modelo.setColumnIdentifiers(columnas);
        Object fila[] = new Object[columnas.length];
        TipoMovimiento tipoM = null;
        while(iterador.hasNext()) {
            tipoM = iterador.next();
            fila[0] = tipoM.getCodigo();
            fila[1] = tipoM.getDescripcion();
            fila[2] = tipoM.getAccion();
            fila[3] = tipoM.getEstado();
            modelo.addRow(fila);
        }
        tblTipoM.setModel(modelo);
}//GEN-LAST:event_btnMostrarListadoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
}//GEN-LAST:event_btnSalirActionPerformed

    /**
    * @param args the command line arguments
    */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FrmListadoTipoMovimiento(null).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMostrarListado;
    private javax.swing.JButton btnSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTipoM;
    // End of variables declaration//GEN-END:variables
    private DefaultTableModel modelo;
}
