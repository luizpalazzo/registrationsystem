<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<title>Trocar senha: </title>
</head>
	<body>
		<form method = "post" action = "${pageContext.servletContext.contextPath}/ForwardController" onsubmit = "return validarSenha();">
		<label for = "senha1">Digite a nova senha: </label>
		<input type = "password" name = "senha1" id = "senha1" /><br />
		<label for = "senha2">Confirme a senha: </label>
		<input type = "password" name = "senha2" id = "senha2"/> <br />
		<input type = "submit" value = "Alterar senha" name = "action" />
		</form>
		<script src = "${pageContext.servletContext.contextPath}/javascript/password.js"></script>
	</body>
</html>