/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.bean.Servico;
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
public class ServicoDAO {
    
      private final Connection connection;
  
       public ServicoDAO(Connection connection) {
         this.connection = connection;  
         

     }

    public ServicoDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    /**
     * Insere um servico dentro do banco de dados
     * @param servico exige que seja passado um objeto do tipo servico
     */
    public void create(Servico servico){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO servico (nome,valor)VALUES(?,?)");
            stmt.setString(1, servico.getNome());
            stmt.setDouble(2, servico.getValor());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar!"+ex);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }
    
    
        
    
    /**
     * Atualiza um Objeto no banco de dados
     * @param servico
     * @return 
     */
    public void update(Servico servico) {

        Connection con = Conexao.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE servico SET nome = ? ,valor = ? WHERE id = ?");
            stmt.setString(1, servico.getNome());
            stmt.setDouble(2, servico.getValor());
            stmt.setInt(3, servico.getId());

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
     public void delete(Servico servico) {

        Connection con = Conexao.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM servico WHERE nome = ?");
            stmt.setString(1, servico.getNome());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            Conexao.closeConnection(con, stmt);
        }

    }

     public List<Servico> read(){

    Connection con = Conexao.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    List<Servico> servicos = new ArrayList<>();
    
    try{
        stmt = con.prepareStatement("SELECT * FROM servico");
        rs = stmt.executeQuery();
        
        while(rs.next()){
            Servico servico = new Servico();
            
            servico.setId(rs.getInt("id"));
            servico.setNome(rs.getString("nome"));
            servico.setValor(rs.getDouble("valor"));
            servicos.add(servico);
        }
        
    }catch(SQLException ex){
        Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
    }finally{
        Conexao.closeConnection(con,stmt, rs);
    }
    
    return servicos;
    
}
     
}


    
    /**
     * Retorna um arraylist com todos os servicos do banco de dados
     * @return uma lista com todos os registros do banco
     */
    /*public ArrayList<Servico> selectAll(){
        return Banco.servico;
    }
    
    /**
     * Compara se dois objetos tem a propriedade id igual
     * @param servico
     * @param servicoAComparar
     * @return verdadeiro caso os id forem iguais e falso se nao forem
     */
    /*private boolean idSaoIguais(Servico servico, Servico servicoAComparar) {
        return servico.getId() ==  servicoAComparar.getId();
    }*/
    