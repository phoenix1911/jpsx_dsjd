<%--
  User: TJL Date: 2018/8/23  Time: 9:09
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()+"://"
                    +request.getServerName()+":"
                    +request.getServerPort()
                    +request.getContextPath()+"/";

%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>基路径</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
    <a href=" ">跳转到test2_obj.jsp</a>
    <img alt="图片没有了" src="image/1.jpg">
</body>
</html>
