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
//内部跳转过来的:
public class Test6End extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("test6接收到请求");
		
		//服务器内部跳转  : http://ip:8888/项目名/day3/...
		req.getRequestDispatcher("../html/day3_1.html").forward(req, resp);
		
		//http://localhost:8888/zb_servlet/day3/test6end
		//相对点其实还是：http://localhost:8888/zb_servlet/test5dar
		//相对路径：相对当前请求/最近的请求[看地址栏]
//		resp.sendRedirect("html/day3_1.html");
//		resp.sendRedirect("/zb_servlet/html/day3_1.html");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post请求");
		doGet(req, resp);
	}
	
}
