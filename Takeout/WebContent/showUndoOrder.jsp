<%@page import="bean.User"%>
<%@page import="dao.impl.UserDaoImpl"%>
<%@page import="service.impl.DriverServiceImpl"%>
<%@page import="service.DriverService"%>
<%@page import="java.util.List"%>

<%@page import="bean.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html" charset="ISO-8859-1"  name="viewport" content="width=device-width,initial-scale=1.0">
	<meta name="viewport" content="width=device-width,initial-scale=1.0">  
	<title>骑手订单</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.css"></link>
	<link rel="stylesheet" type="text/css"href="./css/me.css"></link>
	

</head>
<body>


<!--导航-->
<nav class="m-yellow ui attached segment m-padded-tb-mini">
	<div class="ui container">
		<div class="ui inverted secondary stackable menu" ><!--stackable 允许堆叠，适应移动端 -->
			<div style="height:190px;text-align:center;" >
			
				<!--网站图片-->
				<div class="m-inline-block m-top-left " style="margin-top:20px;margin-right:10px;margin-left:70px;">
					<img src="./image/logo.jpg" style="width:150px;height:150px" class="m-border" style="border-radius:5px;" alt="">
				</div>
				
				<!--文本介绍-->
				<div class="m-inline-block" style="width:530px; margin-top:20px">
					<p class="m-text-heavy">Web实训项目摸鱼集团</p>		
					<p class="m-text">本网页仅作Web实训项目答辩之用，闲暇之余也为一贫如洗的编程者提供虚拟空间一掷万金的朴实与快乐</p>

				</div>
				
				<!--人物信息-->
				<div class="m-inline-block" style="width:180px;margin-top:20px" >
					<p class="m-text-bold m-text-right">骑手姓名</p>
					<p class="m-text-thin m-text-right">152-XXXX-XXXX</p>
					<!--<p class="m-text m-text-right">余额：0</p>-->
					
				</div>
				
				<div class="m-inline-block m-top-right" style="margin-top:20px;margin-left:20px;margin-right:30px;">
						<img src="./image/person.jpg" style="width:100px;height:100px" class="m-top-right m-border-thin" alt="">
						
						<!--跳转修改信息界面-->
						<!--<div><a href="" class="m-inline-block" style="text-align:center">修改信息</a></div>-->
				</div>
				
			</div>
			
		</div>
	</div>
</nav>


<!--中间内容-->
<div class="m-container m-padded-tb-big">
	<div class="ui container">
		<div class="ui stackable grid">

			<!--左边卡片-->
			<div class="five wide column">
				<div class="ui segments"><!--secondary灰色底色-->
					<div class="ui secondary segment" style="height:400px;text-align:center;vertical-align: middle;line-height: 75px;"><!--secondary灰色底色-->	
						
						
						<div class="five wide column">
						
							<div class="five wide column" align="center"><!--店铺图片-->
								<a href="#" target="_blank">
									<img alt="" src=" " height="150px" alt="" class="ui rounded image">
								</a>
							</div>
							
							<div class="m-inline-block" style="width:200px;margin-top:20px" >
								<p class="m-text-bold" align="center"></p><!--店铺名称-->
								<p class="m-text-thin" align="left">店铺简介:</p><!--店铺简介-->
								<p class="m-text" align="left">消费范围:&nbsp;40+</p>
								<p class="m-text" align="left">配送时间:&nbsp;20min </p>
							</div>
							
							
						</div>
						
						
						
						
						<div class="right aligned column" style="margin-top:5px">
								
								
								
								<!--
								<div class="m-inline-block" style="height:40px;width:70px;background-color:white;">
								</div>
								-->
									
						</div>

						
					</div>
				</div>
			</div>
		
		
			<!--右边主体-->
			<div class="eleven wide column">
				<div class="container">
						
						
					<div class="ui bottom attached segment"><!--在后续div后添加attached将抹去上边框-->
						<div class="ui mobile reversed stackable grid m-inline-block" style="height:400px"><!--mobile reversed 使之在移动端时图片和文字顺序反转-->
							
							
							<!--页内导航-->
							<div class="m-inline-block m-yellow-back m-padded-none" style="width:685px; height: 60px;">
								<ul class="m-top-left-tiny  m-padded-none" style="overflow:hidden;list-style:none;padding: 0px"><!--设置padding属性覆盖用户代理样式-->
									
									<li class="m-float-left m-text-center m-radius m-yellow m-block" style="width:100px; height: 40px;line-height: 40px;">
										<a class="m-block" href="#" style="color:white;">查看可接订单</a><!--color样式由css引用无法起效？-->
									</li>
									
									<li class="m-float-left m-text-center m-radius m-block" style="width:100px; height: 40px;line-height: 40px;background-color:#FFAA74"">
										<a class="m-block" href="showDriverOrder.jsp" style="color:white;">查看已接订单</a>
									</li>
									
									
									
									
									<li class="m-float-left m-text-center m-radius m-block" style="width:100px; height: 40px;line-height: 40px;background-color:#FFAA74"">
										<a class="m-block" href="showFinshOrder.jsp" style="color:white;">查看已完成订单</a><!--color样式由css引用无法起效？-->
									</li>
									
									
									
								
									
									
									
									
								</ul>
								
								
								
								
							</div>
							
							
								
							<hr width="100%" size="3" color="#ffcc00">
							
							<%
								UserDaoImpl userdao=new UserDaoImpl();
								DriverServiceImpl driver=new DriverServiceImpl();
							%>
							<%
								List<Order> undoOrders=driver.undoOrder();
							%>
							
							<%
								for(Order undoorder:undoOrders){
								String username=undoorder.getId();
								User user=userdao.queryByName(username);
								
								
								
							
							%>
							
							<!--可接订单不为空时代码-->
							<div class="m-inline-block" style="padding-left:10px;width:49%;margin:0px;">
								<div class="ui bottom segment" style=""><!--在后续div后添加attached将抹去上边框-->
									<div class="ui mobile reversed stackable grid" style="height:170px"><!--mobile reversed 使之在移动端时图片和文字顺序反转-->
									
																			
										<form method="post">
											<div class="m-inline-block m-margin-top " id="text-desc">	
							
												<p class="m-text">
													顾客名：<%=username %></br>
													顾客地址：<%=user.getAddress() %></br>
													顾客电话：<%=user.getPhone() %></br>
													店铺名：<%=undoorder.getShopname() %></br>

												</p>
												<a class="ui mini teal basic button" href="changeStateServlet?user_id=<%=username %> ">接单</a>
			
											</div>
										</form>	

									
									</div>
								</div>
							</div>
							
							
							
									
								



								
									
							
									
									
									
							
							<%
							}
							%>
							<!--表单循环完毕-->
							
							
						</div>	
					</div>
					<!--右边主体完毕-->

						
						
						
				</div>
				
			</div>
			
			
			
			
		</div>
	</div>
</div>



<!--底部footer-->
<footer class="ui m-yellow-foot vertical segment m-padded-tb-large">
	<div class="ui center aligned container">
		<div class="ui divided stackable grid">
		
			<div class="four wide column">
				<div class="ui inverted link list">
					<div class="item">
						<img src="./image/jiang.jpg" class="ui rounded image" alt="" style="width:100px">
					</div>
					<h4 class="ui header m-grey">蒋芳霞</h4>
					
				</div>
			</div>
			
			<div class="four wide column">
				<div class="ui inverted link list">
					<div class="item">
						<img src="./image/liu.jpg" class="ui rounded image" alt="" style="width:100px">
					</div>
					<h4 class="ui header m-grey">刘明玉</h4>
					
				</div>
			</div>
			
			<div class="four wide column">
				<div class="ui inverted link list">
					<div class="item">
						<img src="./image/tang.jpg" class="ui rounded image" alt="" style="width:100px">
					</div>
					<h4 class="ui header m-grey">唐玲玲</h4>
					
				</div>
			</div>
			
			<div class="four wide column">
				<div class="ui inverted link list">
					<div class="item">
						<img src="./image/wang.jpg" class="ui rounded image" alt="" style="width:100px">
					</div>
					<h4 class="ui header m-grey">王濒彬</h4>
					
				</div>
			</div>
			

		</div>
		
		<div class="ui inverted section divider"></div>
		
		<p class="m-text-thin m-text-spaced m-grey-h">小组成员：蒋芳霞，刘明玉，唐玲玲，王濒彬（按姓氏首字母排序）</p>
	</div>
</footer>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.2/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.js"></script>


</body>
</html>

