<%@page import="service.impl.IMenuServiceImpl"%>
<%@page import="service.IMenuService"%>
<%@page import="bean.Single_order"%>
<%@page import="java.util.List"%>
<%@page import="service.impl.Single_orderServiceImpl"%>
<%@page import="service.ISingle_orderService"%>
<%@page import="service.impl.OrderServiceImpl"%>
<%@page import="service.IOrderService"%>
<%@page import="bean.Order"%>
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
	Order order=(Order)request.getAttribute("order");
	String shopname=(String)request.getAttribute("shopname"); 
	IOrderService orderService=new OrderServiceImpl();
	ISingle_orderService s_OrderService=new Single_orderServiceImpl();
	IMenuService menuService=new IMenuServiceImpl();
	
	
	if(order==null)
	{
%>
		<script>
		alert("您的店铺现在没有订单哟~");
		</script>
<% 
	}
	else{
		String id=order.getId();
		List<Single_order> s_Orders=s_OrderService.queryS_Order(id);
		String menu_id;
		 for(Single_order s_order:s_Orders) 
		{
			menu_id=s_order.getMenu_id();
		%>
			 <img alt="" src="<%=menuService.queryImgById(menu_id) %>">
			 <%=menuService.queryNameById(menu_id) %>
			 数量：<%=s_order.getQuantity() %>
			 </br>
		<% 
		}
		 %>
		 
		 <hr width="100%" size="3" color="#ffcc00">
		客户姓名：<%=id %></br>
		订单详情</br>
		订单总价：<%=order.getPrice()%></br>
		</br>
		下单时间：<%=order.getOrdertime() %></br>
		
		
		
		
		<%
			String state=null;
			if(order.getState().equals("1")) 
			{
		%>	
				<a href="updateOrderServlet?shopname=<%=shopname %>">确认接单</a> 
		<% 
			}
			if(order.getState().equals("2"))
			{
		%>
				您已接单！
		<% 		
			}
	}
		%>


</body>
</html>