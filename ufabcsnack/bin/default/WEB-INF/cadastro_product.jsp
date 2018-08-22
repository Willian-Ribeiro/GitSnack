<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Produtos</title>
</head>


<body>

	<h2>Cadastro de Produto</h2>
	<form action ="/salvarProduct" method="post">
		Digite o nome do produto: <br>
		<input type ="text" name="productName" value="nome" size="25" />
		<br>
		Digite a descricao do produto: <br>
		<input type ="text" name="productDesc" value="nome" size="25" />
		<br>
		<input type ="submit" value="Submeter" />
	</form>
</body>
</html>