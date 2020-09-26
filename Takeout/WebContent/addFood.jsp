<%@page import="bean.Shop"%>
<%@page import="java.util.List"%>
<%@page import="service.impl.ShopServiceImpl"%>
<%@page import="service.IShopService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
img{
	width:200px;
}
</style>
</head>
<body>
<%
String shopName=(String) request.getAttribute("shopName");
String desc=(String) request.getAttribute("desc");
String imgurl=(String) request.getAttribute("imgurl");
String shopname=request.getParameter("shopname");
String desc2=request.getParameter("shopdes");
String imgurl2=request.getParameter("shopimgurl");
request.setAttribute("shopName", shopName);
request.setAttribute("desc", desc);
request.setAttribute("imgurl", imgurl);
IShopService shopService=new ShopServiceImpl();
%>
 <h1>菜品信息</h1>
    <form method="post"  action="addMenuServlet" enctype="multipart/form-data"> 
<%
	if(shopname!=null)
	{
%>
		<p>		   
        <lable for="name"> 店铺图片：</label>		 
        <img src="<%=imgurl2%>"></img>
        <input type="text" name="shopImg" id="name" value="<%=imgurl2 %>" ></p>        		
    <p>
	<p>		   
        <lable for="name"> 店铺名称：</label>		      
        <input type="text" name="shopName" id="name" value="<%=shopname%>" readonly="readonly"></p>        		
    <p>  
    <p>		   
        <lable for="name"> 店铺描述：</label>		      
        <input type="text" name="shopDes" id="name" value="<%=desc2 %>" readonly="readonly" ></p>        		
    <p>  
 <% 
	}
	else
	{
%>
	<p>		   
            <lable for="name"> 店铺图片：</label>		 
            <img src="<%=imgurl%>"></img>
            <input type="text" name="shopImg" id="name" value="<%=imgurl %>" ></p>        		
        <p>
    	<p>		   
            <lable for="name"> 店铺名称：</label>		      
            <input type="text" name="shopName" id="name" value="<%=shopName%>" readonly="readonly"></p>        		
        <p>  
        <p>		   
            <lable for="name"> 店铺描述：</label>		      
            <input type="text" name="shopDes" id="name" value="<%=desc %>" readonly="readonly" ></p>        		
        <p>   
<% 
	}
%> 
        <p>		   
            <lable for="name"> 菜品名称：</label>		      
            <input type="text" name="foodName" id="name"  ></p>        		
        <p>		  
            <lable for="introduce"> 菜品描述：</label>		  
            <textarea name="commet"rows=5 cols=60  id="introduce"></textarea>
        </p>	
     		 价格：<input name="price" ></input>
        <p>	图片<input type="file" name="filename" id="selectFiles"   ></p>	
        <p>  
            <input type="submit"value="提交">          
            <input type="reset"value="清空">
        </p>     
    </form>
</body>
</html>