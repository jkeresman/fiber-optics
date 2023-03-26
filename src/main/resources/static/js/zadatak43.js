$(document).ready(function() {
    $('#izracunaj-43').click(function(event) {
        event.preventDefault();
        var formData = {
            "Pod": $('#Pod').val(),
            "b": $('#b').val(),
            "l": $('#l').val(),
            "lambda": $('#lambda').val(),
            "alpha": $('#alpha').val(),
            "alpha-s": $('#alpha-s').val(),
            "alpha-k": $('#alpha-k').val(),
            "nb": $('#nb').val(),
            "ls": $('#ls').val(),
            "la": $('#la').val(),
            "ms": $('#ms').val()
        };

        $.ajax({
            url: "/zadatak/43/calculate",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(formData),
            dataType: "json",
            success: function(response) {
                $("#rez-ga").val(response.rjesenjeGa.toFixed(4) + " dB");
                $("#rez-na").val(response.rjesenjeNa);
                $("#rez-ns").val(response.rjesenjeNs);
                $("#rez-ppr").val(response.rjesenjePpr.toFixed(4) + " dbm");

            },
            error: function(xhr, status, error) {
                alert(error);
            }
        });
    });
});
