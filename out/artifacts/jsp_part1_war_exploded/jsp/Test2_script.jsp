<%@ page import="bean.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/22  Time: 10:27
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp的三种脚本元素</title>
</head>
<body>
    <h1>1.表达式:<%=" "%>,翻译到的位置:_jspServcie方法种的out.print(<q>就在这儿,原样输出</q>)</h1>
        <%--表达式:out.print();--%>
        <%="helloword" %>
        <%=1+1+"你好" %>
    <h2>2.脚本:翻译到位置,_jspServcie方法中,作为成员方法中的普通代码执行,原样执行|</h2>
        <%
            System.out.println("脚本");
            int i = 10;
            int j = 20;
        %>
        <%=i %>
        <%
            User u1 = new User("张三",12);
            User u2 = new User("李四",13);
            User u3 = new User("王五",10);
            User u4 = new User("阿胶",90);
            List<User> users = new ArrayList<>();
            users.add(u1);
            users.add(u2);
            users.add(u3);
            users.add(u4);
        %>
        <%=users%>

    <h1>声明:翻译的位置,类体部,比如成员变量成员方法</h1>
    <%!
        private String gender = "F";
        public String hello() {
            return "hello";
        }
    %>
    <%=gender%>
    <%out.write(hello());%>

    <%--重写初始化,销毁的方法--%>
    <%!
        public void jspInit(){
            System.out.println("Test2_script.jsp初始化:"+getServletInfo());
        }
        public void jspDestory(){
            System.out.println("Test2_script.jsp销毁");
        }
    %>
</body>
</html>
