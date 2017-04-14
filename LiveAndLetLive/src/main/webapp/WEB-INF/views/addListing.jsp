<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Listing</title>
<link rel="stylesheet" type="text/css" href="resources/css/sweetalert.css">

</head>
<body>
<jsp:include page="menu.jsp" />

	<c:if test="${not empty listing}">
		<p>Listing Added Successfully</p>
		<a href="addPhotos.htm?param1=${listing.listingID}">Add Photos</a>
		<hr>
	</c:if>
	<c:if test = "${not empty dateMessage}">
	<h3><p>Invalid Listing : ${dateMessage}</p></h3>
	</c:if>
	<h1>
		<i>Add a Listing</i>
	</h1>
	<hr>
	<form action="addListing.htm" method="post" onsubmit="return checkListingForm(this);">
		Property Type : <select name="propertyType">
			<option value="Apartment">Apartment</option>
			<option value="House">House</option>
			<option value="Loft">Loft</option>
			<option value="TownHouse">TownHouse</option>
			<option value="Bungalow">Bungalow</option>
			<option value="Cabin">Cabin</option>
			<option value="Villa">Villa</option>
			<option value="Castle">Castle</option>
			<option value="Dorm">Dorm</option>
			<option value="TreeHouse">TreeHouse</option>
			<option value="Boat">Boat</option>
			<option value="Tent">Tent</option>
			<option value="Other">Other</option>
		</select><br>
		<br> Room Type : <select name="roomType">
			<option value="EntireHome">Entire Home</option>
			<option value="PrivateRoom">Private Room</option>
			<option value="SharedRoom">Shared Room</option>
		</select><br>
		<br> Accomodates : <select name="accomodates">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
			<option value="8">8</option>
			<option value="9">9</option>
			<option value="10">10</option>
			<option value="11">11</option>
			<option value="12">12</option>
		</select><br>
		<br> Bedrooms : <select name="bedrooms">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
			<option value="8">8</option>
			<option value="9">9</option>
			<option value="10">10</option>
		</select><br>
		<br> Beds : <select name="beds">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
			<option value="8">8</option>
			<option value="9">9</option>
			<option value="10">10</option>
			<option value="11">11</option>
			<option value="12">12</option>
		</select><br>
		<br> Bathrooms : <select name="bathrooms">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
		</select><br>
		<br> Summary :
		<textarea rows="4" cols="50" name="summary">
</textarea>
		<br>
		<br> Available From : <input type="date" name="availableFrom"><br>
		<br> Available To : <input type="date" name="availableTo"><br>
		<br> Price per day : <input type="text" name="pricePerDay"><br>
		<br> Zip : <input type="text" name="zip"><br>
		<br> StreetAddress : <input type="text" name="streetAddress"><br>
		<br> City : <select name="city">
		<option value="Boston">Boston</option>
			<option value="Worcester">Worcester</option>
			<option value="Salem">Salem</option>
			<option value="Cambridge">Cambridge</option>
		</select><br>
		<br> State : <input type="text" name="state" value="MA" readonly><br>
		<br> Country : <input type="text" name="country" value="USA" readonly><br>
		<br> <input type="submit" name="Add a Listing">
	</form>
<script type="text/javascript" src="resources/js/listingValidation.js"></script>
<script src="resources/js/sweetalert.min.js"></script> 


</body>
</html>