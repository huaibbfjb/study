package s1125;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;


//显示曾经浏览过的商品
@WebServlet("/GoodsServlet")
public class GoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决向网页输出消息(响应)中文乱码
        resp.setContentType("text/html; charset=UTF-8");
        String goodsName = req.getParameter("name");
        Cookie cookie = CookieUtils.findCookie("name2", req.getCookies());

        if (cookie == null) {//第一次进
            //创建新cookie
            cookie = new Cookie("name2", goodsName);
            cookie.setMaxAge(60 * 60);
            resp.addCookie(cookie);
            resp.sendRedirect("/s1125/goodsList.jsp");
            System.out.println(goodsName);
            return;
        }
        String goods = cookie.getValue();
        if (goods != null) {
            String[] arr = goods.split("&");
            Set<String> goodsSet = new LinkedHashSet(Arrays.asList(arr));
            goodsSet.add(goodsName);
            goods = goodsSet.toString();//[a,b]
            goods = goods.substring(1, goods.length() - 1);//去除中括号
            goods = goods.replaceAll(", ", "&");
            System.out.println(goods);
            cookie = new Cookie("name2", goods);
            cookie.setMaxAge(60 * 60);
            resp.addCookie(cookie);
            resp.sendRedirect("/s1125/goodsList.jsp");
            return;
        }
    }

}
