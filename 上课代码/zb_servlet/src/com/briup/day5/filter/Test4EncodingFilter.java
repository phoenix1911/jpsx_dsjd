package com.briup.day5.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 编码过滤器
 */
public class Test4EncodingFilter implements Filter {
	private String encoding;
    public Test4EncodingFilter() {
    	System.out.println("编码过滤器创建");
    }

	public void destroy() {
		System.out.println("编码过滤器销毁");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
		
	}
	public void init(FilterConfig fConfig) throws ServletException {
		encoding = fConfig.getInitParameter("encoding");
		System.out.println("编码过滤器初始化:"+encoding);
	}

}
