<html>
	<head>
		<title> Login Page </title>
	</head>
	<body>
		Enter username and password
		<form action="login" method="post">
			<pre>${errorMessage}</pre>
			Name: <input type = "text" name = "name"> <br>
			Password: <input type = "password" name = "password"> <br>
			<button type = "submit">Login</button> 
			<!--<input type = "submit"> -->
		</form>
	</body>
</html>