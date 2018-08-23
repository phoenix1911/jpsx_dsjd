package com.briup.day3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//localhost:8888/zb_servlet/test5dar
//localhost:8888/zb_servlet/a/b/tes5_5cen
//localhost:8888/zb_servlet/c/d/test5_6cen2
//localhost:8888/zb_servlet/test5_7cen3
//localhost:8888/zb_servlet/day3/test6end
public class Test5RequestDisAndRed extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("test5接收到请求");
		
		//服务器内部跳转: /:项目根目录 http://localhost:8888/zb_servlet/
		req.getRequestDispatcher("a/b/test5_5cen").forward(req, resp);
		
//		req.getRequestDispatcher("day3/test6end").forward(req, resp);
//		req.getRequestDispatcher("/day3/test6end").forward(req, resp);
		//客户端重定向: /:服务器根目录 http://localhost:8888/
//		resp.sendRedirect("day3/test6end");
//		resp.sendRedirect("/zb_servlet/day3/test6end");
//		resp.sendRedirect("a/b/test5_5cen");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post请求");
		doGet(req, resp);
	}
	
}
