<%@ page import="s1126.demo1.User" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2020/11/26
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        out.print("用户未登录");
    } else {
        out.print("用户名：" + user.getUsername());
%>
<a href="/LogoutServlet">注销</a>
<%

    }

%>
</body>
</html>
