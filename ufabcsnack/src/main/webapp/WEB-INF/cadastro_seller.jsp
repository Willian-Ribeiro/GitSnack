<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Vendedores</title>
</head>


<body>

	<h2>Cadastro de Vendedor</h2>
	<form action ="/salvarSeller" method="post">
		Digite a descricao do vendedor: <br>
		<input type ="text" name="sellerDesc" value="nome" size="25" />
		<br>
		Digite o nome do vendedor: <br>
		<input type ="text" name="sellerName" value="nome" size="25" />
		<br>
		Digite a posicaoX do vendedor: <br>
		<input type ="text" name="positionX" value="nome" size="25" />
		<br>
		Digite a posicaoY do vendedor: <br>
		<input type ="text" name="positionY" value="nome" size="25" />
		<br>
		Digite o status do vendedor: <br>
		<input type ="text" name="status" value="nome" size="25" />
		<br>
		<input type ="submit" value="Submeter" />
	</form>
</body>
</html>