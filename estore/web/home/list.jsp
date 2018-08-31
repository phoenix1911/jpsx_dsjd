
<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8"%>
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
	<script src="home/public/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript">
		// 加入购物车的函数，参数是 编号
		function addShopCart(id) {

			/*******************************************************/
			/*******************************************************/
			/*********************《修改区域》**********************/
			/*******************************************************/
			var url = "shopcart?id=" + id;
			/*******************************************************/
			/*******************************************************/
			
			window.location = url;
		}
		$(function() {
			// 根据后台显示是否加入到购物车成功
			// if ("${requestScope.msg}" != "") {
			// 	alert("${requestScope.msg}");
			// }
		});
	</script>
</head>
<body>
	<!--顶部-->
	<div class="top">
		<div class="top_center">

			<!-- ******************************************************* -->
			<!-- ******************************************************* -->
			<!-- *********************《修改区域》********************** -->
			<!-- ******************************************************* -->
			<ul class="top_lr">
				<li><a>欢迎 张三</a></li>
			</ul>
			<ul class="top_bars">
				<!-- 此处需要改链接 -->
				<li><a href="login.html">退出</a>|</li>
				<!-- 此处需要改链接 -->
				<li><a href="myorder.html">我的订单<span class="jt_down"></span></a>|</li>
				<li><a href="javascript:void(0)">关注杰普<span class="jt_down"></span></a>|</li>
				<li><a href="javascript:void(0)">网站导航<span class="jt_down"></span></a></li>
			</ul>
			<!-- ******************************************************* -->
			<!-- ******************************************************* -->

		</div>
	</div>
	<!--头部-->
	<div class="header3">
		<!-- ******************************************************* -->
		<!-- 此处需要改链接 -->
		<a href="index.jsp"><img src="home/public/img/logo.png"></a>
		<!-- ******************************************************* -->
		<div class="h3_center">
			<div class="search_box">
				<input type="text"/>
				<span>搜索</span>
			</div>

			<!-- ******************************************************* -->
			<!-- ******************************************************* -->
			<!-- *********************《修改区域》********************** -->
			<!-- *************** 循环读取前第五个分类名 **************** -->
			<!-- ******************************************************* -->
			<p>
				<!-- 此处需要改链接 -->
				<a href="list.jsp">文学类</a>|
				<a href="list.jsp">教育类</a>|
				<a href="list.jsp">计算机</a>|
				<a href="list.jsp">儿童类</a>|
				<a href="list.jsp">漫画类</a>|
			</p>
			<!-- ******************************************************* -->
			<!-- ******************************************************* -->

		</div>
		<div class="h3_right">
			<div class="myyy">
				<!-- ******************************************************* -->
				<!-- 此处需要改链接 -->
				<a href="userinfo.html">个人信息</a>
				<!-- ******************************************************* -->
				<span class="sj_down"></span>
			 </div>
			<div class="tsc">
				<!-- ******************************************************* -->
				<!-- 此处需要改链接 -->
				<a href="shopcart.html">去购物车结算</a>
				<!-- ******************************************************* -->
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

			<!-- ******************************************************* -->
			<!-- ******************************************************* -->
			<!-- *********************《修改区域》********************** -->
			<!-- *************** 循环读取前第五个分类名 **************** -->
			<!-- ******************************************************* -->
			<ul>
				<!-- 此处需要改链接 -->
				<li><a href="list.jsp">文学类</a></li>
				<li><a href="list.jsp">教育类</a></li>
				<li><a href="list.jsp">计算机</a></li>
				<li><a href="list.jsp">儿童类</a></li>
				<li><a href="list.jsp">漫画类</a></li>
			</ul>
			<!-- ******************************************************* -->
			<!-- ******************************************************* -->

		</div>
	</div>
	
	<!--内容-->
	<div class="container4">

		<div class="c4_b2">
			<h1 class="c4_b2_x">
				<!-- ******************************************************* -->
				<!-- 此处需要改链接 -->
				<a href="index.jsp">首页&nbsp;&nbsp;></a>
				<!-- ******************************************************* -->
				<span><a href="javascript:void(0)">计算机类</a></span>
			</h1> 
		</div>
		<div class="c4_b4">
			 <div class="c4_b4_y">
				<ul>
					<li>&nbsp;&nbsp;&nbsp;&nbsp;计算机类</li>
				</ul>               
			</div>
		</div>
		<!--商品列表-->
		<div class="c4_b5">	
			<div class="c4_b5_content">

				<!-- ******************************************************* -->
				<!-- ******************************************************* -->
				<!-- *********************《修改区域》********************** -->
				<!-- ************** 循环读取此分类下所有书籍 *************** -->
				<!-- ******************************************************* -->
				<ul class="c4_b5_c_boxes">
					<li class="c4_b5_c_box">
						<!--图片-->
						<div class="c4_b5_c_box_pic">
							<div class="c4b5_pic_view">
								<!-- ******************************************************* -->
								<!-- 此处需要改链接 -->
								<a href="book.jsp"><img src="home/public/img/list_p1.png"></a>
								<!-- ******************************************************* -->
							</div>
						</div>
						<!--价钱-->
						<div class="c4_b5_c_box_txt">
							<h1>￥ 50</h1>
							<!-- ******************************************************* -->
							<!-- 此处需要改链接 -->
							<h2><a href="book.jsp">Java编程思想</a></h2>
							<!-- ******************************************************* -->
						</div>
						<!--购买等操作-->
						<ul class="c4b5_option">
						</ul>
					</li>

					<li class="c4_b5_c_box">
						<!--图片-->
						<div class="c4_b5_c_box_pic">
							<div class="c4b5_pic_view">
								<!-- ******************************************************* -->
								<!-- 此处需要改链接 -->
								<a href="book.jsp"><img src="home/public/img/list_p1.png"></a>
								<!-- ******************************************************* -->
							</div>
						</div>
						<!--价钱-->
						<div class="c4_b5_c_box_txt">
							<h1>￥ 50</h1>
							<!-- ******************************************************* -->
							<!-- 此处需要改链接 -->
							<h2><a href="book.jsp">Java编程思想</a></h2>
							<!-- ******************************************************* -->
						</div>
						<!--购买等操作-->
						<ul class="c4b5_option">
						</ul>
					</li>
				</ul>
				<!-- ******************************************************* -->
				<!-- ******************************************************* -->

			</div>
		</div>
	</div>

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