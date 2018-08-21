package servlet;

import bean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tjl on 2018/8/21 10:14.
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("从请求中获取username,password");
        System.out.println("创建service对象,调用service对象的login方法,做处理");
        System.out.println("判断结果:用户登陆成功,返回当前User对象");
        System.out.println("将此User对象放在session范围中");
        req.getSession().setAttribute("user",new User());
        //跳转到登陆成功之后的首页
        resp.sendRedirect("html/loginSuccess.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
