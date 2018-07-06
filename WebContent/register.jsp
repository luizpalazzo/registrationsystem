<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<title>Cadastro de aluno</title>
</head>
<body>
<h2>Cadastro de aluno</h2>
	<form method = "post" onsubmit = "return validaCPF();" action = "${pageContext.servletContext.contextPath}/ForwardController">
		<label for = "cpf">CPF: </label>
		<input type = "text" name = "cpf" required = "required" id = "cpf" /><br />
		<label for = "nome">Nome: </label>
		<input type = "text" name = "nome" required = "required"/> <br />
		<label for = "data_nascimento">Data de nascimento: </label>
		<input type = "date" name = "data_nascimento" required = "required" /> <br />
		<label for = "email">Email: </label>
		<input type = "email" name = "email" required = "required"/> <br />
		<label for = "senha">Senha: </label>
		<input type = "password" name = "senha" required = "required"/> <br />
		<label for = "foto">Foto: </label>
		<input type = "text" name = "foto" required = "required" /> <br />
		<input type = "submit" value = "Cadastrar" name = "action" />
	</form>
	<script src = "${pageContext.servletContext.contextPath}/javascript/valida_cpf.js"></script>
</body>
</html>