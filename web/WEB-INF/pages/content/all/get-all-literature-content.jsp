<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid text-center">    
    <div class="row content">

        <div class="col-sm-12 text-left"> 
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
                <h4 id="h3error"><b>${suceessMessage}</b></h4>  
            </div>
            <div id="alarmmsgerror" >
                <h4 id="h3error"><b> ${errorMessage} </b></h4>  

            </div>


            <table  class="table table-striped result">
                <thead>
                    <tr>
                        <th>Skolske godine</th>
                        <th>Naziv knjige</th>
                        <th>Izdanje</th>
                        <th>Predmeti</th>


                        <th>Izdavac</th>
                        <th>Autori</th>
                        <th>Akcija</th>
                        <th>Akcija</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="l" items="${listaLit}">
                        <tr>

                            <td>
                                <c:forEach var="a" items="${l.getSkolskagodinaList()}">
                                    ${a}<br>
                                </c:forEach>
                            </td>
                            <td>${l.getNazivKnjige()}</td>
                            <td>${l.getIzdanje()}</td>
                            <td>
                                <c:forEach var="a" items="${l.getSkolskagodinaList()}">
                                    ${a.getPredmet()}<br>
                                </c:forEach>
                            </td>


                            <td>${l.getSifraIzdavaca()}</td>
                            <td>
                                <c:forEach var="a" items="${l.getAutorliteraturaList()}">
                                    ${a.getAutor()}<br>
                                </c:forEach>
                            </td>

                            <td>
                                <a href="<c:url value="controller">
                                       <c:param name="action" value="delete_literature"></c:param>
                                       <c:param name="literatureID" value="${l.getSifraKnjige()}"></c:param>
                                   </c:url>"><button type="button" name="view_details" onclick="getConfirmation();" class="btn btn-danger btn-xs remove_details_lit ">Obrisi literaturu</button></a>
                            </td>
                            <td>
                                 <a href="<c:url value="controller">
                                       <c:param name="action" value="update_literature"></c:param>
                                       <c:param name="literatureID" value="${l.getSifraKnjige()}"></c:param>
                                   </c:url>"><button type="button" name="" class="btn btn-warning btn-xs ">Izmeni literaturu</button></a>
                            </td>
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
    setTimeout(function () {
        document.getElementById("alarmmsgerror").innerHTML = '';
    }, 4000);

    setTimeout(function () {
        document.getElementById("alarmmsg").innerHTML = '';
    }, 4000);


    $(document).on('click', '.remove_details_lit', function () {

        if (confirm("Da li zelite da obrisete literaturu ?"))
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