<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.17.0/jquery.validate.js"></script>
        <script src="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.17.0/jquery.validate.min.js"></script>
        <script src="../../resources/javascript.js"></script>
        <script >
            $(function () {

                $.validator.addMethod("nowhitespace", function (value, element) {
                    return this.optional(element) || /^\S+$/i.test(value);
                }, "Polje ne sme da sadrzi razmak");

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



                $('#loginForm').validate({
                    rules: {
                        korisnickoIme: {
                            required: true,
                            nowhitespace: true,

                        },
                        korisnickaSifra: "required",
                        nowhitespace: true,
                    },
                    messages: {
                        korisnickoIme: {
                            required: "Molimo unesite korisnicko ime"
                        },
                        korisnickaSifra: {
                            required: "Molimo unesite korisnicku sifru"
                        }

                    }
                });
            });

            setTimeout(function () {
                document.getElementById("alarmmsgerror").innerHTML = '';
            }, 4000);

            setTimeout(function () {
                document.getElementById("alarmmsg").innerHTML = '';
            }, 4000);

        </script>


        <style type="text/css" >

            #h3success{
                color: green;
            }
            #h3error{
                color: red;
            }
            body{
                background-color: #666666;
            }
            .main-section{
                margin: 0 auto;
                margin-top: 150px ;
                padding: 0;
            }
            .modal-content{
                opacity: .85;
                margin-left: 100px;
                width: 400px;

            }
            .user-img{
                margin-top: -60px ;
                margin-bottom: 30px ;
            }
            .user-img img{
                height: 100px;
                width: 100px;

            }
            .form-group{
                margin-bottom: 20px;
                width:300px ;
                margin-left: 50px;
            }



            .form-input button{
                width: 30%;
                margin-bottom: 30px;
            }
            .btn-success{
                background-color: #2ecc71;
                border-radius: 0;
                padding: .7rem;
            }

            .btn-success:hover{
                background-color: #277ae60;
            }



        </style>

        <title>Login page</title>
    </head>
    <body>



        <div class="modal-dialog text-center">

            <div class="col-sm-8 main-section">

                <div class="modal-content">
                    <div class="col-12 user-img">
                        <img src="img/user_icon.png"></img>
                    </div>
                    <div class="col-12 form-input">
                        <div id="alarmmsg" >
                            <h5 id="h3success"><b>${suceessMessage}</b></h5>  
                        </div>
                        <div id="alarmmsgerror" >
                            <h5 id="h3error"><b> ${erorrMessage} </b></h5>  

                        </div>


                        <form method="POST" action="/WebDiplomski/controller" id="loginForm">
                            <input type="hidden" name="action" value ="login">

                            <div class="form-group">

                                <input  type="text" class="form-control" name="korisnickoIme" placeholder="Korisnicko ime">
                            </div>

                            <div class="form-group">
                                <input type="password" class="form-control" name="korisnickaSifra" placeholder="Korisnicka sifra">
                            </div>
                            <div>
                                <button type="submit" class="btn  " >Login</button> 
                            </div>
                        </form>
                    </div>
                </div>
            </div>



    </body>
</html>
