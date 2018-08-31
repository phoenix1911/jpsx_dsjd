package web.servlet.user;

import bean.User;
import service.UserService;
import service.serviceImpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Tjl on 2018/8/30 15:50.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1.获取前台数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");
//        2.封装User对象
        User user = new User(username, password);
//        3.user对象执行登陆方法
        UserService userService = new UserServiceImpl();
        boolean login = userService.login(user);
//        4.根据登陆方法结果执行相应操作
        if (login) {
//        5.如果注册成功,跳转到首页
            User dbUser = userService.findUserByUsername(username);
            HttpSession session = req.getSession();
            session.setAttribute("user", dbUser);
            req.getRequestDispatcher("home/index.jsp").forward(req, resp);
        } else {
//        6.如果失败则在"注册页面"中弹出"注册失败*
            req.setAttribute("msg", "登陆失败!");
            req.getRequestDispatcher("home/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
