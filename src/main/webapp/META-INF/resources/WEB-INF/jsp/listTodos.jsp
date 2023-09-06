<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title> List ToDo's Page </title>
	</head>
	<body>
		<div>
			<h1>Hello ${name}! </h1>
			<h3>Your ToDos are </h3>
			<table>
				<thead>
					<tr>
						<th>id</th>
						<th>Description</th>
						<th>Target Date</th>
						<th>IsDone?</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="todo" items="${todos}">
						<tr>
							<td>${todo.id}</td>
							<td>${todo.description}</td>
							<td>${todo.targetDate}</td>
							<td>${todo.done}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>