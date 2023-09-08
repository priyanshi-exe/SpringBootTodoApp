<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
		<link href="webjars/bootstrap/5.3.1/css/bootstrap.min.css" rel="stylesheet">
		<link href="webjars/bootstrap-datepicker/1.10.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet">
		<title> Add ToDo Page </title>
	</head>
	<body>
		<div class="container">
			<h1>Enter Todo Details</h1>
			<form:form method="post" modelAttribute="todo" action="/add-todo">
			
				<fieldset class="mb-3">
					<form:label path="description">Description</form:label>
					<form:input type="text" path="description" required="required"/>
					<form:errors path="description" cssClass="text-warning"/>
				</fieldset>
				
				<fieldset class="mb-3">
					<form:label path="targetDate">Target Date</form:label>
					<form:input type="text" path="targetDate" required="required"/>
					<form:errors path="targetDate" cssClass="text-warning"/>
				</fieldset>
				
				<form:input type="hidden" path="id"/>
				
				<fieldset>
				    <legend>Done?</legend>
				    <div class="form-check">
				        <input class="form-check-input" type="radio" id="doneYes" name="done" value="yes" required="required">
				        <label class="form-check-label" for="doneYes">Yes</label>
				    </div>
				    <div class="form-check">
				        <input class="form-check-input" type="radio" id="doneNo" name="done" value="no" required="required">
				        <label class="form-check-label" for="doneNo">No</label>
				    </div>
				</fieldset>
				
				<input type="submit" class="btn btn-success"/>
			</form:form>
		</div>
		<script src="webjars/bootstrap/5.3.1/js/bootstrap.min.js"></script>
		<script src="webjars/jquery/3.7.1/jquery.min.js"></script>
		<script src="webjars/bootstrap-datepicker/1.10.0/js/bootstrap-datepicker.min.js"></script>
		<script type="text/javascript">
			$('#targetDate').datepicker({
			    format: 'yyyy-mm-dd'
			});
		</script>
	</body>
</html>