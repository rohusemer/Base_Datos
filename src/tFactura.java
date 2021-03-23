
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class tFactura extends javax.swing.JFrame {

    /**
     * Creates new form Pagos
     */
    public tFactura() {
        initComponents();
        this.setLocationRelativeTo(null);
        cerrar();
    }
    public void cerrar(){
        try{
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e){
                    confirmarSalida();
                }
            });
            this.setVisible(true);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void confirmarSalida(){
        int valor1 = JOptionPane.showConfirmDialog(this,"¿Esta seguro de salir de la Aplicacion?","Advertencia",JOptionPane.YES_NO_OPTION);
        if(valor1 == JOptionPane.YES_OPTION){
//            JOptionPane.showMessageDialog(null,"GRacias por su visita!","Gracias", JOptionPane.INFORMATION_MESSAGE);
//            System.exit(0);
            Inicio in = new Inicio();
            in.setVisible(true);
            this.setVisible(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAceptar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbPersona = new javax.swing.JLabel();
        jmenu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jPrincipla = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAceptar.setText("Viaje");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 140, -1));

        jButton1.setText("Proveedores");
        jButton1.setMaximumSize(new java.awt.Dimension(75, 32));
        jButton1.setMinimumSize(new java.awt.Dimension(75, 32));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 150, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("SELECCIONE EL TIPO DE FACTURA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 260, 30));

        lbPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/au2.jpg"))); // NOI18N
        getContentPane().add(lbPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 200));

        jMenu1.setText("Archivo");

        jPrincipla.setText("Menu");
        jPrincipla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPrinciplaActionPerformed(evt);
            }
        });
        jMenu1.add(jPrincipla);

        jmenu.add(jMenu1);

        setJMenuBar(jmenu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        RFProveedor rfp = new RFProveedor();
        rfp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        RFViaje rfv = new RFViaje();
        rfv.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void jPrinciplaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPrinciplaActionPerformed
        // TODO add your handling code here:
        Inicio in = new Inicio();
        in.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jPrinciplaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(tFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tFactura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jPrincipla;
    private javax.swing.JMenuBar jmenu;
    private javax.swing.JLabel lbPersona;
    // End of variables declaration//GEN-END:variables
}
