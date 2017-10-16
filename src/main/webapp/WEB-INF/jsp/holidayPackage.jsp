<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />
<html>
<head>
	<title>Prime Zoo Garden| Holiday Package</title>
<link href="${cp}/css/css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary JavaScript plugins) -->
<script src="${cp}/js/js/bootstrap.js"></script>
<!-- Custom Theme files -->
<link rel="stylesheet" href="${cp}/css/css/lightbox.css">
<link href="${cp}/css/css/style.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Prime Zoo Garden" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<script src="${cp}/js/js/jquery.min.js"></script>
 <script src="${cp}/js/js/bootstrap.js"></script>

</head>
<body>
<!-- banner -->
<div class="header-top">
	 <div class="container">
		 <div class="logo">			
				  <h1><a href="">PRIME ZOO GARDEN</a></h1>
		 </div>
		 <div class="details">				 
				<div class="locate">
                     <div class="detail-grid">
                         <div class="lctr">
                                <img src="images/lct.png" alt=""/>
                         </div>
                         <p>1000 North 4th street,
                         <span>Fairfield, IA</span></p>
                         <div class="clearfix"></div>
                     </div>
                     <div class="detail-grid">
                         <div class="lctr">
                                <img src="images/phn.png" alt=""/>
                         </div>
                         <p>Tel:9115550341</p>
                         <div class="clearfix"></div>
                     </div>
                </div>
		 </div>
		 <div class="clearfix"></div>
	 </div>
</div>
<div class="header">
	 <div class="container">
		 <div class="top-menu">
			 <span class="menu"><img src="images/menu.png" alt=""></span>
			 <ul class="nav1">
				  <li ><a href="${cp}/index">Home</a></li>
                 <li><a href="${cp}/gallery">Gallery</a></li>
                  <li class="active"><a href="${cp}/holidayPackage">Holiday Packages</a></li>
                 <li><a href="${cp}/contact">Contact</a></li>
			 </ul>
		 </div>
		 <!-- script-for-menu -->
							 <script>
							   $( "span.menu" ).click(function() {
								 $( "ul.nav1" ).slideToggle( 300, function() {
								 // Animation complete.
								  });
								 });
							</script>
		 <!-- /script-for-menu -->
		 <div class="search">					
				<form>
				 <input type="text" value="" placeholder="Search...">
				 <input type="submit" value="">
				</form>					
		 </div>
		 <div class="clearfix"></div>
	 </div>
</div>
<!----> 
<!--pages-starts-->
	<div class="pages">
		<div class="container">
			 <h2 class="top">Holiday Packages</h2>
			<div class="headdings">
				<!--h3 class="ghj">Headings</h3 -->

						 <div class="alert alert-success alert-dismissable" style="display:none" id="msgAlert">
						    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
						    <div id="resultsSuccess"></div>
						</div>

						<div class="alert alert-danger alert-dismissable" style="display:none" id="msgAlertFailed">
						    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
						    <div id="resultsError"></div>
						</div>

					<div class="table-responsive">
				     <!--a href="#" class="btn btn-primary btn-md pull-right" data-toggle="modal" data-target="#myModal">
				     <b>+</b> Add new Cell</a -->
				     <!-- Trigger the modal with a button -->
				     <!--button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button -->
				     <div class="clearfix"> </div>
				       <div class="clearfix"> </div>
				      <table class="table table-bordered">
				        <thead>
				          <tr>
				            <th>#</th>
				            <th>Package</th>
				            <th>Amount</th>
				            <th>Period</th>
				            <th>Date Modified</th>
				            <th>Modified by</th>
				            <th></th>
				          </tr>
				        </thead>
				        <tbody>
				        <c:forEach var="holiday" items="${holidays}" varStatus="theCount">
				          <tr>
				            <th scope="row">${theCount.count}</th>
				            <td>${holiday.name}</td>
				             <td>${holiday.amount}</td>
				            <td>${holiday.period}</td>
				            <td></td>
				            <td></td>
				            <td> <a href="#"
				                        data-toggle="tooltip" data-placement="top"
				                        data-id="${holiday.id}:${holiday.name}:${holiday.period}"   class="reserveBtn" id="myBtn${holiday.id}">Reserve</td>
				          </tr>
				         </c:forEach>
				        </tbody>
				      </table>
				    </div><!-- /.table-responsive -->
			</div>
			
			
		</div>	
	</div>	
	<!----pages-end---->

<!---->
<div class="footer">
	 <div class="container">
		 <div class="footer-sec">
			 <div class="col-md-4 ftr-grid1">
				 <h3>Latest Tweets</h3>
				 <div class="twts">
					 <h5>Animal care</h5>
					 <a href=""></a>
				 </div>
				 <div class="twts">
					 <h5>Animal right</h5>
					 <a href=""></a>
				 </div>
			 </div>
			 <div class="col-md-4 news-ltr">
				 <h3>NewsLetter</h3>
				 <p>NGOs to donate more Animal to our garden
				  </p>
				 <form>
					  <input type="text" class="text" value="Enter Email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Enter Email';}">
					 <input type="submit" value="Go">
					 <div class="clearfix"></div>
				 </form>
			 </div>
			 <div class="col-md-4 social">
				 <h3>Social Media</h3>
				 <a href="#"><i class="facebook"></i></a>
				 <a href="#"><i class="twitter"></i></a>
				 <a href="#"><i class="dribble"></i></a>
				 <a href="#"><i class="google"></i></a>
				 <a href="#"><i class="youtube"></i></a>
			 </div>
			 <div class="clearfix"></div>
     	 </div>
	 </div>
</div>
<!---->
<div class="copywrite">
	 <div class="container">
		 <div class="ftr-logo">
			 <h3><a href=""></a></h3>
		 </div>
		 <div class="ftr-right">
			 <p>Copyright &copy; 2017. All rights reserved | Design by <a href="http://w3layouts.com">W3layouts</a></p>
		 </div>
		 <div class="clearfix"></div>
	 </div>
</div>
<!---->

<script src="${cp}/js/bootstrap.min.js"></script>
</body>
<script type="text/javascript">
    $(document).ready(function () {

            

              $('.reserveBtn').click(function () {

                                     var id = $(this).attr('data-id');

                                     $('#myModalEdit').find('#holidayId').val(id.split(":")[0]);
                                     $('#myModalEdit').find('#nameEditInput').val(id.split(":")[1]);
                                     $('#myModalEdit').find('#priceEditInput').val(id.split(":")[2]);

                                     $('#myModalEdit').modal();
                                 });

              $(document).on("click", "#submitlRequest", function (e) {


                                          submitlHolidayRequest();

                                       
                                      });

   });


  
function submitlHolidayRequest() {
             
               var jsonRequest = {};

               jsonRequest["id"] =  $("#holidayId").val();
               jsonRequest["description"] =  $("#nameEditInput").val();
               jsonRequest["amount"] =  $("#priceEditInput").val();
               jsonRequest["paymentMethod"] =  $("#paymentInput").val();
               jsonRequest["discount"] =  "";
               jsonRequest["paidBy"] =  "";
               jsonRequest["paymentDate"] =  "";
               
               
               var userJson = JSON.parse(localStorage.getItem("user"));
               console.log(userJson);

               if (userJson === null)
               	 window.location.href = "${pageContext.request.servletContext.contextPath}/login";

               else
               {

		               var param = JSON.stringify(jsonRequest);
		       
		               $.ajax({
		                   url: "${cp}/api/v1/zoo/holidayRequest",
		                   type: "POST",
		                   dataType: "json",
		                   beforeSend: function (xhr) {
		                       xhr.setRequestHeader("Accept", "application/json");
		                       xhr.setRequestHeader("Content-Type", "application/json");
		                        xhr.setRequestHeader("X-Auth-Token", userJson.accessToken);

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

		                      localStorage.removeItem("user");


		                       $("#resultsError").html(responseText.description);

		                   }
		               }

		           );
           }
           }


 </script>

<!-- Modal Edit-->
<div id="myModalEdit" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Holiday Package Request</h4>
      </div>
      <div class="modal-body">
            <form:form id = "form-popup-cell8" class="form-horizontal">
                       <div class="form-group">
                       <input type ="hidden" name ="holidayId" value ="" id ="holidayId"/>
                           <label for="nameEditInput" class="col-sm-2 control-label">Name</label>
                           <div class="col-sm-8">
                               <input type="text" class="form-control1" id="nameEditInput">
                           </div>
                           <div class="col-sm-2">

                           </div>
                       </div>
                       <div class="form-group">
                      
                           <label for="priceEditInput" class="col-sm-2 control-label">Price</label>
                           <div class="col-sm-8">
                               <input type="text" class="form-control1" id="priceEditInput">
                           </div>
                           <div class="col-sm-2">

                           </div>
                       </div>
                        <div class="form-group">
                    <label for="paymentInput" class="col-sm-2 control-label">Payment Method</label>
                    <div class="col-sm-8">
                        <select  id="paymentInput" class="form-control1">
                            <option>Cash</option>
                            <option>Card</option>
                            <option>Zoo Card</option>

                        </select>
                    </div>
                    <div class="col-sm-2">

                    </div>
                </div>

               </form:form>
      </div>
      <div class="modal-footer">
      <button type="button" class="btn btn-primary" id="submitlRequest">Pay</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
 </div>

</div>
</html>
