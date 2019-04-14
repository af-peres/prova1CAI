/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import db.MensagemDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Mensagem;
import modelos.Usuario;

/**
 *
 * @author gutol
 */
public class AddMessage extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Mensagem mensagem = new Mensagem();
        mensagem.setDescricao(request.getParameter("descricao"));

        Usuario logado = (Usuario)request.getSession().getAttribute("logado");
        mensagem.setAutor(logado);

        try{
            MensagemDAO dao = new MensagemDAO();
            dao.insert(mensagem);

            response.sendRedirect("home.jsp");

        }catch(Exception e){
            System.out.println(e.toString());
        }

    }


}