package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tjl on 2018/8/18 10:30.
 * 重定向
 */
public class Test4_RequestRed extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Test4_RequestRed");
        System.out.println("重定向之前: "+ req.getParameter("name"));
        //重定向
        resp.sendRedirect("OS.servlet");
    }
}
