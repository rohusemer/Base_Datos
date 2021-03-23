
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
public class CFactura extends javax.swing.JFrame {
    conectar cc = new conectar();
    Connection cn = cc.getConnection();
    public static int idF;
    /**
     * Creates new form CFProveedor
     */
    public CFactura() {
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
        modelo.addColumn("Numero");
        modelo.addColumn("Fecha de Registro");
        modelo.addColumn("Decripcion");
        modelo.addColumn("Valor");  
        modelo.addColumn("Nombre");
        modelo.addColumn("Tipo Factura");
         
        
        
        tbFactura.setModel(modelo);
        String sql="";
        if (valor.equals("")){
            //sql = "SELECT p.codigo_p, p.empleado, p.proveedor, e.primer_nombre, pr.nombre FROM Pagos p, Empleado e,Proveedor pr WHERE e.id = p.empleado OR pr.id = p.proveedor GROUP BY p.codigo_p";
            sql ="SELECT * FROM(SELECT DISTINCT f.num_defactura, f.fecha_registro, f.descripcion, f.valor, UPPER(CONCAT(p.nombre,\" \",p.apellido)) as Nombre, 'Proveedor' AS Tipo"+
            " FROM factura_proveedor f INNER JOIN Proveedor p ON p.id = f.proveedor"+
            " UNION SELECT DISTINCT fv.num_defactura, fv.fecha_registro, fv.descripcion, fv.valor, UPPER(c.nombreCliente) as Nombre, 'Viaje' AS Tipo"+
            " FROM factura_viaje fv INNER JOIN Cliente c ON c.id = fv.cliente) as p"+
            " ORDER BY p.num_defactura";        
        } else {
            sql = "SELECT * FROM(SELECT DISTINCT f.num_defactura, f.fecha_registro, f.descripcion, f.valor, UPPER(CONCAT(p.nombre,\" \",p.apellido)) as Nombre, 'Proveedor' AS Tipo"+
            " FROM factura_proveedor f INNER JOIN Proveedor p ON p.id = f.proveedor"+
            " UNION SELECT DISTINCT fv.num_defactura, fv.fecha_registro, fv.descripcion, fv.valor, UPPER(c.nombreCliente) as Nombre, 'Viaje' AS Tipo"+
            " FROM factura_viaje fv INNER JOIN Cliente c ON c.id = fv.cliente) as p  HAVING p.Nombre like '%"+valor+"%'";
        }
    
        String [] datos = new String[6];
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                datos[5]=rs.getString(6);
                modelo.addRow(datos);
            }
            tbFactura.setModel(modelo);
        } catch (SQLException ex){
           Logger.getLogger(REmpleado.class.getName()).log(Level.SEVERE, null, ex); 

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
        jSplitPane1 = new javax.swing.JSplitPane();
        jButton3 = new javax.swing.JButton();
        jSplitPane2 = new javax.swing.JSplitPane();
        btnIda = new javax.swing.JButton();
        btnV = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbFactura = new javax.swing.JTable();
        lbt = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jbuscar = new javax.swing.JButton();
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

        jButton3.setText("Mostar Datos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jSplitPane1.setLeftComponent(jButton3);

        btnIda.setText("Viaje");
        btnIda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIdaActionPerformed(evt);
            }
        });
        jSplitPane2.setLeftComponent(btnIda);

        btnV.setText("Proveedor");
        btnV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVActionPerformed(evt);
            }
        });
        jSplitPane2.setRightComponent(btnV);

        jSplitPane1.setRightComponent(jSplitPane2);

        getContentPane().add(jSplitPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 280, 40));

        jScrollPane1.setComponentPopupMenu(jPopupMenu1);

        tbFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbFactura.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tbFactura);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 526, 160));

        lbt.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lbt.setForeground(new java.awt.Color(0, 0, 0));
        lbt.setText("CONSULTAS DE FACTURAS");
        getContentPane().add(lbt, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 340, 50));

        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });
        getContentPane().add(txtbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(464, 150, 90, -1));

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
        RVehiculo rv = new RVehiculo();
        rv.setVisible(true);
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

    private void btnIdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIdaActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelo= new DefaultTableModel();
        modelo.addColumn("Numero");
        modelo.addColumn("Fecha Registro");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Valor");
        modelo.addColumn("Articulo");
        modelo.addColumn("CodViaje");
        modelo.addColumn("CodCliente");
        modelo.addColumn("Nombre");

        tbFactura.setModel(modelo);
        String sql="SELECT * FROM(SELECT DISTINCT fv.num_defactura, fv.fecha_registro, fv.descripcion, fv.valor, fv.articulo, fv.viaje, fv.cliente,  UPPER(c.nombreCliente) as Nombre"+
            " FROM factura_viaje fv INNER JOIN Cliente c ON c.id = fv.cliente) as p ";
        String [] datos = new String[8];
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                datos[5]=rs.getString(6);
                datos[6]=rs.getString(7);
                datos[7]=rs.getString(8);
                modelo.addRow(datos);
            }
            tbFactura.setModel(modelo);
        } catch (SQLException ex){
            Logger.getLogger(REmpleado.class.getName()).log(Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_btnIdaActionPerformed

    private void btnVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelo= new DefaultTableModel();
        modelo.addColumn("Numero");
        modelo.addColumn("Fecha Registro");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Valor");
        modelo.addColumn("CodMObra");
        modelo.addColumn("CodProvedor");
        modelo.addColumn("Nombre");

        tbFactura.setModel(modelo);
        String sql="SELECT * FROM(SELECT DISTINCT f.num_defactura, f.fecha_registro, f.descripcion, f.valor, f.mano_obra, f.proveedor, UPPER(CONCAT(p.nombre,\" \",p.apellido)) as Nombre"+
            " FROM factura_proveedor f INNER JOIN Proveedor p ON p.id = f.proveedor) as p"+
            " GROUP BY p.num_defactura ORDER BY p.num_defactura";
        String [] datos = new String[7];
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                datos[5]=rs.getString(6);
                datos[6]=rs.getString(7);
                modelo.addRow(datos);
            }
            tbFactura.setModel(modelo);
        } catch (SQLException ex){
            Logger.getLogger(REmpleado.class.getName()).log(Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_btnVActionPerformed

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        EVehiculo ev = new EVehiculo();
        ev.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuscarActionPerformed
        // TODO add your handling code here:
        mostrardatos(txtbuscar.getText());
    }//GEN-LAST:event_jbuscarActionPerformed
    private int obtenerCod(){
        int fila=tbFactura.getSelectedRow();
        String tipo = tbFactura.getValueAt(fila,5).toString();
        //String nombre= cbId.getSelectedItem().toString();
        int id=0;
        if(tipo.equals("Viaje")){
            String sql = "SELECT p.num_defactura FROM(SELECT DISTINCT f.num_defactura, f.fecha_registro, f.descripcion, f.valor, UPPER(CONCAT(p.nombre,\" \",p.apellido)) as Nombre, 'Proveedor' AS Tipo"+
            " FROM factura_proveedor f INNER JOIN Proveedor p ON p.id = f.proveedor"+
            " UNION SELECT DISTINCT fv.num_defactura, fv.fecha_registro, fv.descripcion, fv.valor, UPPER(c.nombreCliente) as Nombre, 'Viaje' AS Tipo"+
            " FROM factura_viaje fv INNER JOIN Cliente c ON c.id = fv.cliente) as p  WHERE p.Tipo like '%"+tipo+"%'";
        try {
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                id=rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RPago.class.getName()).log(Level.SEVERE, null, ex);
        }
            return id;  
 
        }else if(tipo.equals("PROVEEDOR")) {
//
            String sql = "SELECT p.num_defactura FROM(SELECT DISTINCT f.num_defactura, f.fecha_registro, f.descripcion, f.valor, UPPER(CONCAT(p.nombre,\" \",p.apellido)) as Nombre, 'Proveedor' AS Tipo"+
            " FROM factura_proveedor f INNER JOIN Proveedor p ON p.id = f.proveedor"+
            " UNION SELECT DISTINCT fv.num_defactura, fv.fecha_registro, fv.descripcion, fv.valor, UPPER(c.nombreCliente) as Nombre, 'Viaje' AS Tipo"+
            " FROM factura_viaje fv INNER JOIN Cliente c ON c.id = fv.cliente) as p  WHERE p.Tipo like '%"+tipo+"%'";
        try {
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                id=rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RPago.class.getName()).log(Level.SEVERE, null, ex);
        }
            return id;  
        
        }
      
        return id;
    }
        
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        int fila=tbFactura.getSelectedRow();
        String tipo = tbFactura.getValueAt(fila,5).toString();
        idF = obtenerCod();
        //int cod1 = Integer.parseInt(cod);
        if(tipo.equals("Viaje")){
            try{
            PreparedStatement pst=cn.prepareStatement("DELETE FROM factura_viaje WHERE num_defactura='"+idF+"'");
            pst.executeUpdate();
            mostrardatos("");// TODO add your handling code here:
            } catch (Exception e){
            }
 
        }else if(tipo.equals("PROVEEDOR")) {
//
           try{
            PreparedStatement pst=cn.prepareStatement("DELETE FROM factura_proveedor WHERE num_defactura='"+idF+"'");
            pst.executeUpdate();
            mostrardatos("");// TODO add your handling code here:
            } catch (Exception e){
            } 
        
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
            java.util.logging.Logger.getLogger(CFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CFactura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIda;
    private javax.swing.JButton btnV;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jNuevo;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JMenuItem jPrincipla;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JButton jbuscar;
    private javax.swing.JMenuBar jmenu;
    private javax.swing.JLabel lbt;
    private javax.swing.JLabel tCE;
    private javax.swing.JTable tbFactura;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}
