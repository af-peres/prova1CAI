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
import modelos.Mensagem;
import modelos.Usuario;

/**
 *
 * @author gutol
 */
public class MensagemDAO {
    
    public MensagemDAO(){}
    
    public ArrayList<Mensagem> select() throws SQLException, ClassNotFoundException{
        String sql =  " select mensagem.*, usuario.nome, usuario.email, usuario.senha\n" +
                      " from mensagem\n" +
                      " left join usuario on usuario.id = mensagem.id_usuario";

        System.out.println(sql);
        return select(sql);
    }
    
    public ArrayList<Mensagem> select(Usuario logado) throws SQLException, ClassNotFoundException{
        String sql =  " select mensagem.*, usuario.nome, usuario.email, usuario.senha\n" +
                      " from mensagem\n" +
                      " left join usuario on usuario.id = mensagem.id_usuario" + 
                      " where mensagem.id_usuario = " + logado.getId();
        
        return select(sql);
    }
    
    public ArrayList<Mensagem> select(String sql) throws SQLException, ClassNotFoundException{
        //objeto para conter os resultados da consulta
        ArrayList<Mensagem> resultado = new ArrayList();
        
        //criando conexao com mysql
        Connection con = Conexao.getConnection();
        
        //criando um estrutura de consulta SQL
        Statement stm = con.createStatement();
        //guardando o resultado de uma consulta
        ResultSet rs = stm.executeQuery(sql);
        
        //percorrendo cada linha do resultado da consulta
        while(rs.next()){
            
            //convertendo dado relacional para objeto
            Usuario user = new Usuario();
            user.setId(rs.getInt("id_usuario"));
            user.setNome(rs.getString("nome"));
            user.setEmail(rs.getString("email"));
            user.setSenha(rs.getString("senha"));
            
            //convertendo dado relacional para objeto
            Mensagem msg = new Mensagem();            
            msg.setId(rs.getInt("id"));
            msg.setDescricao(rs.getString("descricao"));
            msg.setAutor(user);
            
            //adicionando na lista de mensagens 
            resultado.add(msg);
        }
        
        stm.close();
        //con.close();
        
        return resultado;
    }
    
    
    public void insert(Mensagem mensagem) throws SQLException, ClassNotFoundException{
        //criar conexão com o banco
        Connection con = Conexao.getConnection();
        
        //construindo a sql da inserção de dados
        String sql = " insert into mensagem (descricao, id_usuario) values(?, ?) ";
        
        //construindo a estrutura de dados para comunicação com o BD
        PreparedStatement stm = con.prepareStatement(sql);
        //preenchendo parâmetro da sql
        stm.setString(1, mensagem.getDescricao());
        stm.setInt(2, mensagem.getAutor().getId());
        
        //executando o camando SQL
        stm.execute();
        
        stm.close();
        //con.close();
    }

    public void delete(int idInt) throws SQLException, ClassNotFoundException{
        //criar conexão com o banco
        Connection con = Conexao.getConnection();

        //construindo a sql da exclusão de dados
        String sql = "delete from mensagem where id = ?";

        //construindo a estrutura de dados para comunicação com o BD
        PreparedStatement stm = con.prepareStatement(sql);
        //preenchendo parâmetro da sql
        stm.setInt(1,idInt);

        //executando o camando SQL
        stm.execute();

        stm.close();
        //con.close();
    }
}
