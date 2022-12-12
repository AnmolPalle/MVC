<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
		<thead>
			<tr>
				<td>User Id</td>
				<td>User Name</td>
				<td>User UName</td>
				<td>User Password</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="user">
			<tr>
				<td>${user.uid }</td>
				<td>${user.name }</td>
				<td>${user.uname }</td>
				<td>${user.password }</td>
				</tr>
			</c:forEach>

		</tbody>

	</table>

</body>
</html>