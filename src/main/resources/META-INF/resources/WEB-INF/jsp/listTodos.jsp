<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
	<h1>Welcome ${name}! </h1>
	<hr>
	<h2>Your ToDos </h2>
	<table class="table">
		<thead>
			<tr>
				<th>Description</th>
				<th>Target Date</th>
				<th>IsDone?</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="todo" items="${todos}">
				<tr>
					<td>${todo.description}</td>
					<td>${todo.targetDate}</td>
					<td>${todo.done}</td>
					<td><a href="update-todo?id=${todo.id}" class="btn btn-warning">Update</a></td>
					<td><a href="delete-todo?id=${todo.id}" class="btn btn-danger">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="add-todo" class="btn btn-success">Add ToDo</a>
</div>

<%@ include file="common/footer.jspf" %>