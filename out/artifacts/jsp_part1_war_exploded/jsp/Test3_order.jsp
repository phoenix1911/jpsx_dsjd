<%@ page import="bean.User" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%--
  User: TJL Date: 2018/8/22  Time: 14:15
--%>
<%@ page errorPage="Test3_error.jsp" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>指令元素</title>
    <style type="text/css">
        #main{
            width:400px;
            height:300px;
            margin:0px auto;
        }
        .one,.two,.three{
            border:1px solid red;
        }

    </style>
</head>
<body>
    <h1>指令元素</h1>
    <h2>page</h2>
    <%
        User u1 = new User("zs", 15);
        Date date = new Date();
        List list = new ArrayList<>();
//        int i= 1/0;
    %>
    <%=u1%><br>
    <%=date%><br>
    <%=list%><br>
    <hr>
    <div id="main">
        <%--静态包含--%>
    <%@ include file="Test3_top.jsp"%>
    <div class="two">
        <ul>
            <li>
                <p>内容区域1</p>
            </li>
            <li>
                <p>内容区域2</p>
            </li>
            <li>
                <p>内容区域3</p>
            </li>
        </ul>
    </div>
    <div class="three">
        <p><em>版权所有</em></p>
    </div>
    </div>
</body>
</html>
