package com.briup.day5.listener;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

//javabean
public class UserWithListener implements Serializable,
					HttpSessionBindingListener,HttpSessionActivationListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private String gender;
	
	public UserWithListener() {
		
	}
	public UserWithListener(String name, int age, String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "UserWithListener [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	//钝化
	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("session钝化");
	}
	//活化	
	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("session活化");
		
	}
	//绑定 session.setAttribute("key",value)  value:是当前类型的对象 
	//登录成功,Customer,User,Student,Teacher
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.print("当前session范围内绑定了UserWithListener类型的值:"+this);
		System.out.println("bind event:"+event.getName()+"--"+event.getValue());
	}
	//解绑 session.removeAttribute("key")  value:是当前类型的对象 
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.print("当前session范围内解除绑定UserWithListener类型的值:"+this);
		System.out.println("bind event:"+event.getName()+"--"+event.getValue());
	}

}
