<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>AnaliseCPBR8</title>
<link href="style.css" rel="stylesheet">
</head>
<body>
	<div>
		
		<div class="navbar">
		  <h2 class="textnavbar">Análise Tweets CPBR8</h2>
		</div>
		<div class="navbarsec">
			<a href="index.jsp"> 
				<input type="button" value="Voltar para a página inicial" class="btnmenu"/> 
			</a>
		</div>
		<form action="ServletColetaTweets" method="post">
			<div class="labels">
                <label for="descricao" class="labels"> Descrição da busca:</label>
            </div>
			<div class="component">
                <textarea rows="7" cols="50" name="descricao"></textarea>
            </div>
            <div class="labels">
                <label for="busca" class="labels"> Buscar por:</label>
            </div>
            <div class="component">
                <textarea rows="6" cols="50" name="busca"></textarea>
            </div>
            <div class="labels">
                <label for="tempo_periodo" class="labels"> Periodo de tempo para buscas: </label>
            </div>
            <div class="component">
                <select name="tempo_periodo" id="tempo_periodo"> 
				    <option value="minuto"> Minuto </option>
				    <option value="dia"> Dia </option>
				    <option value="hora"> Hora </option>
                </select>
			<input type="text" name="tempo_hora" size="8px"/>
            </div>
            <div class="labels">
                <label for="quantidade" class="labels"> Quantidade de tweets por busca: </label>
            </div>
            <div class="component">
                <input type="text" name="quantidade"/> <br>
            </div>
            <div class="labels">
                <label for="num_buscas" class="labels"> Requisições da busca: </label>
            </div>
            <div class="component">
                <input type="text" name="num_buscas" id="num_buscas"/>
            </div>
            
            <div class="labels">
                <label for="num_buscas" class="labels"> Tempo: </label>
            </div>
            <div class="component">
                <input type="time" name="tempo_busca" id="num_buscas"/>
            </div>
            
            <div class="labels">
                <label for="num_buscas" class="labels"> Data: </label>
            </div>
            <div class="component">
                <input type="date" name="data_busca" id="num_buscas"/>
            </div>
            
            <div class="component">
                <input type="submit" value="Procurar" class="btn"/>
            </div>
		</form>
	</div>
</body>
</html>