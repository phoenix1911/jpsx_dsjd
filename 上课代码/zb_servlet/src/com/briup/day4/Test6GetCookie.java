package com.briup.day4;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取cookie
 */
public class Test6GetCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Test6GetCookie() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.getSession();
		//cookie的获取
		//获取所有cookie[k=v]
		//请求会携带"当前路径以及祖先路径下的cookie"
		Cookie[] cookies = request.getCookies();
		System.out.println("******");
		if(cookies!=null && cookies.length>0){
			for(Cookie c : cookies ){
				System.out.println(c.getName()+": "+URLDecoder.decode(c.getValue(), "utf-8"));
				//删除username这个cookie
				if(c.getName().equals("username")){
					c.setMaxAge(0);
					response.addCookie(c);
				}
			}
		}
		//删除cookie:再写一个同样key，同样path的cookie，时间设置为0
		Cookie delPwd = new Cookie("password", "");
		delPwd.setMaxAge(0);
		response.addCookie(delPwd);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
