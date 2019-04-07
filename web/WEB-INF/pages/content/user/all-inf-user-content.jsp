<%-- 
    Document   : all-inf-user-content
    Created on : Oct 30, 2018, 3:00:48 PM
    Author     : Nikola
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid text-center">    
    <div class="row content">
        <div class="col-sm-2 sidenav">
             <ul class="list-group">
                <li  class="list-group-item" ><a href="<c:url value="/controller">
                                                     <c:param name="action" value="all_employees_user"></c:param>
                                                     <c:param name="katedraID" value="${katUser.getSifraKatedre()}"></c:param>
                                                 </c:url>">Nastavnici</a>
                </li>
            </ul>
            <ul class="list-group">
                <li  class="list-group-item"><a href="<c:url value="/controller">
                                                    <c:param name="action" value="all_subjects_user"></c:param>      
                                                    <c:param name="katedraID" value="${katUser.getSifraKatedre()}"></c:param>
                                                </c:url>">Predmeti</a>
                </li>

            </ul>
        </div>
        <div class="col-sm-10 text-left"> 

            <div id="alarmmsg" >
                <h4 id="h3success"><b>${suceessMessage}</b></h4>  
            </div>
            <div id="alarmmsgerror" >
                <h4 id="h3error"><b> ${errorMessage} </b></h4>  

            </div>

            <h1>${katUser}</h1>



        </div>

    </div>
</div>