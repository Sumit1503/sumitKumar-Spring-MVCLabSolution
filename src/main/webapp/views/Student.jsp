<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Registered Students</title>
	</head>
	<body>
		<h1>Registered Students</h1>
		<a href="http://localhost:8080/CollegeFestManagement">Home</a>
		<table border="1">
			<thead>
			<tr><th>StudentId</th><th>Student Name</th><th>Department</th><th>Country</th></tr>
			</thead>
			<tbody align="center">
				<c:forEach items="${studentList}" var ="student">
					<tr>
					<td>${student.studentId}</td>
					<td>${student.studentName}</td>
					<td>${student.department}</td>
					<td>${student.country}</td>
					<td><a href="update?studentId=${student.studentId}">Update</a></td>
					<td><a href="delete?studentId=${student.studentId}">Delete</a></td>			
					</tr>			
				</c:forEach>
			</tbody>
		</table>
		
	</body>
</html>