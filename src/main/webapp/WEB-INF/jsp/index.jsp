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
<title>Prime Zoo Garden| Home</title>
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
<div class="banner">
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
				 <li class="active"><a href="${cp}/index">Home</a></li>
				 <li><a href="${cp}/gallery">Gallery</a></li>
				  <li><a href="${cp}/holidayPackage">Holiday Packages</a></li>
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
				 <input type="text" value="" placeholder="Search Animal">
				 <input type="submit" value="">
				</form>
		 </div>
		 <div class="clearfix"></div>
	 </div>
</div>
<!---->
<div class="banner-sec">
	 <div class="banner-grids">
			 <div class="col-md-7 banner-left">
				 <div class="banner_lft_info">
					 <p><a href="projects.html">Safari Park</a></p>
					 <h3></h3>
				 </div>
			 </div>
			 <div class="col-md-5 banner-right">
				 <div class="bnr-right grid1">
					 <div class="banner_rght_info">
						 <p><a href="">Elephants</a></p>
						 <h4>Elephantidae and the order Proboscidea.</h4>
					 </div>
				 </div>
				 <div class="bnr-right grid2">
					 <div class="banner_rght_info bnr_rht">
						 <p><a href="">Wild Cats</a></p>
						 <h4>The wildcat (Felis silvestris) is a small cat native.</h4>
					 </div>
				 </div>
				 <div class="clearfix"></div>
				 <div class="bnr-right grid3">
					 <div class="banner_rght_info">
						 <p><a href="">Birds</a></p>
						 <h4>Birds are a group of endothermic vertebrates, characterised by feathers.</h4>
					 </div>
				 </div>
				 <div class="bnr-right grid4">
					 <div class="banner_rght_info bnr_rht">
						 <p><a href="">Reptiles</a></p>
						<h4>Reptiles are tetrapod animals in the class Reptilia</h4>
					 </div>
				 </div>
				 <div class="clearfix"></div>
			 </div>
			 <div class="clearfix"></div>
	 </div>
	</div>
</div>
<!---->

<!---->
<div class="service">
	 <div class="container">
		 <h3>Services</h3>
		  <div class="works">
			  <div class="prjt-grid">
				 <div class="box maxheight">
					  <a class="example-image-link" href="images/s1.jpg" data-lightbox="example-1" data-title="Guidance."><img class="example-image" src="images/s1.jpg"></a>
					  <div class="project-info">
					   <a href="">Guidance</a>
					   <p>Our well trained staff are ready to guid you around the zoo </p>
					  </div>
				 </div>
			  </div>
			  <div class="prjt-grid">
				 <div class="box maxheight">
					  <a class="example-image-link" href="images/s2.jpg" data-lightbox="example-2" data-title="Mobile Tents."><img class="example-image" src="images/s2.jpg"></a>
					  <div class="project-info">
					  <a href="">Mobile Tents</a>
					  <p>We set up Mobile Tents for our visitors and tourist </p>
					  </div>
				  </div>
			  </div>
			  <div class="prjt-grid span66">
				 <div class="box maxheight">
					  	<a class="example-image-link" href="images/s3.jpg" data-lightbox="example-3" data-title="Animal Care."><img class="example-image" src="images/s3.jpg"></a>
					  <div class="project-info">
					  <a href="">Animal Care</a>
					  <p>Animal Care: our staff care for our animals</p>
					  </div>
				  </div>
			  </div>
			 <div class="clearfix"></div>
		 </div>
	 </div>
</div>
<script src="${cp}/js/js/lightbox-plus-jquery.min.js"></script>
<!---->

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
</body>
</html>
