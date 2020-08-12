<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" media="screen" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
	<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>Show Page</h1>
		<h2><c:out value="${book.id}" /></h2>
		<h2><c:out value="${book.title}" /></h2>
		<h2><c:out value="${book.description}" /></h2>
		<h2><c:out value="${book.language}" /></h2>
		<h2><c:out value="${book.numOfPages}" /></h2>
	</div>
</body>
</html>