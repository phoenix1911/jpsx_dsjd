package com.briup.day3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 重定向:请求从test3red中跳转到test3out去,test3out跳转到其他页面，或者其他请求，或者通过流输出
 * 		1.地址栏地址发生改变
 *      2.请求发送多次
 * */
public class Test4RequestRed extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("---Test4RequestRen");
		System.out.println("重定向之前:"+req.getParameter("name"));
		//重定向
		resp.sendRedirect("test3out");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
