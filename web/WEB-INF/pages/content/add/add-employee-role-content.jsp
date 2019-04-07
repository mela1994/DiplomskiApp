<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid text-center">    
    <div class="row content">

        <div class="col-sm-8 text-left"> 
            <form action="/WebDiplomski/controller" method="POST" id="myFormRole" >
                <input type="hidden" name="action" value="save_employee_role"/> 
                <input type="submit" style="display:none" />
                <ul class="form-style-1">
                    <fieldset>
                        <legend>Forma za dodavanje uloge nastavniku</legend>
                    </fieldset>

                    <li>
                        <div id="alarmmsgerror" >
                            <h4 id="h3error"><b> ${errorMessage} </b></h4>  
                        </div>
                        <div id="alarmmsg" >
                            <h4 id="h3success"><b>${successMessage}</b></h4>  
                        </div>


                    </li>
                    <li>
                        <div class="form-group col-md-10">
                            <select name="zaposleni" class="field-select">
                                <option value="-1">Izaberite nastavnika..</option>     
                                <c:forEach items="${lista}" var="z">
                                    <option value="${z.getSifraZaposlenog()}">${z}</option>         
                                </c:forEach>
                            </select>
                        </div>
                    </li>
                    <li>
                        <div class="form-group col-md-10">
                            <select name="uloga" class="field-select">
                                <option>Izaberite ulogu..</option>
                                <option>Predavanja</option>      
                                <option>Vezbe</option>      
                                <option>Lab vezbe</option>
                            </select>
                        </div>

                    </li>
                    <li>
                        <div class="form-group col-md-10">
                            <input type="button" value="Sacuvaj ulogu" id="myButtonRole"  /> 
                        </div>

                    </li>
                </ul>
            </form>

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

</style>
<script>
    $(document).ready(function () {
        $("#myButtonRole").click(function () {
            $("#myFormRole").submit();
        });
    });

    $(function () {

        $.validator.setDefaults({
            errorClass: 'help-block',
            highlight: function (element) {
                $(element)
                        .closest('.form-group')
                        .addClass('has-error');

            },
            unhighlight: function (element) {
                $(element)
                        .closest('.form-group')
                        .removeClass('has-error');

            }


        });

        $.validator.addMethod('komboZaposleni', function (value, element) {
            return value != -1;

        }, 'Morate da izaberete zaposlenog')

        $.validator.addMethod('komboUloga', function (value, element) {
            return value != 'Izaberite ulogu..';

        }, 'Morate da izaberete ulogu')


        $('#myFormRole').validate({
            rules: {
                uloga: {
                    komboUloga: true,
                },
                zaposleni: {
                    komboZaposleni: true,
                },

            }

        });

    });

</script>

