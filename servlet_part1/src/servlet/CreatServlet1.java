package servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Tjl on 2018/8/17 8:30.
 * 第一种创建servlet 的方式,实现javax.servlet.Servlet接口
 * Servlet接口中有5个抽象方法,所以自定义Servlet需要全部实现
 */
public class CreatServlet1 implements Servlet {

    //初始化:servlet对象创建后进行初始化调用,需要传参:参数类型:servletConfig
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }
    //返回包含此Servlet相关的配置信息的ServletConfig对象
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
    //运行时接收到请求,就会执行Service
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("接收到请求");
        //类型转换
        String method = ((HttpServletRequest) servletRequest).getMethod();
        //接收到请求后执行以下代码
        System.out.println("接收到请求:"+method);
        //返回响应,返回一个html页面,设置响应内容编码格式;
        servletRequest.setCharacterEncoding("UTF-8");
        //contentType:响应的文件类型是html,编码格式
        servletResponse.setContentType("text/html;charset=utf-8");
        //获取响应输出流
        PrintWriter pw = servletResponse.getWriter();
        pw.print("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
        pw.print("<html>");
        pw.println("<head>");
        pw.print("<title>实现Serclet接口的方式</title>");
        pw.println("</head>");
        pw.print("<body><h1 style='color:red;'>hello,方式1:实现javax.servlet.Servlet</h1></body>");
        pw.print("你好");
        pw.print("hello");
        pw.print("</html>");


        pw.flush();
        pw.close();

    }
    //返回Servlet的字符串描述信息 作者 版本 版权
    @Override
    public String getServletInfo() {
        return null;
    }
    //servlet对象销毁的时候调用
    @Override
    public void destroy() {

    }
}
