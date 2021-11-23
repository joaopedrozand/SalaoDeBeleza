/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.bean.Cliente;
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
public class ClienteDAO {

    private final Connection connection;
   
    
     public ClienteDAO(Connection connection) {
         this.connection = connection;  
         

     }

   
     
     
    public void create(Cliente cliente){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
         
         try {
            stmt = con.prepareStatement("INSERT INTO cliente (nome,email,cidade)VALUES(?,?,?)");
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getCidade());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar!"+ex);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }
     
    
         public void update(Cliente cliente) {

        Connection con = Conexao.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE cliente SET nome = ? ,email = ?, cidade = ? WHERE id = ?");
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getCidade());
            stmt.setInt(4, cliente.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }
    
    /**
     * Deleta um objeto do banco de dados pelo id do servico passado
     * @param servico
     * @return 
     */
     public void delete(Cliente cliente) {

        Connection con = Conexao.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM cliente WHERE id = ?");
            stmt.setInt(1, cliente.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            Conexao.closeConnection(con, stmt);
        }

     }
        
    public List<Cliente> read(){

    Connection con = Conexao.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    List<Cliente> clientes = new ArrayList<>();
    
    try{
        stmt = con.prepareStatement("SELECT * FROM cliente");
        rs = stmt.executeQuery();
        
        while(rs.next()){
            Cliente cliente = new Cliente();
            
            cliente.setId(rs.getInt("id"));
            cliente.setNome(rs.getString("nome"));
            cliente.setEmail(rs.getString("email"));
            cliente.setCidade(rs.getString("cidade"));
            clientes.add(cliente);
        }
        
    }catch(SQLException ex){
        Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
    }finally{
        Conexao.closeConnection(con,stmt, rs);
    }
    
    return clientes;
    
}
    /**
     * Atualiza um Objeto no banco de dados
     * @param cliente
     * @return 
     */
        

    
    
    /**
     * Deleta um objeto do banco de dados pelo id do cliente passado
     * @param cliente
     * @return 
     */
   
    
    /**
     * Retorna um arraylist com todos os clientes do banco de dados
     * @return uma lista com todos os registros do banco
     */
    
    
    /**
     * Compara se dois objetos tem a propriedade id igual
     * @param cliente
     * @param clienteAComparar
     * @return verdadeiro caso os id forem iguais e falso se nao forem
     */
    
    
}
    

