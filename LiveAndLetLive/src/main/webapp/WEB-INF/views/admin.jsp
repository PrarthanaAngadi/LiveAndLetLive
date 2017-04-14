<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Admin</title>
</head>
<body>
<h1><i>Welcome Admin&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="index.jsp"><input type="button" value="Logout"></a></i></h1>
<hr>
<p>Total Number of users are ${totalNumberOfUsers}</p>
<br><br>
<c:if test="${not empty listOfMessages}">
<span id="success"></span>
<p><b>List of Messages Received</b></p>
<table border="1">
<th>Name</th>
<th>Email</th>
<th>Subject</th>
<th>Message</th>
<th>Response Status</th>
<th>Action</th>
<c:forEach var="message" items="${listOfMessages}">
<tr>
<td>${message.name}</td>
<td>${message.email}</td>
<td>${message.subject}</td>
<td>${message.message}</td>
<td>${message.status}</td>
<c:choose>
<c:when test="${message.status eq 'Response Pending'}">
<td><a href="email.htm?messageid=${message.contactID}">Reply</a></td>
</c:when>
<c:otherwise>
<td>Not Applicable</td>
</c:otherwise>
</c:choose>
</tr>
</c:forEach>
</table>
</c:if>
<c:if test="${not empty contact}">
<form action="sendEmail.htm" method="post" >
From : <input type="text" name="from" value="api.java.project@gmail.com" readonly/><br><br>
To : <input type="text" name="to" value="${contact.email}" readonly/><br><br>
Subject : <input type="text" name="subject" value="Live&LetLive Response : ${contact.subject}" readonly/><br><br>
Submitted Query : <input type="text" name="query" value="${contact.message}" readonly/><br><br>
Message : <textarea name="responsemessage" cols="40" rows="10"></textarea><br><br>
<input type="hidden" name="contactID" value="${contact.contactID}"/>
<input type="submit" value="Send"/>
</form>
</c:if>

</body>
</html>