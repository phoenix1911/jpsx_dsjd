package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * day2_test5:测试Servlet的生命周期
 * 			1.初始化:构造器+init[只执行一次]
 * 					初始化时机:默认:
 * 							配置:
 * 			2.运行:service
 * 				接收到请求，执行
 *			 3.销毁:destory
 * 					web应用停止或者重新加载
 *
 *
 * */
public class Test5_Life_Servlet extends HttpServlet{
    public Test5_Life_Servlet() {
        System.out.println("1.执行构造器");
    }


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("2.默认初始化，赋值ServletConfig对象");
    }


    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("3.无参init，重写此方法，进行初始化");
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        System.out.println("5.判断请求方法，调用doXxx方法");
    }


    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
        System.out.println("4.运行，进行类型强制准换，调用另一个service");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行doGet方法");
        resp.setContentType("text/plain;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        /*
        GenericServlet已经实现了ServletConfig接口中定义的方法了
         */
        pw.println("输出:");
        pw.println(getServletName());
        pw.println(getInitParameter("password"));
        pw.println(getInitParameterNames());
        pw.println(getServletContext());
        pw.println("*******************************************");

        ServletConfig servletConfig = getServletConfig();
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        pw.println("如果不知道参数名,可以获取所有参数名然后遍历");
        while (initParameterNames.hasMoreElements()) {
            String key = initParameterNames.nextElement();
            String value = servletConfig.getInitParameter(key);
            pw.println(key+" : "+value);
        }
        pw.println("*******************************************");
//        应用上下文
        ServletContext servletContext = servletConfig.getServletContext();
        pw.println("应用上下文:" +servletContext.getContextPath());
        pw.println(servletContext.getRealPath("/"));


        pw.flush();
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("6.执行doPost方法");
        doPost(req, resp);
    }

    @SuppressWarnings("unused")
    private void destory() {
        System.out.println("7.销毁:程序停止或者重新加载");
    }

}
