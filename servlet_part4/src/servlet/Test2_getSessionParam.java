package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Tjl on 2018/8/20 9:07.
 */
public class Test2_getSessionParam extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取会话范围中的session
        HttpSession session = req.getSession();
        System.out.println("getSessionParam中的session" + session.getId());
        System.out.println("name : "+session.getAttribute("name"));
        System.out.println("name2 : " +session.getAttribute("name2"));
        System.out.println("user : "+session.getAttribute("user"));
        System.out.println("list : "+session.getAttribute("list"));


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
