package com.briup.day5.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//过滤器测试1
public class Test1Filter implements Filter{
	public Test1Filter(){
		System.out.println("过滤器1被创建");
	}
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("过滤器1初始化"+filterConfig.getFilterName()+",: "+
								filterConfig.getInitParameter("username"));
		
		
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("filter1开始处理request");
		String name = request.getParameter("name");
		//类型强制转换
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		System.out.println("filter1中获取的请求信息："+name+", "+req.getServletPath());
//		System.out.println("filter1只是简单做个记录，放行");
		
		//如果传递了name参数，放行，如果没有传递，跳转到html/day3_1.html
		if(name!=null){
			System.out.println("filte1放行");
			chain.doFilter(request, response);
		}else{
			System.out.println("filter1不放行，转发到day3_1.html");
			//重定向,小心死循环
//			resp.sendRedirect(req.getContextPath()+"/html/day3_1.html?name=zs");
			req.getRequestDispatcher("/html/day3_1.html").forward(request, response);;
		}
		
		System.out.println("filter1处理结束");
		
	}
	public void destroy() {
		System.out.println("过滤器1销毁");
	}

}
