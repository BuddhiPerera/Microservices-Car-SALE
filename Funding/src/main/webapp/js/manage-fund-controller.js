$(document).ready(function () {

    loadProducts();
});
var selectedRow = null;
function loadProducts() {

    var ajaxConfig = {
        url: "http://localhost:8085/Funding/rest2/funds/getfunds",
        method: "GET",
        async: 'json'
    }
    var i = 0;
    $.ajax(ajaxConfig).done(function (funds, status, jQXHB) {
        for (var i = 0; i < funds.length; i++) {
            var html =
                '<tr>' +
                '<td>' + funds[i].id + '</td>' +
                '<td>' + funds[i].fundName + '</td>' +
                '<td>' + funds[i].email + '</td>' +
                '<td>' + funds[i].address + '</td>' +
                '<td>' + funds[i].contactNumber + '</td>' +
                '<td>' + funds[i].amount + '</td>' +
                '<td>' + funds[i].fundMethod + '</td>' +
                '</tr>';
            $("#datatable tbody").append(html);
        }
        console.log(funds)
    }).fail(function (jqXHB, status, error) {
        console.log(error)

    })

}
$("#btnDelete").click(function (){
    $("#datatable tbody").on('click', "tr td:last-child", function (eventData) {
        var row = $(this).parents("tr");
        eventData.stopPropagation();
        if (confirm("Are you sure whether you want delete this Item?")) {
            $.ajax({
                method: 'DELETE',
                url:  'http://localhost:8085/Funding/rest2/funds/delete/' + row.find('td:first-child').text(),
                async: true
            }).done(function (response, status, jqXHR) {
                row.remove();
            }).fail(function (jqXHR, status, error) {
                console.log(error);
            });
        }
    });

})


$("#btnsubmit").click(function () {
    var funds = {
        id: $("#id").val(),
        fundName: $("#fundName").val(),
        email: $("#email").val(),
        address: $("#address").val(),
        contactNumber: $("#contactNumber").val(),
        amount: $("#amount").val(),
        fundMethod: $("#fundMethod").val(),

    };
    if (!selectedRow) {
        var ajaxConfig = {
            method: 'POST',
            url: 'http://localhost/Funding/rest2/fundss/save/',
            async: true,
            contentType: 'application/json',
            data: JSON.stringify(product)
        };
        $.ajax(ajaxConfig).done(function (response, status, jqXHR) {
            var html = "<tr>" +
                "<td>" + funds.id + "</td>" +
                "<td>" + funds.fundName + "</td>" +
                "<td>" + funds.email + "</td>" +
                "<td>" + funds.address + "</td>" +
                "<td>" + funds.contactNumber + "</td>" +
                "<td>" + funds.amount + "</td>" +
                "<td>" + funds.fundMethod + "</td>" +
                "</tr>";
            $("#dtble tbody").append(html);
            $("#id, #fundName, #email, #address,#contactNumber,#amount,#fundMethod").val("");
            $("#id").focus();
        }).fail(function (jqXHR, status, error) {
            console.log(error);
        });
    } else {
        var ajaxConfig = {
            method: 'PUT',
            url: 'http://localhost/Product/rest/products/update/',
            async: true,
            contentType: 'application/json',
            data: JSON.stringify(product)
        };
        $.ajax(ajaxConfig).done(function (response, status, jqXHR) {
            selectedRow.find("td:nth-child(1)").text(funds.id);
            selectedRow.find("td:nth-child(2)").text(funds.fundName);
            selectedRow.find("td:nth-child(3)").text(funds.email);
            selectedRow.find("td:nth-child(4)").text(funds.address);
            selectedRow.find("td:nth-child(5)").text(funds.contactNumber);
            selectedRow.find("td:nth-child(6)").text(funds.amount);
            selectedRow.find("td:nth-child(7)").text(funds.fundMethod).src;


        }).fail(function (jqXHR, status, error) {
            console.log(error);
        }).always(function(){
            $("#btnClear").click();
        });
    }


});







$("#datatable tbody").on('click', 'tr', function () {
    selectedRow = $(this);
    $("#id").val($(this).find("td:first-child").text());
    $("#fundName").val($(this).find("td:nth-child(2)").text());
    $("#email").val($(this).find("td:nth-child(3)").text());
    $("#address").val($(this).find("td:nth-child(4)").text());
    $("#contactNumber").val($(this).find("td:nth-child(5)").text());
    $("#amount").val($(this).find("td:nth-child(6)").text());
    $("#setType").val($(this).find("td:nth-child(7)").text());




    $("#id").attr("disabled", 'true');
    $("#datatable tbody tr").removeClass('row-selected');
    selectedRow.addClass('row-selected');
});

function initializePagination(totalElements) {

    var totalPages = parseInt(totalElements / 5 + (((totalElements % 5) !== 0) ? 1 : 0));
    $(".page-item").remove();

    var html = '<li class="page-item"><a class="page-link" href="javascript:void(0)">&laquo;</a></li>';

    for (var i = 0; i < totalPages; i++) {
        html += '<li class="page-item"><a class="page-link" href="#">' + (i + 1) + '</a></li>'
    }

    html += '<li class="page-item"><a class="page-link" href="#">&raquo;</a></li>';

    $(".card-footer .pagination").html(html);

    $(".card-footer .pagination .page-item:first-child").click(function () {
        loadProducts(0);
    });

    $(".card-footer .pagination .page-item:last-child").click(function () {
        loadProducts(totalPages - 1);
    });

    $(".card-footer .pagination .page-item").click(function () {
        var number = parseInt($(this).find("a").text());
        if (number) {
            loadProducts(number - 1);
        }
    })
}