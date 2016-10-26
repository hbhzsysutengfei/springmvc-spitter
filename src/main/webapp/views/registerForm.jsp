<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="style.css"/>
</head>
<body>
	<h1>Registration Form</h1>
	
	<sf:form method="POST" commandName="spitter">
		<sf:errors path="*" element="div" cssClass="error" />
		
		<sf:label path="firstName" cssErrorClass="error">FirstName:</sf:label>
			<sf:input path="firstName" /> <br/>
		<sf:label path="lastName" cssErrorClass="error">LastName:</sf:label>
			<sf:input path="lastName"/> <br/>
		<sf:label path="email" cssErrorClass="error">Email:</sf:label>
			<sf:input path="email" /><br/>
		<sf:label path="username" cssErrorClass="error">UserName:</sf:label>
			<sf:input path="username"/><br/>
		<sf:label path="password" cssErrorClass="error">Password:</sf:label>
			<sf:password path="password"/><br/>
		
		<input type="submit" value="Register">
	
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