$(document).ready(function () {
    loadUser();
});
var selectedRow = null;
function loadUser() {

    var ajaxConfig = {
        url: "http://localhost/:8081/USER/rest1/buyer",
        method: "GET",
        async: 'json'
    }
    var i = 0;
    $.ajax(ajaxConfig).done(function (buyer, status, jQXHB) {
        for (var i = 0; i < buyer.length; i++) {
            var html = '<tr>' +
                '<td>' + buyer[i].id + '</td>' +
                '<td>' + buyer[i].fName + '</td>' +
                '<td>' + buyer[i].lName + '</td>' +
                '<td>' + buyer[i].email + '</td>' +
                '<td>' + buyer[i].contactNo + '</td>' +
                '<td>' + buyer[i].address + '</td>' +
                '<td>' + buyer[i].zipcode + '</td>'
                '<td><i class="fas fa-trash"></i></td>' +
                '</tr>';
            $("#datatable tbody").append(html);
        }
        console.log(product)
    }).fail(function (jqXHB, status, error) {
        console.log(error)
    })
}

$("#datatable tbody").on('click', "tr td:last-child", function (eventData) {
    var row = $(this).parents("tr");
    eventData.stopPropagation();
    if (confirm("Are you sure whether you want delete this Item?")) {
        $.ajax({
            method: 'DELETE',
            url: 'http://localhost/:8081/USER/rest1/buyer/delete/' + row.find('td:first-child').text(),
            async: true
        }).done(function (response, status, jqXHR) {
            row.remove();
        }).fail(function (jqXHR, status, error) {
            console.log(error);
        });
    }
});

$("#btnsubmit").click(function () {
    var buyer = {
        id: $("#id").val(),
        fName: $("#fName").val(),
        lName: $("#lName").val(),
        email: $("#email").val(),
        contactNo: $("#contactNo").val(),
        address: $("#address").val(),
        zipCode: $("#zipcode").val(),
        password: $("#password").val()
    };
        var ajaxConfig = {
            method: 'POST',
            url: 'http://localhost/:8081/USER/rest1/buyer/save/',
            async: true,
            contentType: 'application/json',
            data: JSON.stringify(buyer)
        };
        $.ajax(ajaxConfig).done(function (response, status, jqXHR) {
            var html = "<tr>" +
                "<td>" + buyer[i].id + "</td>" +
                "<td>" + buyer[i].fName + "</td>" +
                "</td>" + buyer[i].lName + "</td>" +
                "</td>" + buyer[i].email + "</td>" +
                "</td>" + buyer[i].contactNo + "</td>" +
                "</td>" + buyer[i].address + "</td>" +
                "</td>" + buyer[i].zipcode + "</td>" +
                "</td>" + buyer[i].password + "</td>" +
                "</tr>";
            $("#datatable tbody").append(html);
            $("#id, #fName, #lName, #email, #contactNo, #address, #zipcode, #password").val("");
            $("#id").focus();
        }).fail(function (jqXHR, status, error) {
            console.log(error);
        });
});

$("#datatable tbody").on('click', 'tr', function () {
    selectedRow = $(this);
    $("#id").val($(this).find("td:first-child").text());
    $("#fName").val($(this).find("td:nth-child(2)").text());
    $("#lName").val($(this).find("td:nth-child(3)").text());
    $("#email").val($(this).find("td:nth-child(4)").text());
    $("#contactNo").val($(this).find("td:nth-child(5)").text());
    $("#address").val($(this).find("td:nth-child(6)").text());
    $("#zipcode").val($(this).find("td:nth-child(7)").text());



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
