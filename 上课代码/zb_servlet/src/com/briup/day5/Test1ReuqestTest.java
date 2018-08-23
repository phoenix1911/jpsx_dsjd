package com.briup.day5;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test1ReuqestTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Test1ReuqestTest() {
        super();
    }
    //  /test1req        /*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("访问到真正的资源："+request.getParameter("name"));
		response.setContentType("text/html;charset=utf-8");
		//重定向
		response.sendRedirect("../html/day3_1.html");
		//内部跳转，不拦截
//		request.getRequestDispatcher("../html/day3_1.html").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
