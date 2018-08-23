<%--
  User: TJL Date: 2018/8/22  Time: 15:00
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
    <title>表单提交</title>
</head>
<body>
    <a href="register.servlet?name=张三&addr=太原&addr=大同">通过超链接发送请求</a>
    <form action="register.servlet">
        name:<input type="text" name="name" value="李四">
        addr:<input type="checkbox" name="addr" value="运城">
        <input type="checkbox" name="addr" value="晋中">
        <input type="submit" value="提交">
    </form>
</body>
</html>
