
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

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
public class conectar {
    Connection conectar=null;
    public static Session sesion=null;
    
    public static void serverConnection(){
        try{
            String usuario="root";
            String contraseña="root";
            String host="127.0.0.1";
            int localport=3366;
            int remoteport=3306;
            connectionJSch(usuario,contraseña,host,localport,remoteport);    
        }catch(JSchException j){
            j.printStackTrace();
           
        }  
    }
    public static void connectionJSch(String SSHuser,String SSHpass,String SSHhost,int localport,int remoteport) throws JSchException{
        JSch js=new JSch();
        sesion=js.getSession(SSHuser,SSHhost,22);
        sesion.setPassword(SSHpass);
        Properties config= new Properties();
        config.put("StrictHostKeyChecking","no");
        sesion.setConfig(config);
        sesion.connect();
        sesion.setPortForwardingL(localport,SSHhost,remoteport);
        
    }
    public conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectog9?useTimezone=True&serverTimezone=UTC", "root", "root");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error");
            System.out.println(e.getMessage());
        }
    }
    public static boolean ValidarUsuario(String Usuario, String contraseña) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectog9?useTimezone=True&serverTimezone=UTC", Usuario, contraseña);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public Connection getConnection() {
        return conectar;
    }

    public void desconectar() {
        conectar = null;
    }

    
//    public Connection conexion(){
//        try {
//            Class.forName("com.mysql.jdbc.Driver");//.newInstance();
//            conectar=DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectog9","root","root");
//            //JOptionPane.showMessageDialog(null, "Conectada");
//        } catch ( SQLException e) {
//            //System.out.print(e.getMessage());
//            JOptionPane.showMessageDialog(null, "Error Base de Datos no Conectada");
//        } catch ( ClassNotFoundException ex){
//            
//        } 
//        return conectar;
//    }
}
