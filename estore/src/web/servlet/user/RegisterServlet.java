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
import java.util.Date;

/**
 * Created by Tjl on 2018/8/30 11:12.
 * 注册servlet
 * Servlet implementation class RegisterServlet
 * 实现思路
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//       * 1.获取前台传来的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String zip = req.getParameter("zip");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
//       * 2.封装User对象
        User user = new User(username, password, zip, phone, email, new Date(), 1);
//        * 3.注册User对象
        UserService userService = new UserServiceImpl();
        boolean bool = userService.register(user);
//         * 4.根据注册的结果执行相应的操作

        if (bool) {
// * 5.如果注册成功,跳转到首页

//            上面的user不包含id,从数据库里获取完整user
//            System.out.println(username);
            User dbUser = userService.findUserByUsername(username);
            HttpSession session = req.getSession();
            session.setAttribute("user", dbUser);
            req.getRequestDispatcher("home/index.jsp").forward(req, resp);
        } else {
// * 6.如果失败则在"注册页面"中弹出"注册失败*
            req.setAttribute("msg", "注册失败!");
            req.getRequestDispatcher("home/register.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
