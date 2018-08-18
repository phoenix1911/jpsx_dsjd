package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Tjl on 2018/8/18 10:17.
 * 访问Test2OUtServelt:请求从Test2_RequestDis中跳转过来
 */
public class Test3_OutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("OutServlet");
        System.out.println("重定向之后: "+ req.getParameter("name"));
        PrintWriter writer = resp.getWriter();
        writer.println("Test3_OutServlet");
    }
}
