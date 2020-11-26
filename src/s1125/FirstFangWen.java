package s1125;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 作者：LiuYunTao
 * 日期: 11:10 2020/11/25
 * 描述：
 */
@WebServlet("/FirstFangWen")
public class FirstFangWen extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");//设置日期格式
        //解决向网页输出消息(响应)中文乱码
        resp.setContentType("text/html; charset=UTF-8");
        Cookie[] cookies = req.getCookies();
        Cookie cookie = CookieUtils.findCookie("key1", cookies);

        if (cookie != null) {
            System.out.println(df.format(new Date()));
            resp.getWriter().write("您上一次访问本站:"+cookie.getValue());
            //创建新cookie
            String time=df.format(new Date());
            cookie=new Cookie("key1",time);
            cookie.setMaxAge(60*60);
            resp.addCookie(cookie);

        }else {
            resp.getWriter().write("恭喜您第一次访问本站！");
            //1.创建cookie对象
            String time=df.format(new Date());
            cookie=new Cookie("key1",time);
            //2.通知客户端保存cookie
            cookie.setMaxAge(60*60);
            resp.addCookie(cookie);
            resp.getWriter().write("cookie创建成功！");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
