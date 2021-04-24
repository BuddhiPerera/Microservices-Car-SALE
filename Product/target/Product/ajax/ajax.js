$("#btnSave").click(function () {


    var http = new XMLHttpRequest();

    http.onreadystatechange = function () {
        if (http.readyState == 4 && http.status == 200) {


        }

    };

    http.open('POST', 'http://localhost:8080/pos/customers5', true);
    // http.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

var form = new FormData();

 form.append("id",$('#txtId').val());
 form.append("name",$('#txtName').val());
 form.append("address",$('#txtCustomerAddress').val());
 form.append("pic",$('#txtPic').val());


    http.send(form);

});