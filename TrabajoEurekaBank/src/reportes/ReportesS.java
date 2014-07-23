/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Reportes.java
 *
 * Created on 14/08/2011, 07:54:43 PM
 */

package reportes;

import Imagenes.JFondo;
import entidades.Cliente;
import entidades.Cuenta;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import negocio.EmpleadoBL;
import negocio.SucursalBL;
import negocio.ClienteBL;
import negocio.CuentaBL;

/**
 *
 * @author David
 */
public class ReportesS extends javax.swing.JFrame {

    /** Creates new form Reportes */
    public ReportesS() {
        initComponents();
        setLocationRelativeTo(this);
        JFondo p=new JFondo(this);
        this.add(p,BorderLayout.CENTER);
        this.pack();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnReportarEmpleados = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnReportarSucursal = new javax.swing.JButton();
        btnReportarClientes = new javax.swing.JButton();
        btnReportesMoviEmpleado = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtCodigo = new javax.swing.JTextField();
        btnBuscarCuentas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstLista = new javax.swing.JList();
        btnReporteMoviCliente = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("REPOTES DE EMPLEADOS");

        btnReportarEmpleados.setFont(new java.awt.Font("Comic Sans MS", 1, 16));
        btnReportarEmpleados.setText("2. REPORTAR EMPLEADOS");
        btnReportarEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportarEmpleadosActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Comic Sans MS", 1, 16));
        jButton2.setText("SALIR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnReportarSucursal.setFont(new java.awt.Font("Comic Sans MS", 1, 16));
        btnReportarSucursal.setText("1. REPOTAR SUCURSALES");
        btnReportarSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportarSucursalActionPerformed(evt);
            }
        });

        btnReportarClientes.setFont(new java.awt.Font("Comic Sans MS", 1, 16));
        btnReportarClientes.setText("3. REPORTAR CLIENTES");
        btnReportarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportarClientesActionPerformed(evt);
            }
        });

        btnReportesMoviEmpleado.setFont(new java.awt.Font("Comic Sans MS", 1, 16));
        btnReportesMoviEmpleado.setText("4. REPORTAR MOVIMIENTOS DEL EMPLEADO");
        btnReportesMoviEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesMoviEmpleadoActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Codigo Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 1, 14))); // NOI18N

        txtCodigo.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        txtCodigo.setEnabled(false);

        btnBuscarCuentas.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnBuscarCuentas.setText("BUSCAR CUENTAS");
        btnBuscarCuentas.setEnabled(false);
        btnBuscarCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCuentasActionPerformed(evt);
            }
        });

        lstLista.setEnabled(false);
        jScrollPane1.setViewportView(lstLista);

        btnReporteMoviCliente.setFont(new java.awt.Font("Comic Sans MS", 1, 16));
        btnReporteMoviCliente.setText("5. REPORTAR MOVIMIENTOS DE LA CUENTA");
        btnReporteMoviCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteMoviClienteActionPerformed(evt);
            }
        });

        btnNuevo.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnNuevo.setText("NUEVO");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel2.setText("Cuentas del Cliente :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReporteMoviCliente)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(17, 17, 17))
                                    .addComponent(btnBuscarCuentas))))
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(176, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(153, 153, 153))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btnBuscarCuentas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReporteMoviCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(489, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReportesMoviEmpleado)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnReportarSucursal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReportarClientes, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnReportarEmpleados, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(153, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnReportarSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReportarEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReportarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReportesMoviEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReportarEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportarEmpleadosActionPerformed
        // TODO add your handling code here:
        new EmpleadoBL().ejecutarReporte();
    }//GEN-LAST:event_btnReportarEmpleadosActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnReportarSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportarSucursalActionPerformed
//        String codigo = "001";
        new SucursalBL().ejecutarReporte();
}//GEN-LAST:event_btnReportarSucursalActionPerformed

    private void btnReportarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportarClientesActionPerformed
        // TODO add your handling code here:
        new ClienteBL().ejecutarReporte();
    }//GEN-LAST:event_btnReportarClientesActionPerformed

    private void btnReportesMoviEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesMoviEmpleadoActionPerformed
        String codigo= JOptionPane.showInputDialog("Ingrese Codigo");
        new EmpleadoBL().ejecutarReporteMov(codigo);

    }//GEN-LAST:event_btnReportesMoviEmpleadoActionPerformed

    private void btnReporteMoviClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteMoviClienteActionPerformed
      if(!lstLista.isSelectionEmpty()){//devuelve true si no se selecciona nada
             new ClienteBL().ejecutarReporteMov(arr[lstLista.getSelectedIndex()]);
        }else
             JOptionPane.showMessageDialog(null, "Selccione una cuenta de la Lista", "Error", 0);
    }//GEN-LAST:event_btnReporteMoviClienteActionPerformed

    private void btnBuscarCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCuentasActionPerformed
        lstLista.setEnabled(true);
        String codigo = txtCodigo.getText();
        CuentaBL cbl= new CuentaBL();
            lista= cbl.listarCuentaxCliente(2, codigo);
            if(lista!=null){
                arr= new String[lista.size()];
                Iterator<Cuenta> iterador= lista.iterator();
                Cuenta  cuenta =null;
                int i=0;
                while(iterador.hasNext()){
                    cuenta= iterador.next();
                    arr[i]=cuenta.getCuenCodigo();
                    i++;
                }
                lstLista.setListData(arr);
            }else
               JOptionPane.showMessageDialog(null, "Datos no validos", "Error", 0);

            txtCodigo.setEnabled(false);
            btnBuscarCuentas.setEnabled(false);
    }//GEN-LAST:event_btnBuscarCuentasActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        txtCodigo.setEnabled(true);
        txtCodigo.setText("");
        btnBuscarCuentas.setEnabled(true);
        lstLista.setEnabled(false);
        lstLista.setListData( arr= new String[lista.size()]);
    }//GEN-LAST:event_btnNuevoActionPerformed

    /**
    * @param args the command line arguments
    */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ReportesS().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarCuentas;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnReportarClientes;
    private javax.swing.JButton btnReportarEmpleados;
    private javax.swing.JButton btnReportarSucursal;
    private javax.swing.JButton btnReporteMoviCliente;
    private javax.swing.JButton btnReportesMoviEmpleado;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lstLista;
    private javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables
    ArrayList<Cuenta> lista =  new ArrayList<Cuenta>();
     String[] arr;
}
