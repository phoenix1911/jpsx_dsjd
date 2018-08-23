package com.briup.day3.urltest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//localhost:8888/zb_servlet/d3test1
//localhost:8888/zb_servlet/a/b/d3test2  
//localhost:8888/zb_servlet/c/d/d3test3  
//localhost:8888/zb_servlet/day3/d3test4  *
//localhost:8888/zb_servlet/html/day3_1.html
public class Test4Servlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("test4");
		//服务器内部跳转，相对路径
//		req.getRequestDispatcher("../html/day3_1.html").forward(req, resp);
//		req.getRequestDispatcher("/html/day3_1.html").forward(req, resp);
		//内部跳转和重定向的过程中，请求1-请求2-请求3-页面，都是基于正常访问上一条请求的时候的路径
		
		//不同点：最后请求到了页面的时候，如果页面中申请了静态资源--基于浏览器地址栏
//		resp.sendRedirect("../html/day3_1.html");
		resp.sendRedirect("/zb_servlet/html/day3_1.html");
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
