<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-sm-2 sidenav">
    <c:forEach items="${listaPre}" var="p">
        <ul  >
            <li  ><b><p>${p.getNazivPredmeta()} </p></b> 
                <ul>
                    <li > <a href="<c:url value="/controller">
                             <c:param name="action" value="all_employee_sub"></c:param>
                            <c:param name="predmetID" value="${p.getSifraPredmeta()}"></c:param>
                        </c:url>">Nastavnici</li></a>
                    <li ><a href="<c:url value="/controller">
                            <c:param name="action" value="all_literature"></c:param>
                            <c:param name="predmetID" value="${p.getSifraPredmeta()}"></c:param>
                        </c:url>">Literatura</li></a>
                </ul>
            </li>
        </ul>
    </c:forEach>
</div>