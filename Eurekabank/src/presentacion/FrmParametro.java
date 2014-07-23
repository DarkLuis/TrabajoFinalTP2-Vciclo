/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmParametro.java
 *
 * Created on 14-jul-2012, 2:04:11
 */
package presentacion;
import javax.swing.*;
import logica.*;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author jefferson
 */
public class FrmParametro extends javax.swing.JFrame {

    /** Creates new form FrmParametro */
    public FrmParametro(JFrame parent) {
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

        txtEstado = new javax.swing.JTextField();
        txtValor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnInsertar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        txtDescripcion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("..::REGISTRO DE PARAMETRO::..");

        txtEstado.setBackground(new java.awt.Color(204, 255, 255));
        txtEstado.setEnabled(false);

        txtValor.setBackground(new java.awt.Color(204, 255, 255));
        txtValor.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Vrinda", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 255));
        jLabel1.setText("Código:");

        btnSalir.setFont(new java.awt.Font("Vrinda", 1, 14)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(0, 102, 0));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnInsertar.setFont(new java.awt.Font("Vrinda", 1, 14)); // NOI18N
        btnInsertar.setForeground(new java.awt.Color(0, 102, 0));
        btnInsertar.setText("Insertar");
        btnInsertar.setEnabled(false);
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        btnNuevo.setFont(new java.awt.Font("Vrinda", 1, 14)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(0, 102, 0));
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        txtDescripcion.setBackground(new java.awt.Color(204, 255, 255));
        txtDescripcion.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Vrinda", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 255));
        jLabel3.setText("Valor:");

        jLabel2.setFont(new java.awt.Font("Vrinda", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 255));
        jLabel2.setText("Descripción:");

        txtCodigo.setBackground(new java.awt.Color(204, 255, 255));
        txtCodigo.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Vrinda", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 255));
        jLabel4.setText("Estado:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(29, 29, 29))
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnInsertar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtEstado)
                        .addComponent(txtValor)
                        .addComponent(txtDescripcion)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnInsertar)
                    .addComponent(btnSalir))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
}//GEN-LAST:event_btnSalirActionPerformed

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        String codigo, descripcion, valor, estado;
        int rpta;
        codigo = txtCodigo.getText();
        descripcion = txtDescripcion.getText();
        valor = txtValor.getText();
        estado = txtEstado.getText();
        if(codigo != null && descripcion != null) {
            rpta = new ParametroBL().insertarParametro(codigo,descripcion,valor,estado);
            switch(rpta) {
                case 0:
                case 1:
                    limpiarTextos();
                    activar(false);
                    break;
                case 2:
                    txtCodigo.setText(null);
                    txtCodigo.requestFocus();
                    break;
                case 3:
                    limpiarTextos();
                    txtCodigo.requestFocus();
                    break;
            }
        } else
            showMessageDialog(this,"Debe digitar datos","Aviso",2);
}//GEN-LAST:event_btnInsertarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiarTextos();
        activar(true);
        txtCodigo.requestFocus();
}//GEN-LAST:event_btnNuevoActionPerformed
private void limpiarTextos() {
        txtCodigo.setText(null);
        txtDescripcion.setText(null);
        txtValor.setText(null);
        txtEstado.setText(null);
    }

    private void activar(boolean estado) {
        txtCodigo.setEnabled(estado);
        txtDescripcion.setEnabled(estado);
        txtValor.setEnabled(estado);
        txtEstado.setEnabled(estado);
        btnInsertar.setEnabled(estado);
        btnNuevo.setEnabled(!estado);
    }
    /**
     * @param args the command line arguments
     */
//     public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new FrmParametro(null).setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
