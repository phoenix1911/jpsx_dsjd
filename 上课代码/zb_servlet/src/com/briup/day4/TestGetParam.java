package com.briup.day4;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 测试其他请求中是否可以获取到参数
 * */
public class TestGetParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TestGetParam() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("**************************");
		//获取请求范围中的参数
		//1.请求对象的获取：参数中有
		//2.调用方法
		/*Object namer = request.getAttribute("namer");
		Object namer2 = request.getAttribute("namer2");
		Object userr = request.getAttribute("userr");
		Object listr = request.getAttribute("listr");
		System.out.println("request范围：namer: "+namer);
		System.out.println("request范围：namer2: "+namer2);
		System.out.println("request范围：userr: "+userr);
		System.out.println("request范围：listr: "+listr);*/
		
		//获取会话范围中的参数
		HttpSession session = request.getSession();
		System.out.println("getParam中的session："+session.getId());
		Object names = session.getAttribute("names");
		Object users = session.getAttribute("users");
		Object lists = session.getAttribute("lists");
		System.out.println("session范围中取值:");
		System.out.println("names: "+names);
		System.out.println("users: "+users);
		System.out.println("lists: "+lists);
		//获取会话范围中所有的参数key值
		Enumeration<String> es = session.getAttributeNames();
		while(es.hasMoreElements()){
			String key = es.nextElement();
			System.out.println(key+": "+session.getAttribute(key));
		}
		
		//获取上下文环境中的参数
		//获取上下文对象
		/*ServletContext application = getServletContext();
		//获取参数
		Object namea = application.getAttribute("namea");
		Object namea2 = application.getAttribute("namea2");
		Object usera = application.getAttribute("usera");
		Object lista = application.getAttribute("lista");
		System.out.println("application范围中的值，是否可以获取到:");
		System.out.println("namea: "+namea);
		System.out.println("namea2: "+namea2);
		System.out.println("usera: "+usera);
		System.out.println("lista: "+lista);*/
		
//		Enumeration<String> es = application.getAttributeNames();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
