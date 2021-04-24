<!DOCTYPE html>
<html  lang="5">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Modern POS | Manage Customers</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="css2/adminlte.min.css">
  <link rel="stylesheet" href="css/manage-customers-style.css">

  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
</head>

<body  class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">
  <!-- Navbar -->
  <nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <!-- Left navbar links -->
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" data-widget="pushmenu" href="#"><i class="fas fa-bars"></i></a>
      </li>
    </ul>
  </nav>

  <!-- Main Sidebar Container -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="#" class="brand-link text-center">
      <span class="brand-text font-weight-light">MODERN POS</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">

      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
             with font-awesome or any other icon font library -->
          <li class="nav-item">
            <a href="allProducts.jsp" class="nav-link">
              <i class="fa fa-tachometer-alt"></i>
              <p>Dashboard</p>
            </a>
          </li>
          <li class="nav-item">
            <a href="#" class="nav-link active">
              <i class="fa fa-users"></i>
              <p>Manage Customers</p>
            </a>
          </li>
          <li class="nav-item">
            <a href="manage-item.html" class="nav-link">
              <i class="fa fa-sitemap "></i>
              <p>Manage Items</p>
            </a>
          </li>
          <li class="nav-item">
            <a href="place-order-controll.html" class="nav-link">
              <i class="fa fa-shopping-cart "></i>
              <p>Place Orders</p>
            </a>
          </li>
          <li class="nav-item">
            <a href="pages/widgets.html" class="nav-link">
              <i class="fa fa-search"></i>
              <p>
                Search Orders
              </p>
            </a>
          </li>
        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0 text-dark">Manage Customers</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Manage Products</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <section class="content">
      <div class="container-fluid">
        <!-- Main row -->
        <div class="row">
          <div class="col col-12 col-md-6">
            <div class="card card-primary">
              <div class="card-header">
                <h3 class="card-title">Manage Products</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->



<%--              ///////////////////////////////////////////////////////////////////////////////////--%>
<%--              ///////////////////////////////////////////////////////////////////////////////////--%>

              <form role="form" id="submitform">
                <div class="card-body">
                  <div class="form-group">
                    <input type="hidden" class="form-control"  name="id"  id="id" >
                  </div>
                  <div class="form-group">
                    <label> Name</label>
                    <input type="text" class="form-control" id="name" name="name"  >
                  </div>
                  <div class="form-group">
                    <label >Description</label>
                    <textarea type="text" class="form-control" name="description"  id="description"></textarea>
                  </div>
                  <div class="form-group">
                    <label >Price</label>
                    <input type="text" class="form-control" id="price" type="text" name="price">
                  </div>
                  <div class="form-group">
                    <label >Quantity</label>
                    <input type="text" class="form-control" id="qty" name = "qty">
                  </div>
                  <div class="form-group">
                    <label >Shipping</label>
                    <input type="text" class="form-control" id="shipping" name="shipping">
                  </div>
                  <div class="form-group">
                    <label >Image</label>
                    <input type="text" class="form-control" name="image"  id="image">
                  </div>
                </div>
                <!-- /.card-body -->

                <div class="card-footer">
                  <button type="button"  onclick="checkUSB()" id="btnsubmit" class="btn btn-primary">Add table</button>
                  <button id="btnClear" type="reset" class="btn btn-warning">Clear</button>
                  <!--<button type="button" id="Save" class="btn btn-primary">Submit</button>-->
                </div>
              </form>

<%--              ///////////////////////////////////////////////////////////////////////////////////--%>
<%--              ///////////////////////////////////////////////////////////////////////////////////--%>


<!--              ////////////////////////////////////////////////////////////////////////////-->

            </div>
            <!-- /.card -->
          </div>
          <div class="col-6">
            <div class="card card-primary card-outline">
              <div class="table-responsive">
                <table  id="datatable" class="table table-bordered">
                  <thead>
                  <tr>
                    <th class="text-center">ID</th>
                    <th>Name</th>
                    <th>description</th>
                    <th>price</th>
                    <th>qty</th>
                    <th>shipping</th>
                    <th>image</th>
                    <th>Delete</th>
                  </tr>
                  </thead>
                  <tbody>

                  </tbody>
                </table>
              </div>

              <div class="card-footer">
                <ul class="pagination pagination-sm m-0">
                  <li class="page-item"><a class="page-link" href="#">&laquo;</a></li>
                  <li class="page-item"><a class="page-link" href="#">1</a></li>
                  <li class="page-item"><a class="page-link" href="#">2</a></li>
                  <li class="page-item"><a class="page-link" href="#">3</a></li>
                  <li class="page-item"><a class="page-link" href="#">&raquo;</a></li>
                </ul>
              </div>
            </div>
          </div>
        </div>
        <!-- /.row (main row) -->
      </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <footer class="main-footer">
    <strong>Copyright &copy; 2019 <a href="http://ijse.lk">DEP</a>.</strong>
    All rights reserved.
    <div class="float-right d-none d-sm-inline-block">
      <b>Version</b> 1.0.0
    </div>
  </footer>

</div>
<!-- ./wrapper -->

<!-- jQuery -->
<script src="vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>

<!-- Datatables -->
<script src="vendors/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<script src="vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
<%--Responsive Table--%>
<script src="vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
<script src="vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>

<script src="vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
<!-- FastClick -->
<script src="vendors/fastclick/lib/fastclick.js"></script>
<!-- NProgress -->
<script src="vendors/nprogress/nprogress.js"></script>

<!-- Custom Theme Scripts -->
<script src="build/js/custom.min.js"></script>

<!-- AdminLTE App -->
<script src="js/adminlte.js"></script>
<!-- Our little scripts  -->
<script src="js/database.js"></script>
<script src="js/manage-products-controller.js"></script>
<script>

  function checkUSB(){
      window.location.reload();

  }
</script>
</body>

</html>