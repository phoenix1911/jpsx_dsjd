package com.briup.day4;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 测试cookie:jessionid
 */
public class Test5Cookie1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Test5Cookie1() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("请求到达cookie1");
		HttpSession session = request.getSession();
		System.out.println("生成session:"+session.getId());
		//JSESSIONID  path
		//自定义Cookie
		//1.创建cookie对象,value如果是汉字，需要进行编码
		Cookie c1 = new Cookie("username", URLEncoder.encode("张三", "utf-8"));
		Cookie c2 = new Cookie("password", "zs123");
		//2.给cookie设置最大存活时间，单位是秒;如果不设置/负数，为会话cookie  0:立即删除
		c1.setMaxAge(60*60*24*7);
		c2.setMaxAge(60*60*24*7);
		//2.5设置cookie的路径，默认和当前请求一致
//		c1.setPath("/");
//		c1.setPath("/qt_servlet");
//		c1.setPath("/zb_servlet/");//不设置默认
		
		//3.使用response将cookie写到客户端浏览器
		response.addCookie(c1);
		response.addCookie(c2);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
