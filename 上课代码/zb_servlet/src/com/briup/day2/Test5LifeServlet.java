package com.briup.day2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * day2 test5:测试servlet的声明周期
 * 		1.初始化:构造器+init[只执行一次]
 * 			  初始化时机：默认:第一次访问的时候初始化
 * 					    配置:load-on-startup:整数<负数，0，正数>
 * 						 1.负数:默认，第一次访问的时候初始化
 *  				     2.0，正整数:服务器启动就创建，数字越小，越先启动,0最先
 * 
 * 		2.运行:service
 * 			 接收到请求,执行
 * 
 * 		3.销毁:destory
 * 			web应用停止或者重新加载
 * */
public class Test5LifeServlet extends HttpServlet{
	public Test5LifeServlet(){
		System.out.println("1.执行构造器");
	}
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("2.默认初始化，赋值ServletConfig对象");
		super.init(config);
	}
	
	public void init() throws ServletException {
		System.out.println("3.无参init，重写此方法，进行初始化");
		System.out.println("*****初始化操作**********");
		/*
		 *GenericServlet已经实现了ServletConfig接口中定义的方法了 
		 */
		/*getServletName();
		getInitParameter("");
		getInitParameterNames();
		getServletContext();*/
		ServletConfig config = getServletConfig();
		String ServletName = config.getServletName();
		
		System.out.println("servlet-name标签中的值："+ServletName);
		
		String username = config.getInitParameter("username");
		String password = config.getInitParameter("password");
		System.out.println("根据已知参数名获取参数值:username: "+username+", password: "+password);
		
		Enumeration<String> es = config.getInitParameterNames();
		System.out.println("如果不知道参数名，可以获取所有参数名然后遍历");
		//判断是否还有参数元素
		while(es.hasMoreElements()){
			//遍历到第一个参数名
			String initParamterName = es.nextElement();
			//根据遍历出的参数名，即可获取对应参数值
			String initParameterValue = config.getInitParameter(initParamterName);
			System.out.println(initParamterName+": "+initParameterValue);
		}
		
		//应用上下文:当前应用
		ServletContext application = config.getServletContext();
		System.out.println("应用上下文:"+application.getContextPath());
		String realPath = application.getRealPath("/images/sn1.jpg");
		System.out.println(realPath);
		
		System.out.println("******************************");
	}
	
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("4.运行，进行类型强制转换，调用另一个servcie"+this);
		super.service(req, res);
	}
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("5.判断请求方法，执行doXxx方法");
		super.service(req, resp);
	}


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("6.执行doGet方法:"+req.getRemoteHost());
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.print("<h1>辛辛苦苦拼接输出</h1>");
		pw.flush();
		pw.close();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("6.POST请求方式");
		doGet(req, resp);
	}
	public void destroy() {
		System.out.println("7.销毁：程序停止或者重新加载");
	}

}
