$("#btnSave").click(function () {


    var http = new XMLHttpRequest();

    http.onreadystatechange = function () {
        if (http.readyState == 4 && http.status == 200) {


        }

    };

    http.open('POST', 'http://localhost:8080/pos/customers6', true);
    http.setRequestHeader('Content-Type', 'application/json');


    var customer = {
      "id" :$('#txtId').val(),
      "name" :$('#txtName').val(),
      "address" :$('#txtCustomerAddress').val()
    };


    http.send(JSON.stringify(customer));

});