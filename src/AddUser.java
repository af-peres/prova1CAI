/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import db.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Usuario;

/**
 *
 * @author gutol
 */
public class AddUser extends HttpServlet {


    /**
     * Recebe dados de novo usuário para o sistema via POST
     *
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Usuario novo = new Usuario();
        novo.setNome(request.getParameter("nome"));
        novo.setEmail(request.getParameter("email"));
        novo.setSenha(request.getParameter("senha"));

        UsuarioDAO dao = new UsuarioDAO();

        try{

            dao.insert(novo);
            response.sendRedirect("index.jsp");

        }catch(Exception e){
            System.out.println(e.toString());
        }

    }


}