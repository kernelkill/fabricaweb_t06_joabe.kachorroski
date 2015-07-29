<!DOCTYPE html>
<%@page import="com.fabricadeprogramador.persistencia.entidade.Usuario"%>
<html>
<head>
<meta charset="UTF-8">
<title>Projeto Novo</title>
</head>
<body>
<%@ include file="menu.jsp" %>

	<% Usuario usu = (Usuario)session.getAttribute("usuario");%>
	<h4 style="text-align: center;">Usuario: <%= usu.getLogin() %></h4>

	<br>
	<br>
	<br>
	
	<h2 style="text-align: center; font-family: Arial; font-size: 22px;"> Sistema WEB - HighTech</h2>
</body>
</html>