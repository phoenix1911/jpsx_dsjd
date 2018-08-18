package servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Tjl on 2018/8/17 9:59.
 * test3:实现servlet的第三种,也是最常用的方式,继承自javax.servlet.http.HttpServlet
 * HttpServlet继承自GenericServlet,实现了Servlet
 * HttpServlet:5个方法都实现了
 */
public class CreatHttpServlet extends HttpServlet {

    public CreatHttpServlet() {
        System.out.println("创建CreatHttpServlet实例");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("接收到Get方式请求");
        //返回响应:边看边写(println),边读边写(io)
        resp.setContentType("text/plain;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.print("这是响应内容");
        pw.flush();
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("接收到post方式请求");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        System.out.println("httpservlet service..");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
        System.out.println("servlet servic");
    }
}
