<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
	String basePath = request.getScheme()+"://"
						+request.getServerName()+":"
						+request.getServerPort()
						+request.getContextPath()+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>表单提交</title>
</head>
<body>
	<a href="register.do?name=张三&addr=太原&addr=大同">超链接发送请求</a>
	<form action="register.do">
		<input type="text" name="name" value="李四"><br/>
		<input type="checkbox" name="addr" value="运城">
		<input type="checkbox" name="addr" value="晋中"><br/>
		<input type="submit" value="提交">
	</form>
</body>
</html>