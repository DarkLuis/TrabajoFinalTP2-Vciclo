/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmCargoMantenimiento.java
 *
 * Created on 12/07/2012, 03:08:49 PM
 */
package presentacion;
import javax.swing.*;
import logica.CargoMantenimientoBL;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Sara Rojas
 */
public class FrmCargoMantenimiento extends javax.swing.JFrame {

    private static FrmCargoMantenimiento obj=null;
    
    public static FrmCargoMantenimiento getInstanciaUnica() {

        if (obj == null) {
            obj = new FrmCargoMantenimiento(obj);
        }
        return obj;
    }
    /**
     * Creates new form FrmSucursal
     */
    private FrmCargoMantenimiento(JFrame parent) {
        initComponents();
        setLocationRelativeTo(parent);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TxtCod = new javax.swing.JTextField();
        TxtMontoMax = new javax.swing.JTextField();
        TxtImporte = new javax.swing.JTextField();
        BtnInsertar = new javax.swing.JButton();
        BtnNuevo = new javax.swing.JButton();
        BtnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("..::REGISTRO DE CARGO DE MANTENIMIENTO::..");

        jLabel1.setFont(new java.awt.Font("Vrinda", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 255));
        jLabel1.setText("Código de Moneda:");

        jLabel2.setFont(new java.awt.Font("Vrinda", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 255));
        jLabel2.setText("Monto Máximo:");

        jLabel3.setFont(new java.awt.Font("Vrinda", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 255));
        jLabel3.setText("Importe:");

        TxtCod.setBackground(new java.awt.Color(204, 255, 255));
        TxtCod.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TxtCod.setEnabled(false);

        TxtMontoMax.setBackground(new java.awt.Color(204, 255, 255));
        TxtMontoMax.setEnabled(false);
        TxtMontoMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtMontoMaxActionPerformed(evt);
            }
        });

        TxtImporte.setBackground(new java.awt.Color(204, 255, 255));
        TxtImporte.setEnabled(false);

        BtnInsertar.setFont(new java.awt.Font("Vrinda", 1, 14)); // NOI18N
        BtnInsertar.setForeground(new java.awt.Color(0, 102, 0));
        BtnInsertar.setText("Insertar");
        BtnInsertar.setEnabled(false);
        BtnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInsertarActionPerformed(evt);
            }
        });

        BtnNuevo.setFont(new java.awt.Font("Vrinda", 1, 14)); // NOI18N
        BtnNuevo.setForeground(new java.awt.Color(0, 102, 0));
        BtnNuevo.setText("Nuevo");
        BtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoActionPerformed(evt);
            }
        });

        BtnSalir.setFont(new java.awt.Font("Vrinda", 1, 14)); // NOI18N
        BtnSalir.setForeground(new java.awt.Color(0, 102, 0));
        BtnSalir.setText("Salir");
        BtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtImporte)
                    .addComponent(TxtMontoMax)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BtnNuevo)
                        .addGap(52, 52, 52)
                        .addComponent(BtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addComponent(TxtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(BtnInsertar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(TxtMontoMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TxtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnInsertar)
                    .addComponent(BtnSalir)
                    .addComponent(BtnNuevo))
                .addGap(54, 54, 54))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void TxtMontoMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtMontoMaxActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_TxtMontoMaxActionPerformed

private void BtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSalirActionPerformed
// TODO add your handling code here:
    this.dispose();
}//GEN-LAST:event_BtnSalirActionPerformed

private void BtnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnInsertarActionPerformed
// TODO add your handling code here:
    String monecodigo;
    double montoMaximo, importe;
        int rpta;
        monecodigo = TxtCod.getText();
        montoMaximo = Double.parseDouble(TxtMontoMax.getText());
        importe = Double.parseDouble(TxtImporte.getText());
        if(monecodigo!= null) {
            if(montoMaximo > importe){
                rpta = new CargoMantenimientoBL().insertarCargoMantenimiento(monecodigo, montoMaximo, importe);
            switch(rpta) {
                case 0:
                case 1:
                    Nuevo();
                    activar(false);
                    break;
                case 2:
                    TxtCod.setText(null);
                    TxtCod.requestFocus();
                    break;
                case 3:
                    Nuevo();
                    TxtCod.requestFocus();
                    break;
            }
            }else{
                showMessageDialog(this, "El importe excede al monto maximo", "Aviso", 2);
            }
        } else
            showMessageDialog(this, "Debe digitar todos los campos", "Aviso", 3);
}//GEN-LAST:event_BtnInsertarActionPerformed

private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoActionPerformed
    Nuevo();
    activar(true);//enviamos el valor null
    TxtCod.requestFocus();
}//GEN-LAST:event_BtnNuevoActionPerformed

    private void Nuevo() {
        TxtCod.setText(null);// a las cajas d texto le asigna null para eliminar datos d caja
        TxtMontoMax.setText(null);
        TxtImporte.setText(null);
        
    }
        private void activar(boolean estado) {
        TxtCod.setEnabled(estado);
        TxtMontoMax.setEnabled(estado);
        TxtImporte.setEnabled(estado);
        
        TxtCod.setEnabled(estado);
        BtnInsertar.setEnabled(estado);
        BtnNuevo.setEnabled(!estado);//se niega el valor estado
    }
        
    /**
     * @param args the command line arguments
     */
   /*public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        /*try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmCargoMantenimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCargoMantenimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCargoMantenimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCargoMantenimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       /* java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrmCargoMantenimiento().setVisible(true);
            }
        });
    }*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnInsertar;
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JButton BtnSalir;
    private javax.swing.JTextField TxtCod;
    private javax.swing.JTextField TxtImporte;
    private javax.swing.JTextField TxtMontoMax;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
