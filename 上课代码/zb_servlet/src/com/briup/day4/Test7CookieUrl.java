package com.briup.day4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 测试url重写
 */
public class Test7CookieUrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Test7CookieUrl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("test7接收到请求");
		System.out.println("**************************");
		HttpSession session = request.getSession();
		System.out.println("JSESSIONID:"+session.getId());
		//获取请求中携带的cookie
		Cookie[] cookies = request.getCookies();
		if(cookies!=null && cookies.length>0){
			for(Cookie c : cookies){
				System.out.println("请求中的cookie:"+c.getName()+"---"+c.getValue());
			}//localhost:8888/zb_servlet/urlcookie
		}
		System.out.println("****************************");
		//URL重写
		//设置编码
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取输出流
		PrintWriter pw = response.getWriter();
		String path = "urlcookie";
		//重写URL		
//		path = response.encodeURL(path);
		pw.print("<html><head><title>url重写</title></head><body>");
		//页面中有一个超链接,页面上所有的链接地址都进行重写
		pw.print("<a href='"+response.encodeURL(path)+"'>是否有JSESSIONID拼接</a>");
		//思考：跳转 html<如果html页面上能写java代码的话>:jsp
		pw.print("</body></html>");
		pw.flush();
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
