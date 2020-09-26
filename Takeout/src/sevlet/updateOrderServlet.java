package sevlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.IOrderService;
import service.impl.OrderServiceImpl;

/**
 * Servlet implementation class updateOrderServlet
 */
@WebServlet("/updateOrderServlet")
public class updateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String shopname=request.getParameter("shopname");
		IOrderService orderService=new OrderServiceImpl();
		orderService.updatestate(shopname, "2");
		request.setAttribute("shopname3", shopname);
		request.getRequestDispatcher("queryMerchantServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
