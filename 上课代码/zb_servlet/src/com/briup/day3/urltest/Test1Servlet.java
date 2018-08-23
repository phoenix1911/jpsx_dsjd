package com.briup.day3.urltest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//localhost:8888/zb_servlet/d3test1       *
//localhost:8888/zb_servlet/a/b/d3test2
//localhost:8888/zb_servlet/c/d/d3test3
//localhost:8888/zb_servlet/day3/d3test2
public class Test1Servlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("test1");
		//服务器内部跳转到test2,相对路径
//		req.getRequestDispatcher("a/b/d3test2").forward(req, resp);
		//绝对
//		req.getRequestDispatcher("/a/b/d3test2").forward(req, resp);
		
		//客户端重定向，相对路径
//		resp.sendRedirect("a/b/d3test2");
		resp.sendRedirect("/zb_servlet/a/b/d3test2");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
//		getServletContext().getContextPath() /项目名
		/*如果是在请求内部跳转过程中，相对路径指的是当前资源的路径		      
		如果是在请求内部跳转结束后，浏览器页面上的静态资源，如果使用相对路径的话，则是相对当前浏览器上显示的地址。
	      如果是重定向，相对路径都是相对浏览器地址栏显示的路径*/

	}
	
}
