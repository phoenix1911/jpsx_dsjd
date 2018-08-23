<%@ page import="bean.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  User: TJL Date: 2018/8/23  Time: 9:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式</title>
</head>
<body>
    <h1>EL表达式</h1>

    <h2>1.获取请求中的参数 request.getParameter("name")</h2>
    <%--http://localhost:8080/jsp_part2/jsp/Test4_el.jsp?name=张三&addr=山西--%>
    ${param.name}
    ${param.addr}<br>

    <h2>2.获取请求中的参数 request.getParametervalues("addr")</h2>
    <%--http://localhost:8080/jsp_part2/jsp/Test4_el.jsp?name=张三&addr=山西&addr=江苏--%>
    ${paramValues.name[0]}
    ${paramValues.addr[0]}
    ${paramValues["addr"][1]}

    <h2>3.获取范围对象中设置的值,pageContext/request/session/application.getAttribute("key")</h2>
    <%--<%--%>
        <%--pageContext.setAttribute("name","tom1");--%>
        <%--request.setAttribute("name","tom2");--%>
        <%--session.setAttribute("name","tom3");--%>
        <%--application.setAttribute("name","tom4");--%>
    <%--%>--%>
    <%=pageContext.getAttribute("name")%>
    <%=request.getAttribute("name")%>
    <%=session.getAttribute("name")%>
    <%=application.getAttribute("name")%>
    <hr>
    ${pageScope.name}
    ${requestScope.name}
    ${sessionScope.name}
    ${applicationScope.name}

    <h2>4.获取范围对象中设置的值,如果没有声明范围,从小到大找</h2>
    ${name}

    <h2>5.获取范围对象中保存的对象类型的值</h2>
    ${requestScope.student}<br>
    ${student}<br>
    ${student.name}<br>
    ${student.addr}

    <h2>6.输出字符串</h2>
    ${"hello world "}<br>
    ${123}<br>
    ${1+1}<br>
    ${1>2}<br>
    ${empty "hello"}<br>
    ${empty 123}<br>
    ${empty student}<br>
    <hr>
    <%
        Student stu = new Student("张三","运城");
        stu.setGender("男");
        request.setAttribute("student",stu);%>
    ${1>2?'算错了':'算错了'}<br>

    男:<input type="radio" name="gender" value="男" ${student.gender eq '男'?'checked':''}>
    女:<input type="radio" name="gender" value="女" ${student.gender eq '女'?'checked':''}><br>

    <h2>7.输出数组,集合中的值</h2>
    <%
        Student s1 = new Student("zs", 18, "F");
        Student s2 = new Student("ls", 18, "M");
        Student s3 = new Student("ww", 18, "F");
        Student[] students = {s1, s2, s3};
       request.setAttribute("students",students);

        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        request.setAttribute("list",list);

        Map<String, Student> map = new HashMap<>();
        map.put("s1", s1);
        map.put("s2", s2);
        map.put("s3", s3);
        request.setAttribute("map",map);
    %>
    1 : ${students}<br>
    2 : ${list}<br>
    3 : ${map}<br>
    <hr>
    4 : ${students[0]}<br>
    5 : ${list[1]}<br>
    6 : ${map["s3"]}<br>
    7 : ${map.s3}<br>




</body>
</html>
