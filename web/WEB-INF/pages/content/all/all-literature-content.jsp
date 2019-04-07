<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid text-center">    
    <div class="row content">

        <div id="infLit">
            <h3> <b>Literatura za predmet : ${p.getNazivPredmeta()}</h3>
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

            <table  class="table table-striped result">
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
                            <td>
                                <c:forEach var="a" items="${z.getLiteratura().getAutorliteraturaList()}">
                                    ${a.getAutor()}<br>
                                </c:forEach>
                            </td>
                           
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="<c:url value="/controller">
                   <c:param name="action" value="add_literature_sub"></c:param>
                   <c:param name="predmetID" value="${p.getSifraPredmeta()}"></c:param>
               </c:url>"> <button class="btn-lg" id="myButton">Dodaj literaturu</button></a>

        </div>
    </div>
</div>
<style type="text/css">
    #infLit{
        margin-left: -540px;
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
    $(document).on('click', '.remove_details_lit', function () {

        if (confirm("Da li sigurno zelite da obrisete literaturu ?"))
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