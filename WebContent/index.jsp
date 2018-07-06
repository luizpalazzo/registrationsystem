<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<title>Login</title>
</head>
<body>
	<form method = "post" action = "${pageContext.servletContext.contextPath}/RedirectController">
		<label for = "email">Email: </label>
		<input type = "email" name = "email" />
		<br />
		<label for = "senha">Senha: </label>
		<input type = "password" name = "senha" /> <br />
		<select name = "action">
			<option value = "LoginAluno">Aluno</option>
			<option value = "LoginAdministrador">Administrador</option>
		</select>
		<br />
		<input type = "submit" value = "Login" />
		<br /><br />
		<a href = "${pageContext.servletContext.contextPath}/register.jsp">Não é cadastrado? Clique aqui para se cadastrar</a>
	</form>
</body>
</html>