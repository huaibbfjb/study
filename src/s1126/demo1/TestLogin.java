package s1126.demo1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * 作者：LiuYunTao
 * 日期: 10:16 2020/11/26
 * 描述：
 */
@WebServlet("/TestLogin")
public class TestLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        //获取验证码
        String token=(String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        System.out.println("谷歌生成的验证码："+token);

        String username=req.getParameter("username");
        String password =req.getParameter("password");
        String code=req.getParameter("code");
        if(token!=null && token.equalsIgnoreCase(code)){
            if("wnky".equals(username) && "123".equals(password)){
                //登录成功，获取session对象
                User user=new User(username,password);
                // 得到session，如果已有session，得到该session，如果没有session，得到创建的新session
                HttpSession session=req.getSession();
                //System.out.println(session);
                session.setAttribute("user",user);
                resp.sendRedirect("/s1126/index1.jsp");
            }
        }else {
            resp.getWriter().print("验证码输入错误！");
        }

    }
}
