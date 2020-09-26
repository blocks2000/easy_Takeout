package sevlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.IMenuService;
import service.impl.IMenuServiceImpl;

/**
 * Servlet implementation class deleteFoodServlet
 */
@WebServlet("/deleteFoodServlet")
public class deleteFoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteFoodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		IMenuService menuService=new IMenuServiceImpl();
		String merchant=menuService.queryMerById(id);
		request.setAttribute("merchant2", merchant);
		menuService.deleteMenu(id);
		request.getRequestDispatcher("queryAllMenuServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
