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

            <div id="alarmmsg" >
                <h4 id="h3success"><b>${successMessage}</b></h4>  
            </div>
            <div id="alarmmsgerror" >
                <h4 id="h3error"><b> ${errorMessage} </b></h4>  

            </div>



            <form  action="/WebDiplomski/controller" method="POST"  id="myForm">
                <input type="hidden" name="action" value="save_employee"/> 
                <input type="submit" style="display:none" />
                <fieldset>
                    <legend>Forma za dodavanje novog nastavnika</legend>
                </fieldset>
                <table  >
                    <tbody>
                        <tr>
                            <td>Ime: </td>
                            <td>
                                <div class="form-group col-md-12">
                                    <input class="form-control" name="ime_zap" placeholder="Ime">
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>Prezime :</td>
                            <td>
                                <div class="form-group col-md-12">
                                    <input class="form-control" name="prezime_zap" placeholder="Prezime">
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>Telefon nastavnika :</td>
                            <td>
                                <div class="form-group col-md-12">
                                    <input class="form-control" name="tel_zap" placeholder="Broj telefona">
                                </div>
                            </td>
                        </tr>
                        <tr>                       
                            <td>Broj kabineta :</td>
                            <td>
                                <div class="form-group col-md-12">
                                    <input class="form-control" name="kab_zap" placeholder="Broj kabineta">
                                </div>
                            </td>
                        </tr>
                        <tr>            
                            <td>Email :</td>
                            <td>
                                <div class="form-group col-md-12">
                                    <input class="form-control" name="email_zap" placeholder="Email">
                                </div>
                            </td>
                        </tr>
                        <tr>                       
                            <td>Korisnicko ime :</td>
                            <td>
                                <div class="form-group col-md-12">
                                    <input class="form-control" name="kor_ime_zap" placeholder="Korisnicko ime">
                                </div>
                            </td>
                        </tr>
                        <tr>                       
                            <td>Korisnicka sifra :</td>
                            <td>
                                <div class="form-group col-md-12">
                                    <input class="form-control" type="password" name="kor_sif_zap" placeholder="Korisnicka sifra">
                                </div>
                            </td>
                        </tr>
                        <tr>                       
                            <td>Zvanje :</td>
                            <td>
                                <div class="form-group col-md-12">
                                    <select name="zvanje" class="field-select">
                                        <option value="-1">Izaberite zvanje..</option>
                                        <option value="1">Redovni profesor</option>      
                                        <option value="2">Docent</option>      
                                        <option value="3">Asistent</option>  
                                        <option value="4">Saradnik u nastavi </option>
                                    </select>
                                </div>
                            </td>
                        </tr>
                        <tr>                       
                            <td>
                                <div class="form-group col-md-10">
                                    <input type="button" class="btn-lg" value="Sacuvaj zaposlenog" id="myButton"  />
                                </div>
                            </td>
                        </tr>
                    </tbody>


                </table>
            </form>
            <script>

                setTimeout(function () {
                    document.getElementById("alarmmsgerror").innerHTML = '';
                }, 4000);

                setTimeout(function () {
                    document.getElementById("alarmmsg").innerHTML = '';
                }, 4000);

                $(document).ready(function () {
                    $("#myButton").click(function () {
                        $("#myForm").submit();
                    });
                });

                $(function () {

                    $.validator.addMethod('kombo', function (value, element) {
                        return value != -1;

                    }, 'Morate da izaberete zvanje');

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


                    $.validator.addMethod('strongPassword', function (value, element) {
                        return value.length >= 6;

                    }, 'Korisnicka sifra mora da sadrzi vise od 6 znakova');
                    $.validator.addMethod('kombo', function (value, element) {
                        return value != -1;

                    }, 'Morate da izaberete zvanje');
                    $.validator.addMethod("lettersonly", function (value, element) {
                        return this.optional(element) || /^[a-z]+$/i.test(value);
                    }, "Polje mora da sadrzi samo slova");

                    $.validator.addMethod("nowhitespace", function (value, element) {
                        return this.optional(element) || /^\S+$/i.test(value);
                    }, "Polje ne sme da sadrzi razmak");

                    $('#myForm').validate({
                        rules: {
                            ime_zap: {
                                required: true,
                                nowhitespace: true,
                                lettersonly: true

                            },
                            zvanje: {
                                kombo: true
                            },
                            email_zap: {
                                required: true,
                                email: true,
                                nowhitespace: true

                            },
                            kab_zap: {
                                required: true,
                                nowhitespace: true

                            },
                            kor_ime_zap: {
                                required: true,
                                nowhitespace: true

                            },
                            kor_sif_zap: {
                                required: true,
                                strongPassword: true,
                                nowhitespace: true,
                                lettersonly: true

                            },

                            tel_zap: {
                                required: true,
                                nowhitespace: true
                            },
                            prezime_zap: {
                                required: true,
                                nowhitespace: true,
                                lettersonly: true
                            }

                        },
                        messages: {
                            email_zap: {
                                required: 'Molimo popunite polje',
                                email: 'Molimo unesite ispravan email'
                            },
                            ime_zap: {
                                required: "Molimo popunite polje"

                            },
                            prezime_zap: {
                                required: "Molimo popunite polje"

                            },
                            tel_zap: {
                                required: "Molimo popunite polje"

                            },
                            kor_sif_zap: {
                                required: "Molimo popunite polje"

                            },
                            kor_ime_zap: {
                                required: "Molimo popunite polje"

                            },
                            kab_zap: {
                                required: "Molimo popunite polje"

                            }
                        }
                    });
                });
            </script>

            <style type="text/css">

                #h3success{
                    color: green;
                }
                #h3error{
                    color: red;
                }

                #myButton {

                    padding: 10px 25px;
                    text-align: center;
                    text-decoration: none;
                    display: inline-block;
                    font-size: 16px;
                }
                .form-style-1 {

                    position: relative;
                    left: -140px;
                    top:-40px;
                    margin:10px auto;
                    max-width: 400px;
                    padding: 20px 12px 10px 20px;
                    font: 13px "Lucida Sans Unicode", "Lucida Grande", sans-serif;
                }
                .form-style-1 li {
                    padding: 0;
                    display: block;
                    list-style: none;
                    margin: 10px 0 0 0;
                }
                .form-style-1 label{
                    margin:0 0 3px 0;
                    padding:0px;
                    display:block;
                    font-weight: bold;
                }
                .form-style-1 input[type=text], 
                .form-style-1 input[type=date],
                .form-style-1 input[type=datetime],
                .form-style-1 input[type=number],
                .form-style-1 input[type=search],
                .form-style-1 input[type=time],
                .form-style-1 input[type=url],
                .form-style-1 input[type=email],
                textarea, 
                select{
                    box-sizing: border-box;
                    -webkit-box-sizing: border-box;
                    -moz-box-sizing: border-box;
                    border:1px solid #BEBEBE;
                    padding: 7px;
                    margin:0px;
                    -webkit-transition: all 0.30s ease-in-out;
                    -moz-transition: all 0.30s ease-in-out;
                    -ms-transition: all 0.30s ease-in-out;
                    -o-transition: all 0.30s ease-in-out;
                    outline: none;  
                }
                .form-style-1 input[type=text]:focus, 
                .form-style-1 input[type=date]:focus,
                .form-style-1 input[type=datetime]:focus,
                .form-style-1 input[type=number]:focus,
                .form-style-1 input[type=search]:focus,
                .form-style-1 input[type=time]:focus,
                .form-style-1 input[type=url]:focus,
                .form-style-1 input[type=email]:focus,
                .form-style-1 textarea:focus, 
                .form-style-1 select:focus{
                    -moz-box-shadow: 0 0 8px #88D5E9;
                    -webkit-box-shadow: 0 0 8px #88D5E9;
                    box-shadow: 0 0 8px #88D5E9;
                    border: 1px solid #88D5E9;
                }
                .form-style-1 .field-divided{
                    width: 49%;
                }

                .form-style-1 .field-long{
                    width: 100%;
                }
                .form-style-1 .field-select{
                    width: 100%;
                }
                .form-style-1 .field-textarea{
                    height: 100px;
                }
                .form-style-1 input[type=submit], .form-style-1 input[type=button]{
                    background: #4B99AD;
                    padding: 8px 15px 8px 15px;
                    border: none;
                    color: #fff;
                }
                .form-style-1 input[type=submit]:hover, .form-style-1 input[type=button]:hover{
                    background: #4691A4;
                    box-shadow:none;
                    -moz-box-shadow:none;
                    -webkit-box-shadow:none;
                }
                .form-style-1 .required{
                    color:red;
                }
            </style>

        </div>


    </div>
</div>


