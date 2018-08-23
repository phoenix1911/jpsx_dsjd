<%--
  User: TJL Date: 2018/8/22  Time: 15:00
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>链接发送请求</title>
</head>
<body>
    mark:<%=request.getAttribute("mark") %>
    addr:<%=request.getParameter("addr") %>
    date:<%=request.getParameter("date") %>
    class:<%=request.getParameter("class") %>
    test:<%=request.getParameter("test") %>
    <hr>
    <a href="Test4_action.jsp?name=zs&age=18">通过超链接发送请求</a>
    <form action="Test4_action.jsp">
        <input type="text" name="name">
        <input type="text" name="age">
        <input type="submit" value="提交">
    </form>
</body>
</html>
