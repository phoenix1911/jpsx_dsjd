package com.briup.day5.listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * 与请求相关的监听器
 * */
public class Test1RequestListener implements ServletRequestListener, ServletRequestAttributeListener {
	public Test1RequestListener(){
		System.out.println("请求监听器创建");
	}
	//请求范围内，属性的添加setAttribute(key,value)
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("请求范围添加,key:"+srae.getName()+", value:"+srae.getValue());
	}

	//请求范围内，属性的删除removeAttribute(key);
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println("请求范围删除,key:"+srae.getName()+", value:"+srae.getValue());
	}

	//请求范围内，属性的替换setAttribute("key","")key:已有
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		
		System.out.println("请求范围参数替换,key: "+srae.getName()+
									 ",value: "+srae.getValue()+
							"，新值:"+srae.getServletRequest().getAttribute(srae.getName()));
	}

	//请求对象的销毁
	public void requestDestroyed(ServletRequestEvent sre) {
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
		System.out.println("请求对象销毁:"+request.getServletPath());
	}

	//请求对象的创建 
	public void requestInitialized(ServletRequestEvent sre) {
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
		System.out.println("请求对象创建:"+request.getServletPath());
	}

}
