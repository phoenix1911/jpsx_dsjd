package com.briup.day1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("接受到GET方式请求");
		//设置响应内容的编码格式
		resp.setCharacterEncoding("utf-8");
		//通知客户端浏览器，服务器发送的响应类型以及编码格式
		resp.setContentType("text/plain;charset=utf-8");
		//text,images,html
		PrintWriter pw = resp.getWriter();
		pw.print("hello 你好");
		pw.flush();
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("接收到Post方式请求，执行doGet方法处理请求");
		doGet(req,resp);
	}
	
	
}
