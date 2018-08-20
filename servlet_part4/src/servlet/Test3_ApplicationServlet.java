package servlet;

import bean.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Tjl on 2018/8/20 10:17.
 */
public class Test3_ApplicationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //application : 应用上下文,整个web项目启动期间,只有一个,被所有客户端共用
        //1.怎么获取
        ServletContext application1 = getServletContext();
        ServletContext application2 = req.getServletContext();
        ServletContext application3 = req.getSession().getServletContext();

        PrintWriter writer = resp.getWriter();
        writer.println(application1);
        writer.println(application2);
        writer.println(application3);

        //2.设置/替换/移除
        application1.setAttribute("name","tom");
        application1.setAttribute("name2","tim");
        application1.setAttribute("user",new User());
        application1.setAttribute("list",new ArrayList<>());

        application1.setAttribute("name","tom1");
        application1.removeAttribute("name2");

        writer.println(application1.getAttribute("list"));
        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
