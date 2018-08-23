<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>链接发送请求</title>
</head>
<body>
	mark:<%=request.getAttribute("mark") %>
	addr:<%=request.getParameter("addr") %>
	date:<%=request.getParameter("date") %>
	class:<%=request.getParameter("class") %>
	test:<%=request.getParameter("test") %>
	<hr/>
	<a href="test4action.jsp?name=zs&age=18">通过超链接发送请求</a>
	<form action="test4action.jsp">
		<input type="text" name="name" value="张三"><br/>
		<input type="text" name="age" value="19"><br/>
		<input type="submit" value="提交">
	</form>

</body>
</html>