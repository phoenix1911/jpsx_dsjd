package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

/**
 * Created by Tjl on 2018/8/20 15:19.
 */
public class Test5_Cookie1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("请求到达cookie1");

        HttpSession session = req.getSession();
        writer.println("生成session : "+ session.getId());

        //自定义Cookie对象
        //1.创建cookie对象
        Cookie c1 = new Cookie("username", URLEncoder.encode("测试中文cookie 需要编码,解码","utf-8"));
        Cookie c2 = new Cookie("password", "123");
        //2.给Cookie 设置最大存活时间,单位是秒;如果不设置,为会话Cookie
        c1.setMaxAge(60*60*24*7);
        //3.可以设置cookie的路径 ,默认和当前请求一致
//        c1.setPath("/servlet_part4/");
        //4.使用response将cookie写到客户端浏览器
        resp.addCookie(c1);
        resp.addCookie(c2);




    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
