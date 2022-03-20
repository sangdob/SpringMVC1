<%--
  Created by IntelliJ IDEA.
  User: Localhost
  Date: 2022-03-20
  Time: 오후 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/jsp/members/save.jsp" method="post">
        <p>username : <input type="text" name="username" id="username"></p>
        <p>age : <input type="text" name="age" id="age"></p>
        <button type="submit">전송</button>
        <button type="reset">초기화</button>
    </form>
</body>
</html>
