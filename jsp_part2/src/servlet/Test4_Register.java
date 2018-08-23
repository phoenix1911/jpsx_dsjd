package servlet;

import bean.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tjl on 2018/8/23 9:43.
 */
public class Test4_Register extends HttpServlet {
    //与用户进行交互
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
//        1.获取用户传送的参数
        String name = req.getParameter("name");
        String[] addrs = req.getParameterValues("addr");
        System.out.println("servlet获取到请求中携带的参数:"+name+" : "+addrs);
//        2.封装数据
        Student student = new Student(name, addrs[0]);
        System.out.println(name+addrs);
        System.out.println(student);
        System.out.println("封装数据,调用其他类的对应方法处理这些注册数据[servlet,register]");
        //3.处理数据

        //4.以及处理结束
        //5.给页面传参
        req.setAttribute("name",name);
        req.setAttribute("student",student);
        req.getSession().setAttribute("name","servlet_session_name");
        getServletContext().setAttribute("name","servlet_application_name");
        //6.反应响应页面
        req.getRequestDispatcher("/jsp/Test4_el.jsp").forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
