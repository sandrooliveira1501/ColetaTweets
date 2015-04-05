<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta charset="utf-8">
<title>AnaliseCPBR8</title>
<link href="style.css" rel="stylesheet">
</head>
<body>

	<div class="navbar">
		<h2 class="textnavbar">Análise Tweets CPBR8</h2>
	</div>

	<div style="margin-top: 70px;">
		<div class="component">
			<a href="ServletColetaTweets?cmd=listar"> <input type="button"
				value="Listar todas as pesquisas" class="btn" />
			</a>
		</div>
		<div class="component">
			<a href="nova-busca.jsp"> <input type="button"
				value="Iniciar nova busca" class="btn" />
			</a>
		</div>
	</div>

</body>
</html>