<%--
  Created by IntelliJ IDEA.
  User: Localhost
  Date: 2022-03-21
  Time: 오전 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MVC-JSP NewForm</title>
</head>
<body>
    <!-- 상대경로 사용, 현재 URL이 속한 계층의 경로를 사용하여 호출한다. -->
    <form action="save" method="post">
        <p>name : <input type="text" name="username" /></p>
        <p>age : <input type="number" name="age" /></p>
        <button type="submit" name="save">save</button>
    </form>
    <p><a href="./index.html">main page</a></p>
</body>
</html>
