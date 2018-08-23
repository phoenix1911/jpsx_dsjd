package servlet;

import bean.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Tjl on 2018/8/18 17:47.
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("接收到get请求");
        //Post方式中文乱码
        req.setCharacterEncoding("utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String repassword = req.getParameter("repassword");
        String phone = req.getParameter("phone");

        System.out.println(username);
        System.out.println(password);
        System.out.println(phone);


        if (password.equals(repassword)) {
            UserService userService = new UserService();
            Boolean register = userService.register(username, password, phone);
            System.out.println("注册成功");
            User dbUser = userService.showByUsername(username);
            HttpSession session = req.getSession();
            session.setAttribute("user",dbUser);

            req.getRequestDispatcher("login.html").forward(req, resp);


        } else {
            req.getRequestDispatcher("register.html").forward(req, resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
