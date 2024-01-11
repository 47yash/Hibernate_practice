<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
	<tr>
	<th>Department Id</th>
	<th>Department Name</th>
	<th>Department Location</th>
	<th>Action</th>
	</tr>
	<c:forEach var="dept" items="${list}">
	<tr>
	<td>${dept.id}</td>
	<td>${dept.name}</td>
	<td>${dept.location}</td>
	<td><a href="deletedept?did=${dept.id}">Delete</a> / <a href="editdept?did=${dept.id}"> Edit</a></td>
	</tr>
	</c:forEach>
	</table>
	<a href="newdept.jsp">Add Department</a>
</body>
</html>