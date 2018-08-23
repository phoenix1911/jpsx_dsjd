<%@page import="java.util.Date"%>
<%@page import="com.briup.day7.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jstl标签库</title>
<style type="text/css">
	table,tr,th,td{
		border:1px solid gray;
		border-spacing: 0px;
		width: 300px;
		height:30px;
		margin: 0px auto;
		text-align: center;
	}
</style>
</head>
<body>
	<table>
		<tr>
			<th>索引</th>
			<th>数量</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>性别</th>
			<th>map-key</th>
		</tr>
		<c:forEach items="${stusm }" var="stuEntry" varStatus="i">
			<tr>
				<td>${i.index+1 }</td>
				<td>${i.count }</td>
				<td>${stuEntry.value.name }</td>
				<td>${stuEntry.value["age"] }</td>
				<td>${stuEntry.value['gender'] }</td>
				<td>${stuEntry.key }</td>
			</tr>
		</c:forEach>
	</table>
	<hr/>
	<table>
		<tr>
			<th>索引set</th>
			<th>数量</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>性别</th>
		</tr>
		<c:forEach items="${stuss }" var="stu" varStatus="i">
			<tr>
				<td>${i.index }</td>
				<td>${i.count }</td>
				<td>${stu.name }</td>
				<td>${stu.age }</td>
				<td>${stu.gender }</td>
			</tr>
		</c:forEach>
	</table>
	<hr/>
	<h1>c:forEach</h1>
	<table>
		<tr>
			<th>索引</th>
			<th>数量</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>性别</th>
			<th>备注</th>
		</tr>
	<!--items:要迭代的对象
		var:迭代出的对象名,会被存放到pageContext范围中,key:var，在迭代结束后，会移除
		begin:从索引为begin的数据开始迭代，默认0
		end:迭代到索引为end结束，默认集合.size-1
		step: 下次迭代索引增加step,默认是1
		varSatus:保存迭代的状态,varSatus.index:当前迭代的数据在集合中的索引，.count：当前已迭代的第几条数据
		 -->
	<c:forEach items="${stusl }" var="stu" begin="1" step="2" end="4" varStatus="i">
		<tr>
			<td>${i.index }</td>
			<td>${i.count }</td>
			<td>${stu.name }</td>
			<td>${stu.age }</td>
			<td>${stu.gender }</td>
			<td><%=pageContext.getAttribute("stu") %></td>
		</tr>
	</c:forEach>
	</table>
	测试迭代结束后，是否还有stu的值：<%=pageContext.getAttribute("stu") %>
	<hr/>
	
	<table>
		<tr>
			<th>姓名</th>
			<th>年龄</th>
			<th>性别</th>
		</tr>
		<% 
			List<Student> stusl = (List<Student>)request.getAttribute("stusl");
			if(stusl!=null){
			for(Student s : stusl){
		%>		
			<tr>
				<td><%=s.getName() %></td>
				<td><%=s.getAge() %></td>
				<td><%=s.getGender() %></td>
			</tr>
		<%		
			}
			}
		%>
	</table>
	<h1>c:out</h1>
	<c:out value="hello"></c:out>
	<c:out value="${1+1 }"></c:out>
	<c:out value="${stusl[0].name }"></c:out>
	
	<h1>c:set</h1>
	<c:set var="h1" value="hello" scope="page"></c:set>
	<c:set var="h2" value="${stusl[0] }" scope="request"></c:set>
	h1: ${h1 }
	h2: ${h2 }
	
	<h1>c:remove</h1>
	<c:remove var="h1" scope="page"/>
	<c:remove var="h2" scope="page"/>
	h1: ${h1 }
	h2: ${h2 }
	
	<h1>c:if</h1>
	<%request.setAttribute("score", 60); %>
	<c:if test="${score>=60 }">
		<p><em>可以了</em></p>
	</c:if>
	<c:if test="${score<60 }">
		<p><em>不可以</em></p>
	</c:if>
	<!--如果当前有用户登录，显示：欢迎您,XXX|注销；
		没有用户登录  登录|没有账号?点击注册  -->
	<%session.setAttribute("user", new Student("tom",18,"F")); %>
	<c:if test="${empty sessionScope.user}">
		<a href="login.jsp">登录</a>|<a href="register.jsp">没有账号?点击注册</a>
	</c:if>
	<c:if test="${not empty user}">
		欢迎您,<a href="">${user.name }</a>|<a href="logout.do">注销</a>
	</c:if>
	
	<h2>c:import</h2>
	<c:import var="frjsp" url="form_Register.jsp"></c:import>
	
	<h2>c:catch</h2>
	<c:catch var="ex">
		<%int i = 10/0; %>
	</c:catch>
	<c:if test="${!empty ex}">
		${ex.message }
	</c:if>
	
	${frjsp }
	
	<h1>c:redirect</h1>
	<%-- <c:redirect url="form_Register.jsp"></c:redirect> --%>
	<h1>c:choose when othewise</h1>
	<%request.setAttribute("age", 60); %>
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
	
	<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
</body>
</html>