﻿
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
	<title>结算页面</title>
	<link rel="stylesheet" href="home/public/css/common.css"/>
	<link rel="stylesheet" href="home/public/css/icons.css" />
	<link rel="stylesheet" href="home/public/css/table.css" />
	<link rel="stylesheet" href="home/public/css/orderSure.css" />
	<link rel="stylesheet" href="home/public/css/addr.css" />
	<script type="text/javascript" src="home/public/js/area.js"></script>
	<script src="home/public/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript">
		// 把下拉框中的数据 添加到详细地址中
		function addaddr_detail() {
			var s_province = document.getElementById('s_province').value;
			var s_city = document.getElementById('s_city').value;
			var s_county = document.getElementById('s_county').value;
			document.getElementById('addr_detail').value = s_province + s_city + s_county;
		}
		// end 把下拉框中的数据 添加到详细地址中
	</script>

</head>
<body>
<!--顶部-->
<div class="top">
	<div class="top_center">

		<ul class="top_bars">
			<c:if test="${sessionScope.user!=null}">
				<li><a href="Outlogin">退出</a> </li>
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
		<!-- ******************************************************* -->
		<!-- ******************************************************* -->

	</div>
</div>
<!--头部-->
	<div class="header3">

		<!-- ******************************************************* -->
		<!-- 此处需要改链接 -->
		<a href="index.jsp"><img src="home/public/img/logo.png" class="oneImg"></a>
		<!-- ******************************************************* -->

		<div class="h3_right">
			<img src="home/public/img/play_02.png" alt="">
		</div>
	   
	</div>
	<p class="orderButtom">填写并核对订单信息</p>
	<!--中间复杂部分-->
	<div class="content">
		<div class="contentCenter">
			<div class="centerTop">

				<!-- ******************************************************* -->
				<!-- ******************************************************* -->
				<!-- *********************《修改区域》********************** -->
				<!-- *************** 循环读取所有地址表信息 **************** -->
				<!-- ******************************************************* -->
				<p>
					<!-- for和id的属性值是address表的id值 -->
					<label for="1">
						<!-- 此处需要改链接 -->
						<input class="address" type="radio" name="address" id="1">山西省太原市万柏林区XXX街道XXX小区XXX号（briup收）12345678901 <a href="##">删除</a>
					</label>
				</p>
				<!-- ******************************************************* -->
				<!-- ******************************************************* -->

				<!-- ******************************************************* -->
				<!-- ******************************************************* -->
				<!-- *********************《修改区域》********************** -->
				<!-- *************** 循环读取所有地址表信息 **************** -->
				<!-- ******************************************************* -->
				<p>
					<!-- for和id的属性值是address表的id值 -->
					<label for="2">
						<!-- 此处需要改链接 -->
						<input class="address" type="radio" name="address" id="2">山西省太原市万柏林区XXX街道XXX小区XXX号（briup收）12345678901 <a href="##">删除</a>
					</label>
				</p>
				<!-- ******************************************************* -->
				<!-- ******************************************************* -->

				<p style="font-size:15px;margin-left:20px;margin-top:30px;"><button onclick="document.getElementById('divDialog').style.display=''">添加收件人</button></p>
			</div>

			<!-- 送货清单（开始） -->
			<!-- ******************************************************* -->
			<!-- 此处需要改链接 -->
			<p class="singleP"><b>送货清单</b><span><a href="shopCart.html">返回修改购物车</a></span></p>
			<!-- ******************************************************* -->

			<div class="bigDiv">
				<div class="twoDiv">
					<!-- ******************************************************* -->
					<!-- ******************************************************* -->
					<!-- *********************《修改区域》********************** -->
					<!-- ************** 循环读取订单行中图书信息 *************** -->
					<!-- ******************************************************* -->
					<br>
					<ul class="oneUL">
						<li>
							<img src="home/public/img/viewBook.png" class="pic">
							<p>计算机&nbsp;&nbsp;JAVA&nbsp;&nbsp;Effective JAVA&nbsp;&nbsp;</p>
							<p><font class="price">¥100169.00</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;×<b class="num">1</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;有货</p>
							<p><img src="home/public/img/sureLogo_14.png" alt=""><span>七天无理由退换货</span></p>

						</li>
						<li><pre>【赠品】  高级定制干花书签  随机  ×1</pre></li>
					</ul>
					<!-- ******************************************************* -->
					<!-- ******************************************************* -->


					<!-- ******************************************************* -->
					<!-- ******************************************************* -->
					<!-- *********************《修改区域》********************** -->
					<!-- ************** 循环读取订单行中图书信息 *************** -->
					<!-- ******************************************************* -->
					<br>
					<ul class="oneUL">
						<li>
							<!-- 此处需要修改name值，name值是书籍的编号 -->
							<img name="${bean.value.book.id}" src="home/public/img/viewBook.png" class="pic">
							<p>计算机&nbsp;&nbsp;JAVA&nbsp;&nbsp;Effective JAVA&nbsp;&nbsp;</p>
							<p><font class="price">¥100169.00</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;×<b class="num">1</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;有货</p>
							<p><img src="home/public/img/sureLogo_14.png" alt=""><span>七天无理由退换货</span></p>

						</li>
						<li><pre>【赠品】  高级定制干花书签  随机  ×1</pre></li>
					</ul>
					<!-- ******************************************************* -->
					<!-- ******************************************************* -->

				</div>
			</div>
			<!-- 送货清单（结束） -->
	
			<script>
				$(function () {
					var sum = 0;
					for (var i = 0; i < $('.price').size(); i ++) {
						var price = Number($('.price').eq(i).text().split('¥')[1]);
						var num = Number($('.num').eq(i).text());
						sum = sum + (price * num);
					}
					$('#number').text($('.price').size());
					$('.total').text('¥'+sum.toFixed(2));

					// 拼接“提交订单”的链接
					var sub = "?orderline=";
					$(".pic").each(function(i) {
						sub = sub + '|' + $('.pic').eq(i).attr('name');
					});

					if ($('#suborder').attr('href').indexOf('addressid') == -1) {
						$('#suborder').attr('href','javascript:void(0)');
					}

					$('.address').click(function () {
						var addressid = '&addressid=' + $(this).attr('id');
						$('#suborder').attr('href',sub + addressid);
					});

				});
			</script>
			<div class="money">
				<span><font id="number"></font>件商品，总商品金额：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b class="total">¥14699</b></span>
				<span><img src="home/public/img/sureLogo_18.png" alt="">运费：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;¥0.00</span>
				
			</div>
			<div class="submit">
				<span>应付金额：<font class="total">¥14699.00</font>
					<!-- 提交订单按钮 -->
					<a href="" id="suborder"><img src="home/public/img/21_03.png" alt=""></a></span>
			</div>
		</div>

	</div>

	<!-- 这里是弹框div，默认不显示 -->
	<div id="divDialog"
		style="left: 378.5px; top: 94.5px; opacity: 1;display:none;">
		<div class="pop">
			<a href="javascript:void(0)" class="close" id="closeEdit"
				style="display: none;"></a>
			<div class="pop_title">新增收货地址</div>
			<div class="pop_con">

				<!-- ******************************************************* -->
				<!-- ******************************************************* -->
				<!-- *********************《修改区域》********************** -->
				<!-- ************* 此处为增加地址信息记录表单 ************** -->
				<!-- ******************************************************* -->
				<form class="info_list" action="" method="method">
					<ul>
						<li><span class="name">收货人</span> <input name="name" type="text"
							id="addr_name" value="" maxlength="20"></li>
						<li><span class="name">手机号码</span> <input name="phone" type="text"
							id="addr_phone" value=""
							onfocus="if(value == defaultValue){value='';}" maxlength="20"></li>
						<li><span class="name">所在地区</span>
					
						<select id="s_province" name="s_province"></select>  
						<select id="s_city" name="s_city" ></select>  
						<select id="s_county" name="s_county" onchange="addaddr_detail();"></select>
						<script type="text/javascript">_init_area();</script>

						<div class="alart_tip" style="display: none;"
								id="div_addr_sel_edit"></div></li>
						<li><span class="name">详细地址</span> <input name="info" type="text"
							style="width: 413px;" id="addr_detail" value="" maxlength="150"></li>
					</ul>
					<div class="btn_bar">
						<input type="submit" style="cursor:pointer;background: red;border:none;padding:8px;color:#fff" id="submitAdd" class="btn_red" value="确认新增收货地址">

						<!-- ******************************************************* -->
						<!-- 此处需要改链接 -->
						<a href="order.html" id="cancelAdd" class="btn">返回</a>
						<!-- ******************************************************* -->

					</div>
				</form>
				<!-- ******************************************************* -->
				<!-- ******************************************************* -->

			</div>
		</div>
	</div>
	
	<!-- 脚部 -->
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
			<p>沪ICP备14033591号-8 杰普软件briup.com版权所有 杰普软件科技有限公司 </p>
			<img src="home/public/img/police.png">
		</div>
	</div>

</body>
</html>