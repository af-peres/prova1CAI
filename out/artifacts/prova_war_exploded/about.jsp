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
            <jsp:param name="selected" value="about"/>                
        </jsp:include>
        
        <div class="container">
            <h1>Sobre nós!</h1>
            
            <div class="sobre">
                <p>Este é um exemplo de projeto JAVA Web utilizado na prova prática da disciplina 'Construção de Aplicações para Internet'.            
                Esta disciplina é oferecida no curso Tecnólogo em Análise e Desenvolvimento de Sistemas pelo Instituto Federal do Paraná. 
                Na ocasião, esta disciplina foi ministrada pelo professor Augusto Luengo Pereira Nunes.
                </p>
                
                <p>Para acessar as demais páginas deste projeto, por favor, faça login no sistema.
                </p>
            </div>
        
        </div>
        
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
