package servlet;

import bean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Tjl on 2018/8/20 8:56.
 * 测试请求传参
 */
public class Test1_RequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //在请求范围内设置参数/替换参数/移除参数
        //1.怎么获取reuqest 参数中有
        //2.调用哪些方法
            //添加参数
        req.setAttribute("name","tom");
        req.setAttribute("name2","tom");
        req.setAttribute("user",new User());
        req.setAttribute("list",new ArrayList<>());
            //移除参数
        req.removeAttribute("name2");
            //替换参数
        req.setAttribute("name","tim");
            //获取参数
        System.out.println("Test1 name:"+req.getAttribute("name"));

//        //服务器内部跳转
//        req.getRequestDispatcher("/GP.servlet").forward(req,resp);
//        客户端重定向:相当于重新发送一次请求
        resp.sendRedirect("/servlet_part4/GP.servlet");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
