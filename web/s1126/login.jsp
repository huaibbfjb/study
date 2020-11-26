<%--
  Created by IntelliJ IDEA.
  User: Hasee
  Date: 2020/11/26
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Session登录验证</title>
</head>
<body>
<h3>Session登录验证</h3>
<%

%>
<form action="/TestLogin" METHOD="get">
    用户名:<input type="text" name="username"><br>
    密码:<input type="password" name="password"><br>
    验证码:<img src="/kaptcha.jpg"><br>
    <input type="text" name="code"><br>
    <button type="submit">登录</button>
</form>
</body>
</html>
