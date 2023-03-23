$(document).ready(function() {
    $('#converter').submit(function(event) {
        event.preventDefault();
        var formData = $(this).serialize();
        var unit = $('select.form-select-lg').val();
        var watts = $('#vati').val();
        var request = {
            value: watts,
            djelitelj: unit
        };
        $.ajax({
            type: 'POST',
            url: '/zadatak/convert',
            contentType: 'application/json',
            data: JSON.stringify(request),
            success: function(response) {
                $('#izracun').val(response.toFixed(4) + " dbW");
            },
            error: function() {
                alert('Error occurred while trying to convert' + watts + " " + unit + " into dbW");
            }
        });
    });
});