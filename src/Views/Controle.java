/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

/**
 *
 * @author Ana
 */
import java.sql.*;

public class Controle {
    public static Conexao db = new Conexao();
    ResultSet resultados;
    
    public boolean verifLogin(String email, String senha){
        try{
            resultados = db.consulta("SELECT * FROM Login WHERE email = "+email+";");
            System.out.println("chegou aqui");
            String senharesult=null;
            while(resultados.next()){
                System.out.println(resultados);
                senharesult = resultados.getString("senha");
            }
            System.out.println(senharesult);
            if(senharesult.equals(senha))
                    return true;
                else
                    return false;
        }
        catch(Exception e){
            return false;
        }
    }
}
