<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/css/sweetalert.css">

</head>
<body>
	<jsp:include page="menu.jsp" />

	<h1>Add Photos to ListingID ${listingid}</h1>
	<hr>
	<form:form action="addPhotos.htm?param1=${listingid}" method="POST" 
	commandName="listingphotos"  enctype="multipart/form-data"  onsubmit="return checkPhotoForm(this);">
		<form:input path="photo" type="file" />
		<input type="submit" value="Add Photos" />
	</form:form>
	<script src="resources/js/sweetalert.min.js"></script> 
	<script type="text/javascript" src="resources/js/photoValidation.js"></script>
	
</body>
</html>