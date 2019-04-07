<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
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