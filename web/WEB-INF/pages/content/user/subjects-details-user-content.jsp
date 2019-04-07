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
        <div class="col-sm-9 text-left"> 

            <h3><b>Predmet : ${p.getNazivPredmeta()}</b> </h3>

            <h3><b>Broj ESPB : ${p.getBrojESPB()} </b></h3>
            <br>
            <ul class="nav nav-tabs">
                <li class="active"><a data-toggle="tab" href="#home">Nastavnici</a></li>
                <li><a data-toggle="tab" href="#menu1">Literatura</a></li>

            </ul>

            <div class="tab-content">
                <div id="home" class="tab-pane fade in active">
                    <br>

                    <table  class="table table-striped">
                        <thead>
                            <tr>
                                <th>Ime</th>
                                <th>Prezime</th>
                                <th>Zvanje</th>
                                <th>Uloge</th>

                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="z" items="${lista}">
                                <tr>
                                    <td>${z.getIme()}</td>
                                    <td>${z.getPrezime()}</td>
                                    <td>${z.getSifraZvanja()}</td>
                                    <td>
                                        <c:forEach var="a" items="${z.getUlogaList()}">
                                            ${a.getNazivUloge()}<br>
                                        </c:forEach>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table> 
                </div>
                <div id="menu1" class="tab-pane fade">
                    <br>

                    <table  class="table table-striped">
                        <thead>
                            <tr>
                                <th>Skolska godina</th>
                                <th>Naziv knjige</th>
                                <th>Izdanje</th>
                                <th>Izdavac</th>
                                <th>Autori</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="z" items="${p.getSkolskagodinaList()}">
                                <tr>
                                    <td>${z.getSkolskaGodina()}</td>
                                    <td>${z.getLiteratura().getNazivKnjige()}</td>
                                    <td>${z.getLiteratura().getIzdanje()}</td>
                                    <td>${z.getLiteratura().getSifraIzdavaca().getNazivIzdavaca()}</td> 
                                    <td><c:forEach var="a" items="${z.getLiteratura().getAutorliteraturaList()}">
                                            ${a.getAutor()}<br>
                                        </c:forEach>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table> 
                </div>
            </div>
        </div>
    </div>
</div>



