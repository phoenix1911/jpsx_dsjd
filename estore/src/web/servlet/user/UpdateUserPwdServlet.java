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
 * Created by Tjl on 2018/8/30 18:44.
 */
@WebServlet("/updateUserPwdServlet")
public class UpdateUserPwdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1.获取前台传入的数据
        String username = req.getParameter("username");
        String oldpassword = req.getParameter("oldpassword");
        String newpassword = req.getParameter("newpassword");
        String repassword = req.getParameter("repassword");
//        2.执行修改密码方法
        UserService userService = new UserServiceImpl();
        int i  = userService.updateUserPwdByUsername(username,oldpassword,newpassword,repassword);
//        3.根据修改结果执行相应操作
        if (i == 0) {
            req.setAttribute("msg", "旧密码为空或输错,修改密码失败!");
            req.getRequestDispatcher("home/editpwd.jsp").forward(req, resp);
        } else if (i == 1) {
            req.setAttribute("msg", "新密码或确认密码为空,修改密码失败!");
            req.getRequestDispatcher("home/editpwd.jsp").forward(req, resp);
        }else if (i == 2) {
            req.setAttribute("msg", "新密码和确认密码不一致,修改密码失败!");
            req.getRequestDispatcher("home/editpwd.jsp").forward(req, resp);
        }else if (i == 3) {
            User dbUser = userService.findUserByUsername(username);
            HttpSession session = req.getSession();
            session.setAttribute("user", dbUser);
            req.setAttribute("msg", "修改密码成功!");
            req.getRequestDispatcher("home/editpwd.jsp").forward(req, resp);
        }





    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
