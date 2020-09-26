package sevlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Order;
import service.IOrderService;
import service.impl.OrderServiceImpl;

/**
 * Servlet implementation class queryMerchantServlet
 */
@WebServlet("/queryMerchantServlet")
public class queryMerchantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public queryMerchantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		IOrderService orderService=new OrderServiceImpl();
		String shopname=request.getParameter("shopname");
		String shopname2=(String)request.getAttribute("shopname");
		String trueshopname=null;
		if(shopname==null)
		{
			trueshopname=shopname2;
		}
		else {
			trueshopname=shopname;
		}
		Order order=orderService.queryByMerchant(trueshopname);
		request.setAttribute("order", order);
		request.setAttribute("shopname", trueshopname);
		request.getRequestDispatcher("showMerchantOrder.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
