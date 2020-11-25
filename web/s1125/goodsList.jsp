<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="ss1125.CookieUtils" %><%--
  Created by IntelliJ IDEA.
  User: WuLiangHang
  Date: 2020/11/25
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品列表</title>
</head>
<body>
<div>
    <a href="/GoodsServlet?name=toy"><img src="./img/toy.jpg"/> </a><br/>
    <font>玩具车</font>
</div>
<div>
    <a href="/GoodsServlet?name=car"><img src="./img/car.jpg"/> </a><br/>
    <font>兰博基尼</font>
</div>
<div>
    <a href="/GoodsServlet?name=grape"><img src="./img/grape.jpg"/> </a><br/>
    <font>葡萄</font>
</div>
<div>
    <a href="/GoodsServlet?name=sausage"><img src="./img/sausage.jpg"/> </a><br/>
    <font>香肠</font>
</div>
<div>
    <a href="/GoodsServlet?name=wash"><img src="./img/wash.jpg"/> </a><br/>
    <font>香水</font>
</div>
<h3>
    您浏览过的商品:
</h3>
<table>
    <%
        Cookie cookie2 = CookieUtils.findCookie("name2", request.getCookies());//取出key为某个值的cookie
        if(cookie2!=null){
            String [] strings=cookie2.getValue().split("&");
            for (int i = 0; i < strings.length; i++) {
    %>
        <tr><td><%=strings[i]%></td></tr>
    <%
            }
        }
    %>
</table>

</body>
</html>
