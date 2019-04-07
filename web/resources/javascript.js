/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
setTimeout(function () {
    document.getElementById("alarmmsgerror").innerHTML = '';
}, 4000);

setTimeout(function () {
    document.getElementById("alarmmsg").innerHTML = '';
}, 4000);

$(document).ready(function () {
    $("#myButtonRole").click(function () {
        $("#myFormRole").submit();
    });
});

$(document).ready(function () {
    $("#myButton").click(function () {
        $("#myForm").submit();
    });
});


 



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

    $('#user_form').validate({
        rules: {
            sk_godina: {
                required: true,
                nowhitespace: true,

            },
            naziv_knjige: {
                required: true,

                lettersonly: true,
            },
            izdanje: {
                required: true,

                lettersonly: true,

            },
            izdavac: {
                required: true,

                lettersonly: true,

            },

        },
        messages: {
            sk_godina: {
                required: 'Molimo popunite polje',

            },
            naziv_knjige: {
                required: "Molimo popunite polje"

            },
            izdanje: {
                required: "Molimo popunite polje"

            },
            izdavac: {
                required: "Molimo popunite polje"

            },
        }
    });

});










$(function () {

    $.validator.addMethod('kombo', function (value, element) {
        return value != -1;

    }, 'Morate da izaberete zvanje')

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

    }, 'Korisnicka sifra mora da sadrzi vise od 6 znakova')
    $.validator.addMethod('kombo', function (value, element) {
        return value != -1;

    }, 'Morate da izaberete zvanje')
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
                lettersonly: true,

            },
            zvanje: {
                kombo: true,
            },
            email_zap: {
                required: true,
                email: true,
                nowhitespace: true,

            },
            kab_zap: {
                required: true,
                nowhitespace: true,

            },
            kor_ime_zap: {
                required: true,
                nowhitespace: true,

            },
            kor_sif_zap: {
                required: true,
                strongPassword: true,
                nowhitespace: true,
                lettersonly: true,

            },

            tel_zap: {
                required: true,
                nowhitespace: true,
            },
            prezime_zap: {
                required: true,
                nowhitespace: true,
                lettersonly: true,
            },

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

            },
        }
    });
});

$(document).ready(function () {

    var count = 0;

    $('#user_dialog').dialog({
        autoOpen: false,
        width: 400
    });

    $('#add').click(function () {
        $('#user_dialog').dialog('option', 'title', 'Dodavanje autora');
        $('#first_name').val('');
        $('#last_name').val('');
        $('#error_first_name').text('');
        $('#error_last_name').text('');
        $('#first_name').css('border-color', '');
        $('#last_name').css('border-color', '');
        $('#save').text('Dodaj');
        $('#user_dialog').dialog('open');
    });

    $('#save').click(function () {
        var error_first_name = '';
        var error_last_name = '';
        var first_name = '';
        var last_name = '';
        if ($('#first_name').val() == '')
        {
            error_first_name = 'First Name is required';
            $('#error_first_name').text(error_first_name);
            $('#first_name').css('border-color', '#cc0000');
            first_name = '';
        } else
        {
            error_first_name = '';
            $('#error_first_name').text(error_first_name);
            $('#first_name').css('border-color', '');
            first_name = $('#first_name').val();
        }
        if ($('#last_name').val() == '')
        {
            error_last_name = 'Last Name is required';
            $('#error_last_name').text(error_last_name);
            $('#last_name').css('border-color', '#cc0000');
            last_name = '';
        } else
        {
            error_last_name = '';
            $('#error_last_name').text(error_last_name);
            $('#last_name').css('border-color', '');
            last_name = $('#last_name').val();
        }
        if (error_first_name != '' || error_last_name != '')
        {
            return false;
        } else
        {
            if ($('#save').text() == 'Dodaj')
            {
                count = count + 1;
                output = '<tr id="row_' + count + '">';
                output += '<td>' + first_name + ' <input type="hidden" name="hidden_first_name[]" id="first_name' + count + '" class="first_name" value="' + first_name + '" /></td>';
                output += '<td>' + last_name + ' <input type="hidden" name="hidden_last_name[]" id="last_name' + count + '" value="' + last_name + '" /></td>';
                output += '<td><button type="button" name="view_details" class="btn btn-warning btn-xs view_details" id="' + count + '">Izmeni</button></td>';
                output += '<td><button type="button" name="remove_details" class="btn btn-danger btn-xs remove_details" id="' + count + '">Obrisi</button></td>';
                output += '</tr>';
                $('#user_data').append(output);
            } else
            {
                var row_id = $('#hidden_row_id').val();
                output = '<td>' + first_name + ' <input type="hidden" name="hidden_first_name[]" id="first_name' + row_id + '" class="first_name" value="' + first_name + '" /></td>';
                output += '<td>' + last_name + ' <input type="hidden" name="hidden_last_name[]" id="last_name' + row_id + '" value="' + last_name + '" /></td>';
                output += '<td><button type="button" name="view_details" class="btn btn-warning btn-xs view_details" id="' + row_id + '">Izmeni</button></td>';
                output += '<td><button type="button" name="remove_details" class="btn btn-danger btn-xs remove_details" id="' + row_id + '">Obrisi</button></td>';
                $('#row_' + row_id + '').html(output);
            }

            $('#user_dialog').dialog('close');
        }
    });

    $(document).on('click', '.view_details', function () {
        var row_id = $(this).attr("id");
        var first_name = $('#first_name' + row_id + '').val();
        var last_name = $('#last_name' + row_id + '').val();
        $('#first_name').val(first_name);
        $('#last_name').val(last_name);
        $('#save').text('Izmeni');
        $('#hidden_row_id').val(row_id);
        $('#user_dialog').dialog('option', 'title', 'Izmeni autora');
        $('#user_dialog').dialog('open');
    });

    $(document).on('click', '.remove_details_role', function () {
        var row_id = $(this).attr("id");
        if (confirm("Da li zelite da obrisete ulogu?"))
        {
            $('#row_' + row_id + '').remove();
        } else
        {
            return false;
        }
    });

    $('#action_alert').dialog({
        autoOpen: false
    });

    $('#user_form').on('submit', function (event) {
        event.preventDefault();
        var count_data = 0;
        $('.first_name').each(function () {
            count_data = count_data + 1;
        });
        if (count_data > 0)
        {
            var form_data = $(this).serialize();

            $.ajax({
                url: "/WebDiplomski/controller",
                method: "POST",
                data:
                        form_data,

                success: function (data)
                {
                    $('#user_data').find("tr:gt(0)").remove();
                    $('#action_alert').html('<p>Data Inserted Successfully</p>');
                    $('#action_alert').dialog('open');
                }
            })
        } else
        {
            $('#action_alert').html('<p>Please Add atleast one data</p>');
            $('#action_alert').dialog('open');
        }
    });

});