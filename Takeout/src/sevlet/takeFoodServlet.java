package sevlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.FoodMenu;
import bean.Shop;
import service.IMenuService;
import service.IShopService;
import service.impl.IMenuServiceImpl;
import service.impl.ShopServiceImpl;

/**
 * Servlet implementation class takeFoodServlet
 */
@WebServlet("/takeFoodServlet")
public class takeFoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public takeFoodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IMenuService menuService=new IMenuServiceImpl();
		IShopService shopService=new ShopServiceImpl();
		String shopname=request.getParameter("shopname");
		String username=request.getParameter("username");
		List<Shop> shops=shopService.queryShopByMer(shopname);
		List<FoodMenu> foodMenus=menuService.queryMenuByShopName(shopname);
		request.setAttribute("foodMenus", foodMenus);
		request.setAttribute("shops", shops);
		request.setAttribute("username", username);
		request.getRequestDispatcher("takeFood.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
