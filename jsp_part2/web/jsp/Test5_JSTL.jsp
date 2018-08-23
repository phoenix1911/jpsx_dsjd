<%@ page import="bean.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %><%--
  User: TJL Date: 2018/8/23  Time: 14:02
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入JSTL核心标签库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<body>
<table>
    <tr>
        <th>索引</th>
        <th>数量</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>key</th>
    </tr>

    <%--遍历写法一--%>
    <%--<%--%>
    <%--List<Student> studentlist = (List<Student>) request.getAttribute("studentlist");--%>
    <%--for (Student s : studentlist) {--%>
    <%--%>--%>
    <%--<tr>--%>
    <%--<td><%=s.getName()%></td>--%>
    <%--<td><%=s.getAge()%></td>--%>
    <%--<td><%=s.getGender()%></td>--%>
    <%--</tr>--%>
    <%--<%--%>
    <%--}--%>
    <%--%>--%>


    <%--遍历写法2--%>
    <%--items:要迭代的对象
        var:迭代出的对象名(类似foreach)
        begin:从索引为begin的数据开始迭代
        end:迭代到索引为end结束,默认集合.siZe-1
        step:下次迭代索引增加step,默认1
        varStatus:保存迭代的状态,varSatus.index:当前迭代的数据在集合中的索引
    --%>
    <c:forEach items="${studentlist}" var="stu" begin="0" step="1" end="5" varStatus="i">
        <tr>
            <td>${i.index}</td>
            <td>${i.count}</td>
            <td>${stu.name}</td>
            <td>${stu.age}</td>
            <td>${stu.gender}</td>
        </tr>
    </c:forEach>
    <tr>

    </tr>
    <c:forEach items="${map}" var="stuEntry" begin="0" step="1" end="5" varStatus="i">
        <tr>
            <td>${i.index+1}</td>
            <td>${i.count}</td>
            <td>${stuEntry.value.name}</td>
            <td>${stuEntry.value["age"]}</td>
            <td>${stuEntry.value["gender"]}</td>
            <td>${stuEntry.key}</td>

        </tr>
    </c:forEach>
</table>
<h1>c:out</h1>
<c:out value="hello"/><br>
<c:out value="${1+1}"/><br>
<c:out value="${studentlist[0]}"/>

<h1>c:set</h1>
<c:set var="h1" value="hello" scope="page"/>
<c:set var="h2" value="${studentlist[0]}" scope="request"/>
h1:${h1}<br>
h2:${h2}

<h1>c:remove</h1>
<c:remove var="h1" scope="page"/>
<c:remove var="h2" scope="page"/>
h1:${h1}<br>
h2:${h2}

<h1>c:if</h1>
<%
    request.setAttribute("score",80);
%>
<c:if test="${score>60}">
    <p><em>大于60</em></p>
</c:if>
<c:if test="${score<60}">
    <p><em>小于60</em></p>
</c:if>

<%--如果当前有用户登陆,显示:欢迎您,xxx|注销;
    如果没有用户登陆 登陆|没有账号?点击注册--%>
<%
    session.setAttribute("user",new Student("tom",18,"F"));
%>
<c:if test="${empty sessionScope.user}">
    <a href="login.jsp">登录</a>|<a href="register.jsp">没有账号?点击注册</a>
</c:if>
<c:if test="${not empty user}">
    欢迎您,<a href="">${user.name }</a>|<a href="logout.do">注销</a>
</c:if>


<h2>c:catch</h2>

<c:catch var="ex">
    <%int i = 10/0; %>
</c:catch>
<c:if test="${!empty ex}">
    ${ex.message }
</c:if>


<h2>c:import</h2>
<c:import var="frjsp" url="Test4_form.jsp"></c:import>
${frjsp }

<h1>c:redirect标签重定向</h1>
<%-- <c:redirect url="form_Register.jsp"></c:redirect> --%>

<h1>c:choose when othewise</h1>
<%request.setAttribute("age", 19); %>
<c:choose>
    <c:when test="${age<15 && age>=0}">
        儿童
    </c:when>
    <c:when test="${age>=15 && age<20 }">
        豆蔻
    </c:when>
    <c:when test="${age>=20 && age<30 }">
        弱冠
    </c:when>
    <c:when test="${age>=30 && age<40 }">
        而立
    </c:when>
    <c:otherwise>
        自己下去查
    </c:otherwise>
</c:choose>
<h2>fmt</h2>
<% request.setAttribute("time", new Date()); %>
${time }

<fmt:formatDate value="${time }" pattern="yyyy-MM-dd HH:mm:ss"/>

</body>
<head>
    <title>JSTL标签库</title>
    <style type="text/css">
        table,tr,td {
            border: 1px solid gray;
            border-spacing: 0px;
            width: 300px;
            height: 30px;
            margin: 0px auto;
            text-align: center;
        }
    </style>
</head>
</html>
