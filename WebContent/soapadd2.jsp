<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enter the details</title>
</head>
<body>
<form action="/Addserv" method="POST">
<p>Enter the model_id</p>
<br><br>
<input value="text" name="model_id">
<br><br>
<p>Enter the Make</p>
<br><br>
<input value="text" name="make">
<br><br>
<p>Enter the Model</p>
<br><br>
<input value="text" name="model">
<br><br>
<p>Enter the Class</p>
<br><br>
<input value="text" name="class">
<br><br>
<input type="submit" name="submit">
</form>
</body>
</html>