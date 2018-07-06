<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Aprovar acesso</title>
<style type = "text/css">
table{
	border: 1px solid black;
}
</style>
</head>
<body>
<%@ include file="/template/admin_menu.jsp" %>

	<form method = "post" onsubmit = "setSelectedId(this.submited);" action = "${pageContext.servletContext.contextPath}/RedirectController">
	<input type = "hidden" id = "selected_id" name = "selected_id" value = "" />
		<table>
			<tr>
				<th>CPF</th>
				<th>NOME</th>
				<th>EMAIL</th>
				<th>NASCIMENTO</th>
				<th>AÇÃO 1</th>
				<th>AÇÃO 2</th>
			</tr>
			<c:forEach var="student" items="${students}">
				<tr>	
					<td class = "current_id">${student.id}</td>
					<td>${student.cpf}</td>
					<td>${student.nome}</td>
					<td>${student.email}</td>
					<td>${student.dataNascimento}</td>
					<td><input type = "submit" name = "action" onclick="this.form.submited=this;" value = "Aprovar"></td>
					<td><input type = "submit" name = "action" onclick="this.form.submited=this;" value = "Revogar"></td>
				</tr>
			</c:forEach>
		</table>
	</form>
	
	<script src = "${pageContext.servletContext.contextPath}/javascript/jquery-3.3.1.min.js"></script>
	<script src = "${pageContext.servletContext.contextPath}/javascript/admin_approve.js"></script>

</body>
</html>