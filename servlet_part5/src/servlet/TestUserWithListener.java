package servlet;

import bean.UserWithListener;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Tjl on 2018/8/21 14:54.
 */
public class TestUserWithListener extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //session范围添加移除替换UserWithListener类型的对象
        HttpSession session = req.getSession();
//		session.setAttribute("user", "tom");
        System.out.println(session.getAttribute("users"));
        session.setAttribute("users", new UserWithListener("zs", 15, "F"));
//		session.setAttribute("users", new UserWithListener("ls", 17, "M"));
//		session.removeAttribute("user");
//		session.removeAttribute("users");
    }
}
