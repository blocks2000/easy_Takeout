package sevlet;

import java.io.IOException;
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
 * Servlet implementation class queryAllMenuServlet
 */
@WebServlet("/queryAllMenuServlet")
public class queryAllMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public queryAllMenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String shopname=request.getParameter("shopname");
		if(shopname==null)
		{
			if(request.getAttribute("merchant")!=null)
			{
				shopname=(String) request.getAttribute("merchant");
			}
			else
			{
				shopname=(String) request.getAttribute("merchant2");
			}
		}
		IMenuService menuService=new IMenuServiceImpl();
		List<FoodMenu>foodMenus=menuService.queryMenuByShopName(shopname);
		//List<FoodMenu>foodMenus=menuService.queryAll();
		request.setAttribute("foodMenus", foodMenus);
		request.setAttribute("shopname", shopname);
		//因为request有数据，所以用请求转发来，不用session，是因为数据范围小一点比较好
		request.getRequestDispatcher("menu.jsp").forward(request, response);
		//System.out.println(students);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
