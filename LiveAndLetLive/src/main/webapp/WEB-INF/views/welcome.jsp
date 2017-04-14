<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome  ${traveller.firstName} </title>
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
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="resources/css/sweetalert.css">
    
</head>
<body>
	<jsp:include page="menu.jsp" />

<div id="templatemo_events" class="container_wapper">
	<div class="container-fluid">
		<h1><i>Search Listings</i></h1>
		<center>
		<c:if test="${not empty dateMessage}">
		<p>${dateMessage}</p>
		</c:if>
		<form action="search.htm" method="post" onsubmit="return onCheckSearch(this);">
		<font color="white">Check-In : </font><input type="date" name="checkin"/>
		<font color="white">Check-Out : </font><input type="date" name="checkout"/>
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
<script type="text/javascript" src="resources/js/searchValidation.js"></script>
<script src="resources/js/sweetalert.min.js"></script> 


</body>
</html>