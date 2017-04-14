<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: red;
}

li {
	float: left;
}

li a {
	display: inline-block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover {
	background-color: #111;
}
</style>

</head>
<body>
	<ul>
			<li><a class="active" href="login.htm">Home</a></li>
		<li><a href="addListing.htm">Want to become a Host?</a></li>
		<c:if test="${traveller.isHost eq 'Yes'}">
			<li><a href="manageListing.htm">Manage Listing</a></li>
		</c:if>
		<li><a href="viewReservations.htm">View Reservations</a></li>
		<!-- <li><a href="host.htm">Host</a></li> -->
		<li><a href="logout.htm">Logout</a></li>
	</ul>

</body>
</html>