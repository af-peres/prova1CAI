import db.MensagemDAO;
import modelos.Mensagem;
import modelos.Usuario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class deletarMensagem extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int idInt = Integer.parseInt(id);

        try{
            MensagemDAO dao = new MensagemDAO();
            dao.delete(idInt);

            response.sendRedirect("home.jsp");

        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
}
