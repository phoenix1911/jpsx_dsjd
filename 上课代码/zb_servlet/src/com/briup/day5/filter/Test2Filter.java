package com.briup.day5.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class Test2Filter
 */
public class Test2Filter implements Filter {

    public Test2Filter() {
    	System.out.println("过滤器2创建");
    }

	public void destroy() {
		System.out.println("过滤器2销毁");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("filter2开始处理请求");
		chain.doFilter(request, response);
		System.out.println("filter2处理请求结束");
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("过滤器2初始化");
	}

}
