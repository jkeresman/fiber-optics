$(document).ready(function () {
    $("#zadatak-42").submit(function (event) {
        event.preventDefault();
        var formData = {
            ls: $("#ls").val(),
            as: $("#alpha-s").val(),
            ak: $("#alpha-k").val(),
            ga: $("#ga").val(),
            ms: $("#ms").val()
        };
        $.ajax({
            type: "POST",
            url: "/zadatak/42",
            data: JSON.stringify(formData),
            contentType: "application/json",
            dataType: "json",
            success: function (response) {
                $("#ptx").val(response.toFixed(4) + " mW");
            },
            error: function(xhr, status, error) {
                console.error(error);
            }
        });
    });
});
