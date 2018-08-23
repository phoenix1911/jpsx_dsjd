package com.briup.day4;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 测试上下文范围:application
 */
public class Test3ApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Test3ApplicationServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//application:应用上下文，整个web项目启动期间，只有一个，被所有客户端共用
		//1.怎么获取
		ServletContext application1 = getServletContext();
		ServletContext application2 = request.getServletContext();
		ServletContext application3 = request.getSession().getServletContext();
		System.out.println(application1==application2);
		System.out.println(application3==application2);
		//2.设置/替换/移除
		application1.setAttribute("namea", "tom");
		application1.setAttribute("namea2", "tim");
		application1.setAttribute("usera", new User());
		application1.setAttribute("lista", new ArrayList<>());
		
		application1.setAttribute("namea", "toma");
		application1.removeAttribute("namea2");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
