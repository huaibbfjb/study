package ss1125;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 作者：LiuYunTao
 * 日期: 19:39 2020/11/25
 * 描述：
 */
@WebServlet("/DeleteCookie")
public class DeleteCookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie=new Cookie("name2",null);//删除名为name2的cookie
        cookie.setMaxAge(0);//立刻删除
        cookie.setPath("/");//项目所有目录有效
        resp.addCookie(cookie);//重新写入，将覆盖之前的
        resp.sendRedirect("/s1125/goodsList.jsp");
        return;
    }
}
