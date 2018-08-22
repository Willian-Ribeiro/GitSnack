<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Loja</title>
</head>


<body>

	<h2>Cadastro de Loja</h2>
	<form action ="/salvarStore" method="post">
		Digite o ID do vendedor: <br>
		<input type ="text" name="sellerID" value="nome" size="25" />
		<br>
		Preco do produto: <br>
		<input type ="text" name="productPrice" value="12.3" size="25" />
		<br>
		Quantidade do produto: <br>
		<input type ="text" name="productQty" value="10" size="25" />
		<br>
		ID do produto: <br>
		<input type ="text" name="productID" value="11" size="25" />
		<br>
		<input type ="submit" value="Submeter" />
	</form>
</body>
</html>