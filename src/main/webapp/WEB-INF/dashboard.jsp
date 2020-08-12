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
		<h1>Dashboard</h1>
		<table class="table table-dark">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Description</th>
					<th>Language</th>
					<th>Pages</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ allBooks}" var="book">
					<tr>
						<td>
							<c:out value="${book.id } " />
						</td>
						<td>
							<c:out value="${book.title } " />
						</td>
						<td>
							<c:out value="${book.description } " />
						</td>
						<td>
							<c:out value="${book.language } " />
						</td>
						<td>
							<c:out value="${book.numOfPages } " />
						</td>
						<td>
							<a href="/books/${book.id}">Show</a>
							<a href="/books/${book.id}/edit">Edit</a>
							<a href="/books/${book.id}/delete">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>