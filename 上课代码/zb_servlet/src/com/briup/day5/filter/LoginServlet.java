package com.briup.day5.filter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--LoginServlet:--");
		System.out.println("从请求中获取username,password");
		System.out.println("创建service对象，调用service对象的login方法,做处理");
		System.out.println("判断结果：用户名存在，密码一致，登录成功，返回当前登录的User对象");
		System.out.println("将此user对象存放在session范围中");
		request.getSession().setAttribute("user", new User());
		
		//跳转到登录成功之后的首页
		response.sendRedirect("html/loginsuccess.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
