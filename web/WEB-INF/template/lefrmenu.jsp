<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-sm-2 sidenav">
    <p><a href="<c:url value="/controller">
              <c:param name="action" value="all_employees"></c:param>
              <c:param name="katedraID" value="${ulogovaniZap.getSifraKatedre().getSifraKatedre()}"></c:param>
          </c:url>"><button class="btn-info btn-lg">Svi nastavnici</button> </a></p>
    <p><a href="<c:url value="/controller">
              <c:param name="action" value="add_employee"></c:param>                         
          </c:url>">Dodaj nastavnika</a></p>
</div>