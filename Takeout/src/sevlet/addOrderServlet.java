package sevlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Order;
import bean.Single_order;
import service.IMenuService;
import service.IOrderService;
import service.ISingle_orderService;
import service.impl.IMenuServiceImpl;
import service.impl.OrderServiceImpl;
import service.impl.Single_orderServiceImpl;

/**
 * Servlet implementation class addOrderServlet
 */
@WebServlet("/addOrderServlet")
public class addOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public addOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		IOrderService orderService=new OrderServiceImpl();
		ISingle_orderService s_orderService=new Single_orderServiceImpl();
		IMenuService menuService=new IMenuServiceImpl();
		Order order=null;
		Single_order s_order=null;
		
		
		String foodId=(String)request.getAttribute("foodId");
		String foodPrice=(String)request.getAttribute("foodPrice");
		String time=(String)request.getAttribute("time");
		String count=(String)request.getAttribute("count");
		String username=(String)request.getAttribute("username");
		String shopname=(String)request.getAttribute("shopname");
		
		
		int sCount=Integer.parseInt(count)+1;
		System.out.println(sCount);
		String ssCount=Integer.toString(sCount);
		String s_price=menuService.queryPriceById(foodId);
		int sprice=Integer.parseInt(s_price);
		System.out.println(sprice);
		int sTotalPrice=sprice*sCount;
		System.out.println(sTotalPrice);
		String TPrice=Integer.toString(sTotalPrice);
		
		if(orderService.isExistByShopName(shopname))
		{
			orderService.updatePrice(shopname, foodPrice);
		}
		else
		{
			order=new Order(username,time, foodPrice, "1", username,shopname,null);
			orderService.addOrder(order);
		}
		
		if(s_orderService.isExist(foodId))
		{
			s_orderService.updateS_Order(foodId, ssCount, TPrice);
		}
		else
		{
			s_order=new Single_order(foodId,username, ssCount, TPrice, foodId);
			s_orderService.addS_Order(s_order);
		}
		//Order u_Order=orderService.queryOrder("7");
		//List<Single_order> s_orders=s_orderService.queryS_Order("7");
		
//		request.setAttribute("u_Order", u_Order);
//		request.setAttribute("s_orders", s_orders);
//		request.getRequestDispatcher("ShowOrder.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
