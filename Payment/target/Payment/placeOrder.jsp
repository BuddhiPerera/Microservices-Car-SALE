<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>E-commerce</title>

    <!-- Bootstrap -->
    <link href="vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- bootstrap-daterangepicker -->
    <link href="vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
    <!-- bootstrap-datetimepicker -->
    <link href="vendors/bootstrap-datetimepicker/build/css/bootstrap-datetimepicker.css" rel="stylesheet">
    <!-- Ion.RangeSlider -->
    <link href="vendors/normalize-css/normalize.css" rel="stylesheet">
    <link href="vendors/ion.rangeSlider/css/ion.rangeSlider.css" rel="stylesheet">
    <link href="vendors/ion.rangeSlider/css/ion.rangeSlider.skinFlat.css" rel="stylesheet">
    <!-- Bootstrap Colorpicker -->
    <link href="vendors/mjolnic-bootstrap-colorpicker/dist/css/bootstrap-colorpicker.min.css" rel="stylesheet">

    <link href="vendors/cropper/dist/cropper.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="build/css/custom.min.css" rel="stylesheet">
</head>

<body class="nav-md">
<div style="background-color: white" class=" body">
    <div class="">


        <!-- top navigation -->
        <div class="top_nav">
            <div class="nav_menu">
                <div class="nav toggle">
                    <a id="menu_toggle"><i ></i></a>
                </div>
                <nav class="nav navbar-nav">
                    <ul class=" navbar-right">
                        <li class="nav-item dropdown open" style="padding-left: 15px;">
                            <a href="javascript:;" class="user-profile dropdown-toggle" aria-haspopup="true" id="navbarDropdown" data-toggle="dropdown" aria-expanded="false">
                                <img src="images/img.jpg" alt="">John Doe
                            </a>
                            <div class="dropdown-menu dropdown-usermenu pull-right" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item"  href="javascript:;"> Profile</a>
                                <a class="dropdown-item"  href="javascript:;">
                                    <span class="badge bg-red pull-right">50%</span>
                                    <span>Settings</span>
                                </a>
                                <a class="dropdown-item"  href="javascript:;">Help</a>
                                <a class="dropdown-item"  href="login.html"><i class="fa fa-sign-out pull-right"></i> Log Out</a>
                            </div>
                        </li>

                        <li role="presentation" class="nav-item dropdown open">
                            <a href="javascript:;" class="dropdown-toggle info-number" id="navbarDropdown1" data-toggle="dropdown" aria-expanded="false">
                                <i class="fa fa-envelope-o"></i>
                                <span class="badge bg-green">6</span>
                            </a>
                            <ul class="dropdown-menu list-unstyled msg_list" role="menu" aria-labelledby="navbarDropdown1">
                                <li class="nav-item">
                                    <a class="dropdown-item">
                                        <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span>
                                        <span>
                            <span>John Smith</span>
                            <span class="time">3 mins ago</span>
                          </span>
                                        <span class="message">
                            Film festivals used to be do-or-die moments for movie makers. They were where...
                          </span>
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a class="dropdown-item">
                                        <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span>
                                        <span>
                            <span>John Smith</span>
                            <span class="time">3 mins ago</span>
                          </span>
                                        <span class="message">
                            Film festivals used to be do-or-die moments for movie makers. They were where...
                          </span>
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a class="dropdown-item">
                                        <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span>
                                        <span>
                            <span>John Smith</span>
                            <span class="time">3 mins ago</span>
                          </span>
                                        <span class="message">
                            Film festivals used to be do-or-die moments for movie makers. They were where...
                          </span>
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a class="dropdown-item">
                                        <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span>
                                        <span>
                            <span>John Smith</span>
                            <span class="time">3 mins ago</span>
                          </span>
                                        <span class="message">
                            Film festivals used to be do-or-die moments for movie makers. They were where...
                          </span>
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <div class="text-center">
                                        <a class="dropdown-item">
                                            <strong>See All Alerts</strong>
                                            <i class="fa fa-angle-right"></i>
                                        </a>
                                    </div>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">
                <div class="page-title">
                    <div class="title_left">

                    </div>



                    <div class="clearfix"></div>

                    <div class="row">


                        <!-- form color picker -->
                        <div class="col-md-6 col-sm-12  ">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Order Summary</h2>
                                    <ul class="nav navbar-right panel_toolbox">
                                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                        </li>
                                        <li class="dropdown">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                            <ul class="dropdown-menu" role="menu">
                                                <li><a href="#">Settings 1</a>
                                                </li>
                                                <li><a href="#">Settings 2</a>
                                                </li>
                                            </ul>
                                        </li>
                                        <li><a class="close-link"><i class="fa fa-close"></i></a>
                                        </li>
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <br />
                                    <form class="form-horizontal form-label-left">

                                        <div class="form-group row">
                                            <div class="col-md-9 col-sm-9  ">
                                                <img height="200px" width="400px" src="https://specials-images.forbesimg.com/imageserve/5d3703e2f1176b00089761a6/960x0.jpg?cropX1=836&cropX2=5396&cropY1=799&cropY2=3364">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="control-label col-md-3 col-sm-3  " id="iName">Ferrari Spider</label>
                                        </div>
                                        <div class="form-group row">
                                            <label class="control-label col-md-3 col-sm-3  " id="iDescription">From £510
                                                The newest version of Rolls-Royce's flagship model sets new standards for opulence and luxury  </label>
                                        </div>
                                        <div class="form-group row">
                                            <label class="control-label col-md-3 col-sm-3  " id="iShipping">free Shipping</label>
                                        </div>

                                    </form>
                                </div>
                            </div>
                        </div>
                        <!-- form input mask -->
                        <div class="col-md-6 col-sm-12  ">
                            <div class="x_panel">
                                <div class="x_title">
                                    <h2>Shipping Information</h2>
                                    <ul class="nav navbar-right panel_toolbox">
                                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                        </li>
                                        <li class="dropdown">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                                <a class="dropdown-item" href="#">Settings 1</a>
                                                <a class="dropdown-item" href="#">Settings 2</a>
                                            </div>
                                        </li>
                                        <li><a class="close-link"><i class="fa fa-close"></i></a>
                                        </li>
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <br />
                                    <form class="form-horizontal form-label-left">

                                        <div class="form-group row">
                                            <input  type="hidden" id="id" class="form-control">
                                            <div class="col-md-10 col-sm-10 col-xs-10">
                                                <input placeholder="Name" id="name" type="text" class="form-control">

                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <div class="col-md-10 col-sm-10 col-xs-10">
                                                <input placeholder="Street, house/apartment/unit" id="address" type="text" class="form-control" >

                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <div class="col-md-5 col-sm-5 col-xs-5">
                                                <input placeholder="State/Province/Region" id="state" type="text" class="form-control" >

                                            </div>
                                            <div class="col-md-5 col-sm-5 col-xs-5">
                                                <input placeholder="Country" id="country" type="text" class="form-control">
                                            </div>

                                        </div>
                                        <div class="form-group row">

                                            <div class="col-md-5 col-sm-5 col-xs-5">
                                                <input placeholder="City and Zip Code" id="zip" type="text" class="form-control">

                                            </div>
                                            <div class="col-md-5 col-sm-5 col-xs-5">
                                                <input placeholder="Phone Number" id="contact" type="text" class="form-control">

                                            </div>

                                        </div>
                                        <div class="form-group row">
                                            <div class="col-md-5 col-sm-5 col-xs-5">
                                                <label >Qty</label>
                                                <input placeholder="Qty" id="qty" type="text" value="1" class="form-control">

                                            </div>
                                        </div>
                                        <div class="ln_solid"></div>

                                        <div class="form-group row">
                                            <div class="col-md-9 offset-md-3">
                                                <button type="submit" class="btn btn-danger" id="btnsubmit">Place Order</button>
                                                <button type="reset" class="btn btn-outline-success">Reset</button>
                                            </div>
                                        </div>

                                    </form>
                                </div>
                            </div>
                        </div>
                        <!-- /form input mask -->



                    </div>


                </div>
            </div>
        </div>
        <!-- /page content -->

        <!-- footer content -->
        <footer>
            <div class="pull-right">
                Rivindu Chamath <a href=""></a>
            </div>
            <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
    </div>
</div>

<!-- jQuery -->
<script src="vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
<!-- FastClick -->
<script src="vendors/fastclick/lib/fastclick.js"></script>
<!-- NProgress -->
<script src="vendors/nprogress/nprogress.js"></script>
<!-- bootstrap-daterangepicker -->
<script src="vendors/moment/min/moment.min.js"></script>
<script src="vendors/bootstrap-daterangepicker/daterangepicker.js"></script>
<!-- bootstrap-datetimepicker -->
<script src="vendors/bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js"></script>
<!-- Ion.RangeSlider -->
<script src="vendors/ion.rangeSlider/js/ion.rangeSlider.min.js"></script>
<!-- Bootstrap Colorpicker -->
<script src="vendors/mjolnic-bootstrap-colorpicker/dist/js/bootstrap-colorpicker.min.js"></script>
<!-- jquery.inputmask -->
<script src="vendors/jquery.inputmask/dist/min/jquery.inputmask.bundle.min.js"></script>
<!-- jQuery Knob -->
<script src="vendors/jquery-knob/dist/jquery.knob.min.js"></script>
<!-- Cropper -->
<script src="vendors/cropper/dist/cropper.min.js"></script>

<!-- Custom Theme Scripts -->
<script src="build/js/custom.min.js"></script>
<script src="js/placeOrder.js"></script>

<!-- Initialize datetimepicker -->
</body>
</html>
