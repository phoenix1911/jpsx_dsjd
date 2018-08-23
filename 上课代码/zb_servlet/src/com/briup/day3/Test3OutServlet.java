package com.briup.day3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//访问Test3OutServlet：请求从Test2RequestDis中跳转过来
public class Test3OutServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Test3OutServlet接收到请求");
		System.out.println("test3是否获取到:"+req.getParameter("name"));
		PrintWriter pw = resp.getWriter();
		pw.print("world");
		pw.flush();
		pw.close();
	}
}
