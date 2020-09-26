package sevlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.IOrderService;
import service.ISingle_orderService;
import service.impl.OrderServiceImpl;
import service.impl.Single_orderServiceImpl;

/**
 * Servlet implementation class updateSqServlet
 */
@WebServlet("/updateSqServlet")
public class updateSqServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateSqServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 IOrderService orderService=new OrderServiceImpl();
		 ISingle_orderService single_orderService=new Single_orderServiceImpl();
		 single_orderService.deleteAll();
		 //orderService.updateExceptPri();
		 String username=request.getParameter("username");
		 request.getRequestDispatcher("queryFoodServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
