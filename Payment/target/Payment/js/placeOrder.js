
$("#btnsubmit").click(function () {
    var orderPlace = {
        id: $("#id").val(),
        name: $("#name").val(),
        address: $("#address").val(),
        state: $("#state").val(),
        country: $("#country").val(),
        zip: $("#zip").val(),
        contact: $("#contact").val(),
        qty: $("#qty").val()
    };

    alert("sssssssssssssssssssssssssssssssss")
        var ajaxConfig = {
            method: 'POST',
            url: "http://localhost:8090/Payment/rest/payment/saveOrder/",
            async: true,
            contentType: 'application/json',
            data: JSON.stringify(orderPlace)
        };
        $.ajax(ajaxConfig).done(function (response, status, jqXHR) {


        }).fail(function (jqXHR, status, error) {
            console.log(error);
        });
});