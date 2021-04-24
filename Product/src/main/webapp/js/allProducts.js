$(document).ready(function () {
    loadProducts();
});
var selectedRow = null;

function loadProducts() {
    var ajaxConfig = {
        url: "http://localhost/Product/rest/products/getProducts",
        method: "GET",
        async: 'json'
    }
    var i = 0;

    $.ajax(ajaxConfig).done(function (product, status, jQXHB) {
        for (var i = 0; i < product.length; i++) {
            var html =
                '<tr>'
                + '<td style="visibility: hidden">' + product[i].id + '</td>'
                + '<td style="height: 100px; width: 20%">'
                + '<img style="height: 160px; width: 100%;" src=' + product[i].image + '>' + '</td>'
                + '<td style="height: 100px; width: 80%">'
                + '<h1>' + product[i].name + '</h1>'
                + '<h4>' + product[i].description + '</h4>'
                + '<h2 style="font-weight: bolder">' + '$ ' + product[i].price + '</h2>'
                + '<h4>' + product[i].qty + '</h4>'
                + '<h5>' + product[i].shipping + '</h5>'
                + '</td>' +
                '<td >' + '<img style="height: 35px; width: 35px;" src=' +  + '/>' + '</td>' +
                +'</tr>';

            $("#datatable tbody").append(html);

            var elem = document.querySelector('#some-element');

        }
        console.log(product);
    }).fail(function (jqXHB, status, error) {
        console.log(error);
    });
}

/*$("#datatable tbody").on('click', 'tr td', function () {
    var row = $(this).parents("tr");

    var itemId = row.find('td:first-child').text();
    alert(itemId)
    document.getElementById("itemPay").value = itemId;
});*/

$("#datatable tbody").on('click', "tr td:last-child", function (eventData) {
    var row = $(this).parents("tr");
    eventData.stopPropagation();
    var value = "";
    value = row.find('td:first-child').text();
    if (value !== "") {
        var ajaxConfig = {
            url: "http://localhost/Product/rest/products/setProduct/" + value,
            method: "GET",
            async: 'json'
        };
        $.ajax(ajaxConfig).done(function (response, status, jqXHR) {

            window.location.href = "http://localhost/Product/e-commers.jsp";

        }).fail(function (jqXHR, status, error) {

        });
    }


});

document.getElementById("demo")
$(window).scroll(function () {
    if ($(document).scrollTop() > 200) {
        $(".button1x1").show();
    } else {
        $(".button1x1").hide();
    }
});

