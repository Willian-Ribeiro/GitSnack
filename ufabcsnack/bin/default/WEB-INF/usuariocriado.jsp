<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usuario Criado</title>
</head>
<body>

	<h1>Usuario Criado</h1>

	<table border="1">
		<thead>
			<tr>
				<th><b>ID</b></th>
				<th><b>Password</b></th>
				<th><b>Tipo</b></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><c:out value="${user.ID}"></c:out></td>
				<td><c:out value="${user.password}"></c:out></td>
				<td><c:choose>
				
						<c:when test = "${user.tipo == 0}">
							SnackUser
						</c:when>
						
						<c:when test = "${user.tipo == 1}">
							Seller
						</c:when>
						
						<c:otherwise>
							Outro usuario
						</c:otherwise>
						
					</c:choose>
				</a>
				</td>
			</tr>
		</tbody>
	</table>
	<form action="/index" method="post">
		<input type="submit" value="Inicio" />
	</form>

</body>
</html>