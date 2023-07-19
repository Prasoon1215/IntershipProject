<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Record</title>
</head>
<body>
<h1>Delete Record</h1>
<%-- Display success message if available --%>
	<c:if test=${not empty message}">
		<div style="color: red;">${message}</div>
	</c:if>
	<form action="delete" method="post">
		<label for="customerOrderId">Customer Order ID:</label> 
		<input type="text" id="customerOrderId" name="customerOrderId"><br>
		
		<input type="submit" value="Delete Invoice">
	</form>
</body>
</html>