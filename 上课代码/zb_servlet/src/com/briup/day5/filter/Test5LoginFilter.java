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
import javax.servlet.http.HttpSession;

/**
 * 权限过滤器：/user/* 必须有用户登录
 */
public class Test5LoginFilter implements Filter {

    public Test5LoginFilter() {
    	System.out.println("权限过滤器创建");
    }
	public void destroy() {
		System.out.println("权限过滤器销毁");
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//如果当前请求对应的客户端已有用户登录，放行，反之，跳转到登录页面去
		//登录成功，就会以key值为user，将当前登录用户存到session范围中
		//类型转换
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		//获取session，如果已有，获取已有的；如果没有，也不创建，为 null
		HttpSession session = req.getSession(false);
		if(session==null){
			System.out.println("当前无session，跳转到登录页面:");
			resp.sendRedirect(req.getContextPath()+"/html/login.html");
		}else{
			System.out.println("当前有session，已有会话，继续判断是否有user为key的值");
			if(session.getAttribute("user")!=null){
				System.out.println("当前已有用户登录，放行:");
				chain.doFilter(req, resp);
			}else{
				System.out.println("有session，但是没有用户，跳转到登录页面");
				resp.sendRedirect(req.getContextPath()+"/html/login.html");
			}
		}
		/*if(session!=null && session.getAttribute("user")!=null){
			chain.doFilter(req, resp);
		}else{
			System.out.println("没登录，跳转登录页");
			resp.sendRedirect(req.getContextPath()+"/login.html");
		}*/
	}
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("权限过滤器初始化");
	}

}
