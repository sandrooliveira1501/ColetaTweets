<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>AnaliseCPBR8</title>
<link href="style.css" rel="stylesheet">
<link href="css/bootstrap.css" rel="stylesheet">
</head>
<body>
	<div>

		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">Coleta Tweets</a>
				</div>
			</div>
		</nav>

		<ol class="breadcrumb">
			<li><a href="index.jsp">Home</a></li>
			<li class="active">Iniciar Nova Busca</li>
		</ol>

		<form class="form-horizontal" action="ServletColetaTweets"
			method="post">
			<div class="form-group" style="width:100%">
				<label for="descricao" class="col-sm-2 control-label"> Descrição da busca:</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" name="descricao" id="descricao" placeholder="Descrição da busca"/>
				</div>
			</div>
			<div class="form-group" style="width:100%">
				<label for="busca" class="col-sm-2 control-label"> Buscar por:</label>
				<div class="col-sm-3">
					<input type="text" name="busca" class="form-control" id="busca" placeholder="Buscar por"/>
				</div>
			</div>

			<div class="form-group" style="width:100%">
				<label for="tempo_periodo" class="col-sm-2 control-label"> Periodo de tempo
					para buscas: </label>
				<div class="col-sm-2">
					<select name="tempo_periodo" id="tempo_periodo" class="form-control">
						<option value="minuto">Minuto</option>
						<option value="dia">Dia</option>
						<option value="hora">Hora</option>
					</select> 
				</div>
				<div class="col-sm-1">	
					<input type="text" class="form-control" name="tempo_hora" id="tempo_hora" placeholder="Tempo"/>
				</div>
			</div>

			<div class="form-group" style="width:100%">
				<label for="quantidade" class="col-sm-2 control-label"> Qtd. de tweets
					por busca: </label>
				<div class="col-sm-2">
					<input type="text" name="quantidade" id="quantidade" class="form-control" placeholder="Qtd. tweets"/>
				</div>
			</div>

			<div class="form-group" style="width:100%">
				<label for="num_buscas" class="col-sm-2 control-label"> Requisições da
					busca: </label>
				<div class="col-sm-2">
					<input type="text" class="form-control" name="num_buscas" id="num_buscas" placeholder="Requisições"/>
				</div>
			</div>

			<div class="form-group" style="width:100%">
				<div class="col-sm-offset-2 col-sm-2">
					<input type="submit" value="Procurar" class="btn btn-primary" />
				</div>
			</div>

		</form>
	</div>
</body>
</html>