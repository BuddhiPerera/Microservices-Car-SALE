$(document).ready(function () {
    loadResearcher();
});
var selectedRow = null;
function loadResearcher() {

    var ajaxConfig = {
        url: "http://localhost:8081/USER/rest1/researcher/getResearcher",
        method: "GET",
        async: 'json'
    }
    var i = 0;
    $.ajax(ajaxConfig).done(function (researcher, status, jQXHB) {
        document.getElementById("id").value = researcher.id;
        document.getElementById("first-name").value = researcher.fName;
        document.getElementById("last-name").value = researcher.lName;
        document.getElementById("email").value = researcher.email;
        document.getElementById("contactNo").value = researcher.contactNo;
        document.getElementById("address").value = researcher.address;
        document.getElementById("zipcode").value = researcher.zipCode;
        document.getElementById("rate").value = researcher.rate;
    }).fail(function (jqXHB, status, error) {
        console.log(error)
    })
}