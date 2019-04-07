<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-sm-2 sidenav">
    <ul class="list-group">
        <li class="list-group-item" ><a href="<c:url value="/controller">
                                            <c:param name="action" value="get_all_literature"></c:param>
                                        </c:url>">Sve literature</a></li>
    </ul>
    <ul class="list-group">
        <li class="list-group-item" ><a href="<c:url value="/controller">
                                            <c:param name="action" value="add_literature"></c:param>                         
                                        </c:url>">Dodaj literaturu</a></li>  
    </ul>
</div>