package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Tjl on 2018/8/20 9:07.
 */
public class Test3_getApplicationParam extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        resp.setContentType("text/plain;charset=utf-8");
        //获取上下文环境中的参数
        ServletContext application = getServletContext();
        PrintWriter writer = resp.getWriter();
        writer.println("application范围的值");
        writer.println(application.getAttribute("name"));
        writer.println(application.getAttribute("name2"));
        writer.println(application.getAttribute("user"));
        writer.println(application.getAttribute("list"));

        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
