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
<title>Prime Zoo Garden| Contact</title>
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
				 <li><a href="${cp}/index">Home</a></li>
				 <li><a href="${cp}/gallery">Gallery</a></li>
				 <li><a href="typo.html">Appointment</a></li>
				  <li><a href="typo.html">Holiday Packages</a></li>
				 <li class="active"><a href="${cp}/contact">Contact</a></li>
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
<div class="contact">
		<div class="container">
			<div class="contact-top">
				<h2>Contact</h2>
			</div>
			<div class="contact-bottom">
				 <div class="contact-text">
					<div class="col-md-3 contact-right">
						<div class="address">
							<h5>Address</h5>
							<p>Prime Zoo Garden,
							<span>1000 North 4th street,</span>
							Fairfield, IA</p>
						</div>
						<div class="address">
							<h5>Address1</h5>
							<p>Tel:9115550341,
							<span>Fax:9115550341</span>
							Email: <a href="mailto:zoo@garden.com">zoo@garden.com</a></p>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="col-md-9 contact-left">
						<form>
						<input type="text" value="Name" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Name';}" />
						<input type="text" value="Email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email';}" />
						<input type="text" value="Phone" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Phone';}" />
						<textarea value="Message:" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Message';}">Message..</textarea>
							<div class="submit-btn">
									<input type="submit" value="SUBMIT">
							</div>
						</form>
					</div>
					<div class="clearfix"></div>
			 </div>
				<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3010.3396850890695!2d-91.96947928493154!3d41.017823779299874!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x87e666733021a1fd%3A0xbd109f9c0f5e4fce!2sMaharishi+University+Of+Management!5e0!3m2!1sen!2sus!4v1507825025229" frameborder="0" style="border:0"></iframe>

		 </div>
	 </div>
</div>
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
			 <h3></h3>
		 </div>
		 <div class="ftr-right">
			 <p>Copyright &copy; 2017 Wild Life. All rights reserved | Design by <a href="http://w3layouts.com">W3layouts</a></p>
		 </div>
		 <div class="clearfix"></div>
	 </div>
</div>
<!---->
</body>
</html>