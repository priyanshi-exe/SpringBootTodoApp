<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
		<link href="webjars/bootstrap/5.3.1/css/bootstrap.min.css" rel="stylesheet">
		<title> Add ToDo Page </title>
	</head>
	<body>
		<div class="container">
			<h1>Enter Todo Details</h1>
			<form:form method="post" modelAttribute="todo" action="/add-todo">
				Description: 
				<form:input type="text" path="description" required="required"/><br>
				<form:errors path="description" cssClass="text-warning"/><br>
				
				<form:input type="hidden" path="id"/>
				<form:input type="hidden" path="done"/>
				<input type="submit" class="btn btn-success"/>
			</form:form>
		</div>
		<script src="webjars/bootstrap/5.3.1/js/bootstrap.min.js"></script>
		<script src="webjars/jquery/3.7.1/jquery.min.js"></script>
	</body>
</html>