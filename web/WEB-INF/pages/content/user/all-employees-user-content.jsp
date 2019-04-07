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
        <div class="col-sm-10 text-left"> 

            <h3><b>Nastavnici : ${katUser}</b></h3>
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
                        <th>Ime</th>
                        <th>Prezime</th>
                        <th>Zvanje</th>
                        <th>Broj Telefona</th>
                        <th>Email</th>
                        <th>Broj Kabineta</th>

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
                        </tr>

                    </c:forEach>

                </tbody>
            </table>




        </div>

    </div>
</div>
            
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

<style >
    .result tr[visible ='false' ],.no-result{
        display: none;
    }
    .result tr[visible = 'true']{
        display: table-row;
    }

</style>