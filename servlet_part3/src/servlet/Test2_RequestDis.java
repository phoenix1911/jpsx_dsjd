package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by Tjl on 2018/8/18 9:54.
 * 测试2：测试请求跳转
 */
public class Test2_RequestDis extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("接收到请求");
        System.out.println("可以获取参数，封装数据");
        System.out.println("如果这个请求需要访问数据库，思考在三层架构");
        System.out.println("假设数据处理代码有500行，现在处理结束了");
        System.out.println("返回响应--html页面");
        //怎么返回一个html页面
        resp.setContentType("text/html;charset=utf-8");
        //1.边看边写
        //2.边读边写
//        String realPath = getServletContext().getRealPath("/html/test1.html");
//        System.out.println(realPath);
//        FileInputStream fileInputStream = new FileInputStream(new File(realPath));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
//        String line = "";
//        PrintWriter writer = resp.getWriter();
//        while ((line = bufferedReader.readLine()) != null) {
//            writer.print(line);
//        }
//        writer.flush();
//        writer.close();
        //3.跳转
        /*
        forward:response清空
        include:response追加
         */
//        req.getRequestDispatcher("html/test1.html").forward(req,resp);//清空
//        req.getRequestDispatcher("html/test1.html").include(req,resp);//追加
        //请求跳转到另一个请求中
        PrintWriter writer = resp.getWriter();
        writer.println("hello");
        req.getRequestDispatcher("OS.servlet").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
