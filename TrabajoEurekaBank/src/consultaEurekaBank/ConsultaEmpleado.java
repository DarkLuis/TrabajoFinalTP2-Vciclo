/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ConsultaEmpleado.java
 *
 * Created on 14/08/2011, 07:27:19 AM
 */

package consultaEurekaBank;
import Imagenes.JFondo2;
import java.awt.BorderLayout;
import Asignacion.InsertarA;
import Movimiento.InsertarM;
import cuenta.InsertarC;
import empleado.BuscarE;
import empleado.EliminarE;
import empleado.InsertarE;
import static javax.swing.JOptionPane.showMessageDialog;
/**
 *
 * @author David
 */
public class ConsultaEmpleado extends javax.swing.JFrame {

    /** Creates new form ConsultaEmpleado */
    public ConsultaEmpleado() {
        initComponents();
        setLocationRelativeTo(null);
        JFondo2 p=new JFondo2(this);
        this.add(p,BorderLayout.CENTER);
        this.pack();
    }


   //cuando entremos en modo usuario Empleado.
    public void InavilitarOpciones(boolean estado,String codigo){
        jmInsertarEmpleado.setEnabled(estado);
        jmBuscarEmpleado.setEnabled(estado);
        jmEliminarEmpleado.setEnabled(estado);

        CodigoEmpl= codigo;
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
        jPanel1 = new javax.swing.JPanel();
        btnIr = new javax.swing.JButton();
        rbtCrearCuenta = new javax.swing.JRadioButton();
        rbtCrearAsignacion = new javax.swing.JRadioButton();
        rbtAgregarMovimiento = new javax.swing.JRadioButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmInsertarEmpleado = new javax.swing.JMenuItem();
        jmBuscarEmpleado = new javax.swing.JMenuItem();
        jmEliminarEmpleado = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Empleados");

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ELIJA UNA OPCION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 14))); // NOI18N

        btnIr.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnIr.setText("<< IR >>");
        btnIr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIrActionPerformed(evt);
            }
        });

        rbtCrearCuenta.setBackground(new java.awt.Color(102, 153, 255));
        buttonGroup2.add(rbtCrearCuenta);
        rbtCrearCuenta.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        rbtCrearCuenta.setText("1. CREAR NUEVA CUENTA");
        rbtCrearCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtCrearCuentaActionPerformed(evt);
            }
        });

        rbtCrearAsignacion.setBackground(new java.awt.Color(102, 153, 255));
        buttonGroup2.add(rbtCrearAsignacion);
        rbtCrearAsignacion.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        rbtCrearAsignacion.setText("2. AGREGAR NUEVA ASIGNACION");
        rbtCrearAsignacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtCrearAsignacionActionPerformed(evt);
            }
        });

        rbtAgregarMovimiento.setBackground(new java.awt.Color(102, 153, 255));
        buttonGroup2.add(rbtAgregarMovimiento);
        rbtAgregarMovimiento.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        rbtAgregarMovimiento.setText("3. AGREGAR MOVIMIENTO");
        rbtAgregarMovimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtAgregarMovimientoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rbtAgregarMovimiento)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtCrearCuenta)
                            .addComponent(rbtCrearAsignacion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(btnIr)
                        .addGap(42, 42, 42))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rbtCrearCuenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtCrearAsignacion))
                    .addComponent(btnIr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtAgregarMovimiento)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jMenu1.setForeground(new java.awt.Color(0, 0, 204));
        jMenu1.setText("TABLA EMPLEADOS");

        jmInsertarEmpleado.setFont(new java.awt.Font("Comic Sans MS", 1, 14));
        jmInsertarEmpleado.setText("Insertar ");
        jmInsertarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmInsertarEmpleadoActionPerformed(evt);
            }
        });
        jMenu1.add(jmInsertarEmpleado);

        jmBuscarEmpleado.setFont(new java.awt.Font("Comic Sans MS", 1, 14));
        jmBuscarEmpleado.setText("Buscar ");
        jmBuscarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmBuscarEmpleadoActionPerformed(evt);
            }
        });
        jMenu1.add(jmBuscarEmpleado);

        jmEliminarEmpleado.setFont(new java.awt.Font("Comic Sans MS", 1, 14));
        jmEliminarEmpleado.setText("Eliminar ");
        jmEliminarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmEliminarEmpleadoActionPerformed(evt);
            }
        });
        jMenu1.add(jmEliminarEmpleado);

        jMenuBar1.add(jMenu1);

        jMenu2.setForeground(new java.awt.Color(0, 0, 204));
        jMenu2.setText("SALIR");

        jMenuItem4.setFont(new java.awt.Font("Comic Sans MS", 2, 14));
        jMenuItem4.setText("SALIR");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmInsertarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmInsertarEmpleadoActionPerformed
        // TODO add your handling code here:
        InsertarE Ie = new InsertarE();
        Ie.setVisible(true);

    }//GEN-LAST:event_jmInsertarEmpleadoActionPerformed

    private void jmBuscarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmBuscarEmpleadoActionPerformed
        // TODO add your handling code here:
        BuscarE Be= new BuscarE();
        Be.setVisible(true);

    }//GEN-LAST:event_jmBuscarEmpleadoActionPerformed

    private void jmEliminarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmEliminarEmpleadoActionPerformed
        // TODO add your handling code here:
        EliminarE Ee= new EliminarE();
        Ee.setVisible(true);

}//GEN-LAST:event_jmEliminarEmpleadoActionPerformed

    private void btnIrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrActionPerformed
        // TODO add your handling code here:
       if(rbtCrearCuenta.isSelected()){
           Ic.setVisible(true);
           Ic.AgregarCodigoEmpl(CodigoEmpl);
        }
       if(rbtCrearAsignacion.isSelected()){
           Ia.setVisible(true);
           Ia.AgregarCodigoEmpl(CodigoEmpl);
        }
       if(rbtAgregarMovimiento.isSelected()){
           Im.setVisible(true);
           Im.AgregarCodigoEmpl(CodigoEmpl);
        }

        btnIr.setEnabled(false);
    }//GEN-LAST:event_btnIrActionPerformed

    private void rbtCrearCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtCrearCuentaActionPerformed
        // TODO add your handling code here:
        if(!Ia.isVisible() && !Im.isVisible()){    // verifica q la ventana inserrtat asignar este en false
            btnIr.setEnabled(true);
        }else
             showMessageDialog(null,"Esta abierta una ventana", "Error", 0);

    }//GEN-LAST:event_rbtCrearCuentaActionPerformed

    private void rbtCrearAsignacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtCrearAsignacionActionPerformed
        // TODO add your handling code here:
        if( !Ic.isVisible()&&!Im.isVisible()){   // verifica q la ventana inserrtat cuenta este en false
            btnIr.setEnabled(true);
        }else
             showMessageDialog(null,"Esta abierta una ventana", "Error", 0);
    }//GEN-LAST:event_rbtCrearAsignacionActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void rbtAgregarMovimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtAgregarMovimientoActionPerformed
         if( !Ic.isVisible()&&!Ia.isVisible()){   // verifica q la ventana inserrtat cuenta este en false
            btnIr.setEnabled(true);
           }else
             showMessageDialog(null,"Esta abierta una ventana", "Error", 0);
    }//GEN-LAST:event_rbtAgregarMovimientoActionPerformed

    /**
    * @param args the command line arguments
    */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ConsultaEmpleado().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIr;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem jmBuscarEmpleado;
    private javax.swing.JMenuItem jmEliminarEmpleado;
    private javax.swing.JMenuItem jmInsertarEmpleado;
    private javax.swing.JRadioButton rbtAgregarMovimiento;
    private javax.swing.JRadioButton rbtCrearAsignacion;
    private javax.swing.JRadioButton rbtCrearCuenta;
    // End of variables declaration//GEN-END:variables
        InsertarC Ic= new InsertarC();
        InsertarA Ia= new InsertarA();
        InsertarM Im= new InsertarM();
       FormPrincipal fp= new FormPrincipal();
       private String CodigoEmpl;
}
