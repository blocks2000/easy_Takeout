<%@page import="bean.Shop"%>
<%@page import="service.impl.ShopServiceImpl"%>
<%@page import="service.IShopService"%>
<%@page import="java.util.HashSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="bean.FoodMenu"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html" charset="UTF-8"  name="viewport" content="width=device-width,initial-scale=1.0">
	<meta name="viewport" content="width=device-width,initial-scale=1.0">  
	<title>首页</title>
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
				data:{"foodId":foodId,"foodPrice":price,"count":count}
			})
		}
		
		$(document.documentElement).on("click",".on-number",function(){
			var $val=$(this).siblings("input[type='text']"),
			val=parseInt($val.val(),10)+parseInt($(this).data("v"));
			$val.val(isNaN(val)?0:val);
		})

	</script>
	
</head>
<body>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width,initial-scale=1.0">  
	<title>首页</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.css"></link>
	<link rel="stylesheet" type="text/css"href="../css/me.css"></link>
</head>
<body>

<%
	List<FoodMenu> foodMenu=(List<FoodMenu>)request.getAttribute("foodMenus");
	HashSet<String> merchants=(HashSet<String>)request.getAttribute("merchants");
	IShopService shopService=new ShopServiceImpl();
	String username=(String)request.getAttribute("username");
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
						<div><a href="login.jsp" class="m-inline-block" style="text-align:center">退出登录</a></div>
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
				<div class="ui segments">
					
					<div class="ui secondary segment " style="height:100px;text-align:center;vertical-align: middle;line-height: 75px;"><!--secondary灰色底色-->	
						主食区
					</div>
					
					<div class="ui segment" style="height:100px;text-align:center;vertical-align: middle;line-height: 75px;">
						快餐区
					</div>
					
					<div class="ui segment" style="height:100px;text-align:center;vertical-align: middle;line-height: 75px;">
						水果区
					</div>
					
					<div class="ui segment" style="height:100px;text-align:center;vertical-align: middle;line-height: 75px;">
						零食区
					</div>
					
				</div>
				
			</div>
		
		
			<!--右边主体-->
			<div class="eleven wide column">

				<!--content-->
				<div class="ui attached segment"><!--店铺列表-->
				
				
					<%for(String merchant:merchants) 
					{
						Shop shop=shopService.queryShopByName(merchant);
					%>
				
				
					<div class="ui bottom attached segment"><!--在后续店铺div后添加attached将抹去上边框-->
						<div class="ui mobile reversed stackable grid" style="height:160px"><!--mobile reversed 使之在移动端时图片和文字顺序反转-->
							<form method="post">
								<div class="m-inline-block" ><!--店铺图片-->
									<a href="#" target="_blank">
										<img src="<%=shop.getImgurl()%>" style="width:180px;height:130px" alt="" class="ui rounded image m-margin-top">
									</a>
								</div>
							
								<div class="m-inline-block m-margin-top "><!--店铺文字-->
									<h3 class="ui header m-inline-block" id="<%=shop.getId()%>" name="foodId" ><%=shop.getShopname() %></h3>
									
									<span class=" m-inline-block">&nbsp;&nbsp;&nbsp;<%=shop.getDesc()%></span>
									
				
									<p class="m-text">
										消费范围：&nbsp;$40+</br>
										配送时间：&nbsp;20min
									
									
									</p>
									
									
									
									<div class="m-inline-block right aligned ">
										<a href="takeFoodServlet?shopname=<%=shop.getShopname() %>&username=<%=username %>" target="_black" class="ui red basic label ">进入店铺</a>
									</div>
		
								</div>
								
								
							</form>
						</div>	
					</div>
					<% 
					}
					%>
								
					
				
					<!--footer-->
					<div class="ui bottom  segment">
						<div class="ui middle aligned two column grid"><!--middle垂直居中-->
							
							<div class="column"><!--第一行-->
								<a href="#" class="ui mini teal basic button">上一页</a><!--basic使薄荷绿底色效果变为薄荷绿边框加白色底色-->
							</div>
							<div class="right aligned column">
								<a href="#" class="ui mini teal basic button">下一页</a>
							</div>
							
						</div>
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