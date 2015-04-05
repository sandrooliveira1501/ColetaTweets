<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, br.ufc.cpbr8.model.Busca, br.ufc.cpbr8.dao.*, br.ufc.cpbr8.dao.impl.*  "%>
	<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="index.jsp"> Index </a> <br>
	<a href="nova-busca.jsp"> Iniciar nova busca </a> <br>
	
	
	<%
		List<Busca> buscas = (List<Busca>)request.getAttribute("buscas");
	%>

	<table>
		<tr>
			<th>Descrição da busca</th>
			<th>Data de criação</th>
			<th>Status</th>
		</tr>

		<%
			for(Busca busca : buscas){
		%>

		<tr>
			<td> <%= busca.getDescricao() %> </td>
			<td> <%= busca.getDataCriacao() %> </td>
			<td> <%= busca.isStatus() %> </td>
		</tr>

		<%
			}
		%>

	</table>

</body>
</html>