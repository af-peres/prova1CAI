<%-- 
    Document   : index
    Created on : 25/03/2019, 17:27:59
    Author     : gutol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>                
        <jsp:include page = "header.jsp" flush = "true" >
            <jsp:param name="selected" value="home"/>                
        </jsp:include>
        
        <div class="container">                        
            
            <div class="form_login">
            <h1>Login</h1>
                <form action="Login" method="post">
                    <label>Email: </label> <input name="email" type="email"></input> 
                    <label>Senha: </label> <input name="senha" type="password"></input> 
                    
                    <a href="adduser.jsp">Novo Usuário</a>
                    <button class="btn btn-primary" type="submit">OK</button>
                </form>
            </div>
        
        </div>
        
        <script src="js/bootstrap.min.js"></script>
        
    </body>
</html>
