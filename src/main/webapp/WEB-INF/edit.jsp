<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" media="screen" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
	<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>Edit A Show</h1>
		<form:form action="/books/${bookObj.id}/edit" method="post" modelAttribute="bookObj" >
			<input type="hidden" name="_method" value="put" />
			<p>
				Title:
				<form:input path="title" />
				<form:errors path="title" />
			</p>
			<p>
				Description:
				<form:textarea path="description" />
				<form:errors path="description" />
			</p>	
			<p>
				Language:
				<form:input path="language" />
				<form:errors path="language" />
			</p>	
			<p>
				Num of Pages:
				<form:input type="number" path="numOfPages" />
				<form:errors path="numOfPages" />
			</p>
			<button type="submit">Submit</button>
		</form:form>
	</div>
</body>
</html>