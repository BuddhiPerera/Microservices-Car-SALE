$(document).ready(function () {
    loadProduct();
});
var selectedRow = null;

function loadProduct() {
    var ajaxConfig = {
        url: "http://localhost/Product/rest/products/getProduct",
        method: "GET",
        async: 'json'
    }
    var i = 0;

    $.ajax(ajaxConfig).done(function (product, status, jQXHB) {

        document.getElementById("itemPrice").innerHTML = product.id;
        document.getElementById("titleName").innerHTML = product.name;
        document.getElementById("description").innerHTML = product.description;
        document.getElementById("shipping").innerHTML = product.shipping;
        document.getElementById("myImg").src = product.image;

    }).fail(function (jqXHB, status, error) {
        console.log(error);
    });
}
