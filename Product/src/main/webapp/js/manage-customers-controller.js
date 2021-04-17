console.log("sssssssssaaaawwwwwwwwwwwwwwwwwwwwwwwwww222")
alert("ddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd")
var ajaxConfig = {
    url: "http://localhost/Product_war/rest/products",
    method: "GET",
    async: 'json'
}
console.log("sssssssssssssss22222222222222222222222222222222222")
var i = 0;
$.ajax(ajaxConfig).done(function (product, status, jQXHB) {
    for (var i = 0; i < product.length; i++) {
        var html = '<tr>' +
            '<td>' + product[i].id + '</td>' +
            '<td>' + product[i].name + '</td>' +
            '<td>' + product[i].address + '</td>' +
            '<td><i class="fas fa-trash"></i></td>' +
            '</tr>';
        $("#tbl-customers tbody").append(html);
    }
    console.log(product)
    console.log("ssssssssssssssssssssssssssssssssssssssssss")
}).fail(function (jqXHB, status, error) {
    console.log(error)
    console.log("ssssssssssssssssssssssssssssssssssssssssss")
})

//////////////////////////////////////////////////////////////////////////


