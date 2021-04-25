$(document).ready(function () {
    loadProducts();
});
var selectedRow = null;
function loadProducts() {

    var ajaxConfig = {
        url: "http://localhost/Product/rest/products/login",
        method: "GET",
        async: 'json'
    }
    var i = 0;
    $.ajax(ajaxConfig).done(function (product, status, jQXHB) {
        for (var i = 0; i < product.length; i++) {
        }
        console.log(product)
    }).fail(function (jqXHB, status, error) {
        console.log(error)
    })
}