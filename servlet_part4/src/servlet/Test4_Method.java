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
 * Created by Tjl on 2018/8/20 14:10.
 * 三大域对象常用的方法
 */
public class Test4_Method extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset=utf-8");
        PrintWriter writer = resp.getWriter();

        testRequestMethod(req, writer);

        writer.println("********************************************");

        testSessionMethod(req, writer);

        writer.println("********************************************");
        testApplicationMethod(writer);


        writer.println();
        writer.println();



        writer.flush();
        writer.close();
    }

    private void testApplicationMethod(PrintWriter writer) {
        ServletContext application = getServletContext();
        writer.println(application.getContextPath());
        writer.println(application.getRealPath("/index.jsp"));
        writer.println(application.getResourcePaths("/"));
        //获取初始化参数 web.xml里的
        writer.println(application.getInitParameter("encoding"));
    }

    private void testSessionMethod(HttpServletRequest req, PrintWriter writer) {
        //session对象常用的方法
        HttpSession session = req.getSession();
        writer.println("sessionid"+session.getId());
        writer.println("session最大不活跃时间"+session.getMaxInactiveInterval());
        session.setMaxInactiveInterval(600);
        writer.println("session最大不活跃时间"+session.getMaxInactiveInterval());
        writer.println("获取session的创建时间"+session.getCreationTime());
        writer.println("获取上次请求时间"+session.getLastAccessedTime());
        writer.println("获取上下文对象application"+session.getServletContext());
        //主动销毁session
        session.invalidate();
        writer.println(session.getId());
    }

    private void testRequestMethod(HttpServletRequest req, PrintWriter writer) {
        writer.println(req.getContextPath());
        writer.println(req.getServletPath());
        writer.println(req.getRequestURL());
        writer.println(req.getRequestURI());
        writer.println(req.getProtocol());
        writer.println(req.getScheme());
        writer.println(req.getServerName());
        writer.println(req.getServerPort());
        writer.println(req.getQueryString());

        //基路径 协议://ip:port/ContextPath
        String basePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+req.getContextPath();
        writer.println(basePath);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
