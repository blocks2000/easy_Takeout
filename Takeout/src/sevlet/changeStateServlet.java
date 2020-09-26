package sevlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import dao.impl.DriverDaoImpl;

/**
 * Servlet implementation class changeStateServlet
 */
@WebServlet("/changeStateServlet")
public class changeStateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DriverDaoImpl driverdao=new DriverDaoImpl();
	
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//改变订单状态为骑手已接单
		HttpSession session = request.getSession();
		String user_id=request.getParameter("user_id");
		User driver=(User)session.getAttribute("loginUser");
		driverdao.changeState("3",user_id);
		driverdao.changeDriver(user_id, driver.getUsername());
		
		request.getRequestDispatcher("showUndoOrder.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
