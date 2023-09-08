<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
	Enter your username and password:
	<form action="login" method="post">
		<pre>${errorMessage}</pre>
		Name: <input type = "text" name = "name"> <br>
		Password: <input type = "password" name = "password"> <br>
		<button type = "submit">Login</button> 
	</form>
</div>

<%@ include file="common/footer.jspf" %>