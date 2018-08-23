package com.briup.day2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * day2_测试1：第一种创建servlet的方式，实现javax.servlet.Servlet接口
 * 			  Servlet接口中有5个抽象方法，所以自定义Servlet需要全部实现
 * 			  destroy,getServletConfig,getServletInfo,init,service
 * */
public class Test1Servlet implements Servlet{
	//返回包含与此Servlet相关的配置信息的 ServletConfig对象
	public ServletConfig getServletConfig() {
		return null;
	}
	//返回Servlet的字符串描述信息，比如：作者、版本、版权.....
	public String getServletInfo() {
		return null;
	}
	//初始化:Servlet对象创建后进行初始化时调用 ，需要传参:参数类型ServletConfig
	public void init(ServletConfig arg0) throws ServletException {
		
	}
	//运行的时候接收到请求，就会执行service
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		//类型转换
		String method = ((HttpServletRequest)request).getMethod();
		//接收到请求后执行以下代码 
		System.out.println("接收到请求:"+method);
		
		//返回响应,返回一个html页面，设置响应内容编码格式
		response.setCharacterEncoding("UTF-8");
		//ContentType:响应的文件类型是html,编码格式
		response.setContentType("text/html;charset=utf-8");
		
		//获取响应输出流,将html文件中的代码原样输出
		PrintWriter pw = response.getWriter();
		pw.print("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		pw.print("<html>");
		pw.print("<head>");
		pw.print("<title>实现Servlet接口的方式</title>");
		pw.print("</head>");
		pw.print("<body><h1 style='color:red;'>hello,方式1：实现javax.servlet.Servlet</h1></body>");
		pw.print("</html>");
		
		pw.flush();
		pw.close();
		
		
	}
	//Servlet对象销毁的时候调用
	public void destroy() {
	}

}
