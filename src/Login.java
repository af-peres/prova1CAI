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
import javax.servlet.http.HttpSession;
import modelos.Usuario;

/**
 *
 * @author gutol
 */
public class Login extends HttpServlet {


    /**
     * Processa as requisições do tipo POST
     *
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Usuario user = new Usuario();
        user.setEmail(request.getParameter("email"));
        user.setSenha(request.getParameter("senha"));

        UsuarioDAO dao = new UsuarioDAO();

        try{

            if(dao.login(user)){
                Usuario logado = dao.loadUserData(user.getEmail());
                HttpSession session = request.getSession();

                session.setAttribute("logado", logado);
                response.sendRedirect("home.jsp");
            }else{
                response.sendRedirect("error.jsp");
            }
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }


}
