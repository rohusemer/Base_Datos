
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class CManoObra extends javax.swing.JFrame {
    conectar cc = new conectar();
    Connection cn = cc.getConnection();
    /**
     * Creates new form CManoObra
     */
    public CManoObra() {
        initComponents();
        mostrardatos("");
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
            JOptionPane.showMessageDialog(null,"GRacias por su visita!","Gracias", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
            
        }
    }
    void mostrardatos(String valor){
        DefaultTableModel modelo= new DefaultTableModel();
        modelo.addColumn("Cod");
        modelo.addColumn("Mantenimiento");
        modelo.addColumn("Repuesto");
        modelo.addColumn("Vehiculo");
        modelo.addColumn("Fecha Mantenimiento"); 
        
        tbMantenimiento.setModel(modelo);
        String sql="";
        if (valor.equals("")){
            //sql = "SELECT p.codigo_p, p.empleado, p.proveedor, e.primer_nombre, pr.nombre FROM Pagos p, Empleado e,Proveedor pr WHERE e.id = p.empleado OR pr.id = p.proveedor GROUP BY p.codigo_p";
            sql ="SELECT * FROM Mano_Obra";        
        } else {
            sql = "SELECT * FROM Mano_Obra WHERE mantenimiento like '%"+valor+"%' OR repuesto like '%"+valor+"%' or matricula like '%"+valor+"%' or fecha_m like '%"+valor+"%'";
        }
    
        String [] datos = new String[5];
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(5);
                datos[4]=rs.getString(6);
//                datos[5]=rs.getString(6);
//                datos[6]=rs.getString(7);
                modelo.addRow(datos);
            }
            tbMantenimiento.setModel(modelo);
        } catch (SQLException ex){
           Logger.getLogger(CManoObra.class.getName()).log(Level.SEVERE, null, ex); 

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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMantenimiento = new javax.swing.JTable();
        lbt = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jbuscar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        tCE = new javax.swing.JLabel();
        jmenu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jNuevo = new javax.swing.JMenuItem();
        jPrincipla = new javax.swing.JMenuItem();

        jMenuItem2.setText("Eliminar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setComponentPopupMenu(jPopupMenu1);

        tbMantenimiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbMantenimiento.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tbMantenimiento);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 526, 170));

        lbt.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lbt.setForeground(new java.awt.Color(0, 0, 0));
        lbt.setText("CONSULTAS DE MANTENIMIENTOS");
        getContentPane().add(lbt, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 430, 50));

        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });
        getContentPane().add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, 90, -1));

        jButton1.setText("Editar");
        jButton1.setMaximumSize(new java.awt.Dimension(106, 32));
        jButton1.setMinimumSize(new java.awt.Dimension(106, 32));
        jButton1.setPreferredSize(new java.awt.Dimension(106, 32));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 420, -1, 40));

        jbuscar.setText("Buscar");
        jbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuscarActionPerformed(evt);
            }
        });
        getContentPane().add(jbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, 80, 40));

        jButton3.setText("Mostar Datos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, -1, 38));

        tCE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/au2.jpg"))); // NOI18N
        getContentPane().add(tCE, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 490));

        jMenu1.setText("Archivo");

        jNuevo.setText("Nuevo Ingreso");
        jNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNuevoActionPerformed(evt);
            }
        });
        jMenu1.add(jNuevo);

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

    private void jNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNuevoActionPerformed
        // TODO add your handling code here:
        RManoObra rmo = new RManoObra();
        rmo.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jNuevoActionPerformed

    private void jPrinciplaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPrinciplaActionPerformed
        // TODO add your handling code here:
        Inicio in = new Inicio();
        in.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jPrinciplaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        mostrardatos("");
        this.txtbuscar.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        EManoObra emo = new EManoObra();
        emo.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuscarActionPerformed
        // TODO add your handling code here:
        mostrardatos(txtbuscar.getText());
    }//GEN-LAST:event_jbuscarActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        int fila=tbMantenimiento.getSelectedRow();
        String cod = tbMantenimiento.getValueAt(fila,0).toString();
        int cod1 = Integer.parseInt(cod);
        try{
            PreparedStatement pst=cn.prepareStatement("DELETE FROM Mano_Obra WHERE cod='"+cod1+"'");
            pst.executeUpdate();
            mostrardatos("");// TODO add your handling code here:
        } catch (Exception e){
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(CManoObra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CManoObra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CManoObra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CManoObra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CManoObra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jNuevo;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JMenuItem jPrincipla;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbuscar;
    private javax.swing.JMenuBar jmenu;
    private javax.swing.JLabel lbt;
    private javax.swing.JLabel tCE;
    private javax.swing.JTable tbMantenimiento;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}
