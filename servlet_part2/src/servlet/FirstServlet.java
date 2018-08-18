package servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;
import java.io.PrintWriter;

//第一个servlet类，继承抽象父类HttoSerblet
public class FirstServlet extends HttpServlet {

    //请求URL--执行一段java代码(作用：处理这个请求)(哪段：service)
    //service-->service-->doXxx
    //方法重写：方法名一样，参数列表一样，访问权限不能被缩小，异常不能被扩大
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        //这个URL请求的处理过程就在这里写
        //获取请求中的相关信息[参数]，进行一系列的处理[接收参数]
        //注册:....数据库交互.....
        //返回响应
        PrintWriter pw = response.getWriter();
        pw.print("hello world");
        pw.flush();
        pw.close();
    }
}