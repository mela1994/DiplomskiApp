<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid text-center">    
    <div class="row content">
        <div class="col-sm-10 text-left"> 
            <div id="alarmmsgerror" >
                <h4 id="h3error"><b> ${errorMessage} </b></h4>  
            </div>
            <form action="/WebDiplomski/controller" method="POST" id="formAddPublisher">
                <input type="hidden" name="action" value="save_publisher"/> 
                <table >
                    <tbody>
                        <tr>
                            <td> Naziv izdavaca : </td>
                            <td>
                                <div class="form-group col-md-10" id="nazivI">
                                    <input class="form-control" name="naziv_izdavaca" placeholder="Naziv izdavaca">
                                </div>
                            </td>
                        </tr>

                    </tbody>
                </table>
                <input type="submit" class="btn-default btn-lg" value="Sacuvaj izdavaca" id="btnSacuvajIzdavaca"  /> 

            </form>
        </div>
    </div>
</div>

<style type="text/css">
    #nazivI{
        margin-bottom: -5px;

    }
    #btnSacuvajIzdavaca{
        margin-top: 20px;
        margin-left: -2px;
    }
    #h3error{
        color: red;
    }

</style>

<script>
     setTimeout(function () {
        document.getElementById("alarmmsgerror").innerHTML = '';
    }, 4000);

    setTimeout(function () {
        document.getElementById("alarmmsg").innerHTML = '';
    }, 4000);
    
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

        $.validator.addMethod("lettersonly", function (value, element) {
            return this.optional(element) || /^[a-z]+$/i.test(value);
        }, "Polje mora da sadrzi samo slova");



        $('#formAddPublisher').validate({
            rules: {
                naziv_izdavaca: {
                    required: true,
                   
                },

            },
            messages: {
                naziv_izdavaca: {
                    required: 'Molimo popunite polje',

                },
            }
        });

    });

</script>