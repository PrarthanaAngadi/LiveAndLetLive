<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Redirected to Reservation</title>
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
	<c:choose>
		<c:when test="${not empty selectedListing}">
			<h1>
				<i>Please confirm your booking by filling the below mentioned
					details</i>
			</h1>
			<hr>
				<p><b>Listing ID     :</b> ${selectedListing.listingID}</p><br>
				<p><b>Property Type  :</b> ${selectedListing.propertyType}</p><br>
				<p><b>Room Type      :</b> ${selectedListing.roomType}</p><br>
				<p><b>Accomodates    :</b> ${selectedListing.accomodates}</p><br>
				<p><b>BedRooms       :</b> ${selectedListing.bedRooms}</p><br>
				<p><b>Beds           :</b> ${selectedListing.beds}</p><br>
				<p><b>Bathrooms      :</b> ${selectedListing.bathrooms}</p><br>
				<p><b>Summary        :</b> ${selectedListing.summary}</p><br>
				<p><b>Host Name      :</b> ${selectedListing.traveller.firstName}</p><br>
				<p><b>Host Email ID  :</b> ${selectedListing.traveller.emailID}</p><br>
				<p><b>Street Address :</b> ${selectedListing.address.streetAddress}</p><br>
				<p><b>Price Per Day  :</b> ${selectedListing.pricePerDay}</p><br>
					
					<br>
					<br>
					<br>
					<br>
					<br>
			<c:forEach var="photo" items="${selectedListing.getListingphotos()}">
				<img src="http://localhost:8080${photo.photoPath}" height="200"
					width="200" />
			</c:forEach>
			<br>
			<br>
			<br>
			<br>
			<form action="reservation.htm" method="post"
				onsubmit="return onCheckReservation(this);">
				Card Number (format - 1234567812345678) : <input type="text"
					name="cardnumber" pattern="[0-9]{13,16}" /> <br> Expiry Date
				(mmyy) : <input type="text" name="expirydate" /> <br> CVV : <input
					type="text" name="cvv" /> <br> Amount : <input type="text"
					value="${amount}" readonly /> <br> <input
					type="submit" value="Confirm Reservation">
			</form>
		</c:when>
		<c:when test="${not empty reservationid}">
			<p>
			<h1>
				<i>Payment done successfully & Reservation confirmed!!</i>
			</h1>
			</p>
		</c:when>
		<c:otherwise>
			<p>
			<h1>
				<i>Your trying to book your own listing bymistake!!</i>
			</h1>
			</p>
		</c:otherwise>
	</c:choose>
	<script type="text/javascript" src="resources/js/reservationValidation.js"></script>
	<script src="resources/js/sweetalert.min.js"></script> 
	
</body>
</html>