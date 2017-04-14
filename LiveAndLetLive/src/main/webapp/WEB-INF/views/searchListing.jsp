<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Available Listing</title>
</head>
<body>
<h1><i>Available Listings based on your search</i></h1>
<hr>
<c:choose>
<c:when test = "${not empty fetchedList}">
<% int i =0; %>
<c:forEach var="fl" items="${fetchedList}">
<% i=i+1; %>
<% out.println(i); %>) Price Per Day : <c:out value="${fl.pricePerDay}$"></c:out>
<a href="reservation.htm?Listingid=${fl.listingID}"><input type="button" value="Book"/></a><br><br>
<c:forEach var="photo" items="${fl.getListingphotos()}">
<img src="http://localhost:8080${photo.photoPath}" height="200" width="200"/>
</c:forEach><br>
</c:forEach>
</c:when>
<c:otherwise>
<p>Sorry there are no available listings!!!</p>
</c:otherwise>
</c:choose>
</body>
</html>