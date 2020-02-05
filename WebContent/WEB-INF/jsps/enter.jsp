<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OpenNLP Demo</title>
	<link href="<c:url value="/css/style.css" />" rel="stylesheet" type="text/css"></head>
<body>
<div class="header">
  <h1>OpenNLP Demo</h1>
</div>


<c:url value="/process" var="url" />
<div class="center">
	<form:form modelAttribute="sentence" method="post" action="${url}"><br>
		<label>Enter a Sentence to Find its Entities:</label><br><br>
		 <form:textarea path="text" rows="5" cols="40" /><br>
		<input type="submit" value="Process!"/><br>
		<h3>${error}</h3>
	</form:form>
</div>


</body>
</html>