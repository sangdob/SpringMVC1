<%@ page import="SpringMVC.Servlet.domain.member.Member" %><%--
  Created by IntelliJ IDEA.
  User: Localhost
  Date: 2022-03-21
  Time: 오전 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>-- Success --</p>
    <%-- jstl이 없는 예전 방식으로 만들어진 mapping --%>
    <%--<ul>
        <li>id = <%=((Member)request.getAttribute("member")).getId()%></li>
        <li>name = <%=((Member)request.getAttribute("member")).getName()%></li>
        <li>age = <%=((Member)request.getAttribute("member")).getAge()%></li>
    </ul>--%>

    <%-- JSTL(Java Servlet Type language)을 사용한 문법--%>
    <ul>
        <li>id = ${member.id}</li>
        <li>name = ${member.name}</li>
        <li>age = ${member.age}</li>
    </ul>
    <a href="/index.html">Main page</a>
</body>
</html>
