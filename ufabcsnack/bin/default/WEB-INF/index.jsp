<!DOCTYPE html>
<html lang="en" >
<head>
    <!-- meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <!-- Leaflet's CSS -->
    <link rel="stylesheet" href="https://unpkg.com/leaflet@1.3.3/dist/leaflet.css"
          integrity="sha512-Rksm5RenBEKSKFjgI3a41vrjkw4EVPlJ3+OiI65vTjIdo9brlAacEuKOiQ5OFh7cOI1bkDwLqdLw3Zg0cRJAAQ=="
          crossorigin=""/>
    <link rel="stylesheet"
      href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>

    <script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>

    <!--Leaflet's Javascript-->
    <script src="https://unpkg.com/leaflet@1.3.3/dist/leaflet.js"
            integrity="sha512-tAGcCfR4Sc5ZP5ZoVz0quoZDYX5aCtEm/eu1KhSLj2c9eFrylXZknQYmxUssFaVJKvvc0dJQixhGjG2yXWiV9Q=="
            crossorigin=""></script>
    <link rel="stylesheet" href="css/mapa-configuration.css">
	
	<style type="text/css"> <%@ include file="mapa-configuration.css" %> </style>
	
    <script src="actions.js"></script>

    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>


    <!--<script src="https://raw.github.com/calvinmetcalf/leaflet-ajax/master/dist/leaflet.ajax.min.js"></script>-->

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

<div class="container fill">
    <div class="row fill">
        <div class="col-12 fill">
            <div class="row fill align-items-center">
                <div class="col-sm-8 border rounded pad">
                    <div id="mapid" ></div>
                </div>
                <div class="col-sm-4">
                    <div class="panel panel-success" id="result_panel">
                    <div class="panel-heading"><h3 class="panel-title">Vendedores e
                        Produtos</h3>
                    </div>
                    <div class="panel-body">
                        <ul id="tabela" class="list-group">
                            <li id="biscoito" class="list-group-item" data-seller= "Charli"><strong>Caf� rapidinho</strong>
                                <br>Curto
                                <br>Pingado
                            </li>

                            <li id="nome" class="list-group-item" data-seller= "Paula"><strong>Trufel�cia</strong>
                                <br>Chocolate e doce de leite
                                <br>Morango com maracuj�
                            </li>
                        </ul>
                    </div>
                </div>
                </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="actions.js"></script>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

<form action="/snackUser" method = "post"><input type ="submit" value="SnackUser" /></form>
<form action="/product" method = "post"><input type ="submit" value="Produtos" /></form>
<form action="/fullproduct" method = "post"><input type ="submit" value="FullProduct" /></form>
<form action="/seller" method = "post"><input type ="submit" value="Vendedor" /></form>
<form action="/store" method = "post"><input type ="submit" value="Lojas" /></form>

</body>
</html>
