<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.briup.day7.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>el表达式</title>
</head>
<body>
	<h1>EL表达式</h1>
	<h2>1.获取请求中单一key映射的参数,request.getParameter("name")</h2>
	${param.name }
	${param.addr }<br/>
	<h2>2.获取请求中一个key映射多个值的参数,request.getParameterValues("addr")</h2>
	${paramValues.name[0] }
	${paramValues.addr[0] }
	${paramValues["addr"][1] }
	<hr/>
	<h2>3.获取范围对象中设置的值,pageContext/request/session/application.getAttribute("key")</h2>
	<%-- <% pageContext.setAttribute("name", "tom1"); %> 
	<% request.setAttribute("name", "tom2"); %>
	<% session.setAttribute("name", "tom3"); %>
	<% application.setAttribute("name", "tom4"); %> --%>
	
	<%=pageContext.getAttribute("name") %>
	<%=request.getAttribute("name") %>
	<%=session.getAttribute("name") %>
	<%=application.getAttribute("name") %>
	<hr/>
	${pageScope.name }
	${requestScope.name }
	${sessionScope.name }
	${applicationScope.name }
	<hr/>
	<h2>4.获取范围对象中设置的值，如果没有声明范围，从小到大找</h2>
	${name }
	<h2>5.获取范围对象中保存的对象类型的值,对象中属性值的获取</h2>
	${requestScope.student }
	${student }
	<br/>
	<%-- ${student.name }
	${student.addr[1] }
	${student.address } --%>
	
	<h2>6.输出字符等值</h2>
	${"hello world" }
	${123 }
	${1+1 }
	${(1+2)*3-2*2 }
	${1>2 }
	${empty "hello" }
	${empty 123 }
	<hr/>
	<% 
	Student stu = new Student();
	stu.setGender("F");
	stu.setAddr(new String[]{"榆次"});
	request.setAttribute("student", stu);%>
	${empty pageScope.student }
	${empty requestScope.student }
	${empty student }
	${not empty pageScope.student }
	${not empty requestScope.student }
	${not empty student }
	${1>2?'算错了':'算对了' }
	<input type="radio" name="gender" value="男" ${student.gender eq "男"?"checked":"" }>
	<input type="radio" name="gender" value="女" ${student.gender eq '女'?'checked':'' }>
	<select>
		<option ${student.addr[0] eq '晋中'?'selected':'' }>晋中</option>
		<option ${student.addr[0] eq '榆次'?'selected':'' }>榆次</option>
		<option ${student.addr[0] eq '运城'?'selected':'' }>运城</option>
	</select>
	
	<h2>7.输出数组/集合中的值</h2>
	<%
	Student s1 = new Student("张三",15,"F");
	Student s2 = new Student("李四",16,"M");
	Student s3 = new Student("王五",17,"F");
	Student[] stusA = {s1,s2,s3}; 
	request.setAttribute("stusA", stusA);
	
	List<Student> stusL = new ArrayList<Student>();
	stusL.add(s1);
	stusL.add(s2);
	stusL.add(s3);
	request.setAttribute("stusL", stusL);
	
	Map<String,Student> stusM = new HashMap<String,Student>();
	stusM.put("s1", s1);
	stusM.put("s2", s2);
	stusM.put("s3", s3);
	request.setAttribute("stusM", stusM);
	%>
	${stusA }<br/>
	${stusL }<br/>
	${stusM }<br/>
	
	${stusA[0] }<br/>
	${stusL[1] }<br/>
	${stusM["s3"] }
	${stusM['s3'] }
	${stusM.s3 }
	${stusM.s2 }
	
	
</body>
</html>