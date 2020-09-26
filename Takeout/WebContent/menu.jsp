<%@page import="java.util.List"%>
<%@page import="bean.FoodMenu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.container{
	float:left;
	margin-right:20px;
	margin-top:40px;
}
        img{
            width:200px;
            height:150px;
        }
        a {
        font-size:14px;
        padding:1px 1px;
        display:block;
        color:#ffffff;
        text-decoration:none;
      	}
      	.container div .change_button{
      	display:inline-block;
      	width:40px;
      	height:25px;
      	border:1px solid #CCC;
      	background:#9c9d9e;
      	margin-top:10px;
      	}
      
        .food{
        	border:none;
        	
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
	List<FoodMenu> foodMenu=(List<FoodMenu>)request.getAttribute("foodMenus");
	String shopname=(String)request.getAttribute("shopname");
%>
<ul>
	<li><a href="queryShopServlet?shopname=<%=shopname %>">查看店铺信息</a></li>
	<li><a href="#">查看店铺菜品</a></li>
</ul>

		<%for(FoodMenu foodMenu2:foodMenu) 
		{
		%>
		<div class="container">
			<form method="post">
        	<img src="<%= foodMenu2.getImgurl()%>">
        	<div id="text-desc">
	        	<input class="food" name="foodId" type="hidden" value="<%= foodMenu2.getId() %>"></input>
	        	<input class="food" name="foodName"  value="<%=foodMenu2.getName()%>"></input></br>
	        	<input class="food" name="fooddes" value="<%= foodMenu2.getDes() %>"></input></br>
        		评分：<%=foodMenu2.getMark() %>
	        	<div class="change_button">
	        	<a href="takeIdServlet?id=<%=foodMenu2.getId()%>&mark=<%=foodMenu2.getMark()%>&name=<%=foodMenu2.getName()%>&des=<%=foodMenu2.getDes()%>&price=<%=foodMenu2.getPrice()%>">修改</a>
	        	</div>
	        	<div class="change_button">
	        	<a href="deleteFoodServlet?id=<%=foodMenu2.getId()%>">删除</a>
	        	</div>
        	</div>
        	</from>
        </div>
		<% 
		}
		%>
    

</body>
</html>