
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
	<link rel="stylesheet" href="home/public/css/myorder.css">
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
				<span><a href="javascript:void(0)">我的订单</a></span>
			</h1> 
		</div>
		<div class="c4_b4">
			 <div class="c4_b4_y">
				<ul>
					<li>&nbsp;&nbsp;&nbsp;&nbsp;我的订单</li>
				</ul>               
			</div>
		</div>

		<!-- ******************************************************* -->
		<!-- ******************************************************* -->
		<!-- *********************《修改区域》********************** -->
		<!-- **************** 循环查询出所有的订单 ***************** -->
		<!-- ******************************************************* -->
		<table border="1">
			<tr style="background:#eee">
				<th colspan="5">订单编号：1011&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;总金额：23.43&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;创建时间：XX年XX月XX日&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;状态：未发货</th>
			</tr>
			<tr>
				<th width="100px">图片</th>
				<th>书名</th>
				<th>价格</th>
				<th>数量</th>
				<th>小计</th>
			</tr>

			<!-- ******************************************************* -->
			<!-- ******************************************************* -->
			<!-- *********************《修改区域》********************** -->
			<!-- *************** 循环查询出所有的订单行 **************** -->
			<!-- ******************************************************* -->
			<tr>
				<td><img src="home/public/img/2.png" alt=""></td>
				<td>JAVA虚拟机</td>
				<td>12.43</td>
				<td>2</td>
				<td>24.86</td>
			</tr>
			<tr>
				<td><img src="home/public/img/2.png" alt=""></td>
				<td>JAVA虚拟机</td>
				<td>12.43</td>
				<td>2</td>
				<td>24.86</td>
			</tr>
			<!-- ******************************************************* -->
			<!-- ******************************************************* -->
			<tr style="background:#ccc">
				<th colspan="5">收货信息：山西省太原市万柏林区XXX街道XXX小区XXX号（briup收）12345678901 </th>
			</tr>

		</table>

		<table border="1">
			<tr style="background:#eee">
				<th colspan="5">订单编号：1011&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;总金额：23.43&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;创建时间：XX年XX月XX日&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;状态：未发货</th>
			</tr>
			<tr>
				<th width="100px">图片</th>
				<th>书名</th>
				<th>价格</th>
				<th>数量</th>
				<th>小计</th>
			</tr>

			<!-- ******************************************************* -->
			<!-- ******************************************************* -->
			<!-- *********************《修改区域》********************** -->
			<!-- *************** 循环查询出所有的订单行 **************** -->
			<!-- ******************************************************* -->
			<tr>
				<td><img src="home/public/img/2.png" alt=""></td>
				<td>JAVA虚拟机</td>
				<td>12.43</td>
				<td>2</td>
				<td>24.86</td>
			</tr>
			<tr>
				<td><img src="home/public/img/2.png" alt=""></td>
				<td>JAVA虚拟机</td>
				<td>12.43</td>
				<td>2</td>
				<td>24.86</td>
			</tr>
			<!-- ******************************************************* -->
			<!-- ******************************************************* -->
			<tr style="background:#ccc">
				<th colspan="5">收货信息：山西省太原市万柏林区XXX街道XXX小区XXX号（briup收）12345678901 </th>
			</tr>

		</table>
		<!-- ******************************************************* -->
		<!-- ******************************************************* -->
		
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