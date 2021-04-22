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
            +'<td >'+product[i].id +'</td>'
            +'<td style="height: 100px; width: 20%">'
            +'<img style="height: 160px; width: 100%;" src='+product[i].image+'>'+'</td>'
            +'<td style="height: 100px; width: 80%">'
            +'<h1>'+product[i].name +'</h1>'
            +'<h4>'+product[i].description +'</h4>'
            +'<h2 style="font-weight: bolder">'+'$ '+ product[i].price +'</h2>'
            +'<h4>'+product[i].qty +'</h4>'
            +'<h5>'+product[i].shipping +'</h5>'
            +'</td>'
            +'</tr>';

        $("#datatable tbody").append(html);

        var elem = document.querySelector('#some-element');

    }
    console.log(product);
}).fail(function (jqXHB, status, error) {
    console.log(error);
});

$("#datatable tbody").on('click', 'tr', function () {
    selectedRow = $(this);

    var itemId = $("#datatable tr td:first-child").text();
    alert(itemId)

    $("#itemPay").val($(this).find("td:first-child").text());

});
