$(document).ready(function () {

    loadProducts();
});
var selectedRow = null;
function loadProducts() {

    var ajaxConfig = {
        url: "http://localhost:8082/Project/rest2/projects/getprojects",
        method: "GET",
        async: 'json'
    }
    var i = 0;
    $.ajax(ajaxConfig).done(function (projects, status, jQXHB) {
        for (var i = 0; i < projects.length; i++) {
            var html =
                '<tr>' +
                '<td style="visibility: hidden">' + projects[i].projectID + '</td>' +
                '<td>' + projects[i].publisherName + '</td>' +
                '<td>' + projects[i].projectName + '</td>' +
                '<td>' + projects[i].email + '</td>' +
                '<td>' + projects[i].status + '</td>' +
                '<td>' + projects[i].link + '</td>' +
                '<td>' + projects[i].updatedDate + '</td>' +
                '<td>' + projects[i].submittedDate + '</td>' +
                '<td>' + projects[i].description + '</td>' +
                '</tr>';
            $("#table tbody").append(html);
        }
        console.log(projects)
    }).fail(function (jqXHB, status, error) {
        console.log(error)

    })

}


$("#table tbody").on('click', 'tr', function () {
    selectedRow = $(this);
    $("#id").val($(this).find("td:first-child").text());
    $("#pubName").val($(this).find("td:nth-child(2)").text());
    $("#proName").val($(this).find("td:nth-child(3)").text());
    $("#Email").val($(this).find("td:nth-child(4)").text());
    $("#proStatus").val($(this).find("td:nth-child(5)").text());
    $("#proLink").val($(this).find("td:nth-child(6)").text());
    $("#proUpDate").val($(this).find("td:nth-child(7)").text());
    $("#proSubDate").val($(this).find("td:nth-child(8)").text());
    $("#proDesc").val($(this).find("td:nth-child(9)").text());


    $("#id").attr("disabled", 'true');
    $("#table tbody tr").removeClass('row-selected');
    selectedRow.addClass('row-selected');
});




function deleteProject(){

    var id = document.getElementById('id').value;

    if (confirm("Are you sure whether you want delete this Item?")) {
        $.ajax({
            method: 'DELETE',
            url:  'http://localhost:8082/Project/rest2/projects/delete/' + id,
            async: true
        }).done(function (response, status, jqXHR) {

        }).fail(function (jqXHR, status, error) {
            console.log(error);
        });
    }
    window.location.reload();
}








$("#btnsubmit").click(function () {
    var project = {
        projectID:$("#id").val(),
        publisherName: $("#pubName").val(),
        projectName: $("#proName").val(),
        email: $("#Email").val(),
        status: $("#proStatus").val(),
        link: $("#proLink").val(),
        updatedDate: $("#proUpDate").val(),
        submittedDate: $("#proSubDate").val(),
        description: $("#proDesc").val(),

    };

        var ajaxConfig = {
            method: 'PUT',
            url: 'http://localhost:8082/Project/rest2/projects/update',
            async: true,
            contentType: 'application/json',
            data: JSON.stringify(project)
        };
        $.ajax(ajaxConfig).done(function (response, status, jqXHR) {
            // selectedRow.find("td:nth-child(1)").text(project.pubName);
            // selectedRow.find("td:nth-child(2)").text(project.proName);
            // selectedRow.find("td:nth-child(3)").text(project.proStatus);
            // selectedRow.find("td:nth-child(4)").text(project.proLink);
            // selectedRow.find("td:nth-child(5)").text(project.proUpDate);
            // selectedRow.find("td:nth-child(6)").text(project.proSubDate);
            // selectedRow.find("td:nth-child(7)").text(project.proDesc);


        }).fail(function (jqXHR, status, error) {
            console.log(error);
        }).always(function(){
            $("#btnClear").click();
            window.location.reload();
        });


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