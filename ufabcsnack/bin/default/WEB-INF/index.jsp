<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de SnackUsers</title>
</head>
<body>

	<table border="1">
		<thead>
			<tr>
				<th><b>ID</b></th>
				<th><b>Password</b></th>
				<th><b>Tipo</b></th>
				<th><b>Ação</b></th>
				<th><b>Remover</b></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${userList}" var="uL">
				<tr>
					<td><c:out value="${uL.ID}"></c:out></td>
					<td><c:out value="${uL.password}"></c:out></td>
					<td><c:out value="${uL.tipo}"></c:out></td>
					<td><a href="/edit/${uL.ID}"><button type="submit">Editar</button>
					<td><a href="/remove/${uL.ID}"><button type="submit">Deleta</button>
					</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<form action="/cadastro" method = "post">
		<input type ="submit" value="Cadastrar Novo Usuario" />
	</form>

</body>
</html>