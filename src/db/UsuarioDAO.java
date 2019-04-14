package db;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelos.Usuario;

/**
 *
 * @author gutol
 */
public class UsuarioDAO {
    
    public boolean login(Usuario usuario) throws SQLException, ClassNotFoundException{
        
        String sql = "select * from usuario where email = \""
                    +usuario.getEmail()
                    +"\" AND senha = \"" 
                    +usuario.getSenha() + "\"";
        
        System.out.println(sql);
        
        ArrayList<Usuario> resultado = select(sql);
        
        return (resultado.size()>0);        
    }
    
    public Usuario loadUserData(String email) throws SQLException, ClassNotFoundException{
      
        String sql = "select * from usuario where email = \"" + email + "\"";      
        
        ArrayList<Usuario> resultado = select(sql);
        
        return resultado.get(0);
    }
    
    public ArrayList<Usuario> select() throws SQLException, ClassNotFoundException{
        
        String sql = " select * from usuario ";
        
        return this.select(sql);
    }
    
    public ArrayList<Usuario> select(String sql) throws SQLException, ClassNotFoundException{
        ArrayList<Usuario> resposta = new ArrayList();
    
        Connection con = Conexao.getConnection();
        
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        
        while(rs.next()){
            Usuario p = new Usuario();
            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            p.setEmail(rs.getString("email"));
            p.setSenha(rs.getString("senha"));
            p.setTipo(rs.getInt("tipo"));
            
            resposta.add(p);
        }
        
        stm.close();
        con.close();
        return resposta;
    }
    
    public void insert(Usuario user) throws SQLException, ClassNotFoundException{
        Connection con = Conexao.getConnection();
        
        String sql = " insert into usuario(nome, email, senha) values(?, ?, ?) ";
        
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, user.getNome());
        stm.setString(2, user.getEmail());
        stm.setString(3, user.getSenha());
        
        stm.execute();
        stm.close();
        con.close();
    }
    
}
