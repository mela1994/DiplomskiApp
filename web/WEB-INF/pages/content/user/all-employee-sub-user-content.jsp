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
            <h4><b>Nastavnici na predmetu : ${p}</h4>
            <table  class="table table-striped">
                <thead>
                    <tr>
                        <th>Ime</th>
                        <th>Prezime</th>
                        <th>Zvanje</th>
                        <th>Uloga</th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="z" items="${lista}">
                        <tr>
                            <td>${z.getIme()}</td>
                            <td>${z.getPrezime()}</td>
                            <td>${z.getSifraZvanja()}</td>
                            
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
</div>