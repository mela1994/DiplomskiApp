<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid text-center">    
    <div class="row content">
        <div id="inf">
            <h3><b>Nastavnici na predmetu : ${p.getNazivPredmeta()}</h3>
            <h4>${errorMessage}</h4>
        </div>

        <div class="col-sm-10 text-left">      
            <br>
            <table>
                <tbody>
                    <tr>
                        <td>
                            <div class="form-group pull-left">
                                <h4><b>Pretrazivanje:</b></h4>  
                            </div>       
                        </td>
                        <td>
                            <div class="form-group pull-left">
                                <input type="text" class="search form-control" placeholder="Pretrazivanje..."/>
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>
            <table border="0" class="table table-striped result">
                <thead>
                    <tr>
                        <th>Ime</th>
                        <th>Prezime</th>
                        <th>Zvanje</th>
                        <th >Uloga</th>
                        <th>Akcija</th>


                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="z" items="${lista}">
                        <tr>
                            <td >${z.getIme()}</td>
                            <td  >${z.getPrezime()}</td>
                            <td >${z.getSifraZvanja()}</td>
                            <td  >
                                <c:forEach var="a" items="${z.getUlogaList()}">
                                    ${a.getNazivUloge()}     <br> 
                                </c:forEach>
                            </td> 
                            <td>
                                <c:forEach var="a" items="${z.getUlogaList()}">
                                    <a id="tag" href="<c:url value="controller">
                                           <c:param name="action" value="delete_role"></c:param>
                                           <c:param name="employeeID" value="${z.getSifraZaposlenog()}"></c:param>
                                           <c:param name="subjectID" value="${a.getPredmet().getSifraPredmeta()}"></c:param>
                                           <c:param name="roleID" value="${a.getUlogaPK().getRbr()}"></c:param>
                                       </c:url>"><button type="button" name="view_details" class="btn btn-danger btn-xs remove_details_role">Ukloni ulogu</button></a><br>
                                </c:forEach>
                            </td>





                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <a href="<c:url value="/controller">
                   <c:param name="action" value="add_employee_role"></c:param>
                   <c:param name="katedraID" value="${ulogovaniZap.getSifraKatedre().getSifraKatedre()}"></c:param>
                   <c:param name="predmetID" value="${p.getSifraPredmeta()}"></c:param>
               </c:url>">  <button class=" btn-lg" id="myButton">Dodaj ulogu</button></a>

        </div>
    </div>
</div>

<style type="text/css">
    #inf{
        margin-left: -520px;
    }

    #myButton {

        padding: 10px 25px;
        text-align: center;
        text-decoration:  #111;
        display: inline-block;
        font-size: 16px;
    }
    .result tr[visible ='false' ],.no-result{
        display: none;
    }
    .result tr[visible = 'true']{
        display: table-row;
    }


</style>
<script>
    $(document).on('click', '.remove_details_role', function () {

        if (confirm("Da li zelite da obrisete ulogu?"))
        {

        } else
        {
            return false;
        }
    });

    $(document).ready(function () {
        $('.search').keyup(function () {
            var searchTerm = $(".search").val();
            var listItem = $('.result tbody').children('tr');
            var searchSplit = searchTerm.replace(/ /g, "'):containsi('");
            $.extend($.expr[':'], {
                'containsi': function (elem, i, match, array) {
                    return (elem.textContent || elem.innerText || '').toLowerCase().indexOf((match[3] || "").toLowerCase()) >= 0;
                }
            });
            $(".result tbody tr").not(":containsi('" + searchSplit + "')").each(function () {
                $(this).attr('visible', 'false');
            });
            $(".result tbody tr:containsi('" + searchSplit + "')").each(function () {
                $(this).attr('visible', 'true');
            });
            var jobCount = $('.result tbody tr[visible="true"]').length;


            if (jobCount == 0) {
                $('.no-result').show();
            } else {
                $('.no-result').hide();
            }
        });
    });

</script>