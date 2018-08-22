package servlet;

import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tjl on 2018/8/22 16:21.
 * 跳转servlet
 * 实现思路:
 *  1.获取cookie
 *  2.判断cookie是否为空
 *  3.如果为空,直接跳转到登陆页面(login.html)
 *  4.如果不为空
 *      从Cookie中取出用户名和密码,如果取不出,则跳转到登陆页面(login.html)
 *      如果取出,校验用户名和密码是否正确
 *          如果正确,跳转到成功页面
 *          如果不正确,则跳转到登陆页面
 */
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies == null) {
            resp.sendRedirect("login.html");
            return;
        }
            String username = "";
            String password = "";
            for (Cookie c : cookies) {
                if ("username".equals(c.getName())) {
                    username = c.getValue();
                }
                if ("password".equals(c.getName())) {
                    password = c.getValue();
                }
            }

        if ("".equals(username) || "".equals(password)) {
            resp.sendRedirect("login.html");
            return;
        }
        UserService userService = new UserService();
        Boolean login = userService.login(username, password);
        if (login) {
            req.getRequestDispatcher("success.html").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
