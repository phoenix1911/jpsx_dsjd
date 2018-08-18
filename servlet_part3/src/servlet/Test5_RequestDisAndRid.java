package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tjl on 2018/8/18 10:44.
 */
public class Test5_RequestDisAndRid extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("接收到get请求");
        //服务器内部跳转: /:项目根目录http://localhost:8080/servlet_part3
//        req.getRequestDispatcher("day3/E.servlet").forward(req,resp);
//        req.getRequestDispatcher("/day3/E.servlet").forward(req,resp);

        //客户端重定向: /:服务器根目录http://localhost:8080/
//        resp.sendRedirect("day3/E.servlet");//404
        resp.sendRedirect("/day3/E.servlet");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("接收到post请求");
        doPost(req, resp);
    }
}
