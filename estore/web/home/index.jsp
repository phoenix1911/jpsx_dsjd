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
	<link rel="stylesheet" href="home/public/css/banner.css">
	<link rel="stylesheet" href="home/public/css/text.css">
	<script src="home/public/js/jquery-1.8.3.min.js"></script>
	<script src="home/public/js/banner.js"></script>
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
				<!-- 如果是用户登录状态，就显示以下li -->
				<!-- <li><a>欢迎 张三</a></li> -->
				<!-- 如果没有登录，就显示以下两个li -->
				<!-- 此处需要改链接 -->
				<li><a href="home/login.jsp" style="color: red;">亲,请登入${sessionScope.user.username}</a></li>
				<li><a href="home/register.jsp">免费注册</a></li>
			</ul>
			<ul class="top_bars">
				<!-- 如果是用户登录状态，就显示以下li -->
				<!-- 此处需要改链接 -->
				<!-- <li><a href="login.html">退出</a>|</li> -->
				<!-- 此处需要改链接 -->
				<!-- <li><a href="myorder.html">我的订单<span class="jt_down"></span></a>|</li> -->
				<!-- 如果没有登录，就显示以下两个li -->
				<li><a href="javascript:void(0)">关注杰普<span class="jt_down"></span></a>|</li>
				<li><a href="javascript:void(0)">网站导航<span class="jt_down"></span></a></li>
			</ul>
			<!-- ******************************************************* -->
			<!-- ******************************************************* -->

		</div>
	</div>
	<!--头部-->
	<div class="header3">
		<!-- 此处需要改链接 -->
		<a href="index.jsp"><img src="home/public/img/logo.png"></a>
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
				<!-- 此处需要改链接 -->
				<a href="home/userinfo.jsp">个人信息</a>
				<span class="sj_down"></span>
			 </div>
			<div class="tsc">
				<!-- 此处需要改链接 -->
				<a href="home/shopcart.jsp">去购物车结算</a>
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
	
	<div class="container3">
		<div class="c3_b1">
			<div class="c3_b1_left">

				<!-- ******************************************************* -->
				<!-- ******************************************************* -->
				<!-- *********************《修改区域》********************** -->
				<!-- *************** 循环读取五～七个分类名 **************** -->
				<!-- ******************************************************* -->
				<dl>
					<dd>
						<!-- 分类名 -->
						<!-- 此处需要改链接 -->
						<h1><a href="list.jsp" class="cla">文学类</a></h1>
						<p>
							<!-- 此处需要改链接 -->
							<!-- 读取推荐书籍的前两本书 -->
							<a href="book.jsp">疯狂JAVA讲义</a>
							<a href="book.jsp">疯狂JAVA讲义</a>
						</p>
					</dd>
					<dd>
						<h1><a href="list.jsp" class="cla">教育类</a></h1>
						<p>
							<a href="book.jsp">疯狂JAVA讲义</a>
							<a href="book.jsp">疯狂JAVA讲义</a>
						</p>
					</dd>
					<dd>
						<h1><a href="list.jsp" class="cla">计算机</a></h1>
						<p>
							<a href="book.jsp">疯狂JAVA讲义</a>
							<a href="book.jsp">疯狂JAVA讲义</a>
						</p>
					</dd>
					<dd>
						<h1><a href="list.jsp" class="cla">儿童类</a></h1>
						<p>
							<a href="book.jsp">疯狂JAVA讲义</a>
							<a href="book.jsp">疯狂JAVA讲义</a>
						</p>
					</dd>
					<dd>
						<h1><a href="list.jsp" class="cla">漫画类</a></h1>
						<p>
							<a href="book.jsp">疯狂JAVA讲义</a>
							<a href="book.jsp">疯狂JAVA讲义</a>
						</p>
					</dd>
					<dd>
						<h1><a href="list.jsp" class="cla">工具书</a></h1>
						<p>
							<a href="book.jsp">疯狂JAVA讲义</a>
							<a href="book.jsp">疯狂JAVA讲义</a>
						</p>
					</dd>
					<dd class="last">
						<h1><a href="list.jsp" class="cla">期刊</a></h1>
						<p>
							<a href="book.jsp">疯狂JAVA讲义</a>
							<a href="book.jsp">疯狂JAVA讲义</a>
						</p>
					</dd>
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
						<li>
							<!-- 此处需要改链接 -->
							<a href="book.jsp"><img src="home/public/img/p01.png"/></a>
							<a href="book.jsp">Java从入门到精通</a>
						</li>
					   <li>
							<a href="book.jsp"><img src="home/public/img/p01.png"/></a>
							<a href="book.jsp">Java从入门到精通</a>
						</li>
						<li>
							<a href="book.jsp"><img src="home/public/img/p01.png"/></a>
							<a href="book.jsp">Java从入门到精通</a>
						</li>
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
				<li>
					<div class="c3_b2_txt">
						<h1 class="rebook">疯狂JAVA讲义疯狂JAVA讲义</h1>
						<p>Java经典</p>
						<h2>推荐书籍</h2>
						<h2>全新内容，全新体验，就在杰普商城</h2>
						<p><a href="#">更多精彩，点击进入</a></p>
					</div>
				</li>
				<li>
					<div class="c3_b2_txt">
						<h1>疯狂JAVA讲义</h1>
						<p>Java经典</p>
						<h2>推荐书籍</h2>
						<h2>全新内容，全新体验，就在杰普商城</h2>
						<p><a href="#">更多精彩，点击进入</a></p>
					</div>
				</li>
				<li>
					<div class="c3_b2_txt">
						<h1>疯狂JAVA讲义</h1>
						<p>Java经典</p>
						<h2>推荐书籍</h2>
						<h2>全新内容，全新体验，就在杰普商城</h2>
						<p><a href="#">更多精彩，点击进入</a></p>
					</div>
				</li>
				<li class="no_mr">
					<div class="c3_b2_txt">
						<h1>疯狂JAVA讲义</h1>
						<p>Java经典</p>
						<h2>推荐书籍</h2>
						<h2>全新内容，全新体验，就在杰普商城</h2>
						<p><a href="#">更多精彩，点击进入</a></p>
					</div>
				</li>
				<li>
					<div class="c3_b2_txt">
						<h1>疯狂JAVA讲义</h1>
						<p>Java经典</p>
						<h2>推荐书籍</h2>
						<h2>全新内容，全新体验，就在杰普商城</h2>
						<p><a href="#">更多精彩，点击进入</a></p>
					</div>
				</li>
				<li>
					<div class="c3_b2_txt">
						<h1>疯狂JAVA讲义</h1>
						<p>Java经典</p>
						<h2>推荐书籍</h2>
						<h2>全新内容，全新体验，就在杰普商城</h2>
						<p><a href="#">更多精彩，点击进入</a></p>
					</div>
				</li>
				<li>
					<div class="c3_b2_txt">
						<h1>疯狂JAVA讲义</h1>
						<p>Java经典</p>
						<h2>推荐书籍</h2>
						<h2>全新内容，全新体验，就在杰普商城</h2>
						<p><a href="#">更多精彩，点击进入</a></p>
					</div>
				</li>
				<li class="no_mr">
					<div class="c3_b2_txt">
						<h1>疯狂JAVA讲义</h1>
						<p>Java经典</p>
						<h2>推荐书籍</h2>
						<h2>全新内容，全新体验，就在杰普商城</h2>
						<p><a href="#">更多精彩，点击进入</a></p>
					</div>
				</li>
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
