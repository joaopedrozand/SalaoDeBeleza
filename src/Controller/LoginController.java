/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Model.DAO.UsuarioDAO;
import Model.bean.Usuario;
import Views.Conexao;
import Views.Login;
import Views.Menu;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ana
 */
public class LoginController {

   private Login view;

    public LoginController(Login view) {
        this.view = view;
    }

    public boolean autenticar() throws SQLException {
        //Busca usuario
        String login = view.getCaixaUsuario().getText();
        String senha = view.getCaixaSenha().getText();
        
        Usuario usuarioAutenticar = new Usuario(login,senha);
        
        //Verifica se existe no banco de dados
        Connection con = Conexao.getConnection();
        UsuarioDAO usuarioDao = new UsuarioDAO(con);
        
        boolean existe = usuarioDao.existeNoBancoPorUsuarioESenha(usuarioAutenticar);
        
        //Se existe vai para o menu
        if(existe){
            Menu telaMenu = new Menu();
            telaMenu.setVisible(true);
            return true;
        }else{
            JOptionPane.showMessageDialog(view, "Usuário ou senha inválidos");
            return false;
        }
        
        
    }
    
    
}
