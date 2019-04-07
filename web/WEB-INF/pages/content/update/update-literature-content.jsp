 


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid text-center">    
    <div class="row content">

        <div class="col-sm-12 text-left"> 


            <div id="alarmmsg" >
                <h4 id="h3success"><b>${suceessMessage}</b></h4>  
            </div>
            <div id="alarmmsgerror" >
                <h4 id="h3error"><b> ${errorMessage} </b></h4>  

            </div>
            <form  method="POST" action="/WebDiplomski/controller" id="formUpdate">
                <input type="hidden" name="action" value="update_literature_execute"/> 
                 <input type="hidden" name="litaratureID" value="${l.getSifraKnjige()}"/> 
                <table id="myTable" >
                    <tbody>
                        <tr>
                            <td>Naziv knjige :</td>
                            <td>
                                <div class="form-group col-md-12">
                                    <input class="form-control" name="naziv_knjige" placeholder="Naziv knjige" value="${l.getNazivKnjige()}">
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>Izdanje :</td>
                            <td>
                                <div class="form-group col-md-12">
                                    <input class="form-control" name="izdanje" placeholder="Izdanje" value="${l.getIzdanje()}">
                                </div>                                                              
                            </td>
                        </tr>



                        <tr>
                            <td>Izdavac :</td>
                            <td>
                                <div class="form-group col-md-12">
                                    <select name="izdavac" class="chosen-select" style="width: 300px;">
                                        <option value="${iz.getSifraIzdavaca()}">${iz}  </option>  
                                        <c:forEach items="${listaI}" var="i">
                                            <option value="${i.getSifraIzdavaca()}">${i}  </option>         
                                        </c:forEach> 
                                    </select>
                                </div>
                            </td>

                        </tr>
                        <tr>
                            <td>Trenutni autori :</td>

                            <td>
                                <table class="table table-striped col-md-2" id="tabelaAutori">
                                    <thead>
                                    <th>
                                        Ime
                                    </th>
                                    <th>
                                        Prezime
                                    </th>
                                    <th>Akcija </th>
                                    </thead>
                                    <tbody>

                                        <tr>
                                            <c:forEach var="a" items="${l.getAutorliteraturaList()}">
                                                 
                                                <td > ${a.getAutor().getImeAutora()}</td>
                                                <td>${a.getAutor().getPrezimeAutora()} </td>
                                                <td> <button type="button" name="view_details" class="btn btn-danger btn-xs remove_details_empl del">Obrisi autora</button> </td>
                                                <td><input hidden="true" name="sifre[]" value="${a.getAutor().getSifraAutora()}"/> </td>
                                            </tr>
                                        </c:forEach> 
                                    </tbody>
                                </table>                                                            
                            </td>

                            </td> 
                        </tr>
                        <tr>
                            <td>Novi autori :</td>
                            <td>
                                <div class="form-group col-md-12">
                                    <select name="autori[]" multiple class="chosen-select" style="width: 300px;">

                                        <c:forEach items="${listaA}" var="a">
                                            <option value="${a.getSifraAutora()}">${a}  </option>  
                                        </c:forEach> 
                                    </select>
                                </div>
                            </td>

                        </tr>
                        <tr>                       
                            <td>
                                <div class="form-group col-md-10">
                                    <input type="submit" class=" btn-lg" value="Izmeni literaturu" id="myButton"  />
                                </div>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>




        </div>

    </div>
</div>

<script>
   



    $(document).ready(function () {
        $("#myTable").on('click', '.del', function () {
            if (confirm("Da li zelite da obriste autora")) {
                $(this).closest('tr').remove();
            } else {
                return false;
            }

        });
    });


    setTimeout(function () {
        document.getElementById("alarmmsgerror").innerHTML = '';
    }, 4000);

    setTimeout(function () {
        document.getElementById("alarmmsg").innerHTML = '';
    }, 4000);
    $('.chosen-select').chosen();
    $('.chosen-select-deselect').chosen({allow_single_deselect: true});

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



        $('#formAddLiterature').validate({
            rules: {
                naziv_knjige: {
                    required: true,

                },
                izdanje: {
                    required: true,
                    nowhitespace: true,

                }

            },
            messages: {
                naziv_knjige: {
                    required: 'Molimo popunite polje',

                },
                izdanje: {
                    required: "Molimo popunite polje",

                }
            }


        });

    });



</script>

<style>
    #tabelaAutori{
        margin-left: 17px;
    }

    #h3success{
        color: green;
    }
    #h3error{
        color: red;
    }
    #myButton {



        padding: 10px 25px;
        text-align: center;
        text-decoration:  #111;
        display: inline-block;
        font-size: 16px;
        margin-left: -20px;
    }
    .chosen-select {
        width: 100%; 
    }

    .chosen-select-deselect {
        width: 100%; }

    .chosen-container {
        display: inline-block;
        font-size: 14px;
        position: relative;
        vertical-align: middle; }
    .chosen-container .chosen-drop {
        background: #fff;
        border: 1px solid #ccc;
        border-bottom-right-radius: 4px;
        border-bottom-left-radius: 4px;
        -webkit-box-shadow: 0 8px 8px rgba(0, 0, 0, 0.25);
        box-shadow: 0 8px 8px rgba(0, 0, 0, 0.25);
        margin-top: -1px;
        position: absolute;
        top: 100%;
        left: -9000px;
        z-index: 1060; }
    .chosen-container.chosen-with-drop .chosen-drop {
        left: 0;
        right: 0; }
    .chosen-container .chosen-results {
        color: #555555;
        margin: 0 4px 4px 0;
        max-height: 240px;
        padding: 0 0 0 4px;
        position: relative;
        overflow-x: hidden;
        overflow-y: auto;
        -webkit-overflow-scrolling: touch; }
    .chosen-container .chosen-results li {
        display: none;
        line-height: 1.42857;
        list-style: none;
        margin: 0;
        padding: 5px 6px; }
    .chosen-container .chosen-results li em {
        background: #feffde;
        font-style: normal; }
    .chosen-container .chosen-results li.group-result {
        display: list-item;
        cursor: default;
        color: #999;
        font-weight: bold; }
    .chosen-container .chosen-results li.group-option {
        padding-left: 15px; }
    .chosen-container .chosen-results li.active-result {
        cursor: pointer;
        display: list-item; }
    .chosen-container .chosen-results li.highlighted {
        background-color: #337ab7;
        background-image: none;
        color: white; }
    .chosen-container .chosen-results li.highlighted em {
        background: transparent; }
    .chosen-container .chosen-results li.disabled-result {
        display: list-item;
        color: #777777; }
    .chosen-container .chosen-results .no-results {
        background: #eeeeee;
        display: list-item; }
    .chosen-container .chosen-results-scroll {
        background: white;
        margin: 0 4px;
        position: absolute;
        text-align: center;
        width: 321px;
        z-index: 1; }
    .chosen-container .chosen-results-scroll span {
        display: inline-block;
        height: 1.42857;
        text-indent: -5000px;
        width: 9px; }
    .chosen-container .chosen-results-scroll-down {
        bottom: 0; }
    .chosen-container .chosen-results-scroll-down span {
        background: url("chosen-sprite.png") no-repeat -4px -3px; }
    .chosen-container .chosen-results-scroll-up span {
        background: url("chosen-sprite.png") no-repeat -22px -3px; }

    .chosen-container-single .chosen-single {
        background-color: #fff;
        -webkit-background-clip: padding-box;
        -moz-background-clip: padding;
        background-clip: padding-box;
        border: 1px solid #ccc;
        border-top-right-radius: 4px;
        border-top-left-radius: 4px;
        border-bottom-right-radius: 4px;
        border-bottom-left-radius: 4px;
        -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
        box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
        color: #555555;
        display: block;
        height: 34px;
        overflow: hidden;
        line-height: 34px;
        padding: 0 0 0 8px;
        position: relative;
        text-decoration: none;
        white-space: nowrap; }
    .chosen-container-single .chosen-single span {
        display: block;
        margin-right: 26px;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap; }
    .chosen-container-single .chosen-single abbr {
        background: url("chosen-sprite.png") right top no-repeat;
        display: block;
        font-size: 1px;
        height: 10px;
        position: absolute;
        right: 26px;
        top: 12px;
        width: 12px; }
    .chosen-container-single .chosen-single abbr:hover {
        background-position: right -11px; }
    .chosen-container-single .chosen-single.chosen-disabled .chosen-single abbr:hover {
        background-position: right 2px; }
    .chosen-container-single .chosen-single div {
        display: block;
        height: 100%;
        position: absolute;
        top: 0;
        right: 0;
        width: 18px; }
    .chosen-container-single .chosen-single div b {
        background: url("chosen-sprite.png") no-repeat 0 7px;
        display: block;
        height: 100%;
        width: 100%; }
    .chosen-container-single .chosen-default {
        color: #777777; }
    .chosen-container-single .chosen-search {
        margin: 0;
        padding: 3px 4px;
        position: relative;
        white-space: nowrap;
        z-index: 1000; }
    .chosen-container-single .chosen-search input[type="text"] {
        background: url("chosen-sprite.png") no-repeat 100% -20px, #fff;
        border: 1px solid #ccc;
        border-top-right-radius: 4px;
        border-top-left-radius: 4px;
        border-bottom-right-radius: 4px;
        border-bottom-left-radius: 4px;
        -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
        box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
        margin: 1px 0;
        padding: 4px 20px 4px 4px;
        width: 100%; }
    .chosen-container-single .chosen-drop {
        margin-top: -1px;
        border-bottom-right-radius: 4px;
        border-bottom-left-radius: 4px;
        -webkit-background-clip: padding-box;
        -moz-background-clip: padding;
        background-clip: padding-box; }

    .chosen-container-single-nosearch .chosen-search input[type="text"] {
        position: absolute;
        left: -9000px; }

    .chosen-container-multi .chosen-choices {
        background-color: #fff;
        border: 1px solid #ccc;
        border-top-right-radius: 4px;
        border-top-left-radius: 4px;
        border-bottom-right-radius: 4px;
        border-bottom-left-radius: 4px;
        -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
        box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
        cursor: text;
        height: auto !important;
        height: 1%;
        margin: 0;
        overflow: hidden;
        padding: 0;
        position: relative; }
    .chosen-container-multi .chosen-choices li {
        float: left;
        list-style: none; }
    .chosen-container-multi .chosen-choices .search-field {
        margin: 0;
        padding: 0;
        white-space: nowrap; }
    .chosen-container-multi .chosen-choices .search-field input[type="text"] {
        background: transparent !important;
        border: 0 !important;
        -webkit-box-shadow: none;
        box-shadow: none;
        color: #555555;
        height: 32px;
        margin: 0;
        padding: 4px;
        outline: 0; }
    .chosen-container-multi .chosen-choices .search-field .default {
        color: #999; }
    .chosen-container-multi .chosen-choices .search-choice {
        -webkit-background-clip: padding-box;
        -moz-background-clip: padding;
        background-clip: padding-box;
        background-color: #eeeeee;
        border: 1px solid #ccc;
        border-top-right-radius: 4px;
        border-top-left-radius: 4px;
        border-bottom-right-radius: 4px;
        border-bottom-left-radius: 4px;
        background-image: -webkit-linear-gradient(top, white 0%, #eeeeee 100%);
        background-image: -o-linear-gradient(top, white 0%, #eeeeee 100%);
        background-image: linear-gradient(to bottom, white 0%, #eeeeee 100%);
        background-repeat: repeat-x;
        filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#FFFFFFFF', endColorstr='#FFEEEEEE', GradientType=0);
        -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
        box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
        color: #333333;
        cursor: default;
        line-height: 13px;
        margin: 6px 0 3px 5px;
        padding: 3px 20px 3px 5px;
        position: relative; }
    .chosen-container-multi .chosen-choices .search-choice .search-choice-close {
        background: url("chosen-sprite.png") right top no-repeat;
        display: block;
        font-size: 1px;
        height: 10px;
        position: absolute;
        right: 4px;
        top: 5px;
        width: 12px;
        cursor: pointer; }
    .chosen-container-multi .chosen-choices .search-choice .search-choice-close:hover {
        background-position: right -11px; }
    .chosen-container-multi .chosen-choices .search-choice-focus {
        background: #d4d4d4; }
    .chosen-container-multi .chosen-choices .search-choice-focus .search-choice-close {
        background-position: right -11px; }
    .chosen-container-multi .chosen-results {
        margin: 0 0 0 0;
        padding: 0; }
    .chosen-container-multi .chosen-drop .result-selected {
        display: none; }

    .chosen-container-active .chosen-single {
        border: 1px solid #66afe9;
        -webkit-box-shadow: 0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px #66afe9;
        box-shadow: 0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px #66afe9;
        -webkit-transition: border linear 0.2s, box-shadow linear 0.2s;
        -o-transition: border linear 0.2s, box-shadow linear 0.2s;
        transition: border linear 0.2s, box-shadow linear 0.2s; }
    .chosen-container-active.chosen-with-drop .chosen-single {
        background-color: #fff;
        border: 1px solid #66afe9;
        border-bottom-right-radius: 0;
        border-bottom-left-radius: 0;
        -webkit-box-shadow: 0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px #66afe9;
        box-shadow: 0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px #66afe9;
        -webkit-transition: border linear 0.2s, box-shadow linear 0.2s;
        -o-transition: border linear 0.2s, box-shadow linear 0.2s;
        transition: border linear 0.2s, box-shadow linear 0.2s; }
    .chosen-container-active.chosen-with-drop .chosen-single div {
        background: transparent;
        border-left: none; }
    .chosen-container-active.chosen-with-drop .chosen-single div b {
        background-position: -18px 7px; }
    .chosen-container-active .chosen-choices {
        border: 1px solid #66afe9;
        border-bottom-right-radius: 0;
        border-bottom-left-radius: 0;
        -webkit-box-shadow: 0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px #66afe9;
        box-shadow: 0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px #66afe9;
        -webkit-transition: border linear 0.2s, box-shadow linear 0.2s;
        -o-transition: border linear 0.2s, box-shadow linear 0.2s;
        transition: border linear 0.2s, box-shadow linear 0.2s; }
    .chosen-container-active .chosen-choices .search-field input[type="text"] {
        color: #111 !important; }
    .chosen-container-active.chosen-with-drop .chosen-choices {
        border-bottom-right-radius: 0;
        border-bottom-left-radius: 0; }

    .chosen-disabled {
        cursor: default;
        opacity: 0.5 !important; }
    .chosen-disabled .chosen-single {
        cursor: default; }
    .chosen-disabled .chosen-choices .search-choice .search-choice-close {
        cursor: default; }

    .chosen-rtl {
        text-align: right; }
    .chosen-rtl .chosen-single {
        padding: 0 8px 0 0;
        overflow: visible; }
    .chosen-rtl .chosen-single span {
        margin-left: 26px;
        margin-right: 0;
        direction: rtl; }
    .chosen-rtl .chosen-single div {
        left: 7px;
        right: auto; }
    .chosen-rtl .chosen-single abbr {
        left: 26px;
        right: auto; }
    .chosen-rtl .chosen-choices .search-field input[type="text"] {
        direction: rtl; }
    .chosen-rtl .chosen-choices li {
        float: right; }
    .chosen-rtl .chosen-choices .search-choice {
        margin: 6px 5px 3px 0;
        padding: 3px 5px 3px 19px; }
    .chosen-rtl .chosen-choices .search-choice .search-choice-close {
        background-position: right top;
        left: 4px;
        right: auto; }
    .chosen-rtl.chosen-container-single .chosen-results {
        margin: 0 0 4px 4px;
        padding: 0 4px 0 0; }
    .chosen-rtl .chosen-results .group-option {
        padding-left: 0;
        padding-right: 15px; }
    .chosen-rtl.chosen-container-active.chosen-with-drop .chosen-single div {
        border-right: none; }
    .chosen-rtl .chosen-search input[type="text"] {
        background: url("chosen-sprite.png") no-repeat -28px -20px, #fff;
        direction: rtl;
        padding: 4px 5px 4px 20px; }

    @media only screen and (-webkit-min-device-pixel-ratio: 2), only screen and (min-resolution: 2dppx) {
        .chosen-rtl .chosen-search input[type="text"],
        .chosen-container-single .chosen-single abbr,
        .chosen-container-single .chosen-single div b,
        .chosen-container-single .chosen-search input[type="text"],
        .chosen-container-multi .chosen-choices .search-choice .search-choice-close,
        .chosen-container .chosen-results-scroll-down span,
        .chosen-container .chosen-results-scroll-up span {
            background-image: url("chosen-sprite@2x.png") !important;
            background-size: 52px 37px !important;
            background-repeat: no-repeat !important; } }

    /*# sourceMappingURL=bootstrap-chosen.css.map */

</style>