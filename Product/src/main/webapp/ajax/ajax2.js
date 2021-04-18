$("#btnSave").click(function () {


    var http = new XMLHttpRequest();

    http.onreadystatechange = function () {
        if (http.readyState == 4 && http.status == 200) {


        }

    };

    http.open('POST', 'http://localhost:8080/pos/customers5', true);
    http.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');


////////////////////////////////1111111111111111111111111
    // var queryString = "id=" + $("#txtId").val()+
    //     "&name="+  $("#txtName").val()+ "&address="+  $("#txtCustomerAddress").val();
    // http.send(queryString);


////////////////2222222222222222222222222
    // var queryString =new URLSearchParams()
    //     queryString.append("id" ,$("#txtId").val());
    //     queryString.append("name" ,$("#txtName").val());
    //     queryString.append("address" , $("#txtCustomerAddress").val());
    // http.send(queryString.toString());
//////////3333333333333333333333333333333

    var queryString= $("#submitform").serialize();
    http.send(queryString.toString());

});