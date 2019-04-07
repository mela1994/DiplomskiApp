<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid text-center">    
    <div class="row content">
        <div class="col-sm-10 text-left"> 
            <fieldset>
                <legend>Forma za dodavanje novog autora</legend>
            </fieldset>

            <div id="alarmmsgerror" >
                <h4 id="h3error"><b> ${errorMessage} </b></h4>  
            </div>
            

            <form action="/WebDiplomski/controller" method="POST" id="formAddAuthor">
                <input type="hidden" name="action" value="save_author"/> 
                <table>

                    <tbody>
                        <tr>
                            <td> Ime autora : </td>
                            <td>
                                <div class="form-group col-md-10"  >
                                    <input class="form-control" name="ime_autora" placeholder="Ime autora">
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td> Prezime autora : </td>
                            <td>
                                <div class="form-group col-md-10"  >
                                    <input class="form-control" name="prezime_autora" placeholder="Prezime autora">
                                </div>
                            </td>
                        </tr>


                    </tbody>
                </table>
                <input type="submit" class="btn-default btn-lg" value="Sacuvaj autora" id="btnSacuvajAutora"  /> 

            </form>
        </div>
    </div>
</div>
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

        $.validator.addMethod("nowhitespace", function (value, element) {
            return this.optional(element) || /^\S+$/i.test(value);
        }, "Polje ne sme da sadrzi razmak");

        $.validator.addMethod("lettersonly", function (value, element) {
            return this.optional(element) || /^[a-z]+$/i.test(value);
        }, "Polje mora da sadrzi samo slova");



        $('#formAddAuthor').validate({
            rules: {
                ime_autora: {
                    required: true,
                    nowhitespace: true,
                    lettersonly: true
                },
                prezime_autora: {
                    required: true,
                    nowhitespace: true,
                    lettersonly: true
                }

            },
            messages: {
                ime_autora: {
                    required: 'Molimo popunite polje',

                },
                prezime_autora: {
                    required: "Molimo popunite polje",

                }
            }


        });

    });

</script>
<style type="text/css">
    #nazivA{
        margin-bottom: -5px;

    }
    #btnSacuvajAutora{
        margin-top: 20px;
        margin-left: -2px;
    }



    #h3error{
        color: green;
    }

</style>


