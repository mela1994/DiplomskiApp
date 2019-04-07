<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid text-center">    
    <div class="row content">
        <div class="col-sm-2 sidenav">

            <ul class="list-group">
                <li class="list-group-item" ><a href="<c:url value="/controller">
                                                    <c:param name="action" value="all_employees"></c:param>
                                                    <c:param name="katedraID" value="${ulogovaniZap.getSifraKatedre().getSifraKatedre()}"></c:param>
                                                </c:url>">Svi nastavnici</a></li>


            </ul>
            <ul class="list-group">
                <li class="list-group-item" ><a href="<c:url value="/controller">
                                                    <c:param name="action" value="add_employee"></c:param>                         
                                                </c:url>">Dodaj nastavnika</a></li>  
            </ul>
        </div>
        <div class="col-sm-10 text-left"> 
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


            <div id="alarmmsg" >
                <h4 id="h3success"><b>${suceessMessage}</b></h4>  
            </div>
            <div id="alarmmsgerror" >
                <h4 id="h3error"><b> ${errorMessage}</b></h4>  

            </div>


            <table  class="table table-striped result">
                <thead>
                    <tr>
                        <th>Ime</th>
                        <th>Prezime</th>
                        <th>Zvanje</th>
                        <th>Broj Telefona</th>
                        <th>Email</th>
                        <th>Broj Kabineta</th>
                        <th>Akcija<th>
                        <th>Akcija<th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="z" items="${listaZap}">
                        <tr>
                            <td>${z.getIme()}</td>
                            <td>${z.getPrezime()}</td>
                            <td>${z.getSifraZvanja()}</td>
                            <td>${z.getKontaktTelefon()}</td>
                            <td>${z.getEmail()}</td>
                            <td>${z.getBrojKabineta()}</td>
                            <td><a href="<c:url value="controller">
                                       <c:param name="action" value="update_employee"></c:param>
                                       <c:param name="employeeID" value="${z.getSifraZaposlenog()}"></c:param>
                                   </c:url>"><button type="button" name="" class="btn btn-warning btn-xs ">Izmeni nastavnika</button></a></td>
                            <td></td>
                            <td><a href="<c:url value="controller">
                                       <c:param name="action" value="delete_employee"></c:param>
                                       <c:param name="employeeID" value="${z.getSifraZaposlenog()}"></c:param>
                                   </c:url>"><button type="button" name="view_details" class="btn btn-danger btn-xs remove_details_empl ">Obrisi nastavnika</button></a></td>
                        </tr>

                    </c:forEach>

                </tbody>
            </table>


        </div>

    </div>
</div>

<style type="text/css">

    #h3success{
        color: green;
    }
    #h3error{
        color: red;
    }

    .result tr[visible ='false' ],.no-result{
        display: none;
    }
    .result tr[visible = 'true']{
        display: table-row;
    }

</style>


<script>
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

   



    $(document).on('click', '.remove_details_empl', function () {

        if (confirm("Da li sigurno zelite da obrisete nastavnika ?"))
        {

        } else
        {
            return false;
        }
    });
</script>