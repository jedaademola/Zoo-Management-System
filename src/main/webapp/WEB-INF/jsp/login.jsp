<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />
<html>
<head>
<title>Prime Zoo Garden| Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Prime Zoo Garden" />
<!--script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script -->
 <!-- Bootstrap Core CSS -->
<link href="${cp}/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="${cp}/css/style.css" rel='stylesheet' type='text/css' />
<link href="${cp}/css/font-awesome.css" rel="stylesheet"> 
<!-- jQuery -->
<script src="${cp}/js/jquery.min.js"></script>
<!----webfonts--->
<link href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
<!---//webfonts--->  
<!-- Bootstrap Core JavaScript -->
<script src="${cp}/js/bootstrap.min.js"></script>

</head>
<body id="login">
<div class="login-logo">
    <a href=""><img src="" alt=""/></a>
  </div>
  <h2 class="form-heading">login</h2>



  <div class="app-cam">

	  <form >
      
        <c:if test="${not empty emr}">
          <font color="red" style ='vertical-align: auto'>${emr}</font>    
        </c:if>
   

	  	<div class="alert alert-danger alert-dismissable" style="display:none" id="msgAlertFailed">
    
    <div id="resultsError">
      
    </div>
		</div>
		<input type="text" class="text"  id="txtUsername">
		<input type="password"  id="txtPassowrd">
		
			  <button type="button" id="submitLogin" class="btn btn-primary btn-md pull-right">Login</button> 
		
		<div class="login-social-link">
          <a href="" class="facebook">
              Facebook
          </a>
          <a href="" class="twitter">
              Twitter
          </a>
        </div>
		<ul class="new">
			<li class="new_left"><p><a href="#">Forgot Password ?</a></p></li>
			<li class="new_right"><p class="sign">New here ?<a href="register"> Sign Up</a></p></li>
			<div class="clearfix"></div>
		</ul>
	</form>
  </div>
   <div class="copy_layout login">
      <p>Copyright &copy; 2017. All Rights Reserved | Design by <a href="http://w3layouts.com/" target="_blank">W3layouts</a> </p>
   </div>
</body>
<script type="text/javascript">
    $(document).ready(function () {

             $(document).on("click", "#submitLogin", function (e) {

                    callLogin();

                });


   });



   function callLogin() {

   			 document.getElementById("msgAlertFailed").style.display = 'none';

               var jsonRequest = {};

               jsonRequest["username"] =  $("#txtUsername").val();
               jsonRequest["password"] =  $("#txtPassowrd").val();

              
               var param = JSON.stringify(jsonRequest);

               $.ajax({
                   url: "${cp}/api/v1/zoo/user/authenticate",
                   type: "POST",
                   dataType: "json",
                   beforeSend: function (xhr) {
                       xhr.setRequestHeader("Accept", "application/json");
                       xhr.setRequestHeader("Content-Type", "application/json");
                       

                   },
                   data: param,
                   success: function (data) {

                     localStorage.setItem("user", JSON.stringify(data));
                     //window.location.href = "${pageContext.request.servletContext.contextPath}/dashboard";
                     redirct();


                   }
                   ,
                   error: function (xhr, errorType, exception) {

                      
                       document.getElementById("msgAlertFailed").style.display = '';
                      

                       var responseText = JSON.parse(xhr.responseText);
                        console.log(responseText.description);


                       $("#resultsError").html(responseText.description);

                   }
               }

           );
           }

 function redirct() {

               var userJson = JSON.parse(localStorage.getItem("user"));

               console.log(userJson.accessToken);

               var param ='';

               $.ajax({
                   url: "${cp}/confirmLogin",
                   type: "GET",
                   dataType: "json",
                   beforeSend: function (xhr) {
                      // xhr.setRequestHeader("Accept", "application/json");
                       //xhr.setRequestHeader("Content-Type", "application/json");
                       xhr.setRequestHeader("X-Auth-Token", userJson.accessToken);

                   },
                   data: param,
                   success: function (data) {

                    // localStorage.setItem("user", JSON.stringify(data));
                    // window.location.href = "${pageContext.request.servletContext.contextPath}/dashboard";


                   }
                   ,
                   error: function (xhr, errorType, exception) {

                      
                       //document.getElementById("msgAlertFailed").style.display = '';
                      

                       //var responseText = JSON.parse(xhr.responseText);
                        console.log(xhr.responseText);


                       //$("#resultsError").html(responseText.description);

                   }
               }

           );
           }



   </script>               
</html>
