<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" "/>
</head>
<body>
	<h1>Registration Form</h1>
	
	<sf:form method="POST" commandName="spitter">
		FirstName:<sf:input path="firstName" /> <br/>
		LastName:<sf:input path="lastName"/> <br/>
		Email:<sf:input path="email" /><br/>
		UserName:<sf:input path="userName"/><br/>
		Password:<sf:password path="password"/><br/>
		
		<input type="password" value="Register">
	
	</sf:form>
	
	<!-- 
	
	<form method="POST">
		FirstName: <input type="text" name="firstName"/><br/>
		LastName:<input type="text" name="lastName"/><br/>
		UserName:<input type="text" name="userName"/><br/>
		Password:<input type="password" name="password"/><br/>
		<input type="submit" value="Register"/>
	</form>
	 -->

</body>
</html>