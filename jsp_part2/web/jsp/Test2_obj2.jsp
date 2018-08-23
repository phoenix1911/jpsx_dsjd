<%--
  User: TJL Date: 2018/8/23  Time: 8:48
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>九大内置对象2</title>
</head>
<body>
    <h1>四个范围对象</h1>
    <%
        pageContext.setAttribute("name", "tom1");
        request.setAttribute("name", "tom2");
        session.setAttribute("name", "tom3");
        application.setAttribute("name", "tom4");
    %>
    <!--内部跳转-->
    <jsp:forward page="Test2_obj2.jsp"></jsp:forward>

</body>
</html>
