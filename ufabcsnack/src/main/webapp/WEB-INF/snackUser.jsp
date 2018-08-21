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

	<script type="application/javascript">
		
	function copiaDados(id){
		document.getElementById('id').value = id;
		var linhaTabela = document.getElementById('row_'+id);
		var celulas = linhaTabela.getElementsByTagName("td");
		document.getElementById('password').value = celulas[1].textContent;
		document.getElementById('tipo').value = celulas[2].textContent;
	}
	
	</script>


	<table border="1">
		<thead>
			<tr>
				<th><b>ID</b></th>
				<th><b>Password</b></th>
				<th><b>Tipo</b></th>
				<th><b>Editar</b></th>
				<th><b>Remover</b></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${userList}" var="uL">
				<tr id="row_${uL.ID}">
					<td><c:out value="${uL.ID}"></c:out></td>
					<td><c:out value="${uL.password}"></c:out></td>
					<td><c:out value="${uL.tipo}"></c:out></td>
					<td align="center"><input type="radio" name="alterar"
							value="${uL.ID}" onClick="copiaDados(value)"></td>
					<td><a href="/remove/${uL.ID}"><button type="submit">Remover</button>
					</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
	<form action="/editar" method="post">
		ID: <input type="text" id="id" name="id" readonly style="color: #AAAAAA" /><br>
		Password: <input type="text" id="password" name="password" /><br>
		Tipo: <input type="text"	id="tipo" name="tipo" /><br>
		<input type="submit" name="action" value="Alterar" />
	</form>




	<form action="/cadastro" method="post">
		<input type="submit" value="Cadastrar Novo Usuario" />
	</form>

</body>
</html>