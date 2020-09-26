package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Single_order;
import dao.ISingle_orderDao;
import utils.DBUtil2;

public class Single_orderDaoImpl implements ISingle_orderDao {


	@Override
	public int getTotalCount() {
		String sql="select count(1) from sOrder";
		return DBUtil2.getTotalCount(sql);
	}

	@Override
	public boolean updateS_OrderById(String id, Single_order s_order) {
		String sql = "update sOrder set order_id=?,quantity=?,single_price=?,menu_id=? where id=?";
		Object params[]= {s_order.getOrder_id(),s_order.getQuantity(),s_order.getSingle_price(),id};
		return DBUtil2.executeUpdate(sql, params);
	}

	@Override
	public boolean deleteS_Order(String id) {
		String sql = "delete from sOrder where id=?";
		Object params[]= {id};
		return DBUtil2.executeUpdate(sql, params);
	}

	@Override
	public boolean addS_Order(Single_order s_order) {
		String sql = "insert into sOrder values(?,?,?,?,?)";
		Object params[]= {s_order.getId(),s_order.getOrder_id(),s_order.getQuantity(),s_order.getSingle_price(),s_order.getMenu_id()};
		return DBUtil2.executeUpdate(sql, params);
	}

	@Override
	public List<Single_order> queryS_Order(String order_id) {
		List<Single_order> orders = new ArrayList<>();
		Single_order s_order=null;
		ResultSet rs=null;
		try {
			String sql = "select * from sOrder where order_id=?";
			Object params[]= {order_id};
			rs=DBUtil2.queryAll(sql, params);
			while (rs.next()) {
				String id=rs.getString("id");
				String quantity=rs.getString("quantity");
				String single_price=rs.getString("single_price");
				String menu_id=rs.getString("menu_id");
				s_order = new Single_order(id,order_id,quantity,single_price,menu_id);
				orders.add(s_order);
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
			DBUtil2.closeAll(rs, DBUtil2.pstmt, DBUtil2.connection);
		}
	}
	
	@Override
	public Single_order queryS_OrderById(String id) {
		Single_order s_order=null;
		ResultSet rs=null;
		try {
			String sql = "select * from sOrder where id=?";
			Object params[]= {id};
			rs=DBUtil2.queryAll(sql, params);
			if (rs.next()) {
				String quantity=rs.getString("quantity");
				String order_id=rs.getString("order_id");
				String single_price=rs.getString("single_price");
				String menu_id=rs.getString("menu_id");
				s_order = new Single_order(id,order_id,quantity,single_price,menu_id);
			}
			return s_order;

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
	public boolean isExist(String id) {
		return queryS_OrderById(id)==null?false:true;
	}

	@Override
	public Single_order queryIdOrder(String id) {
		Single_order s_order=null;
		ResultSet rs=null;
		String sql="select *from sOrder where id=?";
		Object params[]= {id};
		rs=DBUtil2.queryAll(sql, params);
		try {
			if(rs.next())
			{
				String order_id=rs.getString("order_id");
				String quantity=rs.getString("quantity");
				String single_price=rs.getString("single_price");
				String menu_id=rs.getString("menu_id");
				s_order=new Single_order(id,order_id, quantity, single_price, menu_id);
			}
			return s_order;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			DBUtil2.closeAll(rs, DBUtil2.pstmt, DBUtil2.connection);
		}
	}

	@Override
	public boolean isExistById(String id) {
		return queryIdOrder(id)==null?false:true;
	}

	@Override
	public boolean updateS_Order(String id, String quantity, String single_price) {
		String sql = "update sOrder set quantity=?,single_price=? where id=?";
		Object params[]= {quantity,single_price,id};
		return DBUtil2.executeUpdate(sql, params);
	}

	@Override
	public boolean deleteAll() {
		String sql="delete from sOrder";
		return DBUtil2.executeUpdate(sql, null);
	}


}
