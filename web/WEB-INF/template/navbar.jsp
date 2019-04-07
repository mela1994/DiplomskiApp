<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">

        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li><a href="<c:url value="/controller">
                           <c:param name="action" value="index"></c:param>
                       </c:url>">Pocetna</a></li>
                <li><a href="<c:url value="/controller">
                           <c:param name="action" value="all_employees"></c:param>
                           <c:param name="katedraID" value="${ulogovaniZap.getSifraKatedre().getSifraKatedre()}"></c:param>
                       </c:url>">Nastavnici</a></li>
                <li><a href="<c:url value="/controller">
                           <c:param name="action" value="get_all_literature"></c:param>
                       </c:url>">Literatura</a></li>
                <li><a href="<c:url value="/controller">
                           <c:param name="action" value="all_subjects"></c:param>
                           <c:param name="katedraID" value="${ulogovaniZap.getSifraKatedre().getSifraKatedre()}"></c:param>
                       </c:url>">Predmeti</a></li>


            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="<c:url value="/controller">
                           <c:param name="action" value="logout"></c:param>                            
                       </c:url>"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
            </ul>
        </div>
    </div>
</nav> 