<%-- 
    Document   : header
    Created on : 03/10/2018, 17:43:03
    Author     : gutol
--%>
<%@page import="modelos.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <%
        String selected = request.getParameter("selected");
        String classhome = selected.equals("home")?"active":"";
        String classabout = selected.equals("about")?"active":"";
        
        //obtendo usuario da seção
        Usuario  user = (Usuario)request.getSession().getAttribute("logado");
    %>

    <nav class="navbar navbar-default">
      <div class="container-fluid">
            <div class="navbar-header">
              <a class="navbar-brand" href="index.jsp">CadastrosOnline</a>
            </div>
            <ul class="nav navbar-nav">
                <%--Algumas opções só aparacem se o usuario estiver logado --%>
                <% if(user != null){ %>
                
                <li class="<%=classhome%>" ><a href="home.jsp">Home</a></li>
                
                <%}%>
                <li class="<%=classabout%>"><a href="about.jsp">Sobre</a></li>
            </ul>
      </div>
    </nav>
