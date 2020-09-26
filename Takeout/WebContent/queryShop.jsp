<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="service.impl.IMenuServiceImpl"%>
<%@page import="service.IMenuService"%>
<%@page import="bean.Shop"%>
<%@page import="bean.FoodMenu"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	img{
	width:200px;
	height:150px;
	}
	.menu{
	float:left;
	}
	ul{
		list-style-type:none;
		margin:0;
		padding:0;
		overflow:hidden;
		background-color:#333;
	}
	li{
		float:left;
	}
	li a{
		display:block;
		color:white;
		text-align:center;
		padding:14px 16px;
		text-decoration:none;
	}
	li a:hover{
		background-color:#111;
	}
</style>
</head>
<body>
<%
	IMenuService menuService=new IMenuServiceImpl();
 	Shop shop=(Shop)request.getAttribute("shop");
 	String shopName=shop.getShopname();
 	List<FoodMenu> menus=menuService.queryMenuByShopName(shopName);
 %>
<ul>
	<li><a href="#">查看店铺信息</a></li>
	<li><a href="queryAllMenuServlet?shopname=<%=shopName%>">查看店铺菜品</a></li>
</ul>
 <h1>这是您的店铺信息</h1>
 店铺图片：<img alt="" src="<%=shop.getImgurl()%>"></br>
 店铺名：<%=shop.getShopname() %></br>
店铺描述：<%=shop.getDesc() %></br>
您的店铺有以下菜品：</br>
<hr width="100%" size="3" color="#ffcc00">
<%for(FoodMenu foodMenu2:menus) 
		{
		%>
		<div class="menu">
			<form method="post">
        	<img src="<%= foodMenu2.getImgurl()%>">
        	<div id="text-desc">
	        	<input  id="<%=foodMenu2.getId() %>" name="foodId" type="hidden" value="<%= foodMenu2.getId() %>"></input>
	        	<input class="food" name="foodName"  value="<%=foodMenu2.getName()%>"></input></br>
	        	<input class="food" name="fooddes" value="<%= foodMenu2.getDes() %>"></input></br>
	        		评分：<%=foodMenu2.getMark()%></br>
	        	价格：<input class="<%=foodMenu2.getId() %>" id="foodPrice" name="foodPrice"  value="<%=foodMenu2.getPrice()%>">
	        	</br>
        	</div>
        	</from>
      </div>
      <%
		}
      %>
<a href="addFood.jsp?shopname=<%=shopName %>&shopdes=<%=shop.getDesc()%>&shopimgurl=<%=shop.getImgurl() %>">继续添加菜品</a>
</body>
</html>