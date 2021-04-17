<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Student details</title>
    <link href="vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="vendors/jquery/dist/jquery.min.js"></script>
<%--    <script src="js/main.js"></script>--%>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-8">

            <h1 class="m-3">Student details</h1>

            <form method="post" action="http://localhost/Product/rest/item">
                <!-- NAME -->

                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="lblitemCode">Name: </span>
                    </div>
                    <input type="text" id="itemCode" name="itemCode">
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="lblitemName">Name: </span>
                    </div>
                    <input type="text" id="itemName" name="itemName">
                </div>
                <div class="input-group input-group-sm mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="lblitemPrice">Name: </span>
                    </div>
                    <input type="text" id="itemPrice" name="itemPrice">
                </div>
                <div class="input-group input-group-sm mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="lblitemDesc">Name: </span>
                </div>
                <input type="text" id="itemDesc" name="itemDesc">
            </div>

                <div id="alertSuccess" class="alert alert-success"></div>
                <div id="alertError" class="alert alert-danger"></div>
                <input type="submit" id="btnSave" value="Save" class="btn btn-primary">
            </form>
        </div>
    </div>

    <br>

    <div class="row">
        <div class="col-12" id="colStudents">

        </div>
    </div>
</div>
</body>
</html>