package com.briup.day3.urltest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//localhost:8888/zb_servlet/d3test1
//localhost:8888/zb_servlet/a/b/d3test2  
//localhost:8888/zb_servlet/c/d/d3test3  *
//localhost:8888/zb_servlet/day3/d3test4
public class Test3Servlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("test3");
		//服务器内部跳转，相对路径
//		req.getRequestDispatcher("../../day3/d3test4").forward(req, resp);
//		req.getRequestDispatcher("/day3/d3test4").forward(req, resp);
		
//		resp.sendRedirect("../../day3/d3test4");
		resp.sendRedirect("/zb_servlet/day3/d3test4");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
