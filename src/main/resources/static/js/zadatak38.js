$(document).ready(function () {
    $("#zadatak-38").submit(function (event) {
        event.preventDefault();
        var formData = {
            'Pod': $('input[name=Pod]').val(),
            'b': $('input[name=b]').val(),
            'delta-lambda': $('input[name=delta-lambda]').val(),
            'lambda': $('input[name=lambda]').val(),
            'alpha': $('input[name=alpha]').val(),
            'alpha-s': $('input[name=alpha-s]').val(),
            'alpha-k': $('input[name=alpha-k]').val(),
            'nb': $('input[name=nb]').val(),
            'l1': $('input[name=l1]').val(),
            'd': $('input[name=d]').val(),
            'ms': $('input[name=ms]').val()
        };
        $.ajax({
            type: "POST",
            url: "/zadatak/38/calculate",
            data: JSON.stringify(formData),
            contentType: "application/json",
            dataType: "json",
            success: function (response) {
                $("#rez-od").val(response.snagaPrijemnikadbW.toFixed(4) + " dbW");
                $("#rez-a").val(response.rjesenjeA.toFixed(4) + " km");
                $("#rez-b").val(response.rjesenjeB.toFixed(4) + " km");
                $("#rez-c").val(response.rjesenjeC.toFixed(4) + " km");
            },
            error: function (xhr, status, error) {
                alert(error);
            }
        });
    });
});