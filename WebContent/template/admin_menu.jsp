<style>
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

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover {
    background-color: #111;
}
</style>

<ul>
  <li><a href="${pageContext.servletContext.contextPath}/index.jsp">Home</a></li>
  <li><a href="${pageContext.servletContext.contextPath}/restricted/admin/approve.jsp">Liberar acessos</a></li>
  <li><a href="${pageContext.servletContext.contextPath}/restricted/admin/logoff.jsp">Logoff</a></li>
</ul>