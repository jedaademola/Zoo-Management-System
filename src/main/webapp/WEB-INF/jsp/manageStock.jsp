<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />
<html>
<head>
<title>Zoo System:::Admin Panel</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Zoo Management system" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
 <!-- Bootstrap Core CSS -->
<link href="${cp}/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="${cp}/css/style.css" rel='stylesheet' type='text/css' />
<!-- Graph CSS -->
<link href="${cp}/css/lines.css" rel='stylesheet' type='text/css' />
<link href="${cp}/css/font-awesome.css" rel="stylesheet">
<!-- jQuery -->
<script src="${cp}/js/jquery.min.js"></script>
<!----webfonts--->
<link href='${cp}/fontCss.css' rel='stylesheet' type='text/css'>
<!---//webfonts--->
<!-- Nav CSS -->
<link href="${cp}/css/custom.css" rel="stylesheet">
<!-- Metis Menu Plugin JavaScript -->
<script src="${cp}/js/metisMenu.min.js"></script>
<script src="${cp}/js/custom.js"></script>
<!-- Graph JavaScript -->
<script src="${cp}/js/d3.v3.js"></script>
<script src="${cp}/js/rickshaw.js"></script>
</head>
<body>
<div id="wrapper">
     <!-- Navigation -->
        <nav class="top1 navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${cp}">Zoo Management System</a>
            </div>
            <!-- /.navbar-header -->
            <ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
	        		<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-comments-o"></i><span class="badge">4</span></a>
	        		<ul class="dropdown-menu">
						<li class="dropdown-menu-header">
							<strong>Messages</strong>
							<div class="progress thin">
							  <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
							    <span class="sr-only">40% Complete (success)</span>
							  </div>
							</div>
						</li>
						<li class="avatar">
							<a href="#">
								<img src="images/1.png" alt=""/>
								<div>New message</div>
								<small>1 minute ago</small>
								<span class="label label-info">NEW</span>
							</a>
						</li>
						<li class="avatar">
							<a href="#">
								<img src="images/2.png" alt=""/>
								<div>New message</div>
								<small>1 minute ago</small>
								<span class="label label-info">NEW</span>
							</a>
						</li>
						<li class="avatar">
							<a href="#">
								<img src="images/3.png" alt=""/>
								<div>New message</div>
								<small>1 minute ago</small>
							</a>
						</li>
						<li class="avatar">
							<a href="#">
								<img src="images/4.png" alt=""/>
								<div>New message</div>
								<small>1 minute ago</small>
							</a>
						</li>
						<li class="avatar">
							<a href="#">
								<img src="images/5.png" alt=""/>
								<div>New message</div>
								<small>1 minute ago</small>
							</a>
						</li>
						<li class="avatar">
							<a href="#">
								<img src="images/pic1.png" alt=""/>
								<div>New message</div>
								<small>1 minute ago</small>
							</a>
						</li>
						<li class="dropdown-menu-footer text-center">
							<a href="#">View all messages</a>
						</li>
	        		</ul>
	      		</li>
			    <li class="dropdown">
	        		<a href="#" class="dropdown-toggle avatar" data-toggle="dropdown"><img src="images/1.png"><span class="badge">9</span></a>
	        		<ul class="dropdown-menu">
						<li class="dropdown-menu-header text-center">
							<strong>Account</strong>
						</li>
						<li class="m_2"><a href="#"><i class="fa fa-bell-o"></i> Updates <span class="label label-info">42</span></a></li>
						<li class="m_2"><a href="#"><i class="fa fa-envelope-o"></i> Messages <span class="label label-success">42</span></a></li>
						<li class="m_2"><a href="#"><i class="fa fa-tasks"></i> Tasks <span class="label label-danger">42</span></a></li>
						<li><a href="#"><i class="fa fa-comments"></i> Comments <span class="label label-warning">42</span></a></li>
						<li class="dropdown-menu-header text-center">
							<strong>Settings</strong>
						</li>
						<li class="m_2"><a href="#"><i class="fa fa-user"></i> Profile</a></li>
						<li class="m_2"><a href="#"><i class="fa fa-wrench"></i> Settings</a></li>
						<li class="m_2"><a href="#"><i class="fa fa-usd"></i> Payments <span class="label label-default">42</span></a></li>
						<li class="m_2"><a href="#"><i class="fa fa-file"></i> Projects <span class="label label-primary">42</span></a></li>
						<li class="divider"></li>
						<li class="m_2"><a href="#"><i class="fa fa-shield"></i> Lock Profile</a></li>
						<li class="m_2"><a href="#"><i class="fa fa-lock"></i> Logout</a></li>
	        		</ul>
	      		</li>
			</ul>
			<form class="navbar-form navbar-right">
              <input type="text" class="form-control" value="Search..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search...';}">
            </form>
            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
              <ul class="nav" id="side-menu">
                <li>
                                                              <a href="${cp}/index"><i class="fa fa-dashboard fa-fw nav_icon"></i>Dashboard</a>
                                                          </li>
                                                          <li>
                                                              <a href="${cp}/manageBlock"><i class="fa fa-check-square-o nav_icon"></i>Manage Block</a>
                                                          </li>
                                                            <li>
                                                               <a href="${cp}/manageCell"><i class="fa fa-check-square-o nav_icon"></i>Manage Cell</a>
                                                           </li>
                                                           <li>
                                                            <a href="${cp}/manageAnimal"><i class="fa fa-check-square-o nav_icon"></i>Manage Animal</a>
                                                        </li>
                                                        <li>
                                                          <a href="${cp}/manageFood"><i class="fa fa-check-square-o nav_icon"></i>Manage Food</a>
                                                      </li>
                                                       <li>
                                                            <a href="${cp}/manageHollydayPackage"><i class="fa fa-check-square-o nav_icon"></i>Manage Hollyday Package</a>
                                                       </li>
                                                       <li>
                                                           <a href="${cp}/manageMedicine"><i class="fa fa-check-square-o nav_icon"></i>Manage Medicine</a>
                                                       </li>
                                                       <li>
                                                           <a href="${cp}/manageAppointment"><i class="fa fa-check-square-o nav_icon"></i>Manage Appointment</a>
                                                       </li>

                                                       <li>
                                                           <a href="${cp}/manageStock"><i class="fa fa-check-square-o nav_icon"></i>Manage Stock</a>
                                                       </li>

                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>
        <div id="page-wrapper">

<div class="bs-example4" data-example-id="simple-responsive-table">
 <div class="alert alert-success alert-dismissable" style="display:none" id="msgAlert">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <div id="resultsSuccess"></div>
</div>

<div class="alert alert-danger alert-dismissable" style="display:none" id="msgAlertFailed">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <div id="resultsError"></div>
</div>


    <div class="clearfix"> </div>
     <div class="clearfix"> </div>
    <div class="table-responsive">
     <a href="#" class="btn btn-primary btn-md pull-right" data-toggle="modal" data-target="#myModal">
     <b>+</b> Add new Stock</a>
     <!-- Trigger the modal with a button -->
     <!--button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button -->
     <div class="clearfix"> </div>


       <div class="clearfix"> </div>
      <table class="table table-bordered">
        <thead>
          <tr>
            <th>#</th>
            <th>Item Name</th>
            <th>Item Category</th>
            <th>Supplier</th>
            <th>Quantity</th>
            <th>Price</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
         <c:forEach var="stock" items="${stocks}" varStatus="theCount">
          <tr>
            <th scope="row">${theCount.count}</th>
            <td>${stock.itemName}</td>
            <td>${stock.category}</td>
            <td>${stock.supplier}</td>
            <td>${stock.quantity}</td>
            <td>${stock.price}</td>

            <td> <a href="#"
            data-toggle="tooltip" data-placement="top"
            data-id="${stock.id}:${stock.itemName}:${stock.category}:${stock.supplier}:${stock.quantity}:${stock.price}"
            class="editStock" id="myBtn${stock.id}">Edit</td>
          </tr>
         </c:forEach>
        </tbody>
      </table>
    </div><!-- /.table-responsive -->
  </div>
       </div>
       <div class="clearfix"> </div>
    </div>
    <div class="content_bottom">



		<div class="copy">
            <p>Copyright &copy; 2017 All Rights Reserved | Design by <a href="http://w3layouts.com/" target="_blank">W3layouts</a> </p>
	    </div>
		</div>
       </div>
      <!-- /#page-wrapper -->
   </div>
    <!-- /#wrapper -->
    <!-- Bootstrap Core JavaScript -->
    <script src="${cp}/js/bootstrap.min.js"></script>
</body>
<script type="text/javascript">
    $(document).ready(function () {

             $(document).on("click", "#addStock", function (e) {


                    addStock();

                 //   location.reload();
                });

            $('.editStock').click(function () {

                        var id = $(this).attr('data-id');
                      //${stock.id}:${stock.itemId}:${stock.category}:${stock.supplierId}:${stock.quantity}:${stock.price}
                        $('#myModalEdit').find('#stockId').val(id.split(":")[0]);
                        $('#myModalEdit').find('#quantityInputEdit').val(id.split(":")[4]);
                        $('#myModalEdit').find('#priceInputEdit').val(id.split(":")[5]);

                        $('#myModalEdit').modal();
                    });

         $(document).on("click", "#editStockId", function (e) {


                            editStock();

                         //   location.reload();
                        });



   });


   function addStock() {

               var jsonRequest = {};

               jsonRequest["category"] =  $("#itemCatInput").val();
               jsonRequest["itemId"] =  $("#itemIdInput").val();
                //dateOfBirth should be captured

               jsonRequest["quantity"] =  $("#quantityInput").val();
               jsonRequest["price"] =  $("#priceInput").val();
               jsonRequest["supplierId"] =  $("#supplierInput").val();

               var param = JSON.stringify(jsonRequest);
              // xhr.setRequestHeader(header, token);
               $.ajax({
                   url: "${cp}/api/v1/zoo/stock",
                   type: "POST",
                   dataType: "json",
                   beforeSend: function (xhr) {
                       xhr.setRequestHeader("Accept", "application/json");
                       xhr.setRequestHeader("Content-Type", "application/json");

                   },
                   data: param,
                   success: function (data) {

                      $('#myModal').modal('hide');
                       $("#resultsSuccess").html(data.description);
                       document.getElementById("msgAlert").style.display = '';
                       document.getElementById("msgAlertFailed").style.display = 'none';



                   }
                   ,
                   error: function (xhr, errorType, exception) {

                        $('#myModal').modal('hide');
                       document.getElementById("msgAlertFailed").style.display = '';
                       document.getElementById("msgAlert").style.display = 'none';

                       var responseText = JSON.parse(xhr.responseText);



                       $("#resultsError").html(responseText.description);

                   }
               }

           );
           }
function editStock() {

               var jsonRequest = {};

             jsonRequest["id"] =  $("#stockId").val();
             jsonRequest["category"] =  $("#itemCatInputEdit").val();
             jsonRequest["itemId"] =  $("#itemIdInputEdit").val();


             jsonRequest["quantity"] =  $("#quantityInputEdit").val();
             jsonRequest["price"] =  $("#priceInputEdit").val();
             jsonRequest["supplierId"] =  $("#supplierInputEdit").val();



               var param = JSON.stringify(jsonRequest);

               $.ajax({
                   url: "${cp}/api/v1/zoo/stock",
                   type: "PUT",
                   dataType: "json",
                   beforeSend: function (xhr) {
                       xhr.setRequestHeader("Accept", "application/json");
                       xhr.setRequestHeader("Content-Type", "application/json");

                   },
                   data: param,
                   success: function (data) {

                      $('#myModalEdit').modal('hide');
                       $("#resultsSuccess").html(data.description);
                       document.getElementById("msgAlert").style.display = '';
                       document.getElementById("msgAlertFailed").style.display = 'none';



                   }
                   ,
                   error: function (xhr, errorType, exception) {

                        $('#myModalEdit').modal('hide');
                       document.getElementById("msgAlertFailed").style.display = '';
                       document.getElementById("msgAlert").style.display = 'none';

                       var responseText = JSON.parse(xhr.responseText);



                       $("#resultsError").html(responseText.description);

                   }
               }

           );
           }


 </script>

<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Add Stock Item</h4>
      </div>
      <div class="modal-body">
        <form:form id ="formaction" class="form-horizontal">
                <div class="form-group">
                    <label for="itemCatInput" class="col-sm-2 control-label">Category</label>
                    <div class="col-sm-8">
                        <select  id="itemCatInput" class="form-control1">
                            <option>Food</option>
                            <option>Medicine</option>

                        </select>
                    </div>
                    <div class="col-sm-2">

                    </div>
                </div>

                 <div class="form-group">
                    <label for="itemIdInput" class="col-sm-2 control-label">Item Name</label>
                    <div class="col-sm-8">
                       <form:select class="form-control1" id="itemIdInput" path="id">
                            <form:options items="${itemIds}" itemValue="value" itemLabel="label"/>
                        </form:select>

                    </div>
                    <div class="col-sm-2">

                    </div>
                </div>
                <div class="form-group">
                    <label for="quantityInput" class="col-sm-2 control-label">Quantity</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control1" id="quantityInput" placeholder="Enter Quantity">
                    </div>
                    <div class="col-sm-2">

                    </div>
                </div>
                <div class="form-group">
                    <label for="priceInput" class="col-sm-2 control-label">Price</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control1" id="priceInput" placeholder="Enter Price">
                    </div>
                    <div class="col-sm-2">

                    </div>
                </div>

             <div class="form-group">
                <label for="supplierInput" class="col-sm-2 control-label">Supplier</label>
                <div class="col-sm-8">
                   <form:select class="form-control1" id="supplierInput" path="id">
                        <form:options items="${suppliers}" itemValue="value" itemLabel="label"/>
                    </form:select>

                </div>
                <div class="col-sm-2">

                </div>
            </div>

           </form:form>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="addStock">Add</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>
</div>
</div>



<!-- Modal -->
<div id="myModalEdit" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Edit Stock Item</h4>
      </div>
      <div class="modal-body">
            <form:form id ="formactionEdit" class="form-horizontal">
                           <div class="form-group">
                            <input type ="hidden" name ="stockId" value ="" id ="stockId"/>
                                               <label for="itemCatInputEdit" class="col-sm-2 control-label">Category</label>
                                               <div class="col-sm-8">
                                                   <select  id="itemCatInputEdit" class="form-control1">
                                                       <option>Food</option>
                                                       <option>Medicine</option>

                                                   </select>
                                               </div>
                                               <div class="col-sm-2">

                                               </div>
                                           </div>

                                            <div class="form-group">
                                               <label for="itemIdInputEdit" class="col-sm-2 control-label">Item Name</label>
                                               <div class="col-sm-8">
                                                  <form:select class="form-control1" id="itemIdInputEdit" path="id">
                                                       <form:options items="${itemIds}" itemValue="value" itemLabel="label"/>
                                                   </form:select>

                                               </div>
                                               <div class="col-sm-2">

                                               </div>
                                           </div>
                                           <div class="form-group">
                                               <label for="quantityInputEdit" class="col-sm-2 control-label">Quantity</label>
                                               <div class="col-sm-8">
                                                   <input type="text" class="form-control1" id="quantityInputEdit" placeholder="Enter Quantity">
                                               </div>
                                               <div class="col-sm-2">

                                               </div>
                                           </div>
                                           <div class="form-group">
                                               <label for="priceInputEdit" class="col-sm-2 control-label">Price</label>
                                               <div class="col-sm-8">
                                                   <input type="text" class="form-control1" id="priceInputEdit" placeholder="Enter Price">
                                               </div>
                                               <div class="col-sm-2">

                                               </div>
                                           </div>

                                        <div class="form-group">
                                           <label for="supplierInputEdit" class="col-sm-2 control-label">Supplier</label>
                                           <div class="col-sm-8">
                                              <form:select class="form-control1" id="supplierInputEdit" path="id">
                                                   <form:options items="${suppliers}" itemValue="value" itemLabel="label"/>
                                               </form:select>

                                           </div>
                                           <div class="col-sm-2">

                                           </div>
                                       </div>

                      </form:form>
      </div>
      <div class="modal-footer">
      <button type="button" class="btn btn-primary" id="editStockId">Edit</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>

</html>
