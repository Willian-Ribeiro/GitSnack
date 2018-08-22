<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de FullProduct</title>
</head>


<body>

	<h2>Cadastro de FullProduct</h2>
	<form action ="/salvarFullProduct" method="post">
		Quantidade do produto: <br>
		<input type ="text" name="productQty" value="1" size="25" />
		<br>
		Preco do produto: <br>
		<input type ="text" name="productPrice" value="10.2" size="25" />
		<br>
		<input type ="submit" value="Submeter" />
	</form>
</body>
</html>