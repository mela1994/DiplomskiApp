<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">



    <div class="row">


        <div class="row">

            <c:forEach items="${k}" var="k">
                <div class="col-md-3"></div>
                <div class="col-md-8 ">
                    <a href="<c:url value="/controller">
                           <c:param name="action" value="all_inf_user"></c:param>
                           <c:param name="katedraID" value="${k.getSifraKatedre()}"></c:param>
                         
                       </c:url>" class="btn btn-default btn-lg btn-block btn-huge ">${k.getNazivKatedre()}</a>
                    <br>
                </div>


            </c:forEach>
        </div>






    </div>


</div>