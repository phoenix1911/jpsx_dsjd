package com.briup.day7;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test4FRServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Test4FRServlet() {
        super();
    }
    //与用户交互
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//1.获取用户传送的数据
		String name = request.getParameter("name");
		String[] addrs = request.getParameterValues("addr");
		System.out.println("servlet获取到请求中携带的参数："+name+"--"+Arrays.toString(addrs));
		//2.封装数据
		Student student = new Student(name, addrs);
		System.out.println(student);
		System.out.println("封装数据，调用其他类的对应方法处理这些注册数据[service.register]");
		//3.处理数据[servcie] new StudentServcie().register(student);
		//4.处理结束
		//5.给页面传参
		request.setAttribute("student", student);
		System.out.println("数据处理结束，servlet返回页面，返回数据给页面显示");
		request.setAttribute("name", name);
		request.getSession().setAttribute("name", "servlet_session_name");
		getServletContext().setAttribute("name", "servlet_application_name");
		//6.返回响应页面
		request.getRequestDispatcher("/jsp_day2/test4_el.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
