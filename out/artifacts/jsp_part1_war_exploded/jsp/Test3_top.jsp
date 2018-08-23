<%--
  User: TJL Date: 2018/8/22  Time: 14:35
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>top.jsp</title>
</head>
<body>
    <div class="one">
        <ul>
            <li>
                <p><a>导航1 addr:<%=request.getParameter("addr")%></a></p>
            </li>
            <li>
                <p><a>导航2 s1:<%=pageContext.getAttribute("u1")%></a></p>
            </li>
            <li>
                <p><a>导航3</a></p>
            </li>

        </ul>
    </div>
</body>
</html>
