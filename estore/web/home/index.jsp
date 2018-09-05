<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName()
			+ ":" + request.getServerPort() + path + "/";
%>
<!doctype html>
<html lang="en">
<head>
	<!-- 注意这里的 bese标签 要保留 -->
	<base href="<%= basePath %>">
	<meta charset="UTF-8">
	<title>briup电子商务-首页</title>
	<link rel="stylesheet" href="home/public/css/common.css"/>
	<link rel="stylesheet" href="home/public/css/style.css" />
	<link rel="stylesheet" href="home/public/css/icons.css" />
	<link rel="stylesheet" href="home/public/css/table.css" />
	<link rel="stylesheet" href="home/public/css/banner.css">
	<link rel="stylesheet" href="home/public/css/text.css">
	<script src="home/public/js/jquery-1.8.3.min.js"></script>
	<script src="home/public/js/banner.js"></script>
</head>
<body>
	<!--顶部-->
	<div class="top">
		<div class="top_center">

			<ul class="top_bars">
				<c:if test="${sessionScope.user!=null}">
                    <li><a href="Outlogin">退出</a> </li>
                </c:if>
				<c:if test="${sessionScope.user!=null}">
					<li><a href="showOrderline.servlet">查看我的订单</a></li>
				</c:if>
				<li><a href="javascript:void(0)">关注杰普<span class="jt_down"></span></a>|</li>
				<li><a href="javascript:void(0)">网站导航<span class="jt_down"></span></a></li>
			</ul>
            <ul class="top_lr">
                <c:if test="${sessionScope.user!=null}">
                    <li><a>欢迎 ${sessionScope.user.username}</a></li>
                </c:if>
                <c:if test="${sessionScope.user ==null}">
                <li><a href="home/login.jsp" style="color: red;">亲,请登入</a></li>
                <li><a href="home/register.jsp">免费注册</a></li>
                </c:if>
            </ul>

		</div>
	</div>
	<!--头部-->
	<div class="header3">
		<!-- 此处需要改链接 -->
		<a href="home/index.jsp"><img src="home/public/img/logo.png"></a>
		<div class="h3_center">
			<div class="search_box">
				<input type="text"/>
				<span>搜索</span>
			</div>
			<p>
				<%--搜索框下的--%>
			<c:forEach items="${sessionScope.row5Categoty}" var="category">
				<a href="list.servlet?categoryid=${category.id}">${category.name}|</a>
			</c:forEach>
			</p>


		</div>
		<div class="h3_right">
			<div class="myyy">
				<!-- 此处需要改链接 -->
				<a href="home/userinfo.jsp">个人信息</a>
				<span class="sj_down"></span>
			 </div>
			<div class="tsc">
				<!-- 此处需要改链接 -->
				<a href="shopcart.servlet">去购物车结算</a>
				<span class="sj_right"> </span>
			</div>
		</div>
	</div>
	<!--头部导航-->
	<div class="nav_top">
		<div class="nav_top_center">
			<div>
				全部图书分类
			</div>

			<ul>
				<!-- 此处需要改链接 -->
				<c:forEach items="${sessionScope.allCategory}" var="category">
					<li><a href="list.servlet?categoryid=${category.id}">${category.name}</a></li>
				</c:forEach>

			</ul>


		</div>
	</div>
	
	<div class="container3">
		<div class="c3_b1">
			<div class="c3_b1_left">

				<!-- ******************************************************* -->
				<!-- ******************************************************* -->
				<!-- *********************《修改区域》********************** -->
				<!-- *************** 循环读取五～七个分类名 **************** -->
				<!-- ******************************************************* -->
				<dl>
					<c:forEach items="${sessionScope.allCategory}" var="category">
					<dd>
						<h1><a href="list.servlet?categoryid=${category.id}">${category.name}</a></h1>
						<p>
							<a href="book.servlet?bookid=${category.books[0].id}">${category.books[0].name}</a>
							<a href="book.servlet?bookid=${category.books[0].id}">${category.books[1].name}</a>
							</p>
					</dd>
					</c:forEach>
				</dl>
				<!-- ******************************************************* -->
				<!-- ******************************************************* -->

			</div>
			<div class="c3_b1_center">
				<div>
					<!-- <img src="public/img/ad1.png" alt=""> -->
					<!-- 轮播图开始 -->
					<div id="banner">  
						<div id="banner_bg">       
						</div>
						<!--标题背景-->
						<div id="banner_info"> 
						</div>
						<!--标题-->
						<ul>   
							<li class="on">1</li>
							<li>2</li>
							<li>3</li>
						</ul>

						<div id="banner_list">
							<a href="#" target="_blank"><img src="home/public/img/ad1.jpg" title="杰普Estore网上书城" alt="杰普Estore网上书城"></a>
							<a href="#" target="_blank"><img src="home/public/img/ad2.jpg" title="杰普Estore网上书城" alt="杰普Estore网上书城"></a>
							<a href="#" target="_blank"><img src="home/public/img/ad3.jpg" title="杰普Estore网上书城" alt="杰普Estore网上书城"></a>
						</div>
					</div>   
					<!-- 轮播图开始 -->
				</div>

				<!-- ******************************************************* -->
				<!-- ******************************************************* -->
				<!-- *********************《修改区域》********************** -->
				<!-- *************** 循环读取三本畅销的书籍 **************** -->
				<!-- ******************************************************* -->
				<div class="c3_b1_c_bottom">
					<ul>
						<c:forEach items="${sessionScope.BestSeller3Books}" var="book">
						<li>
							<!-- 此处需要改链接 -->
							<a href="book.servlet?bookid=${book.id}"><img src="home/public/img/p01.png"/></a>
							<a href="book.servlet?bookid=${book.id}">${book.name}</a>
						</li>
						</c:forEach>
					</ul>
				</div>
				<!-- ******************************************************* -->
				<!-- ******************************************************* -->

			</div>
			<div class="c3_b1_right">
				<h1>杰普快报<a href="javascript:void(0)">更多</a></h1>
				<ul>
					<li><a href="javascript:void(0)">〈加措〉相信这一切都是对我们最好的安排  </a></li>
					<li><a href="javascript:void(0)">〈加措〉相信这一切都是对我们最好的安排  </a></li>
					<li><a href="javascript:void(0)">〈加措〉相信这一切都是对我们最好的安排  </a></li>
					<li><a href="javascript:void(0)">〈加措〉相信这一切都是对我们最好的安排  </a></li>
					<li><a href="javascript:void(0)">〈加措〉相信这一切都是对我们最好的安排  </a></li>
					<li><a href="javascript:void(0)">〈加措〉相信这一切都是对我们最好的安排  </a></li>
					<li><a href="javascript:void(0)">〈加措〉相信这一切都是对我们最好的安排  </a></li>
					<li><a href="javascript:void(0)">〈加措〉相信这一切都是对我们最好的安排  </a></li>
					<li><a href="javascript:void(0)">〈加措〉相信这一切都是对我们最好的安排  </a></li>
					<li><a href="javascript:void(0)">〈加措〉相信这一切都是对我们最好的安排  </a></li>
					<li><a href="javascript:void(0)">〈加措〉相信这一切都是对我们最好的安排  </a></li>
					<li><a href="javascript:void(0)">〈加措〉相信这一切都是对我们最好的安排  </a></li>
					<li><a href="javascript:void(0)">〈加措〉相信这一切都是对我们最好的安排  </a></li>
					<li><a href="javascript:void(0)">〈加措〉相信这一切都是对我们最好的安排  </a></li>
					<li><a href="javascript:void(0)">〈加措〉相信这一切都是对我们最好的安排  </a></li>
				</ul>
			</div>
			<div style="clear:both"></div>
		</div>

		<!-- ******************************************************* -->
		<!-- ******************************************************* -->
		<!-- *********************《修改区域》********************** -->
		<!-- *************** 循环读取所有的推荐书籍 **************** -->
		<!-- ******************************************************* -->
		<div class="c3_b2">
			<ul>
				<c:forEach items="${sessionScope.recommendedBooks}" var="book">
				<li>

					<div class="c3_b2_txt">
						<h1 class="rebook">${book.name}</h1>
						<p>
							<c:choose>
								<c:when test="${book.categoryid==1 }">文学类</c:when>
								<c:when test="${book.categoryid==2 }">教育类</c:when>
								<c:when test="${book.categoryid==3 }">计算机类</c:when>
								<c:when test="${book.categoryid==4 }">儿童类</c:when>
								<c:when test="${book.categoryid==5 }">漫画类</c:when>
								<c:when test="${book.categoryid==6 }">工具类</c:when>
								<c:when test="${book.categoryid==7 }">期刊类</c:when>
								<c:otherwise>其他</c:otherwise>
							</c:choose>
						</p>
						<h2>推荐书籍</h2>
						<h2>全新内容，全新体验，就在杰普商城</h2>
						<p><a href="#">更多精彩，点击进入</a></p>
					</div>

				</li>
				</c:forEach>
			</ul>
		</div>
		<!-- ******************************************************* -->
		<!-- ******************************************************* -->
	
	</div>
	<div class="c20"></div>
	<!--脚部-->
	<div class="footer3">
		<div class="f3_top">
			<div class="f3_center">
				<div class="ts1">品目繁多 愉悦购物</div>
				<div class="ts2">正品保障 天天低价</div>
				<div class="ts3">极速物流 特色定制</div>
				<div class="ts4">优质服务 以客为尊</div>
			</div>
		</div>
		<div class="f3_middle">
			<ul class="f3_center">
				<li class="f3_mi_li01">
					<h1>购物指南</h1>
					<p>常见问题</p>
					<p>找回密码</p>
					<p>会员介绍</p>
					<p>购物演示</p>
				</li>
				<li class="f3_mi_li01">
					<h1>配送方式</h1>
					<p>常见问题</p>
					<p>找回密码</p>
					<p>会员介绍</p>
					<p>购物演示</p>
				</li>
				<li class="f3_mi_li01">
					<h1>支付方式</h1>
					<p>常见问题</p>
					<p>找回密码</p>
					<p>会员介绍</p>
					<p>购物演示</p>
				</li>
				<li class="f3_mi_li01">
					<h1>售后服务</h1>
					<p>常见问题</p>
					<p>找回密码</p>
					<p>会员介绍</p>
					<p>购物演示</p>
				</li>
				<li class="f3_mi_li01">
					<h1>服务保障</h1>
					<p>常见问题</p>
					<p>找回密码</p>
					<p>会员介绍</p>
					<p>购物演示</p>
				</li>
				<li class="f3_mi_li06">
					<h1>客服中心</h1>
					<img src="home/public/img/qrcode_jprj.jpg" width="80px" height="80px">
					<p>抢红包、疑问咨询、优惠活动</p>
				</li>
			</ul>
		</div>
		<div class="f3_bottom">
			<p class="f3_links">
				<a href="javascript:void(0)">关于我们</a>|
				<a href="javascript:void(0)">联系我们</a>|
				<a href="javascript:void(0)">友情链接</a>|
				<a href="javascript:void(0)">供货商入驻</a> 
			</p>
			<p>沪ICP备14033591号-8 杰普briup.com版权所有 杰普软件科技有限公司 </p>
			<img src="home/public/img/police.png">
		</div>
	</div>

</body>
</html>
