<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Usuarios</title>
</head>


<body>

	<h2>Cadastro de Usuarios</h2>
	<form action ="/salvar" method="post">
		Digite sua password: <br>
		<input type ="text" name="password" value="pwd" size="25" />
		<br>
		Que tipo de conta voce gostaria de ter: <br>
		<input type ="radio" name="tipo" value="False" checked />SnackUser <br>
		<input type ="radio" name="tipo" value="True"/>Seller
		<br>
		<input type ="submit" value="Submeter" />
	</form>
</body>
</html>