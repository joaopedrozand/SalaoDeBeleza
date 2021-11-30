/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.bean.Agendamento;
import Model.bean.Cliente;
import Model.bean.Servico;
import Views.Conexao;
import java.sql.Connection;
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
public class AgendamentoDAO {
    
     private final Connection connection;
   
    
     public AgendamentoDAO(Connection connection) {
         this.connection = connection;  
     }
     
     public void create(Agendamento agendamento){
        Connection con = Conexao.getConnection();
        PreparedStatement stmt = null;
         try {
            stmt = con.prepareStatement("INSERT INTO agendamento (nome_cliente, nome_servico, valor, data, hora)VALUES('"+agendamento.getNome_Cliente()+"','"+agendamento.getNome_Servico()+"','"+agendamento.getValor()+"','"+agendamento.getData()+"','"+agendamento.getHora()+"');");
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Agendado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao agendar!" +ex);
        } finally {
            Conexao.closeConnection(con, stmt);
        }
    }
     
         public void update(Agendamento agendamento) {

        Connection con = Conexao.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE agendamento SET nome_cliente = ? ,nome_servico = ?, valor = ?, data = ?, hora = ? WHERE id = ?");
            stmt.setObject(1, agendamento.getNome_Cliente());
            stmt.setObject(2, agendamento.getNome_Servico());
            stmt.setString(3, agendamento.getValor());
            stmt.setString(4, agendamento.getData());
            stmt.setString(5, agendamento.getHora());

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
     public void delete(Agendamento agendamento) {

        Connection con = Conexao.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM agendamento WHERE id = ?");
            stmt.setInt(1, agendamento.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            Conexao.closeConnection(con, stmt);
        }

     }
        
    public List<Agendamento> read(){

    Connection con = Conexao.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    List<Agendamento> agendamentos = new ArrayList<>();
    
    try{
        stmt = con.prepareStatement("SELECT * FROM agendamento");
        rs = stmt.executeQuery();
        
        while(rs.next()){
            Agendamento agendamento = new Agendamento();
            
            agendamento.setId(rs.getInt("id"));
            agendamento.setNome_Cliente(rs.getString("nome_cliente"));
            agendamento.setNome_Servico(rs.getString("nome_servico"));
            agendamento.setValor((rs.getString("valor")));
            agendamento.setData(rs.getString("data"));
            agendamento.setHora(rs.getString("hora"));
            agendamentos.add(agendamento);
        }
        
    }catch(SQLException ex){
        Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
    }finally{
        Conexao.closeConnection(con,stmt, rs);
    }
    
    return agendamentos;
    
}
     
}
