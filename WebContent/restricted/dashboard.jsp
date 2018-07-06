<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<title>Dashboard</title>
</head>
	<body>
		<c:if test = "${role == 'administrador'}"> 
			<%@ include file="/template/admin_menu.jsp" %> 
		</c:if>
		<c:if test = "${role == 'aluno'}"> 
			<%@ include file="/template/student_menu.jsp" %> 
		</c:if>
		<p>Nome: ${usuario.nome}</p>
		<p>Email: ${usuario.email}</p>
		<p>CPF: ${usuario.cpf}</p>
	</body>
</html>