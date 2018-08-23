<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP的九大内置对象</title>
</head>
<body>
	<h1>九大内置对象</h1>
	<!--只要成功访问一个jsp页面，就会生成session  -->
	pageContext:<%=pageContext %> <br/>
	request:<%=request %><br/>
	session:<%=session %><br/>
	application:<%=application %><br/>
	response:<%=response %><br/>
	out:<%=out %><br/>
	config:<%=config %><br/>
	page:<%=page %><br/>
	exception:<%=exception %><br/>
	
	<!--4个范围对象  -->
	<%-- <% pageContext.setAttribute("name", "tom1"); %>
	<% request.setAttribute("name", "tom2"); %>
	<% session.setAttribute("name", "tom3"); %>
	<% application.setAttribute("name", "tom4"); %> --%>
	
	<%=pageContext.getAttribute("name") %>
	<%=request.getAttribute("name") %>
	<%=session.getAttribute("name") %>
	<%=application.getAttribute("name") %>
	
	<%-- <%response.sendRedirect("") %> --%>
	<%-- 123   ==  <%out.write("123"); %> --%>
	<%=config.getServletName() %>
	
	
	
	
</body>
</html>