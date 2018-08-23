package com.briup.day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 测试2：测试请求跳转
 * */
public class Test2RequestDis extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("接收到请求");
		System.out.println("可以获取参数，封装数据");
		System.out.println("如果这个请求需要访问数据库，思考在三层架构....");
		System.out.println("假设数据处理代码有500行，现在处理结束了");
		System.out.println("返回响应--html页面");
		//怎么返回一个html页面
		resp.setContentType("text/html;charset=utf-8");
		//1.边看边写
		PrintWriter pw = resp.getWriter();
		/*pw.print("<html><head><title>这是手动输出的</title></head><body>");
		pw.print("<h1>辛辛苦苦写的</h1>");
		pw.print("</body>");*/
		//2.边IO读边写
//		InputStream is = getClass().getResourceAsStream("../../../../../html/day3_1.html");
//		String realPath = getServletContext().getRealPath("/html/day3_1.html");
//		System.out.println(realPath);
//		FileInputStream fis = new FileInputStream(new File(realPath));
//		BufferedReader br = 
//				new BufferedReader(new InputStreamReader(fis));
//		String line = "";
//		while((line=br.readLine())!=null){
//			pw.println(line);
//		}
//		pw.flush();
//		pw.close();
		//3.跳转
			//内部跳转[服务器内部跳转]:req.getRequestDispatcher forward:response中forwar之前的内容情况 
		    //                                            include:跳转之前resposne中的内容做追加
			//重定向
		System.out.println("测试的是内部跳转");
		//请求跳转到页面
//		req.getRequestDispatcher("html/day3_1.html").forward(req, resp);
//		req.getRequestDispatcher("html/day3_1.html").include(req, resp);
		//请求跳转到另一个请求中
		pw.print("hello");
		System.out.println(req.getParameter("name"));
//		req.getRequestDispatcher("test3out").forward(req, resp);//清空
//		req.getRequestDispatcher("test3out").include(req, resp);//追加
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
