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
	
	<!--4个范围对象  -->
	<% pageContext.setAttribute("name", "tom1"); %>
	<% request.setAttribute("name", "tom2"); %>
	<% session.setAttribute("name", "tom3"); %>
	<% application.setAttribute("name", "tom4"); %>
	
	<!--内部跳转  -->
	<%-- <jsp:forward page="test2_obj.jsp"></jsp:forward> --%>
	<%-- <%
		request.getRequestDispatcher("test2_obj.jsp").forward(request, response);
	%> --%>
	<!--重定向  -->
	<% 
		response.sendRedirect("test2_obj.jsp");
	%>
	
	
	
	
	
</body>
</html>