<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Your Listings</title>
<link rel="stylesheet" type="text/css" href="resources/css/sweetalert.css">

</head>
<body>
	<jsp:include page="menu.jsp" />

<h1><i>Available Listings for host ${traveller.firstName}</i></h1>
<hr>
<c:if test = "${not empty infoMessage}">
<p>${infoMessage}</p>
</c:if>
<c:choose>
<c:when test = "${not empty hostListing}">
<table border="1">
<th><b>Listing ID</b></th>
<th><b>Property Type</b></th>
<th><b>Available From</b></th>
<th><b>Available To</b></th>
<th><b>City</b></th>
<th><b>Status</b></th>
<th><b>Delete Action</b></th>

<c:forEach var="listing" items="${hostListing}">
<tr>
<td>${listing.listingID}</td>
<td>${listing.propertyType}</td>
<td>${listing.availableFrom}</td>
<td>${listing.availableTo}</td>
<td>${listing.address.city}</td>
<td>${listing.status}</td>
<c:if test="${listing.status eq 'active' }">
<td><a href="manageListing.htm?action=delete&param1=${listing.listingID}">Delete</a></td>
</c:if>
<c:if test="${listing.status eq 'inactive' }">
<td><a href="manageListing.htm?action=reactivate&param1=${listing.listingID}">Reactivate</a></td>
</c:if>
</tr>
</c:forEach>
</table>
</c:when>
<c:otherwise>No Listing available for the host!!!</c:otherwise>
</c:choose>
<script src="resources/js/sweetalert.min.js"></script> 

</body>
</html>