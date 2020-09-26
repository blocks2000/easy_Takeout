<%@page import="bean.Shop"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="bean.FoodMenu"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html" charset="UTF-8"  name="viewport" content="width=device-width,initial-scale=1.0">
	<meta name="viewport" content="width=device-width,initial-scale=1.0">  
	<title>店铺</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.css"></link>
	<link rel="stylesheet" type="text/css"href="./css/me.css"></link>
	
	<script type="text/javascript" src="js/jquery-1.12.3.js"></script>
	<script type="text/javascript">
	
	var price=0;
	var str;
	var trueId;
		function add_food(obj)
		{
			var id=$(obj).attr("id");
			if(id.includes('_')){
				str=id.split('_');
				trueId=str[1];
			}
			else{
				trueId=id;
			}
			//alert(trueId);
			var foodId=$("#"+trueId).val();
			var foodPrice=$("."+trueId).val();
			var count=$("#100"+trueId).val();
			var username=$("#200"+trueId).val();
			var shopname=$("#300"+trueId).val();
			foodPrice=parseInt(foodPrice);
			var sign=$(obj).attr("value");
			//alert(sign);
			//alert(foodPrice);
			//alert(foodId);
			//alert(count);
			if(sign=="+") price+=foodPrice;
			else{
				if(price==0) price=0;
				else price=price-foodPrice;
				count=count-2;
			}
			$("#totalPrice").val(price);
			//alert(price);
			//alert(price);
			//$("#totalPrice").val(price)
			//$("#totalprice").val(foo)
			$.ajax({
				url:"addFoodServlet",
				type:"post",
				data:{"foodId":foodId,"foodPrice":price,"count":count,"username":username,"shopname":shopname}
			})
		}
		
		$(document.documentElement).on("click",".on-number",function(){
			var $val=$(this).siblings("input[type='text']"),
			val=parseInt($val.val(),10)+parseInt($(this).data("v"));
			$val.val(isNaN(val)?0:val);
		})

	</script>
	
</head>



<%
	List<Shop> shops=(List<Shop>)request.getAttribute("shops");
	List<FoodMenu> foodMenus=(List<FoodMenu>)request.getAttribute("foodMenus");
	String username=(String)request.getAttribute("username");
	Shop shop=shops.get(0);
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
									<img id="shopImg" alt="店铺图片" src="<%=shop.getImgurl() %>" height="150px" alt="" class="ui rounded image" >
								</a>
							</div>
							
							<div class="m-inline-block" style="width:200px;margin-top:20px" >
								<p class="m-text-bold" align="center"><%= shop.getShopname() %></p>
								
								
								
								
								<p class="m-text-thin" align="left">店铺简介:<%=shop.getDesc()%></p>
								<p class="m-text" align="left">消费范围:&nbsp;40+</p>
								<p class="m-text" align="left">配送时间:&nbsp;20min </p>
							</div>
							
							
						</div>
						
						
						
						
						<div class="right aligned column" style="margin-top:5px">
								<a href="queryFoodServlet?username=<%=username %>" class="ui mini teal basic button">返回首页</a>
								&nbsp;&nbsp;&nbsp;
								<a href="ShowOrder.jsp?username=<%=username%>" class="ui mini teal basic button">查看订单</a>
								
								
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
						<%for(FoodMenu foodMenu2:foodMenus) 
						{
						%>
						
						<div class="ui bottom attached segment"><!--在后续div后添加attached将抹去上边框-->
						<div class="ui mobile reversed stackable grid" style="height:160px"><!--mobile reversed 使之在移动端时图片和文字顺序反转-->
							<form method="post">
								<div class="m-inline-block" ><!--食物图片-->
									<a href="#" target="_blank">
										<img src="<%= foodMenu2.getImgurl()%>" style="width:180px;height:130px" alt="" class="ui rounded image m-margin-top">
									</a>
								</div>
							
								<div class="m-inline-block m-margin-top "><!--食物文字-->
								
									<!-- <h3 class="ui header m-inline-block" id="<%=foodMenu2.getId() %>" name="foodId" >--><%= foodMenu2.getName() %></h3>
									
									<span class=" m-inline-block">&nbsp;&nbsp;&nbsp;<%= foodMenu2.getDes() %></span>
									
									<input  id="<%=foodMenu2.getId() %>" name="foodId" type="hidden" style="display:none" value="<%= foodMenu2.getId() %>"></input>
									<input  id="200<%=foodMenu2.getId() %>" name="username" type="hidden" style="display:none" value="<%=username %>"></input>
									<input id="300<%=foodMenu2.getId()%>" name="shopname" type="hidden" style="display:none" value="<%=shop.getShopname() %>"></input>
								
									
				
									<p class="m-text">
										评分：&nbsp;<%=foodMenu2.getMark()%></br>
										价格：&nbsp;<input class="<%=foodMenu2.getId() %>" style="border:none;" id="foodPrice" name="foodPrice"  value="<%=foodMenu2.getPrice()%>">
										
									</p>
									
									
									
									<input type="button" id="_<%=foodMenu2.getId() %>" class="on-number" value="-" data-v="-1"  onclick="add_food(this)" > 
	        	
									<input type="text" style="" id="100<%=foodMenu2.getId() %>"  value="0" readonly="readonly">
	        	
									<input id="<%= foodMenu2.getId()%>" type="button" class="on-number" value="+" data-v="1" onclick="add_food(this)"> 
									
									
		
								</div>
								
								
							</form>
						</div>	
					</div>
						
					  
						<% 
						}
						%>
						
						<div id="showorder">
						总价：<input id="totalPrice" value="0" readonly="readonly">
						</div>
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