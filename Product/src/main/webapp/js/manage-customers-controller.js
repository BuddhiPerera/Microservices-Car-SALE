
var ajaxConfig = {
    url: "http://localhost/Product/rest/products/getProducts",
    method: "GET",
    async: 'json'
}
var i = 0;
$.ajax(ajaxConfig).done(function (product, status, jQXHB) {
    for (var i = 0; i < product.length; i++) {
        var html = '<tr>' +
            '<td>' + product[i].id + '</td>' +
            '<td>' + product[i].name + '</td>' +
            '<td>' + product[i].description + '</td>' +
            '<td>' + product[i].price + '</td>' +
            '<td>' + product[i].qty + '</td>' +
            '<td>' + product[i].shipping + '</td>' +
            '<td>' + product[i].image + '</td>' +
            '<td><i class="fas fa-trash"></i></td>' +
            '</tr>';
        $("#tbl-customers tbody").append(html);
    }
    console.log(product)
}).fail(function (jqXHB, status, error) {
    console.log(error)

})



