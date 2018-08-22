package servlet;

import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tjl on 2018/8/18 17:48.
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("接收到get请求");
        //Post方式中文乱码
        req.setCharacterEncoding("utf-8");

        //1.获取单一key的参数名 获取对应的请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String isAuto = req.getParameter("isAuto");
        System.out.println(username);
        System.out.println(password);
        UserService userService = new UserService();
        Boolean login = userService.login(username, password);
        System.out.println(login);
        if (login) {
            //判断复选框是否被选中
            if (isAuto != null) {
                Cookie ckUsername = new Cookie("username", username);
                Cookie ckPassword = new Cookie("password", password);
                ckUsername.setMaxAge(60*60*24*14);
                ckPassword.setMaxAge(60*60*24*14);
                resp.addCookie(ckUsername);
                resp.addCookie(ckPassword);

            }
            req.getRequestDispatcher("success.html").forward(req,resp);
            System.out.println("执行了?");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
