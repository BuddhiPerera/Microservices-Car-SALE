<<<<<<< HEAD
$(document).ready(function () {
    loadUser();
});
var selectedRow = null;
function loadUser() {

    var ajaxConfig = {
        url: "http://localhost:8081/USER/rest1/buyer",
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
                '<td>' + buyer[i].zipcode + '</td>'+
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
            url: 'http://localhost:8081/USER/rest1/buyer/delete/' + row.find('td:first-child').text(),
            async: true
        }).done(function (response, status, jqXHR) {
            row.remove();
        }).fail(function (jqXHR, status, error) {
            console.log(error);
        });
    }
});

=======
// $(document).ready(function () {
//     loadUser();
// });
// var selectedRow = null;
// function loadUser() {
//
//     var ajaxConfig = {
//         url: "http://localhost:8081/USER/rest1/buyer",
//         method: "GET",
//         async: 'json'
//     }
//     var i = 0;
//     $.ajax(ajaxConfig).done(function (buyer, status, jQXHB) {
//         for (var i = 0; i < buyer.length; i++) {
//             var html = '<tr>' +
//                 '<td>' + buyer[i].id + '</td>' +
//                 '<td>' + buyer[i].fName + '</td>' +
//                 '<td>' + buyer[i].lName + '</td>' +
//                 '<td>' + buyer[i].email + '</td>' +
//                 '<td>' + buyer[i].contactNo + '</td>' +
//                 '<td>' + buyer[i].address + '</td>' +
//                 '<td>' + buyer[i].zipcode + '</td>'
//                 '<td><i class="fas fa-trash"></i></td>' +
//                 '</tr>';
//             $("#datatable tbody").append(html);
//         }
//         console.log(product)
//     }).fail(function (jqXHB, status, error) {
//         console.log(error)
//     })
// }

// $("#datatable tbody").on('click', "tr td:last-child", function (eventData) {
//     var row = $(this).parents("tr");
//     eventData.stopPropagation();
//     if (confirm("Are you sure whether you want delete this Item?")) {
//         $.ajax({
//             method: 'DELETE',
//             url: 'http://localhost:8081/USER/rest1/buyer/delete/' + row.find('td:first-child').text(),
//             async: true
//         }).done(function (response, status, jqXHR) {
//             row.remove();
//         }).fail(function (jqXHR, status, error) {
//             console.log(error);
//         });
//     }
// });

//button id
>>>>>>> 19ccf5ac85bd74b725c781033d4792cf8b9b6eed
$("#btnsubmit").click(function () {

    var buyer = {
        // purple == DTO
        // yellow == HTML id
        fName: $("#fName").val(),
        lName: $("#lName").val(),
        email: $("#email").val(),
        contactNo: $("#contact").val(),
        address: $("#add").val(),
        zipCode: $("#zip").val(),
        password: $("#password").val()
    };
    alert("sssssssssssssssssssssssssssssssssssssss")
        var ajaxConfig = {
            method: 'POST',
            url: 'http://localhost:8081/USER/rest1/buyer/saveUser',
            async: true,
            contentType: 'application/json',
            data: JSON.stringify(buyer) // send data to saveUser method in controller
        };
        $.ajax(ajaxConfig).done(function (response, status, jqXHR) {
            $("#id, #fName, #lName, #email, #contact, #add, #zip, #password").val(""); // empty fields
            $("#id").focus();
        }).fail(function (jqXHR, status, error) {
            console.log(error);
        });
});

// $("#datatable tbody").on('click', 'tr', function () {
//     selectedRow = $(this);
//     $("#id").val($(this).find("td:first-child").text());
//     $("#fName").val($(this).find("td:nth-child(2)").text());
//     $("#lName").val($(this).find("td:nth-child(3)").text());
//     $("#email").val($(this).find("td:nth-child(4)").text());
//     $("#contactNo").val($(this).find("td:nth-child(5)").text());
//     $("#address").val($(this).find("td:nth-child(6)").text());
//     $("#zipcode").val($(this).find("td:nth-child(7)").text());
//
//
//
//     $("#id").attr("disabled", 'true');
//     $("#datatable tbody tr").removeClass('row-selected');
//     selectedRow.addClass('row-selected');
// });

