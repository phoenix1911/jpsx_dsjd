package com.briup.day4;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 三大域对象常用的方法
 */
public class Test4Method extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Test4Method() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request请求对象常用的方法
		/*System.out.println(request.getContextPath());// /zb_servlet
		System.out.println(request.getServletPath());// /method
		System.out.println(request.getRequestURL());//  http://localhost:8888/zb_servlet/method
		System.out.println(request.getRequestURI());//  /zb_servlet/method
		System.out.println(request.getQueryString());// name=zs&pwd=123
		System.out.println(request.getProtocol());//   HTTP/1.1
		System.out.println(request.getScheme());//   http
		System.out.println(request.getServerName());// localhost
		System.out.println(request.getServerPort());// 8888
		//基路径 协议://ip:port/projectName/
		String basePath = request.getScheme()+"://"+
							request.getServerName()+":"+
								request.getServerPort()+
									request.getContextPath()+"/";
		System.out.println(basePath);*/
		//session对象常用的方法
		//获取session对象
		/*HttpSession session = request.getSession();
		System.out.println("sessionId:"+session.getId());
		System.out.println("session的最大不活跃时间:"+session.getMaxInactiveInterval());
		//设置当前session对象的最大不活跃时间为10分钟
		session.setMaxInactiveInterval(600);
		//时间格式的转换:xxxx年-xx月-xx日 时:分:秒
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY年-MM月-dd日 HH:mm:ss");
		System.out.println("session的最大不活跃时间:"+session.getMaxInactiveInterval());
		System.out.println("获取session的创建时间:"+sdf.format(new Date(session.getCreationTime())));
		System.out.println("获取上次请求时间:"+sdf.format(new Date(session.getLastAccessedTime())));
		System.out.println("获取上下文对象application:"+session.getServletContext());
		//主动销毁session
		session.setAttribute("name", "tom");
		session.invalidate();*/
		
		//application常用的方法
		ServletContext application = getServletContext();
		System.out.println(application.getContextPath());
		System.out.println(application.getRealPath("/html/day3_1.html"));
		System.out.println(application.getResourcePaths("/WEB-INF"));
		//获取初始化参数
		System.out.println(application.getInitParameter("encoding"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
