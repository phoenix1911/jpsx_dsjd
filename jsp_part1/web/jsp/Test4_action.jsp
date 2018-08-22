<%@ page import="bean.User" %><%--
  User: TJL Date: 2018/8/22  Time: 14:46
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>动作指令</title>
</head>
<body>
    <%pageContext.setAttribute("u1",new User("zs",17));%>
    <h1>1.与javabean相关</h1>
    <h2>1.1与javabean存取相关</h2>
    <jsp:useBean id="u1" class="bean.User" scope="page"></jsp:useBean>
    <%
        User u2 = null;
        u2 = (User) pageContext.getAttribute("u2");
        if (u2 == null) {
            u2 = new User();
            pageContext.setAttribute("u2",u2);
        }

    %>
    <%=u1%><br>
    <%=u2%><br>

    <hr>
    <h2>1.2javabean</h2>
    <!--1.与表单传参有关,? getParamter(String key-attribute)
                        自动匹配所有的属性-->
    <%-- <jsp:setProperty property="*" name="u1"/> --%>
    <!--2.给指定的property赋值  -->
    <%-- <jsp:setProperty property="age" name="u1"/> --%>
    <!--3.给指定的property赋值，使用指定的参数  -->
    <%-- <jsp:setProperty property="name" name="u1" param="age"/> --%>
    <!--4.给指定的property赋值，使用自定义的值  -->
    <jsp:setProperty property="name" name="u1" value="李四"/>
    <jsp:setProperty property="age" name="u1" value="16"/>

    u1_action:<jsp:getProperty property="name" name="u1"/><br/>
    u1:<%=u1 %><br/>
    s2:<%=u2 %><br/>


    <h2>内部跳转</h2>
    <%request.setAttribute("mark", "req");
        request.setCharacterEncoding("utf-8");
    %>
    <%-- <jsp:forward page="form.jsp?addr=taiyuan&date=2018">
        <jsp:param value="一班" name="class"/>
    </jsp:forward> --%>

    <%--<h2>动态包含</h2>--%>
    <%--<jsp:include page="Test3_top.jsp">--%>
        <%--<jsp:param name="addr" value="taiy"--%>
    <%--</jsp:include>--%>

    <h2>动态包含，不属于同一个pageContext范围</h2>
    <jsp:include page="Test3_top.jsp">
        <jsp:param value="taiyuan" name="addr"/>
    </jsp:include>

    <h2>输出一个标签</h2>
    <jsp:element name="h1">
        <jsp:attribute name="style">color:red;text-align:center;</jsp:attribute>
        <jsp:body>hello world</jsp:body>
    </jsp:element>

    <!--<h1 style="color:red;text-align:center;">hello world</h1>  -->




</body>
</html>
