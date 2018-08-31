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
 * Created by Tjl on 2018/8/30 16:36.
 */
@WebServlet("/updateUserInfoServlet")
public class UpdateUserInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1.获取前台传来的修改数据
        String id = req.getParameter("id");
        String zip = req.getParameter("zip");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
//        2.修改该user信息
        UserService userService = new UserServiceImpl();
        System.out.println("前台接收的数据:"+id+zip+phone+email);
        boolean b = userService.UpdateUserById(id, zip, phone, email);
        System.out.println(id+"修改:"+b);

        if (b) {
//        5.如果修改成功,跳转到主页
            User dbUser = userService.findUserById(Integer.parseInt(id));
            HttpSession session = req.getSession();
            session.setAttribute("user", dbUser);
            session.setAttribute("msg","修改成功");
            req.getRequestDispatcher("home/userinfo.jsp").forward(req, resp);
        } else {
//        6.如果失败则在"注册页面"中弹出"注册失败*
            req.setAttribute("msg", "修改信息失败!");
            req.getRequestDispatcher("home/userinfo.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
