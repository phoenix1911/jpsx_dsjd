package com.briup.day5.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 日志过滤器：记录所有的请求信息
 */
public class Test3LogFilter implements Filter {

    public Test3LogFilter() {
    	System.out.println("日志过滤器创建");
    }

	public void destroy() {
		System.out.println("日志过滤器销毁");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//获取系统当前时间毫秒数
		long start = System.currentTimeMillis();
		System.out.println("log: 本次请求的路径:"+((HttpServletRequest)request).getServletPath());
		
		chain.doFilter(request, response);
	
		long end = System.currentTimeMillis();
		System.out.println("log: 本次请求花费时间："+(end-start));
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("日志过滤器初始化");
	}

}
