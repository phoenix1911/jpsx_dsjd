<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  //http://ip:port/projectName/
	String basePath = request.getScheme()+"://"
						+request.getServerName()+":"
						+request.getServerPort()
						+request.getContextPath()+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>基路径</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
	<%=basePath %>  <br/>  
	<a href="jsp_day2/test2_obj.jsp" target="_blank">跳转到test2_obj.jsp</a>
	<img alt="雪图没有了" src="images/sn1.jpg">
</body>
</html>