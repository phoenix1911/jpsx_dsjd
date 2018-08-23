package com.briup.day4;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 测试会话范围:session
 * */
public class Test2SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Test2SessionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//session范围传递数据
		//会话的开启：第一次调用request.getSession()   30  session
		//会话的对象: HttpSession对象session
		//会话的结束：两次请求间隔超时30分钟
		//1.怎么获取session对象:request.getSession()
		//false:如果已有，使用已有的，如果没有，也不创建
		//true:如果已有，使用已有的，如果没有，就创建新的
		HttpSession session = request.getSession();
		System.out.println("第一次获取的session："+session.getId());
		
		//session的销毁
		//销毁情况1：超时
			//超时1：默认配置,30分钟,tomcat/conf/web.xml，该tomcat的所有应用
					/*<session-config>
			        		<session-timeout>30</session-timeout>
			    	 </session-config>*/
			//超时2：自己配置，单位是分钟,web.xml,当前Web应用； 自己配置>默认配置
		    //超时3：调用session对象的方法，单位是秒，当前session对象
//		session.setMaxInactiveInterval(5);
		//销毁情况2：主动销毁
//		session.invalidate();
		User user = new User();
		ArrayList<Object> list = new ArrayList<>();
		list.add(user);
		list.add("hello");
		list.add(10);
		//2.添加/替换/移除值
		session.setAttribute("names", "tom");
		session.setAttribute("names2", "tim");
		session.setAttribute("users", user);
		session.setAttribute("lists", list);
		
		session.setAttribute("names", "toms");
		session.removeAttribute("names2");
		
//		System.out.println(session.getAttribute("names"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
