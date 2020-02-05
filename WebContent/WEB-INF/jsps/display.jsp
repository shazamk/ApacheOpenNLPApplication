<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OpenNLP Demo</title>
<link href="<c:url value="/css/style.css" />" rel="stylesheet" type="text/css"></head>
</head>
<body>
	<div class="header">
  		<h1>OpenNLP Demo</h1>
	</div>
<div class="center">
	<label>Sentence:</label>
		<br> <span>${sentence.text}</span></li><br><br><br>
	<label>Entities Found:</label><br>
		
		<ul>
			<c:forEach var="tag" items="${sentence.entities}">
				<li>${tag}</li> <br>
			</c:forEach>
			<br>
		</ul>
	 	<c:url value="/" var="home" /><a href="${home}">Back</a>
</div>
</body>
</html>