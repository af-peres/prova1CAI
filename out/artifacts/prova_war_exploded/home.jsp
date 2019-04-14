<%-- 
    Document   : home
    Created on : 08/04/2019, 15:50:29
    Author     : gutol
--%>

<%@page import="modelos.Mensagem" %>
<%@page import="java.util.ArrayList" %>
<%@page import="db.MensagemDAO" %>
<%@page import="modelos.Usuario" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>JSP Page</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<jsp:include page="header.jsp" flush="true">
    <jsp:param name="selected" value="home"/>
</jsp:include>


<%
    Usuario logado = (Usuario) request.getSession().getAttribute("logado");

    if (logado == null) response.sendRedirect("index.jsp");
    else if (logado.getTipo() == 0) {
%>

<div class="container">

    <h1>Bem Vindo <%=logado.getNome()%>
    </h1>

    <h2>Mensagens do Sistema</h2>

    <%

        MensagemDAO dao = new MensagemDAO();
        ArrayList<Mensagem> mensagens = dao.select(logado);

        for (int i = 0; i < mensagens.size(); i++) {
            out.println("<pre>" + mensagens.get(i).getDescricao() + "</pre>");
        }

    %>


    <h3>Nova Mensagem</h3>

    <form action="AddMessage" method="post">
        <label>Descrição: </label>
        <input name="descricao" type="text">
        <button type="submit">OK</button>
    </form>

</div>
<%
} else if (logado.getTipo() == 1) {
%>
<div class="container">

    <h1>Bem Vindo <%=logado.getNome()%>
    </h1>

    <h2>Mensagens do Sistema</h2>

        <%
                MensagemDAO dao = new MensagemDAO();
                ArrayList<Mensagem> mensagens = dao.select();

                for(int i=0; i<mensagens.size(); i++){
                    out.println("<pre>"+mensagens.get(i).getDescricao()+
                    "<a href='deletarMensagem?id="+mensagens.get(i).getId() +
                     "'>deletar</a></pre>");
                }
            }
        %>

    <script src="js/bootstrap.min.js"></script>

</body>
</html>
