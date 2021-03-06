<%@page import="com.air.models.FlightRegister"%>
<%@page import="java.util.List"%>
<%@page import="com.air.Dao.MailDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
	<head>
	 <!-- forms css -->
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/> 
	
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Travel &mdash; 100% Free Fully Responsive HTML5 Template by FREEHTML5.co</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Template by FREEHTML5.CO" />
	<meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
	<meta name="author" content="FREEHTML5.CO" />

  <!-- 
	//////////////////////////////////////////////////////

	FREE HTML5 TEMPLATE 
	DESIGNED & DEVELOPED by FREEHTML5.CO
		
	Website: 		http://freehtml5.co/
	Email: 			info@freehtml5.co
	Twitter: 		http://twitter.com/fh5co
	Facebook: 		https://www.facebook.com/fh5co

	//////////////////////////////////////////////////////
	 -->

  	<!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="favicon.ico">

	<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,300' rel='stylesheet' type='text/css'>
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="css/icomoon.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="css/bootstrap.css">
	<!-- Superfish -->
	<link rel="stylesheet" href="css/superfish.css">
	<!-- Magnific Popup -->
	<link rel="stylesheet" href="css/magnific-popup.css">
	<!-- Date Picker -->
	<link rel="stylesheet" href="css/bootstrap-datepicker.min.css">
	<!-- CS Select -->
	<link rel="stylesheet" href="css/cs-select.css">
	<link rel="stylesheet" href="css/cs-skin-border.css">
	
	<link rel="stylesheet" href="css/style.css">


	<!-- Modernizr JS -->
	<script src="js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->
<style type="text/css">
input , select,textarea {
	width:100%;
	

}
	
            th, td,tr{
            	   
                text-align:center; 
                border:1px solid black;
                padding:5px; 
            
            }
            	
</style>




	</head>
	<body>
		<div id="fh5co-wrapper">
		<div id="fh5co-page">

		<header id="fh5co-header-section" class="sticky-banner">
			<div class="container">
				<div class="nav-header">
					<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle dark"><i></i></a>
					<h1 id="fh5co-logo"><a href="index.html"><i class="icon-airplane"></i>Travel</a></h1>
					<!-- START #fh5co-menu-wrap -->
					<nav id="fh5co-menu-wrap" role="navigation">
						<ul class="sf-menu" id="fh5co-primary-menu">
							<li><a href="AdminHome.jsp">Home</a></li>
							
							<li><a href="BookedFlightTickets.jsp">Booked tickets</a></li>
							<li><a href="ContactedUsers.jsp">Contacted Users</a></li>
							<li  class="active"><a href="FlightRegister.jsp">Flights</a>
							<li><a href="LogoutServlet">Logout</a></li>
							
						</ul>
					</nav>
				</div>
			</div>
		</header>

		<!-- end:header-top -->
	<!-- 
		<div class="fh5co-hero">
			<div class="fh5co-overlay"></div>
			<div class="fh5co-cover" data-stellar-background-ratio="0.5" style="background-image: url(images/cover_bg_1.jpg);">
				<div class="desc">
					<div class="container">
						<div class="row">
														
							
								<div class="col-sm-7 col-sm-push-1 col-md-7 col-md-push-1">
									<h3>Please login</h3>
									<h3>to book or cancel </h3>
									<h3>your flight tickets</h3>
									
									<p><a class="btn btn-primary btn-lg" href="#">Get Started</a></p>
								</div>
								
							
							</div>	
						</div>
					</div>
				</div>
			</div>

		
		<br><br>
		
 -->	
 <br><br><br><br>
 
 	<main>
 	<%
		MailDAO m=new MailDAO();
		List<FlightRegister> l=m.ReadFlights();
		request.setAttribute("list", l);
		
		
		
		%>
		<div align="center" >
		<table border="1">
		<tr>
		<th>Flight Id</th>
		<th>Flight Name</th>
		<th>From</th>
		<th>To</th>
		<th>Time</th>
		<th>Date</th>
		<th>Airport</th>
		<th>Price</th>
		<th>Details</th>
		<th>Remove Flights</th>
		</tr>
		<c:forEach items="${list}" var="l">
		<tr>
		<td><c:out value="${l.getFlightId() }"></c:out>  </td>
		<td><c:out value="${l.getFlightName() }"></c:out>  </td>
		<td><c:out value="${l.getFrom() }"></c:out>  </td>
		<td><c:out value="${l.getTo() }"></c:out>  </td>
		<td><c:out value="${l.getTime() }"></c:out>  </td>
		<td><c:out value="${l.getDate() }"></c:out>  </td>
		<td><c:out value="${l.getAirport() }"></c:out>  </td>
		<td><c:out value="${l.getPrice() }"></c:out>  </td>
		<td><c:out value="${l.getDetails() }"></c:out>  </td>
	    <td> <a href="RemoveFlight?id=${l.getFlightId()}"><button>Delete</button> </a> </td>
      </tr>
</c:forEach>
				
		</table>
		
		</div>
		<br><br><br>
		<hr><hr>
 	
		<div class="container" align="center" style="width: 40%;">
								
								<form action="FlightRegisterServlet" style="width: 90%;">
								<h2><b>Flight Register</b></h2><br>
								<div style="text-align: left;">
								
								<label>Flight ID</label><br>
								<input type="text" name="flightid" placeholder="enter flight id"><br><br>
								<label>Flight Name</label><br>
								<input type="type" name="flightname" placeholder="enter flight name" ><br><br>
								<label>From</label><br>
								<select name="from">
									
									<option value="vizag">Vizag</option>
									<option value="chennai">Chennai</option>
									<option value="hyd">Hyderabad</option>
									<option value="banglore">Banglore</option>
								
								
								
								</select><br><br>
								<label>To</label><br>
								<select name="to">
									
									<option value="vizag">Vizag</option>
									<option value="chennai">Chennai</option>
									<option value="hyd">Hyderabad</option>
									<option value="banglore">Banglore</option>
								
								
								
								</select><br><br>
								<label>Time</label><br>
								<input name="time" type="time" placeholder="enter time"><br><br>
								<label>Date</label><br>
								<input name="date" type="date" placeholder="enter date">
								<br><br>
								<label>Airport</label><br>
								<select name="airport">
									
									<option value="vizag">Vizag</option>
									<option value="chennai">Chennai</option>
									<option value="hyd">Hyderabad</option>
									<option value="banglore">Banglore</option>
								
								
								
								</select><br><br>
								<label>Price</label><br>
								<input type="number" name="price" placeholder="Enter price"><br><br>
								<label>Details</label><br>
								<textarea name="details">enter details </textarea><br><br>
								</div>
								<input type="submit"  value="submit" class="btn btn-primary btn-m" style="width:40%;" >
								
								</form><br>
								<br>
								
							</div>
		
		
		
		
		
		</main>
		
				<footer>
				<br><br>
			<div id="footer">
				<div class="container">
					<div class="row row-bottom-padded-md">
						<div class="col-md-2 col-sm-2 col-xs-12 fh5co-footer-link">
							<h3>About Travel</h3>
							<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
						</div>
						<div class="col-md-2 col-sm-2 col-xs-12 fh5co-footer-link">
							<h3>Top Flights Routes</h3>
							<ul>
								<li><a href="#">Manila flights</a></li>
								<li><a href="#">Dubai flights</a></li>
								<li><a href="#">Bangkok flights</a></li>
								<li><a href="#">Tokyo Flight</a></li>
								<li><a href="#">New York Flights</a></li>
							</ul>
						</div>
						<div class="col-md-2 col-sm-2 col-xs-12 fh5co-footer-link">
							<h3>Top Hotels</h3>
							<ul>
								<li><a href="#">Boracay Hotel</a></li>
								<li><a href="#">Dubai Hotel</a></li>
								<li><a href="#">Singapore Hotel</a></li>
								<li><a href="#">Manila Hotel</a></li>
							</ul>
						</div>
						<div class="col-md-2 col-sm-2 col-xs-12 fh5co-footer-link">
							<h3>Interest</h3>
							<ul>
								<li><a href="#">Beaches</a></li>
								<li><a href="#">Family Travel</a></li>
								<li><a href="#">Budget Travel</a></li>
								<li><a href="#">Food &amp; Drink</a></li>
								<li><a href="#">Honeymoon and Romance</a></li>
							</ul>
						</div>
						<div class="col-md-2 col-sm-2 col-xs-12 fh5co-footer-link">
							<h3>Best Places</h3>
							<ul>
								<li><a href="#">Boracay Beach</a></li>
								<li><a href="#">Dubai</a></li>
								<li><a href="#">Singapore</a></li>
								<li><a href="#">Hongkong</a></li>
							</ul>
						</div>
						<div class="col-md-2 col-sm-2 col-xs-12 fh5co-footer-link">
							<h3>Affordable</h3>
							<ul>
								<li><a href="#">Food &amp; Drink</a></li>
								<li><a href="#">Fare Flights</a></li>
							</ul>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6 col-md-offset-3 text-center">
							<p class="fh5co-social-icons">
								<a href="#"><i class="icon-twitter2"></i></a>
								<a href="#"><i class="icon-facebook2"></i></a>
								<a href="#"><i class="icon-instagram"></i></a>
								<a href="#"><i class="icon-dribbble2"></i></a>
								<a href="#"><i class="icon-youtube"></i></a>
							</p>
							<p>Copyright 2016 Free Html5 <a href="#">Module</a>. All Rights Reserved. <br>Made with <i class="icon-heart3"></i> by <a href="http://freehtml5.co/" target="_blank">Freehtml5.co</a> / Demo Images: <a href="https://unsplash.com/" target="_blank">Unsplash</a></p>
						</div>
					</div>
				</div>
			</div>
		</footer>

	

	</div>
	<!-- END fh5co-page -->

	</div>
	<!-- END fh5co-wrapper -->

	<!-- jQuery -->


	<script src="js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<script src="js/sticky.js"></script>

	<!-- Stellar -->
	<script src="js/jquery.stellar.min.js"></script>
	<!-- Superfish -->
	<script src="js/hoverIntent.js"></script>
	<script src="js/superfish.js"></script>
	<!-- Magnific Popup -->
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/magnific-popup-options.js"></script>
	<!-- Date Picker -->
	<script src="js/bootstrap-datepicker.min.js"></script>
	<!-- CS Select -->
	<script src="js/classie.js"></script>
	<script src="js/selectFx.js"></script>
	
	<!-- Main JS -->
	<script src="js/main.js"></script>

	</body>
</html>

