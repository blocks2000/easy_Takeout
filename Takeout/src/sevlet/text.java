package sevlet;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.FoodMenu;
import bean.Order;
import bean.Single_order;
import service.IMenuService;
import service.IOrderService;
import service.ISingle_orderService;
import service.impl.IMenuServiceImpl;
import service.impl.OrderServiceImpl;
import service.impl.Single_orderServiceImpl;
import utils.DBUtil2;

/**
 * Servlet implementation class text
 */
@WebServlet("/text")
public class text extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public text() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		IOrderService orderService=new OrderServiceImpl();
//		ISingle_orderService s_orderService=new Single_orderServiceImpl();
//		IMenuService menuService=new IMenuServiceImpl();
//		Order order=new Order("1","1", "15", "未发货", "1");
//		//menuService.deleteMenu("8");
//		orderService.u;
//		System.out.println("right");
//		List<Single_order> orders = new ArrayList<>();
//		Single_order s_order=null;
//		ResultSet rs=null;
//		try {
//			String sql = "select *from sOrder";
//			//Object params[]= {7};
//			rs=DBUtil2.queryAll(sql, null);
//			while (rs.next()) {
//				String id=rs.getString("id");
//				String quantity=rs.getString("quantity");
//				String single_price=rs.getString("single_price");
//				String menu_id=rs.getString("menu_id");
//				String order_id=rs.getString("order_id");
//				s_order = new Single_order(id,order_id,quantity,single_price,menu_id);
//				System.out.println(s_order);
//				orders.add(s_order);
//			}
//			 System.out.println(orders);;
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		} finally {
//			DBUtil2.closeAll(rs, DBUtil2.pstmt, DBUtil2.connection);
//		}
//		String sql = "";
//		Object params[]= {menu.getId(),menu.getName(),menu.getDes(),menu.getImgurl(),menu.getMark(),menu.getPrice(),menu.getMerchant()};
//		 DBUtil2.executeUpdate(sql, params);
//		
//	}
		
//		PreparedStatement pstmt=null;
//		List<FoodMenu> menus=new ArrayList<>();
//		FoodMenu foodMenu=null;
//		ResultSet rs=null;
//		try {
//			String sql = " select *from Menu";
//			rs=DBUtil2.queryAll(sql, null);
//			//ResultSet rs = pstmt.executeQuery();
//			while(rs.next())
//			{  
//				String id=rs.getString("id");
//				String fname=rs.getString("name");
//				String des=rs.getString("des");
//				String imgurl=rs.getString("imgurl");
//				String mark=rs.getString("mark");
//				String price=rs.getString("price");
//				foodMenu = new FoodMenu(id,fname,des,imgurl,mark,price);
//				menus.add(foodMenu);
//			}
//			System.out.println(menus); 
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			 
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		 
//		} finally {
//			DBUtil2.closeAll(rs, pstmt, DBUtil2.connection);
//		}
//	}
		String sql = "update foodOrder set id=?,ordertime=?,state=?,user_id=?";
		Object params[]= {"null","null","null","null"};
		 DBUtil2.executeUpdate(sql, params);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
