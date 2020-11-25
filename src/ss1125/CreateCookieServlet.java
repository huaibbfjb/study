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
 * 日期: 9:28 2020/11/25
 * 描述：
 */
@WebServlet("/CreateCookieServlet")
public class CreateCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //解决向网页输出消息(响应)中文乱码
        resp.setContentType("text/html; charset=UTF-8");
        //1.创建cookie对象
        Cookie cookie=new Cookie("key1","value1");
        //2.通知客户端保存cookie
        resp.addCookie(cookie);
        resp.getWriter().write("cookie创建成功！"+cookie.getName()+" "+cookie.getValue());
    }
}
