<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>       
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--[if IE]><meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"><![endif]-->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- 
    Dragonfruit Template 
    http://www.templatemo.com/preview/templatemo_411_dragonfruit 
    -->
<title>Live&LetLive</title>
<meta name="description" content="" />
<!-- templatemo 411 dragonfruit -->
<meta name="author" content="templatemo">
<!-- Login CSS -->
<link href="resources/css/style.css" rel='stylesheet' type='text/css' />
<!-- Favicon-->
<link rel="shortcut icon" href="./favicon.png" />
<!-- Font Awesome -->
<link href="resources/css/font-awesome.min.css" rel="stylesheet">
<!-- Bootstrap -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<!-- Camera -->
<link href="resources/css/camera.css" rel="stylesheet">
<!-- Template  -->
<link href="resources/css/templatemo_style.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="resources/css/sweetalert.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<div class="banner" id="templatemo_banner_slide">
	<ul>
		<li class="templatemo_banner_slide_01">
			<div class="slide_caption">
				
			</div>
		</li>
		<li class="templatemo_banner_slide_02">
			<div class="slide_caption">
				
			</div>
		</li>
		<li class="templatemo_banner_slide_03">
			<div class="slide_caption">
				
			</div>
		</li>
	</ul>
</div>

<div id="templatemo_mobile_menu">
	<ul class="nav nav-pills nav-stacked">
		<li><a href="#templatemo_banner_slide"><i
				class="glyphicon glyphicon-home"></i> &nbsp; Home</a></li>
		<li><a href="#templatemo_login"><i
				class="glyphicon glyphicon-briefcase"></i> &nbsp; Login</a></li>
		<li><a href="#templatemo_search"><i
				class="glyphicon glyphicon-bullhorn"></i> &nbsp; Search</a></li>
		<li><a href="#templatemo_events"><i
				class="glyphicon glyphicon-calendar"></i> &nbsp; Events</a></li>
		<li><a href="#templatemo_contact"><i
				class="glyphicon glyphicon-phone-alt"></i> &nbsp; Contact</a></li>
	</ul>
</div>
<div class="container_wapper">
	<div id="templatemo_banner_menu">
		<div class="container-fluid">
			<div class="col-xs-4 templatemo_logo">
				<a href="#"> <img src="resources/images/templatemo_logo.jpg"
					id="logo_img" alt="dragonfruit website template"
					title="Dragonfruit Template" />
					<h1 id="logo_text">
						dragon<span>fruit</span>
					</h1>
				</a>
			</div>
			<div class="col-sm-8 hidden-xs">
				<ul class="nav nav-justified">
					<li><a href="#templatemo_banner_slide">Home</a></li>
					<li><a href="#templatemo_about">Login</a></li>
					<li><a href="#templatemo_events">Search</a></li>
					<li><a href="#templatemo_contact">Contact</a></li>
				</ul>
			</div>
			<div class="col-xs-8 visible-xs">
				<a href="#" id="mobile_menu"><span
					class="glyphicon glyphicon-th-list"></span></a>
			</div>
		</div>
	</div>
</div>
<div id="templatemo_about" class="container_wapper">
	<div class="main">
		<div class="header">
			<h1>Login</h1>
			<c:if test="${not empty invalidUser }">
			<p>Invalid UserName & Password</p>
			</c:if>
			<c:if test="${not empty selectedListingID}">
			<p>Please login/signup for booking</p>
			</c:if>
		</div>
		<form action="login.htm" method="post" onsubmit="return checkForm(this);">
			<ul class="right-form">
				<div>
					<li><input type="text" placeholder="Username" name="username"/></li>
					<li><input type="password" placeholder="Password" name="password"/></li>
					<input type="submit" value="Login">
					<a href="signup.htm">New User?</a>
				</div>
				<div class="clear"></div>
			</ul>
			<div class="clear"></div>

		</form>



	</div>
</div>
<!--templatemo_about-->
<div id="templatemo_events" class="container_wapper">
	<div class="container-fluid">
		<h1><i>Search Listings</i></h1>
		<center>
		<c:if test="${not empty dateMessage}">
		<font color='white'><p>${dateMessage}</p></font>
		</c:if>
		<form action="search.htm" method="post" onsubmit="return onCheckSearch(this);">
		<font color="white">Check-In : </font><input type="date" name="checkin"/>
		<font color="white">Check-Out : </font> <input type="date" name="checkout"/>
		<font color="white">City : </font><select name="cityname">
			<option value="Boston">Boston</option>
			<option value="Cambridge">Cambridge</option>
			<option value="Worcester">Worcester</option>
			<option value="Salem">Salem</option>
		</select>
		<input type="submit" value="Search"/>
		</form>
		</center>
		
	</div>
</div>

<div id="templatemo_contact" class="container_wapper">
	<div class="container-fluid">
		<h1>Contact</h1>
		<div class="col-xs-12">
			<div id="templatemo_contact_map"></div>
		</div>
		<div class="col-md-4">
			<h2>Contact Info.</h2>
			<p>Whether an apartment for a night, a castle for a week, or a villa for a month, 
			Live&LetLive connects people to unique travel experiences, at any price point, 
			in more than 34,000 cities and 191 countries. And with world-class customer service and a growing community of users, 
			Live&LetLive is the easiest way for people to monetize their extra space and 
			showcase it to an audience of millions.</p>
			<br>
			<p>
				<strong>Email:</strong> angadi.pr@husky.neu.edu<br /> <strong>Phone:</strong>
				617-669-9470<br /> 
			</p>
			
		</div>
		<form action="contact.htm" method="post" class="col-md-8" onsubmit="return checkContactForm(this);">
			<div class="row">
				<div class="col-md-12">
					<h2>Send Enquiry</h2>
				</div>
				<div class="col-md-6">
					<p>Name</p>
					<input type="text" name="name" id="name" placeholder="Your Name" />
				</div>
				<div class="col-md-6">
					<p>Email</p>
					<input type="text" name="email" id="email" placeholder="Your Email" />
				</div>
				<div class="col-md-12">
					<p>Subject</p>
					<input type="text" name="subject" id="subject"
						placeholder="Subject" />
				</div>
				<div class="col-md-12">
					<p>Message</p>
					<textarea name="message" id="message"
						placeholder="Write your message here..."></textarea>
				</div>
				<div class="col-xs-6 col-sm-3 col-md-offset-6">
					<button type="submit">Send</button>
				</div>
				
			</div>
		</form>
	</div>
</div>
<div id="templatemo_footer">
	<div>
		<p id="footer">Copyright &copy; 2016 Live&LetLive</p>
	</div>
</div>
<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/jquery-ui.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/jquery.singlePageNav.min.js"></script>
<script src="resources/js/unslider.min.js"></script>
<script
	src="https://maps.googleapis.com/maps/api/js?v=3.exp&amp;sensor=false"></script>

<script src="resources/js/templatemo_script.js"></script>
<script type="text/javascript" src="resources/js/loginValidation.js"></script>
<script type="text/javascript" src="resources/js/contactValidation.js"></script>
<script type="text/javascript" src="resources/js/searchValidation.js"></script>

<script src="resources/js/sweetalert.min.js"></script> 

</body>
</html>