/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.bean.Usuario;
import Views.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ana
 */
public class UsuarioDAO {
    
    
    private final Connection connection;
    
     public UsuarioDAO(Connection connection) {
         this.connection = connection;   
     }
     
     public void create(Usuario usuario){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
         
         try {
            stmt = con.prepareStatement("INSERT INTO login (usuario,senha)VALUES(?,?)");
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getSenha());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar!"+ex);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }
     }

