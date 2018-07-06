<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<title>Sucesso</title>
	<style type = "text/css">
	h2{
		background-color: green;
	}
	</style>
</head>
<body>
<h2>${mensagem}</h2>
<a href = "${pageContext.servletContext.contextPath}/index.jsp">Voltar para a página inicial</a>
</body>
</html>