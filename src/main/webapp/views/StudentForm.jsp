<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	</head>
	<body>
	<h1>Enter the details of student</h1>
	<form action="register" method="post">
	<table>
		<tr>
		<td>Name</td><td><input type="text" value="${student.studentName}" name ="studentName"/></td>
		</tr>
		<tr>
		<td>Department</td><td><input type="text" value="${student.department}"name ="department"/></td>
		</tr>
		<tr>
		<td>Country</td><td><input type="text" value="${student.country}"name ="country"/></td>
		</tr>
		<tr>
		<td colspan="2"><input type="hidden" value="${student.studentId}" name="id" /><input type="submit"/></td>
		</tr>
	</table>
	</form>
	</body>
</html>