<%@page import="service.impl.Single_orderServiceImpl"%>
<%@page import="service.ISingle_orderService"%>
<%@page import="service.impl.OrderServiceImpl"%>
<%@page import="service.IOrderService"%>
<%@page import="service.impl.IMenuServiceImpl"%>
<%@page import="service.IMenuService"%>
<%@page import="bean.Single_order"%>
<%@page import="java.util.List"%>
<%@page import="bean.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html" charset="UTF-8"  name="viewport" content="width=device-width,initial-scale=1.0">
	<meta name="viewport" content="width=device-width,initial-scale=1.0">  
	<title>查看店铺</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.css"></link>
	<link rel="stylesheet" type="text/css"href="./css/me.css"></link>
	

</head>


<%
String username=request.getParameter("username");
ISingle_orderService s_orderSerivice=new Single_orderServiceImpl();
List<Single_order> s_Orders=s_orderSerivice.queryS_Order(username);
IOrderService orderService=new OrderServiceImpl();
Order orders=orderService.queryOrder(username);
IMenuService menuService=new IMenuServiceImpl();
System.out.print(username);
%>






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
					<p class="m-text-bold m-text-right">用户姓名</p>
					<p class="m-text-thin m-text-right">152-XXXX-XXXX</p>
					<p class="m-text m-text-right">余额：0</p>
					
				</div>
				
				<div class="m-inline-block m-top-right" style="margin-top:20px;margin-left:20px;margin-right:30px;">
						<img src="./image/person.jpg" style="width:100px;height:100px" class="m-top-right m-border-thin" alt="">
						
						<!--跳转修改信息界面-->
						<div><a href="" class="m-inline-block" style="text-align:center">修改信息</a></div>
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
									
								</a>
							</div>
							
							<div class="m-inline-block" style="width:200px;margin-top:20px" >
						
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
							
							<%
								if(orders==null)
								{
							%>
									<script>
									alert("您还没有点菜，订单为空哦~");
									window.location.href="queryFoodServlet";
									</script>
							<% 
								}
								else{
									if(orders.getId().equals("null"))
									{
							%>
										<script>
										alert("您还没有点菜，订单为空哦~");
										window.location.href="queryFoodServlet";
										</script>
							<% 
									}
									String menu_id;
									 for(Single_order s_order:s_Orders) 
									{
										menu_id=s_order.getMenu_id();
							%>
								
								
							<img   src="<%=menuService.queryImgById(menu_id) %>" style="width:180px;height:130px" >
							<%=menuService.queryNameById(menu_id) %>
							数量：<%=s_order.getQuantity() %>
							价格:<%=s_order.getSingle_price() %>
							</br>
								
							<% 
								}
							%>
								
							<hr width="100%" size="3" color="#ffcc00">
							亲爱的<%=username %>,这是你的订单详情：</br>
									
							订单总价：<%=orders.getPrice()%></br>
							订单状态：
							
							<%
								String str=null;
								String state=orders.getState();
								if(state.equals("1")) str="商家未接单";
								if(state.equals("2")) str="商家已接单";
								if(state.equals("3")) str="骑手已接单";
							%>
							<%=str %>
							
							</br>
							下单时间：<%=orders.getOrdertime() %></br>
									

							</br>
							</br>							
							<a href="updateSqServlet?username=<%=username %>" class="ui teal basic button">返回</a>
							返回时订单会为空需要重新点单哦
							
						</div>	
					</div>

						<% 
						}
						%>
						
						
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