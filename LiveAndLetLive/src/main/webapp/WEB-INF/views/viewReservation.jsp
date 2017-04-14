<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Reservations</title>
</head>
<body>
	<jsp:include page="menu.jsp" />

<h1><i>View Reservations for Traveller ${traveller.firstName}</i></h1>
<hr><br>
<c:if test="${not empty infoMessage }">
<p>${infoMessage}</p>
</c:if>
<c:choose>
<c:when test="${not empty reservationList}">
<table border="1">
<th>Reservation ID</th>
<th>CheckIn Date</th>
<th>CheckOut Date</th>
<th>Reservation Status</th>
<th>Reservation History</th>
<th>Cancellation Action</th>
<c:forEach var="reservation" items="${reservationList}" varStatus="loop">
<tr>
<td>${reservation.getReservationID()}</td>
<td>${reservation.getCheckIn()}</td>
<td>${reservation.getCheckOut()}</td>
<td>${reservation.getStatus()}</td>
<td>${reservationStatus[loop.index]}</td>
<c:choose>
<c:when test="${reservationStatus[loop.index] eq 'active' }">
<td><a href="cancellation.htm?reservationID=${reservation.getReservationID()}">Cancellation</td>
</c:when>
<c:otherwise>
<td>Not Applicable</td>
</c:otherwise>
</c:choose>
</tr>
</c:forEach>
</table>
</c:when>
<c:otherwise>
<p> You have no reservations!!!</p>
</c:otherwise>
</c:choose>
</body>
</html>