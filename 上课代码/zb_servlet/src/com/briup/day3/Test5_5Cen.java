package com.briup.day3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//test5--test5.5--test6--html

//localhost:8888/zb_servlet/test5dar
//localhost:8888/zb_servlet/a/b/tes5_5cen
//localhost:8888/zb_servlet/c/d/test5_6cen2
//localhost:8888/zb_servlet/test5_7cen3
//localhost:8888/zb_servlet/day3/test6end
public class Test5_5Cen extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("test5.5执行");
		//地址栏http://localhost:8888/zb_servlet/day3/test6end
		
		req.getRequestDispatcher("../../c/d/test5_6cen2").forward(req, resp);
//		resp.sendRedirect("../../c/d/test5_6cen2");
	}
}
