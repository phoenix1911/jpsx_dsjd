
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
	<title>briup安全中心</title>
	<link rel="stylesheet" href="home/public/css/common.css"/>
	<link rel="stylesheet" href="home/public/css/style.css" />
	<link rel="stylesheet" href="home/public/css/icons.css" />
	<link rel="stylesheet" href="home/public/css/table.css" />
	<link rel="stylesheet" href="home/public/css/newmain.css" />
	<link rel="stylesheet" href="home/public/css/edit.css" />
	<script src="home/public/js/jquery-1.8.3.min.js"></script>
	<script>
		$(function () {
			// 根据后台显示是否修改成功
			 if ("${requestScope.msg}" != "") {
			 	alert("${requestScope.msg}");
			 }
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
	<div class="container4">
		<div class="register_box">
			<div class="head">
				<!-- 此处需要改链接 -->
				<h3><a href="userinfo.html">个人信息</a>&nbsp;&nbsp;&nbsp;修改密码</h3>
			</div>
			<div class="security">

				<!-- ******************************************************* -->
				<!-- ******************************************************* -->
				<!-- *********************《修改区域》********************** -->
				<!-- ******************************************************* -->
				<!-- 此处需要改action -->
				<form action="updateUserPwdServlet" method="post">
					<ul class="list">
						<input type="hidden" name="username" value="${sessionScope.user.username}">
						<li>
								<!-- 此处需要改name属性 -->
								<input id="J_euserName" class="long" name="oldpassword" value="" type="password" />
								<div class="name">旧密码:</div>
								<span id="J_eUserNameTipImg" class="icon"></span>
								<div id="J_eUserNameTipInfo" class="ltip"></div>
								<span class="placeholder" style="position: absolute;z-index: 20;color: rgb(153,153,153);top: 14px;left: 345px;line-height: 37px;"></span>
						</li>
						<li>
								<!-- 此处需要改name属性 -->
								<input id="J_euserName" class="long" name="newpassword" value="" type="password" />
								<div class="name">新密码:</div>
								<span id="J_eUserNameTipImg" class="icon"></span>
								<div id="J_eUserNameTipInfo" class="ltip"></div>
								<span class="placeholder" style="position: absolute;z-index: 20;color: rgb(153,153,153);top: 14px;left: 345px;line-height: 37px;"></span>
						</li>
						<li>
								<!-- 此处需要改name属性 -->
								<input id="J_euserName" class="long" name="repassword" value="" type="password" />
								<div class="name">确认密码:</div>
								<span id="J_eUserNameTipImg" class="icon"></span>
								<div id="J_eUserNameTipInfo" class="ltip"></div>
								<span class="placeholder" style="position: absolute;z-index: 20;color: rgb(153,153,153);top: 14px;left: 345px;line-height: 37px;"></span>
						</li>
						<li>
								<input id="J_euserName" class="long" style="width:70px;font-size: large;cursor: pointer;text-align: center;line-height: 40px;"  value="修改" type="submit" />
								<div class="name">&nbsp;</div>
								<span id="J_eUserNameTipImg" class="icon"></span>
								<div id="J_eUserNameTipInfo" class="ltip"></div>
								<span class="placeholder" style="position: absolute;z-index: 20;color: rgb(153,153,153);top: 14px;left: 345px;line-height: 37px;"></span>
						</li>

					</ul>
				</form>
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
