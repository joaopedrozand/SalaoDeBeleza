/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


/**
 *
 * @author Ana
 */
public class Conexao extends Config{
    
    public Connection conn = null;
    
    public boolean getConnection(){
        try{
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USUARIO, SENHA);
            return true;
        }catch(ClassNotFoundException erro){
            return false;
        }catch(SQLException erro){
            return false;
        }
    }
    
    public void close(){
        try{
            conn.close();
        }catch(SQLException erro){
            
        }
    }
}
