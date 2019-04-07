<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid text-center">    
    <div class="row content">

        <div class="col-sm-10 text-left"> 
            <fieldset>
                <legend>Forma za dodavanje literature na predmet</legend>
            </fieldset>


            <div id="alarmmsgerror" >
                <h4 id="h3error"><b>${errorMessage}</b></h4>  
            </div>
          
            <h3>Predmet : ${p.getNazivPredmeta()}</h3>



            <br>
            <h3><b>Skolska godina : ${sk} </b></h3> 
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
            <table class="table table-striped result">
                <thead>
                    <tr>
                        <th>Naziv knjige</th>
                        <th>Izdanje</th>
                        <th>Akcija</th>
                    </tr>

                </thead>
                <tbody>
                    <c:forEach var="l" items="${listaLit}">
                        <tr>
                            <td>${l.getNazivKnjige()}</td>
                            <td>${l.getIzdanje()}</td>
                            <td><a href="<c:url value="controller">
                                       <c:param name="action" value="save_lit_sub"></c:param>
                                       <c:param name="sk" value="${sk}"></c:param>
                                       <c:param name="predmetID" value="${p.getSifraPredmeta()}"></c:param>
                                       <c:param name="literaturaID" value="${l.getSifraKnjige()}"></c:param>

                                   </c:url>"><button type="button" name="" class="btn btn-warning btn-xs ">Dodaj literaturu</button></a></td> 
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

</script>
