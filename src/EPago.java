
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
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
public class EPago extends javax.swing.JFrame {
     conectar cc = new conectar();
    Connection cn = cc.getConnection();
    public static String tipo,idTipo,idc;
    /**
     * Creates new form EPago
     */
    public EPago() {
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
            JOptionPane.showMessageDialog(null,"GRacias por su visita!","Gracias", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
    public void mostrari(JComboBox cbTipo, JComboBox cbId){
        //tipo = cbTipo.getSelectedItem().toString();
        //idTipo = cbId.getSelectedItem().toString();
//        DefaultComboBoxModel modelo= new DefaultComboBoxModel();
//        cbId.setModel(modelo);
        cbId.removeAllItems();
        switch (cbTipo.getSelectedItem().toString()){
           
            case "EMPLEADO":
                String sql = "SELECT * FROM Empleado";
        
                try{
                    Statement st = cn.createStatement();
                    ResultSet rs = st.executeQuery(sql);
                    //cbId.removeAllItems();
                    while(rs.next()){
                        String nom = rs.getString(2);
                        String spl = rs.getString(4);
        //                 if(cod.length()==10){
                             cbId.addItem(nom + " " + spl);
        //                 }   
                    }        
                } catch (SQLException ex) {
                    Logger.getLogger(REmpleado.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "PROVEEDOR":
                String sq2 = "SELECT * FROM Proveedor";
        
                try{
                    Statement st = cn.createStatement();
                    ResultSet rs = st.executeQuery(sq2);
                    //cbId.removeAllItems();
                    while(rs.next()){
                        String nom = rs.getString(2);
                        String spl = rs.getString(3);
        //                 if(cod.length()==10){
                             cbId.addItem(nom + " " + spl);
        //                 }   
                    }        
                } catch (SQLException ex) {
                    Logger.getLogger(REmpleado.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            default:
                throw new AssertionError();
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

        jPanel1 = new javax.swing.JPanel();
        lb_titulo = new javax.swing.JLabel();
        lb_primerNombre = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox<>();
        lb_idEmpleado1 = new javax.swing.JLabel();
        cbId = new javax.swing.JComboBox<>();
        jSplitPane1 = new javax.swing.JSplitPane();
        btnguardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jmenu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jnuevo = new javax.swing.JMenuItem();
        jPrincipla = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EPago");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lb_titulo.setBackground(new java.awt.Color(0, 0, 0));
        lb_titulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lb_titulo.setText("ACTUALIZAR PAGOS");

        lb_primerNombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_primerNombre.setForeground(new java.awt.Color(0, 0, 0));
        lb_primerNombre.setText("ID:");

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EMPLEADO", "PROVEEDOR" }));
        cbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoActionPerformed(evt);
            }
        });

        lb_idEmpleado1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_idEmpleado1.setForeground(new java.awt.Color(0, 0, 0));
        lb_idEmpleado1.setText("Tipo:");

        cbId.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbIdItemStateChanged(evt);
            }
        });
        cbId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbIdActionPerformed(evt);
            }
        });

        btnguardar.setText("ELIMINAR");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        jSplitPane1.setLeftComponent(btnguardar);

        btnActualizar.setText("CONSULTAR");
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarMouseClicked(evt);
            }
        });
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jSplitPane1.setRightComponent(btnActualizar);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lb_idEmpleado1)
                        .addGap(18, 18, 18)
                        .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lb_primerNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbId, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(111, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lb_titulo)
                        .addGap(104, 104, 104))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lb_titulo)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_idEmpleado1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_primerNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 460, 250));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/au2.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 6, 740, 490));

        jMenu1.setText("Archivo");

        jnuevo.setText("Nuevo Ingreso");
        jnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jnuevoActionPerformed(evt);
            }
        });
        jMenu1.add(jnuevo);

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

    private void jPrinciplaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPrinciplaActionPerformed
        // TODO add your handling code here:
        Inicio in = new Inicio();
        in.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jPrinciplaActionPerformed

    
    private String obtenerCod(){
        String nombre= cbId.getSelectedItem().toString();
        String id="";
        String sql = "SELECT p.p.codigo_p FROM(SELECT DISTINCT p.codigo_p, p.empleado, UPPER(CONCAT(e.primer_nombre,\" \",e.primer_apeelido)) as Nombre, 'Empleados'"+
            " FROM Pagos p INNER JOIN Empleado e ON e.id = p.empleado"+
            " UNION SELECT DISTINCT p.codigo_p, p.proveedor,UPPER(CONCAT(pr.nombre,\" \",pr.apellido)) as Nombre, 'Proveedor'"+
            " FROM Pagos p INNER JOIN Proveedor pr ON pr.id = p.proveedor) as p  WHERE p.Nombre = '"+nombre+"'";
        try {
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                id=rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RPago.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;  
    } 
    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        
        idc = obtenerCod();
        try{
            PreparedStatement pst=cn.prepareStatement("DELETE FROM Pagos WHERE codigo_p='"+idc+"'");
            int a = pst.executeUpdate();
            if(a>0){
                JOptionPane.showMessageDialog(null,"Registro eliminado");
            }else{
                JOptionPane.showMessageDialog(null,"Error al eliminar");
            }
            mostrari(cbTipo,cbId);// TODO add your handling code here:
        } catch (Exception e){
        }  
    
   
    }//GEN-LAST:event_btnguardarActionPerformed

    private void cbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoActionPerformed
        // TODO add your handling code here:
        mostrari(cbTipo,  cbId);
    }//GEN-LAST:event_cbTipoActionPerformed

    private void cbIdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbIdItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_cbIdItemStateChanged

    private void cbIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbIdActionPerformed
        // TODO add your handling code here:
        //mostrarId(cbTipo.getSelectedItem().toString());
    }//GEN-LAST:event_cbIdActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

        CPago cp = new CPago();
        cp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarMouseClicked

    private void jnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jnuevoActionPerformed
        // TODO add your handling code here:
        RPago rp =  new RPago();
        rp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jnuevoActionPerformed

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
            java.util.logging.Logger.getLogger(EPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EPago().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JComboBox<String> cbId;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem jPrincipla;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JMenuBar jmenu;
    private javax.swing.JMenuItem jnuevo;
    private javax.swing.JLabel lb_idEmpleado1;
    private javax.swing.JLabel lb_primerNombre;
    private javax.swing.JLabel lb_titulo;
    // End of variables declaration//GEN-END:variables
}
