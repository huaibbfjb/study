<%--<jsp:useBean id="list" scope="request" type=""/>--%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: WuLiangHang
  Date: 2020/11/24
  Time: 9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    request.setAttribute("list", list);
%>

<%--${ empty 对象 } 返回结果为Boolean值,判断以下条件：
只要满足下面三个条件都返回true
1.对象是否为null
2.字符串是否为””
3.集合长度是否为0--%>
list是否为空:
${empty list}
<br>
""是否为空:
${empty ""}
</body>
</html>
