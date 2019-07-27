<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Record</title>
</head>
<body>
<form action="/Servdel" method="POST">
<p>Enter the firstname of record which you wish to delete</p>
<br><br>
<input type="text" name="delname">
<br><br>
<input type="submit" name="submit">
</form>
</body>
</html>