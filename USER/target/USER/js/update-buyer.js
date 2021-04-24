$(document).ready(function () {
    loadBuyer();
});
var selectedRow = null;
function loadBuyer() {

    var ajaxConfig = {
        url: "http://localhost:8081/USER/rest1/buyer/getBuyer",
        method: "GET",
        async: 'json'
    }
    var i = 0;
    $.ajax(ajaxConfig).done(function (buyer, status, jQXHB) {
        document.getElementById("id").value = buyer.id;
        document.getElementById("first-name").value = buyer.fName;
        document.getElementById("last-name").value = buyer.lName;
        document.getElementById("email").value = buyer.email;
        document.getElementById("contactNo").value = buyer.contactNo;
        document.getElementById("address").value = buyer.address;
        document.getElementById("zipcode").value = buyer.zipCode;
    }).fail(function (jqXHB, status, error) {
        console.log(error)
    })
}