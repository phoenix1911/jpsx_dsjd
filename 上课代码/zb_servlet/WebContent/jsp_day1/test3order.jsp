<%@page import="java.util.List,java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.briup.day6.User,java.util.Date" 
    errorPage="error.jsp"%>
<%-- <%@ taglib prefix="" uri="" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>指令元素</title>
<style type="text/css">
	#main{
		width:400px;
		height:300px;
		margin:0px auto;
	}
	.one,.two,.three{
		border:1px solid red;
	}
</style>
</head>
<body>
	<h1>指令元素</h1>
	<h2>page</h2>
	<% 
		User u1 = new User("zs",15);
		Date date = new Date();
		List list = new ArrayList();
		//int i = 10/0;
	%>
	<%=u1 %><br/>
	<%=date %><br/>
	<%=list %><br/>
	<hr/>
	<div id="main">
		<!--静态包含,属于同一个pageContext范围  -->
		<jsp:useBean id="s1" class="com.briup.day6.User" scope="page"></jsp:useBean>
		main_s1:<%=pageContext.getAttribute("s1") %>
		<%@ include file="top.jsp" %>
		<div class="two">
			<ul>
				<li>
					<p>内容区域1</p>
				</li>
				<li>
					<p>内容区域2</p>
				</li>
				<li>
					<p>内容区域3</p>
				</li>
			</ul>
		</div>
		<div class="three">
			<p><em>版权所有.....</em></p>
		</div>
	</div>
	
</body>
</html>