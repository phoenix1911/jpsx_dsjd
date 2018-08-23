package com.briup.day4;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 测试请求传参
 * */
public class Test1RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Test1RequestServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//在请求范围内设置参数/替换参数/移除参数
		//1.怎么获取request，参数中有
		//2.调用哪些方法
		//添加参数
		request.setAttribute("namer", "tom");
		request.setAttribute("namer2", "tim");
		request.setAttribute("userr", new User());
		request.setAttribute("listr", new ArrayList<>());
		//移除参数
		request.removeAttribute("namer2");
		//替换参数
		request.setAttribute("namer", "tim");
		//获取参数
		System.out.println("test1Req: namer的值:"+request.getAttribute("namer"));
		
		//服务器内部跳转
//		request.getRequestDispatcher("/getparam").forward(request, response);
		//客户端重定向：相当于重新发送一次请求
		response.sendRedirect("getparam");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
