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
	<form method="post" action="usucontroller">
			<fieldset>
				<input type="hidden" name="acao" value="cad">
				<label for="idId"> ID: <input type="text" id="idId" name="id"> </label><br/>
				<label for="idNome">Nome: <input type="text" id="idNome" name="nome"></label><br/>
				<label for="idLogin">Login: <input type="text" id="idLogin" name="login"></label><br/>
				<label for="idSenha"> Senha: <input type="password"	id="idSenha" name="senha"></label><br/>
				<input type="submit" value="Salvar">
			</fieldset>
		</form>				
	</body>
</html>