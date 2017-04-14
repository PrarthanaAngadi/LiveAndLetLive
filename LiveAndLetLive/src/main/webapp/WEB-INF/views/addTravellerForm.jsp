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
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<div id="templatemo_about" class="container_wapper">
	<div class="main">
		<div class="header">
			<c:choose>
				<c:when test="${not empty selectedListingID }">
					<h1>For Booking first create an Account</h1>
				</c:when>
				<c:otherwise>
					<h1>Login or Create a new Account</h1>
				</c:otherwise>
			</c:choose>
		</div>
		<form:form action="signup.htm" commandName="traveller" method="post">
			<ul class="left-form">
				<h2>New Account:</h2>
				<li><form:input path="userName" size="30"
						placeholder="Username" /><font color="red"><form:errors path="userName"/></font>
					<div class="clear"></div></li>
				<li><form:input path="password" placeholder="Password" /><font color="red"><form:errors path="password"/></font>
					<div class="clear"></div></li>
				<li><form:input path="emailID" placeholder="Email" /><font color="red"><form:errors path="emailID"/></font>
					<div class="clear"></div></li>
				<li><form:input path="firstName" placeholder="First Name" /><font color="red"><form:errors path="firstName"/></font>
					<div class="clear"></div></li>
				<li><form:input path="lastName" placeholder="Last Name" /><font color="red"><form:errors path="lastName"/></font>
					<div class="clear"></div></li>
				<%-- <li><form:input path="birthDate" placeholder="BirthDate" /><font color="red"><form:errors path="birthDate"/></font>
					<div class="clear"></div></li> --%>
				<li><form:input path="address.streetAddress"
						placeholder="Street Address" /><font color="red"><form:errors path="address.streetAddress"/></font>
					<div class="clear"></div></li>
				<li><form:input path="address.aptNo" placeholder="Apt No" /><font color="red"><form:errors path="address.aptNo"/></font>
					<div class="clear"></div></li>
				<li><form:input path="address.zip" placeholder="Zip" /><font color="red"><form:errors path="address.zip"/></font>
					<div class="clear"></div></li>
				<li><form:select path="address.city" placeholder="City">
						<form:option value="Boston" label="Boston" />
						<form:option value="Cambridge" label="Cambridge" />
						<form:option value="Worcester" label="Worcester" />
						<form:option value="Salem" label="Salem" />
					</form:select>
					<div class="clear"></div></li>
<%-- 				<li><form:input path="address.state" value="MA" /> --%>
<!-- 					<div class="clear"></div></li> -->
<%-- 				<li><form:input path="address.country" value="USA" /> --%>
<!-- 					<div class="clear"></div></li> -->

				<div class="clear"></div>
				<input type="submit" value="Create Account">
				<div class="clear"></div>
			</ul>


		</form:form>



	</div>
</div>

</body>
</html>