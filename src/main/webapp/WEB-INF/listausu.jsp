<%@page import="com.fabricadeprogramador.persistencia.entidade.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">

	function confirma(){
		
		return window.confirm("Tem certeza que deseja excluir?")
	}

</script>
<title>Lista Usuario</title>
</head>
<body>
	<%
		List<Usuario> lista = (List)request.getAttribute("lista");
	%>
	<form method="post" action="usucontroller" onclick="return confirma()">
	
	<input type="hidden" name="acao" value="exc">
	
	<table style="border:2px solid red;">
	<thead>
		<tr style="background-color: yellow;">
			<td>ID</td>
			<td>Nome</td>
			<td>Login</td>
			<td>Senha</td>
			<td>Excluir</td>
		</tr>
	</thead>
	
	<tbody style="background-color: rgba(0,0,0,.3)">
	<%for(Usuario usu: lista){ %>
		<tr>
			<td><%= usu.getId() %></td>
			<td><%= usu.getNome() %></td>
			<td><%= usu.getLogin() %></td>
			<td><%= usu.getSenha() %></td>
			<td><input type="checkbox" name="id" value="<%= usu.getId()%>"></td>
			
		</tr>
		<%} %>
	</tbody>
	</table>
	<input type="submit" value="Excluir">
	</form>
</body>
</html>