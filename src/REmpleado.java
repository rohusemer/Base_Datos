

import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class REmpleado extends javax.swing.JFrame {
    conectar cc = new conectar();
    Connection cn = cc.getConnection();
    String cid, cargo,PrimerNombre,SegundoNombre,PrimerApellido,SegundoApellido;
    String id1 = "";
    /**
     * Creates new form clientes
     */
    public REmpleado() {
        initComponents();
        mostrarId();
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
    private void mostrarId(){
     
        persona p = new persona();
        txtiD.setText(p.id);
        
        
    }
//    void mostrardatos(String valor){
//        DefaultTableModel modelo= new DefaultTableModel();
//        modelo.addColumn("ID");
//        modelo.addColumn("Primer Nombres");
//        modelo.addColumn("Segundo Nombres");
//        modelo.addColumn("Primer Apellidos");
//        modelo.addColumn("Segundo Nombres");
//        modelo.addColumn("Cargo");
//        tbEmpleados.setModel(modelo);
//        String sql="";
//        if (valor.equals("")){
//            sql = "SELECT * FROM Empleado";
//        } else {
//            sql = "SELECT * FROM Empleado WHERE id='"+valor+"'";
//        }
//    
//        String [] datos = new String[6];
//        try{
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            while(rs.next()){
//                datos[0]=rs.getString(1);
//                datos[1]=rs.getString(2);
//                datos[2]=rs.getString(3);
//                datos[3]=rs.getString(4);
//                datos[4]=rs.getString(5);
//                datos[5]=rs.getString(6);
//                modelo.addRow(datos);
//            }
//            tbEmpleados.setModel(modelo);
//        } catch (SQLException ex){
//           Logger.getLogger(REmpleado.class.getName()).log(Level.SEVERE, null, ex); 
//
//        }
//    }


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
        lb_idEmpleado = new javax.swing.JLabel();
        lb_Cargo = new javax.swing.JLabel();
        txtFcargo = new javax.swing.JTextField();
        lb_primerNombre = new javax.swing.JLabel();
        txtFPrimerNombre = new javax.swing.JTextField();
        lb_SegundoNombre = new javax.swing.JLabel();
        txtFSegundoNombre = new javax.swing.JTextField();
        lb_PrimerApellido = new javax.swing.JLabel();
        txtFPrimerApellido = new javax.swing.JTextField();
        lb_SegundoApellido = new javax.swing.JLabel();
        txtFSegundoApellido = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        txtiD = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jmenu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jNuevo = new javax.swing.JMenuItem();
        jPrincipla = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("REmpleado");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lb_titulo.setBackground(new java.awt.Color(0, 0, 0));
        lb_titulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lb_titulo.setText("REGISTRO DE EMPLEADOS");

        lb_idEmpleado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_idEmpleado.setForeground(new java.awt.Color(0, 0, 0));
        lb_idEmpleado.setText("ID:");

        lb_Cargo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_Cargo.setForeground(new java.awt.Color(0, 0, 0));
        lb_Cargo.setText("Cargo:");

        txtFcargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFcargoActionPerformed(evt);
            }
        });
        txtFcargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFcargoKeyTyped(evt);
            }
        });

        lb_primerNombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_primerNombre.setForeground(new java.awt.Color(0, 0, 0));
        lb_primerNombre.setText("Primer Nombres:");

        txtFPrimerNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFPrimerNombreActionPerformed(evt);
            }
        });
        txtFPrimerNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFPrimerNombreKeyTyped(evt);
            }
        });

        lb_SegundoNombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_SegundoNombre.setForeground(new java.awt.Color(0, 0, 0));
        lb_SegundoNombre.setText("Segundo Nombres:");

        txtFSegundoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFSegundoNombreActionPerformed(evt);
            }
        });
        txtFSegundoNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFSegundoNombreKeyTyped(evt);
            }
        });

        lb_PrimerApellido.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_PrimerApellido.setForeground(new java.awt.Color(0, 0, 0));
        lb_PrimerApellido.setText("Primer Apellidos:");

        txtFPrimerApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFPrimerApellidoActionPerformed(evt);
            }
        });
        txtFPrimerApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFPrimerApellidoKeyTyped(evt);
            }
        });

        lb_SegundoApellido.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_SegundoApellido.setForeground(new java.awt.Color(0, 0, 0));
        lb_SegundoApellido.setText("Segundo Apellidos:");

        txtFSegundoApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFSegundoApellidoActionPerformed(evt);
            }
        });
        txtFSegundoApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFSegundoApellidoKeyTyped(evt);
            }
        });

        btnguardar.setText("GUARDAR");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Consultar Registro");
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

        txtiD.setEditable(false);
        txtiD.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lb_PrimerApellido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFPrimerApellido))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_primerNombre)
                                    .addComponent(lb_idEmpleado))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFPrimerNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtiD))))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_Cargo)
                            .addComponent(lb_SegundoNombre)
                            .addComponent(lb_SegundoApellido))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFSegundoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFSegundoNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(txtFcargo)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(lb_titulo)))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lb_titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_idEmpleado)
                            .addComponent(lb_Cargo)
                            .addComponent(txtFcargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtiD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_primerNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFPrimerNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_SegundoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFSegundoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFPrimerApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_PrimerApellido)
                    .addComponent(txtFSegundoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_SegundoApellido))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnguardar)
                    .addComponent(btnActualizar))
                .addGap(20, 20, 20))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 620, 260));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/au2.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 6, 740, 490));

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
        persona in = new persona();
        in.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jNuevoActionPerformed

    private void txtFPrimerNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFPrimerNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFPrimerNombreActionPerformed

    private void txtFPrimerApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFPrimerApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFPrimerApellidoActionPerformed

    private void txtFSegundoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFSegundoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFSegundoNombreActionPerformed

    private void txtFSegundoApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFSegundoApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFSegundoApellidoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
//        conectar cc = new conectar();
//        Connection cn = cc.conexion();
//        
            //String cid, cargo,PrimerNombre,SegundoNombre,PrimerApellido,SegundoApellido;
            //id = txtFidEmpleado.getText();
            cid = txtiD.getText();
            cargo = txtFcargo.getText();
            PrimerNombre = txtFPrimerNombre.getText();
            SegundoNombre = txtFSegundoNombre.getText();
            PrimerApellido = txtFPrimerApellido.getText();
            SegundoApellido = txtFSegundoApellido.getText();
            
           PreparedStatement pst = null;
//           String sql = "INSERT INTO Empleado VALUES(?,?,?,?,?,?)";
            
            
            if(cid.equals("")||PrimerNombre.equals("")||SegundoNombre.equals("")||PrimerApellido.equals("")||SegundoApellido.equals("")||cargo.equals("")){
                javax.swing.JOptionPane.showMessageDialog(this,"Debe llenar todos los campos \n","AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                txtiD.requestFocus();

            
            }else {
                
                try{
                                       
                    pst=cn.prepareStatement("INSERT INTO Empleado(id,primer_nombre,segundo_nombre,primer_apeelido,segundo_apellido,cargo) VALUES(?,?,?,?,?,?)");
                    pst.setString(1,cid);//tfidPersona.getText());
                    pst.setString(2,PrimerNombre);
                    pst.setString(3,SegundoNombre);
                    pst.setString(4,PrimerApellido);
                    pst.setString(5,SegundoApellido);
                    pst.setString(6,cargo);     
                    
//                    JOptionPane.showMessageDialog(null, "Empleado"+ id +"Registrado" );

        
                    int a=pst.executeUpdate();
                    if(a>0){
                       
                        JOptionPane.showMessageDialog(null,"Registro exitoso");
                    }else{
                        JOptionPane.showMessageDialog(null,"Error al agregar");
                    }
            }catch(HeadlessException | SQLException ex){
                Logger.getLogger(REmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }        
                
  
                                      
                     
//                     if ( con != null ){ 
//                            System.out.println("Se ha establecido una conexión a la base de datos " +  
//                                               "\n " + url ); 
//
//                          //stmt = con.createStatement(); 
//                          stmt.executeUpdate("INSERT INTO Empleado VALUES('" + id + "','"+PrimerNombre+"','"+SegundoNombre+"','"+PrimerApellido+"','"+SegundoApellido+"','"+cargo+"')");
//                          System.out.println("Los valores han sido agregados a la base de datos ");
////                try {
//                    if (  cn != null ){
//                        pst = cn.prepareStatement(sql);
//                        pst.setString(1, id);
//                        pst.setString(2, PrimerNombre);
//                        pst.setString(3, SegundoNombre);
//                        pst.setString(4, PrimerApellido);
//                        pst.setString(5, SegundoApellido);
//                        pst.setString(6, cargo);
//                        
//                        JOptionPane.showMessageDialog(null, "Empleado"+ id +"Registrado" );
//                        
//                    }
                                      
                     
//                     if ( con != null ){ 
//                            System.out.println("Se ha establecido una conexión a la base de datos " +  
//                                               "\n " + url ); 
//
//                          //stmt = con.createStatement(); 
//                          stmt.executeUpdate("INSERT INTO Empleado VALUES('" + id + "','"+PrimerNombre+"','"+SegundoNombre+"','"+PrimerApellido+"','"+SegundoApellido+"','"+cargo+"')");
//                          System.out.println("Los valores han sido agregados a la base de datos ");
//
//                     }
                    
                     
//                } catch ( SQLException ex) {
//                   //ex.printStackTrace();
//                   //JOptionPane.showMessageDialog(null, "Coneccion -establecida");
//                   Logger.getLogger(REmpleado.class.getName()).log(Level.SEVERE, null, ex);
//
//                }    

                finally {
                    if (cn != null) {
                        try {
                            cn.close();
                            pst.close();
                        } catch ( SQLException e ) { 
                                 System.out.println( e.getMessage());
                        }
                    }
                }
        
         javax.swing.JOptionPane.showMessageDialog(this,"Registro exitoso! \n","AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }       
       this.txtiD.setText("");
       this.txtFPrimerNombre.setText("");
//        this.txtFidEmpleado.setText("");
//        this.txtFPrimerNombre.setText("");
        this.txtFSegundoNombre.setText("");
        this.txtFPrimerApellido.setText("");
        this.txtFSegundoApellido.setText("");
        this.txtFcargo.setText("");

        
    }//GEN-LAST:event_btnguardarActionPerformed

    private void txtFcargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFcargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFcargoActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:

//        try{
//            PreparedStatement pst=cn.prepareStatement("UPDATE Empleado SET primer_nombre='"+txtFPrimerNombre.getText()+
//                    "',segundo_nombre='"+txtFSegundoNombre.getText()+"',primer_apeelido='"+txtFPrimerApellido.getText()+
//                    "',segundo_apellido='"+txtFSegundoApellido.getText()+"',cargo='"+txtFcargo.getText()+"' WHERE id='"+
//                    txtFidEmpleado.getText()+"'");
//            id1=txtFidEmpleado.getText();
//            pst.executeUpdate();
//
//           // mostrardatos("");
//        }catch(Exception e){
//            System.out.print(e.getMessage());
//        }

        CEmpleado ce = new CEmpleado();
        ce.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtFPrimerNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFPrimerNombreKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if((c<'a' || c >'z') && (c<'A' || c> 'Z') && (c<' ' || c > ' ')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtFPrimerNombreKeyTyped

    private void txtFPrimerApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFPrimerApellidoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if((c<'a' || c >'z') && (c<'A' || c> 'Z') && (c<' ' || c > ' ')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtFPrimerApellidoKeyTyped

    private void txtFSegundoNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFSegundoNombreKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if((c<'a' || c >'z') && (c<'A' || c> 'Z') && (c<' ' || c > ' ')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtFSegundoNombreKeyTyped

    private void txtFcargoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFcargoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if((c<'a' || c >'z') && (c<'A' || c> 'Z') && (c<' ' || c > ' ')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtFcargoKeyTyped

    private void txtFSegundoApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFSegundoApellidoKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if((c<'a' || c >'z') && (c<'A' || c> 'Z') && (c<' ' || c > ' ')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtFSegundoApellidoKeyTyped

    private void btnActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarMouseClicked
    
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
            java.util.logging.Logger.getLogger(REmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(REmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(REmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(REmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new REmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jNuevo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem jPrincipla;
    private javax.swing.JMenuBar jmenu;
    private javax.swing.JLabel lb_Cargo;
    private javax.swing.JLabel lb_PrimerApellido;
    private javax.swing.JLabel lb_SegundoApellido;
    private javax.swing.JLabel lb_SegundoNombre;
    private javax.swing.JLabel lb_idEmpleado;
    private javax.swing.JLabel lb_primerNombre;
    private javax.swing.JLabel lb_titulo;
    private javax.swing.JTextField txtFPrimerApellido;
    private javax.swing.JTextField txtFPrimerNombre;
    private javax.swing.JTextField txtFSegundoApellido;
    private javax.swing.JTextField txtFSegundoNombre;
    private javax.swing.JTextField txtFcargo;
    private javax.swing.JTextField txtiD;
    // End of variables declaration//GEN-END:variables
}