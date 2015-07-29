<%@page import="com.fabricadeprogramador.persistencia.entidade.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">

</script>
<title>Cadastrando Usuario</title>
</head>

<body>

	<%
	Usuario usu = (Usuario)request.getAttribute("usuario");
	%>
	<h1 style="text-align: center;">Cadastrar/Alterar Usuario</h1>
	
	<form method="post" action="usucontroller" style="margin: auto;width: 500px">
			<fieldset style="border: 2px solid red;">
				<input type="hidden" name="acao" value="cad">
				
				<label for="idId"> ID:</label> 
				<input type="text" id="idId" name="id" value="<%= usu.getId() %>" >
				<br/>
				
				<label for="idNome">Nome: </label>
				<input type="text" id="idNome" name="nome" value="<%= usu.getNome()%>" required="">
				<br/>
				
				<label for="idLogin">Login: </label>
				<input type="text" id="idLogin" name="login" value="<%= usu.getLogin()%>" required="">
				<br/>
				
				<label for="idSenha"> Senha: </label>
				<input type="password"	id="idSenha" name="senha" value="<%= usu.getSenha()%>" required="">
				<br/>
				
				<input type="submit" value="Salvar">
				<input type="button" value="Cancelar" onclick="location.href='usucontroller?acao=list'"> 
			</fieldset>
		</form>				
	</body>
</html>