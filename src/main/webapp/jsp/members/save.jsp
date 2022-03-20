<%@ page import="SpringMVC.Servlet.domain.member.MemberRepository" %>
<%@ page import="SpringMVC.Servlet.domain.member.Member" %><%--
  Created by IntelliJ IDEA.
  User: Localhost
  Date: 2022-03-20
  Time: 오후 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    MemberRepository memberRepository = MemberRepository.getInstance();

    System.out.println("JspClass.jsp_service_method");
	String username = request.getParameter("username");
	int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(username, age);
	memberRepository.save(member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>-- Success --</p>
    <ul>
        <li>id = <%=member.getId()%></li>
        <li>name = <%=member.getName()%></li>
        <li>age = <%=member.getAge()%></li>
    </ul>
    <a href="/index.html">Main page</a>
</body>
</html>
