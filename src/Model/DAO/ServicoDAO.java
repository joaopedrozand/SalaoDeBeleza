/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

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
 * @author tiago
 */
public class ServicoDAO {
    
    
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
        
        /*public List<Servico> read() {

        Connection con = Conexao.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Servico> servicos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM servico");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Servico servico = new Servico();

                servico.setId(rs.getInt("id"));
                servico.setDescricao(rs.getString("descricao"));
                servico.setValor(rs.getDouble("valor"));
                servico.add(servico);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }

        return produtos;

    }
    public List<Produto> readForDesc(String desc) {

        Connection con = Conexao.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM produto WHERE descricao LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Produto produto = new Produto();

                produto.setId(rs.getInt("id"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setQtd(rs.getInt("qtd"));
                produto.setPreco(rs.getDouble("preco"));
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.closeConnection(con, stmt, rs);
        }

        return produtos;

    }
    }
    }
    
    /**
     * Atualiza um Objeto no banco de dados
     * @param servico
     * @return 
     */
    /*public boolean update(Servico servico){
        
        for (int i = 0; i < Banco.servico.size(); i++) {
            if(idSaoIguais(Banco.servico.get(i),servico)){
                Banco.servico.set(i, servico);
                return true;
            }
        }
        return false;      

    }
    
    /**
     * Deleta um objeto do banco de dados pelo id do servico passado
     * @param servico
     * @return 
     */
    /*public boolean delete(Servico servico){
        for (Servico servicoLista : Banco.servico) {
            if(idSaoIguais(servicoLista,servico)){
                Banco.servico.remove(servicoLista);
                return true;
            }
        }
        return false;
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
    
}
}