package ss1125;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CreateCookieServlet1")
public class CreateCookieServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决向网页输出消息(响应)中文乱码
        response.setContentType("text/html; charset=UTF-8");
        //1.创建Cookie对象
        Cookie cookie = new Cookie("key1", "value1");
        //2.通知客户端保存Cookie
        response.addCookie(cookie);
        response.getWriter().write("Cookie创建成功！"+cookie.getName()+" "+cookie.getValue());
    }
}
