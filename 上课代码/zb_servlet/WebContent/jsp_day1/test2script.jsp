<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.briup.day6.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	table,th,td{
		border:1px solid gray;
		border-spacing:0px;
		text-align: center;
		height:80px;
		width:500px;
		margin: 0px auto;
	}
</style>
<title>jsp的三种脚本元素</title>
</head>
<body>
	<h2>1.表达式  :翻译到的位置：_jspServcie方法中的out.print(<q>就在这儿,原样输出</q>);</h2>
	<!--表达式: out.print(); -->
	<%="helloword" %>
	<%=1+1+"你好" %>
	<%=request.getServletPath() %>
	
	<h2>2.脚本 : 翻译到的位置，_jspServcie方法中，作为成员方法中的普通代码执行，原样执行</h2>
	<%System.out.println("脚本"); %>
	<%int i = 10;
	  int j = 20;
	%>
	<%=i %>
	<%
	User u1 = new User("张三3",12); 
	User u2 = new User("李四2",13); 
	User u3 = new User("王五1",10); 
	List<User> users = new ArrayList<User>();
	users.add(u1);
	users.add(u2);
	users.add(u3);
	%>
	<%=users %>
	
	<table>
		<tr>
			<th>姓名</th>
			<th>年龄</th>
		</tr>
		<%
			for(int k=0;k<users.size();k++){
		%>
			<tr>
				<td><%=users.get(k).getName() %></td>
				<td><%=users.get(k).getAge() %></td>
			</tr>
		<% } %>
		<!-- <tr>
			<td>张三</td>
			<td>12</td>
		</tr>
		<tr>
			<td>李四</td>
			<td>13</td>
		</tr>
		<tr>
			<td>王五</td>
			<td>10</td>
		</tr> -->
	</table>
	
	<%=gender %>
	<% //out.write(hello()); %>
	<h2>声明:翻译的位置：类体部，比如成员变量成员方法..</h2>
	<%!private String gender = "F"; 
	   public String hello(){
		   return "hello";
	   }
	%>
	<!--重写初始化、销毁的方法  -->
	<%!
		public void jspInit(){
			//System.out.println("*************");
			System.out.println("test2script.jsp初始化:"+getServletConfig().getServletName());
		}
	%>
	<%!
		public void jspDestroy(){
			System.out.println("test2script.jsp销毁");
		}
	%>
	
	
	
	
</body>
</html>