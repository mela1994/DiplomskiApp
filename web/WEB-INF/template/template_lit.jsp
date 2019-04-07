<%-- 
    Document   : template
    Created on : Sep 11, 2018, 1:32:54 PM
    Author     : Nikola
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web Aplikacija</title>
        <meta charset="utf-8">

        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css" />
        <script src="../../resources/javascript.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.17.0/jquery.validate.js"></script>
        <script src="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.17.0/jquery.validate.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <script src="http://harvesthq.github.io/chosen/chosen.jquery.js"></script>




    </head>
    <body>
        <%@include file="header.jsp" %>
        <%@include file="navbar.jsp" %>

        <div class="container-fluid text-center">  
            <div class="row content">
                <%@include file="leftmenu_lit.jsp" %>
                <div class="col-sm-10 text-left"> 
                    <jsp:include page="../pages/content/${param.content}.jsp"></jsp:include>
                    </div>
                </div>
            </div>
 
            <%@include file="footer.jsp" %>
       

    </body>
</html>