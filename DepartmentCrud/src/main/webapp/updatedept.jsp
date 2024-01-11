<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="updatedept" method="post">
    Department Id : <input type="text" name="deptid" id="deptid" value="${dept.id}" readonly><br>
    Department Name: <input type="text" name="deptname" id="deptname" value="${dept.name}"><br>
    Department Location: <input type="text" name="location" id="location" value="${dept.location}"><br>
<button type="submit" name="btn" id="btn">Update Department</button>
 </form>
</body>
</html>