<%@page import="com.briup.day6.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>动作指令</title>
</head>
<body>
	<%-- <%pageContext.setAttribute("s1", new User("zs",17)); %> --%>
	<h1>1.与javabean相关</h1>
	<h2>1.1javabean的存取</h2>
	<jsp:useBean id="s1" class="com.briup.day6.User" scope="page"></jsp:useBean>
	
	<%
		User s2 = null;
		s2 = (User)pageContext.getAttribute("s2");
		if(s2==null){
			s2 = new User();
			pageContext.setAttribute("s2", s2);
		}
	%>
	
	<h2>1.2javabean</h2>
	<!--1.与表单传参有关,? getParamter(String key-attribute)  
						自动匹配所有的属性-->
	<%-- <jsp:setProperty property="*" name="s1"/> --%>
	<!--2.给指定的property赋值  -->
	<%-- <jsp:setProperty property="age" name="s1"/> --%>
	<!--3.给指定的property赋值，使用指定的参数  -->
	<%-- <jsp:setProperty property="name" name="s1" param="age"/> --%>
	<!--4.给指定的property赋值，使用自定义的值  -->
	<jsp:setProperty property="name" name="s1" value="李四"/>
	<jsp:setProperty property="age" name="s1" value="16"/>
	
	s1_action:<jsp:getProperty property="name" name="s1"/><br/>
	s1:<%=s1 %><br/>
	s2:<%=s2 %><br/>
	
	<h2>内部跳转</h2>
	<%request.setAttribute("mark", "req");
	  request.setCharacterEncoding("utf-8");
	%>
	<%-- <jsp:forward page="form.jsp?addr=taiyuan&date=2018">
		<jsp:param value="一班" name="class"/>
	</jsp:forward> --%>
	
	<h2>动态包含，不属于同一个pageContext范围</h2>	
	<jsp:include page="top.jsp">
		<jsp:param value="taiyuan" name="addr"/>
	</jsp:include>
	
	<h2>输出一个标签</h2>
  	 <jsp:element name="h1">
		<jsp:attribute name="style">color:red;text-align:center;</jsp:attribute>
		<jsp:body>hello world</jsp:body>
   	</jsp:element>
	
	<!--<h1 style="color:red;text-align:center;">hello world</h1>  -->
	
	
</body>
</html>