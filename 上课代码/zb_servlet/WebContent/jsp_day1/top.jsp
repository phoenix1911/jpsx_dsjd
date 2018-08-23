<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <div class="one">
			<ul>
				<li>
					<a href="">导航链接1,addr:<%=request.getParameter("addr") %></a>
				</li>
				<li>
					<a href="">导航链接2,s1:<%=pageContext.getAttribute("s1") %></a>
				</li>
				<li>
					<a href="">导航链接3</a>
				</li>
			</ul>
		</div>
