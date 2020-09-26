package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.FoodMenu;
import bean.Order;
import dao.IOrderDao;
import utils.DBUtil2;

public class OrderDaoImpl implements IOrderDao {


	public int getTotalCount() {
		String sql="select count(1) from foodOrder";
		return DBUtil2.getTotalCount(sql);
	}

	@Override
	public boolean updateOrderById(String id,Order order) {
		String sql = "update foodOrder set ordertime=?,price=?,state=?,user_id=? where id=?";
		Object params[]= {order.getOrdertime(),order.getPrice(),order.getState(),order.getUser_id(),id};
		return DBUtil2.executeUpdate(sql, params);
	}

	@Override
	public boolean deleteOrder(String id) {
		String sql = "delete from foodOrder where id=?";
		Object params[]= {id};
		return DBUtil2.executeUpdate(sql, params);
	}

	@Override
	public boolean addOrder(Order order) {
		String sql = "insert into foodOrder values(?,?,?,?,?,?,?)";
		Object params[]= {order.getId(),order.getOrdertime(),order.getPrice(),order.getState(),order.getUser_id(),order.getShopname(),order.getDriver()};
		return DBUtil2.executeUpdate(sql, params);
	}

	@Override
	public List<Order> queryAll() {
		PreparedStatement pstmt=null;
		List<Order> orders=new ArrayList<>();
		Order order=null;
		ResultSet rs=null;
		try {
			String sql = " select *from foodOrder";
			rs=DBUtil2.queryAll(sql, null);
			//ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{  
				String id=rs.getString("id");
				String ordertime=rs.getString("ordertime");
				String price=rs.getString("price");
				String state=rs.getString("state");
				String user_id=rs.getString("user_id");
				String shopname=rs.getString("shopname");
				String driver=rs.getString("driver");
				order = new Order(id,ordertime,price,state,user_id,shopname,driver);
				orders.add(order);
			}
			return orders;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} finally {
			DBUtil2.closeAll(rs, pstmt, DBUtil2.connection);
		}

	}

	@Override
	public Order queryOrder(String user_id) {
		Order order = null;
		ResultSet rs=null;
		try {
			String sql = "select * from foodOrder where user_id=?";
			Object params[]= {user_id};
			rs=DBUtil2.queryAll(sql, params);
			if (rs.next()) {
				String id=rs.getString("id");
				String ordertime=rs.getString("ordertime");
				String price=rs.getString("price");
				String state=rs.getString("state");
				String user_id1=rs.getString("user_id");
				String shopname=rs.getString("shopname");
				String driver=rs.getString("driver");
				order = new Order(id,ordertime,price,state,user_id1,shopname,driver);
			}
			return order;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} finally {
			DBUtil2.closeAll(rs, DBUtil2.pstmt, DBUtil2.connection);
		}
	}
	
	
	public Order queryIdOrder(String id) {
		Order order = null;
		ResultSet rs=null;
		try {
			String sql = "select * from foodOrder where id=?";
			Object params[]= {id};
			rs=DBUtil2.queryAll(sql, params);
			if (rs.next()) {
				String id1=rs.getString("id");
				String ordertime=rs.getString("ordertime");
				String price=rs.getString("price");
				String state=rs.getString("state");
				String user_id1=rs.getString("user_id");
				String shopname=rs.getString("shopname");
				String driver=rs.getString("driver");
				order = new Order(id1,ordertime,price,state,user_id1,shopname,driver);
			}
			return order;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} finally {
			DBUtil2.closeAll(rs, DBUtil2.pstmt, DBUtil2.connection);
		}
	}

	@Override
	public boolean isExistOrder(String user_id) {
		return queryOrder("user_id")==null?false:true;
	}
	
	public boolean isExistById(String id) {
		return queryIdOrder(id)==null?false:true;
	}

	@Override
	public boolean updatePrice(String shopname, String price) {
		String sql = "update foodOrder set price=? where shopname=?";
		Object params[]= {price,shopname};
		return DBUtil2.executeUpdate(sql, params);
	}

	@Override
	public boolean deleteAll() {
		String sql="delete from foodOrder";
		return DBUtil2.executeUpdate(sql, null);
	}

	@Override
	public boolean updateExceptPri() {
		String sql = "update foodOrder set id=?,ordertime=?,state=?,user_id=?";
		Object params[]= {"null","null","null","null"};
		return DBUtil2.executeUpdate(sql, params);
	}

	@Override
	public Order queryByMerchant(String shopname) {
		PreparedStatement pstmt=null;
		Order order=null;
		ResultSet rs=null;
		try {
			String sql = " select *from foodOrder where shopname=?";
			Object params[]= {shopname};
			rs=DBUtil2.queryAll(sql,params);
			//ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{  
				String id=rs.getString("id");
				String ordertime=rs.getString("ordertime");
				String price=rs.getString("price");
				String state=rs.getString("state");
				String user_id=rs.getString("user_id");
				String driver=rs.getString("driver");
				order = new Order(id,ordertime,price,state,user_id,shopname,driver);
			}
			return order;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} finally {
			DBUtil2.closeAll(rs, pstmt, DBUtil2.connection);
		}

	}

	@Override
	public boolean isExistByShopName(String shopname) {
		// TODO Auto-generated method stub
		return queryByMerchant(shopname)==null?false:true;
	}

	@Override
	public boolean updatestate(String shopname,String state) {
		String sql = "update foodOrder set state=? where shopname=?";
		Object params[]= {state,shopname};
		return DBUtil2.executeUpdate(sql, params);
	}

}
