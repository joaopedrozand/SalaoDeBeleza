/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Ana
 */
public class Conexao extends Config{
    
    public Connection conn;
    public Statement stm;
    public ResultSet rs;
    
    
    public static Connection getConnection(){
        try{
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        }catch(ClassNotFoundException | SQLException ex){
           throw new RuntimeException("Erro na conexão: ", ex);
        }
    }
    
    public void executaSQL(String sql){
        try{
            stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY );
            rs = stm.executeQuery(sql);
        }catch(SQLException ex){
            //JOptionPane.showMessageDialog(null, "Erro de ExecutaSQL!\n" + ex.getMessage());
        }
    }
    
    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

       
    public static void closeConnection(Connection con, PreparedStatement stmt) {

        closeConnection(con);

        try {

            if (stmt != null) {
                stmt.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {

        closeConnection(con, stmt);

        try {

            if (rs != null) {
                rs.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

}
