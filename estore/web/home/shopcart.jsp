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
	<title>购物车页面</title>
	<link rel="stylesheet" href="home/public/css/fullCar.css" />
	<link rel="stylesheet" href="home/public/css/common.css"/>
	<link rel="stylesheet" href="home/public/css/style.css" />
	<link rel="stylesheet" href="home/public/css/icons.css" />
	<link rel="stylesheet" href="home/public/css/table.css" />
	<link rel="stylesheet" href="home/public/css/cartnum.css" />
	<script src="home/public/js/jquery-1.8.3.min.js"></script>
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
		
		<!-- ******************************************************* -->
		<!-- 这里需要修改链接 -->
		<a href="home/index.jsp"><img src="home/public/img/logo.png" class="oneImg"></a>
		<!-- ******************************************************* -->

		<div class="h3_right">
			<img src="home/public/img/play_01.png" alt="">
		</div>

	</div>

	<div class="empty">
	<!-- ******************************************************* -->
	<!-- ******************************************************* -->
	<!-- *********************《修改区域》********************** -->
	<!-- ******************************************************* -->
	<!--中间部分div，购物车为空的情况-->
		<!-- <a href="indexSuccess.html"><img src="public/img/empty_03.png" class="car"> </a> -->
	<!-- ******************************************************* -->
	<!-- ******************************************************* -->
		<div class="peisong"><pre>全部商品</pre></div>
		<div class="mainCenter">
			<div class="allCheck">
				<p class="leftM">商品</p>
				<p class="rightM">单价(元)</p>
				<p class="leftM">数量</p>
				<p class="leftM">小计(元)</p>
				<p class="leftM">操作</p>
			</div>
			<div class="mainPro">
				<div class="aa">
					<span id="but">自营</span>
				</div>
				<c:forEach items="${sessionScope.shopcart}"  var="shopcart">
				<div class="bb" id="shopcart${shopcart.key}">

					<script>
                        // 点击 + 和 - 触发的事件
                        $(function() {

                            // 以下只修改 #shopcart1 这个地方即可，其余不要动
                            // 注意 #shopcart1 代表 #shopcart+id，此时id为1
                            /*******************************************************/
                            /********************《可修改区域》*********************/
                            /*******************************************************/
                            var id = "#shopcart${shopcart.key}";
                            var suburl = "subServlet.servlet";  // 点击“-”的Servlet
                            var addurl = "addServlet.servlet";  // 点击“+”的Servlet
                            /*******************************************************/
                            /*******************************************************/

                            var input = $(id+' .num').val();
                            var price = $(id+' .mm').text().split("¥")[1];
                            $(id+' .ri').text('¥'+(price*input));
                            // 减的事件
                            $(id+' .sub').click(function() {
                                if (input > 1) {
                                    input --;
                                }
                                // 数量
                                $(id+' .num').val(input);
                                // 小计
                                $(id+' .ri').text('¥'+(price*input).toFixed(2));

                                // 用来保存总金额
                                var sum = 0;

                                // 遍历每行的小计
                                $('.ri').each(function(i) {
                                    sum = sum + Number($('.ri').eq(i).text().split("¥")[1]);
                                });
                                // 总价钱
                                $('#total').text('¥'+sum+'元');
                                window.location = suburl + "?id=${shopcart.key}&num=" + input;

                            });
                            // 加的事件
                            $(id+' .add').click(function() {
                                if (input < 99) {
                                    input ++;
                                }
                                // 数量
                                $(id+' .num').val(input);
                                // 小刘
                                $(id+' .ri').text('¥'+(price*input));

                                // 用来保存总金额
                                var sum = 0;

                                // 遍历每行的小计
                                $('.ri').each(function(i) {
                                    sum = sum + Number($('.ri').eq(i).text().split("¥")[1]);
                                });
                                // 总价钱
                                $('#total').text('¥'+sum+'元');
                                window.location = addurl + "?id=${shopcart.key}&num=" + input;
                            });
                        });
					</script>
					<img src="home/public/img/1.png" >

					<!-- ******************************************************* -->
					<!-- 书名，此处需要修改 -->
					<span>
						${shopcart.key}
						${shopcart.value.book.name}
						<br>
					</span>
					<!-- ******************************************************* -->

					<!-- ******************************************************* -->
					<!-- 价格，此处需要修改 -->
					<div class="mm">
						<span>¥${shopcart.value.book.price}</span>
					</div>
					<!-- ******************************************************* -->

					<!-- 数量 -->
					<div class="cartnum">
			            <div class="sub">-</div>
			            <div><input type="text" name="" class="num" value="${shopcart.value.number}" readonly></div>
			            <div class="add">+</div>
			            <div class="clear"></div>
			        </div>


					<div class="ri"></div>

					<div class="righ">
						 <div class="rig"><a href="deleteRowFromShopcart.servlet?bookid=${shopcart.key}">删除</a></div>
					</div>
				</div>
				</c:forEach>
				<div style="clear:both"></div>
				<!-- 购物车行（结束） -->
				<!-- ******************************************************* -->
				<!-- ******************************************************* -->
			</div>
			<div class="allButtom">
				
				<!-- ******************************************************* -->
				<!-- ********************《修改区域》*********************** -->
				<!-- ******************************************************* -->
				<!-- ******************************************************* -->
				<!-- 这里需要修改链接 -->
				<p class="caozuo"> <a id="atotal" href="order.servlet">结算</a> </p>
				<!-- ******************************************************* -->
				<!-- ******************************************************* -->

				<script>
					$(function () {
						var num = $('.num').size();
						var sum = 0;

						$('.ri').each(function(i) {
							sum = sum + Number($('.ri').eq(i).text().split("¥")[1]);
						});

						// 总价钱
						$('#total').text('¥'+sum+'元');
						// 购物车中的总数量
						$('#number').text(num);
					});
				</script>
				<span>已选择<font id="number"></font>件商品&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;总价(不含运费)：<font id="total"></font></span>
			</div>
		</div>
	</div>
	<!--脚部-->
	<div style="clear:both;"></div>
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