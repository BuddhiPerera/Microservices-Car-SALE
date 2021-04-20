

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


$("#tbl-customers tbody").on('click', "tr td:last-child", function (eventData) {
    var row = $(this).parents("tr");
    eventData.stopPropagation();
    if (confirm("Are you sure whether you want delete this Item?")) {
        $.ajax({
            method: 'DELETE',
            url: 'http://localhost/Product/rest/products/delete/' + row.find('td:first-child').text(),
            async: true
        }).done(function (response, status, jqXHR) {
            row.remove();
        }).fail(function (jqXHR, status, error) {
            console.log(error);
        });
    }
});



$("#btnsubmit").click(function () {
    var customer = {
        id: $("#txtId").val(),
        name: $("#txtName").val(),
        address: $("#txtCustomerAddress").val()
    };


        var ajaxConfig = {
            method: 'POST',
            url: 'http://localhost/Product/rest/products/save/',
            async: true,
            contentType: 'application/json',
            data: JSON.stringify(customer)
        };
        $.ajax(ajaxConfig).done(function (response, status, jqXHR) {
            var html = "<tr>" +
                "<td>" + customer.id + "</td>" +
                "<td>" + customer.name + "</td>" +
                "<td>" + customer.address + "</td>" +
                '<td><i class="fa fa-trash"></i></td>' +
                "</tr>";
            $("#tbl-customers tbody").append(html);
            $("#txtId, #txtName, #txtCustomerAddress").val("");
            $("#txtId").focus();
        }).fail(function (jqXHR, status, error) {
            console.log(error);
        });

    console.log("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

});