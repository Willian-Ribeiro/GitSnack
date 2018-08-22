<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en" >
<head>
    <!-- meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <link rel="stylesheet"
      href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>

    <script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>


    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>

	<style type="text/css"> <%@ include file="mapa-configuration.css" %> </style>
	
    <title>UFABC snack</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light color">
        <a class="navbar-brand" id="logo-style" href="#">UFABC snack</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Features</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Pricing</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#">Disabled</a>
                </li>
            </ul>
        </div>
    </nav>
    
	<script type="application/javascript">
		
	function copiaDados(id){
		document.getElementById('id').value = id;
		var linhaTabela = document.getElementById('row_'+id);
		var celulas = linhaTabela.getElementsByTagName("td");
		document.getElementById('productName').value = celulas[1].textContent;
		document.getElementById('productDesc').value = celulas[2].textContent;
	}
	
	</script>


	<table border="1">
		<thead>
			<tr>
				<th><b>ID</b></th>
				<th><b>Nome do Produto</b></th>
				<th><b>Descricao do Produto</b></th>
				<th><b>Editar</b></th>
				<th><b>Remover</b></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${productList}" var="pL">
				<tr id="row_${pL.ID}">
					<td><c:out value="${pL.ID}"></c:out></td>
					<td><c:out value="${pL.productName}"></c:out></td>
					<td><c:out value="${pL.productDesc}"></c:out></td>
					<td align="center"><input type="radio" name="alterar"
							value="${pL.ID}" onClick="copiaDados(value)"></td>
					<td><a href="/remove_product/${pL.ID}"><button type="submit">Remover</button>
					</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
	<form action="/editarProduct" method="post">
		ID: <input type="text" id="id" name="id" readonly style="color: #AAAAAA" /><br>
		Nome do Produto: <input type="text" id="productName" name="productName" /><br>
		Descricao do Produto: <input type="text"	id="productDesc" name="productDesc" /><br>
		<input type="submit" name="action" value="Alterar" />
	</form>




	<form action="/cadastro_product" method="post">
		<input type="submit" value="Cadastrar Novo Produto" />
	</form>
	

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>