package sevlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Shop;
import service.IShopService;
import service.impl.ShopServiceImpl;

/**
 * Servlet implementation class queryShopServlet
 */
@WebServlet("/queryShopServlet")
public class queryShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public queryShopServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IShopService shopService=new ShopServiceImpl();
		//String shopname=request.getParameter("shopname");
		String shopname=(String)request.getAttribute("username");
		String shopname2=request.getParameter("shopname");
		String trueShopName=null;
		if(shopname==null) trueShopName=shopname2;
		else trueShopName=shopname;
		List<Shop> shops=shopService.queryShopByMer(trueShopName);
		Shop shop=shops.get(0);
		request.setAttribute("shop", shop);
		request.getRequestDispatcher("showShop.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
