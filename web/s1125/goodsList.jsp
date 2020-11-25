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
    <style>
        img {
            width: 300px;
            height: 200px;
        }

        .div1 {
            margin-left: 40px;
            float: left;
        }

        .div2 {
            width: 100%;
            height: 350px;

        }

        span {
            position: relative;
            top: 15px;
        }
    </style>

</head>
<body>
<div class="div2" align="center">
    <h3>商品列表如下:</h3>
    <div class="div1">
        <a href="/GoodsServlet?name=toy"><img src="./img/toy.jpg"/> </a><br/>
        <span>玩具车</span>
    </div>
    <div class="div1">
        <a href="/GoodsServlet?name=car"><img src="./img/car.jpg"/> </a><br/>
        <span>兰博基尼</span>
    </div>
    <div class="div1">
        <a href="/GoodsServlet?name=grape"><img src="./img/grape.jpg"/> </a><br/>
        <span>葡萄</span>
    </div>
    <div class="div1">
        <a href="/GoodsServlet?name=sausage"><img src="./img/sausage.jpg"/> </a><br/>
        <span>香肠</span>
    </div>
    <div class="div1">
        <a href="/GoodsServlet?name=wash"><img src="./img/wash.jpg"/> </a><br/>
        <span>香水</span>
    </div>
</div>
<div class="div2" align="center">
    <%
        Cookie cookie2 = CookieUtils.findCookie("name2", request.getCookies());//取出key为某个值的cookie
        if (cookie2 != null) {
    %>
    <h3>您浏览过的商品如下:</h3>
    <%
        String[] strings = cookie2.getValue().split("&");
        for (int i = 0; i < strings.length; i++) {
    %>
    <div class="div1">
        <a href="/GoodsServlet?name=<%=strings[i]%>" title="点击跳转">
            <img src="./img/<%=strings[i]%>.jpg"/>
        </a><br>
        <span>
            <%
                switch (strings[i]) {
                    case "toy":
                        strings[i] = new String("玩具车");
                        break;
                    case "car":
                        strings[i] = new String("兰博基尼");
                        break;
                    case "grape":
                        strings[i] = new String("葡萄");
                        break;
                    case "sausage":
                        strings[i] = new String("香肠");
                        break;
                    case "wash":
                        strings[i] = new String("香水");
                        break;
                    default:
                        break;
                }
            %>
            <%=strings[i]%>
        </span>
    </div>
    <%
            }
        }
    %>

</div>
<div class="div2" align="center">
    <%
        cookie2 = CookieUtils.findCookie("name2", request.getCookies());//取出key为某个值的cookie
        if (cookie2 != null) {
    %>
    <h3><a href="/DeleteCookie" style="text-decoration: none">删除浏览记录</a>:</h3>
    <%
        }
    %>

</div>

</body>
</html>
