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
 * test4:测试url-pattern的写法
 * */
public class Test4URLPattern extends HttpServlet{
	public Test4URLPattern(){
		System.out.println("Test4URLPattern 创建");
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("接受到Get方式请求");
		//返回响应：边看边写，边读边写
		resp.setContentType("text/plain;charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.print("响应内容Test4URLPattern....");
		pw.flush();
		pw.close();
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("接受到 Post方式请求");
		doGet(req, resp);
	}
//	
}
