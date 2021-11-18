/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.bean;

import java.util.Date;

/**
 *
 * @author Ana
 */
public class Usuario {
    
    private String senha;
    private String login;

    public Usuario(String login, String senha) {
        this.senha = senha;
        this.login = login;
    }

    

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }



    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

   
    
    
}
