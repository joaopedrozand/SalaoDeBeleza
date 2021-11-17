/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Helper;

import Model.bean.Usuario;
import Views.Login;

/**
 *
 * @author Ana
 */
public class LoginHelper {
    
    private final Login view;

    public LoginHelper(Login view) {
        this.view = view;
    }
    
    public Usuario obterModelo(){
        String nome = view.getPalavraUsuario().getText();
        String senha = view.getPalavraSenha().getText();
        
        Usuario modelo = new Usuario(0, nome, senha);
        return modelo;
    }
    
    public void setarModelo(Usuario modelo){
       String nome = modelo.getNome();
       String senha = modelo.getSenha();
       
       view.getPalavraUsuario().setText(nome);
       view.getPalavraSenha().setText(senha);
    }
    
    public void limparTela(){
       view.getPalavraUsuario().setText("");
       view.getPalavraSenha().setText("");
    }
}
