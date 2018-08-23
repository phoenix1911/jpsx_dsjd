package com.briup.day3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 测试：请求参数的获取
 * */
public class Test1RequestParamter extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("接收到GET请求");
		//编码问题  [路径，编码]
		//GET:参数键值对拼接到url后边，参数不在请求体中
		//tomcat-server.xml:  URIEncoding="utf-8"
		//POST:参数键值对不在地址栏中，在请求体中
		//POST方式中文乱码:
		req.setCharacterEncoding("utf-8");
		
		//1.根据单一key参数名获取对应的请求参数
		String sid = req.getParameter("sid");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String time = req.getParameter("time");
		String hobby = req.getParameter("hobby");
		String address = req.getParameter("address");
		String self = req.getParameter("self");
		
		System.out.println("sid: "+sid);
		System.out.println("username: "+username);
		System.out.println("password: "+password);
		System.out.println("time: "+time);
		System.out.println("hobby: "+hobby);
		System.out.println("address: "+address);
		System.out.println("self: "+self);
		
		//2.相同key对应不同value，根据同一个key值获取所有匹配的参数值
		System.out.println("---");
		String[] hobbys = req.getParameterValues("hobby");
		System.out.println(Arrays.toString(hobbys));
		
		System.out.println("***");
		
		//3.获取所有参数的key值
		Enumeration<String> es = req.getParameterNames();
		while(es.hasMoreElements()){
			String paramKey = es.nextElement();
			System.out.println(paramKey+": "+Arrays.toString(req.getParameterValues(paramKey)));
		}
		
		
		System.out.println("###");
		//4.获取所有的参数键值对 key:参数键值对的键名,value:与之对应的所有参数值组成的字符串数组
		Map<String, String[]> parameterMap = req.getParameterMap();
		//获取map集合中的key值集合
		Set<String> paramKeys = parameterMap.keySet();
		//遍历获取每一个key,键名
		for(String paramKey : paramKeys){
			System.out.println(paramKey+": "+Arrays.toString(req.getParameterValues(paramKey)));
		}
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("接收到POST请求");
		doGet(req, resp);
	}
	
}
