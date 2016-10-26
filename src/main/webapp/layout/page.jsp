<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t"%>
<%@ page session="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<html>
	<head>
		<s:url var="styleFile" value="style.css"></s:url>
		<title>Spittle</title>
		<link rel="stylesheet" type="text/css" href= "${styleFile}" >
	</head>
	
	<body>
		<div id="header">
			<t:insertAttribute name="header" />
		</div>
		
		<div>
			<t:insertAttribute name="body"/>
		</div>
		<div>
			<t:insertAttribute name="footer"/>
		</div>		
		
	</body>
</html>