package com.briup.day2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * test3:实现Serlvet的第三种，也是最常用的方式：继承自javax.servlet.http.HttpServlet
 * 		HttpServlet继承自GenericServlet,实现了Servlet
 * 		HttpServlet:5个方法都实现了
 * */
public class Test3HttpServlet extends HttpServlet{
	public Test3HttpServlet(){
		System.out.println("Test3HttpServlet 创建");
	}
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("2.再执行");
		super.service(req, resp);
	}

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("1.先执行");
		super.service(req, res);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("接受到Get方式请求");
		//返回响应：边看边写，边读边写
		resp.setContentType("text/plain;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.print("响应内容....");
		pw.flush();
		pw.close();
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("接受到 Post方式请求");
		doGet(req, resp);
	}
//	
}
