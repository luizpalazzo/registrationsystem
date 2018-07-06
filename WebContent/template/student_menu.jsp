<style>

input[type="submit"] {
    background-color: #333;
    border: none;
}

ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li {
    float: left;
}

li a, input {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover, input:hover {
    background-color: #111;
}

</style>
<form method = "post" action = "${pageContext.servletContext.contextPath}/RedirectController">
<ul>
  <li><a href="${pageContext.servletContext.contextPath}/index.jsp">Home</a></li>
  <li><input type = "submit" name = "action" value = "Disciplinas" /></li>
  <li><a href="${pageContext.servletContext.contextPath}/restricted/change_password.jsp">Trocar senha</a></li>
  <li><a href="${pageContext.servletContext.contextPath}/restricted/student/logoff.jsp">Logoff</a></li>
</ul>
</form>