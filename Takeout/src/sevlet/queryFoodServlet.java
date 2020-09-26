package sevlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.FoodMenu;
import service.IMenuService;
import service.impl.IMenuServiceImpl;

/**
 * Servlet implementation class queryFoodServlet
 */
@WebServlet("/queryFoodServlet")
public class queryFoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public queryFoodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String username=(String)request.getAttribute("username");
		String username2=request.getParameter("username");
		String trueUsername=null;
		if(username==null)
		{
			trueUsername=username2;
		}
		else {
			trueUsername=username;
		}
		IMenuService menuService=new IMenuServiceImpl();
		List<FoodMenu>foodMenus=menuService.queryAll();
		HashSet<String>merchants=new HashSet<String>();
		for(FoodMenu foodMenu:foodMenus)
		{
			String merchant=foodMenu.getMerchant();
			merchants.add(merchant);
		}
		System.out.println(merchants);
		request.setAttribute("foodMenus", foodMenus);
		request.setAttribute("merchants", merchants);
		request.setAttribute("username", trueUsername);
		//因为request有数据，所以用请求转发来，不用session，是因为数据范围小一点比较好
		request.getRequestDispatcher("foodOrder.jsp").forward(request, response);
		//System.out.println(students);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
