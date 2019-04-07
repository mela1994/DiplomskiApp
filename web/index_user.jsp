<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web Aplikacija</title>
        <meta charset="utf-8">
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.17.0/jquery.validate.js"></script>
        <script src="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.17.0/jquery.validate.min.js"></script>
        <script src="resources/javascript.js"></script>


        <style type="text/css">
            .btn-huge{
                padding-top:20px;
                padding-bottom:20px;
            }

            #slika{
                margin-top: -50px;
                margin-left: 400px;
            }



        </style>

    </head>
    <body>
        <header class="container-fluid text-center">    
            <h1><b>Dobro dosli </h1>
        </header>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">

                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li><a href="<c:url value="/controller">
                                   <c:param name="action" value="index_user"></c:param>
                               </c:url>">Pocetna</a></li>
                        <li><a href="<c:url value="/controller">
                                   <c:param name="action" value="all_departments_user"></c:param>
                               </c:url>">Katedre</a></li>

                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="<c:url value="/controller">
                                   <c:param name="action" value="login_user"></c:param>                            
                               </c:url>"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                    </ul>
                </div>
            </div>
        </nav> 

        <div class="container-fluid text-center">  
            <div class="row content">

                <div class="col-sm-10 text-left"> 


                    <h1><b> <div  id="slika">
                                <img src="img/fon.png"></img>
                            </div> </h1></b>


                </div>


            </div>
        </div>
    </div>
    <footer class="container-fluid text-center">
        <p>Web aplikacija - korisnik</p>
    </footer>


</body>
</html>
